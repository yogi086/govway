package org.openspcoop2.core.config.ws.client.portaapplicativa.all;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2017-04-24T11:47:13.671+02:00
 * Generated source version: 3.1.7
 * 
 */
@WebServiceClient(name = "PortaApplicativaSoap11Service", 
                  wsdlLocation = "file:deploy/wsdl/PortaApplicativaAll_PortSoap11.wsdl",
                  targetNamespace = "http://www.openspcoop2.org/core/config/management") 
public class PortaApplicativaSoap11Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.openspcoop2.org/core/config/management", "PortaApplicativaSoap11Service");
    public final static QName PortaApplicativaPortSoap11 = new QName("http://www.openspcoop2.org/core/config/management", "PortaApplicativaPortSoap11");
    static {
        URL url = null;
        try {
            url = new URL("file:deploy/wsdl/PortaApplicativaAll_PortSoap11.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PortaApplicativaSoap11Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:deploy/wsdl/PortaApplicativaAll_PortSoap11.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PortaApplicativaSoap11Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PortaApplicativaSoap11Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PortaApplicativaSoap11Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    




    /**
     *
     * @return
     *     returns PortaApplicativa
     */
    @WebEndpoint(name = "PortaApplicativaPortSoap11")
    public PortaApplicativa getPortaApplicativaPortSoap11() {
        return super.getPort(PortaApplicativaPortSoap11, PortaApplicativa.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PortaApplicativa
     */
    @WebEndpoint(name = "PortaApplicativaPortSoap11")
    public PortaApplicativa getPortaApplicativaPortSoap11(WebServiceFeature... features) {
        return super.getPort(PortaApplicativaPortSoap11, PortaApplicativa.class, features);
    }

}
