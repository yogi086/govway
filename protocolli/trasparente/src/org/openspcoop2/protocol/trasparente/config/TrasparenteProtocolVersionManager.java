/*
 * OpenSPCoop v2 - Customizable SOAP Message Broker 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2016 Link.it srl (http://link.it). 
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


package org.openspcoop2.protocol.trasparente.config;

import org.slf4j.Logger;
import org.openspcoop2.protocol.basic.config.BasicVersionManager;
import org.openspcoop2.protocol.sdk.IProtocolFactory;
import org.openspcoop2.protocol.sdk.ProtocolException;

/**
 * Classe che implementa, in base al protocollo Trasparente, l'interfaccia {@link org.openspcoop2.protocol.sdk.config.IProtocolVersionManager} 
 *
 * @author Poli Andrea (apoli@link.it)
 * @author Nardi Lorenzo (nardi@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class TrasparenteProtocolVersionManager extends BasicVersionManager {
	
	protected TrasparenteProperties trasparenteProperties = null;
	protected Logger logger = null;
	protected String versione;
	public TrasparenteProtocolVersionManager(IProtocolFactory protocolFactory,String versione) throws ProtocolException{
		super(protocolFactory);
		this.versione = versione;
		this.logger = this.getProtocolFactory().getLogger();
		this.trasparenteProperties = TrasparenteProperties.getInstance(this.logger);
	}
	
	
	@Override
	public Boolean isAggiungiDetailErroreApplicativo_SoapFaultApplicativo() {
		return this.trasparenteProperties.isAggiungiDetailErroreApplicativo_SoapFaultApplicativo();
	}

	@Override
	public Boolean isAggiungiDetailErroreApplicativo_SoapFaultPdD() {
		return this.trasparenteProperties.isAggiungiDetailErroreApplicativo_SoapFaultPdD();
	}
	
}
