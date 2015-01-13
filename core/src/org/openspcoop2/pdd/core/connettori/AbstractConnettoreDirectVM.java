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




package org.openspcoop2.pdd.core.connettori;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.openspcoop2.message.OpenSPCoop2Message;
import org.openspcoop2.pdd.core.autenticazione.Credenziali;
import org.openspcoop2.pdd.logger.OpenSPCoop2Logger;
import org.openspcoop2.pdd.services.connector.ConnectorException;
import org.openspcoop2.pdd.services.connector.DirectVMConnectorInMessage;
import org.openspcoop2.pdd.services.connector.DirectVMConnectorOutMessage;
import org.openspcoop2.protocol.engine.ProtocolFactoryManager;
import org.openspcoop2.protocol.sdk.Busta;
import org.openspcoop2.protocol.sdk.IProtocolFactory;

/**
 * Classe utilizzata per effettuare consegne di messaggi Soap, attraverso
 * l'invocazione di un server http. 
 *
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */

public abstract class AbstractConnettoreDirectVM extends ConnettoreBase {

	/** Logger utilizzato per debug. */
	private Logger log = null;


	/* ********  F I E L D S  P R I V A T I  ******** */

	/** Msg di richiesta */
	private OpenSPCoop2Message requestMsg;
	/** Proprieta' del connettore */
	private java.util.Hashtable<String,String> properties;
	/** Busta */
	private Busta busta;
	/** Proprieta' del trasporto che deve gestire il connettore */
	private java.util.Properties propertiesTrasporto;
	/** Proprieta' urlBased che deve gestire il connettore */
	private java.util.Properties propertiesUrlBased;
	/** Tipo di Autenticazione */
	//private String tipoAutenticazione;
	/** Credenziali per l'autenticazione */
	private Credenziali credenziali;
	/** Identificativo */
	private String idMessaggio;
	
	/** Indicazione se siamo in modalita' debug */
	private boolean debug = false;

	
	
	/* ********  METODI  ******** */

	/**
	 * Si occupa di effettuare la consegna.
	 *
	 * @param request Messaggio da Consegnare
	 * @return true in caso di consegna con successo, false altrimenti
	 * 
	 */
	@Override
	public boolean send(ConnettoreMsg request){

		this.log = OpenSPCoop2Logger.getLoggerOpenSPCoopCore();
		
		if(request==null){
			this.errore = "Messaggio da consegnare is Null (ConnettoreMsg)";
			return false;
		}

		// Raccolta parametri
		try{
			this.requestMsg =  request.getRequestMessage();
		}catch(Exception e){
			this.eccezioneProcessamento = e;
			this.log.error("Errore durante la lettura del messaggio da consegnare: "+e.getMessage(),e);
			this.errore = "Errore durante la lettura del messaggio da consegnare: "+e.getMessage();
			return false;
		}
		this.properties = request.getConnectorProperties();
		this.busta = request.getBusta();
		if(this.busta!=null)
			this.idMessaggio=this.busta.getID();
		this.propertiesTrasporto = request.getPropertiesTrasporto();
		this.propertiesUrlBased = request.getPropertiesUrlBased();
		this.credenziali = request.getCredenziali();

		// analisi messaggio da spedire
		if(this.requestMsg==null){
			this.errore = "Messaggio da consegnare is Null (Msg)";
			return false;
		}

		// analsi i parametri specifici per il connettore
		if(this.properties == null)
			this.errore = "Proprieta' del connettore non definite";
		if(this.properties.size() == 0)
			this.errore = "Proprieta' del connettore non definite";

		// Debug mode
		if(this.properties.get("debug")!=null){
			if("true".equalsIgnoreCase(this.properties.get("debug").trim()))
				this.debug = true;
		}
		
		// Context per invocazioni handler
		this.outRequestContext = request.getOutRequestContext();
		this.msgDiagnostico = request.getMsgDiagnostico();

		// protocol
		IProtocolFactory pFactory = null;
		try{
			pFactory = this.buildProtocolFactoryForForwardMessage(this.properties);
		}catch(Exception e){
			this.errore = e.getMessage();
			return false;
		}
				
		// credenziali
		if(this.credenziali==null){
			String user = this.properties.get("user");
			String password = this.properties.get("password");
			String subject = this.properties.get("subject");
			if(user!=null || password!=null || subject!=null){
				this.credenziali = new Credenziali();
				this.credenziali.setUsername(user);
				this.credenziali.setPassword(password);
				this.credenziali.setSubject(subject);
			}
		}
		
		// Il Validate legge ulteriori proprieta' che poi vengono usate dal buildLocation
		if(this.validate(request)){	
			
			// location
			try{
				if(this.debug)
					this.log.debug("["+this.idMessaggio+"] creazione URL...");
				this.buildLocation(this.properties,true);
			}catch(Exception e){
				this.errore = e.getMessage();
				return false;
			}
			
			return sendByVM(pFactory);
		}
		else{
			return false;
		}

	}

	private IProtocolFactory buildProtocolFactoryForForwardMessage(Hashtable<String, String> properties) throws Exception{
		// protocol
		IProtocolFactory pFactory = this.getProtocolFactory();
		String protocol = properties.get("protocol");
		if(protocol!=null){
			try{
				pFactory = ProtocolFactoryManager.getInstance().getProtocolFactoryByName(protocol);
			}catch(Exception e){
				throw new Exception("Proprieta' 'protocol' fornita contiene un tipo di protocollo ["+protocol+"] non valido: "+e.getMessage());
			}
		}
		return pFactory;
	}
	
	public void buildLocation(Hashtable<String, String> properties, boolean setFormBasedParameter) throws Exception{
		
		// protocol
		IProtocolFactory pFactory = buildProtocolFactoryForForwardMessage(properties);
		
		// context
		String webContext = "openspcoop2";
		String context = properties.get("context");
		if(context!=null){
			webContext = context;
		}
		
		this.location = "/"+webContext+"/"+pFactory.getProtocol()+"/"+this.getFunction();
		String suffix = this.getFunctionParameters();
		if(suffix!=null && !"".equals(suffix)){
			this.location = this.location + "/"+suffix;
		}
		
		if(setFormBasedParameter){
			if(this.propertiesUrlBased != null && this.propertiesUrlBased.size()>0){
				this.location = ConnettoreUtils.buildLocationWithURLBasedParameter(this.propertiesUrlBased, this.location);
			}
		}
	}
	

	/**
	 * Si occupa di effettuare la consegna SOAP (invocazione di un WebService).
	 * Si aspetta di ricevere una risposta non sbustata.
	 *
	 * @return true in caso di consegna con successo, false altrimenti
	 * 
	 */
	private boolean sendByVM(IProtocolFactory pFactory){
		try{
			
			DirectVMConnectorInMessage inMessage = new DirectVMConnectorInMessage(this.requestMsg, 
					this.getIdModulo(), 
					this.propertiesTrasporto,
					this.propertiesUrlBased,
					pFactory,
					this.getFunction(), 
					this.location, this.credenziali,
					this.getFunctionParameters());
			
			DirectVMConnectorOutMessage outMessage = new DirectVMConnectorOutMessage();
			
			this.process(inMessage, outMessage);
			
			this.responseMsg = outMessage.getMessage();
			this.contentLength = outMessage.getContentLength();
			this.propertiesTrasportoRisposta = outMessage.getHeaders();
			this.codice = outMessage.getStatus();
			
			
			
			
			
			/* ------------  PostOutRequestHandler ------------- */
			this.postOutRequest();
			
			
			
			
			
//			/* ------------  PreInResponseHandler ------------- */
			// Con connettore Direct non e' utilizzabile
//			this.preInResponse();
//			
//			// Lettura risposta parametri NotifierInputStream per la risposta
//			org.openspcoop.utils.io.notifier.NotifierInputStreamParams notifierInputStreamParams = null;
//			if(this.preInResponseContext!=null){
//				notifierInputStreamParams = this.preInResponseContext.getNotifierInputStreamParams();
//			}
			
			
			return true;
		}  catch(Exception e){ 
			this.eccezioneProcessamento = e;
			this.log.error("Errore avvenuto durante la consegna SOAP: "+e.getMessage());
			this.errore = "Errore avvenuto durante la consegna SOAP: "+e.getMessage();
			return false;
		}	
    }
    
	public abstract boolean validate(ConnettoreMsg request);
	public abstract String getFunctionParameters();
	public abstract String getIdModulo();
	public abstract String getFunction();
	public abstract void process(DirectVMConnectorInMessage inMessage,DirectVMConnectorOutMessage outMessage) throws ConnectorException;
	
	
	protected String normalizeFunctionParamters(String value){
		if(value==null){
			return null;
		}
		if(value.contains("?")){
			return value.substring(0,value.indexOf("?"));
		}
		else{
			return value;
		}
	}
}





