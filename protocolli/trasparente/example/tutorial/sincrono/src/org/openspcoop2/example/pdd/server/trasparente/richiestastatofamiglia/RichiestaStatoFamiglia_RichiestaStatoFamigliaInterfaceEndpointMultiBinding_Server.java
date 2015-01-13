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

package org.openspcoop2.example.pdd.server.trasparente.richiestastatofamiglia;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * RichiestaStatoFamiglia_RichiestaStatoFamigliaInterfaceEndpointMultiBinding_Server
 * 
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class RichiestaStatoFamiglia_RichiestaStatoFamigliaInterfaceEndpointMultiBinding_Server{

    protected RichiestaStatoFamiglia_RichiestaStatoFamigliaInterfaceEndpointMultiBinding_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configurazionePdD/server/cxf.xml");
        context.toString();
    }
    
    public static void main(String args[]) throws java.lang.Exception { 
        new RichiestaStatoFamiglia_RichiestaStatoFamigliaInterfaceEndpointMultiBinding_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}
