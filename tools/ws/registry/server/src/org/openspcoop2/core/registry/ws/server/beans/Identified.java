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
package org.openspcoop2.core.registry.ws.server.beans;

import java.io.Serializable;
import java.util.List;

import org.openspcoop2.generic_project.beans.IEnumeration;

/**     
 * Enumeration Identified 
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
@javax.xml.bind.annotation.XmlType(name = "identified")
@javax.xml.bind.annotation.XmlEnum(String.class)
public enum Identified implements IEnumeration , Serializable , Cloneable {

	@javax.xml.bind.annotation.XmlEnumValue("AccordoCooperazione")
	ACCORDO_COOPERAZIONE ("AccordoCooperazione"),
	@javax.xml.bind.annotation.XmlEnumValue("AccordoServizioParteComune")
	ACCORDO_SERVIZIO_PARTE_COMUNE ("AccordoServizioParteComune"),
	@javax.xml.bind.annotation.XmlEnumValue("PortaDominio")
	PORTA_DOMINIO ("PortaDominio"),
	@javax.xml.bind.annotation.XmlEnumValue("Soggetto")
	SOGGETTO ("Soggetto"),
	@javax.xml.bind.annotation.XmlEnumValue("AccordoServizioParteSpecifica")
	ACCORDO_SERVIZIO_PARTE_SPECIFICA ("AccordoServizioParteSpecifica");
	
	
	/** Value */
	private String value;
	@Override
	public String getValue()
	{
		return this.value;
	}


	/** Official Constructor */
	Identified(String value)
	{
		this.value = value;
	}


	
	@Override
	public String toString(){
		return this.value+"";
	}
	public boolean equals(Identified object){
		if(object==null)
			return false;
		if(object.getValue()==null)
			return false;
		return object.getValue().equals(this.getValue());	
	}
	public boolean equals(String object){
		if(object==null)
			return false;
		return object.equals(this.getValue());	
	}
	
		
	
	/** compatibility with the generated bean (reflection) */
	public boolean equals(Object object,List<String> fieldsNotCheck){
		if( !(object instanceof Identified) ){
			throw new RuntimeException("Wrong type: "+object.getClass().getName());
		}
		return this.equals(((Identified)object));
	}
	public String toString(boolean reportHTML){
		return toString();
	}
  	public String toString(boolean reportHTML,List<String> fieldsNotIncluded){
  		return toString();
  	}
  	public String diff(Object object,StringBuffer bf,boolean reportHTML){
		return bf.toString();
	}
	public String diff(Object object,StringBuffer bf,boolean reportHTML,List<String> fieldsNotIncluded){
		return bf.toString();
	}
	
	
	/** Utilities */
	
	public static String[] toArray(){
		String[] res = new String[values().length];
		int i=0;
		for (Identified tmp : values()) {
			res[i]=tmp.getValue();
			i++;
		}
		return res;
	}	
	public static String[] toStringArray(){
		String[] res = new String[values().length];
		int i=0;
		for (Identified tmp : values()) {
			res[i]=tmp.toString();
			i++;
		}
		return res;
	}
	public static String[] toEnumNameArray(){
		String[] res = new String[values().length];
		int i=0;
		for (Identified tmp : values()) {
			res[i]=tmp.name();
			i++;
		}
		return res;
	}
	
	public static boolean contains(String value){
		return toEnumConstant(value)!=null;
	}
	
	public static Identified toEnumConstant(String value){
		Identified res = null;
		if(Identified.ACCORDO_COOPERAZIONE.getValue().equals(value)){
			res = Identified.ACCORDO_COOPERAZIONE;
		}else if(Identified.ACCORDO_SERVIZIO_PARTE_COMUNE.getValue().equals(value)){
			res = Identified.ACCORDO_SERVIZIO_PARTE_COMUNE;
		}else if(Identified.PORTA_DOMINIO.getValue().equals(value)){
			res = Identified.PORTA_DOMINIO;
		}else if(Identified.SOGGETTO.getValue().equals(value)){
			res = Identified.SOGGETTO;
		}else if(Identified.ACCORDO_SERVIZIO_PARTE_SPECIFICA.getValue().equals(value)){
			res = Identified.ACCORDO_SERVIZIO_PARTE_SPECIFICA;
		}
		return res;
	}
	
	public static IEnumeration toEnumConstantFromString(String value){
		Identified res = null;
		if(Identified.ACCORDO_COOPERAZIONE.toString().equals(value)){
			res = Identified.ACCORDO_COOPERAZIONE;
		}else if(Identified.ACCORDO_SERVIZIO_PARTE_COMUNE.toString().equals(value)){
			res = Identified.ACCORDO_SERVIZIO_PARTE_COMUNE;
		}else if(Identified.PORTA_DOMINIO.toString().equals(value)){
			res = Identified.PORTA_DOMINIO;
		}else if(Identified.SOGGETTO.toString().equals(value)){
			res = Identified.SOGGETTO;
		}else if(Identified.ACCORDO_SERVIZIO_PARTE_SPECIFICA.toString().equals(value)){
			res = Identified.ACCORDO_SERVIZIO_PARTE_SPECIFICA;
		}
		return res;
	}
}
