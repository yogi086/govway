package org.openspcoop2.core.registry.ws.client.accordocooperazione.crud;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2018-05-30T09:45:25.834+02:00
 * Generated source version: 3.1.7
 * 
 */
@WebServiceClient(name = "AccordoCooperazioneSoap11Service", 
                  wsdlLocation = "file:deploy/wsdl/AccordoCooperazioneCRUD_PortSoap11.wsdl",
                  targetNamespace = "http://www.openspcoop2.org/core/registry/management") 
public class AccordoCooperazioneSoap11Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.openspcoop2.org/core/registry/management", "AccordoCooperazioneSoap11Service");
    public final static QName AccordoCooperazionePortSoap11 = new QName("http://www.openspcoop2.org/core/registry/management", "AccordoCooperazionePortSoap11");
    static {
        URL url = null;
        try {
            url = new URL("file:deploy/wsdl/AccordoCooperazioneCRUD_PortSoap11.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(AccordoCooperazioneSoap11Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:deploy/wsdl/AccordoCooperazioneCRUD_PortSoap11.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public AccordoCooperazioneSoap11Service(URL wsdlLocation) {
        super(wsdlLocation, AccordoCooperazioneSoap11Service.SERVICE);
    }

    public AccordoCooperazioneSoap11Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AccordoCooperazioneSoap11Service() {
        super(AccordoCooperazioneSoap11Service.WSDL_LOCATION, AccordoCooperazioneSoap11Service.SERVICE);
    }
    




    /**
     *
     * @return
     *     returns AccordoCooperazione
     */
    @WebEndpoint(name = "AccordoCooperazionePortSoap11")
    public AccordoCooperazione getAccordoCooperazionePortSoap11() {
        return super.getPort(AccordoCooperazioneSoap11Service.AccordoCooperazionePortSoap11, AccordoCooperazione.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AccordoCooperazione
     */
    @WebEndpoint(name = "AccordoCooperazionePortSoap11")
    public AccordoCooperazione getAccordoCooperazionePortSoap11(WebServiceFeature... features) {
        return super.getPort(AccordoCooperazioneSoap11Service.AccordoCooperazionePortSoap11, AccordoCooperazione.class, features);
    }

}
