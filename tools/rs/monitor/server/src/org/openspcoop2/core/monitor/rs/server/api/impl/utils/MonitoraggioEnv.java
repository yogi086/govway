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

package org.openspcoop2.core.monitor.rs.server.api.impl.utils;

import org.openspcoop2.core.id.IDSoggetto;
import org.openspcoop2.core.monitor.rs.server.config.ServerProperties;
import org.openspcoop2.protocol.engine.ProtocolFactoryManager;
import org.openspcoop2.protocol.sdk.ProtocolException;
import org.openspcoop2.utils.UtilsException;
import org.openspcoop2.utils.service.beans.ProfiloEnum;
import org.openspcoop2.utils.service.beans.utils.BaseHelper;
import org.openspcoop2.utils.service.beans.utils.ProfiloUtils;
import org.openspcoop2.utils.service.context.IContext;
import org.slf4j.Logger;

/**
 * MonitoraggioEnv
 * 
 * @author $Author$
 * @version $Rev$, $Date$
 * 
 */
public class MonitoraggioEnv {
	
	public final IContext context;
	public final ProfiloEnum profilo;
	public final IDSoggetto soggetto;
	public final Logger log;
	public final String tipo_protocollo;
	public final ProtocolFactoryManager protocolFactoryMgr;

	
	public MonitoraggioEnv(IContext context, ProfiloEnum profilo, String nome_soggetto, Logger log) throws UtilsException, ProtocolException {
		this.context = context;
		
		if (profilo == null) {
			this.profilo = ProfiloUtils.getMapProtocolloToProfilo().get(ServerProperties.getInstance().getProtocolloDefault());
		} else {
			this.profilo = profilo;
		}
		
		if (nome_soggetto == null) {
			nome_soggetto = ServerProperties.getInstance().getSoggettoDefault(ProfiloUtils.toProtocollo(profilo));
		}
		String tipo_soggetto = ProtocolFactoryManager.getInstance().getDefaultOrganizationTypes().get(Converter.toProtocollo(profilo));
		this.soggetto = new IDSoggetto(tipo_soggetto, nome_soggetto);
		
		this.log = log;
		
		this.tipo_protocollo = BaseHelper.tipoProtocolloFromProfilo.get(this.profilo);
		this.protocolFactoryMgr = ProtocolFactoryManager.getInstance();
	}

}
