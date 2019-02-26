/*
 * GovWay - A customizable API Gateway 
 * http://www.govway.org
 *
 * from the Link.it OpenSPCoop project codebase
 * 
 * Copyright (c) 2005-2019 Link.it srl (http://link.it). 
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


package org.openspcoop2.web.ctrlstat.servlet.apc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.openspcoop2.core.commons.Liste;
import org.openspcoop2.core.registry.AccordoServizioParteComune;
import org.openspcoop2.core.registry.Resource;
import org.openspcoop2.core.registry.ResourceParameter;
import org.openspcoop2.core.registry.ResourceRequest;
import org.openspcoop2.core.registry.ResourceResponse;
import org.openspcoop2.web.ctrlstat.core.ControlStationCore;
import org.openspcoop2.web.ctrlstat.core.Search;
import org.openspcoop2.web.ctrlstat.servlet.GeneralHelper;
import org.openspcoop2.web.lib.mvc.ForwardParams;
import org.openspcoop2.web.lib.mvc.GeneralData;
import org.openspcoop2.web.lib.mvc.PageData;
import org.openspcoop2.web.lib.mvc.ServletUtils;

/**
 * AccordiServizioParteComuneResourcesList
 * 
 * @author Andrea Poli (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 * 
 */
public final class AccordiServizioParteComuneResourcesParametersList extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(true);

		// Inizializzo PageData
		PageData pd = new PageData();

		GeneralHelper generalHelper = new GeneralHelper(session);

		GeneralData gd = generalHelper.initGeneralData(request);

		try {

			AccordiServizioParteComuneCore apcCore = new AccordiServizioParteComuneCore();

			AccordiServizioParteComuneHelper apcHelper = new AccordiServizioParteComuneHelper(request, pd, session);

			String id = apcHelper.getParameter(AccordiServizioParteComuneCostanti.PARAMETRO_APC_ID);
			int idAccordo = Integer.parseInt(id);
			String nomeRisorsa = apcHelper.getParameter(AccordiServizioParteComuneCostanti.PARAMETRO_APC_RESOURCES_NOME);

			String tipoAccordo = apcHelper.getParameter(AccordiServizioParteComuneCostanti.PARAMETRO_APC_TIPO_ACCORDO);
			if("".equals(tipoAccordo))
				tipoAccordo = null;

			String statusResponseS = apcHelper.getParameter(AccordiServizioParteComuneCostanti.PARAMETRO_APC_RESOURCES_RESPONSE_STATUS);
			Integer statusResponse = null;
			try {
				if(StringUtils.isNotEmpty(statusResponseS))
					statusResponse = Integer.parseInt(statusResponseS);
			}catch(Exception e) {
				statusResponse = null;
			}

			String isReq = apcHelper.getParameter(AccordiServizioParteComuneCostanti.PARAMETRO_APC_RESOURCE_REQUEST);
			boolean isRequest = ServletUtils.isCheckBoxEnabled(isReq);

			// Preparo il menu
			apcHelper.makeMenu();
			
			// Prendo l'id della risorsa
			Long idRisorsa = 0L;
			Resource res =  null;
			AccordoServizioParteComune as = apcCore.getAccordoServizio(idAccordo);
			for (int i = 0; i < as.sizeResourceList(); i++) {
				res = as.getResource(i);
				if (nomeRisorsa.equals(res.getNome())) {
					idRisorsa = res.getId();
					break;
				}
			}
			
			Long idResponse = null;
			ResourceRequest resourceRequest = null;
			ResourceResponse resourceResponse = null;
			if(isRequest) {
				resourceRequest = res.getRequest();
			} else {
				if(res.getResponseList() != null) {
					for (int i = 0; i < res.getResponseList().size(); i++) {
						resourceResponse = res.getResponse(i);
						if (resourceResponse.getStatus() == statusResponse) {
							idResponse = resourceResponse.getId();
							break;
						}
					}
				}
			}
						

			// Controllo i criteri di ricerca e recupero eventuali parametri
			Search ricerca = (Search) ServletUtils.getSearchObjectFromSession(session, Search.class);

			int idLista = isRequest ? Liste.ACCORDI_API_RESOURCES_PARAMETERS_REQUEST : Liste.ACCORDI_API_RESOURCES_PARAMETERS_RESPONSE;

			ricerca = apcHelper.checkSearchParameters(idLista, ricerca);

			List<ResourceParameter> lista = apcCore.accordiResourceParametersList(idRisorsa, isRequest, idResponse, ricerca);

			apcHelper.prepareAccordiResourcesParametersList(id, as, lista, ricerca, tipoAccordo, isRequest, res, resourceRequest, resourceResponse);
			
			// salvo l'oggetto ricerca nella sessione
			ServletUtils.setSearchObjectIntoSession(session, ricerca);
			
			ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);
			
			return ServletUtils.getStrutsForward(mapping, AccordiServizioParteComuneCostanti.OBJECT_NAME_APC_RESOURCES_PARAMETERS, ForwardParams.LIST());

		} catch (Exception e) {
			return ServletUtils.getStrutsForwardError(ControlStationCore.getLog(), e, pd, session, gd, mapping, 
					AccordiServizioParteComuneCostanti.OBJECT_NAME_APC_RESOURCES_PARAMETERS, ForwardParams.LIST());
		} 
	}
}
