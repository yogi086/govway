package org.openspcoop2.pdd.core.controllo_traffico;

import org.openspcoop2.core.controllo_congestione.beans.DatiTransazione;
import org.openspcoop2.core.controllo_congestione.beans.RisultatoStato;
import org.openspcoop2.core.eventi.constants.CodiceEventoControlloCongestione;
import org.openspcoop2.core.eventi.constants.TipoEvento;
import org.slf4j.Logger;

public interface INotify {

	public boolean isNotifichePassiveAttive();
	
	public RisultatoStato getStato(Logger logCore, DatiTransazione datiTransazione, String idStato) throws Exception;
	
	public void segnaloPortaRipartita(Logger logCore, boolean debug);
	
	public void updateStatoRilevamentoCongestione(Logger logCore, boolean debug, TipoEvento tipoEvento, CodiceEventoControlloCongestione codiceEvento, String descrizione);
	
	public void updateStatoRilevamentoViolazionePolicy(Logger logCore, boolean debug, CodiceEventoControlloCongestione codiceEvento, String idConfigurazionePolicy);
	

}