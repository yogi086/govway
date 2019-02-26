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



package org.openspcoop2.pdd.core.integrazione;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;

import org.openspcoop2.core.constants.Costanti;
import org.openspcoop2.core.id.IDServizio;
import org.openspcoop2.core.id.IDSoggetto;

import org.openspcoop2.message.OpenSPCoop2SoapMessage;
import org.openspcoop2.message.constants.MessageType;
import org.openspcoop2.message.exception.MessageNotSupportedException;
import org.openspcoop2.message.soap.SoapUtils;
import org.openspcoop2.message.xml.ValidatoreXSD;
import org.openspcoop2.pdd.config.OpenSPCoop2Properties;
import org.openspcoop2.pdd.core.CostantiPdD;
import org.openspcoop2.pdd.core.PdDContext;
import org.openspcoop2.pdd.logger.OpenSPCoop2Logger;
import org.openspcoop2.utils.transport.http.HttpConstants;
import org.openspcoop2.utils.xml.XSDResourceResolver;
import org.slf4j.Logger;


/**
 * Classe contenenti utilities per le integrazioni.
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class UtilitiesIntegrazione {


	// ***** STATIC *****

	private static final boolean PORTA_DELEGATA = true;
	private static final boolean PORTA_APPLICATIVA = false;
	private static final boolean REQUEST = true;
	private static final boolean RESPONSE = false;
	
	private static UtilitiesIntegrazione utilitiesIntegrazionePDRequest = null;
	private static UtilitiesIntegrazione utilitiesIntegrazionePDResponse = null;
	private static UtilitiesIntegrazione utilitiesIntegrazionePARequest = null;
	private static UtilitiesIntegrazione utilitiesIntegrazionePAResponse = null;
	public static UtilitiesIntegrazione getInstancePDRequest(Logger log){
		if(UtilitiesIntegrazione.utilitiesIntegrazionePDRequest==null){
			UtilitiesIntegrazione.initialize(log,PORTA_DELEGATA,REQUEST);
		}
		return UtilitiesIntegrazione.utilitiesIntegrazionePDRequest;
	}
	public static UtilitiesIntegrazione getInstancePDResponse(Logger log){
		if(UtilitiesIntegrazione.utilitiesIntegrazionePDResponse==null){
			UtilitiesIntegrazione.initialize(log,PORTA_DELEGATA,RESPONSE);
		}
		return UtilitiesIntegrazione.utilitiesIntegrazionePDResponse;
	}
	public static UtilitiesIntegrazione getInstancePARequest(Logger log){
		if(UtilitiesIntegrazione.utilitiesIntegrazionePARequest==null){
			UtilitiesIntegrazione.initialize(log,PORTA_APPLICATIVA,REQUEST);
		}
		return UtilitiesIntegrazione.utilitiesIntegrazionePARequest;
	}
	public static UtilitiesIntegrazione getInstancePAResponse(Logger log){
		if(UtilitiesIntegrazione.utilitiesIntegrazionePAResponse==null){
			UtilitiesIntegrazione.initialize(log,PORTA_APPLICATIVA,RESPONSE);
		}
		return UtilitiesIntegrazione.utilitiesIntegrazionePAResponse;
	}

	private static synchronized void initialize(Logger log,boolean portaDelegata, boolean request){
		if(portaDelegata) {
			if(request) {
				if(UtilitiesIntegrazione.utilitiesIntegrazionePDRequest==null){
					UtilitiesIntegrazione.utilitiesIntegrazionePDRequest = new UtilitiesIntegrazione(log, portaDelegata, request);
				}
			}
			else {
				if(UtilitiesIntegrazione.utilitiesIntegrazionePDResponse==null){
					UtilitiesIntegrazione.utilitiesIntegrazionePDResponse = new UtilitiesIntegrazione(log, portaDelegata, request);
				}
			}
		}
		else {
			if(request) {
				if(UtilitiesIntegrazione.utilitiesIntegrazionePARequest==null){
					UtilitiesIntegrazione.utilitiesIntegrazionePARequest = new UtilitiesIntegrazione(log, portaDelegata, request);
				}
			}
			else {
				if(UtilitiesIntegrazione.utilitiesIntegrazionePAResponse==null){
					UtilitiesIntegrazione.utilitiesIntegrazionePAResponse = new UtilitiesIntegrazione(log, portaDelegata, request);
				}
			}
		}
	}

	
	
	
	// ***** INSTANCE *****

	private List<String> keywordsIntegrazione = null;
	
	private java.util.Properties keyValueIntegrazioneTrasporto = null;
	private HashMap<String, Boolean> keySetEnabled_HeaderIntegrazioneTrasporto = null;
	private HashMap<String, Boolean> keyReadEnabled_HeaderIntegrazioneTrasporto = null;
	
	private java.util.Properties keyValueIntegrazioneUrlBased = null;
	private HashMap<String, Boolean> keySetEnabled_HeaderIntegrazioneUrlBased = null;
	private HashMap<String, Boolean> keyReadEnabled_HeaderIntegrazioneUrlBased = null;
	
	private java.util.Properties keyValueIntegrazioneSoap = null;
	private HashMap<String, Boolean> keySetEnabled_HeaderIntegrazioneSoap = null;
	private HashMap<String, Boolean> keyReadEnabled_HeaderIntegrazioneSoap = null;
	
	private OpenSPCoop2Properties openspcoopProperties = null;
	private ValidatoreXSD validatoreXSD_soap11 = null;
	private ValidatoreXSD validatoreXSD_soap12 = null;
	
	private boolean request;
	
	private UtilitiesIntegrazione(Logger log, boolean portaDelegata, boolean request){
		this.openspcoopProperties = OpenSPCoop2Properties.getInstance();
		
		this.request = request;
		
		this.keywordsIntegrazione = this.openspcoopProperties.getKeywordsIntegrazione();
		
		this.keyValueIntegrazioneTrasporto = this.openspcoopProperties.getKeyValue_HeaderIntegrazioneTrasporto();
		try{
			if(portaDelegata) {
				this.keySetEnabled_HeaderIntegrazioneTrasporto = this.openspcoopProperties.getKeyPDSetEnabled_HeaderIntegrazioneTrasporto(request);
				this.keyReadEnabled_HeaderIntegrazioneTrasporto = this.openspcoopProperties.getKeyPDReadEnabled_HeaderIntegrazioneTrasporto();
			}
			else {
				this.keySetEnabled_HeaderIntegrazioneTrasporto = this.openspcoopProperties.getKeyPASetEnabled_HeaderIntegrazioneTrasporto(request);
				this.keyReadEnabled_HeaderIntegrazioneTrasporto = this.openspcoopProperties.getKeyPAReadEnabled_HeaderIntegrazioneTrasporto();
			}
		}catch(Exception e){
			log.error("Integrazione, errore durante la lettura del file di configurazione: "+e.getMessage(),e);
		}
		
		this.keyValueIntegrazioneUrlBased = this.openspcoopProperties.getKeyValue_HeaderIntegrazioneUrlBased();
		try{
			if(portaDelegata) {
				this.keySetEnabled_HeaderIntegrazioneUrlBased = this.openspcoopProperties.getKeyPDSetEnabled_HeaderIntegrazioneUrlBased();
				this.keyReadEnabled_HeaderIntegrazioneUrlBased = this.openspcoopProperties.getKeyPDReadEnabled_HeaderIntegrazioneUrlBased();
			}
			else {
				this.keySetEnabled_HeaderIntegrazioneUrlBased = this.openspcoopProperties.getKeyPASetEnabled_HeaderIntegrazioneUrlBased();
				this.keyReadEnabled_HeaderIntegrazioneUrlBased = this.openspcoopProperties.getKeyPAReadEnabled_HeaderIntegrazioneUrlBased();
			}
		}catch(Exception e){
			log.error("Integrazione, errore durante la lettura del file di configurazione: "+e.getMessage(),e);
		}
		
		this.keyValueIntegrazioneSoap = this.openspcoopProperties.getKeyValue_HeaderIntegrazioneSoap();
		try{
			if(portaDelegata) {
				this.keySetEnabled_HeaderIntegrazioneSoap = this.openspcoopProperties.getKeyPDSetEnabled_HeaderIntegrazioneSoap(request);
				this.keyReadEnabled_HeaderIntegrazioneSoap = this.openspcoopProperties.getKeyPDReadEnabled_HeaderIntegrazioneSoap();
			}
			else {
				this.keySetEnabled_HeaderIntegrazioneSoap = this.openspcoopProperties.getKeyPASetEnabled_HeaderIntegrazioneSoap(request);
				this.keyReadEnabled_HeaderIntegrazioneSoap = this.openspcoopProperties.getKeyPAReadEnabled_HeaderIntegrazioneSoap();
			}
		}catch(Exception e){
			log.error("Integrazione, errore durante la lettura del file di configurazione: "+e.getMessage(),e);
		}
		
		try{
			XSDResourceResolver xsdResourceResolver_soap11 = new XSDResourceResolver();
			xsdResourceResolver_soap11.addResource("soapEnvelope.xsd", UtilitiesIntegrazione.class.getResourceAsStream("/soapEnvelope.xsd"));
			this.validatoreXSD_soap11 = new ValidatoreXSD(log,xsdResourceResolver_soap11,UtilitiesIntegrazione.class.getResourceAsStream("/integrazione_soap11.xsd"));
		}catch(Exception e){
			log.error("Integrazione.xsd, errore durante la costruzione del validatore xsd per Soap11: "+e.getMessage(),e);
		}
		
		try{
			XSDResourceResolver xsdResourceResolver_soap12 = new XSDResourceResolver();
			xsdResourceResolver_soap12.addResource("soapEnvelope12.xsd", UtilitiesIntegrazione.class.getResourceAsStream("/soapEnvelope12.xsd"));
			xsdResourceResolver_soap12.addResource("xml.xsd", UtilitiesIntegrazione.class.getResourceAsStream("/xml.xsd"));
			this.validatoreXSD_soap12 = new ValidatoreXSD(log,xsdResourceResolver_soap12,UtilitiesIntegrazione.class.getResourceAsStream("/integrazione_soap12.xsd"));
		}catch(Exception e){
			log.error("Integrazione.xsd, errore durante la costruzione del validatore xsd per Soap11: "+e.getMessage(),e);
		}
	}
	
	public void readTransportProperties(java.util.Properties prop,
			HeaderIntegrazione integrazione) throws HeaderIntegrazioneException{
		try{
			if(prop!=null && integrazione!=null){
								
				// Ricerca tra l'header del trasporto
				java.util.Enumeration<?> keys =  prop.propertyNames();
				while(keys.hasMoreElements()){
					String key = (String) keys.nextElement();

					if(key!=null){
						
						for (String keywordIntegrazione : this.keywordsIntegrazione) {
							if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneTrasporto.get(keywordIntegrazione))) {
								
								if(this.keyReadEnabled_HeaderIntegrazioneTrasporto.get(keywordIntegrazione)) {
								
									// Busta
									if(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE.equals(keywordIntegrazione)) {
										integrazione.getBusta().setTipoMittente(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE.equals(keywordIntegrazione)) {
										integrazione.getBusta().setMittente(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO.equals(keywordIntegrazione)) {
										integrazione.getBusta().setTipoDestinatario(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO.equals(keywordIntegrazione)) {
										integrazione.getBusta().setDestinatario(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO.equals(keywordIntegrazione)) {
										integrazione.getBusta().setTipoServizio(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO.equals(keywordIntegrazione)) {
										integrazione.getBusta().setServizio(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_VERSIONE_SERVIZIO.equals(keywordIntegrazione)) {
										try{
											integrazione.getBusta().setVersioneServizio(Integer.parseInt(prop.getProperty(key)));
										}catch(Exception e){
											throw new Exception("Formato versione ["+prop.getProperty(key)+"] non corretto: "+e.getMessage(),e);
										}
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE.equals(keywordIntegrazione)) {
										integrazione.getBusta().setAzione(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO.equals(keywordIntegrazione)) {
										integrazione.getBusta().setID(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO.equals(keywordIntegrazione)) {
										integrazione.getBusta().setRiferimentoMessaggio(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE.equals(keywordIntegrazione)) {
										integrazione.getBusta().setIdCollaborazione(prop.getProperty(key));	
									}
									
									// id e servizio applicativo
									else if(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO.equals(keywordIntegrazione)) {
										integrazione.setIdApplicativo(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO.equals(keywordIntegrazione)) {
										integrazione.setServizioApplicativo(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_ID_TRANSAZIONE.equals(keywordIntegrazione)) {
										integrazione.setIdTransazione(prop.getProperty(key));	
									}
								}
								break;
							}
						}
						
					}
				}
			}
		}catch(Exception e){
			throw new HeaderIntegrazioneException("UtilitiesIntegrazione, lettura dell'header non riuscita: "+e.getMessage(),e);
		}
	}
	
	public void readUrlProperties(java.util.Properties prop,
			HeaderIntegrazione integrazione) throws HeaderIntegrazioneException{
		try{
			if(prop!=null && integrazione!=null){
			
				// Ricerca tra le proprieta' dell'url
				java.util.Enumeration<?> keys =  prop.propertyNames();
				while(keys.hasMoreElements()){
					String key = (String) keys.nextElement();

					if(key!=null){
						
						for (String keywordIntegrazione : this.keywordsIntegrazione) {
							if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneUrlBased.get(keywordIntegrazione))) {
								
								if(this.keyReadEnabled_HeaderIntegrazioneUrlBased.get(keywordIntegrazione)) {
								
									// Busta
									if(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE.equals(keywordIntegrazione)) {
										integrazione.getBusta().setTipoMittente(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE.equals(keywordIntegrazione)) {
										integrazione.getBusta().setMittente(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO.equals(keywordIntegrazione)) {
										integrazione.getBusta().setTipoDestinatario(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO.equals(keywordIntegrazione)) {
										integrazione.getBusta().setDestinatario(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO.equals(keywordIntegrazione)) {
										integrazione.getBusta().setTipoServizio(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO.equals(keywordIntegrazione)) {
										integrazione.getBusta().setServizio(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_VERSIONE_SERVIZIO.equals(keywordIntegrazione)) {
										try{
											integrazione.getBusta().setVersioneServizio(Integer.parseInt(prop.getProperty(key)));
										}catch(Exception e){
											throw new Exception("Formato versione ["+prop.getProperty(key)+"] non corretto: "+e.getMessage(),e);
										}
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE.equals(keywordIntegrazione)) {
										integrazione.getBusta().setAzione(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO.equals(keywordIntegrazione)) {
										integrazione.getBusta().setID(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO.equals(keywordIntegrazione)) {
										integrazione.getBusta().setRiferimentoMessaggio(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE.equals(keywordIntegrazione)) {
										integrazione.getBusta().setIdCollaborazione(prop.getProperty(key));	
									}
									
									// id e servizio applicativo
									else if(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO.equals(keywordIntegrazione)) {
										integrazione.setIdApplicativo(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO.equals(keywordIntegrazione)) {
										integrazione.setServizioApplicativo(prop.getProperty(key));	
									}
									else if(CostantiPdD.HEADER_INTEGRAZIONE_ID_TRANSAZIONE.equals(keywordIntegrazione)) {
										integrazione.setIdTransazione(prop.getProperty(key));	
									}
								}
								break;
							}
						}
						
					}
				}
			}
		}catch(Exception e){
			throw new HeaderIntegrazioneException("UtilitiesIntegrazione, lettura dell'header non riuscita: "+e.getMessage(),e);
		}
	}
	


	public void setUrlProperties(HeaderIntegrazione integrazione,
			java.util.Properties properties,
			Map<String, String> protocolInfos) throws HeaderIntegrazioneException{

		try{
			if(properties!=null && integrazione!=null){
				if(integrazione.getBusta()!=null){				
					if(integrazione.getBusta().getTipoMittente()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE)) {
							properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE), integrazione.getBusta().getTipoMittente());
						}
					}
					if(integrazione.getBusta().getMittente()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE)) {
							properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE), integrazione.getBusta().getMittente());
						}
					}
					if(integrazione.getBusta().getTipoDestinatario()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO)) {
							properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO), integrazione.getBusta().getTipoDestinatario());
						}
					}
					if(integrazione.getBusta().getDestinatario()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO)) {
							properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO), integrazione.getBusta().getDestinatario());
						}
					}
					if(integrazione.getBusta().getTipoServizio()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO)) {
							properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO), integrazione.getBusta().getTipoServizio());
						}
					}
					if(integrazione.getBusta().getServizio()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO)) {
							properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO), integrazione.getBusta().getServizio());
						}
					}
					if(integrazione.getBusta().getVersioneServizio()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_VERSIONE_SERVIZIO)) {
							properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_VERSIONE_SERVIZIO), integrazione.getBusta().getVersioneServizio().intValue()+"");
						}
					}
					if(integrazione.getBusta().getAzione()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE)) {
							properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE), integrazione.getBusta().getAzione());
						}
					}
					if(integrazione.getBusta().getID()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO)) {
							properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO), integrazione.getBusta().getID());
						}
					}
					if(integrazione.getBusta().getRiferimentoMessaggio()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO)) {
							properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO), integrazione.getBusta().getRiferimentoMessaggio());
						}
					}
					if(integrazione.getBusta().getIdCollaborazione()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE)) {
							properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE), integrazione.getBusta().getIdCollaborazione());
						}
					}
				}
				if(integrazione.getIdApplicativo()!=null) {
					if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO)) {
						properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO), integrazione.getIdApplicativo());
					}
				}
				if(integrazione.getServizioApplicativo()!=null) {
					if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO)) {
						properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO), integrazione.getServizioApplicativo());
					}
				}
				if(integrazione.getIdTransazione()!=null) {
					if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_TRANSAZIONE)) {
						properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_TRANSAZIONE), integrazione.getIdTransazione());
					}
				}
			}
			if(properties!=null){
//				properties.put(CostantiPdD.URL_BASED_PDD,URLEncoder.encode(this.openspcoopProperties.getHttpServer(),"UTF-8"));
//				if(this.openspcoopProperties.getHttpXPdDDetails()!=null && !"".equals(this.openspcoopProperties.getHttpXPdDDetails())){
//					properties.put(CostantiPdD.URL_BASED_PDD_DETAILS,URLEncoder.encode(this.openspcoopProperties.getHttpXPdDDetails(),"UTF-8"));
//				}
				// Non deve essere effettuato a questo livello l'URLEncoder altrimenti si ottiene una doppia codifica, essendo poi fatta anche per tutti i valori in ConnettoreUtils.
				
				if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_INFO)) {
					properties.put(CostantiPdD.URL_BASED_PDD,this.openspcoopProperties.getHttpServer());
					if(this.openspcoopProperties.getHttpXPdDDetails()!=null && !"".equals(this.openspcoopProperties.getHttpXPdDDetails())){
						properties.put(CostantiPdD.URL_BASED_PDD_DETAILS,this.openspcoopProperties.getHttpXPdDDetails());
					}
				}

				if(this.keySetEnabled_HeaderIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_PROTOCOL_INFO)) {
					// protocol info
					if(protocolInfos!=null && protocolInfos.size()>0){
						Iterator<String> itProtocolInfos = protocolInfos.keySet().iterator();
						while (itProtocolInfos.hasNext()) {
							String name = (String) itProtocolInfos.next();
							String value = protocolInfos.get(name);
							properties.put(name,value);
						}
					}
				}
			}
			
		}catch(Exception e){
			throw new HeaderIntegrazioneException("UtilitiesIntegrazione, creazione delle proprieta' dell'header non riuscita: "+e.getMessage(),e);
		}
	}
	
	public void setInfoProductTransportProperties(java.util.Properties properties) throws HeaderIntegrazioneException{
		setTransportProperties(null, properties, null);
	}
	public void setTransportProperties(HeaderIntegrazione integrazione,
			java.util.Properties properties,
			Map<String, String> protocolInfos) throws HeaderIntegrazioneException{

		try{
			if(properties!=null && integrazione!=null){
				if(integrazione.getBusta()!=null){
					if(integrazione.getBusta().getTipoMittente()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE)) {
							properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE), integrazione.getBusta().getTipoMittente());
						}
					}
					if(integrazione.getBusta().getMittente()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE)) {
							properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE), integrazione.getBusta().getMittente());
						}
					}
					if(integrazione.getBusta().getTipoDestinatario()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO)) {
							properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO), integrazione.getBusta().getTipoDestinatario());
						}
					}
					if(integrazione.getBusta().getDestinatario()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO)) {
							properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO), integrazione.getBusta().getDestinatario());
						}
					}
					if(integrazione.getBusta().getTipoServizio()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO)) {
							properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO), integrazione.getBusta().getTipoServizio());
						}
					}
					if(integrazione.getBusta().getServizio()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO)) {
							properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO), integrazione.getBusta().getServizio());
						}
					}
					if(integrazione.getBusta().getVersioneServizio()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_VERSIONE_SERVIZIO)) {
							properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_VERSIONE_SERVIZIO), integrazione.getBusta().getVersioneServizio().intValue()+"");
						}
					}
					if(integrazione.getBusta().getAzione()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE)) {
							properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE), integrazione.getBusta().getAzione());
						}
					}
					if(integrazione.getBusta().getID()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO)) {
							properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO), integrazione.getBusta().getID());
						}
					}
					if(integrazione.getBusta().getRiferimentoMessaggio()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO)) {
							properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO), integrazione.getBusta().getRiferimentoMessaggio());
						}
					}
					if(integrazione.getBusta().getIdCollaborazione()!=null) {
						if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE)) {
							properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE), integrazione.getBusta().getIdCollaborazione());
						}
					}
				}
				if(integrazione.getIdApplicativo()!=null) {
					if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO)) {
						properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO), integrazione.getIdApplicativo());
					}
				}
				if(integrazione.getServizioApplicativo()!=null) {
					if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO)) {
						properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO), integrazione.getServizioApplicativo());
					}
				}
				if(integrazione.getIdTransazione()!=null) {
					if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_TRANSAZIONE)) {
						properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_TRANSAZIONE), integrazione.getIdTransazione());
					}
				}
			}
			if(properties!=null){
				
				boolean infoProduct = this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_INFO);
				if(infoProduct) {
					if(properties.containsKey(CostantiPdD.HEADER_HTTP_X_PDD)==false) {
						properties.put(CostantiPdD.HEADER_HTTP_X_PDD,this.openspcoopProperties.getHttpServer());
					}
					if(this.openspcoopProperties.getHttpXPdDDetails()!=null && !"".equals(this.openspcoopProperties.getHttpXPdDDetails())){
						if(properties.containsKey(CostantiPdD.HEADER_HTTP_X_PDD_DETAILS)==false) {
							properties.put(CostantiPdD.HEADER_HTTP_X_PDD_DETAILS,this.openspcoopProperties.getHttpXPdDDetails());
						}
					}
				}
				
				boolean userAgent = this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_USER_AGENT);
				if(userAgent) {
					if(this.request) {
						if(properties.containsKey(HttpConstants.USER_AGENT)==false) {
							properties.put(HttpConstants.USER_AGENT,this.openspcoopProperties.getHttpUserAgent());
						}
					}
					else {
						if(properties.containsKey(HttpConstants.SERVER)==false) {
							properties.put(HttpConstants.SERVER,this.openspcoopProperties.getHttpUserAgent());
						}
					}
				}
				
				if(this.keySetEnabled_HeaderIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_PROTOCOL_INFO)) {
					if(protocolInfos!=null && protocolInfos.size()>0){
						Iterator<String> itProtocolInfos = protocolInfos.keySet().iterator();
						while (itProtocolInfos.hasNext()) {
							String name = (String) itProtocolInfos.next();
							String value = protocolInfos.get(name);
							properties.put(name,value);
						}
					}
				}
				
			}
		}catch(Exception e){
			throw new HeaderIntegrazioneException("UtilitiesIntegrazione, creazione delle proprieta' dell'header non riuscita: "+e.getMessage(),e);
		}
	}
	
	

	public void readHeader(OpenSPCoop2SoapMessage message,HeaderIntegrazione integrazione,
			String actorIntegrazione) throws HeaderIntegrazioneException{
		
		
		try{			
			if(actorIntegrazione==null)
				throw new Exception("Actor non definito");
			SOAPHeader header = message.getSOAPHeader();
			if(header==null){
				OpenSPCoop2Logger.getLoggerOpenSPCoopCore().debug("SOAPHeader non presente");
				return;
			}
			SOAPHeaderElement headerElement = null;
			java.util.Iterator<?> it = header.examineAllHeaderElements();
			while( it.hasNext()  ){
				// Test Header Element
				headerElement = (SOAPHeaderElement) it.next();
				//Controllo Actor
				String actorCheck = SoapUtils.getSoapActor(headerElement, message.getMessageType());
				if( actorIntegrazione.equals(actorCheck) ){
					break;
				}else{
					headerElement = null;
				}
			}
			if(headerElement==null){
				OpenSPCoop2Logger.getLoggerOpenSPCoopCore().debug("Header di integrazione non presente");
				return;
			}
			
			// validazione XSD
			if(MessageType.SOAP_11.equals(message.getMessageType())){
				if(this.validatoreXSD_soap11==null)
					throw new Exception("Validatore XSD (Soap11) non istanziato");
				this.validatoreXSD_soap11.valida(new java.io.ByteArrayInputStream(message.getAsByte(headerElement, false)));
			}
			else if(MessageType.SOAP_12.equals(message.getMessageType())){
				if(this.validatoreXSD_soap12==null)
					throw new Exception("Validatore XSD (Soap12) non istanziato");
				this.validatoreXSD_soap12.valida(new java.io.ByteArrayInputStream(message.getAsByte(headerElement, false)));
			}
			else{
				throw MessageNotSupportedException.newMessageNotSupportedException(message.getMessageType());
			}

			
			// Ricerca tra gli attributi dell'header SOAP
			String tipoMittente = null;
			try{
				if(this.keyReadEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE)) {
					tipoMittente = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE));
				}
			}catch(Exception e){}
			if(tipoMittente!=null && tipoMittente.compareTo("")!=0)
				integrazione.getBusta().setTipoMittente(tipoMittente);
			
			String mittente = null;
			try{
				if(this.keyReadEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE)) {
					mittente = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE));
				}
			}catch(Exception e){}
			if(mittente!=null && mittente.compareTo("")!=0)
				integrazione.getBusta().setMittente(mittente);
			
			String tipoDestinatario = null;
			try{
				if(this.keyReadEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO)) {
					tipoDestinatario = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO));
				}
			}catch(Exception e){}
			if(tipoDestinatario!=null && tipoDestinatario.compareTo("")!=0)
				integrazione.getBusta().setTipoDestinatario(tipoDestinatario);
			
			String destinatario = null;
			try{
				if(this.keyReadEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO)) {
					destinatario = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO));
				}
			}catch(Exception e){}
			if(destinatario!=null && destinatario.compareTo("")!=0)
				integrazione.getBusta().setDestinatario(destinatario);

			String tipoServizio = null;
			try{
				if(this.keyReadEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO)) {
					tipoServizio = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO));
				}
			}catch(Exception e){}
			if(tipoServizio!=null && tipoServizio.compareTo("")!=0)
				integrazione.getBusta().setTipoServizio(tipoServizio);
			
			String servizio = null;
			try{
				if(this.keyReadEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO)) {
					servizio = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO));
				}
			}catch(Exception e){}
			if(servizio!=null && servizio.compareTo("")!=0)
				integrazione.getBusta().setServizio(servizio);
			
			String versioneServizio = null;
			try{
				if(this.keyReadEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_VERSIONE_SERVIZIO)) {
					versioneServizio = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_VERSIONE_SERVIZIO));
				}
			}catch(Exception e){}
			if(versioneServizio!=null && versioneServizio.compareTo("")!=0){
				try{
					integrazione.getBusta().setVersioneServizio(Integer.parseInt(versioneServizio));
				}catch(Exception e){
					throw new Exception("Formato versione ["+versioneServizio+"] non corretto: "+e.getMessage(),e);
				}
			}

			String azione= null;
			try{
				if(this.keyReadEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE)) {
					azione= headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE));
				}
			}catch(Exception e){}
			if(azione!=null && azione.compareTo("")!=0)
				integrazione.getBusta().setAzione(azione);

			String idBusta = null;
			try{
				if(this.keyReadEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO)) {
					idBusta = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO));
				}
			}catch(Exception e){}
			if(idBusta!=null && idBusta.compareTo("")!=0)
				integrazione.getBusta().setID(idBusta);

			String riferimentoMessaggio = null;
			try{
				if(this.keyReadEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO)) {
					riferimentoMessaggio = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO));
				}
			}catch(Exception e){}
			if(riferimentoMessaggio!=null && riferimentoMessaggio.compareTo("")!=0)
				integrazione.getBusta().setRiferimentoMessaggio(riferimentoMessaggio);

			String collaborazione = null;
			try{
				if(this.keyReadEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE)) {
					collaborazione = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE));
				}
			}catch(Exception e){}
			if(collaborazione!=null && collaborazione.compareTo("")!=0)
				integrazione.getBusta().setIdCollaborazione(collaborazione);

			String idApplicativo = null;
			try{
				if(this.keyReadEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO)) {
					idApplicativo = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO));
				}
			}catch(Exception e){}
			if(idApplicativo!=null && idApplicativo.compareTo("")!=0)
				integrazione.setIdApplicativo(idApplicativo);

			String sa = null;
			try{
				if(this.keyReadEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO)) {
					sa = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO));
				}
			}catch(Exception e){}
			if(sa!=null && sa.compareTo("")!=0)
				integrazione.setServizioApplicativo(sa);
			
			String idTransazione = null;
			try{
				if(this.keyReadEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_TRANSAZIONE)) {
					idTransazione = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_TRANSAZIONE));
				}
			}catch(Exception e){}
			if(idTransazione!=null && idTransazione.compareTo("")!=0)
				integrazione.setIdTransazione(idTransazione);
			
		}catch(Exception e){
			throw new HeaderIntegrazioneException("UtilitiesIntegrazione, lettura dell'header soap non riuscita: "+e.getMessage(),e);
		}
	}

	public void updateHeader(OpenSPCoop2SoapMessage message,IDSoggetto soggettoFruitore,IDServizio idServizio,
			String idBusta,String servizioApplicativo,
			String correlazioneApplicativa,String riferimentoCorrelazioneApplicativaRichiesta, String idTransazione,
			String actorIntegrazione,String nomeElemento,String prefix,String namespace,
			String proprietaProtocolloNomeElemento,String proprietaProtocolloNomeTipoElemento,
			Map<String, String> protocolInfos) throws Exception{
		updateHeader(message, soggettoFruitore, idServizio, idBusta, null, 
				servizioApplicativo, correlazioneApplicativa, riferimentoCorrelazioneApplicativaRichiesta, idTransazione,
				actorIntegrazione, nomeElemento, prefix, namespace, 
				proprietaProtocolloNomeElemento, proprietaProtocolloNomeTipoElemento, protocolInfos);
	}
	
	public void updateHeader(OpenSPCoop2SoapMessage message,IDSoggetto soggettoFruitore,IDServizio idServizio,
			String idBusta,String idBustaRisposta,String servizioApplicativo,
			String correlazioneApplicativa,String riferimentoCorrelazioneApplicativaRichiesta, String idTransazione,
			String actorIntegrazione,String nomeElemento,String prefix,String namespace,
			String proprietaProtocolloNomeElemento,String proprietaProtocolloNomeTipoElemento,
			Map<String, String> protocolInfos) throws Exception{
		
		HeaderIntegrazione integrazione = new HeaderIntegrazione(idTransazione);
		integrazione.setIdApplicativo(correlazioneApplicativa);
		integrazione.setServizioApplicativo(servizioApplicativo);
		HeaderIntegrazioneBusta busta = new HeaderIntegrazioneBusta();
		busta.setTipoMittente(soggettoFruitore.getTipo());
		busta.setMittente(soggettoFruitore.getNome());
		busta.setTipoDestinatario(idServizio.getSoggettoErogatore().getTipo());
		busta.setDestinatario(idServizio.getSoggettoErogatore().getNome());
		busta.setTipoServizio(idServizio.getTipo());
		busta.setServizio(idServizio.getNome());
		busta.setVersioneServizio(idServizio.getVersione());
		busta.setAzione(idServizio.getAzione());
		if(idBustaRisposta==null){
			busta.setID(idBusta);
		}
		else{
			busta.setID(idBustaRisposta);
			busta.setRiferimentoMessaggio(idBusta);
		}
		integrazione.setBusta(busta);
		
		this.updateHeader(message, integrazione, actorIntegrazione, nomeElemento, prefix, namespace, 
				proprietaProtocolloNomeElemento, proprietaProtocolloNomeTipoElemento, protocolInfos);
	}
		
	public void updateHeader(OpenSPCoop2SoapMessage message,HeaderIntegrazione integrazione,
			String actorIntegrazione,String nomeElemento,String prefix,String namespace,
			String proprietaProtocolloNomeElemento,String proprietaProtocolloNomeTipoElemento,
			Map<String, String> protocolInfos) throws Exception{
		
		if(actorIntegrazione==null)
			throw new Exception("Actor non definito");
		SOAPHeader header = message.getSOAPHeader();
		SOAPHeaderElement headerIntegrazione = null;
		if(header==null){
			
			// Creo soap header
			OpenSPCoop2Logger.getLoggerOpenSPCoopCore().debug("SOAPHeader non presente: add soapHeader");
			header = message.getSOAPPart().getEnvelope().addHeader();
			
		}else{

			// cerco soap di integrazione
			java.util.Iterator<?> it = header.examineAllHeaderElements();
			while( it.hasNext()  ){
				// Test Header Element
				headerIntegrazione = (SOAPHeaderElement) it.next();
				//Controllo Actor
				String actorCheck = SoapUtils.getSoapActor(headerIntegrazione, message.getMessageType());
				if( actorIntegrazione.equals(actorCheck) ){
					break;
				}else{
					headerIntegrazione = null;
				}
			}
			if(headerIntegrazione==null){
				OpenSPCoop2Logger.getLoggerOpenSPCoopCore().debug("Header di integrazione non presente, lo creo");
			}
		}

		List<SOAPElement> v = new ArrayList<SOAPElement>(); // mantengo eventuali message element presenti
		if(headerIntegrazione!=null){
			
			java.util.Iterator<?> it = headerIntegrazione.getChildElements();
			if(it.hasNext()){
				SOAPElement tmp = (SOAPElement) it.next();
				//System.out.println("CONSERVO MSG ELEMENT["+tmp.getLocalName()+"]");
				v.add(tmp);
			}
			 
			header.removeChild(headerIntegrazione);
		}
		
		// creo header da nuovo
		SOAPHeaderElement headerIntegrazioneNEW = this.buildHeader(integrazione, nomeElemento, prefix, namespace, 
				actorIntegrazione, message, 
				proprietaProtocolloNomeElemento, proprietaProtocolloNomeTipoElemento, protocolInfos);	
		
		// Riaggiungo eventuali elementi interni
		while(v.size()>0){
			SOAPElement tmp = v.remove(0);
			//System.out.println("RIAGGIUNGO MSG ELEMENT["+tmp.getLocalName()+"]");
			headerIntegrazioneNEW.addChildElement(tmp);
		}
		
		//System.out.println("OTTENGO ["+headerIntegrazioneNEW.getAsString()+"]");
		
		// aggiungo header element al SOAP Header
		//header.addChildElement(headerIntegrazioneNEW);
		message.addHeaderElement(header, headerIntegrazioneNEW);

	}
	
	public SOAPHeaderElement buildHeader(HeaderIntegrazione integrazione,String nomeElemento,
			String prefix,String namespace, String actor, 
			OpenSPCoop2SoapMessage m,
			String proprietaProtocolloNomeElemento,String proprietaProtocolloNomeTipoElemento,
			Map<String, String> protocolInfos) throws HeaderIntegrazioneException{

		try{
			SOAPHeader soapHeader = m.getSOAPHeader();
			if(soapHeader==null){
				soapHeader = m.getSOAPPart().getEnvelope().addHeader();
			}
			SOAPHeaderElement header = m.newSOAPHeaderElement(soapHeader, new QName(namespace,nomeElemento,prefix));

			header.setActor(actor);
			header.setMustUnderstand(false);
			
			setAttributes(integrazione,header);
			
			if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_PROTOCOL_INFO)) {
				if(protocolInfos!=null && protocolInfos.size()>0){
					Iterator<String> itProtocolInfos = protocolInfos.keySet().iterator();
					while (itProtocolInfos.hasNext()) {
						String name = (String) itProtocolInfos.next();
						String value = protocolInfos.get(name);
						SOAPElement element = header.addChildElement(new QName(namespace,proprietaProtocolloNomeElemento,prefix));
						element.setTextContent(value);
						@SuppressWarnings("unused")
						SOAPElement attribute = element.addAttribute(new QName(proprietaProtocolloNomeTipoElemento),name);
					}
				}
			}
			
			return header;

		}catch(Exception e){
			throw new HeaderIntegrazioneException("UtilitiesIntegrazione, creazione dell'header soap non riuscita: "+e.getMessage(),e);
		}
	}
	
	
	public void setAttributes(HeaderIntegrazione integrazione, SOAPHeaderElement header){
		if(integrazione.getBusta()!=null){

			if(integrazione.getBusta().getTipoMittente()!=null){
				if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE)) {
					header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE), integrazione.getBusta().getTipoMittente());
				}
			}
			if(integrazione.getBusta().getMittente()!=null){
				if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE)) {
					header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE), integrazione.getBusta().getMittente());
				}
			}

			if(integrazione.getBusta().getTipoDestinatario()!=null){
				if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO)) {
					header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO), integrazione.getBusta().getTipoDestinatario());
				}
			}
			if(integrazione.getBusta().getDestinatario()!=null){
				if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO)) {
					header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO), integrazione.getBusta().getDestinatario());
				}
			}

			if(integrazione.getBusta().getTipoServizio()!=null){
				if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO)) {
					header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO), integrazione.getBusta().getTipoServizio());
				}
			}
			if(integrazione.getBusta().getServizio()!=null){
				if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO)) {
					header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO), integrazione.getBusta().getServizio());
				}
			}
			if(integrazione.getBusta().getVersioneServizio()!=null){
				if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_VERSIONE_SERVIZIO)) {
					header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_VERSIONE_SERVIZIO), integrazione.getBusta().getVersioneServizio().intValue()+"");
				}
			}

			if(integrazione.getBusta().getAzione()!=null){
				if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE)) {
					header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE), integrazione.getBusta().getAzione());
				}
			}

			if(integrazione.getBusta().getID()!=null){
				if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO)) {
					header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO), integrazione.getBusta().getID());
				}
			}

			if(integrazione.getBusta().getRiferimentoMessaggio()!=null){
				if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO)) {
					header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO), integrazione.getBusta().getRiferimentoMessaggio());
				}
			}

			if(integrazione.getBusta().getIdCollaborazione()!=null){
				if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE)) {
					header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE), integrazione.getBusta().getIdCollaborazione());
				}
			}
		}

		if(integrazione.getIdApplicativo()!=null){
			if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO)) {
				header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO), integrazione.getIdApplicativo());
			}
		}
		
		if(integrazione.getServizioApplicativo()!=null){
			if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO)) {
				header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO), integrazione.getServizioApplicativo());
			}
		}
		
		if(integrazione.getIdTransazione()!=null){
			if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_TRANSAZIONE)) {
				header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_TRANSAZIONE), integrazione.getIdTransazione());
			}
		}
		
		if(this.keySetEnabled_HeaderIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_INFO)) {
			
			header.setAttribute(CostantiPdD.HEADER_INTEGRAZIONE_SOAP_PDD_VERSION, this.openspcoopProperties.getHeaderIntegrazioneSOAPPdDVersione());
			if(this.openspcoopProperties.getHeaderIntegrazioneSOAPPdDDetails()!=null && !"".equals(this.openspcoopProperties.getHeaderIntegrazioneSOAPPdDDetails())){
				header.setAttribute(CostantiPdD.HEADER_INTEGRAZIONE_SOAP_PDD_DETAILS, this.openspcoopProperties.getHeaderIntegrazioneSOAPPdDDetails());
			}
			
		}

	}
	
	
	public void deleteHeader(OpenSPCoop2SoapMessage message,String actorIntegrazione) throws HeaderIntegrazioneException{

		try{

			if(actorIntegrazione==null)
				throw new Exception("Actor non definito");
			SOAPHeader header = message.getSOAPHeader();
			if(header==null){
				OpenSPCoop2Logger.getLoggerOpenSPCoopCore().debug("SOAPHeader non presente");
				return;
			}
			SOAPHeaderElement headerElement = null;
			java.util.Iterator<?> it = header.examineAllHeaderElements();
			while( it.hasNext()  ){
				// Test Header Element
				headerElement = (SOAPHeaderElement) it.next();
				//Controllo Actor
				String actorCheck = SoapUtils.getSoapActor(headerElement, message.getMessageType());
				if( actorIntegrazione.equals(actorCheck) ){
					break;
				}else{
					headerElement = null;
				}
			}
			if(headerElement==null){
				OpenSPCoop2Logger.getLoggerOpenSPCoopCore().debug("Header di integrazione non presente");
				return;
			}
			
			header.removeChild(headerElement);
			
		}catch(Exception e){
			throw new HeaderIntegrazioneException("UtilitiesIntegrazione, eliminazione dell'header soap non riuscita: "+e.getMessage(),e);
		}
	}
	
	public static String getIdTransazione(PdDContext context){
		if(context!=null){
			return (String) context.getObject(Costanti.ID_TRANSAZIONE);
		}
		else{
			return null;
		}
	}
}
