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



package org.openspcoop2.protocol.spcoop.backward_compatibility.integrazione;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;

import org.openspcoop2.core.id.IDServizio;
import org.openspcoop2.core.id.IDSoggetto;
import org.openspcoop2.message.OpenSPCoop2MessageFactory;
import org.openspcoop2.message.OpenSPCoop2SoapMessage;
import org.openspcoop2.message.xml.ValidatoreXSD;
import org.openspcoop2.pdd.config.OpenSPCoop2ConfigurationException;
import org.openspcoop2.pdd.config.OpenSPCoop2Properties;
import org.openspcoop2.pdd.core.CostantiPdD;
import org.openspcoop2.pdd.core.integrazione.HeaderIntegrazione;
import org.openspcoop2.pdd.core.integrazione.HeaderIntegrazioneBusta;
import org.openspcoop2.pdd.core.integrazione.HeaderIntegrazioneException;
import org.openspcoop2.pdd.logger.OpenSPCoop2Logger;
import org.openspcoop2.protocol.spcoop.backward_compatibility.config.BackwardCompatibilityProperties;
import org.openspcoop2.protocol.spcoop.backward_compatibility.config.Costanti;
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
	
	private static UtilitiesIntegrazione utilitiesIntegrazione = null;
	public static UtilitiesIntegrazione getInstance(Logger log, boolean inizializeIfNotExists) throws OpenSPCoop2ConfigurationException {
		if(UtilitiesIntegrazione.utilitiesIntegrazione==null){
			initialize(log, inizializeIfNotExists);
		}
		return UtilitiesIntegrazione.utilitiesIntegrazione;
	}
	private static synchronized void initialize(Logger log, boolean inizializeIfNotExists) throws OpenSPCoop2ConfigurationException{
		if(UtilitiesIntegrazione.utilitiesIntegrazione==null)
			UtilitiesIntegrazione.utilitiesIntegrazione = new UtilitiesIntegrazione(log, inizializeIfNotExists);
	}

	
	
	
	// ***** INSTANCE *****
	
	private Map<String, String> keyValueIntegrazioneTrasporto = null;
	private Map<String, String> keyValueIntegrazioneUrlBased = null;
	private Map<String, String> keyValueIntegrazioneSoap = null;
	private BackwardCompatibilityProperties backwardCompatibilityProperties = null;
	private OpenSPCoop2Properties openspcoop2Properties = null;
	private ValidatoreXSD validatoreXSD = null;

	private UtilitiesIntegrazione(Logger log, boolean inizializeIfNotExists) throws OpenSPCoop2ConfigurationException{
		this.backwardCompatibilityProperties = BackwardCompatibilityProperties.getInstance(inizializeIfNotExists);
		this.keyValueIntegrazioneTrasporto = this.backwardCompatibilityProperties.getKeyValue_HeaderIntegrazioneTrasporto();
		this.keyValueIntegrazioneUrlBased = this.backwardCompatibilityProperties.getKeyValue_HeaderIntegrazioneUrlBased();
		this.keyValueIntegrazioneSoap = this.backwardCompatibilityProperties.getKeyValue_HeaderIntegrazioneSoap();
		this.openspcoop2Properties = OpenSPCoop2Properties.getInstance();
		
		try{
			XSDResourceResolver xsdResourceResolver = new XSDResourceResolver();
			xsdResourceResolver.addResource("soapEnvelope.xsd", UtilitiesIntegrazione.class.getResourceAsStream("/soapEnvelope.xsd"));
			this.validatoreXSD = new ValidatoreXSD(OpenSPCoop2MessageFactory.getDefaultMessageFactory(), log,xsdResourceResolver,UtilitiesIntegrazione.class.getResourceAsStream("/integrazione-OpenSPCoopV1.xsd"));
		}catch(Exception e){
			log.error("integrazione-OpenSPCoopV1.xsd, errore durante la costruzione del validatore xsd: "+e.getMessage(),e);
		}
	}



	public void readTransportProperties(Map<String, String> prop,
			HeaderIntegrazione integrazione) throws HeaderIntegrazioneException{
		try{
			if(prop!=null && integrazione!=null){
					
				if(this.backwardCompatibilityProperties.isBackwardCompatibilityHeaderIntegrazione()){
					
					// Ricerca tra l'header del trasporto
					Iterator<String> keys = prop.keySet().iterator();
					while (keys.hasNext()) {
						String key = (String) keys.next();
						
						if(key!=null){
							// Egov
							if(key.equalsIgnoreCase(Costanti.HEADER_INTEGRAZIONE_HTTP_BACKWARD_COMPATIBILITY_TIPO_MITTENTE))
								integrazione.getBusta().setTipoMittente(prop.get(key));
							else if(key.equalsIgnoreCase(Costanti.HEADER_INTEGRAZIONE_HTTP_BACKWARD_COMPATIBILITY_MITTENTE))
								integrazione.getBusta().setMittente(prop.get(key));
							else if(key.equalsIgnoreCase(Costanti.HEADER_INTEGRAZIONE_HTTP_BACKWARD_COMPATIBILITY_TIPO_DESTINATARIO))
								integrazione.getBusta().setTipoDestinatario(prop.get(key));
							else if(key.equalsIgnoreCase(Costanti.HEADER_INTEGRAZIONE_HTTP_BACKWARD_COMPATIBILITY_DESTINATARIO))
								integrazione.getBusta().setDestinatario(prop.get(key));
							else if(key.equalsIgnoreCase(Costanti.HEADER_INTEGRAZIONE_HTTP_BACKWARD_COMPATIBILITY_TIPO_SERVIZIO))
								integrazione.getBusta().setTipoServizio(prop.get(key));
							else if(key.equalsIgnoreCase(Costanti.HEADER_INTEGRAZIONE_HTTP_BACKWARD_COMPATIBILITY_SERVIZIO))
								integrazione.getBusta().setServizio(prop.get(key));
							else if(key.equalsIgnoreCase(Costanti.HEADER_INTEGRAZIONE_HTTP_BACKWARD_COMPATIBILITY_AZIONE))
								integrazione.getBusta().setAzione(prop.get(key));
							else if(key.equalsIgnoreCase(Costanti.HEADER_INTEGRAZIONE_HTTP_BACKWARD_COMPATIBILITY_ID_EGOV))
								integrazione.getBusta().setID(prop.get(key));
							else if(key.equalsIgnoreCase(Costanti.HEADER_INTEGRAZIONE_HTTP_BACKWARD_COMPATIBILITY_RIFERIMENTO_MESSAGGIO))
								integrazione.getBusta().setRiferimentoMessaggio(prop.get(key));
							else if(key.equalsIgnoreCase(Costanti.HEADER_INTEGRAZIONE_HTTP_BACKWARD_COMPATIBILITY_COLLABORAZIONE))
								integrazione.getBusta().setIdCollaborazione(prop.get(key));
	
							// id e servizio applicativo
							else if(key.equalsIgnoreCase(Costanti.HEADER_INTEGRAZIONE_HTTP_BACKWARD_COMPATIBILITY_ID_APPLICATIVO))
								integrazione.setIdApplicativo(prop.get(key));
							else if(key.equalsIgnoreCase(Costanti.HEADER_INTEGRAZIONE_HTTP_BACKWARD_COMPATIBILITY_SERVIZIO_APPLICATIVO))
								integrazione.setServizioApplicativo(prop.get(key));
						}
					}
				}
				
				// Ricerca tra l'header del trasporto
				Iterator<String> keys = prop.keySet().iterator();
				while (keys.hasNext()) {
					String key = (String) keys.next();
				
					if(key!=null){
						// Busta
						if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE)))
							integrazione.getBusta().setTipoMittente(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE)))
							integrazione.getBusta().setMittente(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO)))
							integrazione.getBusta().setTipoDestinatario(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO)))
							integrazione.getBusta().setDestinatario(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO)))
							integrazione.getBusta().setTipoServizio(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO)))
							integrazione.getBusta().setServizio(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE)))
							integrazione.getBusta().setAzione(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO)))
							integrazione.getBusta().setID(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO)))
							integrazione.getBusta().setRiferimentoMessaggio(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE)))
							integrazione.getBusta().setIdCollaborazione(prop.get(key));

						// id e servizio applicativo
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO)))
							integrazione.setIdApplicativo(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO)))
							integrazione.setServizioApplicativo(prop.get(key));
					}
				}
			}
		}catch(Exception e){
			throw new HeaderIntegrazioneException("UtilitiesIntegrazione, lettura dell'header non riuscita: "+e.getMessage(),e);
		}
	}
	
	public void readUrlProperties(Map<String, String> prop,
			HeaderIntegrazione integrazione) throws HeaderIntegrazioneException{
		try{
			if(prop!=null && integrazione!=null){
			
				// Ricerca tra le proprieta' dell'url
				Iterator<String> keys = prop.keySet().iterator();
				while (keys.hasNext()) {
					String key = (String) keys.next();
				
					if(key!=null){
						// Busta
						if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE)))
							integrazione.getBusta().setTipoMittente(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE)))
							integrazione.getBusta().setMittente(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO)))
							integrazione.getBusta().setTipoDestinatario(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO)))
							integrazione.getBusta().setDestinatario(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO)))
							integrazione.getBusta().setTipoServizio(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO)))
							integrazione.getBusta().setServizio(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE)))
							integrazione.getBusta().setAzione(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO)))
							integrazione.getBusta().setID(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO)))
							integrazione.getBusta().setRiferimentoMessaggio(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE)))
							integrazione.getBusta().setIdCollaborazione(prop.get(key));

						// id e servizio applicativo
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO)))
							integrazione.setIdApplicativo(prop.get(key));
						else if(key.equalsIgnoreCase((String)this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO)))
							integrazione.setServizioApplicativo(prop.get(key));
					}
				}
			}
		}catch(Exception e){
			throw new HeaderIntegrazioneException("UtilitiesIntegrazione, lettura dell'header non riuscita: "+e.getMessage(),e);
		}
	}
	


	public void setRequestUrlProperties(HeaderIntegrazione integrazione,
			Map<String, String> properties) throws HeaderIntegrazioneException{
		setUrlProperties(integrazione, properties, true, false);
	}
	public void setResponseUrlProperties(HeaderIntegrazione integrazione,
			Map<String, String> properties) throws HeaderIntegrazioneException{
		setUrlProperties(integrazione, properties, false, true);
	}
	private void setUrlProperties(HeaderIntegrazione integrazione,
			Map<String, String> properties,boolean request,boolean response) throws HeaderIntegrazioneException{

		try{
			if(properties!=null && integrazione!=null){
				if(integrazione.getBusta()!=null){
					if(integrazione.getBusta().getTipoMittente()!=null)
						properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE), integrazione.getBusta().getTipoMittente());
					if(integrazione.getBusta().getMittente()!=null)
						properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE), integrazione.getBusta().getMittente());
					if(integrazione.getBusta().getTipoDestinatario()!=null)
						properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO), integrazione.getBusta().getTipoDestinatario());
					if(integrazione.getBusta().getDestinatario()!=null)
						properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO), integrazione.getBusta().getDestinatario());
					if(integrazione.getBusta().getTipoServizio()!=null)
						properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO), integrazione.getBusta().getTipoServizio());
					if(integrazione.getBusta().getServizio()!=null)
						properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO), integrazione.getBusta().getServizio());
					if(integrazione.getBusta().getAzione()!=null)
						properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE), integrazione.getBusta().getAzione());
					if(integrazione.getBusta().getID()!=null)
						properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO), integrazione.getBusta().getID());
					if(integrazione.getBusta().getRiferimentoMessaggio()!=null)
						properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO), integrazione.getBusta().getRiferimentoMessaggio());
					if(integrazione.getBusta().getIdCollaborazione()!=null)
						properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE), integrazione.getBusta().getIdCollaborazione());
				}
				if(integrazione.getIdApplicativo()!=null)
					properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO), integrazione.getIdApplicativo());
				if(integrazione.getServizioApplicativo()!=null)
					properties.put(this.keyValueIntegrazioneUrlBased.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO), integrazione.getServizioApplicativo());
			}
			if(properties!=null){
//				properties.put(CostantiPdD.URL_BASED_PDD,URLEncoder.encode(this.openspcoop2Properties.getHttpServer(),"UTF-8"));
//				if(this.openspcoop2Properties.getHttpXPdDDetails()!=null && !"".equals(this.openspcoop2Properties.getHttpXPdDDetails())){
//					properties.put(CostantiPdD.URL_BASED_PDD_DETAILS,URLEncoder.encode(this.openspcoop2Properties.getHttpXPdDDetails(),"UTF-8"));
//				}
				// Tutti i valori delle url vengono codificate. Se si codifica con URLEncoded in questo codice, si ottiene una doppia codifica
				properties.put((String)this.keyValueIntegrazioneUrlBased.get(Costanti.HEADER_INTEGRAZIONE_PDD_VERSION),this.openspcoop2Properties.getHttpServer());
				if(this.openspcoop2Properties.getHttpXPdDDetails()!=null && !"".equals(this.openspcoop2Properties.getHttpXPdDDetails())){
					properties.put((String)this.keyValueIntegrazioneUrlBased.get(Costanti.HEADER_INTEGRAZIONE_PDD_DETAILS),this.openspcoop2Properties.getHttpXPdDDetails());
				}
			}
		}catch(Exception e){
			throw new HeaderIntegrazioneException("UtilitiesIntegrazione, creazione delle proprieta' dell'header non riuscita: "+e.getMessage(),e);
		}
	}
	
	public void setRequestTransportProperties(HeaderIntegrazione integrazione,
			Map<String, String> properties) throws HeaderIntegrazioneException{
		setTransportProperties(integrazione, properties, true, false);
	}
	public void setResponseTransportProperties(HeaderIntegrazione integrazione,
			Map<String, String> properties) throws HeaderIntegrazioneException{
		setTransportProperties(integrazione, properties, false, true);
	}
	private void setTransportProperties(HeaderIntegrazione integrazione,
			Map<String, String> properties,boolean request,boolean response) throws HeaderIntegrazioneException{

		try{
			if(properties!=null && integrazione!=null){
				if(integrazione.getBusta()!=null){
					if(integrazione.getBusta().getTipoMittente()!=null)
						properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE), integrazione.getBusta().getTipoMittente());
					if(integrazione.getBusta().getMittente()!=null)
						properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE), integrazione.getBusta().getMittente());
					if(integrazione.getBusta().getTipoDestinatario()!=null)
						properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO), integrazione.getBusta().getTipoDestinatario());
					if(integrazione.getBusta().getDestinatario()!=null)
						properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO), integrazione.getBusta().getDestinatario());
					if(integrazione.getBusta().getTipoServizio()!=null)
						properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO), integrazione.getBusta().getTipoServizio());
					if(integrazione.getBusta().getServizio()!=null)
						properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO), integrazione.getBusta().getServizio());
					if(integrazione.getBusta().getAzione()!=null)
						properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE), integrazione.getBusta().getAzione());
					if(integrazione.getBusta().getID()!=null)
						properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO), integrazione.getBusta().getID());
					if(integrazione.getBusta().getRiferimentoMessaggio()!=null)
						properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO), integrazione.getBusta().getRiferimentoMessaggio());
					if(integrazione.getBusta().getIdCollaborazione()!=null)
						properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE), integrazione.getBusta().getIdCollaborazione());
				}
				if(integrazione.getIdApplicativo()!=null)
					properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO), integrazione.getIdApplicativo());
				if(integrazione.getServizioApplicativo()!=null)
					properties.put(this.keyValueIntegrazioneTrasporto.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO), integrazione.getServizioApplicativo());
			}
			if(properties!=null){
//				if(request)
//					properties.put(CostantiPdD.HEADER_HTTP_USER_AGENT,this.openspcoop2Properties.getHttpUserAgent());
				properties.put((String)this.keyValueIntegrazioneTrasporto.get(Costanti.HEADER_INTEGRAZIONE_PDD_VERSION),this.openspcoop2Properties.getHttpServer());
				if(this.openspcoop2Properties.getHttpXPdDDetails()!=null && !"".equals(this.openspcoop2Properties.getHttpXPdDDetails())){
					properties.put((String)this.keyValueIntegrazioneTrasporto.get(Costanti.HEADER_INTEGRAZIONE_PDD_DETAILS),this.openspcoop2Properties.getHttpXPdDDetails());
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
				if( actorIntegrazione.equals(headerElement.getActor()) ){
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
			if(this.validatoreXSD==null)
				throw new Exception("Validatore XSD non istanziato");
			this.validatoreXSD.valida(new java.io.ByteArrayInputStream(message.getAsByte(headerElement, false)));

			
			// Ricerca tra gli attributi dell'header SOAP
			String tipoMittente = null;
			try{
			    tipoMittente = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE));
			}catch(Exception e){}
			if(tipoMittente!=null && tipoMittente.compareTo("")!=0)
				integrazione.getBusta().setTipoMittente(tipoMittente);
			
			String mittente = null;
			try{
			    mittente = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE));
			}catch(Exception e){}
			if(mittente!=null && mittente.compareTo("")!=0)
				integrazione.getBusta().setMittente(mittente);
			
			String tipoDestinatario = null;
			try{
			    tipoDestinatario = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO));
			}catch(Exception e){}
			if(tipoDestinatario!=null && tipoDestinatario.compareTo("")!=0)
				integrazione.getBusta().setTipoDestinatario(tipoDestinatario);
			
			String destinatario = null;
			try{
			    destinatario = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO));
			}catch(Exception e){}
			if(destinatario!=null && destinatario.compareTo("")!=0)
				integrazione.getBusta().setDestinatario(destinatario);

			String tipoServizio = null;
			try{
			    tipoServizio = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO));
			}catch(Exception e){}
			if(tipoServizio!=null && tipoServizio.compareTo("")!=0)
				integrazione.getBusta().setTipoServizio(tipoServizio);
			
			String servizio = null;
			try{
			    servizio = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO));
			}catch(Exception e){}
			if(servizio!=null && servizio.compareTo("")!=0)
				integrazione.getBusta().setServizio(servizio);

			String azione= null;
			try{
			    azione= headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE));
			}catch(Exception e){}
			if(azione!=null && azione.compareTo("")!=0)
				integrazione.getBusta().setAzione(azione);

			String idBusta = null;
			try{
			    idBusta = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO));
			}catch(Exception e){}
			if(idBusta!=null && idBusta.compareTo("")!=0)
				integrazione.getBusta().setID(idBusta);

			String riferimentoMessaggio = null;
			try{
			    riferimentoMessaggio = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO));
			}catch(Exception e){}
			if(riferimentoMessaggio!=null && riferimentoMessaggio.compareTo("")!=0)
				integrazione.getBusta().setRiferimentoMessaggio(riferimentoMessaggio);

			String collaborazione = null;
			try{
			    collaborazione = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE));
			}catch(Exception e){}
			if(collaborazione!=null && collaborazione.compareTo("")!=0)
				integrazione.getBusta().setIdCollaborazione(collaborazione);

			String idApplicativo = null;
			try{
			    idApplicativo = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO));
			}catch(Exception e){}
			if(idApplicativo!=null && idApplicativo.compareTo("")!=0)
				integrazione.setIdApplicativo(idApplicativo);

			String sa = null;
			try{
			    sa = headerElement.getAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO));
			}catch(Exception e){}
			if(sa!=null && sa.compareTo("")!=0)
				integrazione.setServizioApplicativo(sa);
			
		}catch(Exception e){
			throw new HeaderIntegrazioneException("UtilitiesIntegrazione, lettura dell'header soap non riuscita: "+e.getMessage(),e);
		}
	}

	public void updateHeader(OpenSPCoop2SoapMessage message,IDSoggetto soggettoFruitore,IDServizio idServizio,
			String idBusta,String servizioApplicativo,
			String correlazioneApplicativa,String riferimentoCorrelazioneApplicativaRichiesta, String idTransazione,
			String actorIntegrazione,String nomeElemento,String prefix,String namespace) throws Exception{
		updateHeader(message, soggettoFruitore, idServizio, idBusta, null, 
				servizioApplicativo, correlazioneApplicativa, riferimentoCorrelazioneApplicativaRichiesta, idTransazione,
				actorIntegrazione, nomeElemento, prefix, namespace);
	}
	
	public void updateHeader(OpenSPCoop2SoapMessage message,IDSoggetto soggettoFruitore,IDServizio idServizio,
			String idBusta,String idBustaRisposta,String servizioApplicativo,
			String correlazioneApplicativa,String riferimentoCorrelazioneApplicativaRichiesta, String idTransazione,
			String actorIntegrazione,String nomeElemento,String prefix,String namespace) throws Exception{
		
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
		if(idServizio.getVersione()!=null){
			busta.setVersioneServizio(idServizio.getVersione());
		}
		busta.setAzione(idServizio.getAzione());
		if(idBustaRisposta==null){
			busta.setID(idBusta);
		}
		else{
			busta.setID(idBustaRisposta);
			busta.setRiferimentoMessaggio(idBusta);
		}
		integrazione.setBusta(busta);
		
		this.updateHeader(message, integrazione, actorIntegrazione, nomeElemento, prefix, namespace);
	}
		
	public void updateHeader(OpenSPCoop2SoapMessage message,HeaderIntegrazione integrazione,String actorIntegrazione,String nomeElemento,String prefix,String namespace) throws Exception{
		
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
				if( actorIntegrazione.equals(headerIntegrazione.getActor()) ){
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
		SOAPHeaderElement headerIntegrazioneNEW = this.buildHeader(integrazione, nomeElemento, prefix, namespace, actorIntegrazione, message);	
		
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
			//SOAPVersion soapVersion,
			OpenSPCoop2SoapMessage m) throws HeaderIntegrazioneException{

		try{
//			OpenSPCoop2MessageFactory mf = OpenSPCoop2MessageFactory.getMessageFactory();
//			
//			OpenSPCoop2Message m = mf.createMessage(soapVersion);
			//SOAPHeaderElement header = m.getSOAPHeader().addHeaderElement(new QName(namespace,nomeElemento,prefix));
			SOAPHeader soapHeader = m.getSOAPHeader();
			if(soapHeader==null){
				soapHeader = m.getSOAPPart().getEnvelope().addHeader();
			}
			SOAPHeaderElement header = m.newSOAPHeaderElement(soapHeader, new QName(namespace,nomeElemento,prefix));

			header.setActor(actor);
			header.setMustUnderstand(false);
			header.addNamespaceDeclaration("SOAP_ENV","http://schemas.xmlsoap.org/soap/envelope/");

			setAttributes(integrazione,header);
			
			return header;

		}catch(Exception e){
			throw new HeaderIntegrazioneException("UtilitiesIntegrazione, creazione dell'header soap non riuscita: "+e.getMessage(),e);
		}
	}
	
	
	public void setAttributes(HeaderIntegrazione integrazione, SOAPHeaderElement header){
		if(integrazione.getBusta()!=null){

			if(integrazione.getBusta().getTipoMittente()!=null){
				header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_MITTENTE), integrazione.getBusta().getTipoMittente());
			}
			if(integrazione.getBusta().getMittente()!=null){
				header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_MITTENTE), integrazione.getBusta().getMittente());
			}

			if(integrazione.getBusta().getTipoDestinatario()!=null){
				header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_DESTINATARIO), integrazione.getBusta().getTipoDestinatario());
			}
			if(integrazione.getBusta().getDestinatario()!=null){
				header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_DESTINATARIO), integrazione.getBusta().getDestinatario());
			}

			if(integrazione.getBusta().getTipoServizio()!=null){
				header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_TIPO_SERVIZIO), integrazione.getBusta().getTipoServizio());
			}
			if(integrazione.getBusta().getServizio()!=null){
				header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO), integrazione.getBusta().getServizio());
			}

			if(integrazione.getBusta().getAzione()!=null){
				header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_AZIONE), integrazione.getBusta().getAzione());
			}

			if(integrazione.getBusta().getID()!=null){
				header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_MESSAGGIO), integrazione.getBusta().getID());
			}

			if(integrazione.getBusta().getRiferimentoMessaggio()!=null){
				header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_RIFERIMENTO_MESSAGGIO), integrazione.getBusta().getRiferimentoMessaggio());
			}

			if(integrazione.getBusta().getIdCollaborazione()!=null){
				header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_COLLABORAZIONE), integrazione.getBusta().getIdCollaborazione());
			}
		}

		if(integrazione.getIdApplicativo()!=null){
			 header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_ID_APPLICATIVO), integrazione.getIdApplicativo());
		}

		if(integrazione.getServizioApplicativo()!=null){
			header.setAttribute((String)this.keyValueIntegrazioneSoap.get(CostantiPdD.HEADER_INTEGRAZIONE_SERVIZIO_APPLICATIVO), integrazione.getServizioApplicativo());
		}
		
		header.setAttribute((String)this.keyValueIntegrazioneSoap.get(Costanti.HEADER_INTEGRAZIONE_PDD_VERSION), this.openspcoop2Properties.getHeaderIntegrazioneSOAPPdDVersione());
		if(this.openspcoop2Properties.getHeaderIntegrazioneSOAPPdDDetails()!=null && !"".equals(this.openspcoop2Properties.getHeaderIntegrazioneSOAPPdDDetails())){
			header.setAttribute((String)this.keyValueIntegrazioneSoap.get(Costanti.HEADER_INTEGRAZIONE_PDD_DETAILS), this.openspcoop2Properties.getHeaderIntegrazioneSOAPPdDDetails());
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
				if( actorIntegrazione.equals(headerElement.getActor()) ){
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
}
