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
package org.openspcoop2.generic_project.dao.jpa;

import java.io.File;

import org.openspcoop2.generic_project.beans.IProjectInfo;
import org.openspcoop2.generic_project.exception.ServiceException;
import org.openspcoop2.generic_project.utils.Log4JLoaderProperties;
import org.openspcoop2.generic_project.utils.Utilities;

/**
 * JPALoggerProperties
 * 
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class JPALoggerProperties extends Log4JLoaderProperties {

	public JPALoggerProperties(IProjectInfo project,File log4jProperties) throws ServiceException {
		super(log4jProperties.getAbsolutePath());
	}
	public JPALoggerProperties(IProjectInfo project) throws ServiceException {
		super(Utilities.normalizedProjectName(project.getProjectName())+".dao.jpa.log4j.properties");
	}

	public static JPALoggerProperties getInstance(IProjectInfo project) throws ServiceException {
		return new JPALoggerProperties(project);
	}
	
} 
