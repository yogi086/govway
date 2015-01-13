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
package org.openspcoop2.core.config.ws.server.filter.beans;

/**
 * <p>Java class for RispostaAsincrona complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="risposta-asincrona">
 *     &lt;sequence>
 *         &lt;element name="credenziali" type="{http://www.openspcoop2.org/core/config/management}credenziali" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="connettore" type="{http://www.openspcoop2.org/core/config/management}connettore" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="sbustamento-soap" type="{http://www.openspcoop2.org/core/config}StatoFunzionalita" minOccurs="0" maxOccurs="1" default="(StatoFunzionalita) StatoFunzionalita.toEnumConstantFromString("disabilitato")" />
 *         &lt;element name="sbustamento-informazioni-protocollo" type="{http://www.openspcoop2.org/core/config}StatoFunzionalita" minOccurs="0" maxOccurs="1" default="(StatoFunzionalita) StatoFunzionalita.toEnumConstantFromString("abilitato")" />
 *         &lt;element name="get-message" type="{http://www.openspcoop2.org/core/config}StatoFunzionalita" minOccurs="0" maxOccurs="1" default="(StatoFunzionalita) StatoFunzionalita.toEnumConstantFromString("disabilitato")" />
 *         &lt;element name="autenticazione" type="{http://www.openspcoop2.org/core/config}InvocazioneServizioTipoAutenticazione" minOccurs="0" maxOccurs="1" default="(InvocazioneServizioTipoAutenticazione) InvocazioneServizioTipoAutenticazione.toEnumConstantFromString("none")" />
 *         &lt;element name="invio-per-riferimento" type="{http://www.openspcoop2.org/core/config}StatoFunzionalita" minOccurs="0" maxOccurs="1" default="(StatoFunzionalita) StatoFunzionalita.toEnumConstantFromString("disabilitato")" />
 *         &lt;element name="risposta-per-riferimento" type="{http://www.openspcoop2.org/core/config}StatoFunzionalita" minOccurs="0" maxOccurs="1" default="(StatoFunzionalita) StatoFunzionalita.toEnumConstantFromString("disabilitato")" />
 *     &lt;/sequence>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
 
 import java.io.Serializable;
 
import javax.xml.bind.annotation.XmlElement;
import org.openspcoop2.core.config.constants.StatoFunzionalita;
import org.openspcoop2.core.config.constants.InvocazioneServizioTipoAutenticazione;
import org.openspcoop2.core.config.ws.server.filter.beans.Credenziali;
import org.openspcoop2.core.config.ws.server.filter.beans.Connettore;

/**     
 * RispostaAsincrona
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
@javax.xml.bind.annotation.XmlType(name = "risposta-asincrona", namespace="http://www.openspcoop2.org/core/config/management", propOrder = {
    "credenziali",
    "connettore",
    "sbustamentoSoap",
    "sbustamentoInformazioniProtocollo",
    "getMessage",
    "autenticazione",
    "invioPerRiferimento",
    "rispostaPerRiferimento"
})
@javax.xml.bind.annotation.XmlRootElement(name = "risposta-asincrona")
public class RispostaAsincrona extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable  {
	
	private static final long serialVersionUID = -1L;

	
	
	@XmlElement(name="credenziali",required=false,nillable=false)
	private Credenziali credenziali;
	
	public void setCredenziali(Credenziali credenziali){
		this.credenziali = credenziali;
	}
	
	public Credenziali getCredenziali(){
		return this.credenziali;
	}
	
	
	@XmlElement(name="connettore",required=false,nillable=false)
	private Connettore connettore;
	
	public void setConnettore(Connettore connettore){
		this.connettore = connettore;
	}
	
	public Connettore getConnettore(){
		return this.connettore;
	}
	
	
	@XmlElement(name="sbustamento-soap",required=false,nillable=false,defaultValue="disabilitato")
	private StatoFunzionalita sbustamentoSoap = (StatoFunzionalita) StatoFunzionalita.toEnumConstantFromString("disabilitato");
	
	public void setSbustamentoSoap(StatoFunzionalita sbustamentoSoap){
		this.sbustamentoSoap = sbustamentoSoap;
	}
	
	public StatoFunzionalita getSbustamentoSoap(){
		return this.sbustamentoSoap;
	}
	
	
	@XmlElement(name="sbustamento-informazioni-protocollo",required=false,nillable=false,defaultValue="abilitato")
	private StatoFunzionalita sbustamentoInformazioniProtocollo = (StatoFunzionalita) StatoFunzionalita.toEnumConstantFromString("abilitato");
	
	public void setSbustamentoInformazioniProtocollo(StatoFunzionalita sbustamentoInformazioniProtocollo){
		this.sbustamentoInformazioniProtocollo = sbustamentoInformazioniProtocollo;
	}
	
	public StatoFunzionalita getSbustamentoInformazioniProtocollo(){
		return this.sbustamentoInformazioniProtocollo;
	}
	
	
	@XmlElement(name="get-message",required=false,nillable=false,defaultValue="disabilitato")
	private StatoFunzionalita getMessage = (StatoFunzionalita) StatoFunzionalita.toEnumConstantFromString("disabilitato");
	
	public void setGetMessage(StatoFunzionalita getMessage){
		this.getMessage = getMessage;
	}
	
	public StatoFunzionalita getGetMessage(){
		return this.getMessage;
	}
	
	
	@XmlElement(name="autenticazione",required=false,nillable=false,defaultValue="none")
	private InvocazioneServizioTipoAutenticazione autenticazione = (InvocazioneServizioTipoAutenticazione) InvocazioneServizioTipoAutenticazione.toEnumConstantFromString("none");
	
	public void setAutenticazione(InvocazioneServizioTipoAutenticazione autenticazione){
		this.autenticazione = autenticazione;
	}
	
	public InvocazioneServizioTipoAutenticazione getAutenticazione(){
		return this.autenticazione;
	}
	
	
	@XmlElement(name="invio-per-riferimento",required=false,nillable=false,defaultValue="disabilitato")
	private StatoFunzionalita invioPerRiferimento = (StatoFunzionalita) StatoFunzionalita.toEnumConstantFromString("disabilitato");
	
	public void setInvioPerRiferimento(StatoFunzionalita invioPerRiferimento){
		this.invioPerRiferimento = invioPerRiferimento;
	}
	
	public StatoFunzionalita getInvioPerRiferimento(){
		return this.invioPerRiferimento;
	}
	
	
	@XmlElement(name="risposta-per-riferimento",required=false,nillable=false,defaultValue="disabilitato")
	private StatoFunzionalita rispostaPerRiferimento = (StatoFunzionalita) StatoFunzionalita.toEnumConstantFromString("disabilitato");
	
	public void setRispostaPerRiferimento(StatoFunzionalita rispostaPerRiferimento){
		this.rispostaPerRiferimento = rispostaPerRiferimento;
	}
	
	public StatoFunzionalita getRispostaPerRiferimento(){
		return this.rispostaPerRiferimento;
	}
	
	
	
	
}