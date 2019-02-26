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


package org.openspcoop2.protocol.spcoop.backward_compatibility.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.openspcoop2.pdd.core.CostantiPdD;
import org.openspcoop2.utils.properties.InstanceProperties;

/**
* BackwardCompatibilityInstanceProperties
*
* @author Andrea Poli <apoli@link.it>
 * @author $Author$
 * @version $Rev$, $Date$
*/

class BackwardCompatibilityInstanceProperties extends InstanceProperties {

	BackwardCompatibilityInstanceProperties(Properties reader,Logger log,String confDir) throws Exception{
		super(CostantiPdD.OPENSPCOOP2_LOCAL_HOME,reader, log);
		super.setLocalFileImplementation(Costanti.OPENSPCOOP2_BACKWARD_COMPATIBILITY_LOCAL_PATH,Costanti.OPENSPCOOP2_BACKWARD_COMPATIBILITY_PROPERTIES, confDir);
	}
}
