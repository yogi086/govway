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



package org.openspcoop2.protocol.spcoop.testsuite.units;

import java.io.IOException;
import java.util.Iterator;

import javax.xml.soap.SOAPException;

import org.apache.axis.Message;
import org.apache.axis.attachments.AttachmentPart;
import org.openspcoop2.testsuite.clients.ClientAsincronoAsimmetrico_ModalitaAsincrona;
import org.openspcoop2.testsuite.clients.ClientAsincronoAsimmetrico_ModalitaSincrona;
import org.openspcoop2.testsuite.clients.ClientAsincronoSimmetrico_ModalitaAsincrona;
import org.openspcoop2.testsuite.clients.ClientAsincronoSimmetrico_ModalitaSincrona;
import org.openspcoop2.testsuite.clients.ClientOneWay;
import org.openspcoop2.testsuite.clients.ClientSincrono;
import org.openspcoop2.testsuite.core.FatalTestSuiteException;
import org.openspcoop2.testsuite.core.Repository;
import org.openspcoop2.testsuite.core.asincrono.RepositoryConsegnaRisposteAsincroneSimmetriche;
import org.openspcoop2.testsuite.core.asincrono.RepositoryCorrelazioneIstanzeAsincrone;
import org.openspcoop2.testsuite.db.DatabaseComponent;
import org.openspcoop2.testsuite.db.DatiServizio;
import org.openspcoop2.testsuite.db.DatiServizioAzione;
import org.openspcoop2.core.id.IDSoggetto;
import org.openspcoop2.protocol.sdk.constants.Inoltro;
import org.openspcoop2.protocol.sdk.constants.ProfiloDiCollaborazione;
import org.openspcoop2.protocol.sdk.constants.TipoOraRegistrazione;
import org.openspcoop2.protocol.spcoop.constants.SPCoopCostanti;
import org.openspcoop2.protocol.spcoop.testsuite.core.CostantiTestSuite;
import org.openspcoop2.protocol.spcoop.testsuite.core.DatabaseProperties;
import org.openspcoop2.protocol.spcoop.testsuite.core.SPCoopTestsuiteLogger;
import org.openspcoop2.protocol.spcoop.testsuite.core.Utilities;
import org.testng.Assert;
import org.testng.Reporter;


/**
 * Test sui profili di collaborazione implementati nella Porta di Dominio
 * utilizzabili con messaggi Soap normali o con attachments
 * 
 * @author Andi Rexha (rexha@openspcoop.org)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class CooperazioneSPCoopBase {

	/** Tipo di gestione */
	private boolean soapWithAttachments;
	/** String tipoCooperazione */
	private String tipoCooperazione;
	
	/** Mittente */
	private IDSoggetto mittente;
	/** Destinatario */
	private IDSoggetto destinatario;
	/** Conferma Ricezione */
	private boolean confermaRicezione;
	/** Inoltro */
	private String inoltro;
	private Inoltro inoltroSdk;
	
	
	public boolean isSoapWithAttachments() {
		return this.soapWithAttachments;
	}
	public void setSoapWithAttachments(boolean soapWithAttachments) {
		this.soapWithAttachments = soapWithAttachments;
	}
	public CooperazioneSPCoopBase(boolean soapWithAttachments){
		this(soapWithAttachments,
				CostantiTestSuite.SPCOOP_SOGGETTO_FRUITORE,
				CostantiTestSuite.SPCOOP_SOGGETTO_EROGATORE,
				false,SPCoopCostanti.PROFILO_TRASMISSIONE_CON_DUPLICATI,Inoltro.CON_DUPLICATI);
	}
	public CooperazioneSPCoopBase(boolean soapWithAttachments,IDSoggetto mittente, IDSoggetto destinatario,boolean confermaRicezione,String inoltro,Inoltro inoltroSdk) {
		super();
		this.soapWithAttachments = soapWithAttachments;
		if(this.soapWithAttachments)
			this.tipoCooperazione = "SOAPWithAttachments";
		else
			this.tipoCooperazione = "SOAP";
		this.mittente = mittente;
		this.destinatario =destinatario;
		this.confermaRicezione = confermaRicezione;
		this.inoltro = inoltro;
		this.inoltroSdk = inoltroSdk;
	}




	
	private void checkAttachmentsRequest(DatabaseComponent data, String id, DatiServizioAzione datiServizioAzione,Message msgFromCheck){
		if(this.isSoapWithAttachments()){
			
			try{
				Thread.sleep(500);
			}catch(Exception e){}
			
			try{
				Message msg = null;
				if(msgFromCheck!=null){
					msg = msgFromCheck;
				}else{
					msg = org.openspcoop2.testsuite.core.Utilities.createMessageWithAttachmentsFromFile(Utilities.testSuiteProperties.getSoapWithAttachmentsFileName(), false);
				}
				Iterator<?> itAp = msg.getAttachments();
				while (itAp.hasNext()) {
					AttachmentPart attachmentPart = (AttachmentPart) itAp.next();
					String contentId = attachmentPart.getContentId();
					String contentLocation = attachmentPart.getContentLocation();
					String contentType = attachmentPart.getContentType();
					Reporter.log("["+this.tipoCooperazione+"] Controllo allegato idMessaggio["+id+"] contentId["+contentId
							+"] contentLocation["+contentLocation+"] contentType["+contentType+"]");
					if(datiServizioAzione!=null){
						Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedAllegato(id, datiServizioAzione, contentId, contentLocation, contentType, false));
					}
					else{
						Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedAllegato(id, contentId, contentLocation, contentType, false));
					}
				
				}
			}catch(Exception e){
				SPCoopTestsuiteLogger.getInstance().error("Errore durante la verifica degli attachments: "+e.getMessage(),e);
				throw new  FatalTestSuiteException(e.getMessage());
			}
		}
	}
	private void checkCountAttachmentsRequest(DatabaseComponent data, String id, DatiServizioAzione datiServizioAzione ,boolean withManifest){
		_checkAttachments(true, data, id, datiServizioAzione, withManifest, null);
	}
	private void checkCountAttachmentsRequest(DatabaseComponent data, String id, DatiServizioAzione datiServizioAzione ,boolean withManifest, Integer numeroAttachments){
		_checkAttachments(true, data, id, datiServizioAzione, withManifest, numeroAttachments);
	}
	@SuppressWarnings("unused")
	private void checkCountAttachmentsResponse(DatabaseComponent data, String id, DatiServizioAzione datiServizioAzione ,boolean withManifest){
		_checkAttachments(false, data, id, datiServizioAzione, withManifest, null);
	}
	private void checkCountAttachmentsResponse(DatabaseComponent data, String id, DatiServizioAzione datiServizioAzione ,boolean withManifest, Integer numeroAttachments){
		_checkAttachments(false, data, id, datiServizioAzione, withManifest, numeroAttachments);
	}
	private void _checkAttachments(boolean isRequest,DatabaseComponent data, String id, DatiServizioAzione datiServizioAzione ,boolean withManifest, Integer numeroAttachments){
		if(this.isSoapWithAttachments()){
			
			try{
				Thread.sleep(1250);
			}catch(Exception e){}
			
			try{
				Message msg = org.openspcoop2.testsuite.core.Utilities.createMessageWithAttachmentsFromFile(Utilities.testSuiteProperties.getSoapWithAttachmentsFileName(), false);
				int countAttachments = msg.countAttachments();
				if(numeroAttachments!=null){
					countAttachments = numeroAttachments;
				}
				if(withManifest){
					countAttachments = countAttachments+1; //manifest comporta che il body originale finisca come allegato
				}
				
				if(isRequest){
					if(datiServizioAzione!=null){
						long count = data.getVerificatoreTracciaRichiesta().countTracedAllegati(id, datiServizioAzione);
						Reporter.log("["+this.tipoCooperazione+"] Controllo numero allegati attesi("+countAttachments+") trovati ("+count+")");
						Assert.assertTrue(count==countAttachments);
					}
					else{
						long count = data.getVerificatoreTracciaRichiesta().countTracedAllegati(id);
						Reporter.log("["+this.tipoCooperazione+"] Controllo numero allegati attesi("+countAttachments+") trovati ("+count+")");
						Assert.assertTrue(count==countAttachments);
					}
				}
				else{
					if(datiServizioAzione!=null){
						long count = data.getVerificatoreTracciaRisposta().countTracedAllegati(id, datiServizioAzione);
						Reporter.log("["+this.tipoCooperazione+"] Controllo numero allegati attesi("+countAttachments+") trovati ("+count+")");
						Assert.assertTrue(count==countAttachments);
					}
					else{
						long count = data.getVerificatoreTracciaRisposta().countTracedAllegati(id);
						Reporter.log("["+this.tipoCooperazione+"] Controllo numero allegati attesi("+countAttachments+") trovati ("+count+")");
						Assert.assertTrue(count==countAttachments);
					}
				}
			}catch(Exception e){
				SPCoopTestsuiteLogger.getInstance().error("Errore durante la verifica degli attachments: "+e.getMessage(),e);
				throw new  FatalTestSuiteException(e.getMessage());
			}
		}
	}
	
	
	
	


	/***
	 * Test per il profilo di collaborazione OneWay
	 */
	public void oneWay(Repository repository,String portaDelegata,boolean addIDUnivoco) throws FatalTestSuiteException, Exception{
		DatabaseComponent dbComponentFruitore = null;
		DatabaseComponent dbComponentErogatore = null;

		try{
			// Creazione client OneWay
			ClientOneWay client=new ClientOneWay(repository);
			client.setUrlPortaDiDominio(Utilities.testSuiteProperties.getServizioRicezioneContenutiApplicativiFruitore());
			client.setPortaDelegata(portaDelegata);
			client.connectToSoapEngine();
			if(this.soapWithAttachments)
				client.setMessageWithAttachmentsFromFile(Utilities.testSuiteProperties.getSoapWithAttachmentsFileName(), false,addIDUnivoco);
			else
				client.setMessageFromFile(Utilities.testSuiteProperties.getSoapFileName(), false,addIDUnivoco);

			// AttesaTerminazioneMessaggi
			if(Utilities.testSuiteProperties.attendiTerminazioneMessaggi_verificaDatabase()){
				dbComponentFruitore = DatabaseProperties.getDatabaseComponentFruitore();
				dbComponentErogatore = DatabaseProperties.getDatabaseComponentErogatore();
				
				client.setAttesaTerminazioneMessaggi(true);
				client.setDbAttesaTerminazioneMessaggiFruitore(dbComponentFruitore);
				client.setDbAttesaTerminazioneMessaggiErogatore(dbComponentErogatore);
			}
			client.run();
		}catch(Exception e){
			throw e;
		}finally{
			try{
				dbComponentFruitore.close();
			}catch(Exception eClose){}
			try{
				dbComponentErogatore.close();
			}catch(Exception eClose){}
		}
	}
	public void testOneWay(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione) throws FatalTestSuiteException{
		testOneWay(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione, null, null, false, null, null);
	}
	public void testOneWay(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione,boolean manifestAbilitato) throws FatalTestSuiteException{
		testOneWay(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione, null, null, manifestAbilitato, null, null);
	}
	public void testOneWay(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk) throws FatalTestSuiteException{
		testOneWay(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione, tipoTempoAtteso, tipoTempoAttesoSdk, false, null, null);
	}
	public void testOneWay(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,boolean manifestAbilitato) throws FatalTestSuiteException{
		testOneWay(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione, tipoTempoAtteso, tipoTempoAttesoSdk,manifestAbilitato,null,null);
	}
	public void testOneWay(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,boolean manifestAbilitato, 
			Integer numeroAttachments,Message msg) throws FatalTestSuiteException{
		Reporter.log("["+this.tipoCooperazione+"] Controllo tracciamento richiesta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTraced(id));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedMittente(id, this.mittente, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedDestinatario(id, this.destinatario, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con id: " +id);
		DatiServizio datiServizio = new DatiServizio(tipoServizio,servizio, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedServizio(id,datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con id: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedAzione(id, azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloDiCollaborazione(id, SPCoopCostanti.PROFILO_COLLABORAZIONE_ONEWAY, ProfiloDiCollaborazione.ONEWAY));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedCollaborazione(id, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloTrasmissione(id, this.confermaRicezione,this.inoltro,this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null, this.destinatario, null, true,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null, this.destinatario, null));
		}
		checkCountAttachmentsRequest(data, id, null, manifestAbilitato,numeroAttachments);
		checkAttachmentsRequest(data, id, null, msg);
		if(checkServizioApplicativo){
			Reporter.log("["+this.tipoCooperazione+"] Numero messaggi arrivati al servizio applicativo: "+data.getVerificatoreTracciaRichiesta().isArrivedCount(id));
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isArrivedCount(id)==1);
		}
	}




	/***
	 * Test per il profilo di collaborazione Sincrono
	 */
	public void sincrono(Repository repository,String portaDelegata,boolean addIDUnivoco) throws FatalTestSuiteException, IOException, SOAPException{
		sincrono(repository,portaDelegata,addIDUnivoco,false);
	}
	public void sincrono(Repository repository,String portaDelegata,boolean addIDUnivoco,boolean isOneWay) throws FatalTestSuiteException, IOException, SOAPException{
		// Creazione client Sincrono
		ClientSincrono client=new ClientSincrono(repository);
		client.setUrlPortaDiDominio(Utilities.testSuiteProperties.getServizioRicezioneContenutiApplicativiFruitore());
		client.setPortaDelegata(portaDelegata);
		client.connectToSoapEngine();
		if(this.soapWithAttachments)
			client.setMessageWithAttachmentsFromFile(Utilities.testSuiteProperties.getSoapWithAttachmentsFileName(), false,addIDUnivoco);
		else
			client.setMessageFromFile(Utilities.testSuiteProperties.getSoapFileName(), false,addIDUnivoco);
		client.run();

		// Test uguaglianza Body (e attachments)
		if(isOneWay==false){
			Assert.assertTrue(client.isEqualsSentAndResponseMessage());
			if(this.soapWithAttachments)
				Assert.assertTrue(client.isEqualsSentAndResponseAttachments());
		}else{
			Assert.assertTrue(org.openspcoop2.testsuite.core.Utilities.isOpenSPCoopOKMessage(client.getResponseMessage()));
		}

	}
	public void testSincrono(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String collaborazione) throws FatalTestSuiteException{
		testSincrono(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione, null, null,false);
	}
	public void testSincrono(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String collaborazione,
			boolean manifestAbilitato) throws FatalTestSuiteException{
		testSincrono(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione, null, null,manifestAbilitato);
	}
	public void testSincrono(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String collaborazione,String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk) throws FatalTestSuiteException{
		testSincrono(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione,tipoTempoAtteso,tipoTempoAttesoSdk,false);
	}
	public void testSincrono(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String collaborazione,String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,
			boolean manifestAbilitato) throws FatalTestSuiteException{
		testSincrono(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione, tipoTempoAtteso, tipoTempoAttesoSdk, manifestAbilitato,null,null);
	}
	public void testSincrono(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String collaborazione,String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,
			boolean manifestAbilitato, Integer numeroAttachments, Message msg) throws FatalTestSuiteException{
		Reporter.log("["+this.tipoCooperazione+"] Controllo tracciamento richiesta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTraced(id));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedMittente(id, this.mittente, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedDestinatario(id, this.destinatario, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con id: " +id);
		DatiServizio datiServizio = new DatiServizio(tipoServizio,servizio, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedServizio(id, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con id: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedAzione(id, azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloDiCollaborazione(id, SPCoopCostanti.PROFILO_COLLABORAZIONE_SINCRONO, ProfiloDiCollaborazione.SINCRONO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedCollaborazione(id, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloTrasmissione(id, this.confermaRicezione,this.inoltro, this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null, this.destinatario, null, true,tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null, this.destinatario, null));
		}
		checkCountAttachmentsRequest(data, id, null, manifestAbilitato, numeroAttachments);
		checkAttachmentsRequest(data, id, null, msg);
		if(checkServizioApplicativo){
			Reporter.log("["+this.tipoCooperazione+"] Numero messaggi arrivati al servizio applicativo: "+data.getVerificatoreTracciaRichiesta().isArrivedCount(id));
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isArrivedCount(id)==1);
		}
		Reporter.log("["+this.tipoCooperazione+"] ----------------------------------------------------------");

		Reporter.log("["+this.tipoCooperazione+"] Controllo tracciamento risposta con riferimento id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTraced(id));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta della risposta con riferimento id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedMittente(id, this.destinatario, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta della risposta con riferimento id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedDestinatario(id, this.mittente, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta della risposta con riferimento id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedServizio(id, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta della risposta con riferimento id: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedAzione(id, azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta della risposta con riferimento id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloDiCollaborazione(id, SPCoopCostanti.PROFILO_COLLABORAZIONE_SINCRONO, ProfiloDiCollaborazione.SINCRONO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedCollaborazione(id, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloTrasmissione(id, this.confermaRicezione,this.inoltro,this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione, riferimento messaggio: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, this.destinatario,null, this.mittente, null));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, this.destinatario,null, this.mittente, null, true,tipoTempoAtteso,tipoTempoAttesoSdk));
		}
		checkCountAttachmentsResponse(data, id, null, manifestAbilitato,  numeroAttachments);
	}






	/***
	 * Test per il profilo di collaborazione Asincrono Simmetrico, modalita asincrona
	 */
	public void asincronoSimmetrico_modalitaAsincrona(String portaDelegata,String portaDelegataCorrelata,String user,String password,RepositoryConsegnaRisposteAsincroneSimmetriche repositoryConsegnaRisposteAsincroneSimmetriche_modalitaAsincrona,
			RepositoryCorrelazioneIstanzeAsincrone repositoryCorrelazioneIstanzeAsincroneSimmetriche_modalitaAsincrona,boolean addIDUnivoco) throws Exception{		
		DatabaseComponent dbComponentFruitore = null;
		DatabaseComponent dbComponentErogatore = null;
		try{

			ClientAsincronoSimmetrico_ModalitaAsincrona client = 
				new ClientAsincronoSimmetrico_ModalitaAsincrona(repositoryConsegnaRisposteAsincroneSimmetriche_modalitaAsincrona,
						repositoryCorrelazioneIstanzeAsincroneSimmetriche_modalitaAsincrona,
						portaDelegataCorrelata);
			client.setUrlPortaDiDominio(Utilities.testSuiteProperties.getServizioRicezioneContenutiApplicativiFruitore());
			client.setPortaDelegata(portaDelegata);
			client.connectToSoapEngine();
			client.setAutenticazione(user,password);
			if(this.soapWithAttachments)
				client.setMessageWithAttachmentsFromFile(Utilities.testSuiteProperties.getSoapWithAttachmentsFileName(), false,addIDUnivoco);
			else
				client.setMessageFromFile(Utilities.testSuiteProperties.getSoapFileName(), false,addIDUnivoco);

			// AttesaTerminazioneMessaggi
			if(Utilities.testSuiteProperties.attendiTerminazioneMessaggi_verificaDatabase()){
				dbComponentFruitore = DatabaseProperties.getDatabaseComponentFruitore();
				dbComponentErogatore = DatabaseProperties.getDatabaseComponentErogatore();

				client.setAttesaTerminazioneMessaggi(true);
				client.setDbAttesaTerminazioneMessaggiFruitore(dbComponentFruitore);
				client.setDbAttesaTerminazioneMessaggiErogatore(dbComponentErogatore);
			}
			client.run();
		}catch(Exception e){
			throw e;
		}finally{
			try{
				dbComponentFruitore.close();
			}catch(Exception eClose){}
			try{
				dbComponentErogatore.close();
			}catch(Exception eClose){}
		}
	}
	public void testAsincronoSimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione) throws FatalTestSuiteException{
		testAsincronoSimmetrico_ModalitaAsincrona(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, tipoServizioCorrelato, servizioCorrelato, 
				collaborazione,null,null,false,null,null);
	}
	public void testAsincronoSimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,boolean manifestAbilitato) throws FatalTestSuiteException{
		testAsincronoSimmetrico_ModalitaAsincrona(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, tipoServizioCorrelato, servizioCorrelato, 
				collaborazione,null,null,manifestAbilitato,null,null);
	}
	public void testAsincronoSimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk) throws FatalTestSuiteException{
		testAsincronoSimmetrico_ModalitaAsincrona(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, tipoServizioCorrelato, servizioCorrelato, 
				collaborazione, tipoTempoAtteso, tipoTempoAttesoSdk,false,null,null);
	}
	public void testAsincronoSimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,boolean manifestAbilitato) throws FatalTestSuiteException{
		testAsincronoSimmetrico_ModalitaAsincrona(data,id,tipoServizio,servizio,azione,
				checkServizioApplicativo,tipoServizioCorrelato,servizioCorrelato,collaborazione,
				tipoTempoAtteso,tipoTempoAttesoSdk,manifestAbilitato, null,null);
	}
	public void testAsincronoSimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,boolean manifestAbilitato, 
			Integer numeroAttachments, Message msg) throws FatalTestSuiteException{
		Reporter.log("["+this.tipoCooperazione+"] Controllo tracciamento richiesta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTraced(id));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedMittente(id, this.mittente, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedDestinatario(id, this.destinatario, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con id: " +id);
		DatiServizio datiServizio = new DatiServizio(tipoServizio,servizio, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedServizio(id, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con id: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedAzione(id, azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloDiCollaborazione(id, SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_SIMMETRICO, ProfiloDiCollaborazione.ASINCRONO_SIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedCollaborazione(id, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloTrasmissione(id, this.confermaRicezione,this.inoltro, this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore tipo e servizio correlato");
		DatiServizio datiServizioCorrelato = new DatiServizio(tipoServizioCorrelato,servizioCorrelato, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedServizioCorrelato(id, datiServizioCorrelato));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null, this.destinatario, null, true,tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null, this.destinatario, null));
		}
		checkCountAttachmentsRequest(data, id, null,manifestAbilitato, numeroAttachments);
		checkAttachmentsRequest(data, id, null, msg);
		if(checkServizioApplicativo){
			Reporter.log("["+this.tipoCooperazione+"] Numero messaggi arrivati al servizio applicativo: "+data.getVerificatoreTracciaRichiesta().isArrivedCount(id));
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isArrivedCount(id)==1);
		}
		Reporter.log("["+this.tipoCooperazione+"] ----------------------------------------------------------");

		DatiServizioAzione datiServizioAzione = new DatiServizioAzione(tipoServizio, servizio, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT,azione);
		
		Reporter.log("["+this.tipoCooperazione+"] Controllo ricevuta richiesta asincrona simmetrica con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTraced(id,datiServizioAzione));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedMittente(id, datiServizioAzione,this.destinatario,null ));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedDestinatario(id, datiServizioAzione,this.mittente, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedServizio(id, datiServizioAzione,datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con riferimento messaggio: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedAzione(id, datiServizioAzione,azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloDiCollaborazione(id, datiServizioAzione,SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_SIMMETRICO,ProfiloDiCollaborazione.ASINCRONO_SIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedCollaborazione(id, datiServizioAzione,collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloTrasmissione(id, datiServizioAzione, this.confermaRicezione,this.inoltro,this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione, riferimento messaggio: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id,datiServizioAzione, this.destinatario, null, this.mittente, null));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id,datiServizioAzione, this.destinatario, null, this.mittente, null, true,tipoTempoAtteso,tipoTempoAttesoSdk));
		}
		
	}
	public void testRispostaAsincronoSimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione, boolean checkServizioApplicativo,
			RepositoryCorrelazioneIstanzeAsincrone repositoryCorrelazioneIstanzeAsincroneSimmetriche_modalitaAsincrona,String collaborazione) throws FatalTestSuiteException{
		testRispostaAsincronoSimmetrico_ModalitaAsincrona(data, id, idCorrelazioneAsincrona, tipoServizio, servizio, azione, checkServizioApplicativo, 
				repositoryCorrelazioneIstanzeAsincroneSimmetriche_modalitaAsincrona, collaborazione,null,null,false);
	}
	public void testRispostaAsincronoSimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione, boolean checkServizioApplicativo,
			RepositoryCorrelazioneIstanzeAsincrone repositoryCorrelazioneIstanzeAsincroneSimmetriche_modalitaAsincrona,String collaborazione,
			boolean manifestAbilitato) throws FatalTestSuiteException{
		testRispostaAsincronoSimmetrico_ModalitaAsincrona(data, id, idCorrelazioneAsincrona, tipoServizio, servizio, azione, checkServizioApplicativo, 
				repositoryCorrelazioneIstanzeAsincroneSimmetriche_modalitaAsincrona, collaborazione,null,null,manifestAbilitato);
	}
	public void testRispostaAsincronoSimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione, boolean checkServizioApplicativo,
			RepositoryCorrelazioneIstanzeAsincrone repositoryCorrelazioneIstanzeAsincroneSimmetriche_modalitaAsincrona,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk) throws FatalTestSuiteException{
		testRispostaAsincronoSimmetrico_ModalitaAsincrona(data, id, idCorrelazioneAsincrona, tipoServizio, servizio, azione, checkServizioApplicativo, 
				repositoryCorrelazioneIstanzeAsincroneSimmetriche_modalitaAsincrona, collaborazione, tipoTempoAtteso, tipoTempoAttesoSdk, false);
	}
	public void testRispostaAsincronoSimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione, boolean checkServizioApplicativo,
			RepositoryCorrelazioneIstanzeAsincrone repositoryCorrelazioneIstanzeAsincroneSimmetriche_modalitaAsincrona,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,
			boolean manifestAbilitato) throws FatalTestSuiteException{
		Reporter.log("["+this.tipoCooperazione+"] Controllo tracciamento risposta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTraced(id));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta risposta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedMittente(id, this.destinatario, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta risposta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedDestinatario(id, this.mittente, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta risposta con id: " +id);
		DatiServizio datiServizio = new DatiServizio(tipoServizio,servizio, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedServizio(id, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta risposta con id: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedAzione(id, azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore RiferimentoMessaggio (valore atteso: "+idCorrelazioneAsincrona+")  della risposta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedRiferimentoMessaggio(id, idCorrelazioneAsincrona));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta risposta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloDiCollaborazione(id, SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_SIMMETRICO, ProfiloDiCollaborazione.ASINCRONO_SIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedCollaborazione(id, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloTrasmissione(id, this.confermaRicezione,this.inoltro, this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.destinatario, null, this.mittente, null, true,tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.destinatario, null, this.mittente, null));
		}
		checkCountAttachmentsRequest(data, id, null, manifestAbilitato); 
		Reporter.log("["+this.tipoCooperazione+"] ----------------------------------------------------------");

		//String id = repositoryCorrelazioneIstanzeAsincroneSimmetriche_modalitaAsincrona.getNextInvAssociate(id);
		DatiServizioAzione datiServizioAzione = new DatiServizioAzione(tipoServizio, servizio, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT,azione);
				
		Reporter.log("["+this.tipoCooperazione+"] Controllo ricevuta risposta asincrona simmetrica con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTraced(id,datiServizioAzione));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedMittente(id, datiServizioAzione, this.mittente, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedDestinatario(id, datiServizioAzione, this.destinatario, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedServizio(id, datiServizioAzione,datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con riferimento messaggio: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedAzione(id, datiServizioAzione,azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloDiCollaborazione(id, datiServizioAzione, SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_SIMMETRICO, ProfiloDiCollaborazione.ASINCRONO_SIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedCollaborazione(id, datiServizioAzione, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloTrasmissione(id, datiServizioAzione, this.confermaRicezione,this.inoltro,this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione, riferimento messaggio: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, datiServizioAzione, this.mittente, null, this.destinatario, null,true,tipoTempoAtteso,tipoTempoAttesoSdk));
		}
		else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, datiServizioAzione, this.mittente, null, this.destinatario, null));
		}
	}






	/***
	 * Test per il profilo di collaborazione Asincrono Simmetrico, modalita sincrona
	 */
	public void asincronoSimmetrico_modalitaSincrona(String portaDelegata,String portaDelegataCorrelata, String user,String password,RepositoryConsegnaRisposteAsincroneSimmetriche repositoryConsegnaRisposteAsincroneSimmetriche_modalitaSincrona,
			RepositoryCorrelazioneIstanzeAsincrone repositoryCorrelazioneIstanzeAsincroneSimmetriche_modalitaSincrona,boolean addIDUnivoco) throws Exception{		
		ClientAsincronoSimmetrico_ModalitaSincrona client = 
			new ClientAsincronoSimmetrico_ModalitaSincrona(repositoryConsegnaRisposteAsincroneSimmetriche_modalitaSincrona,
					repositoryCorrelazioneIstanzeAsincroneSimmetriche_modalitaSincrona,
					portaDelegataCorrelata);
		client.setUrlPortaDiDominio(Utilities.testSuiteProperties.getServizioRicezioneContenutiApplicativiFruitore());
		client.setPortaDelegata(portaDelegata);
		client.connectToSoapEngine();
		client.setAutenticazione(user,password);
		if(this.soapWithAttachments)
			client.setMessageWithAttachmentsFromFile(Utilities.testSuiteProperties.getSoapWithAttachmentsFileName(), false,addIDUnivoco);
		else
			client.setMessageFromFile(Utilities.testSuiteProperties.getSoapFileName(), false,addIDUnivoco);
		client.run();

		// Test uguaglianza Body (e attachments)
		Assert.assertTrue(client.isEqualsSentAndResponseMessage());
		if(this.soapWithAttachments)
			Assert.assertTrue(client.isEqualsSentAndResponseAttachments());
	}
	public void testAsincronoSimmetrico_ModalitaSincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione) throws FatalTestSuiteException{
		testAsincronoSimmetrico_ModalitaSincrona(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, tipoServizioCorrelato, servizioCorrelato, 
				collaborazione, null, null,false,null,null);
	}
	public void testAsincronoSimmetrico_ModalitaSincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,boolean manifestAbilitato) throws FatalTestSuiteException{
		testAsincronoSimmetrico_ModalitaSincrona(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, tipoServizioCorrelato, servizioCorrelato, 
				collaborazione, null, null,manifestAbilitato,null,null);
	}
	public void testAsincronoSimmetrico_ModalitaSincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk) throws FatalTestSuiteException{
		testAsincronoSimmetrico_ModalitaSincrona(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, tipoServizioCorrelato, servizioCorrelato, 
				collaborazione, tipoTempoAtteso, tipoTempoAttesoSdk,false,null,null);
	}
	public void testAsincronoSimmetrico_ModalitaSincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,boolean manifestAbilitato) throws FatalTestSuiteException{
		testAsincronoSimmetrico_ModalitaSincrona(data,id,tipoServizio,servizio,azione,
				checkServizioApplicativo,tipoServizioCorrelato,servizioCorrelato,collaborazione,
				tipoTempoAtteso,tipoTempoAttesoSdk,manifestAbilitato,null,null);
	}
	public void testAsincronoSimmetrico_ModalitaSincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,boolean manifestAbilitato,
			Integer numeroAttachments, Message msg) throws FatalTestSuiteException{
		Reporter.log("["+this.tipoCooperazione+"] Controllo tracciamento richiesta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTraced(id));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedMittente(id, this.mittente, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedDestinatario(id, this.destinatario, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id,tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con id: " +id);
		DatiServizio datiServizio = new DatiServizio(tipoServizio,servizio, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedServizio(id, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con id: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedAzione(id, azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloDiCollaborazione(id, SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_SIMMETRICO, ProfiloDiCollaborazione.ASINCRONO_SIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedCollaborazione(id, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloTrasmissione(id, this.confermaRicezione,this.inoltro, this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore tipo e servizio correlato");
		DatiServizio datiServizioCorrelato = new DatiServizio(tipoServizioCorrelato,servizioCorrelato, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedServizioCorrelato(id, datiServizioCorrelato));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null,  this.destinatario, null, true, tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null, this.destinatario, null));
		}
		checkCountAttachmentsRequest(data, id, null, manifestAbilitato, numeroAttachments);
		checkAttachmentsRequest(data, id, null, msg);
		if(checkServizioApplicativo){
			Reporter.log("["+this.tipoCooperazione+"] Numero messaggi arrivati al servizio applicativo: "+data.getVerificatoreTracciaRichiesta().isArrivedCount(id));
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isArrivedCount(id)==1);
		}
		Reporter.log("["+this.tipoCooperazione+"] ----------------------------------------------------------");

		Reporter.log("["+this.tipoCooperazione+"] Controllo ricevuta richiesta asincrona simmetrica con riferimento messaggio: " +id);
		DatiServizioAzione datiServizioAzione = new DatiServizioAzione(datiServizio,azione);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTraced(id,datiServizioAzione));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedMittente(id, datiServizioAzione, this.destinatario, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedDestinatario(id, datiServizioAzione, this.mittente, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedServizio(id, datiServizioAzione, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con riferimento messaggio: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedAzione(id, datiServizioAzione, azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloDiCollaborazione(id, datiServizioAzione, SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_SIMMETRICO, ProfiloDiCollaborazione.ASINCRONO_SIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedCollaborazione(id, datiServizioAzione, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloTrasmissione(id, datiServizioAzione, this.confermaRicezione,this.inoltro,this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione, riferimento messaggio: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, datiServizioAzione, this.destinatario, null, this.mittente, null, true,tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, datiServizioAzione, this.destinatario, null, this.mittente, null));
		}
	}
	public void testRispostaAsincronoSimmetrico_ModalitaSincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione) throws FatalTestSuiteException{
		testRispostaAsincronoSimmetrico_ModalitaSincrona(data, id, idCorrelazioneAsincrona, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione,null,null,
				false);
	}
	public void testRispostaAsincronoSimmetrico_ModalitaSincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione,boolean manifestAbilitato) throws FatalTestSuiteException{
		testRispostaAsincronoSimmetrico_ModalitaSincrona(data, id, idCorrelazioneAsincrona, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione,null,null,
				manifestAbilitato);
	}
	public void testRispostaAsincronoSimmetrico_ModalitaSincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk) throws FatalTestSuiteException{
		testRispostaAsincronoSimmetrico_ModalitaSincrona(data, id, idCorrelazioneAsincrona, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione, 
				tipoTempoAtteso, tipoTempoAttesoSdk, false);
	}
	public void testRispostaAsincronoSimmetrico_ModalitaSincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,boolean manifestAbilitato) throws FatalTestSuiteException{
		Reporter.log("["+this.tipoCooperazione+"] Controllo tracciamento risposta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTraced(id));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta risposta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedMittente(id, this.destinatario, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta risposta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedDestinatario(id, this.mittente, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta risposta con id: " +id);
		DatiServizio datiServizio = new DatiServizio(tipoServizio,servizio, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedServizio(id, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta risposta con id: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedAzione(id, azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore RiferimentoMessaggio (valore atteso: "+idCorrelazioneAsincrona+")  della risposta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedRiferimentoMessaggio(id, idCorrelazioneAsincrona));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta risposta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloDiCollaborazione(id, SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_SIMMETRICO, ProfiloDiCollaborazione.ASINCRONO_SIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedCollaborazione(id, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloTrasmissione(id, this.confermaRicezione,this.inoltro,this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.destinatario, null, this.mittente, null, true,tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.destinatario, null, this.mittente, null));
		}
		checkCountAttachmentsRequest(data, id, null, manifestAbilitato); // asincrono e' una risposta!
		Reporter.log("["+this.tipoCooperazione+"] ----------------------------------------------------------");

		//String id = repositoryCorrelazioneIstanzeAsincroneSimmetriche_modalitaAsincrona.getNextInvAssociate(id);
		Reporter.log("["+this.tipoCooperazione+"] Controllo ricevuta risposta asincrona simmetrica con riferimento messaggio: " +id);
		DatiServizioAzione datiServizioAzione = new DatiServizioAzione(datiServizio, azione);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTraced(id,datiServizioAzione));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedMittente(id, datiServizioAzione, this.mittente, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedDestinatario(id, datiServizioAzione, this.destinatario, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedServizio(id, datiServizioAzione, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con riferimento messaggio: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedAzione(id, datiServizioAzione,azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloDiCollaborazione(id, datiServizioAzione, SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_SIMMETRICO,ProfiloDiCollaborazione.ASINCRONO_SIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedCollaborazione(id, datiServizioAzione, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloTrasmissione(id, datiServizioAzione, this.confermaRicezione,this.inoltro, this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione, riferimento messaggio: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, datiServizioAzione, this.mittente, null, this.destinatario, null, true,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, datiServizioAzione, this.mittente, null, this.destinatario, null));
		}
	}







	/***
	 * Test per il profilo di collaborazione Asincrono Asimmetrico, modalita asincrona
	 */
	public void asincronoAsimmetrico_modalitaAsincrona(String portaDelegata, String portaDelegataCorrelata, 
			RepositoryCorrelazioneIstanzeAsincrone repositoryCorrelazioneIstanzeAsincroneAsimmetriche_modalitaAsincrona,boolean addIDUnivoco) throws FatalTestSuiteException, Exception{
		DatabaseComponent dbComponentFruitore = null;
		DatabaseComponent dbComponentErogatore = null;
		try{

			ClientAsincronoAsimmetrico_ModalitaAsincrona client = new ClientAsincronoAsimmetrico_ModalitaAsincrona(repositoryCorrelazioneIstanzeAsincroneAsimmetriche_modalitaAsincrona);
			client.setUrlPortaDiDominio(Utilities.testSuiteProperties.getServizioRicezioneContenutiApplicativiFruitore());
			client.setPortaDelegata(portaDelegata);
			client.setPortaDelegataCorrelata(portaDelegataCorrelata);
			client.connectToSoapEngine();
			client.setGeneraIDUnivoco(addIDUnivoco);
			if(this.soapWithAttachments)
				client.setMessageWithAttachmentsFromFile(Utilities.testSuiteProperties.getSoapWithAttachmentsFileName(), false,addIDUnivoco);
			else
				client.setMessageFromFile(Utilities.testSuiteProperties.getSoapFileName(), false,addIDUnivoco);

			// AttesaTerminazioneMessaggi
			if(Utilities.testSuiteProperties.attendiTerminazioneMessaggi_verificaDatabase()){
				dbComponentFruitore = DatabaseProperties.getDatabaseComponentFruitore();
				dbComponentErogatore = DatabaseProperties.getDatabaseComponentErogatore();

				client.setAttesaTerminazioneMessaggi(true);
				client.setDbAttesaTerminazioneMessaggiFruitore(dbComponentFruitore);
				client.setDbAttesaTerminazioneMessaggiErogatore(dbComponentErogatore);
			}
			client.run();
		}catch(Exception e){
			throw e;
		}finally{
			try{
				dbComponentFruitore.close();
			}catch(Exception eClose){}
			try{
				dbComponentErogatore.close();
			}catch(Exception eClose){}
		}
	}
	public void testAsincronoAsimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String tipoServizio,
			String servizio,String azione, boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione) throws FatalTestSuiteException{
		testAsincronoAsimmetrico_ModalitaAsincrona(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, tipoServizioCorrelato, servizioCorrelato, collaborazione, null, null,
				false,null,null);
	}
	public void testAsincronoAsimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String tipoServizio,
			String servizio,String azione, boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,boolean manifestAbilitato) throws FatalTestSuiteException{
		testAsincronoAsimmetrico_ModalitaAsincrona(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, tipoServizioCorrelato, servizioCorrelato, collaborazione, null, null,
				manifestAbilitato,null,null);
	}
	public void testAsincronoAsimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String tipoServizio,
			String servizio,String azione, boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk) throws FatalTestSuiteException{
		testAsincronoAsimmetrico_ModalitaAsincrona(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, tipoServizioCorrelato, servizioCorrelato, 
				collaborazione, tipoTempoAtteso, tipoTempoAttesoSdk,false,null,null);
	}
	public void testAsincronoAsimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String tipoServizio,
			String servizio,String azione, boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,boolean manifestAbilitato) throws FatalTestSuiteException{
		testAsincronoAsimmetrico_ModalitaAsincrona(data,id,tipoServizio,
				servizio,azione, checkServizioApplicativo,tipoServizioCorrelato,servizioCorrelato,collaborazione,
				tipoTempoAtteso,tipoTempoAttesoSdk,manifestAbilitato,null,null);
	}
	public void testAsincronoAsimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String tipoServizio,
			String servizio,String azione, boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,boolean manifestAbilitato,
			Integer numeroAttachments, Message msg) throws FatalTestSuiteException{
		Reporter.log("["+this.tipoCooperazione+"] Controllo tracciamento richiesta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTraced(id));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedMittente(id, this.mittente, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedDestinatario(id, this.destinatario, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id,tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con id: " +id);
		DatiServizio datiServizio = new DatiServizio(tipoServizio,servizio, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedServizio(id, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con id: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedAzione(id, azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloDiCollaborazione(id, SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_ASIMMETRICO,ProfiloDiCollaborazione.ASINCRONO_ASIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedCollaborazione(id, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloTrasmissione(id, this.confermaRicezione,this.inoltro,this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null, this.destinatario, null, true, tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null, this.destinatario, null));
		}
		checkCountAttachmentsRequest(data, id, null, manifestAbilitato, numeroAttachments);
		checkAttachmentsRequest(data, id, null, msg);
		if(checkServizioApplicativo){
			Reporter.log("["+this.tipoCooperazione+"] Numero messaggi arrivati al servizio applicativo: "+data.getVerificatoreTracciaRichiesta().isArrivedCount(id));
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isArrivedCount(id)==1);
		}
		Reporter.log("["+this.tipoCooperazione+"] ----------------------------------------------------------");

		Reporter.log("["+this.tipoCooperazione+"] Controllo ricevuta richiesta asincrona asimmetrica con riferimento messaggio: " +id);
		DatiServizioAzione datiServizioAzione = new DatiServizioAzione(datiServizio, azione);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTraced(id,datiServizioAzione));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedMittente(id, datiServizioAzione, this.destinatario, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedDestinatario(id, datiServizioAzione, this.mittente, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id,tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedServizio(id, datiServizioAzione, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con riferimento messaggio: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedAzione(id, datiServizioAzione, azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloDiCollaborazione(id, datiServizioAzione, SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_ASIMMETRICO,ProfiloDiCollaborazione.ASINCRONO_ASIMMETRICO));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore tipo e servizio correlato");
		DatiServizio datiServizioCorrelato = new DatiServizio(tipoServizioCorrelato, servizioCorrelato, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedServizioCorrelato(id, datiServizioAzione, datiServizioCorrelato));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedCollaborazione(id, datiServizioAzione, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloTrasmissione(id, datiServizioAzione, this.confermaRicezione,this.inoltro, this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione, riferimento messaggio: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, datiServizioAzione, this.destinatario, null, this.mittente, null,true,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, datiServizioAzione, this.destinatario, null, this.mittente, null));
		}
	}
	public void testRispostaAsincronoAsimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione) throws FatalTestSuiteException{
		testRispostaAsincronoAsimmetrico_ModalitaAsincrona(data, id, idCorrelazioneAsincrona, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione,null,null,
				false);
	}
	public void testRispostaAsincronoAsimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione, boolean manifestAbilitato) throws FatalTestSuiteException{
		testRispostaAsincronoAsimmetrico_ModalitaAsincrona(data, id, idCorrelazioneAsincrona, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione,null,null,
				manifestAbilitato);
	}
	public void testRispostaAsincronoAsimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk) throws FatalTestSuiteException{
		testRispostaAsincronoAsimmetrico_ModalitaAsincrona(data, id, idCorrelazioneAsincrona, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione, 
				tipoTempoAtteso, tipoTempoAttesoSdk, false);
	}
	public void testRispostaAsincronoAsimmetrico_ModalitaAsincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk, boolean manifestAbilitato) throws FatalTestSuiteException{
		
		Reporter.log("["+this.tipoCooperazione+"] Controllo tracciamento risposta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTraced(id));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedMittente(id, this.mittente, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedDestinatario(id, this.destinatario, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con id: " +id);
		DatiServizio datiServizio = new DatiServizio(tipoServizio,servizio, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedServizio(id, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con id: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedAzione(id, azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore RiferimentoMessaggio (valore atteso: "+idCorrelazioneAsincrona+")  della risposta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedRiferimentoMessaggio(id, idCorrelazioneAsincrona));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloDiCollaborazione(id, SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_ASIMMETRICO,ProfiloDiCollaborazione.ASINCRONO_ASIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedCollaborazione(id, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloTrasmissione(id, this.confermaRicezione,this.inoltro,this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null, this.destinatario, null, true,tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null, this.destinatario, null));
		}
		checkCountAttachmentsRequest(data, id, null, manifestAbilitato); // asincrono e' una risposta!
		if(checkServizioApplicativo){
			Reporter.log("["+this.tipoCooperazione+"] Numero messaggi arrivati al servizio applicativo: "+data.getVerificatoreTracciaRichiesta().isArrivedCount(id));
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isArrivedCount(id)==1);
		}
		Reporter.log("["+this.tipoCooperazione+"] ----------------------------------------------------------");

		Reporter.log("["+this.tipoCooperazione+"] Controllo ricevuta risposta asincrona asimmetrica con riferimento messaggio: " +id);
		DatiServizioAzione datiServizioAzione = new DatiServizioAzione(datiServizio, azione);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTraced(id,datiServizioAzione));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedMittente(id, datiServizioAzione, this.destinatario, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedDestinatario(id,datiServizioAzione,this.mittente, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedServizio(id, datiServizioAzione, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con riferimento messaggio: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedAzione(id, datiServizioAzione,azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloDiCollaborazione(id, datiServizioAzione, SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_ASIMMETRICO,ProfiloDiCollaborazione.ASINCRONO_ASIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedCollaborazione(id, datiServizioAzione, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloTrasmissione(id,datiServizioAzione, this.confermaRicezione,this.inoltro,this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione, riferimento messaggio: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, datiServizioAzione, this.destinatario,null, this.mittente,null,true,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, datiServizioAzione, this.destinatario,null, this.mittente,null));
		}
	}






	/***
	 * Test per il profilo di collaborazione Asincrono Asimmetrico, modalita sincrona
	 */
	public void asincronoAsimmetrico_modalitaSincrona(String portaDelegata,String portaDelegataCorrelata,
			RepositoryCorrelazioneIstanzeAsincrone repositoryCorrelazioneIstanzeAsincroneAsimmetriche_modalitaSincrona,boolean addIDUnivoco) throws FatalTestSuiteException, IOException, SOAPException{
		ClientAsincronoAsimmetrico_ModalitaSincrona client = new ClientAsincronoAsimmetrico_ModalitaSincrona(repositoryCorrelazioneIstanzeAsincroneAsimmetriche_modalitaSincrona);
		client.setUrlPortaDiDominio(Utilities.testSuiteProperties.getServizioRicezioneContenutiApplicativiFruitore());
		client.setPortaDelegata(portaDelegata);
		client.setGeneraIDUnivoco(addIDUnivoco);
		client.setPortaDelegataCorrelata(portaDelegataCorrelata);
		client.connectToSoapEngine();
		if(this.soapWithAttachments)
			client.setMessageWithAttachmentsFromFile(Utilities.testSuiteProperties.getSoapWithAttachmentsFileName(), false,addIDUnivoco);
		else
			client.setMessageFromFile(Utilities.testSuiteProperties.getSoapFileName(), false,addIDUnivoco);
		client.run();

		// Test uguaglianza Body (e attachments)
		Assert.assertTrue(client.isEqualsSentAndResponseMessage());
		if(this.soapWithAttachments)
			Assert.assertTrue(client.isEqualsSentAndResponseAttachments());
	}
	public void testAsincronoAsimmetrico_modalitaSincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione) throws FatalTestSuiteException{
		testAsincronoAsimmetrico_modalitaSincrona(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, tipoServizioCorrelato, servizioCorrelato, collaborazione, 
				null,null,false,null,null);
	}
	public void testAsincronoAsimmetrico_modalitaSincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,boolean manifestAbilitato) throws FatalTestSuiteException{
		testAsincronoAsimmetrico_modalitaSincrona(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, tipoServizioCorrelato, servizioCorrelato, collaborazione, 
				null,null,manifestAbilitato,null,null);
	}
	public void testAsincronoAsimmetrico_modalitaSincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk) throws FatalTestSuiteException{
		testAsincronoAsimmetrico_modalitaSincrona(data, id, tipoServizio, servizio, azione, checkServizioApplicativo, tipoServizioCorrelato, servizioCorrelato, 
				collaborazione, tipoTempoAtteso, tipoTempoAttesoSdk, false,null,null);
	}
	public void testAsincronoAsimmetrico_modalitaSincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,boolean manifestAbilitato) throws FatalTestSuiteException{
		testAsincronoAsimmetrico_modalitaSincrona(data,id,tipoServizio,servizio,azione,
				checkServizioApplicativo,tipoServizioCorrelato,servizioCorrelato,collaborazione,
				tipoTempoAtteso,tipoTempoAttesoSdk,manifestAbilitato,null,null);
	}
	public void testAsincronoAsimmetrico_modalitaSincrona(DatabaseComponent data,String id,String tipoServizio,String servizio,String azione,
			boolean checkServizioApplicativo,String tipoServizioCorrelato,String servizioCorrelato,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,boolean manifestAbilitato,
			Integer numeroAttachments, Message msg) throws FatalTestSuiteException{
		Reporter.log("["+this.tipoCooperazione+"] Controllo tracciamento richiesta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTraced(id));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedMittente(id, this.mittente, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedDestinatario(id, this.destinatario, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id,tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con id: " +id);
		DatiServizio datiServizio = new DatiServizio(tipoServizio,servizio, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedServizio(id, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con id: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedAzione(id, azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloDiCollaborazione(id, SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_ASIMMETRICO, ProfiloDiCollaborazione.ASINCRONO_ASIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedCollaborazione(id, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloTrasmissione(id, this.confermaRicezione,this.inoltro, this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null, this.destinatario, null,  true, tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null, this.destinatario, null));
		}
		checkCountAttachmentsRequest(data, id, null, manifestAbilitato, numeroAttachments);
		checkAttachmentsRequest(data, id, null, msg);
		if(checkServizioApplicativo){
			Reporter.log("["+this.tipoCooperazione+"] Numero messaggi arrivati al servizio applicativo: "+data.getVerificatoreTracciaRichiesta().isArrivedCount(id));
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isArrivedCount(id)==1);
		}
		Reporter.log("["+this.tipoCooperazione+"] ----------------------------------------------------------");

		DatiServizioAzione datiServizioAzione = new DatiServizioAzione(datiServizio, azione);
		Reporter.log("["+this.tipoCooperazione+"] Controllo ricevuta richiesta asincrona asimmetrica con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTraced(id,datiServizioAzione));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedMittente(id, datiServizioAzione, this.destinatario, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedDestinatario(id, datiServizioAzione, this.mittente, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id,tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedServizio(id, datiServizioAzione, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con riferimento messaggio: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedAzione(id, datiServizioAzione,azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloDiCollaborazione(id, datiServizioAzione, SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_ASIMMETRICO,ProfiloDiCollaborazione.ASINCRONO_ASIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedCollaborazione(id, datiServizioAzione, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloTrasmissione(id, datiServizioAzione, this.confermaRicezione,this.inoltro, this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore tipo["+tipoServizioCorrelato+"] e servizio correlato["+servizioCorrelato+"]");
		DatiServizio datiServizioCorrelato = new DatiServizio(tipoServizioCorrelato, servizioCorrelato, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedServizioCorrelato(id, datiServizioAzione,datiServizioCorrelato));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione, riferimento messaggio: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, datiServizioAzione, this.destinatario, null, this.mittente, null, true, tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, datiServizioAzione, this.destinatario, null, this.mittente, null));
		}
	}
	public void testRispostaAsincronoAsimmetrico_modalitaSincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione) throws FatalTestSuiteException{
		testRispostaAsincronoAsimmetrico_modalitaSincrona(data, id, idCorrelazioneAsincrona, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione,null,null,
				false);
	}
	public void testRispostaAsincronoAsimmetrico_modalitaSincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione,boolean manifestAbilitato) throws FatalTestSuiteException{
		testRispostaAsincronoAsimmetrico_modalitaSincrona(data, id, idCorrelazioneAsincrona, tipoServizio, servizio, azione, checkServizioApplicativo, collaborazione,null,null,
				manifestAbilitato);
	}
	public void testRispostaAsincronoAsimmetrico_modalitaSincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk) throws FatalTestSuiteException{
		testRispostaAsincronoAsimmetrico_modalitaSincrona(data, id, idCorrelazioneAsincrona, tipoServizio, servizio, azione, checkServizioApplicativo, 
				collaborazione, tipoTempoAtteso, tipoTempoAttesoSdk, false);
	}
	public void testRispostaAsincronoAsimmetrico_modalitaSincrona(DatabaseComponent data,String id,String idCorrelazioneAsincrona,
			String tipoServizio,String servizio,String azione,boolean checkServizioApplicativo,String collaborazione,
			String tipoTempoAtteso,TipoOraRegistrazione tipoTempoAttesoSdk,boolean manifestAbilitato) throws FatalTestSuiteException{
		
		Reporter.log("["+this.tipoCooperazione+"] Controllo tracciamento risposta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTraced(id));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedMittente(id, this.mittente, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedDestinatario(id, this.destinatario, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con id: " +id);
		DatiServizio datiServizio = new DatiServizio(tipoServizio,servizio, CostantiTestSuite.SPCOOP_VERSIONE_SERVIZIO_DEFAULT);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedServizio(id,datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con id: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedAzione(id, azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore RiferimentoMessaggio (valore atteso: "+idCorrelazioneAsincrona+")  della risposta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedRiferimentoMessaggio(id, idCorrelazioneAsincrona));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloDiCollaborazione(id, SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_ASIMMETRICO, ProfiloDiCollaborazione.ASINCRONO_ASIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedCollaborazione(id, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedProfiloTrasmissione(id, this.confermaRicezione,this.inoltro, this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null , this.destinatario, null, true,tipoTempoAtteso,tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isTracedTrasmissione(id, this.mittente, null,  this.destinatario, null));
		}
		checkCountAttachmentsRequest(data, id, null, manifestAbilitato); // asincrono e' una risposta!
		if(checkServizioApplicativo){
			Reporter.log("["+this.tipoCooperazione+"] Numero messaggi arrivati al servizio applicativo: "+data.getVerificatoreTracciaRichiesta().isArrivedCount(id));
			Assert.assertTrue(data.getVerificatoreTracciaRichiesta().isArrivedCount(id)==1);
		}
		Reporter.log("["+this.tipoCooperazione+"] ----------------------------------------------------------");

		DatiServizioAzione datiServizioAzione = new DatiServizioAzione(datiServizio, azione);
		Reporter.log("["+this.tipoCooperazione+"] Controllo ricevuta risposta asincrona asimmetrica con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTraced(id,datiServizioAzione));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Mittente Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedMittente(id, datiServizioAzione, this.destinatario, null));
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Destinatario Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedDestinatario(id, datiServizioAzione, this.mittente, null));
		Reporter.log("Controllo valore OraRegistrazione con id: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id,tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedOraRegistrazione(id));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Servizio Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedServizio(id, datiServizioAzione, datiServizio));
		if(azione!=null){
			Reporter.log("["+this.tipoCooperazione+"] Controllo valore Azione Busta con riferimento messaggio: " +id);
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedAzione(id, datiServizioAzione,azione));
		}
		Reporter.log("["+this.tipoCooperazione+"] Controllo valore Profilo di Collaborazione Busta con riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloDiCollaborazione(id,datiServizioAzione,SPCoopCostanti.PROFILO_COLLABORAZIONE_ASINCRONO_ASIMMETRICO,ProfiloDiCollaborazione.ASINCRONO_ASIMMETRICO));
		Reporter.log("Controllo valore Collaborazione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedCollaborazione(id, datiServizioAzione, collaborazione));
		Reporter.log("Controllo valore Profilo di Trasmissione Busta con id: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedProfiloTrasmissione(id, datiServizioAzione, this.confermaRicezione,this.inoltro,this.inoltroSdk));
		Reporter.log("["+this.tipoCooperazione+"] Controllo che la busta non abbia generato eccezioni, riferimento messaggio: " +id);
		Assert.assertTrue(data.getVerificatoreTracciaRisposta().existsListaEccezioni(id)==false);
		Reporter.log("["+this.tipoCooperazione+"] Controllo lista trasmissione, riferimento messaggio: " +id);
		if(tipoTempoAtteso!=null){
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, datiServizioAzione, this.destinatario, null, this.mittente, null, true,tipoTempoAtteso, tipoTempoAttesoSdk));
		}else{
			Assert.assertTrue(data.getVerificatoreTracciaRisposta().isTracedTrasmissione(id, datiServizioAzione, this.destinatario, null, this.mittente, null));
		}
	}
	public boolean isConfermaRicezione() {
		return this.confermaRicezione;
	}
	public void setConfermaRicezione(boolean confermaRicezione) {
		this.confermaRicezione = confermaRicezione;
	}
	public IDSoggetto getDestinatario() {
		return this.destinatario;
	}
	public void setDestinatario(IDSoggetto destinatario) {
		this.destinatario = destinatario;
	}
	public String getInoltro() {
		return this.inoltro;
	}
	public void setInoltro(String inoltro) {
		this.inoltro = inoltro;
	}
	public Inoltro getInoltroSdk() {
		return this.inoltroSdk;
	}
	public void setInoltroSdk(Inoltro inoltro) {
		this.inoltroSdk = inoltro;
	}
	public IDSoggetto getMittente() {
		return this.mittente;
	}
	public void setMittente(IDSoggetto mittente) {
		this.mittente = mittente;
	}
	
}
