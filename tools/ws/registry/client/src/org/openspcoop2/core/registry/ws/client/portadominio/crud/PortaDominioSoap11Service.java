package org.openspcoop2.core.registry.ws.client.portadominio.crud;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2018-05-30T09:48:32.581+02:00
 * Generated source version: 3.1.7
 * 
 */
@WebServiceClient(name = "PortaDominioSoap11Service", 
                  wsdlLocation = "file:deploy/wsdl/PortaDominioCRUD_PortSoap11.wsdl",
                  targetNamespace = "http://www.openspcoop2.org/core/registry/management") 
public class PortaDominioSoap11Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.openspcoop2.org/core/registry/management", "PortaDominioSoap11Service");
    public final static QName PortaDominioPortSoap11 = new QName("http://www.openspcoop2.org/core/registry/management", "PortaDominioPortSoap11");
    static {
        URL url = null;
        try {
            url = new URL("file:deploy/wsdl/PortaDominioCRUD_PortSoap11.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PortaDominioSoap11Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:deploy/wsdl/PortaDominioCRUD_PortSoap11.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PortaDominioSoap11Service(URL wsdlLocation) {
        super(wsdlLocation, PortaDominioSoap11Service.SERVICE);
    }

    public PortaDominioSoap11Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PortaDominioSoap11Service() {
        super(PortaDominioSoap11Service.WSDL_LOCATION, PortaDominioSoap11Service.SERVICE);
    }
    




    /**
     *
     * @return
     *     returns PortaDominio
     */
    @WebEndpoint(name = "PortaDominioPortSoap11")
    public PortaDominio getPortaDominioPortSoap11() {
        return super.getPort(PortaDominioSoap11Service.PortaDominioPortSoap11, PortaDominio.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PortaDominio
     */
    @WebEndpoint(name = "PortaDominioPortSoap11")
    public PortaDominio getPortaDominioPortSoap11(WebServiceFeature... features) {
        return super.getPort(PortaDominioSoap11Service.PortaDominioPortSoap11, PortaDominio.class, features);
    }

}
