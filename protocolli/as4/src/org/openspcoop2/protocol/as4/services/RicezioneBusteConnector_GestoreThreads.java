/*
 * OpenSPCoop - Customizable API Gateway 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2017 Link.it srl (http://link.it). 
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



package org.openspcoop2.protocol.as4.services;

import org.openspcoop2.protocol.as4.config.AS4Properties;
import org.openspcoop2.utils.UtilsException;
import org.openspcoop2.utils.threads.IGestoreRunnableInstance;
import org.openspcoop2.utils.threads.Runnable;
import org.openspcoop2.utils.threads.RunnableLogger;

/**
 * RicezioneBusteConnector_GestoreThreads
 * 
 * @author Poli Andrea (apoli@link.it)
 * @author $Author: apoli $
 * @version $Rev: 13384 $, $Date: 2017-10-26 12:24:53 +0200 (Thu, 26 Oct 2017) $
 */
public class RicezioneBusteConnector_GestoreThreads implements IGestoreRunnableInstance{

	private RunnableLogger log;
	private AS4Properties asProperties;
	
	@Override
	public void initialize(RunnableLogger log) throws UtilsException {
		this.log = log;
		
		// Aspetto inizializzazione di OpenSPCoop (aspetto mezzo minuto e poi segnalo errore)
//		int attesa = 90;
//		int secondi = 0;
//		while( (OpenSPCoop2Startup.initialize==false) && (secondi<attesa) ){
//			Utilities.sleep(1000);
//			secondi++;
//		}
//		if(secondi>= 90){
//			throw new UtilsException("Riscontrata inizializzazione OpenSPCoop non effettuata");
//		}  
		
		try {
			this.asProperties = AS4Properties.getInstance(this.log.getLog());
		}catch(Exception e) {
			throw new UtilsException(e.getMessage(),e);
		}
	}

	@Override
	public Runnable newRunnable(RunnableLogger runnableLog) throws UtilsException {
		try {
			RicezioneBusteConnector connector = new RicezioneBusteConnector(runnableLog, this.asProperties);
			return new Runnable(runnableLog, connector, this.asProperties.getDomibusGatewayJMS_threadCheckIntervalSeconds());
		}catch(Exception e) {
			throw new UtilsException(e.getMessage(),e);
		}
	}
	
}
