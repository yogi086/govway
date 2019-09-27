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

package org.openspcoop2.core.registry.ws.client.soggetto.all;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.6
 * 2019-09-19T15:22:51.421+02:00
 * Generated source version: 3.2.6
 */

@WebFault(name = "registry-not-found-exception", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
public class RegistryNotFoundException_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private org.openspcoop2.core.registry.ws.client.soggetto.all.RegistryNotFoundException registryNotFoundException;

    public RegistryNotFoundException_Exception() {
        super();
    }

    public RegistryNotFoundException_Exception(String message) {
        super(message);
    }

    public RegistryNotFoundException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public RegistryNotFoundException_Exception(String message, org.openspcoop2.core.registry.ws.client.soggetto.all.RegistryNotFoundException registryNotFoundException) {
        super(message);
        this.registryNotFoundException = registryNotFoundException;
    }

    public RegistryNotFoundException_Exception(String message, org.openspcoop2.core.registry.ws.client.soggetto.all.RegistryNotFoundException registryNotFoundException, java.lang.Throwable cause) {
        super(message, cause);
        this.registryNotFoundException = registryNotFoundException;
    }

    public org.openspcoop2.core.registry.ws.client.soggetto.all.RegistryNotFoundException getFaultInfo() {
        return this.registryNotFoundException;
    }
}
