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


package org.openspcoop2.web.ctrlstat.servlet.aps;

import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.openspcoop2.core.commons.Liste;
import org.openspcoop2.core.config.constants.CostantiConfigurazione;
import org.openspcoop2.core.constants.CostantiDB;
import org.openspcoop2.core.constants.TipiConnettore;
import org.openspcoop2.core.constants.TransferLengthModes;
import org.openspcoop2.core.id.IDFruizione;
import org.openspcoop2.core.id.IDServizio;
import org.openspcoop2.core.id.IDSoggetto;
import org.openspcoop2.core.registry.AccordoServizioParteSpecifica;
import org.openspcoop2.core.registry.Connettore;
import org.openspcoop2.core.registry.Fruitore;
import org.openspcoop2.core.registry.ProtocolProperty;
import org.openspcoop2.core.registry.Soggetto;
import org.openspcoop2.core.registry.constants.StatiAccordo;
import org.openspcoop2.core.registry.constants.StatoFunzionalita;
import org.openspcoop2.core.registry.constants.TipologiaServizio;
import org.openspcoop2.core.registry.driver.IDServizioFactory;
import org.openspcoop2.core.registry.driver.ValidazioneStatoPackageException;
import org.openspcoop2.protocol.engine.ProtocolFactoryManager;
import org.openspcoop2.protocol.sdk.IProtocolFactory;
import org.openspcoop2.protocol.sdk.ProtocolException;
import org.openspcoop2.protocol.sdk.constants.ConsoleInterfaceType;
import org.openspcoop2.protocol.sdk.constants.ConsoleOperationType;
import org.openspcoop2.protocol.sdk.properties.ConsoleConfiguration;
import org.openspcoop2.protocol.sdk.properties.IConsoleDynamicConfiguration;
import org.openspcoop2.protocol.sdk.properties.ProtocolProperties;
import org.openspcoop2.protocol.sdk.properties.ProtocolPropertiesUtils;
import org.openspcoop2.protocol.sdk.registry.IRegistryReader;
import org.openspcoop2.web.ctrlstat.core.ControlStationCore;
import org.openspcoop2.web.ctrlstat.core.Search;
import org.openspcoop2.web.ctrlstat.costanti.ConnettoreServletType;
import org.openspcoop2.web.ctrlstat.plugins.ExtendedConnettore;
import org.openspcoop2.web.ctrlstat.plugins.servlet.ServletExtendedConnettoreUtils;
import org.openspcoop2.web.ctrlstat.servlet.GeneralHelper;
import org.openspcoop2.web.ctrlstat.servlet.connettori.ConnettoriCostanti;
import org.openspcoop2.web.ctrlstat.servlet.connettori.ConnettoriHelper;
import org.openspcoop2.web.ctrlstat.servlet.protocol_properties.ProtocolPropertiesCostanti;
import org.openspcoop2.web.ctrlstat.servlet.protocol_properties.ProtocolPropertiesUtilities;
import org.openspcoop2.web.ctrlstat.servlet.soggetti.SoggettiCore;
import org.openspcoop2.web.lib.mvc.BinaryParameter;
import org.openspcoop2.web.lib.mvc.Costanti;
import org.openspcoop2.web.lib.mvc.DataElement;
import org.openspcoop2.web.lib.mvc.ForwardParams;
import org.openspcoop2.web.lib.mvc.GeneralData;
import org.openspcoop2.web.lib.mvc.PageData;
import org.openspcoop2.web.lib.mvc.Parameter;
import org.openspcoop2.web.lib.mvc.ServletUtils;
import org.openspcoop2.web.lib.mvc.TipoOperazione;
import org.openspcoop2.web.lib.users.dao.InterfaceType;

/**
 * serviziFruitoriChange
 * 
 * @author Andrea Poli (apoli@link.it)
 * @author Stefano Corallo (corallo@link.it)
 * @author Sandra Giangrandi (sandra@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 * 
 */
public final class AccordiServizioParteSpecificaFruitoriChange extends Action {

	// Protocol Properties
	private IConsoleDynamicConfiguration consoleDynamicConfiguration = null;
	private ConsoleConfiguration consoleConfiguration =null;
	private ProtocolProperties protocolProperties = null;
	private IProtocolFactory<?> protocolFactory= null;
	private IRegistryReader registryReader = null; 
	private ConsoleOperationType consoleOperationType = null;
	private ConsoleInterfaceType consoleInterfaceType = null;
	private String protocolPropertiesSet = null;
	private String editMode = null;

	private BinaryParameter wsdlimpler, wsdlimplfru;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(true);

		// Inizializzo PageData
		PageData pd = new PageData();

		GeneralHelper generalHelper = new GeneralHelper(session);

		// Inizializzo GeneralData
		GeneralData gd = generalHelper.initGeneralData(request);

		// Parametri Protocol Properties relativi al tipo di operazione e al tipo di visualizzazione
		this.consoleOperationType = ConsoleOperationType.CHANGE;
		this.consoleInterfaceType = ProtocolPropertiesUtilities.getTipoInterfaccia(session); 

		// Parametri relativi al tipo operazione
		TipoOperazione tipoOp = TipoOperazione.CHANGE;
		List<ProtocolProperty> oldProtocolPropertyList = null;

		try {
			// prendo i dati hidden del pdold e li metto nel pd attuale
			PageData pdOld = ServletUtils.getPageDataFromSession(session);
			pd.setHidden(pdOld.getHidden());

			AccordiServizioParteSpecificaHelper apsHelper = new AccordiServizioParteSpecificaHelper(request, pd, session);
			this.editMode = apsHelper.getParameter(Costanti.DATA_ELEMENT_EDIT_MODE_NAME);
			this.protocolPropertiesSet = apsHelper.getParameter(ProtocolPropertiesCostanti.PARAMETRO_PP_SET);

			String idServizio = apsHelper.getParameter(AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_ID);
			int idServizioInt = Integer.parseInt(idServizio);
			String idServizioFruitore = request.getParameter(AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_MY_ID);// id della fruizione
			int idServizioFruitoreInt = Integer.parseInt(idServizioFruitore);

			// NOTA PARAMETRO_APS_MY_ID e' l'id della fruizoione, mentre PARAMETRO_APS_PROVIDER_FRUITORE e' l'id del soggetto fruitore 
			String idSoggettoFruitore = request.getParameter(AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_PROVIDER_FRUITORE); 
			//			String endpointtype = request.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_ENDPOINT_TYPE);
			String correlato = request.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_CUSTOM_CORRELATO);
			
			String myTipo = apsHelper.getParameter(AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_MY_TIPO);
			if(myTipo == null) myTipo = "";
			String myNome = apsHelper.getParameter(AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_MY_NOME);
			if(myNome == null) myNome = "";
			//			String endpointtype = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_ENDPOINT_TYPE);

			String endpointtype = apsHelper.readEndPointType();
			String tipoconn = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_TIPO_PERSONALIZZATO);
			String autenticazioneHttp = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_ENDPOINT_TYPE_ENABLE_HTTP);
			String user = null;
			String password = null;

			String connettoreDebug = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_DEBUG);

			// proxy
			String proxy_enabled = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_PROXY_ENABLED);
			String proxy_hostname = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_PROXY_HOSTNAME);
			String proxy_port = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_PROXY_PORT);
			String proxy_username = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_PROXY_USERNAME);
			String proxy_password = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_PROXY_PASSWORD);

			// opzioni avanzate
			String transfer_mode = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_OPZIONI_AVANZATE_TRANSFER_MODE);
			String transfer_mode_chunk_size = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_OPZIONI_AVANZATE_TRANSFER_CHUNK_SIZE);
			String redirect_mode = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_OPZIONI_AVANZATE_REDIRECT_MODE);
			String redirect_max_hop = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_OPZIONI_AVANZATE_REDIRECT_MAX_HOP);
			String opzioniAvanzate = ConnettoriHelper.getOpzioniAvanzate(request, transfer_mode, redirect_mode);

			// http
			String url = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_URL);
			if(TipiConnettore.HTTP.toString().equals(endpointtype)){
				user = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_AUTENTICAZIONE_USERNAME);
				password = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_AUTENTICAZIONE_PASSWORD);
			}

			// jms
			String nome = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_JMS_NOME_CODA);
			String tipo = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_JMS_TIPO_CODA);
			String initcont = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_JMS_INIT_CTX);
			String urlpgk = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_JMS_URL_PKG);
			String provurl = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_JMS_PROVIDER_URL);
			String connfact = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_JMS_CONNECTION_FACTORY);
			String sendas = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_JMS_TIPO_OGGETTO_JMS);
			if(TipiConnettore.JMS.toString().equals(endpointtype)){
				user = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_JMS_USERNAME);
				password = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_JMS_PASSWORD);
			}

			// https
			String httpsurl = url;
			String httpstipologia = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_SSL_TYPE );
			String httpshostverifyS = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_HOST_VERIFY);
			boolean httpshostverify = false;
			if (httpshostverifyS != null && httpshostverifyS.equals(Costanti.CHECK_BOX_ENABLED))
				httpshostverify = true;
			String httpspath = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_TRUST_STORE_LOCATION);
			String httpstipo = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_TRUST_STORE_TYPE);
			String httpspwd = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_TRUST_STORE_PASSWORD);
			String httpsalgoritmo = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_TRUST_MANAGEMENT_ALGORITM);
			String httpsstatoS = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_STATO);
			boolean httpsstato = false;
			if (httpsstatoS != null && httpsstatoS.equals(Costanti.CHECK_BOX_ENABLED))
				httpsstato = true;
			String httpskeystore = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_KEYSTORE_CLIENT_AUTH_MODE);
			String httpspwdprivatekeytrust = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_PASSWORD_PRIVATE_KEY_STORE);
			String httpspathkey = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_KEY_STORE_LOCATION);
			String httpstipokey = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_KEY_STORE_TYPE);
			String httpspwdkey = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_KEY_STORE_PASSWORD);
			String httpspwdprivatekey = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_PASSWORD_PRIVATE_KEY_KEYSTORE);
			String httpsalgoritmokey = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_KEY_MANAGEMENT_ALGORITM);
			if(TipiConnettore.HTTPS.toString().equals(endpointtype)){
				user = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_AUTENTICAZIONE_USERNAME);
				password = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_AUTENTICAZIONE_PASSWORD);
			}
			
			// file
			String requestOutputFileName = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_FILE_REQUEST_OUTPUT_FILE_NAME);
			String requestOutputFileNameHeaders = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_FILE_REQUEST_OUTPUT_FILE_NAME_HEADERS);
			String requestOutputParentDirCreateIfNotExists = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_FILE_REQUEST_OUTPUT_AUTO_CREATE_DIR);
			String requestOutputOverwriteIfExists = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_FILE_REQUEST_OUTPUT_OVERWRITE_FILE_NAME);
			String responseInputMode = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_FILE_RESPONSE_INPUT_MODE);
			String responseInputFileName = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_FILE_RESPONSE_INPUT_FILE_NAME);
			String responseInputFileNameHeaders = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_FILE_RESPONSE_INPUT_FILE_NAME_HEADERS);
			String responseInputDeleteAfterRead = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_FILE_RESPONSE_INPUT_FILE_NAME_DELETE_AFTER_READ);
			String responseInputWaitTime = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_FILE_RESPONSE_INPUT_WAIT_TIME);


			String profilo = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_PROFILO);
			String clientAuth = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_CLIENT_AUTH);
			String statoPackage = apsHelper.getParameter(ConnettoriCostanti.PARAMETRO_CONNETTORE_HTTPS_STATO_PACKAGE);

			String backToStato = apsHelper.getParameter(AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_RIPRISTINA_STATO);
			String actionConfirm = apsHelper.getParameter(Costanti.PARAMETRO_ACTION_CONFIRM);

			boolean validazioneDocumenti = true;
			String tmpValidazioneDocumenti = apsHelper.getParameter(AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_VALIDAZIONE_DOCUMENTI);
			if(ServletUtils.isEditModeInProgress(request)){
				// primo accesso alla servlet
				if(tmpValidazioneDocumenti!=null){
					if(Costanti.CHECK_BOX_ENABLED_TRUE.equalsIgnoreCase(tmpValidazioneDocumenti) || Costanti.CHECK_BOX_ENABLED.equalsIgnoreCase(tmpValidazioneDocumenti)){
						validazioneDocumenti = true;
					}
					else if("false".equalsIgnoreCase(tmpValidazioneDocumenti) || Costanti.CHECK_BOX_DISABLED.equalsIgnoreCase(tmpValidazioneDocumenti)){
						validazioneDocumenti = false;
					}
				}else{
					validazioneDocumenti = true;
				}
			}else{
				if(Costanti.CHECK_BOX_ENABLED_TRUE.equalsIgnoreCase(tmpValidazioneDocumenti) || Costanti.CHECK_BOX_ENABLED.equalsIgnoreCase(tmpValidazioneDocumenti)){
					validazioneDocumenti = true;
				}
				else{
					validazioneDocumenti = false;
				}
			}

			// Prendo il servizio
			AccordiServizioParteSpecificaCore apsCore = new AccordiServizioParteSpecificaCore();
			SoggettiCore soggettiCore = new SoggettiCore(apsCore);

			AccordoServizioParteSpecifica asps = apsCore.getAccordoServizioParteSpecifica(idServizioInt);
			String nomeservizio = asps.getNome();
			String tiposervizio = asps.getTipo();
			Integer versioneservizio = asps.getVersione();

			// se ho impostato nome e tipo del fruitore li utilizzo per ricostruire l'id del fruitore
			if(StringUtils.isNotBlank(myTipo) && StringUtils.isNotBlank(myNome)){
				long idSoggetto = soggettiCore.getIdSoggetto(myNome,myTipo);
				idServizioFruitoreInt = apsCore.getServizioFruitore(IDServizioFactory.getInstance().getIDServizioFromAccordo(asps), idSoggetto); 
			}
			
			// Prendo nome e tipo del fruitore dal db
			Fruitore servFru = apsCore.getServizioFruitore(idServizioFruitoreInt);
			myTipo = servFru.getTipo();
			myNome = servFru.getNome();

			Boolean isConnettoreCustomUltimaImmagineSalvata = servFru.getConnettore().getCustom();

			List<ExtendedConnettore> listExtendedConnettore = 
					ServletExtendedConnettoreUtils.getExtendedConnettore(servFru.getConnettore(), ConnettoreServletType.FRUIZIONE_ACCORDO_SERVIZIO_PARTE_SPECIFICA_CHANGE, apsCore, 
							request, session, (endpointtype==null), endpointtype); // uso endpointtype per capire se è la prima volta che entro

			// Prendo il soggetto erogatore del servizio
			String tipoSoggettoErogatore = asps.getTipoSoggettoErogatore();
			String nomeSoggettoErogatore = asps.getNomeSoggettoErogatore();
			String idSoggettoErogatoreDelServizio = apsHelper.getParameter(AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_ID_SOGGETTO_EROGATORE);
			if ((idSoggettoErogatoreDelServizio == null) || idSoggettoErogatoreDelServizio.equals("")) {
				PageData oldPD = ServletUtils.getPageDataFromSession(session);

				idSoggettoErogatoreDelServizio = oldPD.getHidden(AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_ID_SOGGETTO_EROGATORE);

				if (idSoggettoErogatoreDelServizio == null || idSoggettoErogatoreDelServizio.equals("")) {
					IDSoggetto idSE = new IDSoggetto(tipoSoggettoErogatore, nomeSoggettoErogatore);
					Soggetto SE = soggettiCore.getSoggettoRegistro(idSE);
					idSoggettoErogatoreDelServizio = "" + SE.getId();
				}
			}

			if( correlato == null){
				correlato = ((TipologiaServizio.CORRELATO.equals(asps.getTipologiaServizio()) ?
						AccordiServizioParteSpecificaCostanti.DEFAULT_VALUE_CORRELATO :
							AccordiServizioParteSpecificaCostanti.DEFAULT_VALUE_NORMALE));
			}

			// setto i dati come campi hidden nel pd per portarmeli dietro

			// Preparo il menu
			apsHelper.makeMenu();

			String tmpTitle = IDServizioFactory.getInstance().getUriFromAccordo(asps);

			String profiloSoggettoFruitore = null;
			Soggetto soggettoFruitore = null;
			if ((idSoggettoFruitore != null) && !idSoggettoFruitore.equals("")) {
				long idSoggettoFruitoreAsInt = Long.parseLong(idSoggettoFruitore);
				soggettoFruitore = soggettiCore.getSoggettoRegistro(idSoggettoFruitoreAsInt);
				profiloSoggettoFruitore = soggettoFruitore.getVersioneProtocollo();
			} 
			else {
				profiloSoggettoFruitore = servFru.getVersioneProtocollo();
				//				Soggetto soggetto = soggettiCore.getSoggettoRegistro(new IDSoggetto(servFru.getTipo(),servFru.getNome()));
				//				profiloSoggettoFruitore = soggetto.getVersioneProtocollo();
			}



			String profiloValue = profiloSoggettoFruitore;
			if(profilo!=null && !"".equals(profilo) && !"-".equals(profilo)){
				profiloValue = profilo;
			}

			String protocollo = apsCore.getProtocolloAssociatoTipoServizio(tiposervizio);
			List<String> versioniProtocollo = apsCore.getVersioniProtocollo(protocollo);
			//List<String> tipiSoggettiCompatibiliAccordo = soggettiCore.getTipiSoggettiGestitiProtocollo(protocollo);

			// Prendo la lista di soggetti (tranne quello del servizio)
			// e la metto in un array
//			List<Soggetto> soggList = soggettiCore.soggettiRegistroList("", new Search());
//			String[] soggettiList = null;
//			String[] soggettiListLabel = null;
//			List<String> soggettiListVector = new ArrayList<String>();
//			List<String> soggettiListLabelVector = new ArrayList<String>();
//			for (int i = 0; i < soggList.size(); i++) {
//				Soggetto fru = soggList.get(i);
//				if(tipiSoggettiCompatibiliAccordo.contains(fru.getTipo())){
//					soggettiListVector.add("" + fru.getId());
//					soggettiListLabelVector.add(fru.getTipo() + "/" + fru.getNome());
//				}
//			}
//			soggettiList = soggettiListVector.toArray(new String[1]);
//			soggettiListLabel = soggettiListLabelVector.toArray(new String[1]);
			// Non serve una vera lista. Basta avere una lista di un elemento con la fruizione in corso
			String[] soggettiList = new String [] { (idSoggettoFruitore+"") };
			String[] soggettiListLabel = new String [] { (soggettoFruitore.getTipo() + "/" + soggettoFruitore.getNome()) };

			// Versioni
			String[] versioniValues = new String[versioniProtocollo.size()+1];
			String[] versioniLabel = new String[versioniProtocollo.size()+1];
			versioniLabel[0] = "usa versione fruitore";
			versioniValues[0] = "-";
			for (int i = 0; i < versioniProtocollo.size(); i++) {
				String tmp = versioniProtocollo.get(i);
				versioniLabel[i+1] = tmp;
				versioniValues[i+1] = tmp;
			}

			//se passo dal link diretto di ripristino stato imposto il nuovo stato
			if(backToStato != null)
				statoPackage = backToStato;


			String nomefru = servFru.getNome();
			String tipofru = servFru.getTipo();
			IDSoggetto idSF = new IDSoggetto(tipofru, nomefru);
			Soggetto soggFru = soggettiCore.getSoggettoRegistro(idSF);
			idSoggettoFruitore = "" + soggFru.getId();
			if(statoPackage==null)
				statoPackage = servFru.getStatoPackage();
			String oldStatoPackage = servFru.getStatoPackage();	


			Connettore connettore = servFru.getConnettore();

			this.protocolFactory = ProtocolFactoryManager.getInstance().getProtocolFactoryByName(protocollo);
			this.consoleDynamicConfiguration =  this.protocolFactory.createDynamicConfigurationConsole();
			this.registryReader = soggettiCore.getRegistryReader(this.protocolFactory); 
			IDServizio idAps = apsHelper.getIDServizioFromValues(tiposervizio, nomeservizio, tipoSoggettoErogatore,nomeSoggettoErogatore, versioneservizio+"");
			IDFruizione idFruizione = new IDFruizione();
			idFruizione.setIdServizio(idAps);
			idFruizione.setIdFruitore(idSF);
			this.consoleConfiguration = this.consoleDynamicConfiguration.getDynamicConfigFruizioneAccordoServizioParteSpecifica(this.consoleOperationType, this.consoleInterfaceType, this.registryReader, idFruizione  );
			this.protocolProperties = apsHelper.estraiProtocolPropertiesDaRequest(this.consoleConfiguration, this.consoleOperationType);

			oldProtocolPropertyList = servFru.getProtocolPropertyList(); 

			if(this.protocolPropertiesSet == null){
				ProtocolPropertiesUtils.mergeProtocolProperties(this.protocolProperties, oldProtocolPropertyList, this.consoleOperationType);
			}

			Parameter pMyId = new Parameter(AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_MY_ID, idServizioFruitoreInt+"");
			Parameter pMyTipo = new Parameter(AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_MY_TIPO, myTipo);
			Parameter pMyNome = new Parameter(AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_MY_NOME, myNome);
			Parameter pIdSoggettoErogatore = new Parameter(AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_ID_SOGGETTO_EROGATORE, idSoggettoErogatoreDelServizio);
			Parameter pId = new Parameter(AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_ID, idServizio);
			Parameter urlChange = new Parameter("", AccordiServizioParteSpecificaCostanti.SERVLET_NAME_APS_FRUITORI_CHANGE, pMyId, pId, pIdSoggettoErogatore,pMyTipo,pMyNome);
			
			String fruitoreLabel = tipofru + "/" + nomefru;
			Properties propertiesProprietario = new Properties();
			propertiesProprietario.setProperty(ProtocolPropertiesCostanti.PARAMETRO_PP_ID_PROPRIETARIO, idServizioFruitoreInt+"");
			propertiesProprietario.setProperty(ProtocolPropertiesCostanti.PARAMETRO_PP_TIPO_PROPRIETARIO, ProtocolPropertiesCostanti.PARAMETRO_PP_TIPO_PROPRIETARIO_VALUE_FRUITORE);
			propertiesProprietario.setProperty(ProtocolPropertiesCostanti.PARAMETRO_PP_NOME_PROPRIETARIO, fruitoreLabel);
			propertiesProprietario.setProperty(ProtocolPropertiesCostanti.PARAMETRO_PP_URL_ORIGINALE_CHANGE, 
					URLEncoder.encode( urlChange.getValue() , "UTF-8"));
			propertiesProprietario.setProperty(ProtocolPropertiesCostanti.PARAMETRO_PP_PROTOCOLLO, protocollo);
			propertiesProprietario.setProperty(ProtocolPropertiesCostanti.PARAMETRO_PP_TIPO_ACCORDO, "");

			// Se idhid = null, devo visualizzare la pagina per la
			// modifica dati

			if (ServletUtils.isEditModeInProgress(this.editMode)) {
				// setto la barra del titolo
				List<Parameter> lstParm = new ArrayList<Parameter>();

				lstParm.add(new Parameter(AccordiServizioParteSpecificaCostanti.LABEL_APS, null));
				lstParm.add(new Parameter(Costanti.PAGE_DATA_TITLE_LABEL_ELENCO, AccordiServizioParteSpecificaCostanti.SERVLET_NAME_APS_LIST));
				lstParm.add(new Parameter(AccordiServizioParteSpecificaCostanti.LABEL_APS_FUITORI_DI  + tmpTitle, 
						AccordiServizioParteSpecificaCostanti.SERVLET_NAME_APS_FRUITORI_LIST ,
						new Parameter( AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_ID, ""+ idServizio),
						new Parameter( AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_ID_SOGGETTO_EROGATORE, ""+ idSoggettoErogatoreDelServizio)
						));
				lstParm.add(new Parameter(fruitoreLabel, null));

				// setto la barra del titolo
				ServletUtils.setPageDataTitle(pd, lstParm );


				Map<String, String> props = connettore.getProperties();

				// Profilo
				if ((profilo==null || "".equals(profilo)) &&  servFru.getVersioneProtocollo() != null)
					profilo = servFru.getVersioneProtocollo();

				if ((clientAuth==null || "".equals(clientAuth))){
					if(servFru.getClientAuth() != null){
						if(servFru.getClientAuth()!=null){
							clientAuth = servFru.getClientAuth().toString();
						}
					}else
						clientAuth = ConnettoriCostanti.DEFAULT_CONNETTORE_HTTPS_KEYSTORE_CLIENT_AUTH_MODE_DEFAULT;
				}

				if (endpointtype == null) {
					if ((connettore.getCustom()!=null && connettore.getCustom()) && 
							!connettore.getTipo().equals(CostantiDB.CONNETTORE_TIPO_HTTPS) && 
							!connettore.getTipo().equals(CostantiDB.CONNETTORE_TIPO_FILE)) {
						endpointtype = ConnettoriCostanti.DEFAULT_CONNETTORE_TYPE_CUSTOM;
						tipoconn = connettore.getTipo();
					} else
						endpointtype = connettore.getTipo();
				}

				if(connettoreDebug==null && props!=null){
					String v = props.get(CostantiDB.CONNETTORE_DEBUG);
					if(v!=null){
						if("true".equals(v)){
							connettoreDebug = Costanti.CHECK_BOX_ENABLED;
						}
						else{
							connettoreDebug = Costanti.CHECK_BOX_DISABLED;
						}
					}
				}

				if(proxy_enabled==null && props!=null){
					String v = props.get(CostantiDB.CONNETTORE_PROXY_TYPE);
					if(v!=null && !"".equals(v)){
						proxy_enabled = Costanti.CHECK_BOX_ENABLED_TRUE;

						// raccolgo anche altre proprietà
						v = props.get(CostantiDB.CONNETTORE_PROXY_HOSTNAME);
						if(v!=null && !"".equals(v)){
							proxy_hostname = v.trim();
						}
						v = props.get(CostantiDB.CONNETTORE_PROXY_PORT);
						if(v!=null && !"".equals(v)){
							proxy_port = v.trim();
						}
						v = props.get(CostantiDB.CONNETTORE_PROXY_USERNAME);
						if(v!=null && !"".equals(v)){
							proxy_username = v.trim();
						}
						v = props.get(CostantiDB.CONNETTORE_PROXY_PASSWORD);
						if(v!=null && !"".equals(v)){
							proxy_password = v.trim();
						}
					}
				}

				if(transfer_mode==null && props!=null){
					String v = props.get(CostantiDB.CONNETTORE_HTTP_DATA_TRANSFER_MODE);
					if(v!=null && !"".equals(v)){

						transfer_mode = v.trim();

						if(TransferLengthModes.TRANSFER_ENCODING_CHUNKED.getNome().equals(transfer_mode)){
							// raccolgo anche altra proprietà correlata
							v = props.get(CostantiDB.CONNETTORE_HTTP_DATA_TRANSFER_MODE_CHUNK_SIZE);
							if(v!=null && !"".equals(v)){
								transfer_mode_chunk_size = v.trim();
							}
						}

					}
				}

				if(redirect_mode==null && props!=null){
					String v = props.get(CostantiDB.CONNETTORE_HTTP_REDIRECT_FOLLOW);
					if(v!=null && !"".equals(v)){

						if("true".equalsIgnoreCase(v.trim()) || CostantiConfigurazione.ABILITATO.getValue().equalsIgnoreCase(v.trim())){
							redirect_mode = CostantiConfigurazione.ABILITATO.getValue();
						}
						else{
							redirect_mode = CostantiConfigurazione.DISABILITATO.getValue();
						}					

						if(CostantiConfigurazione.ABILITATO.getValue().equals(redirect_mode)){
							// raccolgo anche altra proprietà correlata
							v = props.get(CostantiDB.CONNETTORE_HTTP_REDIRECT_MAX_HOP);
							if(v!=null && !"".equals(v)){
								redirect_max_hop = v.trim();
							}
						}

					}
				}

				opzioniAvanzate = ConnettoriHelper.getOpzioniAvanzate(request, transfer_mode, redirect_mode);

				if (url == null) {
					url = props.get(CostantiDB.CONNETTORE_HTTP_LOCATION);
				}
				if (nome == null) {
					nome = props.get(CostantiDB.CONNETTORE_JMS_NOME);
					tipo = props.get(CostantiDB.CONNETTORE_JMS_TIPO);
					user = props.get(CostantiDB.CONNETTORE_USER);
					password = props.get(CostantiDB.CONNETTORE_PWD);
					initcont = props.get(CostantiDB.CONNETTORE_JMS_CONTEXT_JAVA_NAMING_FACTORY_INITIAL);
					urlpgk = props.get(CostantiDB.CONNETTORE_JMS_CONTEXT_JAVA_NAMING_FACTORY_URL_PKG);
					provurl = props.get(CostantiDB.CONNETTORE_JMS_CONTEXT_JAVA_NAMING_PROVIDER_URL);
					connfact = props.get(CostantiDB.CONNETTORE_JMS_CONNECTION_FACTORY);
					sendas = props.get(CostantiDB.CONNETTORE_JMS_SEND_AS);
				}

				autenticazioneHttp = apsHelper.getAutenticazioneHttp(autenticazioneHttp, endpointtype, user);

				if (httpstipologia == null) {
					httpsurl = props.get(CostantiDB.CONNETTORE_HTTPS_LOCATION);
					httpstipologia = props.get(CostantiDB.CONNETTORE_HTTPS_SSL_TYPE);
					httpshostverifyS = props.get(CostantiDB.CONNETTORE_HTTPS_HOSTNAME_VERIFIER);
					if(httpshostverifyS!=null){
						httpshostverify = Boolean.valueOf(httpshostverifyS);
					}
					httpspath = props.get(CostantiDB.CONNETTORE_HTTPS_TRUST_STORE_LOCATION);
					httpstipo = props.get(CostantiDB.CONNETTORE_HTTPS_TRUST_STORE_TYPE);
					httpspwd = props.get(CostantiDB.CONNETTORE_HTTPS_TRUST_STORE_PASSWORD);
					httpsalgoritmo = props.get(CostantiDB.CONNETTORE_HTTPS_TRUST_MANAGEMENT_ALGORITM);
					httpspwdprivatekeytrust = props.get(CostantiDB.CONNETTORE_HTTPS_KEY_PASSWORD);
					httpspathkey = props.get(CostantiDB.CONNETTORE_HTTPS_KEY_STORE_LOCATION);
					httpstipokey = props.get(CostantiDB.CONNETTORE_HTTPS_KEY_STORE_TYPE);
					httpspwdkey = props.get(CostantiDB.CONNETTORE_HTTPS_KEY_STORE_PASSWORD);
					httpspwdprivatekey = props.get(CostantiDB.CONNETTORE_HTTPS_KEY_PASSWORD);
					httpsalgoritmokey = props.get(CostantiDB.CONNETTORE_HTTPS_KEY_MANAGEMENT_ALGORITM);
					if (httpspathkey == null) {
						httpsstato = false;
						httpskeystore = ConnettoriCostanti.DEFAULT_CONNETTORE_HTTPS_KEYSTORE_CLIENT_AUTH_MODE_DEFAULT;
					} else {
						httpsstato = true;
						if (httpspathkey.equals(httpspath) &&
								httpstipokey.equals(httpstipo) &&
								httpspwdkey.equals(httpspwd) )
							httpskeystore = ConnettoriCostanti.DEFAULT_CONNETTORE_HTTPS_KEYSTORE_CLIENT_AUTH_MODE_DEFAULT;
						else
							httpskeystore = ConnettoriCostanti.DEFAULT_CONNETTORE_HTTPS_KEYSTORE_CLIENT_AUTH_MODE_RIDEFINISCI;
					}
				}

				// default
				if(httpsalgoritmo==null || "".equals(httpsalgoritmo)){
					httpsalgoritmo = TrustManagerFactory.getDefaultAlgorithm();
				}
				if(httpsalgoritmokey==null || "".equals(httpsalgoritmokey)){
					httpsalgoritmokey = KeyManagerFactory.getDefaultAlgorithm();
				}
				if(httpstipologia==null || "".equals(httpstipologia)){
					httpstipologia = ConnettoriCostanti.DEFAULT_CONNETTORE_HTTPS_TYPE;
				}
				if(httpshostverifyS==null || "".equals(httpshostverifyS)){
					httpshostverifyS = Costanti.CHECK_BOX_ENABLED_TRUE;
					httpshostverify = true;
				}
				
				// file
				if(responseInputMode==null && props!=null){
					
					requestOutputFileName = props.get(CostantiDB.CONNETTORE_FILE_REQUEST_OUTPUT_FILE);	
					requestOutputFileNameHeaders = props.get(CostantiDB.CONNETTORE_FILE_REQUEST_OUTPUT_FILE_HEADERS);	
					String v = props.get(CostantiDB.CONNETTORE_FILE_REQUEST_OUTPUT_AUTO_CREATE_DIR);
					if(v!=null && !"".equals(v)){
						if("true".equalsIgnoreCase(v) || CostantiConfigurazione.ABILITATO.getValue().equalsIgnoreCase(v) ){
							requestOutputParentDirCreateIfNotExists = Costanti.CHECK_BOX_ENABLED_TRUE;
						}
					}					
					v = props.get(CostantiDB.CONNETTORE_FILE_REQUEST_OUTPUT_OVERWRITE_FILE);
					if(v!=null && !"".equals(v)){
						if("true".equalsIgnoreCase(v) || CostantiConfigurazione.ABILITATO.getValue().equalsIgnoreCase(v) ){
							requestOutputOverwriteIfExists = Costanti.CHECK_BOX_ENABLED_TRUE;
						}
					}	
					
					v = props.get(CostantiDB.CONNETTORE_FILE_RESPONSE_INPUT_MODE);
					if(v!=null && !"".equals(v)){
						if("true".equalsIgnoreCase(v) || CostantiConfigurazione.ABILITATO.getValue().equalsIgnoreCase(v) ){
							responseInputMode = CostantiConfigurazione.ABILITATO.getValue();
						}
					}
					if(CostantiConfigurazione.ABILITATO.getValue().equals(responseInputMode)){						
						responseInputFileName = props.get(CostantiDB.CONNETTORE_FILE_RESPONSE_INPUT_FILE);
						responseInputFileNameHeaders = props.get(CostantiDB.CONNETTORE_FILE_RESPONSE_INPUT_FILE_HEADERS);
						v = props.get(CostantiDB.CONNETTORE_FILE_RESPONSE_INPUT_FILE_DELETE_AFTER_READ);
						if(v!=null && !"".equals(v)){
							if("true".equalsIgnoreCase(v) || CostantiConfigurazione.ABILITATO.getValue().equalsIgnoreCase(v) ){
								responseInputDeleteAfterRead = Costanti.CHECK_BOX_ENABLED_TRUE;
							}
						}						
						responseInputWaitTime = props.get(CostantiDB.CONNETTORE_FILE_RESPONSE_INPUT_WAIT_TIME);						
					}
					
				}

				if(this.wsdlimpler == null){
					this.wsdlimpler = new BinaryParameter();
					this.wsdlimpler.setValue(servFru.getByteWsdlImplementativoErogatore());
				}

				if(this.wsdlimplfru == null){
					this.wsdlimplfru = new BinaryParameter();
					this.wsdlimplfru.setValue(servFru.getByteWsdlImplementativoFruitore());
				}

				if(backToStato == null){
					// preparo i campi
					Vector<DataElement> dati = new Vector<DataElement>();
					dati.addElement(ServletUtils.getDataElementForEditModeFinished());

					// update della configurazione 
					this.consoleDynamicConfiguration.updateDynamicConfigFruizioneAccordoServizioParteSpecifica(this.consoleConfiguration, this.consoleOperationType, this.consoleInterfaceType, this.protocolProperties, this.registryReader, idFruizione);

					dati = apsHelper.addHiddenFieldsToDati(tipoOp, idServizio, null, null, dati);

					dati = apsHelper.addServiziFruitoriToDati(dati, idSoggettoFruitore, this.wsdlimpler, this.wsdlimplfru, soggettiList, soggettiListLabel, idServizio,
							idServizioFruitore,tipoOp, idSoggettoErogatoreDelServizio, "", "", nomeservizio, tiposervizio, versioneservizio, correlato,
							statoPackage,oldStatoPackage,asps.getStatoPackage(),null,validazioneDocumenti,
							null,null,null,null,null,null,null,null,null,null);

					dati = apsHelper.addFruitoreToDati(tipoOp, versioniLabel, versioniValues, profilo, clientAuth, dati, 
							oldStatoPackage, idServizio, idServizioFruitore, idSoggettoErogatoreDelServizio,
							nomeservizio, tiposervizio, versioneservizio, idSoggettoFruitore,
							asps, servFru);

					if (!InterfaceType.STANDARD.equals(ServletUtils.getUserFromSession(session).getInterfaceType())) {
						dati = apsHelper.addEndPointToDati(dati, connettoreDebug, endpointtype, autenticazioneHttp, null, 
								url, nome,
								tipo, user, password, initcont, urlpgk, provurl,
								connfact, sendas, AccordiServizioParteSpecificaCostanti.OBJECT_NAME_APS_FRUITORI,tipoOp, httpsurl,
								httpstipologia, httpshostverify, httpspath, httpstipo,
								httpspwd, httpsalgoritmo, httpsstato, httpskeystore,
								httpspwdprivatekeytrust, httpspathkey, httpstipokey,
								httpspwdkey, httpspwdprivatekey, httpsalgoritmokey,
								tipoconn, AccordiServizioParteSpecificaCostanti.SERVLET_NAME_APS_FRUITORI_CHANGE, idServizio, idServizioFruitore,
								idSoggettoErogatoreDelServizio, null, null, null, null,
								oldStatoPackage, true,
								isConnettoreCustomUltimaImmagineSalvata, 
								proxy_enabled, proxy_hostname, proxy_port, proxy_username, proxy_password,
								opzioniAvanzate, transfer_mode, transfer_mode_chunk_size, redirect_mode, redirect_max_hop,
								requestOutputFileName,requestOutputFileNameHeaders,requestOutputParentDirCreateIfNotExists,requestOutputOverwriteIfExists,
								responseInputMode, responseInputFileName, responseInputFileNameHeaders, responseInputDeleteAfterRead, responseInputWaitTime,
								listExtendedConnettore);
					}else{
						//spostato nell'helper
					}

					// aggiunta campi custom
					dati = apsHelper.addProtocolPropertiesToDati(dati, this.consoleConfiguration,this.consoleOperationType, this.consoleInterfaceType, this.protocolProperties,oldProtocolPropertyList,propertiesProprietario);

					pd.setDati(dati);

					if(apsCore.isShowGestioneWorkflowStatoDocumenti() && StatiAccordo.finale.toString().equals(servFru.getStatoPackage())){
						pd.setMode(Costanti.DATA_ELEMENT_EDIT_MODE_DISABLE_NAME);
					}

					ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

					return ServletUtils.getStrutsForwardEditModeInProgress(mapping, AccordiServizioParteSpecificaCostanti.OBJECT_NAME_APS_FRUITORI,
							ForwardParams.CHANGE());
				}
			}

			// Controlli sui campi immessi
			boolean isOk = apsHelper.serviziFruitoriCheckData(tipoOp,
					soggettiList, idServizio, "", "", null, "", "", idSoggettoFruitore,
					endpointtype, url, nome, tipo, user, password, initcont,
					urlpgk, provurl, connfact, sendas, this.wsdlimpler, this.wsdlimplfru,
					idServizioFruitore, profilo, httpsurl,
					httpstipologia, httpshostverify, httpspath, httpstipo,
					httpspwd, httpsalgoritmo, httpsstato, httpskeystore,
					httpspwdprivatekeytrust, httpspathkey, httpstipokey,
					httpspwdkey, httpspwdprivatekey, httpsalgoritmokey,
					tipoconn,clientAuth,validazioneDocumenti,backToStato,autenticazioneHttp,
					proxy_enabled, proxy_hostname, proxy_port, proxy_username, proxy_password,
					opzioniAvanzate, transfer_mode, transfer_mode_chunk_size, redirect_mode, redirect_max_hop,
					requestOutputFileName,requestOutputFileNameHeaders,requestOutputParentDirCreateIfNotExists,requestOutputOverwriteIfExists,
					responseInputMode, responseInputFileName, responseInputFileNameHeaders, responseInputDeleteAfterRead, responseInputWaitTime,
					null,null,null,null,null,
					null, null, null,null,
					listExtendedConnettore);

			// Validazione base dei parametri custom 
			if(isOk){
				try{
					apsHelper.validaProtocolProperties(this.consoleConfiguration, this.consoleOperationType, this.consoleInterfaceType, this.protocolProperties);
				}catch(ProtocolException e){
					pd.setMessage(e.getMessage());
					isOk = false;
				}
			}

			// Valido i parametri custom se ho gia' passato tutta la validazione prevista
			if(isOk){
				try{
					//validazione campi dinamici
					this.consoleDynamicConfiguration.validateDynamicConfigFruizioneAccordoServizioParteSpecifica(this.consoleConfiguration, this.consoleOperationType, this.protocolProperties, this.registryReader, idFruizione);
				}catch(ProtocolException e){
					pd.setMessage(e.getMessage());
					isOk = false;
				}
			}

			if (!isOk) {
				// setto la barra del titolo
				List<Parameter> lstParm = new ArrayList<Parameter>();

				lstParm.add(new Parameter(AccordiServizioParteSpecificaCostanti.LABEL_APS, null));
				lstParm.add(new Parameter(Costanti.PAGE_DATA_TITLE_LABEL_ELENCO, AccordiServizioParteSpecificaCostanti.SERVLET_NAME_APS_LIST));
				lstParm.add(new Parameter(AccordiServizioParteSpecificaCostanti.LABEL_APS_FUITORI_DI  + tmpTitle, 
						AccordiServizioParteSpecificaCostanti.SERVLET_NAME_APS_FRUITORI_LIST ,
						new Parameter( AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_ID, ""+ idServizio),
						new Parameter( AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_ID_SOGGETTO_EROGATORE, ""+ idSoggettoErogatoreDelServizio)
						));
				lstParm.add(new Parameter(fruitoreLabel, null));

				// setto la barra del titolo
				ServletUtils.setPageDataTitle(pd, lstParm );

				// preparo i campi
				Vector<DataElement> dati = new Vector<DataElement>();

				dati.addElement(ServletUtils.getDataElementForEditModeFinished());

				// update della configurazione 
				this.consoleDynamicConfiguration.updateDynamicConfigFruizioneAccordoServizioParteSpecifica(this.consoleConfiguration, this.consoleOperationType, this.consoleInterfaceType, this.protocolProperties, this.registryReader, idFruizione);

				dati = apsHelper.addHiddenFieldsToDati(tipoOp, idServizio, null, null, dati);

				dati = apsHelper.addServiziFruitoriToDati(dati, idSoggettoFruitore, this.wsdlimpler, this.wsdlimplfru, soggettiList, soggettiListLabel, idServizio,
						idServizioFruitore, tipoOp, idSoggettoErogatoreDelServizio, "", "", nomeservizio, tiposervizio, versioneservizio,  correlato,
						statoPackage,oldStatoPackage,asps.getStatoPackage(),null,validazioneDocumenti,
						null,null,null,null,null,null,null,null,null,null);

				dati = apsHelper.addFruitoreToDati(tipoOp, versioniLabel, versioniValues, profiloValue, clientAuth, dati, 
						oldStatoPackage, idServizio, idServizioFruitore, idSoggettoErogatoreDelServizio, nomeservizio, tiposervizio, versioneservizio, idSoggettoFruitore,
						asps, servFru);

				if (!InterfaceType.STANDARD.equals(ServletUtils.getUserFromSession(session).getInterfaceType())) {
					dati = apsHelper.addEndPointToDati(dati, connettoreDebug, endpointtype, autenticazioneHttp, null, 
							url, nome,
							tipo, user, password, initcont, urlpgk, provurl,
							connfact, sendas, AccordiServizioParteSpecificaCostanti.OBJECT_NAME_APS_FRUITORI,tipoOp, httpsurl,
							httpstipologia, httpshostverify, httpspath, httpstipo,
							httpspwd, httpsalgoritmo, httpsstato, httpskeystore,
							httpspwdprivatekeytrust, httpspathkey, httpstipokey,
							httpspwdkey, httpspwdprivatekey, httpsalgoritmokey,
							tipoconn, AccordiServizioParteSpecificaCostanti.SERVLET_NAME_APS_FRUITORI_CHANGE, idServizio, idServizioFruitore,
							idSoggettoErogatoreDelServizio, null, null, null, null,
							oldStatoPackage, true,
							isConnettoreCustomUltimaImmagineSalvata, 
							proxy_enabled, proxy_hostname, proxy_port, proxy_username, proxy_password,
							opzioniAvanzate, transfer_mode, transfer_mode_chunk_size, redirect_mode, redirect_max_hop,
							requestOutputFileName,requestOutputFileNameHeaders,requestOutputParentDirCreateIfNotExists,requestOutputOverwriteIfExists,
							responseInputMode, responseInputFileName, responseInputFileNameHeaders, responseInputDeleteAfterRead, responseInputWaitTime,
							listExtendedConnettore);
				}else{
					//spostato nell'helper
				}

				// aggiunta campi custom
				dati = apsHelper.addProtocolPropertiesToDati(dati, this.consoleConfiguration,this.consoleOperationType, this.consoleInterfaceType, this.protocolProperties,oldProtocolPropertyList,propertiesProprietario);

				pd.setDati(dati);

				ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

				return ServletUtils.getStrutsForwardEditModeCheckError(mapping, AccordiServizioParteSpecificaCostanti.OBJECT_NAME_APS_FRUITORI, 
						ForwardParams.CHANGE());
			}

			if(actionConfirm == null){
				if(backToStato != null){

					// setto la barra del titolo
					List<Parameter> lstParm = new ArrayList<Parameter>();

					lstParm.add(new Parameter(AccordiServizioParteSpecificaCostanti.LABEL_APS, null));
					lstParm.add(new Parameter(Costanti.PAGE_DATA_TITLE_LABEL_ELENCO, AccordiServizioParteSpecificaCostanti.SERVLET_NAME_APS_LIST));
					lstParm.add(new Parameter(AccordiServizioParteSpecificaCostanti.LABEL_APS_FUITORI_DI  + tmpTitle, 
							AccordiServizioParteSpecificaCostanti.SERVLET_NAME_APS_FRUITORI_LIST ,
							new Parameter( AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_ID, ""+ idServizio),
							new Parameter( AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_ID_SOGGETTO_EROGATORE, ""+ idSoggettoErogatoreDelServizio)
							));
					lstParm.add(new Parameter(fruitoreLabel, null));

					// setto la barra del titolo
					ServletUtils.setPageDataTitle(pd, lstParm );

					// preparo i campi
					Vector<DataElement> dati = new Vector<DataElement>();

					dati.addElement(ServletUtils.getDataElementForEditModeFinished());

					// update della configurazione 
					this.consoleDynamicConfiguration.updateDynamicConfigFruizioneAccordoServizioParteSpecifica(this.consoleConfiguration, this.consoleOperationType, this.consoleInterfaceType, this.protocolProperties, this.registryReader, idFruizione);

					dati = apsHelper.addHiddenFieldsToDati(tipoOp, idServizio, null, null, dati);

					dati = apsHelper.addServiziFruitoriToDatiAsHidden(dati, idSoggettoFruitore, "", "", soggettiList, soggettiListLabel, idServizio,
							idServizioFruitore, tipoOp, idSoggettoErogatoreDelServizio, "", "", nomeservizio, tiposervizio,  correlato,statoPackage,oldStatoPackage,asps.getStatoPackage(),null,validazioneDocumenti);

					dati = apsHelper.addFruitoreToDatiAsHidden(tipoOp, versioniLabel, versioniValues, profiloValue, clientAuth, dati, 
							oldStatoPackage, idServizio, idServizioFruitore, idSoggettoErogatoreDelServizio, nomeservizio, tiposervizio, idSoggettoFruitore);

					if (!InterfaceType.STANDARD.equals(ServletUtils.getUserFromSession(session).getInterfaceType())) {
						dati = apsHelper.addEndPointToDatiAsHidden(dati, endpointtype, url, nome,
								tipo, user, password, initcont, urlpgk, provurl,
								connfact, sendas, AccordiServizioParteSpecificaCostanti.OBJECT_NAME_APS_FRUITORI,tipoOp, httpsurl,
								httpstipologia, httpshostverify, httpspath, httpstipo,
								httpspwd, httpsalgoritmo, httpsstato, httpskeystore,
								httpspwdprivatekeytrust, httpspathkey, httpstipokey,
								httpspwdkey, httpspwdprivatekey, httpsalgoritmokey,
								tipoconn, AccordiServizioParteSpecificaCostanti.SERVLET_NAME_APS_FRUITORI_CHANGE, idServizio, idServizioFruitore,
								idSoggettoErogatoreDelServizio, null, null, null, null,
								oldStatoPackage,
								requestOutputFileName,requestOutputFileNameHeaders,requestOutputParentDirCreateIfNotExists,requestOutputOverwriteIfExists,
								responseInputMode, responseInputFileName, responseInputFileNameHeaders, responseInputDeleteAfterRead, responseInputWaitTime
								);
					}else{
						//spostato nell'helper
					}

					// aggiunta campi custom
					dati = apsHelper.addProtocolPropertiesToDati(dati, this.consoleConfiguration,this.consoleOperationType, this.consoleInterfaceType, this.protocolProperties,oldProtocolPropertyList,propertiesProprietario);

					String msg = "&Egrave; stato richiesto di ripristinare lo stato dell soggetto fruitore [{0}] in operativo. Tale operazione permetter&agrave; successive modifiche all''accordo. Vuoi procedere?";

					pd.setMessage(MessageFormat.format(msg, fruitoreLabel));

					pd.setDati(dati);

					String[][] bottoni = { 
							{ Costanti.LABEL_MONITOR_BUTTON_ANNULLA, 
								Costanti.LABEL_MONITOR_BUTTON_ANNULLA_CONFERMA_PREFIX +
								Costanti.LABEL_MONITOR_BUTTON_ANNULLA_CONFERMA_SUFFIX

							},
							{ Costanti.LABEL_MONITOR_BUTTON_OK,
								Costanti.LABEL_MONITOR_BUTTON_ESEGUI_OPERAZIONE_CONFERMA_PREFIX +
								Costanti.LABEL_MONITOR_BUTTON_ESEGUI_OPERAZIONE_CONFERMA_SUFFIX }};

					pd.setBottoni(bottoni );

					ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

					return ServletUtils.getStrutsForwardEditModeConfirm(mapping, AccordiServizioParteSpecificaCostanti.OBJECT_NAME_APS_FRUITORI, 
							ForwardParams.CHANGE());

				}
			}

			// Modifico i dati del fruitore nel db
			Connettore connettoreNew = null;
			if (!InterfaceType.STANDARD.equals(ServletUtils.getUserFromSession(session).getInterfaceType())) {
				connettoreNew = new Connettore();
				connettoreNew.setNome("CNT_SF_" + fruitoreLabel + "_" + tipoSoggettoErogatore + "/" + nomeSoggettoErogatore + "_" + tiposervizio + "/" + nomeservizio);
				connettoreNew.setId(connettore.getId());

				String oldConnT = connettore.getTipo();
				if ((connettore.getCustom()!=null && connettore.getCustom()) && 
						!connettore.getTipo().equals(CostantiDB.CONNETTORE_TIPO_HTTPS) && 
						!connettore.getTipo().equals(CostantiDB.CONNETTORE_TIPO_FILE)){
					// mantengo vecchie proprieta connettore custom
					for(int i=0; i<connettore.sizePropertyList(); i++){
						connettoreNew.addProperty(connettore.getProperty(i));
					}
					oldConnT = ConnettoriCostanti.DEFAULT_CONNETTORE_TYPE_CUSTOM;
				}
				apsHelper.fillConnettore(connettoreNew, connettoreDebug, endpointtype, oldConnT, tipoconn, url,
						nome, tipo, user, password,
						initcont, urlpgk, provurl, connfact,
						sendas, httpsurl, httpstipologia,
						httpshostverify, httpspath, httpstipo,
						httpspwd, httpsalgoritmo, httpsstato,
						httpskeystore, httpspwdprivatekeytrust,
						httpspathkey, httpstipokey,
						httpspwdkey, httpspwdprivatekey,
						httpsalgoritmokey,
						proxy_enabled, proxy_hostname, proxy_port, proxy_username, proxy_password,
						opzioniAvanzate, transfer_mode, transfer_mode_chunk_size, redirect_mode, redirect_max_hop,
						requestOutputFileName,requestOutputFileNameHeaders,requestOutputParentDirCreateIfNotExists,requestOutputOverwriteIfExists,
						responseInputMode, responseInputFileName, responseInputFileNameHeaders, responseInputDeleteAfterRead, responseInputWaitTime,
						listExtendedConnettore);
			}
			else{
				connettoreNew = connettore;
			}

			Fruitore fruitore = new Fruitore();
			fruitore.setId(new Long(idSoggettoFruitore));
			fruitore.setConnettore(connettoreNew);
			fruitore.setTipo(tipofru);
			fruitore.setNome(nomefru);
			fruitore.setByteWsdlImplementativoErogatore(servFru.getByteWsdlImplementativoErogatore());
			fruitore.setByteWsdlImplementativoFruitore(servFru.getByteWsdlImplementativoFruitore());
			if ("-".equals(profilo) == false)
				fruitore.setVersioneProtocollo(profilo);
			else
				fruitore.setVersioneProtocollo(null);
			if(ConnettoriCostanti.DEFAULT_CONNETTORE_HTTPS_KEYSTORE_CLIENT_AUTH_MODE_DEFAULT.equals(clientAuth))
				fruitore.setClientAuth(null);
			else
				fruitore.setClientAuth(StatoFunzionalita.toEnumConstant(clientAuth));
			// Prendo i dati del soggetto erogatore del servizio
			Soggetto SE = soggettiCore.getSoggettoRegistro(Integer.parseInt(idSoggettoErogatoreDelServizio));
			tipoSoggettoErogatore = SE.getTipo();
			nomeSoggettoErogatore = SE.getNome();

			AccordoServizioParteSpecifica serviziosp = apsCore.getAccordoServizioParteSpecifica(idServizioInt);

			// Elimino il vecchio fruitore ed aggiungo il nuovo
			for (int i = 0; i < serviziosp.sizeFruitoreList(); i++) {
				Fruitore tmpFru = serviziosp.getFruitore(i);
				if (tmpFru.getId().longValue() == servFru.getId().longValue()) {
					serviziosp.removeFruitore(i);
					break;
				}
			}


			// stato
			fruitore.setStatoPackage(statoPackage);

			// Check stato
			if(apsCore.isShowGestioneWorkflowStatoDocumenti()){

				try{
					apsCore.validaStatoFruitoreAccordoServizioParteSpecifica(fruitore, serviziosp);
				}catch(ValidazioneStatoPackageException validazioneException){

					// Setto messaggio di errore
					pd.setMessage(validazioneException.toString());

					List<Parameter> lstParm = new ArrayList<Parameter>();

					lstParm.add(new Parameter(AccordiServizioParteSpecificaCostanti.LABEL_APS, null));
					lstParm.add(new Parameter(Costanti.PAGE_DATA_TITLE_LABEL_ELENCO, AccordiServizioParteSpecificaCostanti.SERVLET_NAME_APS_LIST));
					lstParm.add(new Parameter(AccordiServizioParteSpecificaCostanti.LABEL_APS_FUITORI_DI  + tmpTitle, 
							AccordiServizioParteSpecificaCostanti.SERVLET_NAME_APS_FRUITORI_LIST ,
							new Parameter( AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_ID, ""+ idServizio),
							new Parameter( AccordiServizioParteSpecificaCostanti.PARAMETRO_APS_ID_SOGGETTO_EROGATORE, ""+ idSoggettoErogatoreDelServizio)
							));
					lstParm.add(new Parameter(fruitoreLabel, null));

					// setto la barra del titolo
					ServletUtils.setPageDataTitle(pd, lstParm );

					// preparo i campi
					Vector<DataElement> dati = new Vector<DataElement>();

					dati.addElement(ServletUtils.getDataElementForEditModeFinished());

					// update della configurazione 
					this.consoleDynamicConfiguration.updateDynamicConfigFruizioneAccordoServizioParteSpecifica(this.consoleConfiguration, this.consoleOperationType, this.consoleInterfaceType, this.protocolProperties, this.registryReader, idFruizione);

					dati = apsHelper.addHiddenFieldsToDati(tipoOp, idServizio, null, null, dati);

					dati = apsHelper.addServiziFruitoriToDati(dati, idSoggettoFruitore, this.wsdlimpler, this.wsdlimplfru, soggettiList, soggettiListLabel, idServizio, 
							idServizioFruitore, tipoOp, idSoggettoErogatoreDelServizio, "", "", nomeservizio, tiposervizio, versioneservizio,  
							correlato,statoPackage,oldStatoPackage,asps.getStatoPackage(),null,validazioneDocumenti,
							null,null,null,null,null,null,null,null,null,null);

					dati = apsHelper.addFruitoreToDati(tipoOp, versioniLabel, versioniValues, profiloValue, clientAuth, dati, 
							oldStatoPackage, idServizio, idServizioFruitore, idSoggettoErogatoreDelServizio, nomeservizio, tiposervizio, versioneservizio, idSoggettoFruitore,
							asps, servFru);

					if (!InterfaceType.STANDARD.equals(ServletUtils.getUserFromSession(session).getInterfaceType())) {
						dati = apsHelper.addEndPointToDati(dati, connettoreDebug, endpointtype, autenticazioneHttp, null, 
								url,
								nome, tipo, user, password, initcont, urlpgk,
								provurl, connfact, sendas,
								AccordiServizioParteSpecificaCostanti.OBJECT_NAME_APS_FRUITORI,tipoOp, httpsurl,
								httpstipologia, httpshostverify, httpspath,
								httpstipo, httpspwd, httpsalgoritmo, httpsstato,
								httpskeystore, httpspwdprivatekeytrust,
								httpspathkey, httpstipokey, httpspwdkey,
								httpspwdprivatekey, httpsalgoritmokey,
								tipoconn, AccordiServizioParteSpecificaCostanti.SERVLET_NAME_APS_FRUITORI_CHANGE, idServizio, idServizioFruitore,
								idSoggettoErogatoreDelServizio, null, null, null, null,
								oldStatoPackage, true,
								isConnettoreCustomUltimaImmagineSalvata, 
								proxy_enabled, proxy_hostname, proxy_port, proxy_username, proxy_password,
								opzioniAvanzate, transfer_mode, transfer_mode_chunk_size, redirect_mode, redirect_max_hop,
								requestOutputFileName,requestOutputFileNameHeaders,requestOutputParentDirCreateIfNotExists,requestOutputOverwriteIfExists,
								responseInputMode, responseInputFileName, responseInputFileNameHeaders, responseInputDeleteAfterRead, responseInputWaitTime,
								listExtendedConnettore);
					}else{
						//spostato nell'helper
					}

					// aggiunta campi custom
					dati = apsHelper.addProtocolPropertiesToDati(dati, this.consoleConfiguration,this.consoleOperationType, this.consoleInterfaceType, this.protocolProperties,oldProtocolPropertyList,propertiesProprietario);

					pd.setDati(dati);

					ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

					return ServletUtils.getStrutsForwardEditModeCheckError(mapping, AccordiServizioParteSpecificaCostanti.OBJECT_NAME_APS_FRUITORI, 
							ForwardParams.CHANGE());
				}
			}

			//imposto properties custom
			fruitore.setProtocolPropertyList(ProtocolPropertiesUtils.toProtocolProperties(this.protocolProperties, this.consoleOperationType, oldProtocolPropertyList));
			
			serviziosp.addFruitore(fruitore);
			String superUser = ServletUtils.getUserLoginFromSession(session);
			apsCore.performUpdateOperation(superUser, apsHelper.smista(), serviziosp);

			// Preparo la lista
			Search ricerca = (Search) ServletUtils.getSearchObjectFromSession(session, Search.class);

			int idLista = Liste.SERVIZI_FRUITORI;

			ricerca = apsHelper.checkSearchParameters(idLista, ricerca);

			List<Fruitore> lista = apsCore.serviziFruitoriList(idServizioInt, ricerca);

			apsHelper.prepareServiziFruitoriList(lista, idServizio, ricerca);

			ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

			return ServletUtils.getStrutsForwardEditModeFinished( mapping, AccordiServizioParteSpecificaCostanti.OBJECT_NAME_APS_FRUITORI,
					ForwardParams.CHANGE());


		} catch (Exception e) {
			return ServletUtils.getStrutsForwardError(ControlStationCore.getLog(), e, pd, session, gd, mapping, 
					AccordiServizioParteSpecificaCostanti.OBJECT_NAME_APS_FRUITORI,
					ForwardParams.CHANGE());
		} 
	}
}
