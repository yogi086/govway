/*
 * OpenSPCoop - Customizable API Gateway 
 * http://www.openspcoop2.org
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
package org.openspcoop2.web.ctrlstat.servlet.pd;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.openspcoop2.core.config.AutorizzazioneRuoli;
import org.openspcoop2.core.config.PortaDelegata;
import org.openspcoop2.core.config.constants.RuoloTipoMatch;
import org.openspcoop2.core.config.constants.StatoFunzionalita;
import org.openspcoop2.core.config.constants.TipoAutenticazione;
import org.openspcoop2.core.config.constants.TipoAutorizzazione;
import org.openspcoop2.core.registry.constants.RuoloTipologia;
import org.openspcoop2.web.ctrlstat.core.AutorizzazioneUtilities;
import org.openspcoop2.web.ctrlstat.core.ControlStationCore;
import org.openspcoop2.web.ctrlstat.costanti.CostantiControlStation;
import org.openspcoop2.web.ctrlstat.servlet.GeneralHelper;
import org.openspcoop2.web.lib.mvc.Costanti;
import org.openspcoop2.web.lib.mvc.DataElement;
import org.openspcoop2.web.lib.mvc.ForwardParams;
import org.openspcoop2.web.lib.mvc.GeneralData;
import org.openspcoop2.web.lib.mvc.PageData;
import org.openspcoop2.web.lib.mvc.Parameter;
import org.openspcoop2.web.lib.mvc.ServletUtils;
import org.openspcoop2.web.lib.mvc.TipoOperazione;

/***
 * 
 * PorteDelegateControlloAccessi
 * 
 * @author Giuliano Pintori (pintori@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class PorteDelegateControlloAccessi extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(true);

		// Inizializzo PageData
		PageData pd = new PageData();

		GeneralHelper generalHelper = new GeneralHelper(session);

		// Inizializzo GeneralData
		GeneralData gd = generalHelper.initGeneralData(request);
		
		boolean isPortaDelegata = true;

		// prelevo il flag che mi dice da quale pagina ho acceduto la sezione delle porte delegate
		Integer parentPD = ServletUtils.getIntegerAttributeFromSession(PorteDelegateCostanti.ATTRIBUTO_PORTE_DELEGATE_PARENT, session);
		if(parentPD == null) parentPD = PorteDelegateCostanti.ATTRIBUTO_PORTE_DELEGATE_PARENT_NONE;

		try {
			Boolean contaListe = ServletUtils.getContaListeFromSession(session);
			Boolean confPers = (Boolean) session.getAttribute(CostantiControlStation.SESSION_PARAMETRO_GESTIONE_CONFIGURAZIONI_PERSONALIZZATE);

			PorteDelegateHelper porteDelegateHelper = new PorteDelegateHelper(request, pd, session);
			String id = request.getParameter(PorteDelegateCostanti.PARAMETRO_PORTE_DELEGATE_ID);
			int idInt = Integer.parseInt(id);
			String idSoggFruitore = request.getParameter(PorteDelegateCostanti.PARAMETRO_PORTE_DELEGATE_ID_SOGGETTO);
			String idAsps = request.getParameter(PorteDelegateCostanti.PARAMETRO_PORTE_DELEGATE_ID_ASPS);
			if(idAsps == null) 
				idAsps = "";
			String idFruizione= request.getParameter(PorteDelegateCostanti.PARAMETRO_PORTE_DELEGATE_ID_FRUIZIONE);
			if(idFruizione == null) 
				idFruizione = "";
			
			String autenticazione = request.getParameter(CostantiControlStation.PARAMETRO_PORTE_AUTENTICAZIONE );
			String autenticazioneOpzionale = request.getParameter(CostantiControlStation.PARAMETRO_PORTE_AUTENTICAZIONE_OPZIONALE );
			String autenticazioneCustom = request.getParameter(CostantiControlStation.PARAMETRO_PORTE_AUTENTICAZIONE_CUSTOM );
			String autorizzazione = request.getParameter(CostantiControlStation.PARAMETRO_PORTE_AUTORIZZAZIONE);
			String autorizzazioneCustom = request.getParameter(CostantiControlStation.PARAMETRO_PORTE_AUTORIZZAZIONE_CUSTOM);
			
			String autorizzazioneAutenticati = request.getParameter(CostantiControlStation.PARAMETRO_PORTE_AUTORIZZAZIONE_AUTENTICAZIONE);
			String autorizzazioneRuoli = request.getParameter(CostantiControlStation.PARAMETRO_PORTE_AUTORIZZAZIONE_RUOLI);
			String autorizzazioneRuoliTipologia = request.getParameter(CostantiControlStation.PARAMETRO_RUOLO_TIPOLOGIA);
			String ruoloMatch = request.getParameter(CostantiControlStation.PARAMETRO_RUOLO_MATCH);
			
			String autorizzazioneContenuti = request.getParameter(PorteDelegateCostanti.PARAMETRO_PORTE_DELEGATE_AUTORIZZAZIONE_CONTENUTI);

			String applicaModificaS = request.getParameter(PorteDelegateCostanti.PARAMETRO_PORTE_DELEGATE_APPLICA_MODIFICA);
			boolean applicaModifica = ServletUtils.isCheckBoxEnabled(applicaModificaS);

			
			// Preparo il menu
			porteDelegateHelper.makeMenu();

			// Prendo il nome della porta
			PorteDelegateCore porteDelegateCore = new PorteDelegateCore();

			PortaDelegata portaDelegata = porteDelegateCore.getPortaDelegata(idInt);
			String idporta = portaDelegata.getNome();
			
			List<String> ruoli = new ArrayList<>();
			if(portaDelegata!=null && portaDelegata.getRuoli()!=null && portaDelegata.getRuoli().sizeRuoloList()>0){
				for (int i = 0; i < portaDelegata.getRuoli().sizeRuoloList(); i++) {
					ruoli.add(portaDelegata.getRuoli().getRuolo(i).getNome());
				}
			}
			
			int numRuoli = 0;
			if(portaDelegata.getRuoli()!=null){
				numRuoli = portaDelegata.getRuoli().sizeRuoloList();
			}
			
			int sizeFruitori = 0; 
			if(portaDelegata.getServizioApplicativoList() !=null){
				sizeFruitori = portaDelegata.sizeServizioApplicativoList();
			}

			boolean isSupportatoAutenticazione = true; // sempre nelle porte delegate
			
			List<Parameter> lstParam = porteDelegateHelper.getTitoloPD(parentPD, idSoggFruitore, idAsps, idFruizione);
			
			lstParam.add(new Parameter(PorteDelegateCostanti.LABEL_PARAMETRO_PORTE_DELEGATE_CONTROLLO_ACCESSI_DI + idporta,  null));
			
			// setto la barra del titolo
			ServletUtils.setPageDataTitle(pd, lstParam);
			
			Parameter pId = new Parameter(PorteDelegateCostanti.PARAMETRO_PORTE_DELEGATE_ID, id);
			Parameter pIdSoggetto = new Parameter(PorteDelegateCostanti.PARAMETRO_PORTE_DELEGATE_ID_SOGGETTO, idSoggFruitore);
			Parameter pIdAsps = new Parameter(PorteDelegateCostanti.PARAMETRO_PORTE_DELEGATE_ID_ASPS, idAsps);
			Parameter pIdFrizione = new Parameter(PorteDelegateCostanti.PARAMETRO_PORTE_DELEGATE_ID_FRUIZIONE, idFruizione);

			Parameter[] urlParmsAutorizzazioneAutenticati = {  pId,pIdSoggetto,pIdAsps,pIdFrizione  };
			Parameter urlAutorizzazioneAutenticatiParam= new Parameter("", PorteDelegateCostanti.SERVLET_NAME_PORTE_DELEGATE_SERVIZIO_APPLICATIVO_LIST , urlParmsAutorizzazioneAutenticati);
			String urlAutorizzazioneAutenticati = urlAutorizzazioneAutenticatiParam.getValue();
			
			Parameter[] urlParmsAutorizzazioneRuoli = {  pId,pIdSoggetto,pIdAsps,pIdFrizione };
			Parameter urlAutorizzazioneRuoliParam = new Parameter("", PorteDelegateCostanti.SERVLET_NAME_PORTE_DELEGATE_RUOLI_LIST , urlParmsAutorizzazioneRuoli);
			String urlAutorizzazioneRuoli = urlAutorizzazioneRuoliParam.getValue();
			
			String servletChiamante = PorteDelegateCostanti.SERVLET_NAME_PORTE_DELEGATE_CONTROLLO_ACCESSI;
			
			if(	ServletUtils.isEditModeInProgress(request) && !applicaModifica){

				if (autenticazione == null) {
					autenticazione = portaDelegata.getAutenticazione();
					if (autenticazione != null &&
							!TipoAutenticazione.getValues().contains(autenticazione)) {
						autenticazioneCustom = autenticazione;
						autenticazione = CostantiControlStation.DEFAULT_VALUE_PARAMETRO_PORTE_AUTENTICAZIONE_CUSTOM;
					}
				}
				if(autenticazioneOpzionale==null){
					autenticazioneOpzionale = "";
					if(portaDelegata.getAutenticazioneOpzionale()!=null){
						if (portaDelegata.getAutenticazioneOpzionale().equals(StatoFunzionalita.ABILITATO)) {
							autenticazioneOpzionale = Costanti.CHECK_BOX_ENABLED;
						}
					}
				}
				if (autorizzazione == null) {
					if (portaDelegata.getAutorizzazione() != null &&
							!TipoAutorizzazione.getAllValues().contains(portaDelegata.getAutorizzazione())) {
						autorizzazioneCustom = portaDelegata.getAutorizzazione();
						autorizzazione = CostantiControlStation.DEFAULT_VALUE_PARAMETRO_PORTE_AUTORIZZAZIONE_CUSTOM;
					}
					else{
						autorizzazione = AutorizzazioneUtilities.convertToStato(portaDelegata.getAutorizzazione());
						if(TipoAutorizzazione.isAuthenticationRequired(portaDelegata.getAutorizzazione()))
							autorizzazioneAutenticati = Costanti.CHECK_BOX_ENABLED;
						if(TipoAutorizzazione.isRolesRequired(portaDelegata.getAutorizzazione()))
							autorizzazioneRuoli = Costanti.CHECK_BOX_ENABLED;
						autorizzazioneRuoliTipologia = AutorizzazioneUtilities.convertToRuoloTipologia(portaDelegata.getAutorizzazione()).getValue();
					}
				}
				
				if (ruoloMatch == null) {
					if(portaDelegata.getRuoli()!=null && portaDelegata.getRuoli().getMatch()!=null){
						ruoloMatch = portaDelegata.getRuoli().getMatch().getValue();
					}
				}
				
				if(autorizzazioneContenuti==null){
					autorizzazioneContenuti = portaDelegata.getAutorizzazioneContenuto();
				}

				// preparo i campi
				Vector<DataElement> dati = new Vector<DataElement>();
				dati.addElement(ServletUtils.getDataElementForEditModeFinished());

				porteDelegateHelper.controlloAccessiAutenticazione(dati, autenticazione, autenticazioneCustom, autenticazioneOpzionale, confPers, isSupportatoAutenticazione);

				// Tipo operazione = CHANGE per evitare di aggiungere if, questa e' a tutti gli effetti una servlet di CHANGE
				porteDelegateHelper.controlloAccessiAutorizzazione(dati, TipoOperazione.CHANGE, servletChiamante,
						autenticazione, autorizzazione, autorizzazioneCustom, 
						autorizzazioneAutenticati, urlAutorizzazioneAutenticati, sizeFruitori, null, null,
						autorizzazioneRuoli,  urlAutorizzazioneRuoli, numRuoli, null, 
						autorizzazioneRuoliTipologia, ruoloMatch,
						confPers, isSupportatoAutenticazione, contaListe, isPortaDelegata, false);
				
				porteDelegateHelper.controlloAccessiAutorizzazioneContenuti(dati, autorizzazioneContenuti);
				
				dati = porteDelegateHelper.addHiddenFieldsToDati(TipoOperazione.OTHER,id, idSoggFruitore, null,idAsps, idFruizione, dati);

				pd.setDati(dati);

				ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

				return ServletUtils.getStrutsForwardEditModeInProgress(mapping,
						PorteDelegateCostanti.OBJECT_NAME_PORTE_DELEGATE_CONTROLLO_ACCESSI, ForwardParams.OTHER(""));
			}

			// Controlli sui campi immessi
			boolean isOk = porteDelegateHelper.controlloAccessiCheck(TipoOperazione.OTHER, autenticazioneCustom, autenticazioneOpzionale, autorizzazioneContenuti, 
					autorizzazioneAutenticati, autorizzazioneRuoli, autorizzazioneRuoliTipologia, ruoloMatch, isSupportatoAutenticazione, isPortaDelegata, ruoli);
					
			if (!isOk) {
				// preparo i campi
				Vector<DataElement> dati = new Vector<DataElement>();

				dati.addElement(ServletUtils.getDataElementForEditModeFinished());
				
				porteDelegateHelper.controlloAccessiAutenticazione(dati, autenticazione, autenticazioneCustom, autenticazioneOpzionale, confPers, isSupportatoAutenticazione);

				// Tipo operazione = CHANGE per evitare di aggiungere if, questa e' a tutti gli effetti una servlet di CHANGE
				porteDelegateHelper.controlloAccessiAutorizzazione(dati, TipoOperazione.CHANGE, servletChiamante,
						autenticazione, autorizzazione, autorizzazioneCustom, 
						autorizzazioneAutenticati, urlAutorizzazioneAutenticati, sizeFruitori, null, null,
						autorizzazioneRuoli,  urlAutorizzazioneRuoli, numRuoli, null, 
						autorizzazioneRuoliTipologia, ruoloMatch,
						confPers, isSupportatoAutenticazione, contaListe, isPortaDelegata, false);
				
				porteDelegateHelper.controlloAccessiAutorizzazioneContenuti(dati, autorizzazioneContenuti);
				
				dati = porteDelegateHelper.addHiddenFieldsToDati(TipoOperazione.OTHER,id, idSoggFruitore, null,idAsps, idFruizione, dati);

				pd.setDati(dati);

				ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

				return ServletUtils.getStrutsForwardEditModeCheckError(mapping,
						PorteDelegateCostanti.OBJECT_NAME_PORTE_DELEGATE_CONTROLLO_ACCESSI,
						ForwardParams.OTHER(""));
			}

			
			if (autenticazione == null || !autenticazione.equals(CostantiControlStation.DEFAULT_VALUE_PARAMETRO_PORTE_AUTENTICAZIONE_CUSTOM))
				portaDelegata.setAutenticazione(autenticazione);
			else
				portaDelegata.setAutenticazione(autenticazioneCustom);
			if(autenticazioneOpzionale != null){
				if(ServletUtils.isCheckBoxEnabled(autenticazioneOpzionale))
					portaDelegata.setAutenticazioneOpzionale(StatoFunzionalita.ABILITATO);
				else 
					portaDelegata.setAutenticazioneOpzionale(StatoFunzionalita.DISABILITATO);
			} else 
				portaDelegata.setAutenticazioneOpzionale(null);
			if (autorizzazione == null || !autorizzazione.equals(CostantiControlStation.DEFAULT_VALUE_PARAMETRO_PORTE_AUTORIZZAZIONE_CUSTOM))
				portaDelegata.setAutorizzazione(AutorizzazioneUtilities.convertToTipoAutorizzazioneAsString(autorizzazione, 
						ServletUtils.isCheckBoxEnabled(autorizzazioneAutenticati), ServletUtils.isCheckBoxEnabled(autorizzazioneRuoli), 
						RuoloTipologia.toEnumConstant(autorizzazioneRuoliTipologia)));
			else
				portaDelegata.setAutorizzazione(autorizzazioneCustom);
			
			if(ruoloMatch!=null && !"".equals(ruoloMatch)){
				RuoloTipoMatch tipoRuoloMatch = RuoloTipoMatch.toEnumConstant(ruoloMatch);
				if(tipoRuoloMatch!=null){
					if(portaDelegata.getRuoli()==null){
						portaDelegata.setRuoli(new AutorizzazioneRuoli());
					}
					portaDelegata.getRuoli().setMatch(tipoRuoloMatch);
				}
			}
			portaDelegata.setAutorizzazioneContenuto(autorizzazioneContenuti);
			
			String userLogin = ServletUtils.getUserLoginFromSession(session);

			porteDelegateCore.performUpdateOperation(userLogin, porteDelegateHelper.smista(), portaDelegata);
			
			// preparo i campi
			Vector<DataElement> dati = new Vector<DataElement>();
			
			portaDelegata = porteDelegateCore.getPortaDelegata(idInt);
			idporta = portaDelegata.getNome();
			
			ruoli = new ArrayList<>();
			if(portaDelegata!=null && portaDelegata.getRuoli()!=null && portaDelegata.getRuoli().sizeRuoloList()>0){
				for (int i = 0; i < portaDelegata.getRuoli().sizeRuoloList(); i++) {
					ruoli.add(portaDelegata.getRuoli().getRuolo(i).getNome());
				}
			}
			
			numRuoli = 0;
			if(portaDelegata.getRuoli()!=null){
				numRuoli = portaDelegata.getRuoli().sizeRuoloList();
			}
			
			if (autenticazione == null) {
				autenticazione = portaDelegata.getAutenticazione();
				if (autenticazione != null &&
						!TipoAutenticazione.getValues().contains(autenticazione)) {
					autenticazioneCustom = autenticazione;
					autenticazione = CostantiControlStation.DEFAULT_VALUE_PARAMETRO_PORTE_AUTENTICAZIONE_CUSTOM;
				}
			}
			if(autenticazioneOpzionale==null){
				autenticazioneOpzionale = "";
				if(portaDelegata.getAutenticazioneOpzionale()!=null){
					if (portaDelegata.getAutenticazioneOpzionale().equals(StatoFunzionalita.ABILITATO)) {
						autenticazioneOpzionale = Costanti.CHECK_BOX_ENABLED;
					}
				}
			}
			if (autorizzazione == null) {
				if (portaDelegata.getAutorizzazione() != null &&
						!TipoAutorizzazione.getAllValues().contains(portaDelegata.getAutorizzazione())) {
					autorizzazioneCustom = portaDelegata.getAutorizzazione();
					autorizzazione = CostantiControlStation.DEFAULT_VALUE_PARAMETRO_PORTE_AUTORIZZAZIONE_CUSTOM;
				}
				else{
					autorizzazione = AutorizzazioneUtilities.convertToStato(portaDelegata.getAutorizzazione());
					if(TipoAutorizzazione.isAuthenticationRequired(portaDelegata.getAutorizzazione()))
						autorizzazioneAutenticati = Costanti.CHECK_BOX_ENABLED;
					if(TipoAutorizzazione.isRolesRequired(portaDelegata.getAutorizzazione()))
						autorizzazioneRuoli = Costanti.CHECK_BOX_ENABLED;
					autorizzazioneRuoliTipologia = AutorizzazioneUtilities.convertToRuoloTipologia(portaDelegata.getAutorizzazione()).getValue();
				}
			}
			
			if (ruoloMatch == null) {
				if(portaDelegata.getRuoli()!=null && portaDelegata.getRuoli().getMatch()!=null){
					ruoloMatch = portaDelegata.getRuoli().getMatch().getValue();
				}
			}
			
			if(autorizzazioneContenuti==null){
				autorizzazioneContenuti = portaDelegata.getAutorizzazioneContenuto();
			}
			
			porteDelegateHelper.controlloAccessiAutenticazione(dati, autenticazione, autenticazioneCustom, autenticazioneOpzionale, confPers, isSupportatoAutenticazione);

			// Tipo operazione = CHANGE per evitare di aggiungere if, questa e' a tutti gli effetti una servlet di CHANGE
			porteDelegateHelper.controlloAccessiAutorizzazione(dati, TipoOperazione.CHANGE, servletChiamante,
					autenticazione, autorizzazione, autorizzazioneCustom, 
					autorizzazioneAutenticati, urlAutorizzazioneAutenticati, sizeFruitori, null, null,
					autorizzazioneRuoli,  urlAutorizzazioneRuoli, numRuoli, null, 
					autorizzazioneRuoliTipologia, ruoloMatch,
					confPers, isSupportatoAutenticazione, contaListe, isPortaDelegata, false);
			
			porteDelegateHelper.controlloAccessiAutorizzazioneContenuti(dati, autorizzazioneContenuti);
			
			dati = porteDelegateHelper.addHiddenFieldsToDati(TipoOperazione.OTHER,id, idSoggFruitore, null,idAsps, idFruizione, dati);
			
			pd.setDati(dati);
			
			pd.setMessage(CostantiControlStation.LABEL_AGGIORNAMENTO_EFFETTUATO_CON_SUCCESSO, Costanti.MESSAGE_TYPE_INFO);

			ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);
			// Forward control to the specified success URI
			return ServletUtils.getStrutsForwardEditModeFinished(mapping, PorteDelegateCostanti.OBJECT_NAME_PORTE_DELEGATE_CONTROLLO_ACCESSI, 
					ForwardParams.OTHER(""));
			
		} catch (Exception e) {
			return ServletUtils.getStrutsForwardError(ControlStationCore.getLog(), e, pd, session, gd, mapping, 
					PorteDelegateCostanti.OBJECT_NAME_PORTE_DELEGATE_CONTROLLO_ACCESSI , 
					ForwardParams.OTHER(""));
		} 
	}

}
