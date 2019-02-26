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
package org.openspcoop2.security.message.wss4j;

import org.openspcoop2.security.SecurityException;
import org.openspcoop2.security.message.IMessageSecurityDigest;
import org.openspcoop2.security.message.MessageSecurityContext;
import org.openspcoop2.security.message.constants.SecurityType;
import org.openspcoop2.security.message.engine.MessageSecurityFactory;
import org.openspcoop2.utils.digest.IDigestReader;

/**
 * MessageSecurityDigest_wss4j
 *
 * @author Andrea Poli (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class MessageSecurityDigest_wss4j implements IMessageSecurityDigest{

	@Override
	public IDigestReader getDigestReader(MessageSecurityContext messageSecurityContext) throws SecurityException {
		return MessageSecurityFactory.getMessageSecurityDigestReader(SecurityType.WSSecurity, messageSecurityContext.getLog());
	}
	
}
