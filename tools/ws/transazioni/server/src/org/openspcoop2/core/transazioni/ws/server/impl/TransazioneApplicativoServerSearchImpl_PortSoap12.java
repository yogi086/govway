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
package org.openspcoop2.core.transazioni.ws.server.impl;

import org.openspcoop2.core.transazioni.ws.server.exception.TransazioniServiceException_Exception;

/**     
 * TransazioneApplicativoServerSearchImpl_PortSoap12
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */

@javax.jws.WebService(name = "TransazioneApplicativoServer",
		serviceName = "TransazioneApplicativoServerSoap12Service",
		portName = "TransazioneApplicativoServerPortSoap12",
		targetNamespace = "http://www.openspcoop2.org/core/transazioni/management",
		endpointInterface = "org.openspcoop2.core.transazioni.ws.server.TransazioneApplicativoServerSearch")
public class TransazioneApplicativoServerSearchImpl_PortSoap12 extends TransazioneApplicativoServerImpl {

	@javax.annotation.Resource
	javax.xml.ws.WebServiceContext wsc;
	
	@Override
	@javax.jws.WebMethod
	protected javax.servlet.http.HttpServletRequest getHttpServletRequest() throws TransazioniServiceException_Exception{
		
		javax.servlet.http.HttpServletRequest req =  null;
		
		javax.xml.ws.handler.MessageContext msgContext = this.wsc.getMessageContext();

		req = 
			(javax.servlet.http.HttpServletRequest) msgContext.get(javax.xml.ws.handler.MessageContext.SERVLET_REQUEST);
		
		return req;
	}

	@Override
	protected javax.servlet.http.HttpServletResponse getHttpServletResponse()
			throws TransazioniServiceException_Exception {
		
		javax.servlet.http.HttpServletResponse res =  null;
		
		javax.xml.ws.handler.MessageContext msgContext = this.wsc.getMessageContext();

		res = 
			(javax.servlet.http.HttpServletResponse) msgContext.get(javax.xml.ws.handler.MessageContext.SERVLET_RESPONSE);
		
		return res;
	}
}