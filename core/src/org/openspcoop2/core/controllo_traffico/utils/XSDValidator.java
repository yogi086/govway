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
package org.openspcoop2.core.controllo_traffico.utils;

import org.slf4j.Logger;
import org.openspcoop2.utils.xml.AbstractValidatoreXSD;
import org.openspcoop2.generic_project.exception.ServiceException;

import org.openspcoop2.core.controllo_traffico.ConfigurazioneGenerale;

/** 
 * XSD Validator    
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */

public class XSDValidator {

	private static org.openspcoop2.generic_project.utils.XSDValidator validator = null;
	
	private static synchronized void initValidator(Class<?> validatorImpl,Logger log) throws ServiceException{
		if(validator==null){
			validator = new org.openspcoop2.generic_project.utils.XSDValidator(log,ConfigurazioneGenerale.class, 
				"/openspcoopControlloTraffico.xsd"
				// elencare in questa posizione altri schemi xsd che vengono inclusi/importati dallo schema /openspcoopControlloTraffico.xsd
			);
		}
	}
	
	public static AbstractValidatoreXSD getXSDValidator(Class<?> validatorImpl,Logger log) throws ServiceException{
		if(validator==null){
			initValidator(validatorImpl,log);
		}
		return validator.getXsdValidator();
	}
	public static AbstractValidatoreXSD getXSDValidator(Logger log) throws ServiceException{
		if(validator==null){
			initValidator(org.openspcoop2.utils.xml.ValidatoreXSD.class,log);
		}
		return validator.getXsdValidator();
	}
	
}
