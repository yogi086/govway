/*
 * GovWay - A customizable API Gateway 
 * https://govway.org
 * 
 * Copyright (c) 2005-2020 Link.it srl (https://link.it). 
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


package org.openspcoop2.pdd.mdb.threads;


import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Cicla sul db in attesa di messaggi
 *
 *
 * @author Tronci Fabio (tronci@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class InoltroRisposteProducer extends ModuloAlternativoProducer {

	private static String idModulo = "InoltroRisposte";
	
	public InoltroRisposteProducer(BlockingQueue<IWorker> coda) {
		super(InoltroRisposteProducer.idModulo,coda);
	}

	@Override
	public void creaWorkers(List<MessageIde> messaggiTrovati) {
		for (int i=0;i<messaggiTrovati.size();i++){
			MessageIde ide = messaggiTrovati.get(i);
			System.out.println(this.ID_MODULO+ "Producer: trovato messaggio con ide: " +
					ide.getIdMessaggio() + " , creo task...");
			InoltroRisposteWorker task = new InoltroRisposteWorker(ide);
			try {
				this.coda.put(task);
			} catch (InterruptedException e) {
				System.out.println(this.ID_MODULO+" :errore "+e);
			}
		}
			
	}
}
	
