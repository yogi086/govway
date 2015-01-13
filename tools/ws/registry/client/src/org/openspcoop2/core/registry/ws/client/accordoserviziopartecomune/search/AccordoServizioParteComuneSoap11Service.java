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
package org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2014-11-28T12:43:46.302+01:00
 * Generated source version: 2.7.4
 * 
 */
@WebServiceClient(name = "AccordoServizioParteComuneSoap11Service", 
                  wsdlLocation = "deploy/wsdl/AccordoServizioParteComuneSearch_PortSoap11.wsdl",
                  targetNamespace = "http://www.openspcoop2.org/core/registry/management") 
public class AccordoServizioParteComuneSoap11Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.openspcoop2.org/core/registry/management", "AccordoServizioParteComuneSoap11Service");
    public final static QName AccordoServizioParteComunePortSoap11 = new QName("http://www.openspcoop2.org/core/registry/management", "AccordoServizioParteComunePortSoap11");
    static {
        URL url = AccordoServizioParteComuneSoap11Service.class.getResource("deploy/wsdl/AccordoServizioParteComuneSearch_PortSoap11.wsdl");
        if (url == null) {
            url = AccordoServizioParteComuneSoap11Service.class.getClassLoader().getResource("deploy/wsdl/AccordoServizioParteComuneSearch_PortSoap11.wsdl");
        } 
        if (url == null) {
            
		}
		if (url==null ){
			url = AccordoServizioParteComuneSoap11Service.class.getResource("/registry/AccordoServizioParteComuneSearch_PortSoap11.wsdl");
		}
		if (url==null ){
			url = AccordoServizioParteComuneSoap11Service.class.getClassLoader().getResource("/registry/AccordoServizioParteComuneSearch_PortSoap11.wsdl");
		}
		if (url==null ){
			java.util.logging.Logger.getLogger(AccordoServizioParteComuneSoap11Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "deploy/wsdl/AccordoServizioParteComuneSearch_PortSoap11.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public AccordoServizioParteComuneSoap11Service(URL wsdlLocation) {
        super(wsdlLocation, AccordoServizioParteComuneSoap11Service.SERVICE);
    }

    public AccordoServizioParteComuneSoap11Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AccordoServizioParteComuneSoap11Service() {
        super(AccordoServizioParteComuneSoap11Service.WSDL_LOCATION, AccordoServizioParteComuneSoap11Service.SERVICE);
    }
    

    /**
     *
     * @return
     *     returns AccordoServizioParteComune
     */
    @WebEndpoint(name = "AccordoServizioParteComunePortSoap11")
    public AccordoServizioParteComune getAccordoServizioParteComunePortSoap11() {
        return super.getPort(AccordoServizioParteComuneSoap11Service.AccordoServizioParteComunePortSoap11, AccordoServizioParteComune.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AccordoServizioParteComune
     */
    @WebEndpoint(name = "AccordoServizioParteComunePortSoap11")
    public AccordoServizioParteComune getAccordoServizioParteComunePortSoap11(WebServiceFeature... features) {
        return super.getPort(AccordoServizioParteComuneSoap11Service.AccordoServizioParteComunePortSoap11, AccordoServizioParteComune.class, features);
    }

}
