/*
 * GovWay - A customizable API Gateway 
 * http://www.govway.org
 *
 * from the Link.it OpenSPCoop project codebase
 * 
 * Copyright (c) 2005-2018 Link.it srl (http://link.it). 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3, as published by
 * the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.openspcoop2.web.ctrlstat.servlet.pa;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.openspcoop2.core.commons.Liste;
import org.openspcoop2.core.config.PortaApplicativa;
import org.openspcoop2.core.config.TrasformazioneRegola;
import org.openspcoop2.core.config.TrasformazioneRegolaParametro;
import org.openspcoop2.core.config.Trasformazioni;
import org.openspcoop2.core.config.constants.TrasformazioneRegolaParametroTipoAzione;
import org.openspcoop2.web.ctrlstat.core.ControlStationCore;
import org.openspcoop2.web.ctrlstat.core.Search;
import org.openspcoop2.web.ctrlstat.servlet.GeneralHelper;
import org.openspcoop2.web.lib.mvc.DataElement;
import org.openspcoop2.web.lib.mvc.ForwardParams;
import org.openspcoop2.web.lib.mvc.GeneralData;
import org.openspcoop2.web.lib.mvc.PageData;
import org.openspcoop2.web.lib.mvc.Parameter;
import org.openspcoop2.web.lib.mvc.ServletUtils;
import org.openspcoop2.web.lib.mvc.TipoOperazione;

/**
 * PorteApplicativeTrasformazioniRichiestaHeaderChange
 * 
 * @author Giuliano Pintori (pintori@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 * 
 */
public class PorteApplicativeTrasformazioniRichiestaHeaderChange extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(true);

		// Inizializzo PageData
		PageData pd = new PageData();

		GeneralHelper generalHelper = new GeneralHelper(session);
		
		String userLogin = ServletUtils.getUserLoginFromSession(session);

		// Inizializzo GeneralData
		GeneralData gd = generalHelper.initGeneralData(request);
		
		Integer parentPA = ServletUtils.getIntegerAttributeFromSession(PorteApplicativeCostanti.ATTRIBUTO_PORTE_APPLICATIVE_PARENT, session);
		if(parentPA == null) parentPA = PorteApplicativeCostanti.ATTRIBUTO_PORTE_APPLICATIVE_PARENT_NONE;

		try {
			
			PorteApplicativeHelper porteApplicativeHelper = new PorteApplicativeHelper(request, pd, session);
			String idPorta = porteApplicativeHelper.getParameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID);
			int idInt = Integer.parseInt(idPorta);
			String idsogg = porteApplicativeHelper.getParameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID_SOGGETTO);
			String idAsps = porteApplicativeHelper.getParameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID_ASPS);
			if(idAsps == null) 
				idAsps = "";
			
			String idTrasformazioneS = porteApplicativeHelper.getParameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID_TRASFORMAZIONE);
			long idTrasformazione = Long.parseLong(idTrasformazioneS);
			
			String idTrasformazioneRichiestaHeaderS = porteApplicativeHelper.getParameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID_TRASFORMAZIONE_RICHIESTA_HEADER);
			long idTrasformazioneRichiestaHeader = Long.parseLong(idTrasformazioneRichiestaHeaderS);
			
			String tipo = porteApplicativeHelper.getParameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_TRASFORMAZIONI_RICHIESTA_HEADER_TIPO);
			String nome = porteApplicativeHelper.getParameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_TRASFORMAZIONI_RICHIESTA_HEADER_NOME);
			String valore = porteApplicativeHelper.getParameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_TRASFORMAZIONI_RICHIESTA_HEADER_VALORE);

			PorteApplicativeCore porteApplicativeCore = new PorteApplicativeCore();
			// Preparo il menu
			porteApplicativeHelper.makeMenu();

			// Prendo nome della porta applicativa
			PortaApplicativa pa = porteApplicativeCore.getPortaApplicativa(idInt);
			String nomePorta = pa.getNome();
			
			Trasformazioni trasformazioni = pa.getTrasformazioni();
			TrasformazioneRegola oldRegola = null;
			TrasformazioneRegolaParametro oldParametro = null;
			for (TrasformazioneRegola reg : trasformazioni.getRegolaList()) {
				if(reg.getId().longValue() == idTrasformazione) {
					oldRegola = reg;
					break;
				}
			}

			for (int j = 0; j < oldRegola.getRichiesta().sizeHeaderList(); j++) {
				TrasformazioneRegolaParametro parametro = oldRegola.getRichiesta().getHeader(j);
				if (parametro.getId().longValue() == idTrasformazioneRichiestaHeader) {
					oldParametro = parametro;
					break;
				}
			}
			
			String nomeTrasformazione = oldRegola.getNome();
			String nomeParametro = oldParametro.getNome();
			Parameter pIdTrasformazione = new Parameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID_TRASFORMAZIONE, idTrasformazione+"");
			
			List<Parameter> lstParam = porteApplicativeHelper.getTitoloPA(parentPA, idsogg, idAsps);

			String labelPerPorta = null;
			if(parentPA!=null && (parentPA.intValue() == PorteApplicativeCostanti.ATTRIBUTO_PORTE_APPLICATIVE_PARENT_CONFIGURAZIONE)) {
				labelPerPorta = porteApplicativeCore.getLabelRegolaMappingErogazionePortaApplicativa(
						PorteApplicativeCostanti.LABEL_PARAMETRO_PORTE_APPLICATIVE_TRASFORMAZIONI_DI,
						PorteApplicativeCostanti.LABEL_PARAMETRO_PORTE_APPLICATIVE_TRASFORMAZIONI,
						pa);
			}
			else {
				labelPerPorta = PorteApplicativeCostanti.LABEL_PARAMETRO_PORTE_APPLICATIVE_TRASFORMAZIONI_DI+nomePorta;
			}

			lstParam.add(new Parameter(labelPerPorta,
					PorteApplicativeCostanti.SERVLET_NAME_PORTE_APPLICATIVE_TRASFORMAZIONI_LIST,
					new Parameter( PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID, idPorta),
					new Parameter( PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID_SOGGETTO, idsogg),
					new Parameter( PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID_ASPS, idAsps)
					));
			
			lstParam.add(new Parameter(nomeTrasformazione, PorteApplicativeCostanti.SERVLET_NAME_PORTE_APPLICATIVE_TRASFORMAZIONI_CHANGE, 
					new Parameter( PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID, idPorta),
					new Parameter( PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID_SOGGETTO, idsogg),
					new Parameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID_ASPS, idAsps), pIdTrasformazione));
			
			List<Parameter> parametriInvocazioneServletTrasformazioniRichiesta = new ArrayList<Parameter>();
			parametriInvocazioneServletTrasformazioniRichiesta.add(new Parameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID, idPorta));
			parametriInvocazioneServletTrasformazioniRichiesta.add(new Parameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID_SOGGETTO, idsogg));
			parametriInvocazioneServletTrasformazioniRichiesta.add(new Parameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID_ASPS, idAsps));
			parametriInvocazioneServletTrasformazioniRichiesta.add(pIdTrasformazione);
			
			lstParam.add(new Parameter(PorteApplicativeCostanti.LABEL_PARAMETRO_PORTE_APPLICATIVE_TRASFORMAZIONI_RICHIESTA,
					PorteApplicativeCostanti.SERVLET_NAME_PORTE_APPLICATIVE_TRASFORMAZIONI_RICHIESTA,parametriInvocazioneServletTrasformazioniRichiesta));
						
			List<Parameter> parametriInvocazioneServletTrasformazioniRichiestaHeaders = new ArrayList<Parameter>();
			parametriInvocazioneServletTrasformazioniRichiestaHeaders.add(new Parameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID, idPorta));
			parametriInvocazioneServletTrasformazioniRichiestaHeaders.add(new Parameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID_SOGGETTO, idsogg));
			parametriInvocazioneServletTrasformazioniRichiestaHeaders.add(new Parameter(PorteApplicativeCostanti.PARAMETRO_PORTE_APPLICATIVE_ID_ASPS, idAsps));
			parametriInvocazioneServletTrasformazioniRichiestaHeaders.add(pIdTrasformazione);
			
			lstParam.add(new Parameter(PorteApplicativeCostanti.LABEL_PARAMETRO_PORTE_APPLICATIVE_TRASFORMAZIONI_RICHIESTA_HEADERS,
					PorteApplicativeCostanti.SERVLET_NAME_PORTE_APPLICATIVE_TRASFORMAZIONI_RICHIESTA_HEADER_LIST,parametriInvocazioneServletTrasformazioniRichiestaHeaders ));
			
			lstParam.add(new Parameter(nomeParametro, null));

			ServletUtils.setPageDataTitle(pd, lstParam);
			
			// Se nomehid = null, devo visualizzare la pagina per l'inserimento
			// dati
			if (porteApplicativeHelper.isEditModeInProgress()) {
				// preparo i campi
				Vector<DataElement> dati = new Vector<DataElement>();
				dati.addElement(ServletUtils.getDataElementForEditModeFinished());
				
				// primo accesso
				if(nome == null) {
					nome = oldParametro.getNome();
					tipo = oldParametro.getConversioneTipo().getValue();
					valore = oldParametro.getValore();
				}

				dati = porteApplicativeHelper.addTrasformazioneRichiestaHeaderToDati(TipoOperazione.CHANGE, dati, idTrasformazioneS, idTrasformazioneRichiestaHeaderS, nome, tipo, valore);
				
				dati = porteApplicativeHelper.addHiddenFieldsToDati(TipoOperazione.CHANGE, idPorta, idsogg, idPorta,idAsps,  dati);
				
				pd.setDati(dati);

				ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

				return ServletUtils.getStrutsForwardEditModeInProgress(mapping, PorteApplicativeCostanti.OBJECT_NAME_PORTE_APPLICATIVE_TRASFORMAZIONI_RICHIESTA_HEADER,	ForwardParams.CHANGE());
			}
			
			boolean isOk = porteApplicativeHelper.trasformazioniRichiestaHeaderCheckData(TipoOperazione.CHANGE);
			if (!isOk) {

				// preparo i campi
				Vector<DataElement> dati = new Vector<DataElement>();

				dati.addElement(ServletUtils.getDataElementForEditModeFinished());
				
				dati = porteApplicativeHelper.addTrasformazioneRichiestaHeaderToDati(TipoOperazione.CHANGE, dati, idTrasformazioneS, idTrasformazioneRichiestaHeaderS, nome, tipo, valore);
				
				dati = porteApplicativeHelper.addHiddenFieldsToDati(TipoOperazione.CHANGE, idPorta, idsogg, idPorta,idAsps,  dati);
				
				pd.setDati(dati);

				ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

				return ServletUtils.getStrutsForwardEditModeCheckError(mapping, PorteApplicativeCostanti.OBJECT_NAME_PORTE_APPLICATIVE_TRASFORMAZIONI_RICHIESTA_HEADER,	ForwardParams.CHANGE());
			}
			
			// aggiorno la regola
			TrasformazioneRegola regola = null;
			for (TrasformazioneRegola reg : trasformazioni.getRegolaList()) {
				if(reg.getId().longValue() == idTrasformazione) {
					regola = reg;
					break;
				}
			}
			
			TrasformazioneRegolaParametro parametroDaAggiornare = null;
			for (int j = 0; j < regola.getRichiesta().sizeHeaderList(); j++) {
				TrasformazioneRegolaParametro parametro = regola.getRichiesta().getHeader(j);
				if (parametro.getId().longValue() == idTrasformazioneRichiestaHeader) {
					parametroDaAggiornare = parametro;
					break;
				}
			}
			
			parametroDaAggiornare.setNome(nome);
			parametroDaAggiornare.setValore(valore);
			parametroDaAggiornare.setConversioneTipo(TrasformazioneRegolaParametroTipoAzione.toEnumConstant(tipo));
			
			porteApplicativeCore.performUpdateOperation(userLogin, porteApplicativeHelper.smista(), pa);
			
			// ricaricare id trasformazione
			pa = porteApplicativeCore.getPortaApplicativa(Long.parseLong(idPorta));

			String patternDBCheck = (regola.getApplicabilita() != null && StringUtils.isNotEmpty(regola.getApplicabilita().getPattern())) ? regola.getApplicabilita().getPattern() : null;
			String contentTypeAsString = (regola.getApplicabilita() != null &&regola.getApplicabilita().getContentTypeList() != null) ? StringUtils.join(regola.getApplicabilita().getContentTypeList(), ",") : "";
			String contentTypeDBCheck = StringUtils.isNotEmpty(contentTypeAsString) ? contentTypeAsString : null;
			String azioniAsString = (regola.getApplicabilita() != null && regola.getApplicabilita().getAzioneList() != null) ? StringUtils.join(regola.getApplicabilita().getAzioneList(), ",") : "";
			String azioniDBCheck = StringUtils.isNotEmpty(azioniAsString) ? azioniAsString : null;
			TrasformazioneRegola trasformazioneAggiornata = porteApplicativeCore.getTrasformazione(pa.getId(), azioniDBCheck, patternDBCheck, contentTypeDBCheck);
			
			// Preparo la lista
			Search ricerca = (Search) ServletUtils.getSearchObjectFromSession(session, Search.class);
			
			int idLista = Liste.PORTE_APPLICATIVE_TRASFORMAZIONI_RICHIESTA_HEADER; 
			
			ricerca = porteApplicativeHelper.checkSearchParameters(idLista, ricerca);
			
			List<TrasformazioneRegolaParametro> lista = porteApplicativeCore.porteAppTrasformazioniRichiestaHeaderList(Long.parseLong(idPorta), trasformazioneAggiornata.getId(), ricerca);
			
			porteApplicativeHelper.preparePorteAppTrasformazioniRichiestaHeaderList(nomePorta, trasformazioneAggiornata.getId(), ricerca, lista); 
						
			ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);
			
			// Forward control to the specified success URI
			return ServletUtils.getStrutsForwardEditModeFinished(mapping, PorteApplicativeCostanti.OBJECT_NAME_PORTE_APPLICATIVE_TRASFORMAZIONI_RICHIESTA_HEADER,	ForwardParams.CHANGE());
		} catch (Exception e) {
			return ServletUtils.getStrutsForwardError(ControlStationCore.getLog(), e, pd, session, gd, mapping, 
					PorteApplicativeCostanti.OBJECT_NAME_PORTE_APPLICATIVE_TRASFORMAZIONI_RICHIESTA_HEADER, 
					ForwardParams.CHANGE());
		}
	}
}