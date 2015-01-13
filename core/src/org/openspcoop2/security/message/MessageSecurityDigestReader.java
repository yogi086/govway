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
package org.openspcoop2.security.message;

import org.apache.log4j.Logger;
import org.openspcoop2.security.message.constants.SecurityType;
import org.openspcoop2.utils.digest.IDigestReader;

/**
 * MessageSecurityDigestReader
 *
 * @author Andrea Poli (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public abstract class MessageSecurityDigestReader {

	protected Logger log;
	
	public MessageSecurityDigestReader (Logger log){
		this.log = log;
	}
	
	public abstract IDigestReader getDigestReader(SecurityType securityType);
	
}
