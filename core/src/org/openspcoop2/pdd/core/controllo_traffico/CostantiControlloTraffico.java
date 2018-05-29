package org.openspcoop2.pdd.core.controllo_traffico;

public class CostantiControlloTraffico {

	public final static String PDD_CONTEXT_PDD_CONGESTIONATA = "PDD_CONGESTIONATA";
	
	public final static String PDD_CONTEXT_LIST_GROUP_BY_CONDITION = "POLICY_GROUP_BY_CONDITION";
	public final static String PDD_CONTEXT_LIST_UNIQUE_ID_POLICY = "POLICY_IDS";
	public final static String PDD_CONTEXT_LIST_POLICY_APPLICABILE = "POLICY_APPLICABILE";
	public final static String PDD_CONTEXT_MAX_REQUEST_THREAD_REGISTRATO = "MAX_REQUEST_VIOLATED";
	public final static String PDD_CONTEXT_MAX_REQUEST_VIOLATED_EVENTO = "MAX_REQUEST_VIOLATED_EVENTO";
	public final static String PDD_CONTEXT_MAX_REQUEST_VIOLATED_URL_INVOCAZIONE = "MAX_REQUEST_VIOLATED_URL_INVOCAZIONE";
	public final static String PDD_CONTEXT_MAX_REQUEST_VIOLATED_CREDENZIALI = "MAX_REQUEST_VIOLATED_CREDENZIALI";
	
	public final static String PARAMETRO_CONTROLLO_TRAFFICO_REDEFINE_TEMPI_RISPOSTA = "CTRedefineTempiRisposta";
	public final static String PARAMETRO_CONTROLLO_TRAFFICO_CONNECTION_TIMEOUT = "CTConnectionTimeout";
	public final static String PARAMETRO_CONTROLLO_TRAFFICO_READ_TIMEOUT = "CTReadTimeout";
	public final static String PARAMETRO_CONTROLLO_TRAFFICO_TEMPO_MEDIO_RISPOSTA = "CTTempoMedioRisposta";
	
	public final static String HTML_ERROR_TITLE_TEMPLATE = "TITLE"; 
	public final static String HTML_ERROR_MESSAGE_TEMPLATE = "MESSAGE"; 
	public final static String HTML_ERROR = 
		"<html>\n" + 
		"   <head>\n" + 
		"      <title>"+HTML_ERROR_TITLE_TEMPLATE+"</title>\n" + 
		"   </head>\n" + 
		"   <body>\n" + 
		"      <h1>"+HTML_ERROR_TITLE_TEMPLATE+"</h1>\n" + 
		"      <p>"+HTML_ERROR_MESSAGE_TEMPLATE+"</p>\n" + 
		"   </body>\n" + 
		"</html>";
	
	public final static String HTML_429_ERROR =  HTML_ERROR.replace(HTML_ERROR_TITLE_TEMPLATE, "Too Many Requests");
	public final static String HTML_503_ERROR =  HTML_ERROR.replace(HTML_ERROR_TITLE_TEMPLATE, "Service Unavailable");
	public final static String HTML_500_ERROR =  HTML_ERROR.replace(HTML_ERROR_TITLE_TEMPLATE, "Internal Server Error");
}
