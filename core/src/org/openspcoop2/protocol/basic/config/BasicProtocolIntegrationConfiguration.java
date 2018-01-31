/*
 * OpenSPCoop - Customizable API Gateway 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2018 Link.it srl (http://link.it). 
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

package org.openspcoop2.protocol.basic.config;

import java.util.List;

import org.openspcoop2.core.config.PortaApplicativa;
import org.openspcoop2.core.config.PortaDelegata;
import org.openspcoop2.core.config.constants.PortaApplicativaAzioneIdentificazione;
import org.openspcoop2.core.config.constants.PortaDelegataAzioneIdentificazione;
import org.openspcoop2.core.id.IDServizio;
import org.openspcoop2.core.id.IDSoggetto;
import org.openspcoop2.message.constants.ServiceBinding;
import org.openspcoop2.protocol.basic.BasicComponentFactory;
import org.openspcoop2.protocol.sdk.IProtocolFactory;
import org.openspcoop2.protocol.sdk.ProtocolException;
import org.openspcoop2.protocol.sdk.config.Implementation;
import org.openspcoop2.protocol.sdk.config.Subscription;

/**
 * Classe che implementa, l'interfaccia {@link org.openspcoop2.protocol.sdk.config.IProtocolConfiguration} 
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author: apoli $
 * @version $Rev: 13574 $, $Date: 2018-01-26 12:24:34 +0100 (Fri, 26 Jan 2018) $
 */
public class BasicProtocolIntegrationConfiguration extends BasicComponentFactory implements org.openspcoop2.protocol.sdk.config.IProtocolIntegrationConfiguration {

	private ImplementationConfiguration implementationConfigurationRest;
	private ImplementationConfiguration implementationConfigurationSoap;
	private SubscriptionConfiguration subscriptionConfigurationRest;
	private SubscriptionConfiguration subscriptionConfigurationSoap;

	public BasicProtocolIntegrationConfiguration(IProtocolFactory<?> factory) throws ProtocolException {
		super(factory);
		if(this.protocolFactory.getManifest().getBinding().getRest()!=null) {
			this.implementationConfigurationRest = new ImplementationConfiguration(this.protocolFactory.getManifest().getBinding().getRest().getIntegration().getImplementation());
			this.subscriptionConfigurationRest = new SubscriptionConfiguration(this.protocolFactory.getManifest().getBinding().getRest().getIntegration().getSubscription());
		}
		if(this.protocolFactory.getManifest().getBinding().getSoap()!=null) {
			this.implementationConfigurationSoap = new ImplementationConfiguration(this.protocolFactory.getManifest().getBinding().getSoap().getIntegration().getImplementation());
			this.subscriptionConfigurationSoap = new SubscriptionConfiguration(this.protocolFactory.getManifest().getBinding().getSoap().getIntegration().getSubscription());
		}
	}

	// SUBSCRIPTION
	
	@Override
	public Subscription createDefaultSubscription(ServiceBinding serviceBinding, IDSoggetto idFruitore, IDServizio idServizio) throws ProtocolException{
		if(serviceBinding==null){
			throw new ProtocolException("Service Binding undefined");
		}
		switch (serviceBinding) {
		case REST:
			if(this.subscriptionConfigurationRest==null) {
				throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
			}
			return this.subscriptionConfigurationRest.createDefaultSubscription(idFruitore, idServizio);
		case SOAP:
			if(this.subscriptionConfigurationSoap==null) {
				throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
			}
			return this.subscriptionConfigurationSoap.createDefaultSubscription(idFruitore, idServizio);
		}
		throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
	}
	
	@Override
	public Subscription createSubscription(ServiceBinding serviceBinding, IDSoggetto idFruitore, IDServizio idServizio,
			PortaDelegata portaDelegataDefault, 
			String ruleName, String ... azione ) throws ProtocolException{
		return this.createSubscription(serviceBinding, idFruitore, idServizio, 
				portaDelegataDefault, null, 
				ruleName, azione);
	}
	@Override
	public Subscription createSubscription(ServiceBinding serviceBinding, IDSoggetto idFruitore, IDServizio idServizio,
			PortaDelegata portaDelegataDefault, PortaDelegata portaDelegataDaCopiare,
			String ruleName, String ... azione ) throws ProtocolException{
		if(serviceBinding==null){
			throw new ProtocolException("Service Binding undefined");
		}
		switch (serviceBinding) {
		case REST:
			if(this.subscriptionConfigurationRest==null) {
				throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
			}
			return this.subscriptionConfigurationRest.createSubscription(idFruitore, idServizio, portaDelegataDefault, portaDelegataDaCopiare, ruleName, azione);
		case SOAP:
			if(this.subscriptionConfigurationSoap==null) {
				throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
			}
			return this.subscriptionConfigurationSoap.createSubscription(idFruitore, idServizio, portaDelegataDefault, portaDelegataDaCopiare, ruleName, azione);
		}
		throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
	}
	
	@Override
	public List<PortaDelegataAzioneIdentificazione> getAllSubscriptionIdentificationResourceModes(ServiceBinding serviceBinding) throws ProtocolException{
		if(serviceBinding==null){
			throw new ProtocolException("Service Binding undefined");
		}
		switch (serviceBinding) {
		case REST:
			if(this.subscriptionConfigurationRest==null) {
				throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
			}
			return this.subscriptionConfigurationRest.supportedIdentificationModes();
		case SOAP:
			if(this.subscriptionConfigurationSoap==null) {
				throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
			}
			return this.subscriptionConfigurationSoap.supportedIdentificationModes();
		}
		throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
	}
	
	
	// IMPLEMENTATION
	
	@Override
	public Implementation createDefaultImplementation(ServiceBinding serviceBinding, IDServizio idServizio) throws ProtocolException{
		if(serviceBinding==null){
			throw new ProtocolException("Service Binding undefined");
		}
		switch (serviceBinding) {
		case REST:
			if(this.implementationConfigurationRest==null) {
				throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
			}
			return this.implementationConfigurationRest.createDefaultImplementation(idServizio);
		case SOAP:
			if(this.implementationConfigurationSoap==null) {
				throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
			}
			return this.implementationConfigurationSoap.createDefaultImplementation(idServizio);
		}
		throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
	}
	
	@Override
	public Implementation createImplementation(ServiceBinding serviceBinding, IDServizio idServizio,
			PortaApplicativa portaApplicativaDefault, 
			String ruleName, String ... azione ) throws ProtocolException{
		return this.createImplementation(serviceBinding, idServizio, 
				portaApplicativaDefault, null, 
				ruleName, azione);
	}
	@Override
	public Implementation createImplementation(ServiceBinding serviceBinding, IDServizio idServizio,
			PortaApplicativa portaApplicativaDefault, PortaApplicativa portaApplicativaDaCopiare,
			String ruleName, String ... azione ) throws ProtocolException{
		if(serviceBinding==null){
			throw new ProtocolException("Service Binding undefined");
		}
		switch (serviceBinding) {
		case REST:
			if(this.implementationConfigurationRest==null) {
				throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
			}
			return this.implementationConfigurationRest.createImplementation(idServizio, portaApplicativaDefault, portaApplicativaDaCopiare, ruleName, azione);
		case SOAP:
			if(this.implementationConfigurationSoap==null) {
				throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
			}
			return this.implementationConfigurationSoap.createImplementation(idServizio, portaApplicativaDefault, portaApplicativaDaCopiare, ruleName, azione);
		}
		throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
	}
	
	@Override
	public List<PortaApplicativaAzioneIdentificazione> getAllImplementationIdentificationResourceModes(ServiceBinding serviceBinding) throws ProtocolException{
		if(serviceBinding==null){
			throw new ProtocolException("Service Binding undefined");
		}
		switch (serviceBinding) {
		case REST:
			if(this.implementationConfigurationRest==null) {
				throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
			}
			return this.implementationConfigurationRest.supportedIdentificationModes();
		case SOAP:
			if(this.implementationConfigurationSoap==null) {
				throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
			}
			return this.implementationConfigurationSoap.supportedIdentificationModes();
		}
		throw new ProtocolException("Service Binding '"+serviceBinding+"' unsupported");
	}
	
}