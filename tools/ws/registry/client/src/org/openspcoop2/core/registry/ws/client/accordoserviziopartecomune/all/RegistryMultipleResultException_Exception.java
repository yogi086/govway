
package org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.all;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.7
 * 2018-05-30T09:46:12.805+02:00
 * Generated source version: 3.1.7
 */

@WebFault(name = "registry-multiple-result-exception", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
public class RegistryMultipleResultException_Exception extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.all.RegistryMultipleResultException registryMultipleResultException;

    public RegistryMultipleResultException_Exception() {
        super();
    }
    
    public RegistryMultipleResultException_Exception(String message) {
        super(message);
    }
    
    public RegistryMultipleResultException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistryMultipleResultException_Exception(String message, org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.all.RegistryMultipleResultException registryMultipleResultException) {
        super(message);
        this.registryMultipleResultException = registryMultipleResultException;
    }

    public RegistryMultipleResultException_Exception(String message, org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.all.RegistryMultipleResultException registryMultipleResultException, Throwable cause) {
        super(message, cause);
        this.registryMultipleResultException = registryMultipleResultException;
    }

    public org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.all.RegistryMultipleResultException getFaultInfo() {
        return this.registryMultipleResultException;
    }
}
