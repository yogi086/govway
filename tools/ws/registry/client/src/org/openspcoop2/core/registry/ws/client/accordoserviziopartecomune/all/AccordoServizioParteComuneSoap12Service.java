/*
 * OpenSPCoop v2 - Customizable SOAP Message Broker 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2015 Link.it srl (http://link.it).
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.all;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2014-11-28T12:43:32.167+01:00
 * Generated source version: 2.7.4
 * 
 */
@WebServiceClient(name = "AccordoServizioParteComuneSoap12Service", 
                  wsdlLocation = "deploy/wsdl/AccordoServizioParteComuneAll_PortSoap12.wsdl",
                  targetNamespace = "http://www.openspcoop2.org/core/registry/management") 
public class AccordoServizioParteComuneSoap12Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.openspcoop2.org/core/registry/management", "AccordoServizioParteComuneSoap12Service");
    public final static QName AccordoServizioParteComunePortSoap12 = new QName("http://www.openspcoop2.org/core/registry/management", "AccordoServizioParteComunePortSoap12");
    static {
        URL url = AccordoServizioParteComuneSoap12Service.class.getResource("deploy/wsdl/AccordoServizioParteComuneAll_PortSoap12.wsdl");
        if (url == null) {
            url = AccordoServizioParteComuneSoap12Service.class.getClassLoader().getResource("deploy/wsdl/AccordoServizioParteComuneAll_PortSoap12.wsdl");
        } 
        if (url == null) {
            
		}
		if (url==null ){
			url = AccordoServizioParteComuneSoap12Service.class.getResource("/registry/AccordoServizioParteComuneAll_PortSoap12.wsdl");
		}
		if (url==null ){
			url = AccordoServizioParteComuneSoap12Service.class.getClassLoader().getResource("/registry/AccordoServizioParteComuneAll_PortSoap12.wsdl");
		}
		if (url==null ){
			java.util.logging.Logger.getLogger(AccordoServizioParteComuneSoap12Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "deploy/wsdl/AccordoServizioParteComuneAll_PortSoap12.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public AccordoServizioParteComuneSoap12Service(URL wsdlLocation) {
        super(wsdlLocation, AccordoServizioParteComuneSoap12Service.SERVICE);
    }

    public AccordoServizioParteComuneSoap12Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AccordoServizioParteComuneSoap12Service() {
        super(AccordoServizioParteComuneSoap12Service.WSDL_LOCATION, AccordoServizioParteComuneSoap12Service.SERVICE);
    }
    

    /**
     *
     * @return
     *     returns AccordoServizioParteComune
     */
    @WebEndpoint(name = "AccordoServizioParteComunePortSoap12")
    public AccordoServizioParteComune getAccordoServizioParteComunePortSoap12() {
        return super.getPort(AccordoServizioParteComuneSoap12Service.AccordoServizioParteComunePortSoap12, AccordoServizioParteComune.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AccordoServizioParteComune
     */
    @WebEndpoint(name = "AccordoServizioParteComunePortSoap12")
    public AccordoServizioParteComune getAccordoServizioParteComunePortSoap12(WebServiceFeature... features) {
        return super.getPort(AccordoServizioParteComuneSoap12Service.AccordoServizioParteComunePortSoap12, AccordoServizioParteComune.class, features);
    }

}
