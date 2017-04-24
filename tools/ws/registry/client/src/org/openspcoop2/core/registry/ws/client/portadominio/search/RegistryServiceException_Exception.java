
package org.openspcoop2.core.registry.ws.client.portadominio.search;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.7
 * 2017-04-24T12:01:25.630+02:00
 * Generated source version: 3.1.7
 */

@WebFault(name = "registry-service-exception", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
public class RegistryServiceException_Exception extends Exception {
    
    private org.openspcoop2.core.registry.ws.client.portadominio.search.RegistryServiceException registryServiceException;

    public RegistryServiceException_Exception() {
        super();
    }
    
    public RegistryServiceException_Exception(String message) {
        super(message);
    }
    
    public RegistryServiceException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistryServiceException_Exception(String message, org.openspcoop2.core.registry.ws.client.portadominio.search.RegistryServiceException registryServiceException) {
        super(message);
        this.registryServiceException = registryServiceException;
    }

    public RegistryServiceException_Exception(String message, org.openspcoop2.core.registry.ws.client.portadominio.search.RegistryServiceException registryServiceException, Throwable cause) {
        super(message, cause);
        this.registryServiceException = registryServiceException;
    }

    public org.openspcoop2.core.registry.ws.client.portadominio.search.RegistryServiceException getFaultInfo() {
        return this.registryServiceException;
    }
}
