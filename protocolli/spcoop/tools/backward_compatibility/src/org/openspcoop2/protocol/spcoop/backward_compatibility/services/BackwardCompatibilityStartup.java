/*
 * GovWay - A customizable API Gateway 
 * https://govway.org
 * 
 * Copyright (c) 2005-2020 Link.it srl (https://link.it).
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

package org.openspcoop2.protocol.spcoop.backward_compatibility.services;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.openspcoop2.pdd.config.OpenSPCoop2Properties;
import org.openspcoop2.protocol.spcoop.backward_compatibility.config.BackwardCompatibilityProperties;
import org.openspcoop2.protocol.spcoop.backward_compatibility.config.CodeMapping;
import org.openspcoop2.utils.Utilities;

/**
 * BackwardCompatibilityStartup
 * 
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class BackwardCompatibilityStartup implements ServletContextListener {

	private static CodeMapping codeMapping = null;
	public static CodeMapping getCodeMapping() {
		return codeMapping;
	}

	public static boolean initialized = false;
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		int maxWait = 500;
		int i = 0;
		while(OpenSPCoop2Properties.getInstance()==null && i<maxWait ){
			Utilities.sleep(200);
			i++;
		}
		try{
			BackwardCompatibilityProperties.initialize(OpenSPCoop2Properties.getInstance().getRootDirectory());
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(), e);
		}
		
		try{
			BackwardCompatibilityStartup.codeMapping = new CodeMapping();
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(), e);
		}
		
//		try{
		// IL LOGGER POTREBBE NON ESSERE INIZIALIZZATO
//			UtilitiesIntegrazione.initialize(OpenSPCoop2Logger.getLoggerOpenSPCoopCore(),false);
//		}catch(Exception e){
//			throw new RuntimeException(e.getMessage(), e);
//		}
	
		BackwardCompatibilityStartup.initialized = true;
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		BackwardCompatibilityStartup.initialized = false;
	}

}
