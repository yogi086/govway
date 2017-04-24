/*
 * OpenSPCoop - Customizable API Gateway 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2017 Link.it srl (http://link.it). 
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

package org.openspcoop2.core.registry.driver.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openspcoop2.core.registry.driver.BeanUtilities;
import org.openspcoop2.core.registry.driver.DriverRegistroServiziException;
import org.slf4j.Logger;

/**
 * DriverRegistroServiziWSInitUtilities
 * 
 * @author Andrea Poli (poli@link.it)
 * @author $Author: apoli $
 * @version $Rev: 12564 $, $Date: 2017-01-11 14:31:31 +0100 (Wed, 11 Jan 2017) $
 */
public class DriverRegistroServiziWSInitUtilities {

	public static BeanUtilities newInstance(String url,String username,String password,Logger log) throws DriverRegistroServiziException{
		try{
			// Serve per poter compilare tutto il progetto senza gli stub per non creare dipendenza circolare
			Class<?> cDriver = Class.forName("org.openspcoop2.core.registry.driver.ws.DriverRegistroServiziWS");
			Constructor<?> constructor = null;
			if(username!=null){
				constructor = cDriver.getConstructor(String.class,String.class,String.class,Logger.class);
			}else{
				constructor = cDriver.getConstructor(String.class,Logger.class);
			}
			BeanUtilities driver = null;
			if(username!=null){
				driver = (BeanUtilities) constructor.newInstance(url,username,password,log);
			}else{
				driver = (BeanUtilities) constructor.newInstance(url,log);
			}
			Method mIsCreate = driver.getClass().getMethod("isCreate");
			boolean isCreate = (Boolean) mIsCreate.invoke(driver);
			if(isCreate)
				log.info("Inizializzato Registro dei Servizi WS");
			else
				throw new Exception("RegistroServizi WS non inizializzato");
			return driver;
		}catch(Exception e){
			throw new DriverRegistroServiziException(e.getMessage(),e);
		}
	}
	
}
