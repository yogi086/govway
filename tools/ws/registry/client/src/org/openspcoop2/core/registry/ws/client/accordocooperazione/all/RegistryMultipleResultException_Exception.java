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

package org.openspcoop2.core.registry.ws.client.accordocooperazione.all;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.6
 * 2019-09-19T15:13:41.457+02:00
 * Generated source version: 3.2.6
 */

@WebFault(name = "registry-multiple-result-exception", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
public class RegistryMultipleResultException_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private org.openspcoop2.core.registry.ws.client.accordocooperazione.all.RegistryMultipleResultException registryMultipleResultException;

    public RegistryMultipleResultException_Exception() {
        super();
    }

    public RegistryMultipleResultException_Exception(String message) {
        super(message);
    }

    public RegistryMultipleResultException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public RegistryMultipleResultException_Exception(String message, org.openspcoop2.core.registry.ws.client.accordocooperazione.all.RegistryMultipleResultException registryMultipleResultException) {
        super(message);
        this.registryMultipleResultException = registryMultipleResultException;
    }

    public RegistryMultipleResultException_Exception(String message, org.openspcoop2.core.registry.ws.client.accordocooperazione.all.RegistryMultipleResultException registryMultipleResultException, java.lang.Throwable cause) {
        super(message, cause);
        this.registryMultipleResultException = registryMultipleResultException;
    }

    public org.openspcoop2.core.registry.ws.client.accordocooperazione.all.RegistryMultipleResultException getFaultInfo() {
        return this.registryMultipleResultException;
    }
}
