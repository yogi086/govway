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


package org.openspcoop2.web.ctrlstat.costanti;

import org.openspcoop2.core.config.constants.CostantiConfigurazione;
import org.openspcoop2.core.config.constants.StatoFunzionalita;
import org.openspcoop2.core.config.constants.StatoFunzionalitaConWarning;
import org.openspcoop2.core.config.constants.TipoAutenticazione;
import org.openspcoop2.core.config.constants.TrasformazioneRegolaParametroTipoAzione;
import org.openspcoop2.core.config.constants.VersioneSOAP;
import org.openspcoop2.core.registry.constants.CostantiRegistroServizi;
import org.openspcoop2.core.registry.constants.FormatoSpecifica;
import org.openspcoop2.web.lib.mvc.Costanti;

/**
 * CostantiControlStation
 * 
 * @author Andrea Poli (apoli@link.it)
 * @author Stefano Corallo (corallo@link.it)
 * @author Sandra Giangrandi (sandra@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 * 
 */
public class CostantiControlStation {
	
	public final static String DEFAULT_OPENSPCOOP2_PREFIX_LOCAL_PATH = "console";
	public final static String DEFAULT_OPENSPCOOP2_PROPERTIES_NAME = "CONSOLE";
	
	public final static String OPENSPCOOP2_PREFIX_LOCAL_PATH = "PREFIXNAMETEMPLATE";
	public final static String OPENSPCOOP2_PROPERTIES_NAME = "NAMETEMPLATE";
	
    public final static String _OPENSPCOOP2_CONSOLE_LOCAL_PATH = OPENSPCOOP2_PREFIX_LOCAL_PATH+"_local.properties";
    public final static String _OPENSPCOOP2_CONSOLE_PROPERTIES = "OPENSPCOOP2_"+OPENSPCOOP2_PROPERTIES_NAME+"_PROPERTIES";
    
    public final static String _OPENSPCOOP2_DATASOURCE_LOCAL_PATH = OPENSPCOOP2_PREFIX_LOCAL_PATH+"_local.datasource.properties";
    public final static String _OPENSPCOOP2_DATASOURCE_PROPERTIES = "OPENSPCOOP2_"+OPENSPCOOP2_PROPERTIES_NAME+"_DATASOURCE_PROPERTIES";
    
    public final static String _OPENSPCOOP2_REGISTRO_SERVIZI_REMOTO_LOCAL_PATH = OPENSPCOOP2_PREFIX_LOCAL_PATH+"_local.registroServiziRemoto.properties";
    public final static String _OPENSPCOOP2_REGISTRO_SERVIZI_REMOTO_PROPERTIES = "OPENSPCOOP2_"+OPENSPCOOP2_PROPERTIES_NAME+"_REGISTRO_SERVIZI_REMOTO_PROPERTIES";
	
    public final static String _OPENSPCOOP2_LOGGER_LOCAL_PATH = OPENSPCOOP2_PREFIX_LOCAL_PATH+"_local.log4j2.properties";
    public final static String _OPENSPCOOP2_LOGGER_PROPERTIES = "OPENSPCOOP2_"+OPENSPCOOP2_PROPERTIES_NAME+"_LOG_PROPERTIES";
    
	/** Logger */
	public static final String DRIVER_DB_PDD_CONSOLE_LOGGER = "DRIVER_DB_PDD_CONSOLE";

	/** Debug COSTANT STRING */
	public static final String DEBUG_STRING = "PDD_CONSOLE_DEBUG";
	
	/** PLACEHOLDER PROTOCOLLO in creazione automatica endpoint del soggetto */
	public static final String PLACEHOLDER_SOGGETTO_ENDPOINT_CREAZIONE_AUTOMATICA = "@protocol@";
	
	/** PLACEHOLDER PDD  */
	public static final String PLACEHOLDER_INFORMAZIONI_PDD_IP_GESTIONE = "@IP_GESTIONE@";
	public static final String PLACEHOLDER_INFORMAZIONI_PDD_PORTA_GESTIONE = "@PORTA_GESTIONE@";
	public static final String PLACEHOLDER_INFORMAZIONI_PDD_PROTOCOLLO_GESTIONE = "@PROTOCOLLO_GESTIONE@";
	public static final String PLACEHOLDER_INFORMAZIONI_PDD_IP_PUBBLICO = "@IP@";
	public static final String PLACEHOLDER_INFORMAZIONI_PDD_PORTA_PUBBLICA = "@PORTA@";
	public static final String PLACEHOLDER_INFORMAZIONI_PDD_PROTOCOLLO_PUBBLICO = "@PROTOCOLLO@";
	
	/** Intervallo in millisecondi per Filtro JMS effettuato dai Gestori */
	public static final int JMS_FILTER = 100;

	/** Sleep per simulare Algoritmo transazione XA */
	public static final int INTERVALLO_TRANSAZIONE_XA = 2000;

	/** Sleep per receive */
	public static final int INTERVALLO_RECEIVE = 10000;
	
	/** PERFORM OPERATION */
	public static final int PERFORM_OPERATION_CREATE = 0;
	public static final int PERFORM_OPERATION_UPDATE = 1;
	public static final int PERFORM_OPERATION_DELETE = 2;
	
	/** SCRIPT OPERATION */
	public static final String SCRIPT_PERFORM_OPERATION_CREATE = "add";
	public static final String SCRIPT_PERFORM_OPERATION_DELETE = "delete";
	
	/** SESSION ATTRIBUTE */
	public final static String SESSION_PARAMETRO_GESTIONE_INFO_PROTOCOLLO = "GestioneInfoProtocollo";
	public final static String SESSION_PARAMETRO_VISUALIZZA_ACCORDI_AZIONI = "ShowAccordiAzioni";
	public final static String SESSION_PARAMETRO_VISUALIZZA_ACCORDI_COOPERAZIONE = "ShowAccordiCooperazione";
	public final static String SESSION_PARAMETRO_GESTIONE_SOGGETTI_VIRTUALI = "SoggettoVirtuale";
	public final static String SESSION_PARAMETRO_MODALITA_INTERFACCIA = "ModalitaInterfaccia";
	public final static String SESSION_PARAMETRO_SINGLE_PDD = "singlePdD";
	public final static String SESSION_PARAMETRO_GESTIONE_CONFIGURAZIONI_PERSONALIZZATE = "ConfigurazioniPersonalizzate";
	public final static String SESSION_PARAMETRO_SAME_DB_WEBUI = "sameDBWebUI";
	public final static String SESSION_PARAMETRO_TIPO_DB = "tipoDB";
	public final static String SESSION_PARAMETRO_OLD_CONFIGURAZIONE_PROPERTIES_PREFIX = Costanti.SESSION_PARAMETRO_OLD_CONFIGURAZIONE_PROPERTIES_PREFIX;
	
	
	/** LABEL GENERALI */
	
	public final static String LABEL_PARAMETRO_PROTOCOLLO_DI = org.openspcoop2.core.constants.Costanti.LABEL_PARAMETRO_PROTOCOLLO_DI;
	public final static String LABEL_PARAMETRO_PROTOCOLLO = org.openspcoop2.core.constants.Costanti.LABEL_PARAMETRO_PROTOCOLLO;
	public final static String LABEL_PARAMETRO_PROTOCOLLI = org.openspcoop2.core.constants.Costanti.LABEL_PARAMETRO_PROTOCOLLI;
	public final static String LABEL_PARAMETRO_PROTOCOLLO_COMPACT = org.openspcoop2.core.constants.Costanti.LABEL_PARAMETRO_PROTOCOLLO_COMPACT;
	public final static String LABEL_PARAMETRO_PROTOCOLLI_COMPACT = org.openspcoop2.core.constants.Costanti.LABEL_PARAMETRO_PROTOCOLLI_COMPACT;
	
	public final static String LABEL_CONFIGURAZIONE_IMPOSTATA_MODALITA_AVANZATA_SHORT_MESSAGE_COLUMN = "Non standard";
	public final static String LABEL_CONFIGURAZIONE_IMPOSTATA_MODALITA_AVANZATA_SHORT_MESSAGE = "Configurazione non visualizzabile";
	public final static String LABEL_CONFIGURAZIONE_IMPOSTATA_MODALITA_AVANZATA_LONG_MESSAGE = "Attenzione: Configurazione non standard (Utilizzare l'interfaccia avanzata)";
	public final static String LABEL_AGGIORNAMENTO_EFFETTUATO_CON_SUCCESSO = "Aggiornamento effettuato con successo";
	public final static String LABEL_AGGIORNAMENTO_CONFIGURAZIONE_PROPERTIES_EFFETTUATO_CON_SUCCESSO = "Aggiornamento effettuato con successo";
	public final static String LABEL_STRUMENTI = "Strumenti";
	public final static String LABEL_LINKIT_WEB = "http://www.link.it";
	public final static String LABEL_OPENSPCOOP2_WEB = "http://www.govway.org";
	public final static String LABEL_PARAMETRO_ID = "Id";
	public final static String LABEL_PARAMETRO_ID_SOGGETTO = "IdSogg";
	public final static String LABEL_PARAMETRO_ID_PORTA = "IdPorta";
	public final static String LABEL_PARAMETRO_ID_ASPS = "IdAsps";
	public final static String LABEL_PARAMETRO_ID_FRUIZIONE = "IdFruizione";
	public final static String LABEL_PARAMETRO_NOME = "Nome";
	public final static String LABEL_PARAMETRO_VALORE = "Valore";
	public final static String LABEL_PARAMETRO_SERVIZIO_APPLICATIVO = "Servizio Applicativo";
	public final static String LABEL_PARAMETRO_APPLICATIVO = "Applicativo";
	public final static String LABEL_PARAMETRO_STATO = "Stato";
	public final static String LABEL_PARAMETRO_MESSAGE_SECURITY = "Message-Security";
	public final static String LABEL_PARAMETRO_RICHIESTA = "Richiesta";
	public final static String LABEL_PARAMETRO_RISPOSTA = "Risposta";
	public final static String LABEL_PARAMETRO_OBBLIGATORIO = "Elemento Obbligatorio";
	public final static String LABEL_PARAMETRO_PATTERN = "Pattern";
	public final static String LABEL_PARAMETRO_CONTENT_TYPE = "Content Type";
	public final static String LABEL_PARAMETRO_PARAMETRI = "Parametri";
	public final static String LABEL_PARAMETRO_APPLICA_MTOM = "Applica MTOM";
	public final static String LABEL_PARAMETRO_RUOLO = "Nome";
	public final static String LABEL_PARAMETRO_RUOLO_TIPOLOGIA = "Fonte";
	public final static String LABEL_PARAMETRO_RUOLO_TIPOLOGIA_XACML_POLICY = "Fonte Ruoli";
	public final static String LABEL_PARAMETRO_RUOLO_MATCH = "Ruoli Richiesti";
	public final static String LABEL_PARAMETRO_RUOLO_MATCH_ALL = "tutti";
	public final static String LABEL_PARAMETRO_RUOLO_MATCH_ANY = "almeno uno";
	public final static String LABEL_PARAMETRO_RUOLO_CONTESTO = "Contesto";
	public final static String LABEL_PARAMETRO_SCOPE = "Nome";
	public final static String LABEL_PARAMETRO_SCOPE_TIPOLOGIA = "Fonte";
	public final static String LABEL_PARAMETRO_SCOPE_TIPOLOGIA_XACML_POLICY = "Fonte Scope";
	public final static String LABEL_PARAMETRO_SCOPE_MATCH = "Scope Richiesti";
	public final static String LABEL_PARAMETRO_SCOPE_MATCH_ALL = "tutti";
	public final static String LABEL_PARAMETRO_SCOPE_MATCH_ANY = "almeno uno";
	public final static String LABEL_PARAMETRO_SCOPE_CONTESTO = "Contesto";
	public final static String LABEL_PARAMETRO_PORTE_CONTROLLO_ACCESSI = "Controllo degli Accessi";
	public final static String LABEL_PARAMETRO_PORTE_CONTROLLO_ACCESSI_STATO = "Accesso API";
	public final static String LABEL_PARAMETRO_PORTE_CONTROLLO_ACCESSI_AUTENTICAZIONE = "Autenticazione";
	public final static String LABEL_PARAMETRO_PORTE_CONTROLLO_ACCESSI_AUTENTICAZIONE_TRASPORTO = "Trasporto";
	public final static String LABEL_PARAMETRO_PORTE_CONTROLLO_ACCESSI_AUTENTICAZIONE_TOKEN = "Token";
	public final static String LABEL_PARAMETRO_PORTE_CONTROLLO_ACCESSI_AUTORIZZAZIONE = "Autorizzazione";
	public final static String LABEL_PARAMETRO_PORTE_CONTROLLO_ACCESSI_AUTORIZZAZIONE_CONTENUTI = "Autorizzazione Contenuti";
	public final static String LABEL_PARAMETRO_PORTE_CONTROLLO_ACCESSI_GESTIONE_TOKEN = "Gestione Token";
	public final static String LABEL_PARAMETRO_PORTE_AUTENTICAZIONE = "Stato";
	public final static String LABEL_PARAMETRO_PORTE_AUTENTICAZIONE_BASIC_FORWARD = "Forward Authorization";
	public final static String LABEL_PARAMETRO_PORTE_AUTENTICAZIONE_PRINCIPAL_TIPO = "Tipo";
	public final static String LABEL_PARAMETRO_PORTE_AUTENTICAZIONE_PRINCIPAL_NOME = "Nome";
	public final static String LABEL_PARAMETRO_PORTE_AUTENTICAZIONE_PRINCIPAL_ESPRESSIONE = "Espressione Regolare";
	public final static String LABEL_PARAMETRO_PORTE_AUTENTICAZIONE_PRINCIPAL_FORWARD_HEADER = "Forward Header";
	public final static String LABEL_PARAMETRO_PORTE_AUTENTICAZIONE_PRINCIPAL_FORWARD_FORM = "Forward Parametro Url";
	public final static String LABEL_PARAMETRO_PORTE_AUTENTICAZIONE_OPZIONALE = "Opzionale";
	public final static String LABEL_PARAMETRO_PORTE_AUTENTICAZIONE_TOKEN_ISSUER = "Issuer";
	public final static String LABEL_PARAMETRO_PORTE_AUTENTICAZIONE_TOKEN_CLIENT_ID = "ClientId";
	public final static String LABEL_PARAMETRO_PORTE_AUTENTICAZIONE_TOKEN_SUBJECT = "Subject";
	public final static String LABEL_PARAMETRO_PORTE_AUTENTICAZIONE_TOKEN_USERNAME = "Username";
	public final static String LABEL_PARAMETRO_PORTE_AUTENTICAZIONE_TOKEN_MAIL = "eMail";
	public final static String LABEL_PARAMETRO_PORTE_AUTORIZZAZIONE = "Stato";
	public final static String LABEL_PARAMETRO_PORTE_AUTORIZZAZIONE_AUTENTICAZIONE_SERVIZI_APPLICATIVI = "Autorizzazione Puntuale";//"Applicativi Autenticati";
	public final static String LABEL_PARAMETRO_PORTE_AUTORIZZAZIONE_AUTENTICAZIONE_SOGGETTI = "Autorizzazione Puntuale";//"Soggetti Autenticati";
	public final static String LABEL_PARAMETRO_PORTE_AUTORIZZAZIONE_RUOLI = "Autorizzazione per Ruoli";
	public final static String LABEL_PARAMETRO_PORTE_AUTORIZZAZIONE_SCOPE = "Autorizzazione per Scope";
	public final static String LABEL_PARAMETRO_PORTE_AUTORIZZAZIONE_TOKEN_SUBTITLE = "Autorizzazione per Token Claims";
	public final static String LABEL_PARAMETRO_PORTE_AUTORIZZAZIONE_TOKEN = "Claims";
	public final static String LABEL_PARAMETRO_PORTE_AUTORIZZAZIONE_TOKEN_NOTE = "Indicare per riga i claims richiesti (nome=valore); è possibile elencare differenti valori ammissibili separandoli con la virgola";
	public final static String LABEL_PARAMETRO_AUTORIZZAZIONE_CONTENUTI = "Tipo";
	public final static String LABEL_PARAMETRO_CORRELAZIONE_APPLICATIVA = "Correlazione Applicativa";
	public final static String LABEL_PARAMETRO_CORRELAZIONE_APPLICATIVA_RICHIESTA = "Regole";
	public final static String LABEL_PARAMETRO_CORRELAZIONE_APPLICATIVA_RISPOSTA = "Regole";
	public final static String LABEL_PARAMETRO_SCADENZA_CORRELAZIONE_APPLICATIVA_LABEL = "Scadenza (minuti)";
	public final static String LABEL_PARAMETRO_SCADENZA_CORRELAZIONE_APPLICATIVA_NOTE = "Definisce una scadenza per il riuso del solito ID Protocollo";
	public final static String LABEL_PARAMETRO_SERVICE_BINDING_API = "Tipo API";
	public final static String LABEL_PARAMETRO_STATO_PACKAGE = "Stato";
	public final static String LABEL_PARAMETRO_SERVICE_BINDING = "Tipo";
	public final static String LABEL_PARAMETRO_SERVICE_BINDING_SOAP = "Soap";
	public final static String LABEL_PARAMETRO_SERVICE_BINDING_REST = "Rest";
	public final static String LABEL_PARAMETRO_SERVICE_BINDING_QUALSIASI = CostantiControlStation.LABEL_QUALSIASI;
	public final static String LABEL_PARAMETRO_HTTP_METHOD_QUALSIASI = CostantiControlStation.LABEL_QUALSIASI;
	public final static String LABEL_PARAMETRO_HTTP_METHOD_COMPACT = "Method";
	public final static String LABEL_PARAMETRO_HTTP_METHOD = "HTTP Method";
	public final static String LABEL_PARAMETRO_MESSAGE_TYPE = "Tipo Messaggio";
	public final static String LABEL_PARAMETRO_MESSAGE_TYPE_DEFAULT = "Default";
	public final static String LABEL_PARAMETRO_MESSAGE_TYPE_SOAP_11 = "Soap 1.1";
	public final static String LABEL_PARAMETRO_MESSAGE_TYPE_SOAP_12 = "Soap 1.2";
	public final static String LABEL_PARAMETRO_MESSAGE_TYPE_XML = "Xml";
	public final static String LABEL_PARAMETRO_MESSAGE_TYPE_JSON = "Json";
	public final static String LABEL_PARAMETRO_MESSAGE_TYPE_BINARY = "Binary";
	public final static String LABEL_PARAMETRO_MESSAGE_TYPE_MIME_MULTIPART = "MIME-Multipart";
	public final static String LABEL_PARAMETRO_INTERFACE_TYPE = "Formato Specifica";
	public final static String LABEL_PARAMETRO_INTERFACE_TYPE_WSDL_11 = "Wsdl 1.1";
	public final static String LABEL_PARAMETRO_INTERFACE_TYPE_WADL = "Wadl";
	public final static String LABEL_PARAMETRO_INTERFACE_TYPE_SWAGGER_2 = "Swagger 2.0";
	public final static String LABEL_PARAMETRO_INTERFACE_TYPE_OPEN_API_3 = "Open API 3.0";
	public final static String LABEL_PARAMETRO_SCHEMI_XSD = "Schemi XSD";
	public final static String LABEL_PARAMETRO_REGISTRO_OPENSPCOOP = "Registro API";
	public static final String LABEL_PATTERN = "Pattern";
	public static final String LABEL_PORTA_APPLICATIVA_CON_PARAMETRI = "Porta Applicativa {0}";
	public static final String LABEL_PORTA_DELEGATA_CON_PARAMETRI = "Porta Delegata {0}";
	public static final String LABEL_NON_DEFINITO = "Non definito";
	public static final String LABEL_PARAMETRO_AZIONE = "Azione";
	public final static String LABEL_PARAMETRO_AZIONI = "Azioni";
	public final static String LABEL_PARAMETRO_AZIONI_CONFIG_DI = "Azioni di ";
	public static final String LABEL_PARAMETRO_RISORSA = "Risorsa";
	public final static String LABEL_PARAMETRO_RISORSE = "Risorse";
	public final static String LABEL_PARAMETRO_RISORSE_CONFIG_DI = "Risorse di ";
	public final static String LABEL_PARAMETRO_PORTE_NOME_GRUPPO = "Nome Gruppo";
	public final static String LABEL_DEL_GRUPPO = " del gruppo ";
	public final static String LABEL_PARAMETRO_PORTA_AZIONE_MODALITA = "Modalità Identificazione Azione";
	public final static String LABEL_PARAMETRO_PORTA_RISORSA_MODALITA = "Modalità Identificazione Risorsa";
	public final static String LABEL_PARAMETRO_PORTA_QUALSIASI_AZIONE = "Tutte le azioni del servizio";
	public final static String LABEL_PARAMETRO_PORTA_QUALSIASI_RISORSA = "Tutte le risorse del servizio";
	public final static String LABEL_PARAMETRO_PORTA_ABILITATO_TOOLTIP = "Configurazione abilitata (Clicca per disabilitare)";
	public final static String LABEL_PARAMETRO_PORTA_DISABILITATO_TOOLTIP = "Configurazione disabilitata (Clicca per abilitare)";
	public final static String LABEL_PARAMETRO_PORTA_CONFERMA_ABILITAZIONE_CONFIG_DI = "Conferma abilitazione di ";
	public final static String LABEL_PARAMETRO_PORTA_CONFERMA_DISABILITAZIONE_CONFIG_DI = "Conferma disabilitazione di ";
	public final static String LABEL_PARAMETRO_DEFAULT_ALL_AZIONI_RIDEFINITE_TOOLTIP = "Tutte le azioni sono state riassegnate";
	public final static String LABEL_PARAMETRO_DEFAULT_ALL_RISORSE_RIDEFINITE_TOOLTIP = "Tutte le risorse sono state riassegnate";
	public final static String LABEL_AGGIUNTA_AZIONI_COMPLETATA = "Tutti le azioni disponibili sono già state riassegnate in un gruppo";
	public final static String LABEL_AGGIUNTA_RISORSE_COMPLETATA = "Tutti le risorse disponibili sono già state riassegnate in un gruppo";
	public final static String LABEL_TUTTE_AZIONI_DEFAULT = "Tutte le azioni dell'API";
	public final static String LABEL_TUTTE_RISORSE_DEFAULT = "Tutte le risorse dell'API";
	public final static String LABEL_PARAMETRO_SOGGETTO = "Soggetto";
	public final static String LABEL_PARAMETRO_SOGGETTI = "Soggetti";
	public final static String LABEL_PARAMETRO_PORTE_STATO = "Stato";
	public final static String LABEL_PARAMETRO_PORTE_ACCETTA_MTOM = "Accetta MTOM";
	public final static String LABEL_PARAMETRO_PORTE_TIPO = "Tipo";
	public final static String LABEL_PARAMETRO_PORTE_TIPO_VALIDAZIONE = "Tipo Validazione";
	public final static String LABEL_PARAMETRO_PORTE_VALIDAZIONE_CONTENUTI = "Validazione";
	public final static String LABEL_PARAMETRO_PORTE_VALIDAZIONE_CONTENUTI_CONFIG_DI = "Validazione di ";
	public final static String LABEL_PORTE_CORRELAZIONE_APPLICATIVA_ATTENZIONE = "Attenzione";
	private final static String LABEL_PORTE_CORRELAZIONE_APPLICATIVA_ATTENZIONE_MESSAGGIO_PARAM = "LUNGHEZZA_CARATTERI";
	private final static String LABEL_PORTE_CORRELAZIONE_APPLICATIVA_ATTENZIONE_MESSAGGIO = "L'identificativo applicativo estratto deve possedere una lunghezza non superiore ai "+LABEL_PORTE_CORRELAZIONE_APPLICATIVA_ATTENZIONE_MESSAGGIO_PARAM+" caratteri";
	public final static String getLABEL_PORTE_CORRELAZIONE_APPLICATIVA_ATTENZIONE_MESSAGGIO(int lenght) {
		return LABEL_PORTE_CORRELAZIONE_APPLICATIVA_ATTENZIONE_MESSAGGIO.replace(LABEL_PORTE_CORRELAZIONE_APPLICATIVA_ATTENZIONE_MESSAGGIO_PARAM, lenght+"");
	}
	public final static String LABEL_PORTE_CORRELAZIONE_APPLICATIVA_QUALSIASI = "Qualsiasi";
	public final static String LABEL_CONFIGURAZIONE_INCOMPLETA_LABEL = "Attenzione";
	public final static String LABEL_CONFIGURAZIONE_INCOMPLETA = "Configurazione della sicurezza incompleta";
	public final static String LABEL_CONFIGURAZIONE_PROPERTIES_PROCEDI = "Procedi con la configurazione";
	public final static String LABEL_CONFIGURAZIONE_PROPERTIES_COMPLETA = "Completa la configurazione";
	public final static String LABEL_CONFIGURAZIONE_PROPERTIES = "Configurazione";
	public final static String LABEL_CONFIGURAZIONE_PROPERTIES_CONFIGURAZIONE_MANUALE = "Configurazione Manuale";
	public final static String LABEL_PARAMETRO_PORTE_GESTIONE_TOKEN = "Stato";
	public final static String LABEL_PARAMETRO_PORTE_GESTIONE_TOKEN_POLICY = "Policy";
	public final static String LABEL_PARAMETRO_PORTE_GESTIONE_TOKEN_OPZIONALE = "Token Opzionale";
	public final static String LABEL_PARAMETRO_PORTE_GESTIONE_TOKEN_VALIDAZIONE_INPUT = "Validazione JWT";
	public final static String LABEL_PARAMETRO_PORTE_GESTIONE_TOKEN_INTROSPECTION = "Introspection";
	public final static String LABEL_PARAMETRO_PORTE_GESTIONE_TOKEN_USERINFO = "User Info";
	public final static String LABEL_PARAMETRO_PORTE_GESTIONE_TOKEN_TOKEN_FORWARD = "Token Forward";
	public final static String LABEL_PARAMETRO_PORTE_ELEMENTO_XML = "Elemento";
	
	public final static String LABEL_QUALSIASI = "Qualsiasi";
	public final static String LABEL_DEFAULT = "Default";
	public final static String LABEL_NESSUNO = "Nessuno";
	public final static String LABEL_ABILITATO = "Abilitato";
	public final static String LABEL_SI = "Si";
	public final static String LABEL_NO = "No";
	public final static String LABEL_SOAP_11 = "SOAP 1.1";
	public final static String LABEL_SOAP_12 = "SOAP 1.2";
		
	public final static String LABEL_DUMP = "Dump";
	public final static String LABEL_REGISTRAZIONE_MESSAGGI = "Registrazione Messaggi";
	public final static String LABEL_REGISTRAZIONE_MESSAGGI_CONFIG_DI = "Registrazione Messaggi di ";
	public final static String LABEL_DUMP_CONFIGURAZIONE = "Configurazione";
	
	public final static String LABEL_PARAMETRO_DUMP_STATO = "Stato";
	public final static String LABEL_PARAMETRO_DUMP_STATO_DEFAULT = "default";
	public final static String LABEL_PARAMETRO_DUMP_STATO_RIDEFINITO = "ridefinito";
	public final static String LABEL_PARAMETRO_DUMP_REALTIME = "Realtime";
	public final static String LABEL_PARAMETRO_DUMP_RICHIESTA_STATO = "Stato";
	public final static String LABEL_PARAMETRO_DUMP_RISPOSTA_STATO = "Stato";
	public final static String LABEL_PARAMETRO_DUMP_RICHIESTA_INGRESSO_BODY = "Body";
	public final static String LABEL_PARAMETRO_DUMP_RICHIESTA_INGRESSO_ATTACHMENTS = "Attachments";
	public final static String LABEL_PARAMETRO_DUMP_RICHIESTA_INGRESSO_HEADERS = "Headers";
	public final static String LABEL_PARAMETRO_DUMP_RICHIESTA_USCITA_BODY = "Body";
	public final static String LABEL_PARAMETRO_DUMP_RICHIESTA_USCITA_ATTACHMENTS = "Attachments";
	public final static String LABEL_PARAMETRO_DUMP_RICHIESTA_USCITA_HEADERS = "Headers";
	public final static String LABEL_PARAMETRO_DUMP_RISPOSTA_INGRESSO_BODY = "Body";
	public final static String LABEL_PARAMETRO_DUMP_RISPOSTA_INGRESSO_ATTACHMENTS = "Attachments";
	public final static String LABEL_PARAMETRO_DUMP_RISPOSTA_INGRESSO_HEADERS = "Headers";
	public final static String LABEL_PARAMETRO_DUMP_RISPOSTA_USCITA_BODY = "Body";
	public final static String LABEL_PARAMETRO_DUMP_RISPOSTA_USCITA_ATTACHMENTS = "Attachments";
	public final static String LABEL_PARAMETRO_DUMP_RISPOSTA_USCITA_HEADERS = "Headers";

	public final static String LABEL_PARAMETRO_DUMP_SEZIONE_GENERALE = "Generale";
	public final static String LABEL_PARAMETRO_DUMP_SEZIONE_RICHIESTA = "Richiesta";
	public final static String LABEL_PARAMETRO_DUMP_SEZIONE_RISPOSTA = "Risposta";
	public final static String LABEL_PARAMETRO_DUMP_SEZIONE_INGRESSO = "Ingresso";
	public final static String LABEL_PARAMETRO_DUMP_SEZIONE_USCITA = "Uscita";
	public static final String LABEL_REGISTRAZIONE_MESSAGGI_MODIFICATA_CON_SUCCESSO = "Configurazione Registrazione Messaggi modificata con successo";
	
	public final static String LABEL_PARAMETRO_REQUEST_FLOW_PROPERTIES_CONFIG_NAME = "Schema Sicurezza";
	public final static String LABEL_PARAMETRO_RESPONSE_FLOW_PROPERTIES_CONFIG_NAME = "Schema Sicurezza";
	public final static String LABEL_PARAMETRO_PROPERTIES_CONFIG_NAME = "Nome";
	public final static String LABEL_PARAMETRO_DOCUMENTO_SICUREZZA_XACML_POLICY = "Policy";
	public final static String LABEL_PARAMETRO_DOCUMENTO_SICUREZZA_XACML_NUOVA_POLICY = "Nuova";
	public final static String LABEL_AGGIORNAMENTO_DOCUMENTO_SICUREZZA_XACML_POLICY = "Modifica Policy";
	public final static String LABEL_DOWNLOAD_DOCUMENTO_SICUREZZA_XACML_POLICY = "Download Policy Attuale";

	public static final String LABEL_SICUREZZA_MESSAGGIO_STATO = "Sicurezza Messaggio (Stato)";
	public static final String LABEL_SICUREZZA_MESSAGGIO_SCHEMA_RICHIESTA = "Schema Sicurezza (Richiesta)";
	public static final String LABEL_SICUREZZA_MESSAGGIO_SCHEMA_RISPOSTA = "Schema Sicurezza (Risposta)";
	public static final String LABEL_SICUREZZA_MESSAGGIO_SCHEMA_NESSUNO = "Nessuno";
	public static final String LABEL_SICUREZZA_MESSAGGIO_SCHEMA_CONFIGURAZIONE_MANUALE = "Configurazione Manuale";
	public static final String VALUE_SICUREZZA_MESSAGGIO_SCHEMA_DEFAULT = "default";
	
	public final static String LABEL_CONFIGURAZIONE_CORS = "Gestione CORS";
	public final static String LABEL_CONFIGURAZIONE_CORS_ACCESS_CONTROL = "Access Control";
	public final static String LABEL_CONFIGURAZIONE_CORS_DI = "Gestione CORS di ";
	
	public final static String LABEL_CONFIGURAZIONE_VERIFICA_CONNETTORE_BOTTONE = "Verifica";
	public final static String LABEL_CONFIGURAZIONE_CONNETTIVITA = "Connettività";
	public final static String LABEL_CONFIGURAZIONE_VERIFICA_CONNETTORE_TITLE = "Verifica Connettività";
	public final static String LABEL_CONFIGURAZIONE_VERIFICA_CONNETTORE = "Verifica Connettività Connettore";
	public final static String LABEL_CONFIGURAZIONE_VERIFICA_CONNETTORE_DI = LABEL_CONFIGURAZIONE_VERIFICA_CONNETTORE+" di ";
	public final static String LABEL_CONFIGURAZIONE_VERIFICA_CONNETTORE_EFFETTUATO_CON_SUCCESSO = "Test di connettività effettuato con successo";
	public final static String LABEL_CONFIGURAZIONE_VERIFICA_CONNETTORE_FALLITA = "Test di connettività fallito: ";
	public final static String LABEL_VERIFICA_CONNETTORE_VALORE_LINK = "verifica";
	public final static String LABEL_VERIFICA_CONNETTORE_TUTTI_I_NODI = "Verifica su tutti i nodi";
	
	public final static String LABEL_CONFIGURAZIONE_RESPONSE_CACHING = "Caching Risposta";
	public final static String LABEL_CONFIGURAZIONE_RESPONSE_CACHING_DI = "Caching Risposta di ";
	
	public final static String LABEL_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLE = "Regole di Caching Risposta";
	public final static String LABEL_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLE_DI = "Regole di Caching Risposta di";
	
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CORS_STATO = "Stato";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CORS_TIPO = "Tipo";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CORS_TIPO_GESTITO_GATEWAY ="Gestito dal Gateway";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CORS_TIPO_GESTITO_APPLICATIVO = "Gestito dall'Applicativo";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CORS_ALL_ALLOW_ORIGINS = "All Allow Origins";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CORS_ALLOW_ORIGINS = "Allow Origins";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CORS_ALLOW_HEADERS = "Allow Request Headers";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CORS_ALLOW_METHODS = "Allow Methods";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CORS_ALLOW_CREDENTIALS = "Allow Credentials";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CORS_EXPOSE_HEADERS = "Expose Response Headers";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CORS_MAX_AGE = "Max Age";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CORS_MAX_AGE_SECONDS = "Max Age Seconds";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CORS_MAX_AGE_SECONDS_NOTE = "Utilizza il valore -1 per disabilitare il caching";
	
	public final static String LABEL_PARAMETRO_CORS_STATO_PORTA = "Stato";
	public final static String LABEL_PARAMETRO_CORS_STATO_PORTA_DEFAULT = "default";
	public final static String LABEL_PARAMETRO_CORS_STATO_PORTA_RIDEFINITO = "ridefinito";
	public static final String LABEL_GESTIONE_CORS_MODIFICATA_CON_SUCCESSO = "Configurazione CORS modificata con successo";
	public static final String LABEL_CONFIGURAZIONE_RESPONSE_CACHING_GENERAZIONE_HASH = "Generazione Hash";
	
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_STATO = "Stato";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_TIMEOUT = "Cache Timeout (secondi)";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_MAX_RESPONSE_SIZE = "Dimensione Max Risposta";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_MAX_RESPONSE_SIZE_BYTES = "Dimensione Max (kb)";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_RESPONSE_DIGEST_URI_INVOCAZIONE = "URL di Richiesta";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_RESPONSE_DIGEST_HEADERS = "Headers";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_RESPONSE_DIGEST_HEADERS_NOMI_HEADERS = "Headers";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_RESPONSE_DIGEST_PAYLOAD = "Payload";
	public static final String LABEL_GESTIONE_RESPONSE_CACHING_MODIFICATA_CON_SUCCESSO = "Configurazione Response Caching modificata con successo";
	public final static String LABEL_PARAMETRO_RESPONSE_CACHING_STATO_PORTA = "Stato";
	public final static String LABEL_PARAMETRO_RESPONSE_CACHING_STATO_PORTA_DEFAULT = "default";
	public final static String LABEL_PARAMETRO_RESPONSE_CACHING_STATO_PORTA_RIDEFINITO = "ridefinito";
	public final static String LABEL_CONFIGURAZIONE_RESPONSE_CACHING_CACHE_CONTROL = "Cache Control";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CACHE_CONTROL_NO_CACHE = "No Cache";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CACHE_CONTROL_MAX_AGE = "Max Age";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CACHE_CONTROL_NO_STORE = "No Store";
	public final static String NOTE_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_RESPONSE_DIGEST_HEADERS_NOMI_HEADERS = "Indicare gli Headers da utilizzare per il calcolo dell'Hash";
	
	public final static String LABEL_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIOME_AVANZATA = "Configurazione Avanzata";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA = "Regola";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLE = "Regole";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_MIN = "Min";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_MAX = "Max";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE = "Return Code";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_FAULT = "Fault";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_CACHE_TIMEOUT_SECONDS = "Cache Timeout (Secondi)";
	
	public final static String LABEL_CONFIGURAZIONE_TRASFORMAZIONI = "Trasformazioni";
	public final static String LABEL_CONFIGURAZIONE_TRASFORMAZIONI_DI = "Trasformazioni di ";
	public final static String LABEL_CONFIGURAZIONE_TRASFORMAZIONI_REGOLE_TRASFORMAZIONE = "Regole di Trasformazione";
	public final static String LABEL_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA = "Applicabilit&agrave;";
	public final static String LABEL_CONFIGURAZIONE_TRASFORMAZIONI_TRASFORMAZIONE = "Trasformazione";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA = "Richiesta";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTE = "Risposte";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTE_DI = "Risposte di ";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA = "Risposta";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_HEADERS = "HTTP Headers";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_HEADERS_DI = "HTTP Headers di ";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_HEADER = "HTTP Header";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_HEADER = "HTTP Header";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_HEADERS = "HTTP Headers";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_HEADERS_DI = "HTTP Headers di ";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_PARAMETRI = "URL Parameters";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_PARAMETRI_DI = "URL Parameters di ";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_PARAMETRO = "URL Parameter";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_TRASPORTO = "Trasporto";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_CONTENUTO = "Contenuto";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_SOAP = "Trasformazione SOAP";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_REST = "Trasformazione Rest";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_TRASPORTO = "Trasporto";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_CONTENUTO = "Contenuto";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_SOAP = "Trasformazione SOAP";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_REST = "Trasformazione Rest";
	
	
	public final static String LABEL_PARAMETRO_ID_CONFIGURAZIONE_TRASFORMAZIONE = "Id";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_POSIZIONE = "";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_NOME = "Nome";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_RISORSE = "Risorse";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_AZIONI = "Azioni";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_AZIONI_ALL_VALUE_TRUE = "Qualsiasi";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_AZIONI_ALL_VALUE_FALSE = "Azioni selezionate";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_RISORSE_ALL_VALUE_FALSE = "Risorse selezionate";
	public final static String [] LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_AZIONI_ALL_VALUES = new String [] {
			LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_AZIONI_ALL_VALUE_TRUE,
			LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_AZIONI_ALL_VALUE_FALSE
	};
	public final static String [] LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_RISORSE_ALL_VALUES = new String [] {
			LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_AZIONI_ALL_VALUE_TRUE,
			LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_RISORSE_ALL_VALUE_FALSE
	};
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_CT = "Content Type";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_PATTERN = "Pattern";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_REQ_CONVERSIONE_ENABLED = "Abilitato";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_REQ_CONVERSIONE_TIPO = "Tipo Conversione";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_REQ_CONVERSIONE_TEMPLATE = "Template";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_REQ_CONTENT_TYPE = "Content Type";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_REST_TRANSFORMATION = "Abilitato";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_REST_METHOD = "HTTP Method";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_REST_PATH = "Path";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_TRANSFORMATION = "Abilitato";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_VERSION = "Versione";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ACTION = "SOAP Action";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE = "Imbustamento SOAP";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_AS_ATTACH = "Attachment";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_TITLE_BODY = "SOAP Body";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_TIPO = "Tipo Conversione";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_TEMPLATE = "Template";
	
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_APPLICABILITA_STATUS = "Status";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_APPLICABILITA_STATUS_MIN = "Min";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_APPLICABILITA_STATUS_MAX = "Max";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_APPLICABILITA_CT = "Content Type";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_APPLICABILITA_PATTERN = "Pattern";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_CONVERSIONE_ENABLED = "Abilitato";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_CONVERSIONE_TIPO = "Tipo Conversione";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_CONVERSIONE_TEMPLATE = "Template";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_CONTENT_TYPE = "Content Type";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_RETURN_CODE = "Return Code";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_SOAP_TRANSFORMATION = "Abilitato";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_SOAP_ENVELOPE = "Imbustamento SOAP";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_SOAP_ENVELOPE_AS_ATTACH = "Attachment";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_SOAP_ENVELOPE_TITLE_BODY = "SOAP Body";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_SOAP_ENVELOPE_TIPO = "Tipo Conversione";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_SOAP_ENVELOPE_TEMPLATE = "Template";
	
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_HEADER_VALORE = "Valore";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_HEADER_NOME = "Nome";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_HEADER_TIPO = "Operazione";
	
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_HEADER_VALORE = "Valore";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_HEADER_NOME = "Nome";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_HEADER_TIPO = "Operazione";
	
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_PARAMETRO_VALORE = "Valore";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_PARAMETRO_NOME = "Nome";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_PARAMETRO_TIPO = "Operazione";
	
	/** PARAMETERS **/
	
	public final static String PARAMETRO_ID = "id";
	public final static String PARAMETRO_ID_SOGGETTO = "idsogg";
	public final static String PARAMETRO_ID_PORTA = "idPorta";
	public final static String PARAMETRO_ID_ASPS = "idAsps";
	public final static String PARAMETRO_ID_FRUIZIONE = "myId";
	public final static String PARAMETRO_NOME = "nome";
	public final static String PARAMETRO_NOME_PORTA = "nomePorta";
	public final static String PARAMETRO_SERVIZIO_APPLICATIVO = "servizioApplicativo";
	public final static String PARAMETRO_VALORE = "valore";
	public final static String PARAMETRO_PROTOCOLLO = "protocollo";
	public final static String PARAMETRO_ACCESSO_DA_CHANGE = "accessoDaChange";
	public final static String PARAMETRO_MESSAGE_SECURITY = "messageSecurity";
	public final static String PARAMETRO_MTOM_RICHIESTA = "mtomReq";
	public final static String PARAMETRO_MTOM_RISPOSTA = "mtomRes";
	public final static String PARAMETRO_OBBLIGATORIO = "obbl";
	public final static String PARAMETRO_CONTENT_TYPE = "contentT";
	public final static String PARAMETRO_PATTERN = "pattern";
	public final static String PARAMETRO_APPLICA_MTOM_RICHIESTA = "applicaMTOMReq";
	public final static String PARAMETRO_APPLICA_MTOM_RISPOSTA = "applicaMTOMRes";
	public final static String PARAMETRO_USAIDSOGG = "usaidsogg";
	public final static String PARAMETRO_EXTENDED_FORM_ID = "extendedFormUniqueId";
	public final static String PARAMETRO_CONTENT_DISPOSITION = "Content-Disposition";
	public final static String PREFIX_CONTENT_DISPOSITION = "form-data; name=\"";
	public final static String SUFFIX_CONTENT_DISPOSITION = "\"";
	public final static String PREFIX_FILENAME = "filename=\"";
	public final static String SUFFIX_FILENAME = "\"";
	public final static String PARAMETRO_RUOLO = "ruolo";
	public final static String PARAMETRO_RUOLO_TIPOLOGIA = "ruoloTipologia";
	public final static String PARAMETRO_RUOLO_MATCH = "ruoloMatch";
	public final static String PARAMETRO_SCOPE = "scope";
	public final static String PARAMETRO_SCOPE_MATCH = "scopeMatch";
	public final static String PARAMETRO_PORTE_CONTROLLO_ACCESSI_STATO = "controlloAccessiStato";
	public final static String PARAMETRO_PORTE_AUTENTICAZIONE = "autenticazione";
	public final static String PARAMETRO_PORTE_AUTENTICAZIONE_PRINCIPAL_TIPO = "autenticazionePrincipalTipo";
	public final static String PARAMETRO_PORTE_AUTENTICAZIONE_PARAMETRO_LIST = "autenticazioneParametro";
	public final static String PARAMETRO_PORTE_AUTENTICAZIONE_CUSTOM = "autenticazioneCustom";
	public final static String PARAMETRO_PORTE_AUTENTICAZIONE_OPZIONALE = "autenticazioneOpzionale";
	public final static String PARAMETRO_PORTE_AUTENTICAZIONE_TOKEN_ISSUER = "autenticazioneIssuer";
	public final static String PARAMETRO_PORTE_AUTENTICAZIONE_TOKEN_CLIENT_ID = "autenticazioneClientId";
	public final static String PARAMETRO_PORTE_AUTENTICAZIONE_TOKEN_SUBJECT = "autenticazioneSubject";
	public final static String PARAMETRO_PORTE_AUTENTICAZIONE_TOKEN_USERNAME = "autenticazioneUsername";
	public final static String PARAMETRO_PORTE_AUTENTICAZIONE_TOKEN_MAIL = "autenticazioneEMail";
	public final static String PARAMETRO_PORTE_AUTORIZZAZIONE = "autorizzazione";
	public final static String PARAMETRO_PORTE_AUTORIZZAZIONE_CUSTOM = "autorizzazioneCustom";
	public final static String PARAMETRO_PORTE_AUTORIZZAZIONE_AUTENTICAZIONE = "autorizzazioneAutenticazione";
	public final static String PARAMETRO_PORTE_AUTORIZZAZIONE_RUOLI = "autorizzazioneRuoli";
	public final static String PARAMETRO_PORTE_AUTORIZZAZIONE_SCOPE = "autorizzazioneScope";
	public final static String PARAMETRO_PORTE_AUTORIZZAZIONE_TOKEN = "autorizzazioneToken";
	public final static String PARAMETRO_PORTE_AUTORIZZAZIONE_TOKEN_OPTIONS = "autorizzazioneTokenOptions";
	public final static String PARAMETRO_PORTE_TRACCIAMENTO_ESITO = "portaEsiti";
	public final static String PARAMETRO_AUTORIZZAZIONE_CONTENUTI = "autorizzazioneContenuti";
	public final static String PARAMETRO_SCADENZA_CORRELAZIONE_APPLICATIVA = "scadcorr";
	public final static String PARAMETRO_APPLICA_MODIFICA = "applicaMod";
	public final static String PARAMETRO_SOGGETTO = "soggt";
	public final static String PARAMETRO_SERVIZIO_APPLICATIVO_AUTORIZZATO = "saAuthz";
	public final static String PARAMETRO_PORTE_TIPO_VALIDAZIONE = "tipo_validazione";
	public final static String PARAMETRO_PORTE_XSD = "xsd";
	public final static String PARAMETRO_PORTE_APPLICA_MTOM = PARAMETRO_APPLICA_MTOM_RICHIESTA;
	public final static String PARAMETRO_PROVIDER = "provider";
	public final static String PARAMETRO_CONTROLLO_FIRST_TIME = "paramFirstTime";
	public final static String PARAMETRO_PORTE_GESTIONE_TOKEN = "gestioneToken";
	public final static String PARAMETRO_PORTE_GESTIONE_TOKEN_POLICY = "gtPolicy";
	public final static String PARAMETRO_PORTE_GESTIONE_TOKEN_OPZIONALE = "gtOpzionale";
	public final static String PARAMETRO_PORTE_GESTIONE_TOKEN_VALIDAZIONE_INPUT = "gtValidazione";
	public final static String PARAMETRO_PORTE_GESTIONE_TOKEN_INTROSPECTION = "gtIntrospection";
	public final static String PARAMETRO_PORTE_GESTIONE_TOKEN_USERINFO = "gtUserInfo";
	public final static String PARAMETRO_PORTE_GESTIONE_TOKEN_TOKEN_FORWARD = "gtTokenForward";
	public final static String PARAMETRO_DOCUMENTO_SICUREZZA_XACML_POLICY = "docSicXacmlPol";
	
	public final static String PARAMETRO_RESET_SEARCH = "resetSearch";
	
	public final static String PARAMETRO_SERVICE_BINDING = "serviceBinding";
	public final static String PARAMETRO_SERVICE_BINDING_SEARCH = "serviceBindingSearch";
	public final static String PARAMETRO_MESSAGE_TYPE = "messageType";
	public final static String PARAMETRO_INTERFACE_TYPE = "interfaceType";
		
	public final static String PARAMETRO_ELEMENTO_XML = "elemxml";
	public final static String PARAMETRO_MODE_CORRELAZIONE_APPLICATIVA = "mode";
	public final static String PARAMETRO_ID_CORRELAZIONE= "idcorr";
		
	public final static String ATTRIBUTO_CONFIGURAZIONE_PARENT = "portaPar";
	public final static int ATTRIBUTO_CONFIGURAZIONE_PARENT_NONE = 0;
	public final static int ATTRIBUTO_CONFIGURAZIONE_PARENT_SOGGETTO = 1;
	public final static int ATTRIBUTO_CONFIGURAZIONE_PARENT_CONFIGURAZIONE = 2;
	
	public final static String PARAMETRO_AZIONE = "azione";
	public final static String PARAMETRO_AZIONI = "azioni";
	public final static int RIGHE_MULTISELECT_AZIONI = 10;
	public final static String PARAMETRO_NOME_GRUPPO = "nomeGruppo";
	
	public final static String PARAMETRO_DUMP_STATO = "dumpStato";
	public final static String PARAMETRO_DUMP_REALTIME = "dumpRealTime";
	public final static String PARAMETRO_DUMP_RICHIESTA_STATO = "dumpStatoReq";
	public final static String PARAMETRO_DUMP_RISPOSTA_STATO = "dumpStatoRes";
	public final static String PARAMETRO_DUMP_RICHIESTA_INGRESSO_BODY = "dumpReqInBody";
	public final static String PARAMETRO_DUMP_RICHIESTA_INGRESSO_ATTACHMENTS = "dumpReqInAtt";
	public final static String PARAMETRO_DUMP_RICHIESTA_INGRESSO_HEADERS = "dumpReqInHead";
	public final static String PARAMETRO_DUMP_RICHIESTA_USCITA_BODY = "dumpReqOutBody";
	public final static String PARAMETRO_DUMP_RICHIESTA_USCITA_ATTACHMENTS = "dumpReqOutAtt";
	public final static String PARAMETRO_DUMP_RICHIESTA_USCITA_HEADERS = "dumpReqOutHead";
	public final static String PARAMETRO_DUMP_RISPOSTA_INGRESSO_BODY = "dumpResInBody";
	public final static String PARAMETRO_DUMP_RISPOSTA_INGRESSO_ATTACHMENTS = "dumpResInAtt";
	public final static String PARAMETRO_DUMP_RISPOSTA_INGRESSO_HEADERS = "dumpResInHead";
	public final static String PARAMETRO_DUMP_RISPOSTA_USCITA_BODY = "dumpResOutBody";
	public final static String PARAMETRO_DUMP_RISPOSTA_USCITA_ATTACHMENTS = "dumpResOutAtt";
	public final static String PARAMETRO_DUMP_RISPOSTA_USCITA_HEADERS = "dumpResOutHead";
	
	public final static String PARAMETRO_REQUEST_FLOW_PROPERTIES_CONFIG_NAME = "propertiesConfigNameReq";
	public final static String PARAMETRO_RESPONSE_FLOW_PROPERTIES_CONFIG_NAME = "propertiesConfigNameRes";
	public final static String PARAMETRO_PROPERTIES_CONFIG_NAME = "propertiesConfigName";
	
	public final static String PARAMETRO_CONFIGURAZIONE_CORS_STATO = "corsStato";
	public final static String PARAMETRO_CONFIGURAZIONE_CORS_TIPO = "corsTipo";
	public final static String PARAMETRO_CONFIGURAZIONE_CORS_ALL_ALLOW_ORIGINS= "corsAAllOrig";
	public final static String PARAMETRO_CONFIGURAZIONE_CORS_ALLOW_ORIGINS = "corsAllOrig";
	public final static String PARAMETRO_CONFIGURAZIONE_CORS_ALLOW_HEADERS = "corsAllHead";
	public final static String PARAMETRO_CONFIGURAZIONE_CORS_ALLOW_METHODS = "corsAllMeth";
	public final static String PARAMETRO_CONFIGURAZIONE_CORS_ALLOW_CREDENTIALS = "corsAllCred";
	public final static String PARAMETRO_CONFIGURAZIONE_CORS_EXPOSE_HEADERS = "corsExpHead";
	public final static String PARAMETRO_CONFIGURAZIONE_CORS_MAX_AGE = "corsMaxAge";
	public final static String PARAMETRO_CONFIGURAZIONE_CORS_MAX_AGE_SECONDS = "corsMaxAgeSec";
	public final static String PARAMETRO_CONFIGURAZIONE_CORS_STATO_PORTA = "corsStatoPorta";
	
	public final static String PARAMETRO_VERIFICA_CONNETTORE_ID = "connettoreId";
	public final static String PARAMETRO_VERIFICA_CONNETTORE_ACCESSO_DA_GRUPPI = "connettoreAccessoDaGruppi";
	public final static String PARAMETRO_VERIFICA_CONNETTORE_REGISTRO = "connettoreRegistro";
	public final static String PARAMETRO_VERIFICA_CONNETTORE_NODO = "connettoreNodo";
	
	
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_STATO = "resCacheStato";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_TIMEOUT = "resCacheTimeout";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_MAX_RESPONSE_SIZE = "resCacheMaxResSize";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_MAX_RESPONSE_SIZE_BYTES = "resCacheMaxResSizeB";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_RESPONSE_DIGEST_URI_INVOCAZIONE = "resCacheDUri";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_RESPONSE_DIGEST_HEADERS = "resCacheDHead";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_RESPONSE_DIGEST_HEADERS_NOMI_HEADERS = "resCacheDHeadNomiH";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_RESPONSE_DIGEST_PAYLOAD = "resCacheDpay";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_STATO_PORTA = "resCacheStatoPorta";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CACHE_CONTROL_NO_CACHE = "resCacheCCNoC";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CACHE_CONTROL_MAX_AGE = "resCacheCCMA";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CACHE_CONTROL_NO_STORE = "resCacheCCNoS";
	
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_MIN = "resCacheCCRegMinCode";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_MAX = "resCacheCCRegMaxCode";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE = "resCacheCCRegCode";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_FAULT = "resCacheCCRegFault";
	public final static String PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_CACHE_TIMEOUT_SECONDS = "resCacheCCRegTimeout";
	
	
	public final static String PARAMETRO_ID_CONFIGURAZIONE_TRASFORMAZIONE = "idTrasf";
	public final static String PARAMETRO_ID_CONFIGURAZIONE_TRASFORMAZIONE_RISPOSTA = "idTrasfRes";
	public final static String PARAMETRO_ID_CONFIGURAZIONE_TRASFORMAZIONE_RICHIESTA_HEADER = "idTrasfReqHead";
	public final static String PARAMETRO_ID_CONFIGURAZIONE_TRASFORMAZIONE_RICHIESTA_PARAMETRO = "idTrasfReqParam";
	public final static String PARAMETRO_ID_CONFIGURAZIONE_TRASFORMAZIONE_RISPOSTA_HEADER = "idTrasfResHead";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_FIRST = "trFirst";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_NOME = "trNome";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_AZIONI_ALL = "trAppAzioniAll";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_AZIONI_ALL_VALUE_TRUE = Costanti.CHECK_BOX_ENABLED;
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_AZIONI_ALL_VALUE_FALSE = Costanti.CHECK_BOX_DISABLED;
	public final static String [] PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_AZIONI_ALL_VALUES = new String [] {
			PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_AZIONI_ALL_VALUE_TRUE,
			PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_AZIONI_ALL_VALUE_FALSE
	};
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_AZIONI = "trAppAzioni";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_CT = "trAppCT";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_APPLICABILITA_PATTERN = "trAppPat";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_REQ_CONVERSIONE_ENABLED = "trReqConvEn";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_REQ_CONVERSIONE_TIPO = "trReqConvTp";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_REQ_CONVERSIONE_TEMPLATE = "trReqConvTem";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_REQ_CONTENT_TYPE = "trReqCT";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_REST_TRANSFORMATION = "trRestTr";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_REST_METHOD = "trRestMet";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_REST_PATH = "trRestPath";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_TRANSFORMATION = "trSoapTr";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_VERSION = "trSoapVers";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ACTION = "trSoapAc";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE = "trSoapEnv";
//	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_AS_ATTACH = "trSoapEnvAsAt";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_TIPO = "trSoapTp";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_TEMPLATE = "trSoapEnvTemp";
	
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_APPLICABILITA_STATUS = "trResAppStat";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_APPLICABILITA_STATUS_MIN = "trResAppStatMin";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_APPLICABILITA_STATUS_MAX = "trResAppStatMax";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_APPLICABILITA_CT = "trResAppCT";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_APPLICABILITA_PATTERN = "trResAppPat";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_CONVERSIONE_ENABLED = "trResConvEn";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_CONVERSIONE_TIPO = "trResConvTp";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_CONVERSIONE_TEMPLATE = "trResConvTem";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_CONTENT_TYPE = "trResCT";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_RETURN_CODE = "trResRetCode";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_SOAP_TRANSFORMATION = "trResSoapTr";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_SOAP_ENVELOPE = "trResSoapEnv";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_SOAP_ENVELOPE_AS_ATTACH = "trResSoapEnvAsAt";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_SOAP_ENVELOPE_TIPO = "trResSoapTp";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_SOAP_ENVELOPE_TEMPLATE = "trResSoapEnvTemp";
	
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_HEADER_VALORE = "trResHeadVal";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_HEADER_NOME = "trResHeadNome";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RISPOSTA_HEADER_TIPO = "trResHeadTipo";
	
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_HEADER_VALORE = "trReqHeadVal";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_HEADER_NOME = "trReqHeadNome";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_HEADER_TIPO = "trReqHeadTipo";
	
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_PARAMETRO_VALORE = "trReqParVal";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_PARAMETRO_NOME = "trReqParNome";
	public final static String PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_PARAMETRO_TIPO = "trReqParTipo";
	
	/** PARAMETRI MESSAGE PAGE **/
	
	public static final String PARAMETER_MESSAGE_TEXT = Costanti.PARAMETER_MESSAGE_TEXT;
	public static final String PARAMETER_MESSAGE_TITLE = Costanti.PARAMETER_MESSAGE_TITLE;
	public static final String PARAMETER_MESSAGE_TYPE = Costanti.PARAMETER_MESSAGE_TYPE;
	public static final String PARAMETER_MESSAGE_BREADCRUMB = Costanti.PARAMETER_MESSAGE_BREADCRUMB;
	
	/** VALUES **/
	
	public final static String DEFAULT_VALUE_ABILITATO = "abilitato";
	public final static String DEFAULT_VALUE_DISABILITATO = "disabilitato";
	public final static String DEFAULT_VALUE_WARNING_ONLY = "warningOnly";
	public final static String DEFAULT_VALUE_PARAMETRO_MESSAGE_SECURITY_ABILITATO = "abilitato";
	public final static String DEFAULT_VALUE_PARAMETRO_MESSAGE_SECURITY_DISABILITATO = "disabilitato";
	public final static String DEFAULT_VALUE_PARAMETRO_MESSAGE_SECURITY_REQUEST_FLOW = "Request Flow";
	public final static String DEFAULT_VALUE_PARAMETRO_MESSAGE_SECURITY_RESPONSE_FLOW = "Response Flow";
	public final static String DEFAULT_VALUE_PARAMETRO_MTOM_DISABLE = "disable";
	public final static String DEFAULT_VALUE_PARAMETRO_MTOM_PACKAGING = "packaging";
	public final static String DEFAULT_VALUE_PARAMETRO_MTOM_UNPACKAGING = "unpackaging";
	public final static String DEFAULT_VALUE_PARAMETRO_MTOM_VERIFY = "verify";
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_AUTENTICAZIONE_CUSTOM =  "custom";
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_AUTORIZZAZIONE_CUSTOM = "custom";
	
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_VALIDAZIONE_DISABILITATO = CostantiConfigurazione.STATO_CON_WARNING_DISABILITATO.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_VALIDAZIONE_ABILITATO = CostantiConfigurazione.STATO_CON_WARNING_ABILITATO.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_VALIDAZIONE_WARNING_ONLY = CostantiConfigurazione.STATO_CON_WARNING_WARNING_ONLY.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_TIPO_VALIDAZIONE_XSD =  CostantiConfigurazione.VALIDAZIONE_CONTENUTI_APPLICATIVI_XSD.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_TIPO_VALIDAZIONE_INTERFACE = CostantiConfigurazione.VALIDAZIONE_CONTENUTI_APPLICATIVI_INTERFACE.toString();
	public final static String DEFAULT_VALUE_PARAMETRO_PORTE_TIPO_VALIDAZIONE_OPENSPCOOP = CostantiConfigurazione.VALIDAZIONE_CONTENUTI_APPLICATIVI_OPENSPCOOP.toString();
	
	public final static String DEFAULT_VALUE_PARAMETRO_SERVICE_BINDING_SOAP = "SOAP";
	public final static String DEFAULT_VALUE_PARAMETRO_SERVICE_BINDING_REST = "REST";
	public final static String DEFAULT_VALUE_PARAMETRO_SERVICE_BINDING_QUALSIASI = "";
	
	public final static String DEFAULT_VALUE_PARAMETRO_HTTP_METHOD_QUALSIASI = "";
	
	public final static String DEFAULT_VALUE_PARAMETRO_RUOLO_TIPOLOGIA_QUALSIASI = "";
	public final static String RUOLI_TIPOLOGIA_LABEL_INTERNO = "Registro";
	public final static String RUOLI_TIPOLOGIA_LABEL_ESTERNO = "Esterna";
	public final static String LABEL_PARAMETRO_RUOLO_TIPOLOGIA_QUALSIASI = CostantiControlStation.LABEL_QUALSIASI;
	
	public final static String DEFAULT_VALUE_PARAMETRO_RUOLO_CONTESTO_QUALSIASI = "";
	public final static String RUOLI_CONTESTO_UTILIZZO_LABEL_EROGAZIONE = "Erogazione";
	public final static String RUOLI_CONTESTO_UTILIZZO_LABEL_FRUIZIONE = "Fruizione";
	public final static String LABEL_PARAMETRO_RUOLO_CONTESTO_QUALSIASI = CostantiControlStation.LABEL_QUALSIASI;
	
	public final static String DEFAULT_VALUE_PARAMETRO_SCOPE_TIPOLOGIA_QUALSIASI = "";
	public final static String SCOPE_TIPOLOGIA_LABEL_INTERNO = "Registro";
	public final static String SCOPE_TIPOLOGIA_LABEL_ESTERNO = "Esterna";
	public final static String LABEL_PARAMETRO_SCOPE_TIPOLOGIA_QUALSIASI = CostantiControlStation.LABEL_QUALSIASI;
	
	public final static String DEFAULT_VALUE_PARAMETRO_SCOPE_CONTESTO_QUALSIASI = "";
	public final static String SCOPE_CONTESTO_UTILIZZO_LABEL_EROGAZIONE = "Erogazione";
	public final static String SCOPE_CONTESTO_UTILIZZO_LABEL_FRUIZIONE = "Fruizione";
	public final static String LABEL_PARAMETRO_SCOPE_CONTESTO_QUALSIASI = CostantiControlStation.LABEL_QUALSIASI;
	
	public final static String DEFAULT_VALUE_PARAMETRO_RUOLO_QUALSIASI = "";
	public final static String LABEL_PARAMETRO_RUOLO_QUALSIASI = CostantiControlStation.LABEL_QUALSIASI;
	
	public final static String DEFAULT_VALUE_PARAMETRO_PROTOCOLLO_QUALSIASI = "";
	
	public final static String DEFAULT_VALUE_PARAMETRO_MESSAGE_TYPE_DEFAULT = "D";
	public final static String DEFAULT_VALUE_PARAMETRO_MESSAGE_TYPE_SOAP_11 = "SOAP_11";
	public final static String DEFAULT_VALUE_PARAMETRO_MESSAGE_TYPE_SOAP_12 = "SOAP_12";
	public final static String DEFAULT_VALUE_PARAMETRO_MESSAGE_TYPE_XML = "XML";
	public final static String DEFAULT_VALUE_PARAMETRO_MESSAGE_TYPE_JSON = "JSON";
	public final static String DEFAULT_VALUE_PARAMETRO_MESSAGE_TYPE_BINARY = "BINARY";
	public final static String DEFAULT_VALUE_PARAMETRO_MESSAGE_TYPE_MIME_MULTIPART = "MIME_MULTIPART";
	
	public final static String VALUE_PARAMETRO_INTERFACE_TYPE_WSDL_11 = FormatoSpecifica.WSDL_11.getValue();
	public final static String VALUE_PARAMETRO_INTERFACE_TYPE_WADL = FormatoSpecifica.WADL.getValue();
	public final static String VALUE_PARAMETRO_INTERFACE_TYPE_SWAGGER_2 = FormatoSpecifica.SWAGGER_2.getValue();
	public final static String VALUE_PARAMETRO_INTERFACE_TYPE_OPEN_API_3 = FormatoSpecifica.OPEN_API_3.getValue();
	public final static String DEFAULT_VALUE_PARAMETRO_INTERFACE_TYPE_REST = CostantiRegistroServizi.DEFAULT_VALUE_INTERFACE_TYPE_REST.getValue();
	public final static String DEFAULT_VALUE_PARAMETRO_INTERFACE_TYPE_SOAP = CostantiRegistroServizi.DEFAULT_VALUE_INTERFACE_TYPE_SOAP.getValue();
	
	public final static String VALUE_PARAMETRO_MODE_CORRELAZIONE_INPUT_BASED = CostantiConfigurazione.CORRELAZIONE_APPLICATIVA_RICHIESTA_INPUT_BASED.toString();
	public final static String VALUE_PARAMETRO_MODE_CORRELAZIONE_URL_BASED = CostantiConfigurazione.CORRELAZIONE_APPLICATIVA_RICHIESTA_URL_BASED.toString();
	public final static String VALUE_PARAMETRO_MODE_CORRELAZIONE_HEADER_BASED = CostantiConfigurazione.CORRELAZIONE_APPLICATIVA_RICHIESTA_HEADER_BASED.toString();
	public final static String VALUE_PARAMETRO_MODE_CORRELAZIONE_CONTENT_BASED = CostantiConfigurazione.CORRELAZIONE_APPLICATIVA_RICHIESTA_CONTENT_BASED.toString();
	public final static String VALUE_PARAMETRO_MODE_CORRELAZIONE_DISABILITATO = CostantiConfigurazione.CORRELAZIONE_APPLICATIVA_RICHIESTA_DISABILITATO.toString();
	
	public final static String VALUE_PARAMETRO_DUMP_STATO_DEFAULT = "default";
	public final static String VALUE_PARAMETRO_DUMP_STATO_RIDEFINITO = "ridefinito";
	public final static String VALUE_PARAMETRO_DUMP_SEZIONE_RICHIESTA = "richiesta";
	public final static String VALUE_PARAMETRO_DUMP_SEZIONE_RISPOSTA = "risposta";
	
	public final static String LABEL_LIST_VALORE_NON_PRESENTE = "--";
	public static final String DEFAULT_VALUE_AZIONE_NON_SELEZIONATA = "-";
	public static final String DEFAULT_VALUE_NON_SELEZIONATO = "-";
	
	public final static String VALUE_PARAMETRO_PROPERTIES_MODE_DEFAULT = "default";
	
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_GESTORE_POLICY_TOKEN_TIPOLOGIA_GESTIONE_POLICY_TOKEN = org.openspcoop2.pdd.core.token.Costanti.TIPOLOGIA;
	
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_GESTORE_POLICY_TOKEN_OPZIONALE = StatoFunzionalita.DISABILITATO.getValue();
	
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_GESTORE_POLICY_TOKEN_VALIDAZIONE_INPUT = StatoFunzionalitaConWarning.ABILITATO.getValue();
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_GESTORE_POLICY_TOKEN_INTROSPECTION = StatoFunzionalitaConWarning.ABILITATO.getValue();
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_GESTORE_POLICY_TOKEN_USER_INFO = StatoFunzionalitaConWarning.ABILITATO.getValue();
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_GESTORE_POLICY_TOKEN_TOKEN_FORWARD = StatoFunzionalita.ABILITATO.getValue();
	
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_GESTORE_POLICY_TOKEN_AUTENTICAZIONE_ISSUER = StatoFunzionalita.DISABILITATO.getValue();
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_GESTORE_POLICY_TOKEN_AUTENTICAZIONE_CLIENT_ID = StatoFunzionalita.DISABILITATO.getValue();
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_GESTORE_POLICY_TOKEN_AUTENTICAZIONE_SUBJECT = StatoFunzionalita.DISABILITATO.getValue();
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_GESTORE_POLICY_TOKEN_AUTENTICAZIONE_USERNAME = StatoFunzionalita.DISABILITATO.getValue();
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_GESTORE_POLICY_TOKEN_AUTENTICAZIONE_EMAIL = StatoFunzionalita.DISABILITATO.getValue();
	
	
	public final static int DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_PATTERN_LIST_MAX_VALUE = 100;
	
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_SOAP_VERSION_11 = VersioneSOAP._1_1.getValue();
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_RICHIESTA_SOAP_VERSION_12 = VersioneSOAP._1_2.getValue();
	
	public final static String[] SELECT_VALUES_STATO_FUNZIONALITA_CON_WARNING = {StatoFunzionalitaConWarning.ABILITATO.getValue(), StatoFunzionalitaConWarning.DISABILITATO.getValue(), StatoFunzionalitaConWarning.WARNING_ONLY.getValue()};
	public final static String[] SELECT_VALUES_STATO_FUNZIONALITA= {StatoFunzionalita.ABILITATO.getValue(), StatoFunzionalita.DISABILITATO.getValue()}; 

	public static final String NOME_FILE_EROGAZIONE_XACML_POLICY_XML_SUFFIX = "xacmlPolicy.xml";
	public static final String NOME_FILE_FRUIZIONE_XACML_POLICY_XML_SUFFIX = "fruizioneXacmlPolicy.xml";
	
	public final static String VALUE_PARAMETRO_CORS_STATO_DEFAULT = "default";
	public final static String VALUE_PARAMETRO_CORS_STATO_RIDEFINITO = "ridefinito";
	
	public final static String VALUE_PARAMETRO_RESPONSE_CACHING_STATO_DEFAULT = "default";
	public final static String VALUE_PARAMETRO_RESPONSE_CACHING_STATO_RIDEFINITO = "ridefinito";
	
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_QUALSIASI = "Qualsiasi";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_ESATTO = "Singolo";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_INTERVALLO = "Intervallo";
	
	public final static String[] SELECT_LABELS_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE = {
			LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_QUALSIASI,LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_ESATTO,LABEL_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_INTERVALLO
	};
	
	public final static String VALUE_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_QUALSIASI = "qualsiasi";
	public final static String VALUE_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_ESATTO = "esatto";
	public final static String VALUE_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_INTERVALLO = "intervallo";
	
	public final static String[] SELECT_VALUES_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE = {
			 VALUE_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_QUALSIASI,
			 VALUE_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_ESATTO,
			 VALUE_PARAMETRO_CONFIGURAZIONE_RESPONSE_CACHING_CONFIGURAZIONE_REGOLA_RETURN_CODE_INTERVALLO
	};
	
	public final static String VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_PARAMETRO_ADD = TrasformazioneRegolaParametroTipoAzione.ADD.getValue();
	public final static String VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_PARAMETRO_DELETE = TrasformazioneRegolaParametroTipoAzione.DELETE.getValue();
	public final static String VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_PARAMETRO_UPDATE = TrasformazioneRegolaParametroTipoAzione.UPDATE.getValue();
	public final static String VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_PARAMETRO_UPDATE_OR_ADD = TrasformazioneRegolaParametroTipoAzione.UPDATE_OR_ADD.getValue();
	
	public final static String[] SELECT_VALUES_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_PARAMETRO = {
			VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_PARAMETRO_ADD,
			VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_PARAMETRO_DELETE,
			VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_PARAMETRO_UPDATE,
			VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_PARAMETRO_UPDATE_OR_ADD
	};
	
	public final static String LABEL_VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_DISABILITATO = "Disabilitato";
	public final static String LABEL_VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_AS_BODY = "Utilizza contenuto come SOAP Body";
	public final static String LABEL_VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_AS_ATTACHMENT = "Utilizza contenuto come Attachment";
	
	public final static String VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_DISABILITATO = "0";
	public final static String VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_AS_BODY = "1";
	public final static String VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_AS_ATTACHMENT = "2";
	
	public final static String[] SELECT_VALUES_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE = {
			VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_DISABILITATO,
			VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_AS_BODY,
			VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_AS_ATTACHMENT
	};
	
	public final static String[] SELECT_LABELS_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE = {
			LABEL_VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_DISABILITATO,
			LABEL_VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_AS_BODY,
			LABEL_VALUE_PARAMETRO_CONFIGURAZIONE_TRASFORMAZIONI_SOAP_ENVELOPE_AS_ATTACHMENT
	};
	
	public final static String VALUE_PARAMETRO_PORTE_CONTROLLO_ACCESSI_STATO_PUBBLICO = "pubblico";
	public final static String VALUE_PARAMETRO_PORTE_CONTROLLO_ACCESSI_STATO_AUTENTICATO = "autenticato";
	public final static String[] SELECT_VALUES_PARAMETRO_PORTE_CONTROLLO_ACCESSI_STATO = {
			VALUE_PARAMETRO_PORTE_CONTROLLO_ACCESSI_STATO_AUTENTICATO,
			VALUE_PARAMETRO_PORTE_CONTROLLO_ACCESSI_STATO_PUBBLICO
	};
	
	public final static boolean VALUE_TRASFORMAZIONI_CHECK_UNIQUE_NOME_TIPO_HEADER_URL = false;
	public final static String MESSAGGIO_TRASFORMAZIONI_CHECK_UNIQUE_NOME_TIPO_URL = "Una regola con la propriet&agrave indicata risulta gi&agrave; registrata";
	public final static String MESSAGGIO_TRASFORMAZIONI_CHECK_UNIQUE_NOME_TIPO_HEADER = "Una regola con l'header indicato risulta gi&agrave; registrata";

	/** OTHER */
	public final static String IMAGES_DIR = "images";
	public final static String CSS_DIR = "css";
	public final static String JS_DIR = "js";
	public final static String FONTS_DIR = "fonts";
	public final static String OPERATIONS_DELIMITER = "\n--------------------------------------------\n\n";
	public final static String RESOURCE_JMX_PDD_TIPOLOGIA_ACCESSO_JMX = "jmx";
	public final static String RESOURCE_JMX_PDD_TIPOLOGIA_ACCESSO_OPENSPCOOP = "openspcoop";
	
	
	/** COSTANTI FILE TEMPORANEI */
	public final static String TEMP_FILE_PREFIX = "__pddconsole__";
	public final static String TEMP_FILE_SUFFIX = ".tmp"; 
	
	
	/** MESSAGGI */
	public static final String MESSAGGIO_CONFERMA_ABILITAZIONE_PORTA_AZIONI ="Si sta abilitando la configurazione relativa alle azioni:{0}Procedere?"; 
	public static final String MESSAGGIO_CONFERMA_ABILITAZIONE_PORTA_RISORSE ="Si sta abilitando la configurazione relativa alle risorse:{0}Procedere?"; 
	public static final String MESSAGGIO_CONFERMA_ABILITAZIONE_PORTA_DEFAULT ="Si sta abilitando la configurazione di default, procedere?"; 
	public static final String MESSAGGIO_CONFERMA_DISABILITAZIONE_PORTA_AZIONI ="Si sta disabilitando la configurazione relativa alle azioni:{0}Procedere?";
	public static final String MESSAGGIO_CONFERMA_DISABILITAZIONE_PORTA_RISORSE ="Si sta disabilitando la configurazione relativa alle risorse:{0}Procedere?";
	public static final String MESSAGGIO_CONFERMA_DISABILITAZIONE_PORTA_DEFAULT ="Si sta disabilitando la configurazione di default, procedere?";
	public static final String MESSAGGIO_CONFERMA_REGISTRAZIONE_MESSAGGI_DOPPIO_SPAZIO = "L''attuale configurazione, prevedendo di registrare i dati del messaggio di {0} sia in Ingresso che in Uscita, raddoppia l''ammontare di spazio occupato. Procedere con la configurazione effettuata?";
	
	/** MESSAGGI ERRORE */
	public static final String MESSAGGIO_ERRORE_CORRELAZIONE_APPLICATIVA_CON_ELEMENTO_XML_DEFINITA_GIA_ESISTENTE = "Esiste gi&agrave; una correlazione applicativa con elemento [{0}] definita nella {1}";
	public static final String MESSAGGIO_ERRORE_MODALITA_IDENTIFICAZIONE_CON_TIPI_POSSIBILI = "Modalit&agrave; identificazione dev'essere disabilitato, headerBased, urlBased, contentBased o inputBased ";
	public static final String MESSAGGIO_ERRRORE_DATI_INCOMPLETI_E_NECESSARIO_INDICARE_XX = "Dati incompleti. &Egrave; necessario indicare: {0}";
	public static final String MESSAGGIO_ERRORE_SCADENZA_CORRELAZIONE_APPLICATIVA_NON_VALIDA_INSERIRE_UN_NUMERO_INTERO_MAGGIORE_DI_ZERO = "Scadenza Correlazione Applicativa non valida, inserire un numero intero maggiore di zero";
	public static final String MESSAGGIO_ERRORE_CON_LA_SOLA_MODALITA_DI_AUTORIZZAZIONE_XX_DEVE_ESSERE_INDICATA_ANCHE_UNA_MODALITA_DI_AUTENTICAZIONE_YY = "Con la sola modalit&agrave; di autorizzazione ''{0}'' deve essere indicata anche una modalit&agrave; di autenticazione";
	public static final String MESSAGGIO_ERRORE_CON_LA_SOLA_MODALITA_DI_AUTORIZZAZIONE_XX_NON_E_POSSIBILE_ASSOCIATA_UNA_MODALITÀ_DI_AUTENTICAZIONE_OPZIONALE = "Con la sola modalit&agrave; di autorizzazione ''{0}'' non &egrave; possibile associata una modalit&agrave; di autenticazione ''opzionale''";
	public static final String MESSAGGIO_ERRORE_CON_UNA_MODALITA_DI_AUTENTICAZIONE_BASIC_OBBLIGATORIA_NON_E_POSSIBILE_SELEZIONARE_ENTRAMBE_LE_MODALITA_DI_AUTORIZZAZIONE = "Con una modalit&agrave; di autenticazione ''"+TipoAutenticazione.BASIC.getLabel()+"'' obbligatoria non &egrave; possibile selezionare entrambe le modalit&agrave; di autorizzazione ''{0}'' e ''{1}''.<BR/>Per usare entrambe le autorizzazioni rendere opzionale l''autenticazione";
	public static final String MESSAGGIO_ERRORE_LA_PORTA_CONTIENE_GIA_DEI_RUOLI_CHE_NON_SONO_COMPATIBILI_CON_LA_NUOVA_AUTORIZZAZIONE = "La porta contiene gi&agrave; dei ruoli che non sono compatibili con la nuova autorizzazione ''{0}'' scelta.<BR/>Eliminare i ruoli prima di procedere con la modifica del tipo di autorizzazione.";
	public static final String MESSAGGIO_ERRORE_CON_UNA_FONTE_PER_I_RUOLI_DI_TIPO_XX_DEVE_ESSERE_ASSOCIATA_UNA_MODALITÀ_DI_AUTENTICAZIONE = "Con una {0} per i ruoli di tipo ''{1}'' deve essere associata una modalit&agrave; di autenticazione";
	public static final String MESSAGGIO_ERRORE_CON_UNA_FONTE_PER_I_RUOLI_DI_TIPO_XX_NON_E_POSSIBILE_ASSOCIATA_UNA_MODALITÀ_DI_AUTENTICAZIONE_OPZIONALE = "Con una {0} per i ruoli di tipo ''{1}'' non &egrave; possibile associata una modalit&agrave; di autenticazione ''opzionale''";
	public static final String MESSAGGIO_ERRORE_LA_PORTA_CONTIENE_DEI_RUOLI_XX_CHE_NON_SONO_COMPATIBILI_CON_LA_NUOVA_FONTE_SCELTA = "La porta contiene gi&agrave; dei ruoli ({0}) che non sono compatibili con la nuova {1} ''{2}'' scelta.";
	public static final String MESSAGGIO_ERRORE_SELEZIONARE_ALMENO_UNA_MODALITÀ_DI_AUTORIZZAZIONE = "Selezionare almeno una modalit&agrave; di autorizzazione";
	public static final String MESSAGGIO_ERRORE_IL_RUOLO_XX_E_GIA_STATO_ASSOCIATA_AL_SOGGETTO = "Il ruolo ''{0}'' &egrave; gi&agrave; stato associata al soggetto";
	public static final String MESSAGGIO_ERRORE_LO_SCOPE_XX_E_GIA_STATO_ASSOCIATA_AL_SOGGETTO = "Lo scope ''{0}'' &egrave; gi&agrave; stato associata al soggetto";
	public static final String MESSAGGIO_ERRORE_NON_ESISTONO_RUOLI_ASSOCIABILI = "Non esistono ruoli associabili";
	public static final String MESSAGGIO_ERRORE_NON_ESISTONO_SCOPE_ASSOCIABILI = "Non esistono scope associabili";
	public static final String MESSAGGIO_ERRORE_NON_ESISTONO_ULTERIORI_RUOLI_ASSOCIABILI = "Non esistono ulteriori ruoli associabili";
	public static final String MESSAGGIO_ERRORE_NON_ESISTONO_ULTERIORI_SCOPE_ASSOCIABILI = "Non esistono ulteriori scope associabili";
	public static final String MESSAGGIO_ERRORE_IL_CAMPO_XX_DEVE_RISPETTARE_IL_PATTERN_YY = "Il campo {0} deve rispettare il seguente pattern: {1}";
	public static final String MESSAGGIO_ERRORE_PROPRIETA_DI_MTOM_GIA_ASSOCIATA_ALLA_PORTA_APPLICATIVA_XX = "La propriet&agrave; di MTOM {0} &egrave; gi&agrave; stato associata alla porta applicativa {1}";
	public static final String MESSAGGIO_ERRORE_PROPRIETA_DI_MTOM_GIA_ASSOCIATA_ALLA_PORTA_DELEGATA_XX = "La propriet&agrave; di MTOM {0} &egrave; gi&agrave; stato associata alla porta delegata {1}";
	public static final String MESSAGGIO_ERRORE_NON_INSERIRE_SPAZI_NEL_CAMPO_CONTENT_TYPE = "Non inserire spazi nel campo Content Type";
	public static final String MESSAGGIO_ERRROE_NON_INSERIRE_SPAZI_NEL_CAMPO_PATTERN = "Non inserire spazi nel campo Pattern";
	public static final String MESSAGGIO_ERRORE_NON_INSERIRE_SPAZI_NEL_CAMPO_NOME = "Non inserire spazi nel campo Nome";
	public static final String MESSAGGIO_ERRORE_STATO_DELLA_RISPOSTA_DEVE_ESSERE_DISABLED_PACKAGING_UNPACKAGING_O_VERIFY = "Stato della Risposta dev'essere disabled, packaging, unpackaging o verify.";
	public static final String MESSAGGIO_ERRORE_STATO_DELLA_RICHIESTA_DEVE_ESSERE_DISABLED_PACKAGING_UNPACKAGING_O_VERIFY = "Stato della Richiesta dev'essere disabled, packaging, unpackaging o verify.";
	public static final String MESSAGGIO_ERRORE_CORRELAZIONE_APPLICATIVA_PER_LA_RISPOSTA_CON_ELEMENTO_DEFINITA_GIA_ESISTENTE = "Esiste gi&agrave; una correlazione applicativa per la risposta con elemento [{0}] definita nella {1}";
	public static final String MESSAGGIO_ERRORE_NON_INSERIRE_SPAZI_NEI_CAMPI_DI_TESTO = "Non inserire spazi nei campi di testo";
	public static final String MESSAGGIO_ERRORE_AZIONE_PORTA_NON_PUO_ESSERE_VUOTA = "Deve essere selezionata una Azione";
	public static final String MESSAGGIO_ERRORE_NOME_GRUPPO_GIA_ESISTENTE = "Il nome indicato è già stato assegnato ad un altro gruppo";
	public static final String MESSAGGIO_ERRORE_NOME_GRUPPO_NON_PUO_ESSERE_VUOTA = "Deve essere indicato un nome per il gruppo";
	public static final String MESSAGGIO_ERRORE_AZIONE_PORTA_GIA_PRESENTE = "L'azione scelta &egrave; gi&agrave; presente";
	public static final String MESSAGGIO_ERRORE_RUOLI_PRESENTI_AUTORIZZAZIONE_DISABILITATA = "Non &egrave; possibile disabilitare l'autorizzazione senza prima di eliminare i ruoli associati";
	public static final String MESSAGGIO_ERRORE_SCOPE_PRESENTI_AUTORIZZAZIONE_DISABILITATA = "Non &egrave; possibile disabilitare l'autorizzazione senza prima di eliminare gli scope associati";
	public static final String MESSAGGIO_ERRORE_APPLICATIVI_PRESENTI_AUTORIZZAZIONE_DISABILITATA = "Non &egrave; possibile disabilitare l'autorizzazione senza prima di eliminare gli applicativi associati";
	public static final String MESSAGGIO_ERRORE_SOGGETTI_PRESENTI_AUTORIZZAZIONE_DISABILITATA = "Non &egrave; possibile disabilitare l'autorizzazione senza prima di eliminare i soggetti associati";
	public static final String MESSAGGIO_ERRORE_APPLICATIVI_PRESENTI_AUTENTICAZIONE_MODIFICATA = "Non &egrave; possibile modificare l'autenticazione senza prima di eliminare gli applicativi associati";
	public static final String MESSAGGIO_ERRORE_SOGGETTI_PRESENTI_AUTENTICAZIONE_MODIFICATA = "Non &egrave; possibile modificare l'autenticazione senza prima di eliminare i soggetti associati";
	public static final String MESSAGGIO_ERRORE_VALIDAZIONE_XSD_DEV_ESSERE_ABILITATO_DISABILITATO_O_WARNING_ONLY = "Validazione XSD dev'essere abilitato, disabilitato o warningOnly";
	public static final String MESSAGGIO_ERRORE_CONFIGURAZIONE_DUMPO_VALORE_DEL_CAMPO_XX_NON_VALIDO = "Valore del campo {0} non valido.";
	public static final String MESSAGGIO_ERRORE_CONFIGURAZIONE_DUMPO_VALORE_DEL_CAMPO_XX_DELLA_YY_NON_VALIDO = "Valore del campo {0} della {1} non valido.";
	public static final String MESSAGGIO_ERRORE_CONFIGURAZIONE_DUMPO_VALORE_DEL_CAMPO_XX_YY_DELLA_ZZ_NON_VALIDO = "Valore del campo {0} {1} della {2} non valido.";
	public static final String MESSAGGIO_ERRORE_CONFIGURAZIONE_POLICY_TOKEN_DATI_INCOMPLETI_E_NECESSARIO_INDICARE_UNA_MODALITA = "Dati incompleti. &Egrave; necessario abilitare almeno una voce tra {0}";
	public static final String MESSAGGIO_ERRORE_CONFIGURAZIONE_DUMP_DATI_INCOMPLETI_E_NECESSARIO_ABILITARE_UNA_VOCE = "Impossibile abilitare la Registrazione dei messaggi di {0} senza specificare almeno una voce di Ingresso o Uscita";
	public final static String MESSAGGIO_ERRORE_AUTORIZZAZIONE_TOKEN = "I claims in ogni riga devono essere indicati come coppia (nome=valore); non è stato riscontrato il carattere separatore '='";
	public static final String MESSAGGIO_ERRORE_POLICY_OBBLIGATORIA_CON_LA_NUOVA_AUTORIZZAZIONE = "La policy &egrave; obbligatoria quando si seleziona l''autorizzazione ''{0}''";
	public static final String MESSAGGIO_ERRORE_NOME_GRUPPO_GIA_PRESENTE = "Il nome gruppo indicato &egrave; gi&agrave; utilizzato in un'altra configurazione";
	public static final String MESSAGGIO_ERRORE_TOKEN_OPTIONS_NON_INDICATI = "Dati incompleti. Definire almeno un claim utilizzato per autorizzare la richiesta";
	public static final String MESSAGGIO_ERRORE_CORS_SPAZI_BIANCHI_NON_AMMESSI = "Non inserire spazi bianchi nei valori del campo {0}";
	public static final String MESSAGGIO_ERRORE_CORS_CAMPO_OBBLIGATORIO = "Inserire almeno un valore nel campo {0}";
	public static final String MESSAGGIO_ERRORE_CORS_ALLOW_METHOD_NON_VALIDO = "Il valore {0} indicato per il campo {1} non rappresenta un HTTP-Method valido";
	public static final String MESSAGGIO_ERRORE_REGOLA_TRASFORMAZIONE_APPLICABILITA_DUPLICATA = "&Egrave; gi&agrave; presente una regola di trasformazione con i parametri di applicabilit&agrave; indicati.";
	public static final String MESSAGGIO_ERRORE_REGOLA_TRASFORMAZIONE_APPLICABILITA_NOME = "&Egrave; gi&agrave; presente una regola di trasformazione con il nome indicato.";
}
