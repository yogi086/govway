
package org.openspcoop2.core.diagnostica.ws.client.informazioniprotocollotransazione.search;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.4
 * 2015-02-18T17:51:57.010+01:00
 * Generated source version: 2.7.4
 */

@WebFault(name = "diagnostica-not-found-exception", targetNamespace = "http://www.openspcoop2.org/core/diagnostica/management")
public class DiagnosticaNotFoundException_Exception extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private org.openspcoop2.core.diagnostica.ws.client.informazioniprotocollotransazione.search.DiagnosticaNotFoundException diagnosticaNotFoundException;

    public DiagnosticaNotFoundException_Exception() {
        super();
    }
    
    public DiagnosticaNotFoundException_Exception(String message) {
        super(message);
    }
    
    public DiagnosticaNotFoundException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public DiagnosticaNotFoundException_Exception(String message, org.openspcoop2.core.diagnostica.ws.client.informazioniprotocollotransazione.search.DiagnosticaNotFoundException diagnosticaNotFoundException) {
        super(message);
        this.diagnosticaNotFoundException = diagnosticaNotFoundException;
    }

    public DiagnosticaNotFoundException_Exception(String message, org.openspcoop2.core.diagnostica.ws.client.informazioniprotocollotransazione.search.DiagnosticaNotFoundException diagnosticaNotFoundException, Throwable cause) {
        super(message, cause);
        this.diagnosticaNotFoundException = diagnosticaNotFoundException;
    }

    public org.openspcoop2.core.diagnostica.ws.client.informazioniprotocollotransazione.search.DiagnosticaNotFoundException getFaultInfo() {
        return this.diagnosticaNotFoundException;
    }
}
