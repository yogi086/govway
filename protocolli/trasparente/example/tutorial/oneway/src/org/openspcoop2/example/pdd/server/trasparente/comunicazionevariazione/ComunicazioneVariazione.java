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
package org.openspcoop2.example.pdd.server.trasparente.comunicazionevariazione;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.openspcoop2.example.pdd.server.trasparente.comunicazionevariazione.ComunicazioneVariazione_Type;
import org.openspcoop2.example.pdd.server.trasparente.comunicazionevariazione.ObjectFactory;

/**
 * ComunicazioneVariazione
 * 
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
@WebService(targetNamespace = "http://openspcoop2.org/example/pdd/server/ComunicazioneVariazione", name = "ComunicazioneVariazione")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ComunicazioneVariazione {

    @Oneway
    @WebMethod(operationName = "Notifica")
    public void notifica(
        @WebParam(partName = "comunicazioneVariazionePart", name = "comunicazioneVariazione", targetNamespace = "http://openspcoop2.org/example/pdd/server/ComunicazioneVariazione")
        ComunicazioneVariazione_Type comunicazioneVariazionePart
    );
}
