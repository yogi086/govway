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
package org.openspcoop2.core.config.rs.server.api.impl.erogazioni.gruppi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.openspcoop2.core.commons.Filtri;
import org.openspcoop2.core.commons.Liste;
import org.openspcoop2.core.config.PortaApplicativa;
import org.openspcoop2.core.config.constants.TipoAutenticazionePrincipal;
import org.openspcoop2.core.config.rs.server.api.ErogazioniGruppiApi;
import org.openspcoop2.core.config.rs.server.api.impl.Enums;
import org.openspcoop2.core.config.rs.server.api.impl.Helper;
import org.openspcoop2.core.config.rs.server.api.impl.IdServizio;
import org.openspcoop2.core.config.rs.server.api.impl.erogazioni.ErogazioniApiHelper;
import org.openspcoop2.core.config.rs.server.api.impl.erogazioni.ErogazioniEnv;
import org.openspcoop2.core.config.rs.server.config.ServerProperties;
import org.openspcoop2.core.config.rs.server.model.Gruppo;
import org.openspcoop2.core.config.rs.server.model.GruppoAzioni;
import org.openspcoop2.core.config.rs.server.model.GruppoEreditaConfigurazione;
import org.openspcoop2.core.config.rs.server.model.GruppoItem;
import org.openspcoop2.core.config.rs.server.model.GruppoNome;
import org.openspcoop2.core.config.rs.server.model.GruppoNuovaConfigurazione;
import org.openspcoop2.core.config.rs.server.model.ListaGruppi;
import org.openspcoop2.core.config.rs.server.model.ModalitaConfigurazioneGruppoEnum;
import org.openspcoop2.core.id.IDPortaApplicativa;
import org.openspcoop2.core.mapping.MappingErogazionePortaApplicativa;
import org.openspcoop2.core.registry.AccordoServizioParteSpecifica;
import org.openspcoop2.utils.service.BaseImpl;
import org.openspcoop2.utils.service.authorization.AuthorizationConfig;
import org.openspcoop2.utils.service.authorization.AuthorizationManager;
import org.openspcoop2.utils.service.beans.ProfiloEnum;
import org.openspcoop2.utils.service.beans.utils.BaseHelper;
import org.openspcoop2.utils.service.beans.utils.ListaUtils;
import org.openspcoop2.utils.service.context.IContext;
import org.openspcoop2.utils.service.fault.jaxrs.FaultCode;
import org.openspcoop2.web.ctrlstat.core.Search;
import org.openspcoop2.web.ctrlstat.costanti.CostantiControlStation;
import org.openspcoop2.web.ctrlstat.servlet.aps.AccordiServizioParteSpecificaPorteApplicativeMappingInfo;
import org.openspcoop2.web.ctrlstat.servlet.aps.AccordiServizioParteSpecificaUtilities;
import org.openspcoop2.web.ctrlstat.servlet.pa.PorteApplicativeUtilities;
import org.openspcoop2.web.lib.mvc.ServletUtils;
import org.openspcoop2.web.lib.mvc.TipoOperazione;

/**
 * ErogazioniGruppiApiServiceImpl
 * 
 * @author $Author$
 * @version $Rev$, $Date$
 * 
 */
public class ErogazioniGruppiApiServiceImpl extends BaseImpl implements ErogazioniGruppiApi {

	public ErogazioniGruppiApiServiceImpl(){
		super(org.slf4j.LoggerFactory.getLogger(ErogazioniGruppiApiServiceImpl.class));
	}

	private AuthorizationConfig getAuthorizationConfig() throws Exception{
		return new AuthorizationConfig(ServerProperties.getInstance().getProperties());
	}

    /**
     * Aggiunta di azioni o risorse dell'API al gruppo
     *
     * Questa operazione consente di aggiungere azioni o risorse dell'API al gruppo
     *
     */
	@Override
    public void addErogazioneGruppoAzioni(GruppoAzioni body, String nome, Integer versione, String nomeGruppo, ProfiloEnum profilo, String soggetto, String tipoServizio) {
		IContext context = this.getContext();
		try {

			context.getLogger().info("Invocazione in corso ...");
			
			AuthorizationManager.authorize(context, getAuthorizationConfig());
			context.getLogger().debug("Autorizzazione completata con successo");
			
			BaseHelper.throwIfNull(body);
			
			final ErogazioniEnv env = new ErogazioniEnv(context.getServletRequest(), profilo, soggetto, context);
			final AccordoServizioParteSpecifica asps = BaseHelper.supplyOrNotFound( () -> ErogazioniApiHelper.getServizioIfErogazione(tipoServizio, nome, versione, env.idSoggetto.toIDSoggetto(), env), "Erogazione");
			final IdServizio idAsps = new IdServizio(env.idServizioFactory.getIDServizioFromAccordo(asps), asps.getId());
			final IDPortaApplicativa idPa = BaseHelper.supplyOrNotFound( () -> ErogazioniApiHelper.getIDGruppoPA(nomeGruppo, idAsps, env.apsCore), "Gruppo per l'erogazione scelta");
			final PortaApplicativa pa = env.paCore.getPortaApplicativa(idPa);
						
			List<String> azioniOccupate = ErogazioniApiHelper.getAzioniOccupateErogazione(idAsps, env.apsCore, env.paCore);
					
			ErogazioniApiHelper.checkAzioniAdd( 
					body.getAzioni(),
					azioniOccupate,
					env.apcCore.getAzioni(asps, env.apcCore.getAccordoServizioSintetico(asps.getIdAccordo()), false, false, null)
				);
			
			env.requestWrapper.overrideParameterValues(CostantiControlStation.PARAMETRO_AZIONI, body.getAzioni().toArray(new String[0]));
		
			List<MappingErogazionePortaApplicativa> listaMappingErogazione = env.apsCore.mappingServiziPorteAppList(idAsps,asps.getId(), null);
			if (!env.paHelper.porteAppAzioneCheckData(TipoOperazione.ADD,azioniOccupate,listaMappingErogazione)) {
				throw FaultCode.RICHIESTA_NON_VALIDA.toException(StringEscapeUtils.unescapeHtml(env.pd.getMessage()));
			}
			
			// aggiungo azione nel db
			for(String azione: body.getAzioni()) {
				pa.getAzione().addAzioneDelegata(azione);
			}

			env.paCore.performUpdateOperation(env.userLogin, false, pa);

			context.getLogger().info("Invocazione completata con successo");        
     
		}
		catch(javax.ws.rs.WebApplicationException e) {
			context.getLogger().error("Invocazione terminata con errore '4xx': %s",e, e.getMessage());
			throw e;
		}
		catch(Throwable e) {
			context.getLogger().error("Invocazione terminata con errore: %s",e, e.getMessage());
			throw FaultCode.ERRORE_INTERNO.toException(e);
		}
    }
    
    /**
     * Creazione di un gruppo di azioni o risorse dell'API erogata
     *
     * Questa operazione consente di creare un gruppo di azioni o risorse dell'API erogata
     *
     */
	@Override
    public void createErogazioneGruppo(Gruppo body, String nome, Integer versione, ProfiloEnum profilo, String soggetto, String tipoServizio) {
		IContext context = this.getContext();
		try {
			context.getLogger().info("Invocazione in corso ...");     

			AuthorizationManager.authorize(context, getAuthorizationConfig());
			context.getLogger().debug("Autorizzazione completata con successo");     
			
			BaseHelper.throwIfNull(body);

			
			final ErogazioniEnv env = new ErogazioniEnv(context.getServletRequest(), profilo, soggetto, context);
			final AccordoServizioParteSpecifica asps = BaseHelper.supplyOrNotFound( () -> ErogazioniApiHelper.getServizioIfErogazione(tipoServizio, nome, versione, env.idSoggetto.toIDSoggetto(), env), "Erogazione");
			IdServizio idAsps = new IdServizio(env.idServizioFactory.getIDServizioFromAccordo(asps), asps.getId());
	
			String mappingPadre = null;
			String erogazioneAutenticazione = null;
			String erogazioneAutenticazioneOpzionale = null;
			TipoAutenticazionePrincipal erogazioneAutenticazionePrincipal = null;
			List<String> erogazioneAutenticazioneParametroList = null;
			
			if ( body.getModalita() == ModalitaConfigurazioneGruppoEnum.NUOVA ) {
				
				final GruppoNuovaConfigurazione confNuova = ErogazioniApiHelper.deserializeModalitaConfGruppo(body.getModalita(), body.getConfigurazione());
				
				if(confNuova.getAutenticazione()!=null) {
					erogazioneAutenticazione = Enums.toTipoAutenticazione(confNuova.getAutenticazione().getTipo()).toString();
					erogazioneAutenticazioneOpzionale = ServletUtils.boolToCheckBoxStatus(confNuova.getAutenticazione().isOpzionale());
					erogazioneAutenticazionePrincipal = ErogazioniApiHelper.getTipoAutenticazionePrincipal(confNuova.getAutenticazione().getTipo(), confNuova.getAutenticazione().getConfigurazione()); 
					erogazioneAutenticazioneParametroList = ErogazioniApiHelper.getAutenticazioneParametroList(env, confNuova.getAutenticazione().getTipo(), confNuova.getAutenticazione().getConfigurazione());
				}
			}
			
			else if ( body.getModalita() == ModalitaConfigurazioneGruppoEnum.EREDITA ) {
				
				GruppoEreditaConfigurazione confEredita = ErogazioniApiHelper.deserializeModalitaConfGruppo(body.getModalita(), body.getConfigurazione());
				List<MappingErogazionePortaApplicativa> mappings = ErogazioniApiHelper.getMappingGruppiPA( confEredita.getNome(), idAsps, env.apsCore);
				if ( mappings.isEmpty() ) {
					throw FaultCode.RICHIESTA_NON_VALIDA.toException("Il gruppo " + confEredita.getNome() + " da cui ereditare è inesistente");
				}
				mappingPadre = mappings.get(0).getNome();		
			}
						
			final AccordiServizioParteSpecificaPorteApplicativeMappingInfo mappingInfo = AccordiServizioParteSpecificaUtilities.getMappingInfo(mappingPadre, asps, env.apsCore);
			final MappingErogazionePortaApplicativa mappingSelezionato = mappingInfo.getMappingSelezionato();
			final MappingErogazionePortaApplicativa mappingDefault = mappingInfo.getMappingDefault();
			final List<String> azioniOccupate = mappingInfo.getAzioniOccupate();
			
			if ( mappingDefault == null )
				throw FaultCode.NOT_FOUND.toException("Nessuna erogazione trovata");
			
			if ( mappingSelezionato == null )
				throw FaultCode.RICHIESTA_NON_VALIDA.toException("Gruppo scelto non trovato");
						
			ErogazioniApiHelper.checkAzioniAdd( 
					body.getAzioni(),
					azioniOccupate,
					env.apcCore.getAzioni(asps, env.apcCore.getAccordoServizioSintetico(asps.getIdAccordo()), false, false, null)
				);
			
			if (!env.apsHelper.configurazioneErogazioneCheckData(
					TipoOperazione.ADD, 
					mappingInfo.getNomeNuovaConfigurazione(),					
					body.getNome(), 
					body.getAzioni().toArray(new String[0]),
					asps, 
					azioniOccupate,
					body.getModalita().toString(),					// modeCreazione
					null,											// Come da codice console,
					env.isSupportatoAutenticazioneSoggetti,
					mappingInfo
				)) {
				throw FaultCode.RICHIESTA_NON_VALIDA.toException(StringEscapeUtils.unescapeHtml(env.pd.getMessage()));
			}
			
			
			AccordiServizioParteSpecificaUtilities.addAccordoServizioParteSpecificaPorteApplicative(
					mappingDefault,
					mappingSelezionato,
					mappingInfo.getNomeNuovaConfigurazione(),
					body.getNome(),				// nomeGruppo
					body.getAzioni().toArray(new String[0]),	// azioni
					body.getModalita().toString(),				// modeCreazione
					body.getModalita().toString(),				// modeCreazioneConnettore Forse c'è un bug nella console, qui viene passato "eredita", nella console viene trattato come una checkbox
					null,							// endpointtype,
					null,							// tipoconn,
					null,							// autenticazioneHttp,	// RECHECK
					null,							// connettoreDebug,
					null,							// url,
					null,							// nomeCodaJms,
					null,							// tipoJms, 
					null,							// initcont, 
					null,							// urlpgk, 
					null,							// provurl, 
					null,							// connfact, 
					null,							// tipoSendas, 
					null,							// user, 	RECHECK
					null,							// password, RECHECK
					null,							// httpsurl, 
					null,							// httpstipologia, 
					false,							// httpshostverify,
					null,							// httpspath, 
					null,							// httpstipo, 
					null,							// httpspwd,
					null,							// httpsalgoritmo, 
					false,							// httpsstato,
					null,							// httpskeystore,
					null,							// httpspwdprivatekeytrust, 
					null,							// httpspathkey,
					null,							// httpstipokey, 
					null,							// httpspwdkey,
					null,							// httpspwdprivatekey, 
					null,							// httpsalgoritmokey,
	        		null,							// httpsKeyAlias
	        		null,							// httpsTrustStoreCRLs
					null,							// proxy_enabled, 
					null,							// proxy_hostname, 
					null,							// proxy_port, 
					null,							// proxy_username, 
					null,							// proxy_password,
					null,							// tempiRisposta_enabled, 
					null,							// tempiRisposta_connectionTimeout,
					null,							// tempiRisposta_readTimeout, 
					null,							// tempiRisposta_tempoMedioRisposta,
					"no",							// opzioniAvanzate,
					null,							// transfer_mode, 
					null,							// transfer_mode_chunk_size, 
					null,							// redirect_mode, 
					null,							// redirect_max_hop,
					null,							// requestOutputFileName,
					null,							// requestOutputFileNameHeaders,
					null,							// requestOutputParentDirCreateIfNotExists,
					null,							// requestOutputOverwriteIfExists,
					null,							// responseInputMode,
					null,							// responseInputFileName,
					null,							// responseInputFileNameHeaders, 
					null,							// responseInputDeleteAfterRead, 
					null,							// responseInputWaitTime,
					false, 							// autenticazioneToken,
					null, 							// tokenPolicy,
					null,							// listExtendedConnettore
	        		erogazioneAutenticazione,
	        		erogazioneAutenticazioneOpzionale,
	        		erogazioneAutenticazionePrincipal,
	        		erogazioneAutenticazioneParametroList,
					"disabilitato",					// erogazioneAutorizzazione
					null,							// erogazioneAutorizzazioneAutenticati, 
					null,							// erogazioneAutorizzazioneRuoli, 
					null,							// erogazioneAutorizzazioneRuoliTipologia, 
					null,							// erogazioneAutorizzazioneRuoliMatch,
					null,							// nomeSA, 
					null,							// erogazioneRuolo, 
					null,							// erogazioneSoggettoAutenticato, 
					null,							// autorizzazione_tokenOptions,
					null,							// autorizzazioneScope,
					null,							// scope, 
					null,							// autorizzazioneScopeMatch,
					null,							// allegatoXacmlPolicy,
					"disabilitato",					// gestioneToken
					null,							// gestioneTokenPolicy,  
					null,							// gestioneTokenOpzionale,  
					null,							// gestioneTokenValidazioneInput, 
					null,							// gestioneTokenIntrospection, 
					null,							// gestioneTokenUserInfo, 
					null,							// gestioneTokenTokenForward,
					null,							// autenticazioneTokenIssuer, 
					null,							// autenticazioneTokenClientId,
					null,							// autenticazioneTokenSubject, 
					null,							// autenticazioneTokenUsername, 
					null,							// autenticazioneTokenEMail,
					asps, 
					env.tipo_protocollo, 
					env.userLogin,
					env.apsCore,
					env.apsHelper
				);

		        
			context.getLogger().info("Invocazione completata con successo");
        
     
			// Bug Fix: altrimenti viene generato 204
			context.getServletResponse().setStatus(201);
		}
		catch(javax.ws.rs.WebApplicationException e) {
			context.getLogger().error("Invocazione terminata con errore '4xx': %s",e, e.getMessage());
			throw e;
		}
		catch(Throwable e) {
			context.getLogger().error("Invocazione terminata con errore: %s",e, e.getMessage());
			throw FaultCode.ERRORE_INTERNO.toException(e);
		}
    }
    
    /**
     * Elimina il gruppo identificato dal nome
     *
     * Questa operazione consente di eliminare il gruppo identificato dal nome
     *
     */
	@Override
    public void deleteErogazioneGruppo(String nome, Integer versione, String nomeGruppo, ProfiloEnum profilo, String soggetto, String tipoServizio) {
		IContext context = this.getContext();
		try {
			context.getLogger().info("Invocazione in corso ...");     

			AuthorizationManager.authorize(context, getAuthorizationConfig());
			context.getLogger().debug("Autorizzazione completata con successo");
			
			final ErogazioniEnv env = new ErogazioniEnv(context.getServletRequest(), profilo, soggetto, context);
			final AccordoServizioParteSpecifica asps = BaseHelper.supplyOrNotFound( () -> ErogazioniApiHelper.getServizioIfErogazione(tipoServizio, nome, versione, env.idSoggetto.toIDSoggetto(), env), "Erogazione");
			final IdServizio idAsps = new IdServizio(env.idServizioFactory.getIDServizioFromAccordo(asps),asps.getId());
			
			final IDPortaApplicativa idPortaApplicativa = ErogazioniApiHelper.getIDGruppoPA(nomeGruppo, idAsps, env.apsCore);
				
			if (env.delete_404 && idPortaApplicativa == null) 
				throw FaultCode.NOT_FOUND.toException("Gruppo con nome " + nomeGruppo + "non trovato per l'erogazione scelta");

			else if ( idPortaApplicativa != null) {
		
				StringBuilder inUsoMessage = new StringBuilder();
				AccordiServizioParteSpecificaUtilities.deleteAccordoServizioParteSpecificaPorteApplicative(idPortaApplicativa, idAsps, env.userLogin, env.apsCore, env.apsHelper, inUsoMessage);
				
				if (inUsoMessage.length() > 0) {
					throw FaultCode.RICHIESTA_NON_VALIDA.toException(StringEscapeUtils.unescapeHtml(inUsoMessage.toString()));
				}
			}
			context.getLogger().info("Invocazione completata con successo");
     
		}
		catch(javax.ws.rs.WebApplicationException e) {
			context.getLogger().error("Invocazione terminata con errore '4xx': %s",e, e.getMessage());
			throw e;
		}
		catch(Throwable e) {
			context.getLogger().error("Invocazione terminata con errore: %s",e, e.getMessage());
			throw FaultCode.ERRORE_INTERNO.toException(e);
		}
    }
    
    /**
     * Elimina l'azione o la risorsa dell'API associata al gruppo
     *
     * Questa operazione consente di eliminare l'azione o la risorsa dell'API associate al gruppo
     *
     */
	@Override
    public void deleteErogazioneGruppoAzione(String nome, Integer versione, String nomeGruppo, String nomeAzione, ProfiloEnum profilo, String soggetto, String tipoServizio) {
		IContext context = this.getContext();
		try {
			context.getLogger().info("Invocazione in corso ...");     

			AuthorizationManager.authorize(context, getAuthorizationConfig());
			context.getLogger().debug("Autorizzazione completata con successo");
			
			
			final ErogazioniEnv env = new ErogazioniEnv(context.getServletRequest(), profilo, soggetto, context);
			final AccordoServizioParteSpecifica asps = BaseHelper.supplyOrNotFound( () -> ErogazioniApiHelper.getServizioIfErogazione(tipoServizio, nome, versione, env.idSoggetto.toIDSoggetto(), env), "Erogazione");
			final IdServizio idAsps = new IdServizio(env.idServizioFactory.getIDServizioFromAccordo(asps), asps.getId());
			final IDPortaApplicativa idPa = BaseHelper.supplyOrNotFound( () -> ErogazioniApiHelper.getIDGruppoPA(nomeGruppo, idAsps, env.apsCore), "Gruppo per l'erogazione scelta");
			final PortaApplicativa pa = env.paCore.getPortaApplicativa(idPa);
			
			if ( BaseHelper.findFirst( pa.getAzione().getAzioneDelegataList(), a -> a.equals(nomeAzione)).isPresent() )	{
				StringBuilder inUsoMessage = new StringBuilder();
				
				PorteApplicativeUtilities.deletePortaApplicativaAzioni(pa, env.paCore, env.paHelper, inUsoMessage, new ArrayList<String>(Arrays.asList(nomeAzione)), env.userLogin);
				
				if (inUsoMessage.length() > 0)
					throw FaultCode.RICHIESTA_NON_VALIDA.toException(StringEscapeUtils.unescapeHtml(inUsoMessage.toString()));
				
			} else if ( env.delete_404 ) {
				throw FaultCode.NOT_FOUND.toException("Azione " + nomeAzione + " non presente nel gruppo " + nomeGruppo);
			}
			                        		
			context.getLogger().info("Invocazione completata con successo");
        
     
		}
		catch(javax.ws.rs.WebApplicationException e) {
			context.getLogger().error("Invocazione terminata con errore '4xx': %s",e, e.getMessage());
			throw e;
		}
		catch(Throwable e) {
			context.getLogger().error("Invocazione terminata con errore: %s",e, e.getMessage());
			throw FaultCode.ERRORE_INTERNO.toException(e);
		}
    }
    
    /**
     * Ricerca i gruppi in cui sono stati classificate le azioni o le risorse dell'API
     *
     * Elenca i gruppi in cui sono stati classificate le azioni o le risorse dell'API
     *
     */
	@Override
    public ListaGruppi findAllErogazioneGruppi(String nome, Integer versione, ProfiloEnum profilo, String soggetto, String tipoServizio, Integer limit, Integer offset, String azione) {
		IContext context = this.getContext();
		try {
			context.getLogger().info("Invocazione in corso ...");     

			AuthorizationManager.authorize(context, getAuthorizationConfig());
			context.getLogger().debug("Autorizzazione completata con successo");
			
			final ErogazioniEnv env = new ErogazioniEnv(context.getServletRequest(), profilo, soggetto, context);
			final AccordoServizioParteSpecifica asps = BaseHelper.supplyOrNotFound( () -> ErogazioniApiHelper.getServizioIfErogazione(tipoServizio, nome, versione, env.idSoggetto.toIDSoggetto(), env), "Erogazione");
			final IdServizio idAsps = new IdServizio(env.idServizioFactory.getIDServizioFromAccordo(asps), asps.getId());
			final int idLista = Liste.CONFIGURAZIONE_EROGAZIONE;
			
			final Search ricerca = Helper.setupRicercaPaginata(null, limit, offset, idLista, env.idSoggetto.toIDSoggetto(), env.tipo_protocollo);
			
			if (!StringUtils.isEmpty(azione))
				ricerca.addFilter(idLista, Filtri.FILTRO_AZIONE, azione);
			
			List<MappingErogazionePortaApplicativa> mappings = env.apsCore.mappingServiziPorteAppList(idAsps, ricerca);
			
			if ( env.findall_404 && mappings.isEmpty() ) {
				throw FaultCode.NOT_FOUND.toException("Nessuna porta associata al servizio: " + idAsps.toString());
			}
			
			ListaGruppi ret = ListaUtils.costruisciListaPaginata(context.getUriInfo(), 
					ricerca.getIndexIniziale(idLista),
					ricerca.getPageSize(idLista), 
					ricerca.getNumEntries(idLista), ListaGruppi.class);
			
			for (MappingErogazionePortaApplicativa m : mappings) {
				final PortaApplicativa pd = env.paCore.getPortaApplicativa(m.getIdPortaApplicativa());
				
				GruppoItem g = new GruppoItem();
				g.setAzioni(pd.getAzione().getAzioneDelegataList());
				g.setNome(m.getDescrizione());
				g.setPredefinito(m.isDefault());
				
				ret.addItemsItem(g);			
			}
                       
        
			context.getLogger().info("Invocazione completata con successo");
        	return ret;
     
		}
		catch(javax.ws.rs.WebApplicationException e) {
			context.getLogger().error("Invocazione terminata con errore '4xx': %s",e, e.getMessage());
			throw e;
		}
		catch(Throwable e) {
			context.getLogger().error("Invocazione terminata con errore: %s",e, e.getMessage());
			throw FaultCode.ERRORE_INTERNO.toException(e);
		}
    }
    
    /**
     * Restituisce azioni/risorse associate al gruppo identificato dal nome
     *
     * Questa operazione consente di ottenere le azioni associate al gruppo identificato dal nome
     *
     */
	@Override
    public GruppoAzioni getErogazioneGruppoAzioni(String nome, Integer versione, String nomeGruppo, ProfiloEnum profilo, String soggetto, String tipoServizio) {
		IContext context = this.getContext();
		try {
			context.getLogger().info("Invocazione in corso ...");     

			AuthorizationManager.authorize(context, getAuthorizationConfig());
			context.getLogger().debug("Autorizzazione completata con successo");
			
			final ErogazioniEnv env = new ErogazioniEnv(context.getServletRequest(), profilo, soggetto, context);
			final AccordoServizioParteSpecifica asps = BaseHelper.supplyOrNotFound( () -> ErogazioniApiHelper.getServizioIfErogazione(tipoServizio, nome, versione, env.idSoggetto.toIDSoggetto(), env), "Erogazione");
			final IdServizio idAsps = new IdServizio(env.idServizioFactory.getIDServizioFromAccordo(asps), asps.getId());
			
			final IDPortaApplicativa idPa = BaseHelper.supplyOrNotFound( 
					() -> ErogazioniApiHelper.getIDGruppoPA(nomeGruppo, idAsps, env.apsCore)
					, "Gruppo per l'erogazione scelta"
				);
			
			final PortaApplicativa pa = BaseHelper.supplyOrNotFound( 
					() -> env.paCore.getPortaApplicativa(idPa)
					, "Gruppo per l'erogazione scelta"
				);
			
			GruppoAzioni ret = new GruppoAzioni();
			ret.setAzioni(pa.getAzione().getAzioneDelegataList());
			context.getLogger().info("Invocazione completata con successo");
			
			return ret;
     
		}
		catch(javax.ws.rs.WebApplicationException e) {
			context.getLogger().error("Invocazione terminata con errore '4xx': %s",e, e.getMessage());
			throw e;
		}
		catch(Throwable e) {
			context.getLogger().error("Invocazione terminata con errore: %s",e, e.getMessage());
			throw FaultCode.ERRORE_INTERNO.toException(e);
		}
    }
    
    /**
     * Consente di modificare il nome del gruppo
     *
     * Questa operazione consente di aggiornare il nome di un gruppo
     *
     */
	@Override
    public void updateErogazioneGruppoNome(GruppoNome body, String nome, Integer versione, String nomeGruppo, ProfiloEnum profilo, String soggetto, String tipoServizio) {
		IContext context = this.getContext();
		try {
			context.getLogger().info("Invocazione in corso ...");     

			AuthorizationManager.authorize(context, getAuthorizationConfig());
			context.getLogger().debug("Autorizzazione completata con successo");
			
			BaseHelper.throwIfNull(body);
                        
			// PorteApplicativeConfigurazioneChange
			final ErogazioniEnv env = new ErogazioniEnv(context.getServletRequest(), profilo, soggetto, context);
			final AccordoServizioParteSpecifica asps = BaseHelper.supplyOrNotFound( () -> ErogazioniApiHelper.getServizioIfErogazione(tipoServizio, nome, versione, env.idSoggetto.toIDSoggetto(), env), "Erogazione");
			final IdServizio idAsps = new IdServizio(env.idServizioFactory.getIDServizioFromAccordo(asps),asps.getId());
			final List<MappingErogazionePortaApplicativa> listaMapping = env.apsCore.mappingServiziPorteAppList(idAsps,idAsps.getId(), null);
			final List<String> mappingUtilizzati = ErogazioniApiHelper.getDescrizioniMappingPA(listaMapping);
			
			BaseHelper.supplyOrNotFound( () -> ErogazioniApiHelper.getIDGruppoPA(nomeGruppo, idAsps, env.apsCore), "Gruppo per l'erogazione scelta");
			
			if (mappingUtilizzati.stream().filter( m -> m.equalsIgnoreCase(body.getNome())).findFirst().isPresent()) {
				throw FaultCode.CONFLITTO.toException(CostantiControlStation.MESSAGGIO_ERRORE_NOME_GRUPPO_GIA_PRESENTE);
			}
			
			if (! env.paHelper.configurazioneCambiaNomeCheck(TipoOperazione.OTHER, body.getNome(), mappingUtilizzati,false)) {
				throw FaultCode.RICHIESTA_NON_VALIDA.toException(StringEscapeUtils.unescapeHtml(env.pd.getMessage()));
			}
			
			final MappingErogazionePortaApplicativa mappingErogazionePortaApplicativa = AccordiServizioParteSpecificaUtilities.getMappingPA_filterByDescription(
					 listaMapping, 
					 nomeGruppo
					);
			
			mappingErogazionePortaApplicativa.setDescrizione(body.getNome());
			
			env.paCore.aggiornaDescrizioneMappingErogazionePortaApplicativa( mappingErogazionePortaApplicativa );
								
			context.getLogger().info("Invocazione completata con successo");
        
     
		}
		catch(javax.ws.rs.WebApplicationException e) {
			context.getLogger().error("Invocazione terminata con errore '4xx': %s",e, e.getMessage());
			throw e;
		}
		catch(Throwable e) {
			context.getLogger().error("Invocazione terminata con errore: %s",e, e.getMessage());
			throw FaultCode.ERRORE_INTERNO.toException(e);
		}
    }
    
}

