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
package org.openspcoop2.web.ctrlstat.servlet.pa;

import java.util.Vector;

import org.openspcoop2.core.config.constants.CostantiConfigurazione;
import org.openspcoop2.core.config.constants.TipoAutenticazione;
import org.openspcoop2.core.config.constants.TipoAutorizzazione;
import org.openspcoop2.web.ctrlstat.costanti.CostantiControlStation;
import org.openspcoop2.web.lib.mvc.ForwardParams;

/**
 * PorteApplicativeCostanti
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class PorteApplicativeCostanti {

	/* OBJECT NAME */
	
	public final static String OBJECT_NAME_PORTE_APPLICATIVE = "porteApplicative";
	
	public final static String OBJECT_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY = "porteApplicativeWS";
	public final static ForwardParams TIPO_OPERAZIONE_MESSAGE_SECURITY = ForwardParams.OTHER("");
	public final static String OBJECT_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST = "porteApplicativeWSRequest";
	public final static String OBJECT_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE = "porteApplicativeWSResponse";
	
	public final static String OBJECT_NAME_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO = "porteApplicativeServizioApplicativo";
	
	public final static String OBJECT_NAME_PORTE_APPLICATIVE_RUOLI = "porteApplicativeRuoli";
	
	
	public final static String OBJECT_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA = "porteApplicativeCorrelazioneApplicativa";
	public final static ForwardParams TIPO_OPERAZIONE_CORRELAZIONE_APPLICATIVA = ForwardParams.OTHER("");
	public final static String OBJECT_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_REQUEST = "porteApplicativeCorrelazioneApplicativaRequest";
	public final static String OBJECT_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RESPONSE = "porteApplicativeCorrelazioneApplicativaResponse";
	
	public final static String OBJECT_NAME_PORTE_APPLICATIVE_PROPRIETA_PROTOCOLLO = "porteApplicativeProprietaProtocollo";
	
	public final static String OBJECT_NAME_PORTE_APPLICATIVE_MTOM = "porteApplicativeMTOM";
	public final static ForwardParams TIPO_OPERAZIONE_MTOM = ForwardParams.OTHER("");
	public final static String OBJECT_NAME_PORTE_APPLICATIVE_MTOM_REQUEST = "porteApplicativeMTOMRequest";
	public final static String OBJECT_NAME_PORTE_APPLICATIVE_MTOM_RESPONSE = "porteApplicativeMTOMResponse";
	
	public final static String OBJECT_NAME_PORTE_APPLICATIVE_EXTENDED = "porteApplicativeExtended";
	
	
	/* SERVLET NAME */
	
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_ADD = OBJECT_NAME_PORTE_APPLICATIVE+"Add.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_CHANGE = OBJECT_NAME_PORTE_APPLICATIVE+"Change.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_DELETE = OBJECT_NAME_PORTE_APPLICATIVE+"Del.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_LIST = OBJECT_NAME_PORTE_APPLICATIVE+"List.do";
	public final static Vector<String> SERVLET_PORTE_APPLICATIVE = new Vector<String>();
	static{
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_ADD);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_CHANGE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_DELETE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_LIST);
	}


	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY = OBJECT_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY+".do";

	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST_ADD = OBJECT_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST+"Add.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST_CHANGE = OBJECT_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST+"Change.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST_DELETE = OBJECT_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST+"Del.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST_LIST = OBJECT_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST+"List.do";
	public final static Vector<String> SERVLET_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST = new Vector<String>();
	static{
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST_ADD);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST_CHANGE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST_DELETE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST_LIST);
	}

	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE_ADD = OBJECT_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE+"Add.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE_CHANGE = OBJECT_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE+"Change.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE_DELETE = OBJECT_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE+"Del.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE_LIST = OBJECT_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE+"List.do";
	public final static Vector<String> SERVLET_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE = new Vector<String>();
	static{
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE_ADD);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE_CHANGE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE_DELETE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE_LIST);
	}

	public final static String SERVLET_NAME_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO_ADD = OBJECT_NAME_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO+"Add.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO_DELETE = OBJECT_NAME_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO+"Del.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO_LIST = OBJECT_NAME_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO+"List.do";
	public final static Vector<String> SERVLET_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO = new Vector<String>();
	static{
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO_ADD);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO_DELETE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO_LIST);
	}
	
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_RUOLI_ADD = OBJECT_NAME_PORTE_APPLICATIVE_RUOLI+"Add.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_RUOLI_DELETE = OBJECT_NAME_PORTE_APPLICATIVE_RUOLI+"Del.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_RUOLI_LIST = OBJECT_NAME_PORTE_APPLICATIVE_RUOLI+"List.do";
	public final static Vector<String> SERVLET_PORTE_APPLICATIVE_RUOLI = new Vector<String>();
	static{
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_RUOLI_ADD);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_RUOLI_DELETE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_RUOLI_LIST);
	}

	public final static String SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA = OBJECT_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA+".do";
	
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_REQUEST_ADD = OBJECT_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_REQUEST+"Add.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_REQUEST_CHANGE = OBJECT_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_REQUEST+"Change.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_REQUEST_DELETE = OBJECT_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_REQUEST+"Del.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_REQUEST_LIST = OBJECT_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_REQUEST+"List.do";
	public final static Vector<String> SERVLET_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_REQUEST = new Vector<String>();
	static{
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_REQUEST_ADD);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_REQUEST_CHANGE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_REQUEST_DELETE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_REQUEST_LIST);
	}

	public final static String SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RESPONSE_ADD = OBJECT_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RESPONSE+"Add.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RESPONSE_CHANGE = OBJECT_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RESPONSE+"Change.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RESPONSE_DELETE = OBJECT_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RESPONSE+"Del.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RESPONSE_LIST = OBJECT_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RESPONSE+"List.do";
	public final static Vector<String> SERVLET_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RESPONSE = new Vector<String>();
	static{
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RESPONSE_ADD);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RESPONSE_CHANGE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RESPONSE_DELETE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RESPONSE_LIST);
	}
	
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_PROPRIETA_PROTOCOLLO_ADD = OBJECT_NAME_PORTE_APPLICATIVE_PROPRIETA_PROTOCOLLO+"Add.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_PROPRIETA_PROTOCOLLO_CHANGE = OBJECT_NAME_PORTE_APPLICATIVE_PROPRIETA_PROTOCOLLO+"Change.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_PROPRIETA_PROTOCOLLO_DELETE = OBJECT_NAME_PORTE_APPLICATIVE_PROPRIETA_PROTOCOLLO+"Del.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_PROPRIETA_PROTOCOLLO_LIST = OBJECT_NAME_PORTE_APPLICATIVE_PROPRIETA_PROTOCOLLO+"List.do";
	public final static Vector<String> SERVLET_PORTE_APPLICATIVE_PROPRIETA_PROTOCOLLO = new Vector<String>();
	static{
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_PROPRIETA_PROTOCOLLO_ADD);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_PROPRIETA_PROTOCOLLO_CHANGE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_PROPRIETA_PROTOCOLLO_DELETE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_PROPRIETA_PROTOCOLLO_LIST);
	}
	
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MTOM = OBJECT_NAME_PORTE_APPLICATIVE_MTOM+".do";

	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MTOM_REQUEST_ADD = OBJECT_NAME_PORTE_APPLICATIVE_MTOM_REQUEST+"Add.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MTOM_REQUEST_CHANGE = OBJECT_NAME_PORTE_APPLICATIVE_MTOM_REQUEST+"Change.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MTOM_REQUEST_DELETE = OBJECT_NAME_PORTE_APPLICATIVE_MTOM_REQUEST+"Del.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MTOM_REQUEST_LIST = OBJECT_NAME_PORTE_APPLICATIVE_MTOM_REQUEST+"List.do";
	public final static Vector<String> SERVLET_PORTE_APPLICATIVE_MTOM_REQUEST = new Vector<String>();
	static{
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MTOM_REQUEST_ADD);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MTOM_REQUEST_CHANGE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MTOM_REQUEST_DELETE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MTOM_REQUEST_LIST);
	}

	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MTOM_RESPONSE_ADD = OBJECT_NAME_PORTE_APPLICATIVE_MTOM_RESPONSE+"Add.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MTOM_RESPONSE_CHANGE = OBJECT_NAME_PORTE_APPLICATIVE_MTOM_RESPONSE+"Change.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MTOM_RESPONSE_DELETE = OBJECT_NAME_PORTE_APPLICATIVE_MTOM_RESPONSE+"Del.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_MTOM_RESPONSE_LIST = OBJECT_NAME_PORTE_APPLICATIVE_MTOM_RESPONSE+"List.do";
	public final static Vector<String> SERVLET_PORTE_APPLICATIVE_MTOM_RESPONSE = new Vector<String>();
	static{
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MTOM_RESPONSE_ADD);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MTOM_RESPONSE_CHANGE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MTOM_RESPONSE_DELETE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_MTOM_RESPONSE_LIST);
	}
	
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_EXTENDED_ADD = OBJECT_NAME_PORTE_APPLICATIVE_EXTENDED+"Add.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_EXTENDED_CHANGE = OBJECT_NAME_PORTE_APPLICATIVE_EXTENDED+"Change.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_EXTENDED_DELETE = OBJECT_NAME_PORTE_APPLICATIVE_EXTENDED+"Del.do";
	public final static String SERVLET_NAME_PORTE_APPLICATIVE_EXTENDED_LIST = OBJECT_NAME_PORTE_APPLICATIVE_EXTENDED+"List.do";
	public final static Vector<String> SERVLET_PORTE_APPLICATIVE_EXTENDED = new Vector<String>();
	static{
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_EXTENDED_ADD);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_EXTENDED_CHANGE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_EXTENDED_DELETE);
		SERVLET_PORTE_APPLICATIVE.add(SERVLET_NAME_PORTE_APPLICATIVE_EXTENDED_LIST);
	}
	
	
	/* LABEL GENERALI */
	
	public final static String LABEL_PORTE_APPLICATIVE = "Porte Applicative";
	public final static String LABEL_PORTE_APPLICATIVE_RISULTATI_RICERCA = "Risultati ricerca";

	public final static String LABEL_PA_MENU_VISUALE_AGGREGATA = "Porte Applicative";
	
	public final static String LABEL_PARAMETRO_TITOLO_PORTE_APPLICATIVE_DATI_GENERALI = "Dati Generali";
	public final static String LABEL_PARAMETRO_TITOLO_PORTE_APPLICATIVE_DATI_SERVIZIO = "Dati Servizio";
	
	/* PARAMETRI */
	
	public final static String PARAMETRO_PORTE_APPLICATIVE_ID = "id";
	public final static String PARAMETRO_PORTE_APPLICATIVE_NOME_PORTA = "nomePorta";
	public final static String PARAMETRO_PORTE_APPLICATIVE_ID_SOGGETTO = "idsogg";
	public final static String PARAMETRO_PORTE_APPLICATIVE_PROVIDER = "provider";
	public final static String PARAMETRO_PORTE_APPLICATIVE_ID_CORRELAZIONE_APPLICATIVA = "idcorr";
	public final static String PARAMETRO_PORTE_APPLICATIVE_TIPO_SOGGETTO = "tipoprov";
	public final static String PARAMETRO_PORTE_APPLICATIVE_NOME_SOGGETTO = "nomeprov";
	
	public final static String PARAMETRO_PORTE_APPLICATIVE_MODE = "mode";
	public final static String PARAMETRO_PORTE_APPLICATIVE_ELEMENTO_XML = "elemxml";
	public final static String PARAMETRO_PORTE_APPLICATIVE_GESTIONE_IDENTIFICAZIONE_FALLITA = "gif";
	public final static String PARAMETRO_PORTE_APPLICATIVE_PATTERN = CostantiControlStation.PARAMETRO_PATTERN;
	public final static String PARAMETRO_PORTE_APPLICATIVE_RIUSO_ID_MESSAGGIO = "riusoIdMessaggio";
	public final static String PARAMETRO_PORTE_APPLICATIVE_VALORE = "valore";
	public final static String PARAMETRO_PORTE_APPLICATIVE_MESSAGE_SECURITY = "messageSecurity";
	public final static String PARAMETRO_PORTE_APPLICATIVE_NOME = "nome";
	public final static String PARAMETRO_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO = "servizioApplicativo";
	public final static String PARAMETRO_PORTE_APPLICATIVE_RICEVUTA_ASINCRONA_SIMMETRICA = "ricsim";
	public final static String PARAMETRO_PORTE_APPLICATIVE_RICEVUTA_ASINCRONA_ASIMMETRICA = "ricasim";
	public final static String PARAMETRO_PORTE_APPLICATIVE_AUTORIZZAZIONE_CONTENUTI = "autorizzazioneContenuti";
	public final static String PARAMETRO_PORTE_APPLICATIVE_TIPO_VALIDAZIONE = "tipo_validazione";
	public final static String PARAMETRO_PORTE_APPLICATIVE_XSD = "xsd";
	public final static String PARAMETRO_PORTE_APPLICATIVE_GESTIONE_MANIFEST = "gestManifest";
	public final static String PARAMETRO_PORTE_APPLICATIVE_GESTIONE_BODY = "gestBody";
	public final static String PARAMETRO_PORTE_APPLICATIVE_LOCAL_FORWARD = "localForward";
	public final static String PARAMETRO_PORTE_APPLICATIVE_STATELESS = "stateless";
	public final static String PARAMETRO_PORTE_APPLICATIVE_BEHAVIOUR = "behaviour";
	public final static String PARAMETRO_PORTE_APPLICATIVE_DESCRIZIONE = "descr";
	public final static String PARAMETRO_PORTE_APPLICATIVE_SOGGETTO_VIRTUALE = "soggvirt";
	public final static String PARAMETRO_PORTE_APPLICATIVE_SERVIZIO = "servizio";
	public final static String PARAMETRO_PORTE_APPLICATIVE_AZIONE = "azione";
	public final static String PARAMETRO_PORTE_APPLICATIVE_OLD_NOME_PA = "oldNomePA";
	public final static String PARAMETRO_PORTE_APPLICATIVE_SCADENZA_CORRELAZIONE_APPLICATIVA = "scadcorr";
	public final static String PARAMETRO_PORTE_APPLICATIVE_INTEGRAZIONE = "integrazione";
	public final static String PARAMETRO_PORTE_APPLICATIVE_IDENTIFICATIVO_MESSAGGIO = "idMessaggio";
	
	public final static String ATTRIBUTO_PORTE_APPLICATIVE_USA_ID_SOGGETTO = CostantiControlStation.PARAMETRO_USAIDSOGG;
	
	public final static String PARAMETRO_PORTE_APPLICATIVE_MTOM_RICHIESTA = CostantiControlStation.PARAMETRO_MTOM_RICHIESTA;
	public final static String PARAMETRO_PORTE_APPLICATIVE_MTOM_RISPOSTA = CostantiControlStation.PARAMETRO_MTOM_RISPOSTA;
	
	public final static String PARAMETRO_PORTE_APPLICATIVE_OBBLIGATORIO = CostantiControlStation.PARAMETRO_OBBLIGATORIO;
	public final static String PARAMETRO_PORTE_APPLICATIVE_CONTENT_TYPE = CostantiControlStation.PARAMETRO_CONTENT_TYPE;
	
	public final static String PARAMETRO_PORTE_APPLICATIVE_APPLICA_MTOM_RICHIESTA = CostantiControlStation.PARAMETRO_APPLICA_MTOM_RICHIESTA;
	public final static String PARAMETRO_PORTE_APPLICATIVE_APPLICA_MTOM_RISPOSTA = CostantiControlStation.PARAMETRO_APPLICA_MTOM_RISPOSTA;
	
	public final static String PARAMETRO_PORTE_APPLICATIVE_APPLICA_MTOM = CostantiControlStation.PARAMETRO_APPLICA_MTOM_RICHIESTA;
	public final static String PARAMETRO_PORTE_APPLICATIVE_APPLICA_MODIFICA = CostantiControlStation.PARAMETRO_APPLICA_MODIFICA;

	/* LABEL PARAMETRI */
	
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_ID = "Id";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_ID_SOGGETTO = "IdSogg";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_ID_CORRELAZIONE_APPLICATIVA = "idCorr";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_SOGGETTI = "Soggetti";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_SERVIZIO = "Servizio";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_AZIONE = "Azione";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_NOME = "Nome";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_QUALSIASI_AZIONE = "Tutte le azioni del servizio";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_DESCRIZIONE = "Descrizione";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_SERVIZI_APPLICATIVI_EROGATORI = "Servizi Applicativi Erogatori";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO_EROGATORE = "Servizio Applicativo Erogatore";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_VALORE = "Valore";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_PATTERN = "Pattern";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO = "Servizio Applicativo";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_SERVIZI_APPLICATIVI = "Servizi Applicativi";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_RUOLI = "Ruoli";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_PROTOCOL_PROPERTIES = "Propriet&agrave; Protocollo";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_PROTOCOL_PROPERTIES_DI = "Propriet&agrave; Protocollo di ";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_PORTE_APPLICATIVE_DI = "Porte Applicative di ";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_SERVIZIO_APPLICATIVO_DI = "Servizi Applicativi di ";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_RUOLI_DI = "Ruoli di ";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_GESTIONE_MESSAGGIO = "Trattamento Messaggio";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MESSAGE_SECURITY = "Message Security";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MESSAGE_SECURITY_DI = "Message-Security di ";
//	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST_FLOW_DI = "Message-Security request-flow di ";
//	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE_FLOW_DI = "Message-Security response-flow di ";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MESSAGE_SECURITY_REQUEST_FLOW_DI = "Parametri Message-Security della Richiesta";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MESSAGE_SECURITY_RESPONSE_FLOW_DI = "Parametri Message-Security della Risposta";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MTOM = "MTOM";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MTOM_DI = "Configurazione MTOM di ";
//	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MTOM_REQUEST_FLOW_DI = "MTOM request-flow di ";
//	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MTOM_RESPONSE_FLOW_DI = "MTOM response-flow di ";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MTOM_REQUEST_FLOW_DI = "Parametri MTOM della Richiesta";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MTOM_RESPONSE_FLOW_DI = "Parametri MTOM della Risposta";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_CORRELAZIONI_APPLICATIVE_DI = "Correlazione Applicativa di ";
//	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_CORRELAZIONI_APPLICATIVE_RICHIESTA_DI = "Correlazioni Applicative Richiesta di ";
//	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_CORRELAZIONI_APPLICATIVE_RISPOSTA_DI = "Correlazioni Applicative per la risposta di ";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_CORRELAZIONI_APPLICATIVE_RICHIESTA_DI = "Regole di Correlazione della Richiesta";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_CORRELAZIONI_APPLICATIVE_RISPOSTA_DI = "Regole di Correlazione della Risposta";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_GESTIONE_IDENTIFICAZIONE_FALLITA = "Identificazione fallita";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MODALITA_IDENTIFICAZIONE = "Modalit&agrave; identificazione";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_ELEMENTO_XML = "Elemento xml";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_ELEMENTO_XML_BR = "Elemento xml<BR/>(Il campo vuoto indica qualsiasi elemento)";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_ELEMENTO_XML_NOTE = "Il campo vuoto indica qualsiasi elemento";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_AUTORIZZAZIONE_CONTENUTI = "Autorizzazione Contenuti";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_VALIDAZIONE_CONTENUTI = "Validazione Contenuti";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_TIPO_VALIDAZIONE = "Tipo Validazione";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_INTEGRAZIONE = "Integrazione";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_METADATI = "Metadati";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_STATELESS = "Stateless";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_BEHAVIOUR = "Behaviour";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_SOAP_WITH_ATTACHMENTS = "SOAP With Attachments";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_GESTIONE_BODY = "Gestione Body";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_GESTIONE_MANIFEST = "Gestione Manifest";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_GESTIONE_ASINCRONA = "Gestione Asincrona";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_RICEVUTA_ASINCRONA_SIMMETRICA = "Ricevuta Simmetrica";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_RICEVUTA_ASINCRONA_ASIMMETRICA = "Ricevuta Asimmetrica";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_SOGGETTO_VIRTUALE = "Soggetto Virtuale";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_KEYWORD ="Keyword";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_BR_RICHIESTA = "Correlazione applicativa<BR/>Richiesta";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_BR_RISPOSTA = "Correlazione applicativa<BR/>Risposta";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RICHIESTA = "Identificazione Richiesta";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_RISPOSTA = "Identificazione Risposta";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA = "Correlazione Applicativa";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_ABILITATA = "abilitata";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_CORRELAZIONE_APPLICATIVA_DISABILITATA = "disabilitata";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_SOGGETTO = "Soggetto";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MTOM_ABILITATO = "abilitato";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_MTOM_DISABILITATO = "disabilitato";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_RISULTATI_RICERCA = "Risultati Ricerca";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_STATO = "Stato";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_TIPO = "Tipo";
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_APPLICA_MTOM = CostantiControlStation.LABEL_PARAMETRO_APPLICA_MTOM;
	public final static String LABEL_PARAMETRO_PORTE_APPLICATIVE_ACCETTA_MTOM = CostantiControlStation.LABEL_PARAMETRO_ACCETTA_MTOM;
	
	
	
	/* DEFAULT VALUE PARAMETRI */
	
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_TIPO_MODE_CORRELAZIONE_INPUT_BASED = CostantiConfigurazione.CORRELAZIONE_APPLICATIVA_RICHIESTA_INPUT_BASED.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_TIPO_MODE_CORRELAZIONE_URL_BASED = CostantiConfigurazione.CORRELAZIONE_APPLICATIVA_RICHIESTA_URL_BASED.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_TIPO_MODE_CORRELAZIONE_CONTENT_BASED = CostantiConfigurazione.CORRELAZIONE_APPLICATIVA_RICHIESTA_CONTENT_BASED.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_TIPO_MODE_CORRELAZIONE_DISABILITATO = CostantiConfigurazione.CORRELAZIONE_APPLICATIVA_RICHIESTA_DISABILITATO.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_XSD_DISABILITATO = CostantiConfigurazione.STATO_CON_WARNING_DISABILITATO.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_XSD_ABILITATO = CostantiConfigurazione.STATO_CON_WARNING_ABILITATO.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_XSD_WARNING_ONLY = CostantiConfigurazione.STATO_CON_WARNING_WARNING_ONLY.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_TIPO_VALIDAZIONE_XSD =  CostantiConfigurazione.VALIDAZIONE_CONTENUTI_APPLICATIVI_XSD.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_TIPO_VALIDAZIONE_WSDL = CostantiConfigurazione.VALIDAZIONE_CONTENUTI_APPLICATIVI_WSDL.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_TIPO_VALIDAZIONE_OPENSPCOOP = CostantiConfigurazione.VALIDAZIONE_CONTENUTI_APPLICATIVI_OPENSPCOOP.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_STATELESS_DEFAULT = "default";
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_STATELESS_ABILITATO = CostantiConfigurazione.ABILITATO.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_STATELESS_DISABILITATO = CostantiConfigurazione.DISABILITATO.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_LOCAL_FORWARD_DISABILITATO = CostantiConfigurazione.DISABILITATO.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_LOCAL_FORWARD_ABILITATO = CostantiConfigurazione.ABILITATO.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_GEST_BODY_NONE = "none";
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_GEST_BODY_ALLEGA = "allega";  
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_GEST_BODY_SCARTA = "scarta";
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_GEST_MANIFEST_ABILITATO = CostantiConfigurazione.ABILITATO.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_GEST_MANIFEST_DISABILITATO = CostantiConfigurazione.DISABILITATO.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_GEST_MANIFEST_DEFAULT = "default";
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_DISABILITATO = CostantiConfigurazione.DISABILITATO.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_ABILITATO = CostantiConfigurazione.ABILITATO.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_AUTENTICAZIONE =  TipoAutenticazione.SSL.getValue();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_APPLICATIVE_AUTORIZZAZIONE = TipoAutorizzazione.AUTHENTICATED.getValue();
     
   
}
