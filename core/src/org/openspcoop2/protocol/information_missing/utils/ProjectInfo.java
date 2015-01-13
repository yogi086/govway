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
package org.openspcoop2.protocol.information_missing.utils;

import org.openspcoop2.generic_project.beans.IProjectInfo;


/**     
 * Project information
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class ProjectInfo implements IProjectInfo {

	@Override
	public String getProjectName(){
		return "openspcoop2_protocolInformationMissing";
	}
	
	@Override
	public String getProjectVersion(){
		return "1.0";
	}

	@Override
	public String getProjectNamespace(){
		return "http://www.openspcoop2.org/protocol/information_missing";
	}

	public static ProjectInfo getInstance(){
		return new ProjectInfo();
	}	
}