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
package org.openspcoop2.web.ctrlstat.servlet.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.openspcoop2.web.ctrlstat.costanti.CostantiControlStation;
import org.openspcoop2.web.lib.mvc.ForwardParams;

/**
 * ConfigurazioneCostanti
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class ConfigurazioneCostanti {

	/* OBJECT NAME */
	
	public final static String OBJECT_NAME_CONFIGURAZIONE_GENERALE = "configurazioneGenerale";
	public final static ForwardParams TIPO_OPERAZIONE_CONFIGURAZIONE_GENERALE = ForwardParams.OTHER("");
	
	public final static String OBJECT_NAME_CONFIGURAZIONE_GENERALE_EXTENDED = "configurazioneGeneraleExtended";
	public final static ForwardParams TIPO_OPERAZIONE_CONFIGURAZIONE_GENERALE_EXTENDED = ForwardParams.OTHER("");
	
	public final static String OBJECT_NAME_CONFIGURAZIONE_GENERALE_LIST_EXTENDED = "configurazioneGeneraleListExtended";
	
	public final static String OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER = "configurazioneDiagnosticaAppender";
	public final static String OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES = "configurazioneDiagnosticaAppenderProperties";
	
	public final static String OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE = "configurazioneDiagnosticaDatasource";
	public final static String OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES = "configurazioneDiagnosticaDatasourceProperties";
	
	public final static String OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER = "configurazioneTracciamentoAppender";
	public final static String OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES = "configurazioneTracciamentoAppenderProperties";
	
	public final static String OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE = "configurazioneTracciamentoDatasource";
	public final static String OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES = "configurazioneTracciamentoDatasourceProperties";
	
	public final static String OBJECT_NAME_CONFIGURAZIONE_ACCESSO_REGISTRO_SERVIZI = "configurazioneAccessoRegistroServizi";
	public final static ForwardParams TIPO_OPERAZIONE_CONFIGURAZIONE_ACCESSO_REGISTRO_SERVIZI = ForwardParams.OTHER("");
	
	public final static String OBJECT_NAME_CONFIGURAZIONE_REGISTRI = "configurazioneRegistri";
	
	public final static String OBJECT_NAME_CONFIGURAZIONE_ROUTING = "configurazioneRouting";
	public final static ForwardParams TIPO_OPERAZIONE_CONFIGURAZIONE_ROUTING = ForwardParams.OTHER("");
	
	public final static String OBJECT_NAME_CONFIGURAZIONE_ROTTE_ROUTING = "configurazioneRoute";
	
	public final static String OBJECT_NAME_CONFIGURAZIONE_SYSTEM_PROPERTIES = "configurazioneSystemProperties";
	
	public final static String OBJECT_NAME_CONFIGURAZIONE_SISTEMA = "configurazioneSistema";
	
	/* SERVLET NAME */
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_GENERALE = OBJECT_NAME_CONFIGURAZIONE_GENERALE+".do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_GENERALE_EXTENDED = OBJECT_NAME_CONFIGURAZIONE_GENERALE_EXTENDED+".do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_GENERALE = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_GENERALE.add(SERVLET_NAME_CONFIGURAZIONE_GENERALE);
		SERVLET_CONFIGURAZIONE_GENERALE.add(SERVLET_NAME_CONFIGURAZIONE_GENERALE_EXTENDED);
	}
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_GENERALE_LIST_EXTENDED_ADD = OBJECT_NAME_CONFIGURAZIONE_GENERALE_LIST_EXTENDED+"Add.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_GENERALE_LIST_EXTENDED_CHANGE = OBJECT_NAME_CONFIGURAZIONE_GENERALE_LIST_EXTENDED+"Change.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_GENERALE_LIST_EXTENDED_DELETE = OBJECT_NAME_CONFIGURAZIONE_GENERALE_LIST_EXTENDED+"Del.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_GENERALE_LIST_EXTENDED_LIST = OBJECT_NAME_CONFIGURAZIONE_GENERALE_LIST_EXTENDED+"List.do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_GENERALE_LIST_EXTENDED = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_GENERALE_LIST_EXTENDED.add(SERVLET_NAME_CONFIGURAZIONE_GENERALE_LIST_EXTENDED_ADD);
		SERVLET_CONFIGURAZIONE_GENERALE_LIST_EXTENDED.add(SERVLET_NAME_CONFIGURAZIONE_GENERALE_LIST_EXTENDED_CHANGE);
		SERVLET_CONFIGURAZIONE_GENERALE_LIST_EXTENDED.add(SERVLET_NAME_CONFIGURAZIONE_GENERALE_LIST_EXTENDED_DELETE);
		SERVLET_CONFIGURAZIONE_GENERALE_LIST_EXTENDED.add(SERVLET_NAME_CONFIGURAZIONE_GENERALE_LIST_EXTENDED_LIST);
	}
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_ADD = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER+"Add.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_CHANGE = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER+"Change.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_DELETE = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER+"Del.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_LIST = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER+"List.do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_DIAGNOSTICA_APPENDER = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_APPENDER.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_ADD);
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_APPENDER.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_CHANGE);
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_APPENDER.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_DELETE);
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_APPENDER.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_LIST);
	}
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES_ADD = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES+"Add.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES_CHANGE = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES+"Change.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES_DELETE = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES+"Del.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES_LIST = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES+"List.do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES_ADD);
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES_CHANGE);
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES_DELETE);
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_APPENDER_PROPERTIES_LIST);
	}
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_ADD = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE+"Add.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_CHANGE = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE+"Change.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_DELETE = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE+"Del.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_LIST = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE+"List.do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_ADD);
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_CHANGE);
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_DELETE);
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_LIST);
	}
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES_ADD = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES+"Add.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES_CHANGE = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES+"Change.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES_DELETE = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES+"Del.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES_LIST = OBJECT_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES+"List.do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES_ADD);
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES_CHANGE);
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES_DELETE);
		SERVLET_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_DIAGNOSTICA_DATASOURCE_PROPERTIES_LIST);
	}
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_ADD = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER+"Add.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_CHANGE = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER+"Change.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_DELETE = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER+"Del.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_LIST = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER+"List.do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_TRACCIAMENTO_APPENDER = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_APPENDER.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_ADD);
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_APPENDER.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_CHANGE);
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_APPENDER.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_DELETE);
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_APPENDER.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_LIST);
	}
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES_ADD = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES+"Add.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES_CHANGE = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES+"Change.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES_DELETE = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES+"Del.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES_LIST = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES+"List.do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES_ADD);
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES_CHANGE);
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES_DELETE);
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_APPENDER_PROPERTIES_LIST);
	}
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_ADD = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE+"Add.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_CHANGE = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE+"Change.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_DELETE = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE+"Del.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_LIST = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE+"List.do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_ADD);
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_CHANGE);
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_DELETE);
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_LIST);
	}
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES_ADD = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES+"Add.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES_CHANGE = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES+"Change.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES_DELETE = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES+"Del.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES_LIST = OBJECT_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES+"List.do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES_ADD);
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES_CHANGE);
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES_DELETE);
		SERVLET_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_TRACCIAMENTO_DATASOURCE_PROPERTIES_LIST);
	}
	
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_ACCESSO_REGISTRO_SERVIZI = OBJECT_NAME_CONFIGURAZIONE_ACCESSO_REGISTRO_SERVIZI+".do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_ACCESSO_REGISTRO_SERVIZI = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_ACCESSO_REGISTRO_SERVIZI.add(SERVLET_NAME_CONFIGURAZIONE_ACCESSO_REGISTRO_SERVIZI);
	}
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_REGISTRI_ADD = OBJECT_NAME_CONFIGURAZIONE_REGISTRI+"Add.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_REGISTRI_CHANGE = OBJECT_NAME_CONFIGURAZIONE_REGISTRI+"Change.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_REGISTRI_DELETE = OBJECT_NAME_CONFIGURAZIONE_REGISTRI+"Del.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_REGISTRI_LIST = OBJECT_NAME_CONFIGURAZIONE_REGISTRI+"List.do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_REGISTRI = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_REGISTRI.add(SERVLET_NAME_CONFIGURAZIONE_REGISTRI_ADD);
		SERVLET_CONFIGURAZIONE_REGISTRI.add(SERVLET_NAME_CONFIGURAZIONE_REGISTRI_CHANGE);
		SERVLET_CONFIGURAZIONE_REGISTRI.add(SERVLET_NAME_CONFIGURAZIONE_REGISTRI_DELETE);
		SERVLET_CONFIGURAZIONE_REGISTRI.add(SERVLET_NAME_CONFIGURAZIONE_REGISTRI_LIST);
	}
	
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_ROUTING = OBJECT_NAME_CONFIGURAZIONE_ROUTING+".do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_ROUTING = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_ROUTING.add(SERVLET_NAME_CONFIGURAZIONE_ROUTING);
	}
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_ROTTE_ROUTING_ADD = OBJECT_NAME_CONFIGURAZIONE_ROTTE_ROUTING+"Add.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_ROTTE_ROUTING_CHANGE = OBJECT_NAME_CONFIGURAZIONE_ROTTE_ROUTING+"Change.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_ROTTE_ROUTING_DELETE = OBJECT_NAME_CONFIGURAZIONE_ROTTE_ROUTING+"Del.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_ROTTE_ROUTING_LIST = OBJECT_NAME_CONFIGURAZIONE_ROTTE_ROUTING+"List.do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_ROTTE_ROUTING = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_ROTTE_ROUTING.add(SERVLET_NAME_CONFIGURAZIONE_ROTTE_ROUTING_ADD);
		SERVLET_CONFIGURAZIONE_ROTTE_ROUTING.add(SERVLET_NAME_CONFIGURAZIONE_ROTTE_ROUTING_CHANGE);
		SERVLET_CONFIGURAZIONE_ROTTE_ROUTING.add(SERVLET_NAME_CONFIGURAZIONE_ROTTE_ROUTING_DELETE);
		SERVLET_CONFIGURAZIONE_ROTTE_ROUTING.add(SERVLET_NAME_CONFIGURAZIONE_ROTTE_ROUTING_LIST);
	}
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_SYSTEM_PROPERTIES_ADD = OBJECT_NAME_CONFIGURAZIONE_SYSTEM_PROPERTIES+"Add.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_SYSTEM_PROPERTIES_CHANGE = OBJECT_NAME_CONFIGURAZIONE_SYSTEM_PROPERTIES+"Change.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_SYSTEM_PROPERTIES_DELETE = OBJECT_NAME_CONFIGURAZIONE_SYSTEM_PROPERTIES+"Del.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_SYSTEM_PROPERTIES_LIST = OBJECT_NAME_CONFIGURAZIONE_SYSTEM_PROPERTIES+"List.do";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_SYSTEM_PROPERTIES = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_SYSTEM_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_SYSTEM_PROPERTIES_ADD);
		SERVLET_CONFIGURAZIONE_SYSTEM_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_SYSTEM_PROPERTIES_CHANGE);
		SERVLET_CONFIGURAZIONE_SYSTEM_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_SYSTEM_PROPERTIES_DELETE);
		SERVLET_CONFIGURAZIONE_SYSTEM_PROPERTIES.add(SERVLET_NAME_CONFIGURAZIONE_SYSTEM_PROPERTIES_LIST);
	}
	
	public final static String SERVLET_NAME_CONFIGURAZIONE_SISTEMA_ADD = OBJECT_NAME_CONFIGURAZIONE_SISTEMA+"Add.do";
	public final static String SERVLET_NAME_CONFIGURAZIONE_SISTEMA_EXPORTER = "exporterConfigurazione";
	public final static Vector<String> SERVLET_CONFIGURAZIONE_SISTEMA = new Vector<String>();
	static{
		SERVLET_CONFIGURAZIONE_SISTEMA.add(SERVLET_NAME_CONFIGURAZIONE_SISTEMA_ADD);
		SERVLET_CONFIGURAZIONE_SISTEMA.add(SERVLET_NAME_CONFIGURAZIONE_SISTEMA_EXPORTER);
	}
	

	
	
	
	/* LABEL GENERALI */
	
	public final static String LABEL_CONFIGURAZIONE = "Configurazione";
	
	public final static String LABEL_CONFIGURAZIONE_GENERALE = "Generale";
	
	public final static String LABEL_CONFIGURAZIONE_ELENCO_APPENDER_TRACCIAMENTO = "Elenco appender tracciamento";
	public final static String LABEL_CONFIGURAZIONE_ELENCO_APPENDER_MESSAGGI_DIAGNOSTICI = "Elenco appender messaggi diagnostici";
	public final static String LABEL_CONFIGURAZIONE_ELENCO_SORGENTI_DATI_TRACCIAMENTO = "Elenco sorgenti dati tracciamento";
	public final static String LABEL_CONFIGURAZIONE_ELENCO_SORGENTI_DATI_MESSAGGI_DIAGNOSTICI = "Elenco sorgenti dati messaggi diagnostici";
	
	public final static String LABEL_CONFIGURAZIONE_PROPRIETA = "Propriet&agrave;";
	public final static String LABEL_CONFIGURAZIONE_PROPRIETA_SISTEMA = "Propriet&agrave; di Sistema";
	
	public final static String LABEL_CONFIGURAZIONE_SISTEMA =  "Runtime"; //"Configurazione di Sistema";
	
	public final static String LABEL_CONFIGURAZIONE_DESTINAZIONI = "Destinazioni";
	public final static String LABEL_CONFIGURAZIONE_ROTTA = "Rotta";
	public final static String LABEL_CONFIGURAZIONE_ROTTA_DI_DEFAULT = "Rotta di default";
	public final static String LABEL_CONFIGURAZIONE_ROTTE_STATICHE = "Rotte statiche";
	public final static String LABEL_CONFIGURAZIONE_DESTINATARIO = "Destinatario";
	public final static String LABEL_CONFIGURAZIONE_TABELLA_DI_ROUTING = "Tabella di Routing";
	public final static String LABEL_CONFIGURAZIONE_ROUTING_DELLE_BUSTE = "Routing delle buste";
	public final static String LABEL_CONFIGURAZIONE_REGISTRO = "Registro";
	public final static String LABEL_CONFIGURAZIONE_ELENCO_REGISTRI = "Elenco registri";
	public final static String LABEL_CONFIGURAZIONE_MESSAGGI_DIAGNOSTICI = "Messaggi diagnostici";
	public final static String LABEL_CONFIGURAZIONE_TRACCIAMENTO = "Tracciamento";
	public final static String LABEL_CONFIGURAZIONE_INTEGRATION_MANAGER = "Integration Manager";
	public final static String LABEL_CONFIGURAZIONE_VALIDAZIONE_CONTENUTI_APPLICATIVI = "Validazione Contenuti Applicativi";
	
	public final static String LABEL_CONFIGURAZIONE_INOLTRO_BUSTE_NON_RISCONTRATE = "Inoltro buste non riscontrate";
	public final static String LABEL_CONFIGURAZIONE_VALIDAZIONE_BUSTE = "Validazione buste";
	public final static String LABEL_CONFIGURAZIONE_APPENDER = "appender" ;
	public final static String LABEL_CONFIGURAZIONE_SORGENTI_DATI = "sorgenti dati" ;
	public final static String LABEL_CONFIGURAZIONE_RISPOSTE = "Risposte";
	public final static String LABEL_CONFIGURAZIONE_INDIRIZZO_TELEMATICO = "Indirizzo Telematico";
	public final static String LABEL_CONFIGURAZIONE_MANIFEST_ATTACHMENTS = "Manifest attachments";
	public final static String LABEL_CONFIGURAZIONE_REGISTRO_SERVIZI = "Registro dei Servizi";
	
	public final static String LABEL_CONFIGURAZIONE_CACHE_REGISTRY = "Cache";
	
	public final static String LABEL_CONFIGURAZIONE_CACHE_CONFIG = "Cache (Configurazione della Porta)";
	
	public final static String LABEL_CONFIGURAZIONE_CACHE_AUTH = "Cache (Dati di Autorizzazione)";
	
	public final static String LABEL_INFORMAZIONE_NON_DISPONIBILE = "Informazione non disponibile";
	
	public final static String LABEL_CONFIGURAZIONE_SISTEMA_INFO_GENERALI = "Informazioni Generali";
	public final static String LABEL_CONFIGURAZIONE_SISTEMA_INFO_DIAGNOSTICA = "Informazioni Diagnostica";
	public final static String LABEL_CONFIGURAZIONE_SISTEMA_INFO_TRACCIAMENTO = "Informazioni Tracciamento";
	public final static String LABEL_CONFIGURAZIONE_SISTEMA_INFO_DATABASE = "Informazioni Database";
	public final static String LABEL_CONFIGURAZIONE_SISTEMA_INFO_PROTOCOLLI = "Informazioni Protocolli";
	public final static String LABEL_CONFIGURAZIONE_SISTEMA_CACHE = "Cache ";
	public final static String LABEL_CONFIGURAZIONE_SISTEMA_CONNESSIONE_DATABASE = "Connessioni Attive al Database";
	public final static String LABEL_CONFIGURAZIONE_SISTEMA_CONNESSIONE_JMS = "Connessioni Attive al Broker JMS";
	public final static String LABEL_CONFIGURAZIONE_SISTEMA_CONNESSIONE_PD = "Connessioni HTTP Attive in uscita dal modulo InoltroBuste";
	public final static String LABEL_CONFIGURAZIONE_SISTEMA_CONNESSIONE_PA = "Connessioni HTTP Attive in uscita dal modulo ConsegnaContenutiApplicativi";
	
	
	/* PARAMETRI */
	
	public final static String PARAMETRO_CONFIGURAZIONE_ID = "id";
	public final static String PARAMETRO_CONFIGURAZIONE_NOME = "nome";
	public final static String PARAMETRO_CONFIGURAZIONE_TIPO = "tipo";
	public final static String PARAMETRO_CONFIGURAZIONE_VALORE = "valore";
	public final static String PARAMETRO_CONFIGURAZIONE_ESEGUI = "esegui";
	public final static String PARAMETRO_CONFIGURAZIONE_ID_PROPRIETA = "idprop";
	public final static String PARAMETRO_CONFIGURAZIONE_NOME_JNDI = "nomeJndi";
	public final static String PARAMETRO_CONFIGURAZIONE_TIPO_DATABASE = "tipoDatabase";
	public final static String PARAMETRO_CONFIGURAZIONE_TIPO_ROTTA = "tiporotta";
	public final static String PARAMETRO_CONFIGURAZIONE_TIPO_SOGGETTO_ROTTA = "tiposoggrotta";
	public final static String PARAMETRO_CONFIGURAZIONE_NOME_SOGGETTO_ROTTA = "nomesoggrotta";
	public final static String PARAMETRO_CONFIGURAZIONE_REGISTRO_ROTTA = "registrorotta";
	public final static String PARAMETRO_CONFIGURAZIONE_ROTTA_ENABLED = "rottaenabled";
	public final static String PARAMETRO_CONFIGURAZIONE_UTENTE = "utente";
	public final static String PARAMETRO_CONFIGURAZIONE_PASSWORD = "password";
	public final static String PARAMETRO_CONFIGURAZIONE_CONFERMA_PASSWORD = "confpw";
	public final static String PARAMETRO_CONFIGURAZIONE_LOCATION = "location";
	public final static String PARAMETRO_CONFIGURAZIONE_INOLTRO_MIN = "inoltromin";
	public final static String PARAMETRO_CONFIGURAZIONE_STATO = "stato";
	public final static String PARAMETRO_CONFIGURAZIONE_CONTROLLO = "controllo";
	public final static String PARAMETRO_CONFIGURAZIONE_LIVELLO_SEVERITA = "severita";
	public final static String PARAMETRO_CONFIGURAZIONE_LIVELLO_SEVERITA_LOG4J = "severita_log4j";
	public final static String PARAMETRO_CONFIGURAZIONE_NOME_INTEGMAN = "nomeintegman";
	public final static String PARAMETRO_CONFIGURAZIONE_INTEGMAN = "integman";
	public final static String PARAMETRO_CONFIGURAZIONE_PROFILO_COLLABORAZIONE = "profcoll";
	public final static String PARAMETRO_CONFIGURAZIONE_CONNESSIONE = "connessione";
	public final static String PARAMETRO_CONFIGURAZIONE_UTILIZZO = "utilizzo";
	public final static String PARAMETRO_CONFIGURAZIONE_VALIDMAN = "validman";
	public final static String PARAMETRO_CONFIGURAZIONE_GESTMAN = "gestman";
	public final static String PARAMETRO_CONFIGURAZIONE_REGISTRAZIONE_TRACCE = "registrazioneTracce";
	public final static String PARAMETRO_CONFIGURAZIONE_DUMP_APPLICATIVO = "dump";
	public final static String PARAMETRO_CONFIGURAZIONE_DUMP_CONNETTORE_PD = "dumpConnettorePD";
	public final static String PARAMETRO_CONFIGURAZIONE_DUMP_CONNETTORE_PA = "dumpConnettorePA";
	public final static String PARAMETRO_CONFIGURAZIONE_XSD = "xsd";
	public final static String PARAMETRO_CONFIGURAZIONE_TIPO_VALIDAZIONE = "tipo_validazione";
	public final static String PARAMETRO_CONFIGURAZIONE_APPLICA_MTOM = CostantiControlStation.PARAMETRO_APPLICA_MTOM_RICHIESTA;
	
	public final static String PARAMETRO_CONFIGURAZIONE_LOG4J_DIAGNOSTICA = "statoLog4jDiagnostica";
	public final static String PARAMETRO_CONFIGURAZIONE_LOG4J_OPENSPCOOP = "statoLog4jOpenspcoop";
	public final static String PARAMETRO_CONFIGURAZIONE_LOG4J_INTEGRATION_MANAGER = "statoLog4jIntegrationManager";
	public final static String PARAMETRO_CONFIGURAZIONE_LOG4J_TRACCIAMENTO = "statoLog4jTracciamento";
	public final static String PARAMETRO_CONFIGURAZIONE_LOG4J_DUMP = "statoLog4jDump";

	public final static String PARAMETRO_CONFIGURAZIONE_STATO_CACHE_REGISTRY = "statocacheRegistry";
	public final static String PARAMETRO_CONFIGURAZIONE_DIMENSIONE_CACHE_REGISTRY = "dimensionecacheRegistry";
	public final static String PARAMETRO_CONFIGURAZIONE_ALGORITMO_CACHE_REGISTRY = "algoritmocacheRegistry";
	public final static String PARAMETRO_CONFIGURAZIONE_IDLE_CACHE_REGISTRY = "idlecacheRegistry";
	public final static String PARAMETRO_CONFIGURAZIONE_LIFE_CACHE_REGISTRY = "lifecacheRegistry";
	
	public final static String PARAMETRO_CONFIGURAZIONE_STATO_CACHE_CONFIG = "statocacheConfig";
	public final static String PARAMETRO_CONFIGURAZIONE_DIMENSIONE_CACHE_CONFIG = "dimensionecacheConfig";
	public final static String PARAMETRO_CONFIGURAZIONE_ALGORITMO_CACHE_CONFIG = "algoritmocacheConfig";
	public final static String PARAMETRO_CONFIGURAZIONE_IDLE_CACHE_CONFIG = "idlecacheConfig";
	public final static String PARAMETRO_CONFIGURAZIONE_LIFE_CACHE_CONFIG = "lifecacheConfig";
	
	public final static String PARAMETRO_CONFIGURAZIONE_STATO_CACHE_AUTH = "statocacheAuth";
	public final static String PARAMETRO_CONFIGURAZIONE_DIMENSIONE_CACHE_AUTH = "dimensionecacheAuth";
	public final static String PARAMETRO_CONFIGURAZIONE_ALGORITMO_CACHE_AUTH = "algoritmocacheAuth";
	public final static String PARAMETRO_CONFIGURAZIONE_IDLE_CACHE_AUTH = "idlecacheAuth";
	public final static String PARAMETRO_CONFIGURAZIONE_LIFE_CACHE_AUTH = "lifecacheAuth";
	
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_NODO_CLUSTER = "aliasNodo";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_NOME_CACHE = "nomeCache";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_NOME_METODO = "nomeMetodo";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_VERSIONE_PDD = "versionePdD";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_VERSIONE_BASE_DATI = "versioneBaseDati";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_VERSIONE_JAVA = "versioneJava";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_DIRECTORY_CONFIGURAZIONE = "directoryConfigurazione";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_INFO_DATABASE = "infoDatabase_";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_INFO_PROTOCOLLO = "infoProtocollo_";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_INFO_PROTOCOLLO_CONTESTO = "infoProtocolloContesto_";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_CACHE_STATO = "Stato";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_CACHE_RESET = "ResetCache";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_CONNESSIONI_DB = "connessioniDB";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_CONNESSIONI_JMS = "connessioniJMS";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_CONNESSIONI_PD = "connessioniPD";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_CONNESSIONI_PA = "connessioniPA";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_EXPORT = "Download";
	public final static String PARAMETRO_CONFIGURAZIONE_SISTEMA_RESET_ALL_CACHES = "ResetAllCaches";
	
	/* LABEL PARAMETRI */
	
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_ID = "id";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_ID_PROPRIETA = "IdProp";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_NOME = "Nome";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_VALORE = "Valore";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_NOME_JNDI = "Nome Jndi";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TIPO_DATABASE = "Tipo Database";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TIPO = "Tipo";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TIPO_ROTTA = "Tipo rotta";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TIPO_SOGGETTO_ROTTA = "Tipo Soggetto";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_NOME_SOGGETTO_ROTTA = "Nome Soggetto";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_REGISTRO_ROTTA = "Registro";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TIPO_ROTTA_REGISTRO = "registro";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TIPO_ROTTA_GATEWAY = "gateway";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_REGISTRO_ROTTA_ALL = "all";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_UTENTE = "Utente";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_PASSWORD = "Password";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CONFERMA_PASSWORD = "Conferma Password";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_LOCATION = "Location";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_INOLTRO_MIN = "Cadenza (min)";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_STATO = "Stato";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CONTROLLO = "Controllo";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_LIVELLO_SEVERITA_LOG4J = "Livello Severit&agrave; Log4J";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_LIVELLO_SEVERITA = "Livello Severit&agrave;";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_NOME_INTEGMAN = "";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_INTEGMAN = "Tipo autenticazione";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_PROFILO_COLLABORAZIONE = "Profilo di collaborazione";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_CONNESSIONE = "Connessione";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_UTILIZZO = "Utilizzo";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_VALIDMAN = "Manifest attachments";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_GESTMAN = "Gestione";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_REGISTRAZIONE_TRACCE = "Buste";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_DUMP_APPLICATIVO = "Dump Applicativo";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_DUMP_CONNETTORE_PD = "Dump Binario Porta Delegata";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_DUMP_CONNETTORE_PA = "Dump Binario Porta Applicativa";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_XSD = "Stato";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_TIPO_VALIDAZIONE = "Tipo";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_STATO_CACHE = "Stato";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_DIMENSIONE_CACHE = "Dimensione (Elementi)";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_ALGORITMO_CACHE = "Algoritmo";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_IDLE_CACHE = "Item Idle Time (Secondi)";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_LIFE_CACHE = "Item Life Time (Secondi)";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_ALGORITMO_CACHE_LRU = "LRU";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_ALGORITMO_CACHE_MRU = "MRU";
	
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_LOG4J_DIAGNOSTICA = "Log4J (openspcoop2_msgDiagnostico.log)";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_LOG4J_OPENSPCOOP = "Log4J (openspcoop2.log)";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_LOG4J_INTEGRATION_MANAGER = "Log4J (openspcoop2_integrationManager.log)";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_LOG4J_TRACCIAMENTO = "Log4J (openspcoop2_tracciamento.log)";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_LOG4J_DUMP = "Log4J (openspcoop2_dump.log)";
	
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_SISTEMA_NODO_CLUSTER = "Porta di Dominio";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_SISTEMA_VERSIONE_PDD = "Versione PdD";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_SISTEMA_VERSIONE_BASE_DATI = "Versione BaseDati";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_SISTEMA_VERSIONE_JAVA = "Versione Java";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_SISTEMA_DIRECTORY_CONFIGURAZIONE = "Directory di Configurazione";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_SISTEMA_INFO_PROTOCOLLO = "Protocollo";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_SISTEMA_INFO_PROTOCOLLO_CONTESTO = "contesti: ";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_SISTEMA_CACHE_STATO = "Stato";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_SISTEMA_CACHE_RESET = "Reset Cache";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_SISTEMA_CONNESSIONI_STATO = "Stato";
	public final static String LABEL_PARAMETRO_CONFIGURAZIONE_SISTEMA_EXPORT = "Download";
	
	
	public final static String RIAVVIO = "<BR><b>Attenzione:</b> Le modifiche saranno operative al prossimo riavvio della PdD";
	public final static String TEMPORANEE = "<BR><b>Attenzione:</b> Le modifiche saranno operative fino al prossimo riavvio della PdD";
	public final static String LABEL_CONFIGURAZIONE_GENERALE_MODIFICATA_CON_SUCCESSO = "Configurazione Generale modificata con successo"+RIAVVIO;
	public final static String LABEL_CONFIGURAZIONE_ACCESSO_REGISTRO_MODIFICATA_CON_SUCCESSO = "Configurazione "+LABEL_CONFIGURAZIONE_REGISTRO+" modificata con successo"+RIAVVIO;
	public final static String LABEL_CONFIGURAZIONE_TABELLA_ROUTING_MODIFICATA_CON_SUCCESSO = "Configurazione "+LABEL_CONFIGURAZIONE_TABELLA_DI_ROUTING+" modificata con successo"+RIAVVIO;
	public final static String LABEL_CONFIGURAZIONE_PROPRIETA_SISTEMA_MODIFICATA_CON_SUCCESSO = "Configurazione "+LABEL_CONFIGURAZIONE_PROPRIETA_SISTEMA+" modificata con successo"+RIAVVIO;
	public final static String LABEL_CONFIGURAZIONE_APPENDER_CON_SUCCESSO = "Configurazione modificata con successo"+RIAVVIO;
	
	
	/* DEFAULT VALUE PARAMETRI */
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TIPO_XML = "xml";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TIPO_UDDI = "uddi";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TIPO_DATABASE_DEFAULT = "default";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TIPO_DB = "db";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TIPO_WEB = "web";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TIPO_WS = "ws";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TIPO_TRACCIAMENTO = "protocol";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TIPO_DIAGNOSTICA = "protocol";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TIPO_ROTTA_REGISTRO = "registro";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_CONTROLLO_RIGIDO = "rigido";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_CONTROLLO_NORMALE = "normale";
	
	
	public final static String DEFAULT_VALUE_ABILITATO = "abilitato";
	public final static String DEFAULT_VALUE_DISABILITATO = "disabilitato";
	
	
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_IM_SSL = "ssl";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_IM_BASIC = "basic";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_IM_BASIC_SSL = "basic,ssl";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_IM_CUSTOM = "custom";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_STATO_WARNING_ONLY = "warningOnly";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_CONNESSIONE_REPLY = "reply";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TIPO_VALIDAZIONE_XSD = "xsd";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TIPO_VALIDAZIONE_WSDL = "wsdl";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_CONNESSIONE_NEW = "new";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_TIPO_DATABASE = "default";
	
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_ALGORITMO_CACHE_LRU = "lru";
	public final static String DEFAULT_VALUE_PARAMETRO_CONFIGURAZIONE_ALGORITMO_CACHE_MRU = "mru";
	
	
	public final static List<String> CONFIGURAZIONE_SISTEMA_CACHE_STATO_ELEMENTI_VISUALIZZATI = new ArrayList<String>();
	static {
		CONFIGURAZIONE_SISTEMA_CACHE_STATO_ELEMENTI_VISUALIZZATI.add("Algoritmo");
		CONFIGURAZIONE_SISTEMA_CACHE_STATO_ELEMENTI_VISUALIZZATI.add("Dimensione");
		CONFIGURAZIONE_SISTEMA_CACHE_STATO_ELEMENTI_VISUALIZZATI.add("ElementiInCache");
		CONFIGURAZIONE_SISTEMA_CACHE_STATO_ELEMENTI_VISUALIZZATI.add("MemoriaOccupata");
		CONFIGURAZIONE_SISTEMA_CACHE_STATO_ELEMENTI_VISUALIZZATI.add("IdleTime");
		CONFIGURAZIONE_SISTEMA_CACHE_STATO_ELEMENTI_VISUALIZZATI.add("LifeTime");
	}
}

	

