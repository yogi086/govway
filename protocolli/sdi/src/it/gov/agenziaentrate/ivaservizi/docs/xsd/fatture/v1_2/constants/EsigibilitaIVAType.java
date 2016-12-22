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
package it.gov.agenziaentrate.ivaservizi.docs.xsd.fatture.v1_2.constants;

import java.io.Serializable;
import java.util.List;

import org.openspcoop2.generic_project.beans.IEnumeration;

/**     
 * Enumeration dell'elemento EsigibilitaIVAType xsd (tipo:string) 
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
@javax.xml.bind.annotation.XmlType(name = "EsigibilitaIVAType")
@javax.xml.bind.annotation.XmlEnum(java.lang.String.class)
public enum EsigibilitaIVAType implements IEnumeration , Serializable , Cloneable {

	@javax.xml.bind.annotation.XmlEnumValue("D")
	D ('D'),
	@javax.xml.bind.annotation.XmlEnumValue("I")
	I ('I'),
	@javax.xml.bind.annotation.XmlEnumValue("S")
	S ('S');
	
	
	/** Value */
	private java.lang.Character value;
	@Override
	public java.lang.Character getValue()
	{
		return this.value;
	}


	/** Official Constructor */
	EsigibilitaIVAType(java.lang.Character value)
	{
		this.value = value;
	}


	
	@Override
	public String toString(){
		return this.value+"";
	}
	public boolean equals(EsigibilitaIVAType object){
		if(object==null)
			return false;
		return object.getValue().toString().equals(this.getValue().toString());	
	}
	public boolean equals(java.lang.Character object){
		if(object==null)
			return false;
		return object.toString().equals(this.getValue().toString());	
	}
	
		
	
	/** compatibility with the generated bean (reflection) */
	public boolean equals(Object object,List<String> fieldsNotCheck){
		if( !(object instanceof EsigibilitaIVAType) ){
			throw new RuntimeException("Wrong type: "+object.getClass().getName());
		}
		return this.equals(((EsigibilitaIVAType)object));
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
	
	public static java.lang.Character[] toArray(){
		java.lang.Character[] res = new java.lang.Character[values().length];
		int i=0;
		for (EsigibilitaIVAType tmp : values()) {
			res[i]=tmp.getValue();
			i++;
		}
		return res;
	}	
	public static String[] toStringArray(){
		String[] res = new String[values().length];
		int i=0;
		for (EsigibilitaIVAType tmp : values()) {
			res[i]=tmp.toString();
			i++;
		}
		return res;
	}
	public static String[] toEnumNameArray(){
		String[] res = new String[values().length];
		int i=0;
		for (EsigibilitaIVAType tmp : values()) {
			res[i]=tmp.name();
			i++;
		}
		return res;
	}
	
	public static boolean contains(java.lang.Character value){
		return toEnumConstant(value)!=null;
	}
	
	public static EsigibilitaIVAType toEnumConstant(java.lang.Character value){
		EsigibilitaIVAType res = null;
		if(EsigibilitaIVAType.D.getValue() == value){
			res = EsigibilitaIVAType.D;
		}else if(EsigibilitaIVAType.I.getValue() == value){
			res = EsigibilitaIVAType.I;
		}else if(EsigibilitaIVAType.S.getValue() == value){
			res = EsigibilitaIVAType.S;
		}
		return res;
	}
	
	public static IEnumeration toEnumConstantFromString(String value){
		EsigibilitaIVAType res = null;
		if(EsigibilitaIVAType.D.toString().equals(value)){
			res = EsigibilitaIVAType.D;
		}else if(EsigibilitaIVAType.I.toString().equals(value)){
			res = EsigibilitaIVAType.I;
		}else if(EsigibilitaIVAType.S.toString().equals(value)){
			res = EsigibilitaIVAType.S;
		}
		return res;
	}
}