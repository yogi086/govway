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
package org.openspcoop2.example.pdd.server.trasparente.richiestastatofamiglia;

/**
 * RichiestaStatoFamigliaImpl11
 * 
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
@javax.jws.WebService(
                      serviceName = "RichiestaStatoFamigliaSOAP11Service",
                      portName = "RichiestaStatoFamigliaSOAP11InterfaceEndpoint",
                      targetNamespace = "http://openspcoop2.org/example/pdd/server/RichiestaStatoFamiglia",
                      wsdlLocation = "file:configurazionePdD/wsdl/implementazioneErogatoreSoap11.wsdl",
                      endpointInterface = "org.openspcoop2.example.pdd.server.trasparente.richiestastatofamiglia.RichiestaStatoFamiglia")
                      
public class RichiestaStatoFamigliaImpl11 extends RichiestaStatoFamigliaCommonImpl {

}
