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


package org.openspcoop2.web.ctrlstat.servlet.archivi;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.openspcoop2.core.config.PortaApplicativa;
import org.openspcoop2.core.config.PortaApplicativaAutorizzazioneServizioApplicativo;
import org.openspcoop2.core.config.PortaApplicativaAutorizzazioneSoggetto;
import org.openspcoop2.core.config.ServizioApplicativo;
import org.openspcoop2.core.config.driver.DriverConfigurazioneException;
import org.openspcoop2.core.config.driver.DriverConfigurazioneNotFound;
import org.openspcoop2.core.id.IDAccordo;
import org.openspcoop2.core.id.IDAccordoCooperazione;
import org.openspcoop2.core.id.IDGruppo;
import org.openspcoop2.core.id.IDRuolo;
import org.openspcoop2.core.id.IDScope;
import org.openspcoop2.core.id.IDServizio;
import org.openspcoop2.core.id.IDServizioApplicativo;
import org.openspcoop2.core.id.IDSoggetto;
import org.openspcoop2.core.registry.AccordoServizioParteComune;
import org.openspcoop2.core.registry.AccordoServizioParteComuneServizioCompostoServizioComponente;
import org.openspcoop2.core.registry.driver.DriverRegistroServiziException;
import org.openspcoop2.core.registry.driver.DriverRegistroServiziNotFound;
import org.openspcoop2.core.registry.driver.IDAccordoCooperazioneFactory;
import org.openspcoop2.core.registry.driver.IDAccordoFactory;
import org.openspcoop2.core.registry.driver.IDServizioFactory;
import org.openspcoop2.protocol.engine.ProtocolFactoryManager;
import org.openspcoop2.protocol.sdk.IProtocolFactory;
import org.openspcoop2.protocol.sdk.ProtocolException;
import org.openspcoop2.protocol.sdk.archive.Archive;
import org.openspcoop2.protocol.sdk.archive.ArchiveAccordoCooperazione;
import org.openspcoop2.protocol.sdk.archive.ArchiveAccordoServizioComposto;
import org.openspcoop2.protocol.sdk.archive.ArchiveAccordoServizioParteComune;
import org.openspcoop2.protocol.sdk.archive.ArchiveAccordoServizioParteSpecifica;
import org.openspcoop2.protocol.sdk.archive.ArchiveActivePolicy;
import org.openspcoop2.protocol.sdk.archive.ArchiveFruitore;
import org.openspcoop2.protocol.sdk.archive.ArchivePortaApplicativa;
import org.openspcoop2.protocol.sdk.archive.ArchivePortaDelegata;
import org.openspcoop2.protocol.sdk.archive.ArchiveServizioApplicativo;
import org.openspcoop2.protocol.sdk.archive.ArchiveSoggetto;
import org.openspcoop2.protocol.sdk.archive.ExportMode;
import org.openspcoop2.protocol.sdk.archive.IArchive;
import org.openspcoop2.protocol.sdk.constants.ArchiveType;
import org.openspcoop2.web.ctrlstat.core.ControlStationCore;
import org.openspcoop2.web.ctrlstat.core.Utilities;
import org.openspcoop2.web.ctrlstat.servlet.ac.AccordiCooperazioneCore;
import org.openspcoop2.web.ctrlstat.servlet.apc.AccordiServizioParteComuneCore;
import org.openspcoop2.web.ctrlstat.servlet.aps.AccordiServizioParteSpecificaCore;
import org.openspcoop2.web.ctrlstat.servlet.ruoli.RuoliCore;
import org.openspcoop2.web.ctrlstat.servlet.sa.ServiziApplicativiCore;
import org.openspcoop2.web.ctrlstat.servlet.scope.ScopeCore;
import org.openspcoop2.web.ctrlstat.servlet.soggetti.SoggettiCore;

/**
 * ExporterUtils
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class ExporterUtils {

	private ArchiviCore archiviCore;
	private SoggettiCore soggettiCore;
	private AccordiServizioParteComuneCore aspcCore;
	@SuppressWarnings("unused")
	private AccordiServizioParteSpecificaCore aspsCore;
	private AccordiCooperazioneCore acCore;
	private ServiziApplicativiCore saCore;
	@SuppressWarnings("unused")
	private RuoliCore ruoliCore;
	@SuppressWarnings("unused")
	private ScopeCore scopeCore;
	
	public ExporterUtils(ArchiviCore archiviCore) throws Exception{
		this.archiviCore = archiviCore;
		this.soggettiCore = new SoggettiCore(archiviCore);
		this.aspcCore = new AccordiServizioParteComuneCore(archiviCore);
		this.aspsCore = new AccordiServizioParteSpecificaCore(archiviCore);
		this.acCore = new AccordiCooperazioneCore(archiviCore);
		this.saCore = new ServiziApplicativiCore(archiviCore);
		this.ruoliCore = new RuoliCore(archiviCore);
		this.scopeCore = new ScopeCore(archiviCore);
	}

	public List<ExportMode> getExportModesCompatibleWithAllProtocol(List<String> protocolli,ArchiveType archiveType) throws ProtocolException{
		
		List<ExportMode> exportModes = new ArrayList<ExportMode>();
		
		for (int i = 0; i < protocolli.size(); i++) {
			String protocolName = protocolli.get(i);
			IProtocolFactory<?> pf = ProtocolFactoryManager.getInstance().getProtocolFactoryByName(protocolName);
			IArchive archiveEngine = pf.createArchive();
			List<ExportMode> exportModesByProtocol = archiveEngine.getExportModes(archiveType);
			for (ExportMode exportMode : exportModesByProtocol) {
				
				boolean found = true;
				
				for (int j = 0; j < protocolli.size(); j++) {
					if(j==i)
						continue;
					String protocolCheck = protocolli.get(j);
					IProtocolFactory<?> pfCheck = ProtocolFactoryManager.getInstance().getProtocolFactoryByName(protocolCheck);
					IArchive archiveEngineCheck = pfCheck.createArchive();
					List<ExportMode> exportModesByProtocolCheck = archiveEngineCheck.getExportModes(archiveType);
					if(exportModesByProtocolCheck.contains(exportMode)==false){
						found = false;
						break;
					}
				}
				
				if(found){
					if(exportModes.contains(exportMode)==false)
						exportModes.add(exportMode);
				}
				
			}
		}
		
		return exportModes;
	}
	
	public Hashtable<ExportMode,String> getExportModesWithProtocol(List<String> protocolli,ArchiveType archiveType) throws ProtocolException{

		Hashtable<ExportMode,String> exportModes = new Hashtable<ExportMode,String>();
		for (int i = 0; i < protocolli.size(); i++) {
			String protocolName = protocolli.get(i);
			if(ArchiviCostanti.PARAMETRO_ARCHIVI_PROTOCOLLO_UNDEFINDED.equals(protocolName)==false){
				IProtocolFactory<?> pf = ProtocolFactoryManager.getInstance().getProtocolFactoryByName(protocolName);
				IArchive archiveEngine = pf.createArchive();
				List<ExportMode> exportModesByProtocol = archiveEngine.getExportModes(archiveType);
				for (ExportMode exp : exportModesByProtocol) {
					if(exportModes.containsKey(exp)==false){
						exportModes.put(exp,protocolName);
					}
				}
			}
		}

		return exportModes;
	}

	
	public boolean existsAtLeastOneExportMpde(ArchiveType archiveType, HttpSession session) throws ProtocolException, DriverRegistroServiziException{
		List<String> protocolli = this.archiviCore.getProtocolli(session);
		return this.getExportModesWithProtocol(protocolli, archiveType).size()>0;
	}

	public List<?> getIdsSoggetti(String ids) throws DriverRegistroServiziNotFound, DriverRegistroServiziException{
		List<IDSoggetto> idsSoggetti = new ArrayList<IDSoggetto>();
		ArrayList<String> idsToExport = Utilities.parseIdsToRemove(ids);
		for (String id : idsToExport) {
			long idLong = Long.parseLong(id);
			idsSoggetti.add(this.soggettiCore.getIdSoggettoRegistro(idLong));
		}
		return idsSoggetti;
	}
	
	public List<?> getIdsServiziApplicativi(String ids) throws DriverConfigurazioneNotFound, DriverConfigurazioneException{
		List<IDServizioApplicativo> idsSA = new ArrayList<IDServizioApplicativo>();
		ArrayList<String> idsToExport = Utilities.parseIdsToRemove(ids);
		for (String id : idsToExport) {
			long idLong = Long.parseLong(id);
			ServizioApplicativo sa = this.saCore.getServizioApplicativo(idLong);
			IDServizioApplicativo idSA = new IDServizioApplicativo();
			idSA.setIdSoggettoProprietario(new IDSoggetto(sa.getTipoSoggettoProprietario(), sa.getNomeSoggettoProprietario()));
			idSA.setNome(sa.getNome());
			idsSA.add(idSA);
		}
		return idsSA;
	}
	
	public List<?> getIdsAccordiServizioComposti(String ids) throws DriverRegistroServiziNotFound, DriverRegistroServiziException{
		return this.getIdsAccordiServizioParteComune(ids);
	}
	public List<?> getIdsAccordiServizioParteComune(String ids) throws DriverRegistroServiziNotFound, DriverRegistroServiziException{
		List<IDAccordo> idsAccordi = new ArrayList<IDAccordo>();
		ArrayList<String> idsToExport = Utilities.parseIdsToRemove(ids);
		for (String id : idsToExport) {
			long idLong = Long.parseLong(id);
			idsAccordi.add(this.aspcCore.getIdAccordoServizio(idLong));
		}
		return idsAccordi;
	}
	
	public List<?> getIdsAccordiServizioParteSpecifica(String ids) throws DriverRegistroServiziNotFound, DriverRegistroServiziException{
		List<IDServizio> idsAccordi = new ArrayList<IDServizio>();
		ArrayList<String> idsToExport = Utilities.parseIdsToRemove(ids);
		for (String id : idsToExport) {
			if(id.contains("@")) {
				// fruizioni
				id = id.split("@")[0];
			}
			IDServizio idS = IDServizioFactory.getInstance().getIDServizioFromUri(id);
			idsAccordi.add(idS);
		}
		return idsAccordi;
	}
	
	public List<?> getIdsAccordiCooperazione(String ids) throws DriverRegistroServiziNotFound, DriverRegistroServiziException{
		List<IDAccordoCooperazione> idsAccordi = new ArrayList<IDAccordoCooperazione>();
		ArrayList<String> idsToExport = Utilities.parseIdsToRemove(ids);
		for (String id : idsToExport) {
			long idLong = Long.parseLong(id);
			idsAccordi.add(this.acCore.getIdAccordoCooperazione(idLong));
		}
		return idsAccordi;
	}
	
	public List<?> getIdsGruppi(String ids) throws DriverRegistroServiziNotFound, DriverRegistroServiziException{
		List<IDGruppo> idsGruppi = new ArrayList<IDGruppo>();
		ArrayList<String> idsToExport = Utilities.parseIdsToRemove(ids);
		for (String id : idsToExport) {
			IDGruppo idGruppo = new IDGruppo(id);
			idsGruppi.add(idGruppo);
		}
		return idsGruppi;
	}
		
	public List<?> getIdsRuoli(String ids) throws DriverRegistroServiziNotFound, DriverRegistroServiziException{
		List<IDRuolo> idsRuoli = new ArrayList<IDRuolo>();
		ArrayList<String> idsToExport = Utilities.parseIdsToRemove(ids);
		for (String id : idsToExport) {
			IDRuolo idRuolo = new IDRuolo(id);
			idsRuoli.add(idRuolo);
		}
		return idsRuoli;
	}
	
	public List<?> getIdsScope(String ids) throws DriverRegistroServiziNotFound, DriverRegistroServiziException{
		List<IDScope> idsScope = new ArrayList<IDScope>();
		ArrayList<String> idsToExport = Utilities.parseIdsToRemove(ids);
		for (String id : idsToExport) {
			IDScope idScope = new IDScope(id);
			idsScope.add(idScope);
		}
		return idsScope;
	}
	
	public void filterByProtocol(List<String> tipiSoggetti,List<String> tipiServizi,Archive archive) throws ProtocolException {
		
		// soggetti
		if(archive.getSoggetti()!=null && archive.getSoggetti().size()>0) {
			List<ArchiveSoggetto> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getSoggetti().size(); i++) {
				if(archive.getSoggetti().get(i).getIdSoggetto()!=null &&
						tipiSoggetti.contains(archive.getSoggetti().get(i).getIdSoggetto().getTipo())) {
					listFiltrata.add(archive.getSoggetti().get(i));
				}
			}
			while(archive.getSoggetti().size()>0) {
				archive.getSoggetti().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveSoggetto archiveFiltrato : listFiltrata) {
					archive.getSoggetti().add(archiveFiltrato);		
				}
			}
		}
		
		// servizio applicativo
		if(archive.getServiziApplicativi()!=null && archive.getServiziApplicativi().size()>0) {
			List<ArchiveServizioApplicativo> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getServiziApplicativi().size(); i++) {
				if(archive.getServiziApplicativi().get(i).getIdSoggettoProprietario()!=null &&
						tipiSoggetti.contains(archive.getServiziApplicativi().get(i).getIdSoggettoProprietario().getTipo())) {
					listFiltrata.add(archive.getServiziApplicativi().get(i));
				}
			}
			while(archive.getServiziApplicativi().size()>0) {
				archive.getServiziApplicativi().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveServizioApplicativo archiveFiltrato : listFiltrata) {
					archive.getServiziApplicativi().add(archiveFiltrato);		
				}
			}
		}
		
		// porta delegata
		if(archive.getPorteDelegate()!=null && archive.getPorteDelegate().size()>0) {
			List<ArchivePortaDelegata> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getPorteDelegate().size(); i++) {
				if(archive.getPorteDelegate().get(i).getIdSoggettoProprietario()!=null &&
						tipiSoggetti.contains(archive.getPorteDelegate().get(i).getIdSoggettoProprietario().getTipo())) {
					listFiltrata.add(archive.getPorteDelegate().get(i));
				}
			}
			while(archive.getPorteDelegate().size()>0) {
				archive.getPorteDelegate().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchivePortaDelegata archiveFiltrato : listFiltrata) {
					archive.getPorteDelegate().add(archiveFiltrato);		
				}
			}
		}
		
		// porta applicativa
		if(archive.getPorteApplicative()!=null && archive.getPorteApplicative().size()>0) {
			List<ArchivePortaApplicativa> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getPorteApplicative().size(); i++) {
				if(archive.getPorteApplicative().get(i).getIdSoggettoProprietario()!=null &&
						tipiSoggetti.contains(archive.getPorteApplicative().get(i).getIdSoggettoProprietario().getTipo())) {
					listFiltrata.add(archive.getPorteApplicative().get(i));
				}
			}
			while(archive.getPorteApplicative().size()>0) {
				archive.getPorteApplicative().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchivePortaApplicativa archiveFiltrato : listFiltrata) {
					archive.getPorteApplicative().add(archiveFiltrato);		
				}
			}
		}
		
		// accordi cooperazione
		if(archive.getAccordiCooperazione()!=null && archive.getAccordiCooperazione().size()>0) {
			List<ArchiveAccordoCooperazione> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getAccordiCooperazione().size(); i++) {
				if(archive.getAccordiCooperazione().get(i).getIdSoggettoReferente()!=null &&
						tipiSoggetti.contains(archive.getAccordiCooperazione().get(i).getIdSoggettoReferente().getTipo())) {
					listFiltrata.add(archive.getAccordiCooperazione().get(i));
				}
			}
			while(archive.getAccordiCooperazione().size()>0) {
				archive.getAccordiCooperazione().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveAccordoCooperazione archiveFiltrato : listFiltrata) {
					archive.getAccordiCooperazione().add(archiveFiltrato);		
				}
			}
		}
		
		// accordi parte comune
		if(archive.getAccordiServizioParteComune()!=null && archive.getAccordiServizioParteComune().size()>0) {
			List<ArchiveAccordoServizioParteComune> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getAccordiServizioParteComune().size(); i++) {
				if(archive.getAccordiServizioParteComune().get(i).getIdSoggettoReferente()!=null &&
						tipiSoggetti.contains(archive.getAccordiServizioParteComune().get(i).getIdSoggettoReferente().getTipo())) {
					listFiltrata.add(archive.getAccordiServizioParteComune().get(i));
				}
			}
			while(archive.getAccordiServizioParteComune().size()>0) {
				archive.getAccordiServizioParteComune().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveAccordoServizioParteComune archiveFiltrato : listFiltrata) {
					archive.getAccordiServizioParteComune().add(archiveFiltrato);		
				}
			}
		}
		
		// accordi composto
		if(archive.getAccordiServizioComposto()!=null && archive.getAccordiServizioComposto().size()>0) {
			List<ArchiveAccordoServizioComposto> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getAccordiServizioComposto().size(); i++) {
				if(archive.getAccordiServizioComposto().get(i).getIdSoggettoReferente()!=null &&
						tipiSoggetti.contains(archive.getAccordiServizioComposto().get(i).getIdSoggettoReferente().getTipo())) {
					listFiltrata.add(archive.getAccordiServizioComposto().get(i));
				}
			}
			while(archive.getAccordiServizioComposto().size()>0) {
				archive.getAccordiServizioComposto().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveAccordoServizioComposto archiveFiltrato : listFiltrata) {
					archive.getAccordiServizioComposto().add(archiveFiltrato);		
				}
			}
		}
		
		// accordi parte specifica
		if(archive.getAccordiServizioParteSpecifica()!=null && archive.getAccordiServizioParteSpecifica().size()>0) {
			List<ArchiveAccordoServizioParteSpecifica> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getAccordiServizioParteSpecifica().size(); i++) {
				if(archive.getAccordiServizioParteSpecifica().get(i).getIdSoggettoErogatore()!=null &&
						tipiSoggetti.contains(archive.getAccordiServizioParteSpecifica().get(i).getIdSoggettoErogatore().getTipo())) {
					listFiltrata.add(archive.getAccordiServizioParteSpecifica().get(i));
				}
			}
			while(archive.getAccordiServizioParteSpecifica().size()>0) {
				archive.getAccordiServizioParteSpecifica().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveAccordoServizioParteSpecifica archiveFiltrato : listFiltrata) {
					archive.getAccordiServizioParteSpecifica().add(archiveFiltrato);		
				}
			}
		}
		
		// fruitori
		if(archive.getAccordiFruitori()!=null && archive.getAccordiFruitori().size()>0) {
			List<ArchiveFruitore> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getAccordiFruitori().size(); i++) {
				if(archive.getAccordiFruitori().get(i).getIdSoggettoFruitore()!=null &&
						tipiSoggetti.contains(archive.getAccordiFruitori().get(i).getIdSoggettoFruitore().getTipo())) {
					listFiltrata.add(archive.getAccordiFruitori().get(i));
				}
			}
			while(archive.getAccordiFruitori().size()>0) {
				archive.getAccordiFruitori().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveFruitore archiveFiltrato : listFiltrata) {
					archive.getAccordiFruitori().add(archiveFiltrato);		
				}
			}
		}
		
		// controllo del traffico
		if(archive.getControlloTraffico_activePolicies()!=null && archive.getControlloTraffico_activePolicies().size()>0) {
			List<ArchiveActivePolicy> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getControlloTraffico_activePolicies().size(); i++) {
				ArchiveActivePolicy archivePolicy = archive.getControlloTraffico_activePolicies().get(i);
				boolean filtra = false;
				if(archivePolicy.getPolicy().getFiltro()!=null) {
					if(archivePolicy.getPolicy().getFiltro().getTipoErogatore()!=null) {
						if(tipiSoggetti.contains(archivePolicy.getPolicy().getFiltro().getTipoErogatore())==false) {
							filtra = true;
						}
					}
					if(archivePolicy.getPolicy().getFiltro().getTipoFruitore()!=null) {
						if(tipiSoggetti.contains(archivePolicy.getPolicy().getFiltro().getTipoFruitore())==false) {
							filtra = true;
						}
					}
					if(archivePolicy.getPolicy().getFiltro().getTipoServizio()!=null) {
						if(tipiServizi.contains(archivePolicy.getPolicy().getFiltro().getTipoServizio())==false) {
							filtra = true;
						}
					}
				}
				if(!filtra) {
					listFiltrata.add(archivePolicy);
				}
			}
			while(archive.getControlloTraffico_activePolicies().size()>0) {
				archive.getControlloTraffico_activePolicies().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveActivePolicy archiveFiltrato : listFiltrata) {
					archive.getControlloTraffico_activePolicies().add(archiveFiltrato);		
				}
			}
		}
		
	}
	
	public void filterBySoggettoSelezionato(IDSoggetto idSoggettoSelezionato,Archive archive) throws ProtocolException {
		
		List<IDSoggetto> idSoggettiCoinvolti = new ArrayList<>();
		idSoggettiCoinvolti.add(idSoggettoSelezionato);
		
		List<IDServizio> idServiziCoinvolti = new ArrayList<>();
		List<IDServizioApplicativo> idServiziApplicativiCoinvolti = new ArrayList<>();
		List<IDAccordo> idAccordiCoinvolti = new ArrayList<>();
		List<IDAccordoCooperazione> idAccordiCooperazioneCoinvolti = new ArrayList<>();
			
	
		/* --  Raccolgo elementi riferiti dal soggetto selezionato  -- */
		
		// servizio applicativo
		if(archive.getServiziApplicativi()!=null && archive.getServiziApplicativi().size()>0) {
			for (int i = 0; i < archive.getServiziApplicativi().size(); i++) {
				if(archive.getServiziApplicativi().get(i).getIdSoggettoProprietario()!=null &&
						idSoggettoSelezionato.equals(archive.getServiziApplicativi().get(i).getIdSoggettoProprietario())) {
					
					IDServizioApplicativo idSA = archive.getServiziApplicativi().get(i).getIdServizioApplicativo();
					if(idServiziApplicativiCoinvolti.contains(idSA)==false) {
						idServiziApplicativiCoinvolti.add(idSA);
					}
				}
			}
		}
		
		// porta delegata
		if(archive.getPorteDelegate()!=null && archive.getPorteDelegate().size()>0) {
			for (int i = 0; i < archive.getPorteDelegate().size(); i++) {
				if(archive.getPorteDelegate().get(i).getIdSoggettoProprietario()!=null &&
						idSoggettoSelezionato.equals(archive.getPorteDelegate().get(i).getIdSoggettoProprietario())) {
					
					IDServizio idServizio = archive.getPorteDelegate().get(i).getIdPortaDelegata().getIdentificativiFruizione().getIdServizio();
					IDSoggetto idSoggettoErogatore = idServizio.getSoggettoErogatore();
					if(idSoggettiCoinvolti.contains(idSoggettoErogatore)==false) {
						idSoggettiCoinvolti.add(idSoggettoErogatore);
					}
					if(idServiziCoinvolti.contains(idServizio)==false) {
						idServiziCoinvolti.add(idServizio);
					}
				}
			}
		}
		
		// porta applicativa
		if(archive.getPorteApplicative()!=null && archive.getPorteApplicative().size()>0) {
			for (int i = 0; i < archive.getPorteApplicative().size(); i++) {
				if(archive.getPorteApplicative().get(i).getIdSoggettoProprietario()!=null &&
						idSoggettoSelezionato.equals(archive.getPorteApplicative().get(i).getIdSoggettoProprietario())) {
					
					PortaApplicativa pa = archive.getPorteApplicative().get(i).getPortaApplicativa();
					if(pa.getSoggetti()!=null && pa.getSoggetti().sizeSoggettoList()>0) {
						for (int j = 0; j < pa.getSoggetti().sizeSoggettoList(); j++) {
							PortaApplicativaAutorizzazioneSoggetto authSoggetto = pa.getSoggetti().getSoggetto(j);
							IDSoggetto idSoggettoAutorizzato = new IDSoggetto(authSoggetto.getTipo(), authSoggetto.getNome());
							if(idSoggettiCoinvolti.contains(idSoggettoAutorizzato)==false) {
								idSoggettiCoinvolti.add(idSoggettoAutorizzato);
							}
						}
					}
					if(pa.getServiziApplicativiAutorizzati()!=null && pa.getServiziApplicativiAutorizzati().sizeServizioApplicativoList()>0) {
						for (int j = 0; j < pa.getServiziApplicativiAutorizzati().sizeServizioApplicativoList(); j++) {
							PortaApplicativaAutorizzazioneServizioApplicativo authSA = pa.getServiziApplicativiAutorizzati().getServizioApplicativo(j);
							IDSoggetto idSoggettoProprietarioSAAutorizzato = new IDSoggetto(authSA.getTipoSoggettoProprietario(), authSA.getNomeSoggettoProprietario());
							if(idSoggettiCoinvolti.contains(idSoggettoProprietarioSAAutorizzato)==false) {
								idSoggettiCoinvolti.add(idSoggettoProprietarioSAAutorizzato);
							}
							IDServizioApplicativo idSAAutorizzato = new IDServizioApplicativo();
							idSAAutorizzato.setIdSoggettoProprietario(idSoggettoProprietarioSAAutorizzato);
							idSAAutorizzato.setNome(authSA.getNome());
							if(idServiziApplicativiCoinvolti.contains(idSAAutorizzato)==false) {
								idServiziApplicativiCoinvolti.add(idSAAutorizzato);
							}
						}
					}
				}
			}
		}
		
		// accordi cooperazione
		if(archive.getAccordiCooperazione()!=null && archive.getAccordiCooperazione().size()>0) {
			for (int i = 0; i < archive.getAccordiCooperazione().size(); i++) {
				if(archive.getAccordiCooperazione().get(i).getIdSoggettoReferente()!=null &&
						idSoggettoSelezionato.equals(archive.getAccordiCooperazione().get(i).getIdSoggettoReferente())) {
					
					IDAccordoCooperazione idAC = archive.getAccordiCooperazione().get(i).getIdAccordoCooperazione();
					if(idAccordiCooperazioneCoinvolti.contains(idAC)==false) {
						idAccordiCooperazioneCoinvolti.add(idAC);
					} 
					
					IDSoggetto idSoggettoReferente = archive.getAccordiCooperazione().get(i).getIdSoggettoReferente();
					if(idSoggettiCoinvolti.contains(idSoggettoReferente)==false) {
						idSoggettiCoinvolti.add(idSoggettoReferente);
					}
				}
			}
		}
		
		// accordi parte comune (raccolgo solo elementi riferiti, l'eliminazione la faccio dopo)
		if(archive.getAccordiServizioParteComune()!=null && archive.getAccordiServizioParteComune().size()>0) {
			for (int i = 0; i < archive.getAccordiServizioParteComune().size(); i++) {
				if(archive.getAccordiServizioParteComune().get(i).getIdSoggettoReferente()!=null &&
						idSoggettoSelezionato.equals(archive.getAccordiServizioParteComune().get(i).getIdSoggettoReferente())) {
					
					IDAccordo idAccordo = archive.getAccordiServizioParteComune().get(i).getIdAccordoServizioParteComune();
					if(idAccordiCoinvolti.contains(idAccordo)==false) {
						idAccordiCoinvolti.add(idAccordo);
					}
					
					IDSoggetto idSoggettoReferente = archive.getAccordiServizioParteComune().get(i).getIdSoggettoReferente();
					if(idSoggettiCoinvolti.contains(idSoggettoReferente)==false) {
						idSoggettiCoinvolti.add(idSoggettoReferente);
					}
				}
			}
		}
		
		// accordi composto  (raccolgo solo elementi riferiti, l'eliminazione la faccio dopo)
		if(archive.getAccordiServizioComposto()!=null && archive.getAccordiServizioComposto().size()>0) {
			for (int i = 0; i < archive.getAccordiServizioComposto().size(); i++) {
				if(archive.getAccordiServizioComposto().get(i).getIdSoggettoReferente()!=null &&
						idSoggettoSelezionato.equals(archive.getAccordiServizioComposto().get(i).getIdSoggettoReferente())) {
					
					IDAccordo idAccordo = archive.getAccordiServizioComposto().get(i).getIdAccordoServizioParteComune();
					if(idAccordiCoinvolti.contains(idAccordo)==false) {
						idAccordiCoinvolti.add(idAccordo);
					}
					
					IDSoggetto idSoggettoReferente = archive.getAccordiServizioComposto().get(i).getIdSoggettoReferente();
					if(idSoggettiCoinvolti.contains(idSoggettoReferente)==false) {
						idSoggettiCoinvolti.add(idSoggettoReferente);
					}
					
					AccordoServizioParteComune apc = archive.getAccordiServizioComposto().get(i).getAccordoServizioParteComune();
					if(apc.getServizioComposto()!=null) {
						if(apc.getServizioComposto().sizeServizioComponenteList()>0) {
							for (int j = 0; j < apc.getServizioComposto().sizeServizioComponenteList(); j++) {
								AccordoServizioParteComuneServizioCompostoServizioComponente componente = apc.getServizioComposto().getServizioComponente(j);
								try {
									IDServizio idServizioComponente = IDServizioFactory.getInstance().getIDServizioFromValues(componente.getTipo(), componente.getNome(), 
											componente.getTipoSoggetto(), componente.getNomeSoggetto(), componente.getVersione());
									if(idServiziCoinvolti.contains(idServizioComponente)==false) {
										idServiziCoinvolti.add(idServizioComponente);
									}
								}catch(Exception e) {
									ControlStationCore.logError("AccordoServizioComposto ["+idAccordo+"]: "+e.getMessage(), e);
								}
							}
						}
						if(apc.getServizioComposto().getAccordoCooperazione()!=null) {
							String uriAC = apc.getServizioComposto().getAccordoCooperazione();
							try {
								IDAccordoCooperazione idAC = IDAccordoCooperazioneFactory.getInstance().getIDAccordoFromUri(uriAC);
								if(idAccordiCooperazioneCoinvolti.contains(idAC)==false) {
									idAccordiCooperazioneCoinvolti.add(idAC);
								} 
							}catch(Exception e) {
								ControlStationCore.logError("AccordoServizioComposto ["+idAccordo+"]: "+e.getMessage(), e);
							}
						}
					}
				}
			}
		}
			
		// accordi parte specifica (raccolgo solo elementi riferiti, l'eliminazione la faccio dopo)
		if(archive.getAccordiServizioParteSpecifica()!=null && archive.getAccordiServizioParteSpecifica().size()>0) {
			for (int i = 0; i < archive.getAccordiServizioParteSpecifica().size(); i++) {
				if(archive.getAccordiServizioParteSpecifica().get(i).getIdSoggettoErogatore()!=null &&
						idSoggettoSelezionato.equals(archive.getAccordiServizioParteSpecifica().get(i).getIdSoggettoErogatore())) {
					
					IDServizio idServizio =  archive.getAccordiServizioParteSpecifica().get(i).getIdAccordoServizioParteSpecifica();
					if(idServiziCoinvolti.contains(idServizio)==false) {
						idServiziCoinvolti.add(idServizio);
					}
					
					String uriAccordoServizioParteComune = archive.getAccordiServizioParteSpecifica().get(i).getAccordoServizioParteSpecifica().getAccordoServizioParteComune();
					try {
						IDAccordo idApc = IDAccordoFactory.getInstance().getIDAccordoFromUri(uriAccordoServizioParteComune);
						if(idAccordiCoinvolti.contains(idApc)==false) {
							idAccordiCoinvolti.add(idApc);
						}
					}catch(Exception e) {
						ControlStationCore.logError("AccordoServizioParteSpecifica ["+idServizio+"]: "+e.getMessage(), e);
					}
				}
			}
		}
		
		// fruitori
		if(archive.getAccordiFruitori()!=null && archive.getAccordiFruitori().size()>0) {
			for (int i = 0; i < archive.getAccordiFruitori().size(); i++) {
				if(archive.getAccordiFruitori().get(i).getIdSoggettoFruitore()!=null &&
						idSoggettoSelezionato.equals(archive.getAccordiFruitori().get(i).getIdSoggettoFruitore())) {
					
					IDServizio idServizio =  archive.getAccordiFruitori().get(i).getIdAccordoServizioParteSpecifica();
					IDSoggetto idSoggettoErogatore = idServizio.getSoggettoErogatore();
					if(idSoggettiCoinvolti.contains(idSoggettoErogatore)==false) {
						idSoggettiCoinvolti.add(idSoggettoErogatore);
					}
					if(idServiziCoinvolti.contains(idServizio)==false) {
						idServiziCoinvolti.add(idServizio);
					}
				}
			}
		}
		
		
		
		
		
		
		/* Filtro elementi */
		
		// soggetti
		if(archive.getSoggetti()!=null && archive.getSoggetti().size()>0) {
			List<ArchiveSoggetto> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getSoggetti().size(); i++) {
				if(archive.getSoggetti().get(i).getIdSoggetto()!=null &&
						idSoggettiCoinvolti.contains(archive.getSoggetti().get(i).getIdSoggetto())) {
					listFiltrata.add(archive.getSoggetti().get(i));
				}
			}
			while(archive.getSoggetti().size()>0) {
				archive.getSoggetti().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveSoggetto archiveFiltrato : listFiltrata) {
					archive.getSoggetti().add(archiveFiltrato);		
				}
			}
		}
		
		// servizio applicativo
		if(archive.getServiziApplicativi()!=null && archive.getServiziApplicativi().size()>0) {
			List<ArchiveServizioApplicativo> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getServiziApplicativi().size(); i++) {
				if(archive.getServiziApplicativi().get(i).getIdSoggettoProprietario()!=null &&
						idServiziApplicativiCoinvolti.contains(archive.getServiziApplicativi().get(i).getIdServizioApplicativo())) {
					listFiltrata.add(archive.getServiziApplicativi().get(i));
				}
			}
			while(archive.getServiziApplicativi().size()>0) {
				archive.getServiziApplicativi().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveServizioApplicativo archiveFiltrato : listFiltrata) {
					archive.getServiziApplicativi().add(archiveFiltrato);		
				}
			}
		}
		
		// porta delegata
		if(archive.getPorteDelegate()!=null && archive.getPorteDelegate().size()>0) {
			List<ArchivePortaDelegata> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getPorteDelegate().size(); i++) {
				if(archive.getPorteDelegate().get(i).getIdSoggettoProprietario()!=null &&
						idSoggettoSelezionato.equals(archive.getPorteDelegate().get(i).getIdSoggettoProprietario())) {
					listFiltrata.add(archive.getPorteDelegate().get(i));
				}
			}
			while(archive.getPorteDelegate().size()>0) {
				archive.getPorteDelegate().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchivePortaDelegata archiveFiltrato : listFiltrata) {
					archive.getPorteDelegate().add(archiveFiltrato);		
				}
			}
		}
		
		// porta applicativa
		if(archive.getPorteApplicative()!=null && archive.getPorteApplicative().size()>0) {
			List<ArchivePortaApplicativa> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getPorteApplicative().size(); i++) {
				if(archive.getPorteApplicative().get(i).getIdSoggettoProprietario()!=null &&
						idSoggettoSelezionato.equals(archive.getPorteApplicative().get(i).getIdSoggettoProprietario())) {
					listFiltrata.add(archive.getPorteApplicative().get(i));
				}
			}
			while(archive.getPorteApplicative().size()>0) {
				archive.getPorteApplicative().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchivePortaApplicativa archiveFiltrato : listFiltrata) {
					archive.getPorteApplicative().add(archiveFiltrato);		
				}
			}
		}
		
		// accordi cooperazione
		if(archive.getAccordiCooperazione()!=null && archive.getAccordiCooperazione().size()>0) {
			List<ArchiveAccordoCooperazione> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getAccordiCooperazione().size(); i++) {
				if(archive.getAccordiCooperazione().get(i).getIdSoggettoReferente()!=null &&
						idAccordiCooperazioneCoinvolti.contains(archive.getAccordiCooperazione().get(i).getIdAccordoCooperazione())) {
					listFiltrata.add(archive.getAccordiCooperazione().get(i));
				}
			}
			while(archive.getAccordiCooperazione().size()>0) {
				archive.getAccordiCooperazione().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveAccordoCooperazione archiveFiltrato : listFiltrata) {
					archive.getAccordiCooperazione().add(archiveFiltrato);		
				}
			}
		}
		
		// accordi parte comune
		if(archive.getAccordiServizioParteComune()!=null && archive.getAccordiServizioParteComune().size()>0) {
			List<ArchiveAccordoServizioParteComune> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getAccordiServizioParteComune().size(); i++) {
				if(archive.getAccordiServizioParteComune().get(i).getIdSoggettoReferente()!=null &&
						idAccordiCoinvolti.contains(archive.getAccordiServizioParteComune().get(i).getIdAccordoServizioParteComune())) {
					listFiltrata.add(archive.getAccordiServizioParteComune().get(i));
				}
			}
			while(archive.getAccordiServizioParteComune().size()>0) {
				archive.getAccordiServizioParteComune().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveAccordoServizioParteComune archiveFiltrato : listFiltrata) {
					archive.getAccordiServizioParteComune().add(archiveFiltrato);		
				}
			}
		}
		
		// accordi composto
		if(archive.getAccordiServizioComposto()!=null && archive.getAccordiServizioComposto().size()>0) {
			List<ArchiveAccordoServizioComposto> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getAccordiServizioComposto().size(); i++) {
				if(archive.getAccordiServizioComposto().get(i).getIdSoggettoReferente()!=null &&
						idAccordiCoinvolti.contains(archive.getAccordiServizioComposto().get(i).getIdAccordoServizioParteComune())) {
					listFiltrata.add(archive.getAccordiServizioComposto().get(i));
				}
			}
			while(archive.getAccordiServizioComposto().size()>0) {
				archive.getAccordiServizioComposto().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveAccordoServizioComposto archiveFiltrato : listFiltrata) {
					archive.getAccordiServizioComposto().add(archiveFiltrato);		
				}
			}
		}
		
		// accordi parte specifica
		if(archive.getAccordiServizioParteSpecifica()!=null && archive.getAccordiServizioParteSpecifica().size()>0) {
			List<ArchiveAccordoServizioParteSpecifica> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getAccordiServizioParteSpecifica().size(); i++) {
				if(archive.getAccordiServizioParteSpecifica().get(i).getIdSoggettoErogatore()!=null &&
						idServiziCoinvolti.contains(archive.getAccordiServizioParteSpecifica().get(i).getIdAccordoServizioParteSpecifica())) {
					listFiltrata.add(archive.getAccordiServizioParteSpecifica().get(i));
				}
			}
			while(archive.getAccordiServizioParteSpecifica().size()>0) {
				archive.getAccordiServizioParteSpecifica().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveAccordoServizioParteSpecifica archiveFiltrato : listFiltrata) {
					archive.getAccordiServizioParteSpecifica().add(archiveFiltrato);		
				}
			}
		}
		

		// fruitori
		if(archive.getAccordiFruitori()!=null && archive.getAccordiFruitori().size()>0) {
			List<ArchiveFruitore> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getAccordiFruitori().size(); i++) {
				if(archive.getAccordiFruitori().get(i).getIdSoggettoFruitore()!=null &&
						idSoggettoSelezionato.equals(archive.getAccordiFruitori().get(i).getIdSoggettoFruitore())) {
					listFiltrata.add(archive.getAccordiFruitori().get(i));
				}
			}
			while(archive.getAccordiFruitori().size()>0) {
				archive.getAccordiFruitori().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveFruitore archiveFiltrato : listFiltrata) {
					archive.getAccordiFruitori().add(archiveFiltrato);		
				}
			}
		}

		
		// controllo del traffico
		if(archive.getControlloTraffico_activePolicies()!=null && archive.getControlloTraffico_activePolicies().size()>0) {
			List<ArchiveActivePolicy> listFiltrata = new ArrayList<>();
			for (int i = 0; i < archive.getControlloTraffico_activePolicies().size(); i++) {
				ArchiveActivePolicy archivePolicy = archive.getControlloTraffico_activePolicies().get(i);
				boolean filtra = false;
				if(archivePolicy.getPolicy().getFiltro()!=null) {
					IDSoggetto idSoggettoErogatore = null;
					if(archivePolicy.getPolicy().getFiltro().getTipoErogatore()!=null && archivePolicy.getPolicy().getFiltro().getNomeErogatore()!=null) {
						idSoggettoErogatore = new IDSoggetto(archivePolicy.getPolicy().getFiltro().getTipoErogatore(), archivePolicy.getPolicy().getFiltro().getNomeErogatore());
						if(idSoggettiCoinvolti.contains(idSoggettoErogatore)==false) {
							filtra = true;
						}
					}
					if(archivePolicy.getPolicy().getFiltro().getTipoFruitore()!=null && archivePolicy.getPolicy().getFiltro().getNomeFruitore()!=null) {
						IDSoggetto idSoggettoFruitore = new IDSoggetto(archivePolicy.getPolicy().getFiltro().getTipoFruitore(), archivePolicy.getPolicy().getFiltro().getNomeFruitore());
						if(idSoggettiCoinvolti.contains(idSoggettoFruitore)==false) {
							filtra = true;
						}
					}
					if(idSoggettoErogatore!=null && 
							archivePolicy.getPolicy().getFiltro().getTipoServizio()!=null &&
							archivePolicy.getPolicy().getFiltro().getNomeServizio()!=null &&
							archivePolicy.getPolicy().getFiltro().getVersioneServizio()!=null) {
						try {
							IDServizio idServizio = IDServizioFactory.getInstance().getIDServizioFromValues(archivePolicy.getPolicy().getFiltro().getTipoServizio(), 
									archivePolicy.getPolicy().getFiltro().getNomeServizio(), 
									idSoggettoErogatore, 
									archivePolicy.getPolicy().getFiltro().getVersioneServizio());
							if(idServiziCoinvolti.contains(idServizio)==false) {
								filtra = true;
							}
						}catch(Exception e) {
							ControlStationCore.logError("ControlloTraffico activePolicies ["+archivePolicy.getNomePolicy()+"]: "+e.getMessage(), e);
						}
					}
				}
				if(!filtra) {
					listFiltrata.add(archivePolicy);
				}
			}
			while(archive.getControlloTraffico_activePolicies().size()>0) {
				archive.getControlloTraffico_activePolicies().remove(0);
			}
			if(listFiltrata.size()>0) {
				for (ArchiveActivePolicy archiveFiltrato : listFiltrata) {
					archive.getControlloTraffico_activePolicies().add(archiveFiltrato);		
				}
			}
		}
		
	}
}
