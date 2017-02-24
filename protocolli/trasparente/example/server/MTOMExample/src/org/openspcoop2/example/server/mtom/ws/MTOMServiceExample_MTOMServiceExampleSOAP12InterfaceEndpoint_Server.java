
package org.openspcoop2.example.server.mtom.ws;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2017-02-21T15:25:10.701+01:00
 * Generated source version: 2.7.4
 * 
 */
 
public class MTOMServiceExample_MTOMServiceExampleSOAP12InterfaceEndpoint_Server{

    protected MTOMServiceExample_MTOMServiceExampleSOAP12InterfaceEndpoint_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new MTOMServiceExampleSOAP12Impl();
        String address = "http://localhost:8888/MTOMExample/soap12";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws java.lang.Exception { 
        new MTOMServiceExample_MTOMServiceExampleSOAP12InterfaceEndpoint_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}