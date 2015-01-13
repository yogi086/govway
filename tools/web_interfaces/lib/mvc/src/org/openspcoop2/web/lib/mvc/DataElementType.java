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

package org.openspcoop2.web.lib.mvc;

/**
 * DataElementType
 * 
 * @author Andrea Poli (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public enum DataElementType {

	HIDDEN("hidden"),TEXT("text"),TEXT_EDIT("textedit"),TEXT_AREA_NO_EDIT("textarea-noedit"),
	SELECT("select"),TITLE("title"),
	CRYPT("crypt"),CHECKBOX("checkbox"),LINK("link"),FILE("file"),
	NOTE("note");
	
	private String value;
	DataElementType(String value){
		this.value = value;
	}
	
	@Override
	public String toString(){
		return this.value;
	}
}
