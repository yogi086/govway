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

package org.openspcoop2.core.registry.ws.client.accordoserviziopartespecifica.crud;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.4
 * 2014-11-28T12:48:41.385+01:00
 * Generated source version: 2.7.4
 */

@WebFault(name = "registry-not-implemented-exception", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
public class RegistryNotImplementedException_Exception extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private org.openspcoop2.core.registry.ws.client.accordoserviziopartespecifica.crud.RegistryNotImplementedException registryNotImplementedException;

    public RegistryNotImplementedException_Exception() {
        super();
    }
    
    public RegistryNotImplementedException_Exception(String message) {
        super(message);
    }
    
    public RegistryNotImplementedException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistryNotImplementedException_Exception(String message, org.openspcoop2.core.registry.ws.client.accordoserviziopartespecifica.crud.RegistryNotImplementedException registryNotImplementedException) {
        super(message);
        this.registryNotImplementedException = registryNotImplementedException;
    }

    public RegistryNotImplementedException_Exception(String message, org.openspcoop2.core.registry.ws.client.accordoserviziopartespecifica.crud.RegistryNotImplementedException registryNotImplementedException, Throwable cause) {
        super(message, cause);
        this.registryNotImplementedException = registryNotImplementedException;
    }

    public org.openspcoop2.core.registry.ws.client.accordoserviziopartespecifica.crud.RegistryNotImplementedException getFaultInfo() {
        return this.registryNotImplementedException;
    }
}
