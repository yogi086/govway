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

package org.openspcoop2.core.transazioni.ws.client.transazione.search;

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
 * 2018-03-23T14:34:37.808+01:00
 * Generated source version: 3.1.7
 * 
 */
public final class Transazione_TransazionePortSoap11_Client {

    private static final QName SERVICE_NAME = new QName("http://www.openspcoop2.org/core/transazioni/management", "TransazioneSoap11Service");

    private Transazione_TransazionePortSoap11_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = TransazioneSoap11Service.WSDL_LOCATION;
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
      
        TransazioneSoap11Service ss = new TransazioneSoap11Service(wsdlURL, Transazione_TransazionePortSoap11_Client.SERVICE_NAME);
        Transazione port = ss.getTransazionePortSoap11();
	
		new org.openspcoop2.core.transazioni.ws.client.utils.RequestContextUtils("transazione.soap11").addRequestContextParameters((javax.xml.ws.BindingProvider)port);  
        
        {
        System.out.println("Invoking find...");
        org.openspcoop2.core.transazioni.ws.client.transazione.search.Find _find_find = null;
        try {
            org.openspcoop2.core.transazioni.ws.client.transazione.search.FindResponse _find__return = port.find(_find_find);
            System.out.println("find.result=" + _find__return);

        } catch (TransazioniServiceException_Exception e) { 
            System.out.println("Expected exception: transazioni-service-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniNotFoundException_Exception e) { 
            System.out.println("Expected exception: transazioni-not-found-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniNotImplementedException_Exception e) { 
            System.out.println("Expected exception: transazioni-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: transazioni-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniMultipleResultException_Exception e) { 
            System.out.println("Expected exception: transazioni-multiple-result-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking get...");
        org.openspcoop2.core.transazioni.ws.client.transazione.search.Get _get_get = null;
        try {
            org.openspcoop2.core.transazioni.ws.client.transazione.search.GetResponse _get__return = port.get(_get_get);
            System.out.println("get.result=" + _get__return);

        } catch (TransazioniServiceException_Exception e) { 
            System.out.println("Expected exception: transazioni-service-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniNotFoundException_Exception e) { 
            System.out.println("Expected exception: transazioni-not-found-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniNotImplementedException_Exception e) { 
            System.out.println("Expected exception: transazioni-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: transazioni-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniMultipleResultException_Exception e) { 
            System.out.println("Expected exception: transazioni-multiple-result-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking findAllIds...");
        org.openspcoop2.core.transazioni.ws.client.transazione.search.SearchFilterTransazione _findAllIds_filter = null;
        try {
            java.util.List<java.lang.String> _findAllIds__return = port.findAllIds(_findAllIds_filter);
            System.out.println("findAllIds.result=" + _findAllIds__return);

        } catch (TransazioniServiceException_Exception e) { 
            System.out.println("Expected exception: transazioni-service-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniNotImplementedException_Exception e) { 
            System.out.println("Expected exception: transazioni-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: transazioni-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking findAll...");
        org.openspcoop2.core.transazioni.ws.client.transazione.search.FindAll _findAll_findAll = null;
        try {
            org.openspcoop2.core.transazioni.ws.client.transazione.search.FindAllResponse _findAll__return = port.findAll(_findAll_findAll);
            System.out.println("findAll.result=" + _findAll__return);

        } catch (TransazioniServiceException_Exception e) { 
            System.out.println("Expected exception: transazioni-service-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniNotImplementedException_Exception e) { 
            System.out.println("Expected exception: transazioni-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: transazioni-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking count...");
        org.openspcoop2.core.transazioni.ws.client.transazione.search.SearchFilterTransazione _count_filter = null;
        try {
            long _count__return = port.count(_count_filter);
            System.out.println("count.result=" + _count__return);

        } catch (TransazioniServiceException_Exception e) { 
            System.out.println("Expected exception: transazioni-service-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniNotImplementedException_Exception e) { 
            System.out.println("Expected exception: transazioni-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: transazioni-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking exists...");
        java.lang.String _exists_idTransazione = "";
        try {
            boolean _exists__return = port.exists(_exists_idTransazione);
            System.out.println("exists.result=" + _exists__return);

        } catch (TransazioniServiceException_Exception e) { 
            System.out.println("Expected exception: transazioni-service-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniNotImplementedException_Exception e) { 
            System.out.println("Expected exception: transazioni-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: transazioni-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (TransazioniMultipleResultException_Exception e) { 
            System.out.println("Expected exception: transazioni-multiple-result-exception has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
