/*
 * GovWay - A customizable API Gateway 
 * http://www.govway.org
 * 
 * from the Link.it OpenSPCoop project codebase
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
package org.openspcoop2.web.monitor.core.constants;


/****
 * 
 * Classe per gestire l'enumerazione dei ruoli utente possibili
 * 
 * 
 * @author pintori
 *
 */
public enum RuoliUtente {

	ROLE_USER ("user"),
	ROLE_ADMIN ("amministratore"), 
	ROLE_CONFIG ("configuratore"),
	ROLE_OPERATORE ("operatore");

	
	private String value;
	RuoliUtente(String ruolo) {
		this.value = ruolo;
	}
	
	@Override
	public String toString(){
		return this.value;
	}
	
	public static RuoliUtente getFromString(String v){
		if(v.equals(ROLE_ADMIN.value)){
			return ROLE_ADMIN;
		}else if(v.equals(ROLE_CONFIG.value)){
			return ROLE_CONFIG;
		} else if(v.equals(ROLE_OPERATORE.value)){
			return ROLE_OPERATORE;
		} 
		
		return ROLE_USER;
		
	}
	
	
	public static String getValue(RuoliUtente ruolo){
		if(ruolo.equals(ROLE_ADMIN))
			return ROLE_ADMIN.value;
		else if(ruolo.equals(ROLE_CONFIG))
		return ROLE_CONFIG.value; 
		else if(ruolo.equals(ROLE_OPERATORE))
			return ROLE_OPERATORE.value;
		
		return ROLE_USER.value;
	}
	
	
}
