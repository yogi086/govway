
package org.openspcoop2.core.config.ws.client.servizioapplicativo.crud;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2017-04-24T11:52:46.909+02:00
 * Generated source version: 3.1.7
 * 
 */
public final class ServizioApplicativo_ServizioApplicativoPortSoap12_Client {

    private static final QName SERVICE_NAME = new QName("http://www.openspcoop2.org/core/config/management", "ServizioApplicativoSoap12Service");

    private ServizioApplicativo_ServizioApplicativoPortSoap12_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ServizioApplicativoSoap12Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        ServizioApplicativoSoap12Service ss = new ServizioApplicativoSoap12Service(wsdlURL, SERVICE_NAME);
        ServizioApplicativo port = ss.getServizioApplicativoPortSoap12();
	
		new org.openspcoop2.core.config.ws.client.utils.RequestContextUtils("servizioApplicativo.soap12").addRequestContextParameters((javax.xml.ws.BindingProvider)port);  
        
        {
        System.out.println("Invoking deleteById...");
        org.openspcoop2.core.config.IdServizioApplicativo _deleteById_idServizioApplicativo = new org.openspcoop2.core.config.IdServizioApplicativo();
        try {
            port.deleteById(_deleteById_idServizioApplicativo);

        } catch (ConfigNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: config-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotImplementedException_Exception e) { 
            System.out.println("Expected exception: config-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigServiceException_Exception e) { 
            System.out.println("Expected exception: config-service-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking deleteAll...");
        try {
            long _deleteAll__return = port.deleteAll();
            System.out.println("deleteAll.result=" + _deleteAll__return);

        } catch (ConfigNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: config-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotImplementedException_Exception e) { 
            System.out.println("Expected exception: config-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigServiceException_Exception e) { 
            System.out.println("Expected exception: config-service-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking create...");
        org.openspcoop2.core.config.ServizioApplicativo _create_servizioApplicativo = new org.openspcoop2.core.config.ServizioApplicativo();
        try {
            port.create(_create_servizioApplicativo);

        } catch (ConfigNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: config-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotImplementedException_Exception e) { 
            System.out.println("Expected exception: config-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigServiceException_Exception e) { 
            System.out.println("Expected exception: config-service-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking updateOrCreate...");
        org.openspcoop2.core.config.IdServizioApplicativo _updateOrCreate_oldIdServizioApplicativo = new org.openspcoop2.core.config.IdServizioApplicativo();
        org.openspcoop2.core.config.ServizioApplicativo _updateOrCreate_servizioApplicativo = new org.openspcoop2.core.config.ServizioApplicativo();
        try {
            port.updateOrCreate(_updateOrCreate_oldIdServizioApplicativo, _updateOrCreate_servizioApplicativo);

        } catch (ConfigNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: config-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotImplementedException_Exception e) { 
            System.out.println("Expected exception: config-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigServiceException_Exception e) { 
            System.out.println("Expected exception: config-service-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking delete...");
        org.openspcoop2.core.config.ServizioApplicativo _delete_servizioApplicativo = new org.openspcoop2.core.config.ServizioApplicativo();
        try {
            port.delete(_delete_servizioApplicativo);

        } catch (ConfigNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: config-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotImplementedException_Exception e) { 
            System.out.println("Expected exception: config-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigServiceException_Exception e) { 
            System.out.println("Expected exception: config-service-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking update...");
        org.openspcoop2.core.config.IdServizioApplicativo _update_oldIdServizioApplicativo = new org.openspcoop2.core.config.IdServizioApplicativo();
        org.openspcoop2.core.config.ServizioApplicativo _update_servizioApplicativo = new org.openspcoop2.core.config.ServizioApplicativo();
        try {
            port.update(_update_oldIdServizioApplicativo, _update_servizioApplicativo);

        } catch (ConfigNotFoundException_Exception e) { 
            System.out.println("Expected exception: config-not-found-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: config-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotImplementedException_Exception e) { 
            System.out.println("Expected exception: config-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigServiceException_Exception e) { 
            System.out.println("Expected exception: config-service-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking deleteAllByFilter...");
        org.openspcoop2.core.config.ws.client.servizioapplicativo.crud.SearchFilterServizioApplicativo _deleteAllByFilter_filter = new org.openspcoop2.core.config.ws.client.servizioapplicativo.crud.SearchFilterServizioApplicativo();
        try {
            long _deleteAllByFilter__return = port.deleteAllByFilter(_deleteAllByFilter_filter);
            System.out.println("deleteAllByFilter.result=" + _deleteAllByFilter__return);

        } catch (ConfigNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: config-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotImplementedException_Exception e) { 
            System.out.println("Expected exception: config-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigServiceException_Exception e) { 
            System.out.println("Expected exception: config-service-exception has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
