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
package org.openspcoop2.protocol.engine.mapping;

import java.io.Serializable;
import java.util.List;

import org.openspcoop2.core.config.constants.PortaApplicativaAzioneIdentificazione;
import org.openspcoop2.core.config.constants.PortaDelegataAzioneIdentificazione;
import org.openspcoop2.generic_project.beans.IEnumeration;
import org.openspcoop2.generic_project.exception.NotFoundException;

/**     
 * ModalitaIdentificazioneAzione
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public enum ModalitaIdentificazioneAzione implements IEnumeration , Serializable , Cloneable {

	STATIC ("static"),
	HEADER_BASED ("headerBased"),
	PLUGIN_BASED ("pluginBased"),
	URL_BASED ("urlBased"),
	CONTENT_BASED ("contentBased"),
	INPUT_BASED ("inputBased"),
	SOAP_ACTION_BASED ("soapActionBased"),
	WSDL_BASED ("wsdlBased");
	
	
	/** Value */
	private String value;
	@Override
	public String getValue()
	{
		return this.value;
	}


	/** Official Constructor */
	ModalitaIdentificazioneAzione(String value)
	{
		this.value = value;
	}


	
	@Override
	public String toString(){
		return this.value;
	}
	public boolean equals(ModalitaIdentificazioneAzione object){
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
		if( !(object instanceof ModalitaIdentificazioneAzione) ){
			throw new RuntimeException("Wrong type: "+object.getClass().getName());
		}
		return this.equals(((ModalitaIdentificazioneAzione)object));
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
		for (ModalitaIdentificazioneAzione tmp : values()) {
			res[i]=tmp.getValue();
			i++;
		}
		return res;
	}	
	public static String[] toStringArray(){
		String[] res = new String[values().length];
		int i=0;
		for (ModalitaIdentificazioneAzione tmp : values()) {
			res[i]=tmp.toString();
			i++;
		}
		return res;
	}
	public static String[] toEnumNameArray(){
		String[] res = new String[values().length];
		int i=0;
		for (ModalitaIdentificazioneAzione tmp : values()) {
			res[i]=tmp.name();
			i++;
		}
		return res;
	}
	
	public static boolean contains(String value){
		return toEnumConstant(value)!=null;
	}
	
	public static ModalitaIdentificazioneAzione toEnumConstant(String value){
		try{
			return toEnumConstant(value,false);
		}catch(NotFoundException notFound){
			return null;
		}
	}
	public static ModalitaIdentificazioneAzione toEnumConstant(String value, boolean throwNotFoundException) throws NotFoundException{
		ModalitaIdentificazioneAzione res = null;
		for (ModalitaIdentificazioneAzione tmp : values()) {
			if(tmp.getValue().equals(value)){
				res = tmp;
				break;
			}
		}
		if(res==null && throwNotFoundException){
			throw new NotFoundException("Enum with value ["+value+"] not found");
		}
		return res;
	}
	
	public static IEnumeration toEnumConstantFromString(String value){
		try{
			return toEnumConstantFromString(value,false);
		}catch(NotFoundException notFound){
			return null;
		}
	}
	public static IEnumeration toEnumConstantFromString(String value, boolean throwNotFoundException) throws NotFoundException{
		ModalitaIdentificazioneAzione res = null;
		for (ModalitaIdentificazioneAzione tmp : values()) {
			if(tmp.toString().equals(value)){
				res = tmp;
				break;
			}
		}
		if(res==null && throwNotFoundException){
			throw new NotFoundException("Enum with value ["+value+"] not found");
		}
		return res;
	}
	
	public static ModalitaIdentificazioneAzione convert(PortaDelegataAzioneIdentificazione identificazione){
		if(identificazione==null){
			return ModalitaIdentificazioneAzione.STATIC;
		}
		switch (identificazione) {
			case STATIC:
				return ModalitaIdentificazioneAzione.STATIC;
			case HEADER_BASED:
				return ModalitaIdentificazioneAzione.HEADER_BASED;
			case INPUT_BASED:
				return ModalitaIdentificazioneAzione.INPUT_BASED;
			case URL_BASED:
				return ModalitaIdentificazioneAzione.URL_BASED;
			case CONTENT_BASED:
				return ModalitaIdentificazioneAzione.CONTENT_BASED;
			case SOAP_ACTION_BASED:
				return ModalitaIdentificazioneAzione.SOAP_ACTION_BASED;
			case WSDL_BASED:
				return ModalitaIdentificazioneAzione.WSDL_BASED;			
		}
		return ModalitaIdentificazioneAzione.STATIC;
	}
	
	public static ModalitaIdentificazioneAzione convert(PortaApplicativaAzioneIdentificazione identificazione){
		if(identificazione==null){
			return ModalitaIdentificazioneAzione.STATIC;
		}
		switch (identificazione) {
			case STATIC:
				return ModalitaIdentificazioneAzione.STATIC;
			case PLUGIN_BASED:
				return ModalitaIdentificazioneAzione.PLUGIN_BASED;
			case HEADER_BASED:
				return ModalitaIdentificazioneAzione.HEADER_BASED;
			case INPUT_BASED:
				return ModalitaIdentificazioneAzione.INPUT_BASED;
			case URL_BASED:
				return ModalitaIdentificazioneAzione.URL_BASED;
			case CONTENT_BASED:
				return ModalitaIdentificazioneAzione.CONTENT_BASED;
			case SOAP_ACTION_BASED:
				return ModalitaIdentificazioneAzione.SOAP_ACTION_BASED;
			case WSDL_BASED:
				return ModalitaIdentificazioneAzione.WSDL_BASED;			
		}
		return ModalitaIdentificazioneAzione.STATIC;
	}
}