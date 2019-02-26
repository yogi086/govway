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
package org.openspcoop2.protocol.sdk.archive;

import org.openspcoop2.protocol.sdk.ProtocolException;

/**
 * ArchiveIdCorrelazione
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class ArchiveIdCorrelazione {

	private String id;
	private String descrizione;

	public ArchiveIdCorrelazione(String id) throws ProtocolException{
		if(id==null || "".equals(id)){
			throw new ProtocolException("Id is required");
		}
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) throws ProtocolException {
		if(id==null || "".equals(id)){
			throw new ProtocolException("Id is required");
		}
		this.id = id;
	}
	public String getDescrizione() {
		return this.descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
