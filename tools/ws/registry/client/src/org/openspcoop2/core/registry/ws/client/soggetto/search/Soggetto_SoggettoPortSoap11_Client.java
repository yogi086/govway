/*
 * GovWay - A customizable API Gateway 
 * http://www.govway.org
 * 
 * from the Link.it OpenSPCoop project codebase
 * 
 * Copyright (c) 2005-2019 Link.it srl (http://link.it).
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3, as published by
 * the Free Software Foundation.
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

package org.openspcoop2.core.registry.ws.client.soggetto.search;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2018-05-30T09:52:46.314+02:00
 * Generated source version: 3.1.7
 * 
 */
public final class Soggetto_SoggettoPortSoap11_Client {

    private static final QName SERVICE_NAME = new QName("http://www.openspcoop2.org/core/registry/management", "SoggettoSoap11Service");

    private Soggetto_SoggettoPortSoap11_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = SoggettoSoap11Service.WSDL_LOCATION;
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
      
        SoggettoSoap11Service ss = new SoggettoSoap11Service(wsdlURL, Soggetto_SoggettoPortSoap11_Client.SERVICE_NAME);
        Soggetto port = ss.getSoggettoPortSoap11();
	
		new org.openspcoop2.core.registry.ws.client.utils.RequestContextUtils("soggetto.soap11").addRequestContextParameters((javax.xml.ws.BindingProvider)port);  
        
        {
        System.out.println("Invoking find...");
        org.openspcoop2.core.registry.ws.client.soggetto.search.SearchFilterSoggetto _find_filter = new org.openspcoop2.core.registry.ws.client.soggetto.search.SearchFilterSoggetto();
        try {
            org.openspcoop2.core.registry.Soggetto _find__return = port.find(_find_filter);
            System.out.println("find.result=" + _find__return);

        } catch (RegistryServiceException_Exception e) { 
            System.out.println("Expected exception: registry-service-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotFoundException_Exception e) { 
            System.out.println("Expected exception: registry-not-found-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotImplementedException_Exception e) { 
            System.out.println("Expected exception: registry-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryMultipleResultException_Exception e) { 
            System.out.println("Expected exception: registry-multiple-result-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: registry-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking get...");
        org.openspcoop2.core.registry.IdSoggetto _get_idSoggetto = new org.openspcoop2.core.registry.IdSoggetto();
        try {
            org.openspcoop2.core.registry.Soggetto _get__return = port.get(_get_idSoggetto);
            System.out.println("get.result=" + _get__return);

        } catch (RegistryServiceException_Exception e) { 
            System.out.println("Expected exception: registry-service-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotFoundException_Exception e) { 
            System.out.println("Expected exception: registry-not-found-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotImplementedException_Exception e) { 
            System.out.println("Expected exception: registry-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryMultipleResultException_Exception e) { 
            System.out.println("Expected exception: registry-multiple-result-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: registry-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking findAllIds...");
        org.openspcoop2.core.registry.ws.client.soggetto.search.SearchFilterSoggetto _findAllIds_filter = new org.openspcoop2.core.registry.ws.client.soggetto.search.SearchFilterSoggetto();
        try {
            java.util.List<org.openspcoop2.core.registry.IdSoggetto> _findAllIds__return = port.findAllIds(_findAllIds_filter);
            System.out.println("findAllIds.result=" + _findAllIds__return);

        } catch (RegistryServiceException_Exception e) { 
            System.out.println("Expected exception: registry-service-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotImplementedException_Exception e) { 
            System.out.println("Expected exception: registry-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: registry-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking count...");
        org.openspcoop2.core.registry.ws.client.soggetto.search.SearchFilterSoggetto _count_filter = new org.openspcoop2.core.registry.ws.client.soggetto.search.SearchFilterSoggetto();
        try {
            long _count__return = port.count(_count_filter);
            System.out.println("count.result=" + _count__return);

        } catch (RegistryServiceException_Exception e) { 
            System.out.println("Expected exception: registry-service-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotImplementedException_Exception e) { 
            System.out.println("Expected exception: registry-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: registry-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking inUse...");
        org.openspcoop2.core.registry.IdSoggetto _inUse_idSoggetto = new org.openspcoop2.core.registry.IdSoggetto();
        try {
            org.openspcoop2.core.registry.ws.client.soggetto.search.UseInfo _inUse__return = port.inUse(_inUse_idSoggetto);
            System.out.println("inUse.result=" + _inUse__return);

        } catch (RegistryServiceException_Exception e) { 
            System.out.println("Expected exception: registry-service-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotFoundException_Exception e) { 
            System.out.println("Expected exception: registry-not-found-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotImplementedException_Exception e) { 
            System.out.println("Expected exception: registry-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: registry-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking exists...");
        org.openspcoop2.core.registry.IdSoggetto _exists_idSoggetto = new org.openspcoop2.core.registry.IdSoggetto();
        try {
            boolean _exists__return = port.exists(_exists_idSoggetto);
            System.out.println("exists.result=" + _exists__return);

        } catch (RegistryServiceException_Exception e) { 
            System.out.println("Expected exception: registry-service-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotImplementedException_Exception e) { 
            System.out.println("Expected exception: registry-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryMultipleResultException_Exception e) { 
            System.out.println("Expected exception: registry-multiple-result-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: registry-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking findAll...");
        org.openspcoop2.core.registry.ws.client.soggetto.search.SearchFilterSoggetto _findAll_filter = new org.openspcoop2.core.registry.ws.client.soggetto.search.SearchFilterSoggetto();
        try {
            java.util.List<org.openspcoop2.core.registry.Soggetto> _findAll__return = port.findAll(_findAll_filter);
            System.out.println("findAll.result=" + _findAll__return);

        } catch (RegistryServiceException_Exception e) { 
            System.out.println("Expected exception: registry-service-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotImplementedException_Exception e) { 
            System.out.println("Expected exception: registry-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (RegistryNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: registry-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
