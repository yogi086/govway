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
package backend.ecodex.org._1_1.utils;

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
		return "govway_protocol_as4_ecodex_backend_v1.1";
	}
	
	@Override
	public String getProjectVersion(){
		return "1.0";
	}

	@Override
	public String getProjectNamespace(){
		return "http://org.ecodex.backend/1_1/";
	}

	public static ProjectInfo getInstance(){
		return new ProjectInfo();
	}	
}