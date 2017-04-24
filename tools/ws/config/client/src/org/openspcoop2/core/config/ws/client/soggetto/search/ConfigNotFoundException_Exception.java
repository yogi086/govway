
package org.openspcoop2.core.config.ws.client.soggetto.search;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.7
 * 2017-04-24T11:42:54.834+02:00
 * Generated source version: 3.1.7
 */

@WebFault(name = "config-not-found-exception", targetNamespace = "http://www.openspcoop2.org/core/config/management")
public class ConfigNotFoundException_Exception extends Exception {
    
    private org.openspcoop2.core.config.ws.client.soggetto.search.ConfigNotFoundException configNotFoundException;

    public ConfigNotFoundException_Exception() {
        super();
    }
    
    public ConfigNotFoundException_Exception(String message) {
        super(message);
    }
    
    public ConfigNotFoundException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigNotFoundException_Exception(String message, org.openspcoop2.core.config.ws.client.soggetto.search.ConfigNotFoundException configNotFoundException) {
        super(message);
        this.configNotFoundException = configNotFoundException;
    }

    public ConfigNotFoundException_Exception(String message, org.openspcoop2.core.config.ws.client.soggetto.search.ConfigNotFoundException configNotFoundException, Throwable cause) {
        super(message, cause);
        this.configNotFoundException = configNotFoundException;
    }

    public org.openspcoop2.core.config.ws.client.soggetto.search.ConfigNotFoundException getFaultInfo() {
        return this.configNotFoundException;
    }
}
