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


package org.openspcoop2.pdd.core.handlers;

import java.util.Date;

import org.apache.log4j.Logger;
import org.openspcoop2.pdd.core.PdDContext;
import org.openspcoop2.pdd.core.connettori.InfoConnettoreIngresso;
import org.openspcoop2.pdd.services.skeleton.Operazione;
import org.openspcoop2.protocol.sdk.IProtocolFactory;

/**
 * Informazioni di consultazione del servizio di IntegrationManager
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */

public class IntegrationManagerRequestContext extends IntegrationManagerBaseContext {

	/** Informazioni sul connettore di ingresso */
	private InfoConnettoreIngresso connettore;
	
	/** Costruttori */
	public IntegrationManagerRequestContext(Date dataRichiestaOperazione,Operazione tipoOperazione,
			PdDContext pddContext,Logger logger,IProtocolFactory protocolFactory) {
		super(dataRichiestaOperazione,tipoOperazione,pddContext,logger,protocolFactory);
	}

	public InfoConnettoreIngresso getConnettore() {
		return this.connettore;
	}

	public void setConnettore(InfoConnettoreIngresso connettore) {
		this.connettore = connettore;
	}
	
}
