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

package org.openspcoop2.core.tracciamento.ws.client.traccia.search;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.7
 * 2018-03-26T15:02:43.245+02:00
 * Generated source version: 3.1.7
 */

@WebFault(name = "tracciamento-multiple-result-exception", targetNamespace = "http://www.openspcoop2.org/core/tracciamento/management")
public class TracciamentoMultipleResultException_Exception extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private org.openspcoop2.core.tracciamento.ws.client.traccia.search.TracciamentoMultipleResultException tracciamentoMultipleResultException;

    public TracciamentoMultipleResultException_Exception() {
        super();
    }
    
    public TracciamentoMultipleResultException_Exception(String message) {
        super(message);
    }
    
    public TracciamentoMultipleResultException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public TracciamentoMultipleResultException_Exception(String message, org.openspcoop2.core.tracciamento.ws.client.traccia.search.TracciamentoMultipleResultException tracciamentoMultipleResultException) {
        super(message);
        this.tracciamentoMultipleResultException = tracciamentoMultipleResultException;
    }

    public TracciamentoMultipleResultException_Exception(String message, org.openspcoop2.core.tracciamento.ws.client.traccia.search.TracciamentoMultipleResultException tracciamentoMultipleResultException, Throwable cause) {
        super(message, cause);
        this.tracciamentoMultipleResultException = tracciamentoMultipleResultException;
    }

    public org.openspcoop2.core.tracciamento.ws.client.traccia.search.TracciamentoMultipleResultException getFaultInfo() {
        return this.tracciamentoMultipleResultException;
    }
}
