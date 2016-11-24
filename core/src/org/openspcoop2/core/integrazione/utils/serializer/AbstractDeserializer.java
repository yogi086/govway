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
package org.openspcoop2.core.integrazione.utils.serializer;

import org.openspcoop2.generic_project.exception.DeserializerException;

import org.openspcoop2.core.integrazione.EsitoRichiesta;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;

/**     
 * XML Deserializer of beans
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */

public abstract class AbstractDeserializer {



	protected abstract Object _xmlToObj(InputStream is, Class<?> c) throws Exception;
	
	private Object xmlToObj(InputStream is,Class<?> c) throws DeserializerException{
		try{
			return this._xmlToObj(is, c);
		}catch(Exception e){
			throw new DeserializerException(e.getMessage(), e);
		}
	}
	private Object xmlToObj(String fileName,Class<?> c) throws DeserializerException{
		try{
			return this.xmlToObj(new File(fileName), c);
		}catch(Exception e){
			throw new DeserializerException(e.getMessage(), e);
		}
	}
	private Object xmlToObj(File file,Class<?> c) throws DeserializerException{
		FileInputStream fin = null;
		try{
			fin = new FileInputStream(file);
			return this._xmlToObj(fin, c);
		}catch(Exception e){
			throw new DeserializerException(e.getMessage(),e);
		}finally{
			try{
				fin.close();
			}catch(Exception e){}
		}
	}
	private Object xmlToObj(byte[] file,Class<?> c) throws DeserializerException{
		ByteArrayInputStream fin = null;
		try{
			fin = new ByteArrayInputStream(file);
			return this._xmlToObj(fin, c);
		}catch(Exception e){
			throw new DeserializerException(e.getMessage(),e);
		}finally{
			try{
				fin.close();
			}catch(Exception e){}
		}
	}






	/*
	 =================================================================================
	 Object: esito-richiesta
	 =================================================================================
	*/
	
	/**
	 * Transform the xml in <var>fileName</var> in the object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * 
	 * @param fileName Xml file to use for the reconstruction of the object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * @return Object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * @throws DeserializerException The exception that is thrown when an error occurs during deserialization
	 */
	public EsitoRichiesta readEsitoRichiesta(String fileName) throws DeserializerException {
		return (EsitoRichiesta) this.xmlToObj(fileName, EsitoRichiesta.class);
	}
	
	/**
	 * Transform the xml in <var>file</var> in the object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * 
	 * @param file Xml file to use for the reconstruction of the object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * @return Object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * @throws DeserializerException The exception that is thrown when an error occurs during deserialization
	 */
	public EsitoRichiesta readEsitoRichiesta(File file) throws DeserializerException {
		return (EsitoRichiesta) this.xmlToObj(file, EsitoRichiesta.class);
	}
	
	/**
	 * Transform the input stream <var>in</var> in the object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * 
	 * @param in InputStream to use for the reconstruction of the object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * @return Object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * @throws DeserializerException The exception that is thrown when an error occurs during deserialization
	 */
	public EsitoRichiesta readEsitoRichiesta(InputStream in) throws DeserializerException {
		return (EsitoRichiesta) this.xmlToObj(in, EsitoRichiesta.class);
	}	
	
	/**
	 * Transform the byte array <var>in</var> in the object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * 
	 * @param in Byte array to use for the reconstruction of the object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * @return Object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * @throws DeserializerException The exception that is thrown when an error occurs during deserialization
	 */
	public EsitoRichiesta readEsitoRichiesta(byte[] in) throws DeserializerException {
		return (EsitoRichiesta) this.xmlToObj(in, EsitoRichiesta.class);
	}	
	
	/**
	 * Transform the String <var>in</var> in the object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * 
	 * @param in String to use for the reconstruction of the object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * @return Object type {@link org.openspcoop2.core.integrazione.EsitoRichiesta}
	 * @throws DeserializerException The exception that is thrown when an error occurs during deserialization
	 */
	public EsitoRichiesta readEsitoRichiestaFromString(String in) throws DeserializerException {
		return (EsitoRichiesta) this.xmlToObj(in.getBytes(), EsitoRichiesta.class);
	}	
	
	
	

}