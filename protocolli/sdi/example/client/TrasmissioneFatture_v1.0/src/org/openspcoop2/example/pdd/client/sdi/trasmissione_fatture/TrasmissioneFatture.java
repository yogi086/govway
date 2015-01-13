/*
 * OpenSPCoop v2 - Customizable SOAP Message Broker 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2015 Link.it srl (http://link.it).
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
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
package org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2014-10-10T14:24:52.613+02:00
 * Generated source version: 2.7.4
 * 
 * @author Andrea Poli (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
@WebService(targetNamespace = "http://www.fatturapa.gov.it/sdi/ws/trasmissione/v1.0", name = "TrasmissioneFatture")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TrasmissioneFatture {

    @Oneway
    @WebMethod(operationName = "NotificaDecorrenzaTermini", action = "http://www.fatturapa.it/TrasmissioneFatture/NotificaDecorrenzaTermini")
    public void notificaDecorrenzaTermini(
        @WebParam(partName = "decorrenzaTermini", name = "notificaDecorrenzaTermini", targetNamespace = "http://www.fatturapa.gov.it/sdi/ws/trasmissione/v1.0/types")
        FileSdIType decorrenzaTermini
    );

    @Oneway
    @WebMethod(operationName = "NotificaMancataConsegna", action = "http://www.fatturapa.it/TrasmissioneFatture/NotificaMancataConsegna")
    public void notificaMancataConsegna(
        @WebParam(partName = "mancataConsegna", name = "notificaMancataConsegna", targetNamespace = "http://www.fatturapa.gov.it/sdi/ws/trasmissione/v1.0/types")
        FileSdIType mancataConsegna
    );

    @Oneway
    @WebMethod(operationName = "RicevutaConsegna", action = "http://www.fatturapa.it/TrasmissioneFatture/RicevutaConsegna")
    public void ricevutaConsegna(
        @WebParam(partName = "ricevuta", name = "ricevutaConsegna", targetNamespace = "http://www.fatturapa.gov.it/sdi/ws/trasmissione/v1.0/types")
        FileSdIType ricevuta
    );

    @Oneway
    @WebMethod(operationName = "NotificaScarto", action = "http://www.fatturapa.it/TrasmissioneFatture/NotificaScarto")
    public void notificaScarto(
        @WebParam(partName = "scarto", name = "notificaScarto", targetNamespace = "http://www.fatturapa.gov.it/sdi/ws/trasmissione/v1.0/types")
        FileSdIType scarto
    );

    @Oneway
    @WebMethod(operationName = "AttestazioneTrasmissioneFattura", action = "http://www.fatturapa.it/TrasmissioneFatture/AttestazioneTrasmissioneFattura")
    public void attestazioneTrasmissioneFattura(
        @WebParam(partName = "attestazioneTrasmissioneFattura", name = "attestazioneTrasmissioneFattura", targetNamespace = "http://www.fatturapa.gov.it/sdi/ws/trasmissione/v1.0/types")
        FileSdIType attestazioneTrasmissioneFattura
    );

    @Oneway
    @WebMethod(operationName = "NotificaEsito", action = "http://www.fatturapa.it/TrasmissioneFatture/NotificaEsito")
    public void notificaEsito(
        @WebParam(partName = "esito", name = "notificaEsito", targetNamespace = "http://www.fatturapa.gov.it/sdi/ws/trasmissione/v1.0/types")
        FileSdIType esito
    );
}
