
package org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.7
 * 2017-04-24T11:59:41.446+02:00
 * Generated source version: 3.1.7
 */

@WebFault(name = "registry-not-implemented-exception", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
public class RegistryNotImplementedException_Exception extends Exception {
    
    private org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.RegistryNotImplementedException registryNotImplementedException;

    public RegistryNotImplementedException_Exception() {
        super();
    }
    
    public RegistryNotImplementedException_Exception(String message) {
        super(message);
    }
    
    public RegistryNotImplementedException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistryNotImplementedException_Exception(String message, org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.RegistryNotImplementedException registryNotImplementedException) {
        super(message);
        this.registryNotImplementedException = registryNotImplementedException;
    }

    public RegistryNotImplementedException_Exception(String message, org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.RegistryNotImplementedException registryNotImplementedException, Throwable cause) {
        super(message, cause);
        this.registryNotImplementedException = registryNotImplementedException;
    }

    public org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.RegistryNotImplementedException getFaultInfo() {
        return this.registryNotImplementedException;
    }
}
