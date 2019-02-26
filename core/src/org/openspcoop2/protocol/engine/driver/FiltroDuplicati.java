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


package org.openspcoop2.protocol.engine.driver;

import org.openspcoop2.protocol.sdk.Busta;
import org.openspcoop2.protocol.sdk.IProtocolFactory;
import org.openspcoop2.protocol.sdk.ProtocolException;

/**
 * Classe per la gestione dei filtro duplicati
 * 
 * @author Andrea Poli (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */

public class FiltroDuplicati implements IFiltroDuplicati {

	private History historyBuste;
	private RepositoryBuste repositoryBuste;
	private boolean gestioneStateless;
	private long repositoryIntervalloScadenzaMessaggi;
	
	@Override
	public void init(Object context) throws ProtocolException{
	}
	
	@Override
	public boolean isDuplicata(IProtocolFactory<?> protocolFactory, String id) throws ProtocolException{
		return this.historyBuste.bustaRicevutaPrecedentemente(id);
	}
	
	@Override
	public void incrementaNumeroDuplicati(IProtocolFactory<?> protocolFactory, String id) throws ProtocolException{
		this.repositoryBuste.aggiornaDuplicatiIntoInBox(id);
	}
	
	@Override
	public void registraBusta(IProtocolFactory<?> protocolFactory, Busta busta) throws ProtocolException{
		if( this.gestioneStateless ){
			// La busta puo' non esistere
			if(this.repositoryBuste.isRegistrataIntoInBox(busta.getID())==false){
				this.repositoryBuste.registraBustaIntoInboxForHistory(busta, this.repositoryIntervalloScadenzaMessaggi);
			}
		}
		else{
			// se siamo in stateless l'history e' gia stato registrato sopra
			this.historyBuste.registraBustaRicevuta(busta.getID());
		}
	}

	public void setHistoryBuste(History historyBuste) {
		this.historyBuste = historyBuste;
	}

	public void setRepositoryBuste(RepositoryBuste repository) {
		this.repositoryBuste = repository;
	}

	public void setGestioneStateless(boolean stateless) {
		this.gestioneStateless = stateless;
	}

	public void setRepositoryIntervalloScadenzaMessaggi(
			long repositoryIntervalloScadenzaMessaggi) {
		this.repositoryIntervalloScadenzaMessaggi = repositoryIntervalloScadenzaMessaggi;
	}
	
}
