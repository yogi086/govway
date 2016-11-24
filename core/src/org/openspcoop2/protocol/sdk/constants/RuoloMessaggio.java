/*
 * OpenSPCoop - Customizable API Gateway 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2016 Link.it srl (http://link.it). 
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


package org.openspcoop2.protocol.sdk.constants;

import java.io.Serializable;

/**
 * Contiene i tipi di messaggio
 *
 * @author apoli@link.it
 * @author $Author: apoli $
 * @version $Rev: 12237 $, $Date: 2016-10-04 11:41:45 +0200 (Tue, 04 Oct 2016) $
 */

public enum RuoloMessaggio implements Serializable {

	RICHIESTA("Richiesta"),
	RISPOSTA("Risposta");
	
	
	private final String tipo;

	RuoloMessaggio(String tipo)
	{
		this.tipo = tipo;
	}

	public String getTipo()
	{
		return this.tipo;
	}
	
	@Override
	public String toString(){
		return this.tipo;
	}
	
	public boolean equals(RuoloMessaggio tipoPdD){
		return this.tipo.equals(tipoPdD.getTipo());
	}
	
	public static final RuoloMessaggio toTipoTraccia(String v){
		if(RICHIESTA.toString().equals(v)){
			return RuoloMessaggio.RICHIESTA;
		}
		else if(RISPOSTA.toString().equals(v)){
			return RuoloMessaggio.RISPOSTA;
		}
		else{
			return null;
		}
	}
}
