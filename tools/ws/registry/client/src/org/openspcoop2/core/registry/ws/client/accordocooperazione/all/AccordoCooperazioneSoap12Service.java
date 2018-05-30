package org.openspcoop2.core.registry.ws.client.accordocooperazione.all;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2018-05-30T09:44:39.890+02:00
 * Generated source version: 3.1.7
 * 
 */
@WebServiceClient(name = "AccordoCooperazioneSoap12Service", 
                  wsdlLocation = "file:deploy/wsdl/AccordoCooperazioneAll_PortSoap12.wsdl",
                  targetNamespace = "http://www.openspcoop2.org/core/registry/management") 
public class AccordoCooperazioneSoap12Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.openspcoop2.org/core/registry/management", "AccordoCooperazioneSoap12Service");
    public final static QName AccordoCooperazionePortSoap12 = new QName("http://www.openspcoop2.org/core/registry/management", "AccordoCooperazionePortSoap12");
    static {
        URL url = null;
        try {
            url = new URL("file:deploy/wsdl/AccordoCooperazioneAll_PortSoap12.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(AccordoCooperazioneSoap12Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:deploy/wsdl/AccordoCooperazioneAll_PortSoap12.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public AccordoCooperazioneSoap12Service(URL wsdlLocation) {
        super(wsdlLocation, AccordoCooperazioneSoap12Service.SERVICE);
    }

    public AccordoCooperazioneSoap12Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AccordoCooperazioneSoap12Service() {
        super(AccordoCooperazioneSoap12Service.WSDL_LOCATION, AccordoCooperazioneSoap12Service.SERVICE);
    }
    




    /**
     *
     * @return
     *     returns AccordoCooperazione
     */
    @WebEndpoint(name = "AccordoCooperazionePortSoap12")
    public AccordoCooperazione getAccordoCooperazionePortSoap12() {
        return super.getPort(AccordoCooperazioneSoap12Service.AccordoCooperazionePortSoap12, AccordoCooperazione.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AccordoCooperazione
     */
    @WebEndpoint(name = "AccordoCooperazionePortSoap12")
    public AccordoCooperazione getAccordoCooperazionePortSoap12(WebServiceFeature... features) {
        return super.getPort(AccordoCooperazioneSoap12Service.AccordoCooperazionePortSoap12, AccordoCooperazione.class, features);
    }

}
