
package org.openspcoop2.core.registry.ws.client.soggetto.search;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.7
 * 2018-05-30T09:53:02.241+02:00
 * Generated source version: 3.1.7
 */

@WebFault(name = "registry-not-authorized-exception", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
public class RegistryNotAuthorizedException_Exception extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private org.openspcoop2.core.registry.ws.client.soggetto.search.RegistryNotAuthorizedException registryNotAuthorizedException;

    public RegistryNotAuthorizedException_Exception() {
        super();
    }
    
    public RegistryNotAuthorizedException_Exception(String message) {
        super(message);
    }
    
    public RegistryNotAuthorizedException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistryNotAuthorizedException_Exception(String message, org.openspcoop2.core.registry.ws.client.soggetto.search.RegistryNotAuthorizedException registryNotAuthorizedException) {
        super(message);
        this.registryNotAuthorizedException = registryNotAuthorizedException;
    }

    public RegistryNotAuthorizedException_Exception(String message, org.openspcoop2.core.registry.ws.client.soggetto.search.RegistryNotAuthorizedException registryNotAuthorizedException, Throwable cause) {
        super(message, cause);
        this.registryNotAuthorizedException = registryNotAuthorizedException;
    }

    public org.openspcoop2.core.registry.ws.client.soggetto.search.RegistryNotAuthorizedException getFaultInfo() {
        return this.registryNotAuthorizedException;
    }
}
