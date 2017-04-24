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
package org.openspcoop2.core.config.model;

import org.openspcoop2.core.config.InvocazioneServizio;

import org.openspcoop2.generic_project.beans.AbstractModel;
import org.openspcoop2.generic_project.beans.IField;
import org.openspcoop2.generic_project.beans.Field;
import org.openspcoop2.generic_project.beans.ComplexField;


/**     
 * Model InvocazioneServizio 
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class InvocazioneServizioModel extends AbstractModel<InvocazioneServizio> {

	public InvocazioneServizioModel(){
	
		super();
	
		this.CREDENZIALI = new org.openspcoop2.core.config.model.InvocazioneCredenzialiModel(new Field("credenziali",org.openspcoop2.core.config.InvocazioneCredenziali.class,"invocazione-servizio",InvocazioneServizio.class));
		this.CONNETTORE = new org.openspcoop2.core.config.model.ConnettoreModel(new Field("connettore",org.openspcoop2.core.config.Connettore.class,"invocazione-servizio",InvocazioneServizio.class));
		this.GESTIONE_ERRORE = new org.openspcoop2.core.config.model.GestioneErroreModel(new Field("gestione-errore",org.openspcoop2.core.config.GestioneErrore.class,"invocazione-servizio",InvocazioneServizio.class));
		this.SBUSTAMENTO_SOAP = new Field("sbustamento-soap",java.lang.String.class,"invocazione-servizio",InvocazioneServizio.class);
		this.SBUSTAMENTO_INFORMAZIONI_PROTOCOLLO = new Field("sbustamento-informazioni-protocollo",java.lang.String.class,"invocazione-servizio",InvocazioneServizio.class);
		this.GET_MESSAGE = new Field("get-message",java.lang.String.class,"invocazione-servizio",InvocazioneServizio.class);
		this.AUTENTICAZIONE = new Field("autenticazione",java.lang.String.class,"invocazione-servizio",InvocazioneServizio.class);
		this.INVIO_PER_RIFERIMENTO = new Field("invio-per-riferimento",java.lang.String.class,"invocazione-servizio",InvocazioneServizio.class);
		this.RISPOSTA_PER_RIFERIMENTO = new Field("risposta-per-riferimento",java.lang.String.class,"invocazione-servizio",InvocazioneServizio.class);
	
	}
	
	public InvocazioneServizioModel(IField father){
	
		super(father);
	
		this.CREDENZIALI = new org.openspcoop2.core.config.model.InvocazioneCredenzialiModel(new ComplexField(father,"credenziali",org.openspcoop2.core.config.InvocazioneCredenziali.class,"invocazione-servizio",InvocazioneServizio.class));
		this.CONNETTORE = new org.openspcoop2.core.config.model.ConnettoreModel(new ComplexField(father,"connettore",org.openspcoop2.core.config.Connettore.class,"invocazione-servizio",InvocazioneServizio.class));
		this.GESTIONE_ERRORE = new org.openspcoop2.core.config.model.GestioneErroreModel(new ComplexField(father,"gestione-errore",org.openspcoop2.core.config.GestioneErrore.class,"invocazione-servizio",InvocazioneServizio.class));
		this.SBUSTAMENTO_SOAP = new ComplexField(father,"sbustamento-soap",java.lang.String.class,"invocazione-servizio",InvocazioneServizio.class);
		this.SBUSTAMENTO_INFORMAZIONI_PROTOCOLLO = new ComplexField(father,"sbustamento-informazioni-protocollo",java.lang.String.class,"invocazione-servizio",InvocazioneServizio.class);
		this.GET_MESSAGE = new ComplexField(father,"get-message",java.lang.String.class,"invocazione-servizio",InvocazioneServizio.class);
		this.AUTENTICAZIONE = new ComplexField(father,"autenticazione",java.lang.String.class,"invocazione-servizio",InvocazioneServizio.class);
		this.INVIO_PER_RIFERIMENTO = new ComplexField(father,"invio-per-riferimento",java.lang.String.class,"invocazione-servizio",InvocazioneServizio.class);
		this.RISPOSTA_PER_RIFERIMENTO = new ComplexField(father,"risposta-per-riferimento",java.lang.String.class,"invocazione-servizio",InvocazioneServizio.class);
	
	}
	
	

	public org.openspcoop2.core.config.model.InvocazioneCredenzialiModel CREDENZIALI = null;
	 
	public org.openspcoop2.core.config.model.ConnettoreModel CONNETTORE = null;
	 
	public org.openspcoop2.core.config.model.GestioneErroreModel GESTIONE_ERRORE = null;
	 
	public IField SBUSTAMENTO_SOAP = null;
	 
	public IField SBUSTAMENTO_INFORMAZIONI_PROTOCOLLO = null;
	 
	public IField GET_MESSAGE = null;
	 
	public IField AUTENTICAZIONE = null;
	 
	public IField INVIO_PER_RIFERIMENTO = null;
	 
	public IField RISPOSTA_PER_RIFERIMENTO = null;
	 

	@Override
	public Class<InvocazioneServizio> getModeledClass(){
		return InvocazioneServizio.class;
	}
	
	@Override
	public String toString(){
		if(this.getModeledClass()!=null){
			return this.getModeledClass().getName();
		}else{
			return "N.D.";
		}
	}

}