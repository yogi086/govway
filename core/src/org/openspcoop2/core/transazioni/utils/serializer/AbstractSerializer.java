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
package org.openspcoop2.core.transazioni.utils.serializer;

import org.openspcoop2.generic_project.exception.SerializerException;
import org.openspcoop2.utils.beans.WriteToSerializerType;
import org.openspcoop2.utils.xml.JaxbUtils;

import org.openspcoop2.core.transazioni.DumpMessaggio;
import org.openspcoop2.core.transazioni.DumpAllegato;
import org.openspcoop2.core.transazioni.DumpContenuto;
import org.openspcoop2.core.transazioni.DumpHeaderTrasporto;
import org.openspcoop2.core.transazioni.Transazione;
import org.openspcoop2.core.transazioni.TransazioneExtendedInfo;
import org.openspcoop2.core.transazioni.IdDumpMessaggio;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.File;
import java.lang.reflect.Method;

import javax.xml.bind.JAXBElement;

/**     
 * XML Serializer of beans
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public abstract class AbstractSerializer {


	protected abstract WriteToSerializerType getType();
	
	protected void _objToXml(OutputStream out, Class<?> c, Object object,
			boolean prettyPrint) throws Exception {
		if(object instanceof JAXBElement){
			// solo per il tipo WriteToSerializerType.JAXB
			JaxbUtils.objToXml(out, c, object, prettyPrint);
		}else{
			Method m = c.getMethod("writeTo", OutputStream.class, WriteToSerializerType.class);
			m.invoke(object, out, this.getType());
		}
	}
	
	protected void objToXml(OutputStream out,Class<?> c,Object object,boolean prettyPrint) throws SerializerException{
		try{
			this._objToXml(out, c, object, prettyPrint);
		}catch(Exception e){
			throw new SerializerException(e.getMessage(), e);
		}
		finally{
			try{
				out.flush();
			}catch(Exception e){}
		}
	}
	protected void objToXml(String fileName,Class<?> c,Object object,boolean prettyPrint) throws SerializerException{
		try{
			this.objToXml(new File(fileName), c, object, prettyPrint);
		}catch(Exception e){
			throw new SerializerException(e.getMessage(), e);
		}
	}
	protected void objToXml(File file,Class<?> c,Object object,boolean prettyPrint) throws SerializerException{
		FileOutputStream fout = null;
		try{
			fout = new FileOutputStream(file);
			this._objToXml(fout, c, object, prettyPrint);
		}catch(Exception e){
			throw new SerializerException(e.getMessage(), e);
		}
		finally{
			try{
				fout.flush();
			}catch(Exception e){}
			try{
				fout.close();
			}catch(Exception e){}
		}
	}
	protected ByteArrayOutputStream objToXml(Class<?> c,Object object,boolean prettyPrint) throws SerializerException{
		ByteArrayOutputStream bout = null;
		try{
			bout = new ByteArrayOutputStream();
			this._objToXml(bout, c, object, prettyPrint);
		}catch(Exception e){
			throw new SerializerException(e.getMessage(), e);
		}
		finally{
			try{
				bout.flush();
			}catch(Exception e){}
			try{
				bout.close();
			}catch(Exception e){}
		}
		return bout;
	}




	/*
	 =================================================================================
	 Object: dump-messaggio
	 =================================================================================
	*/
	
	/**
	 * Serialize to file system in <var>fileName</var> the object <var>dumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.DumpMessaggio}
	 * 
	 * @param fileName Xml file to serialize the object <var>dumpMessaggio</var>
	 * @param dumpMessaggio Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(String fileName,DumpMessaggio dumpMessaggio) throws SerializerException {
		this.objToXml(fileName, DumpMessaggio.class, dumpMessaggio, false);
	}
	/**
	 * Serialize to file system in <var>fileName</var> the object <var>dumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.DumpMessaggio}
	 * 
	 * @param fileName Xml file to serialize the object <var>dumpMessaggio</var>
	 * @param dumpMessaggio Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(String fileName,DumpMessaggio dumpMessaggio,boolean prettyPrint) throws SerializerException {
		this.objToXml(fileName, DumpMessaggio.class, dumpMessaggio, prettyPrint);
	}
	
	/**
	 * Serialize to file system in <var>file</var> the object <var>dumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.DumpMessaggio}
	 * 
	 * @param file Xml file to serialize the object <var>dumpMessaggio</var>
	 * @param dumpMessaggio Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(File file,DumpMessaggio dumpMessaggio) throws SerializerException {
		this.objToXml(file, DumpMessaggio.class, dumpMessaggio, false);
	}
	/**
	 * Serialize to file system in <var>file</var> the object <var>dumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.DumpMessaggio}
	 * 
	 * @param file Xml file to serialize the object <var>dumpMessaggio</var>
	 * @param dumpMessaggio Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(File file,DumpMessaggio dumpMessaggio,boolean prettyPrint) throws SerializerException {
		this.objToXml(file, DumpMessaggio.class, dumpMessaggio, prettyPrint);
	}
	
	/**
	 * Serialize to output stream <var>out</var> the object <var>dumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.DumpMessaggio}
	 * 
	 * @param out OutputStream to serialize the object <var>dumpMessaggio</var>
	 * @param dumpMessaggio Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(OutputStream out,DumpMessaggio dumpMessaggio) throws SerializerException {
		this.objToXml(out, DumpMessaggio.class, dumpMessaggio, false);
	}
	/**
	 * Serialize to output stream <var>out</var> the object <var>dumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.DumpMessaggio}
	 * 
	 * @param out OutputStream to serialize the object <var>dumpMessaggio</var>
	 * @param dumpMessaggio Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(OutputStream out,DumpMessaggio dumpMessaggio,boolean prettyPrint) throws SerializerException {
		this.objToXml(out, DumpMessaggio.class, dumpMessaggio, prettyPrint);
	}
			
	/**
	 * Serialize to byte array the object <var>dumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.DumpMessaggio}
	 * 
	 * @param dumpMessaggio Object to be serialized
	 * @return Object to be serialized in byte array
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public byte[] toByteArray(DumpMessaggio dumpMessaggio) throws SerializerException {
		return this.objToXml(DumpMessaggio.class, dumpMessaggio, false).toByteArray();
	}
	/**
	 * Serialize to byte array the object <var>dumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.DumpMessaggio}
	 * 
	 * @param dumpMessaggio Object to be serialized
	 * @param prettyPrint if true output the XML with indenting
	 * @return Object to be serialized in byte array
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public byte[] toByteArray(DumpMessaggio dumpMessaggio,boolean prettyPrint) throws SerializerException {
		return this.objToXml(DumpMessaggio.class, dumpMessaggio, prettyPrint).toByteArray();
	}
	
	/**
	 * Serialize to String the object <var>dumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.DumpMessaggio}
	 * 
	 * @param dumpMessaggio Object to be serialized
	 * @return Object to be serialized as String
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public String toString(DumpMessaggio dumpMessaggio) throws SerializerException {
		return this.objToXml(DumpMessaggio.class, dumpMessaggio, false).toString();
	}
	/**
	 * Serialize to String the object <var>dumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.DumpMessaggio}
	 * 
	 * @param dumpMessaggio Object to be serialized
	 * @param prettyPrint if true output the XML with indenting
	 * @return Object to be serialized as String
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public String toString(DumpMessaggio dumpMessaggio,boolean prettyPrint) throws SerializerException {
		return this.objToXml(DumpMessaggio.class, dumpMessaggio, prettyPrint).toString();
	}
	
	
	
	/*
	 =================================================================================
	 Object: dump-allegato
	 =================================================================================
	*/
	
	/**
	 * Serialize to file system in <var>fileName</var> the object <var>dumpAllegato</var> of type {@link org.openspcoop2.core.transazioni.DumpAllegato}
	 * 
	 * @param fileName Xml file to serialize the object <var>dumpAllegato</var>
	 * @param dumpAllegato Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(String fileName,DumpAllegato dumpAllegato) throws SerializerException {
		this.objToXml(fileName, DumpAllegato.class, dumpAllegato, false);
	}
	/**
	 * Serialize to file system in <var>fileName</var> the object <var>dumpAllegato</var> of type {@link org.openspcoop2.core.transazioni.DumpAllegato}
	 * 
	 * @param fileName Xml file to serialize the object <var>dumpAllegato</var>
	 * @param dumpAllegato Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(String fileName,DumpAllegato dumpAllegato,boolean prettyPrint) throws SerializerException {
		this.objToXml(fileName, DumpAllegato.class, dumpAllegato, prettyPrint);
	}
	
	/**
	 * Serialize to file system in <var>file</var> the object <var>dumpAllegato</var> of type {@link org.openspcoop2.core.transazioni.DumpAllegato}
	 * 
	 * @param file Xml file to serialize the object <var>dumpAllegato</var>
	 * @param dumpAllegato Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(File file,DumpAllegato dumpAllegato) throws SerializerException {
		this.objToXml(file, DumpAllegato.class, dumpAllegato, false);
	}
	/**
	 * Serialize to file system in <var>file</var> the object <var>dumpAllegato</var> of type {@link org.openspcoop2.core.transazioni.DumpAllegato}
	 * 
	 * @param file Xml file to serialize the object <var>dumpAllegato</var>
	 * @param dumpAllegato Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(File file,DumpAllegato dumpAllegato,boolean prettyPrint) throws SerializerException {
		this.objToXml(file, DumpAllegato.class, dumpAllegato, prettyPrint);
	}
	
	/**
	 * Serialize to output stream <var>out</var> the object <var>dumpAllegato</var> of type {@link org.openspcoop2.core.transazioni.DumpAllegato}
	 * 
	 * @param out OutputStream to serialize the object <var>dumpAllegato</var>
	 * @param dumpAllegato Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(OutputStream out,DumpAllegato dumpAllegato) throws SerializerException {
		this.objToXml(out, DumpAllegato.class, dumpAllegato, false);
	}
	/**
	 * Serialize to output stream <var>out</var> the object <var>dumpAllegato</var> of type {@link org.openspcoop2.core.transazioni.DumpAllegato}
	 * 
	 * @param out OutputStream to serialize the object <var>dumpAllegato</var>
	 * @param dumpAllegato Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(OutputStream out,DumpAllegato dumpAllegato,boolean prettyPrint) throws SerializerException {
		this.objToXml(out, DumpAllegato.class, dumpAllegato, prettyPrint);
	}
			
	/**
	 * Serialize to byte array the object <var>dumpAllegato</var> of type {@link org.openspcoop2.core.transazioni.DumpAllegato}
	 * 
	 * @param dumpAllegato Object to be serialized
	 * @return Object to be serialized in byte array
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public byte[] toByteArray(DumpAllegato dumpAllegato) throws SerializerException {
		return this.objToXml(DumpAllegato.class, dumpAllegato, false).toByteArray();
	}
	/**
	 * Serialize to byte array the object <var>dumpAllegato</var> of type {@link org.openspcoop2.core.transazioni.DumpAllegato}
	 * 
	 * @param dumpAllegato Object to be serialized
	 * @param prettyPrint if true output the XML with indenting
	 * @return Object to be serialized in byte array
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public byte[] toByteArray(DumpAllegato dumpAllegato,boolean prettyPrint) throws SerializerException {
		return this.objToXml(DumpAllegato.class, dumpAllegato, prettyPrint).toByteArray();
	}
	
	/**
	 * Serialize to String the object <var>dumpAllegato</var> of type {@link org.openspcoop2.core.transazioni.DumpAllegato}
	 * 
	 * @param dumpAllegato Object to be serialized
	 * @return Object to be serialized as String
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public String toString(DumpAllegato dumpAllegato) throws SerializerException {
		return this.objToXml(DumpAllegato.class, dumpAllegato, false).toString();
	}
	/**
	 * Serialize to String the object <var>dumpAllegato</var> of type {@link org.openspcoop2.core.transazioni.DumpAllegato}
	 * 
	 * @param dumpAllegato Object to be serialized
	 * @param prettyPrint if true output the XML with indenting
	 * @return Object to be serialized as String
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public String toString(DumpAllegato dumpAllegato,boolean prettyPrint) throws SerializerException {
		return this.objToXml(DumpAllegato.class, dumpAllegato, prettyPrint).toString();
	}
	
	
	
	/*
	 =================================================================================
	 Object: dump-contenuto
	 =================================================================================
	*/
	
	/**
	 * Serialize to file system in <var>fileName</var> the object <var>dumpContenuto</var> of type {@link org.openspcoop2.core.transazioni.DumpContenuto}
	 * 
	 * @param fileName Xml file to serialize the object <var>dumpContenuto</var>
	 * @param dumpContenuto Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(String fileName,DumpContenuto dumpContenuto) throws SerializerException {
		this.objToXml(fileName, DumpContenuto.class, dumpContenuto, false);
	}
	/**
	 * Serialize to file system in <var>fileName</var> the object <var>dumpContenuto</var> of type {@link org.openspcoop2.core.transazioni.DumpContenuto}
	 * 
	 * @param fileName Xml file to serialize the object <var>dumpContenuto</var>
	 * @param dumpContenuto Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(String fileName,DumpContenuto dumpContenuto,boolean prettyPrint) throws SerializerException {
		this.objToXml(fileName, DumpContenuto.class, dumpContenuto, prettyPrint);
	}
	
	/**
	 * Serialize to file system in <var>file</var> the object <var>dumpContenuto</var> of type {@link org.openspcoop2.core.transazioni.DumpContenuto}
	 * 
	 * @param file Xml file to serialize the object <var>dumpContenuto</var>
	 * @param dumpContenuto Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(File file,DumpContenuto dumpContenuto) throws SerializerException {
		this.objToXml(file, DumpContenuto.class, dumpContenuto, false);
	}
	/**
	 * Serialize to file system in <var>file</var> the object <var>dumpContenuto</var> of type {@link org.openspcoop2.core.transazioni.DumpContenuto}
	 * 
	 * @param file Xml file to serialize the object <var>dumpContenuto</var>
	 * @param dumpContenuto Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(File file,DumpContenuto dumpContenuto,boolean prettyPrint) throws SerializerException {
		this.objToXml(file, DumpContenuto.class, dumpContenuto, prettyPrint);
	}
	
	/**
	 * Serialize to output stream <var>out</var> the object <var>dumpContenuto</var> of type {@link org.openspcoop2.core.transazioni.DumpContenuto}
	 * 
	 * @param out OutputStream to serialize the object <var>dumpContenuto</var>
	 * @param dumpContenuto Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(OutputStream out,DumpContenuto dumpContenuto) throws SerializerException {
		this.objToXml(out, DumpContenuto.class, dumpContenuto, false);
	}
	/**
	 * Serialize to output stream <var>out</var> the object <var>dumpContenuto</var> of type {@link org.openspcoop2.core.transazioni.DumpContenuto}
	 * 
	 * @param out OutputStream to serialize the object <var>dumpContenuto</var>
	 * @param dumpContenuto Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(OutputStream out,DumpContenuto dumpContenuto,boolean prettyPrint) throws SerializerException {
		this.objToXml(out, DumpContenuto.class, dumpContenuto, prettyPrint);
	}
			
	/**
	 * Serialize to byte array the object <var>dumpContenuto</var> of type {@link org.openspcoop2.core.transazioni.DumpContenuto}
	 * 
	 * @param dumpContenuto Object to be serialized
	 * @return Object to be serialized in byte array
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public byte[] toByteArray(DumpContenuto dumpContenuto) throws SerializerException {
		return this.objToXml(DumpContenuto.class, dumpContenuto, false).toByteArray();
	}
	/**
	 * Serialize to byte array the object <var>dumpContenuto</var> of type {@link org.openspcoop2.core.transazioni.DumpContenuto}
	 * 
	 * @param dumpContenuto Object to be serialized
	 * @param prettyPrint if true output the XML with indenting
	 * @return Object to be serialized in byte array
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public byte[] toByteArray(DumpContenuto dumpContenuto,boolean prettyPrint) throws SerializerException {
		return this.objToXml(DumpContenuto.class, dumpContenuto, prettyPrint).toByteArray();
	}
	
	/**
	 * Serialize to String the object <var>dumpContenuto</var> of type {@link org.openspcoop2.core.transazioni.DumpContenuto}
	 * 
	 * @param dumpContenuto Object to be serialized
	 * @return Object to be serialized as String
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public String toString(DumpContenuto dumpContenuto) throws SerializerException {
		return this.objToXml(DumpContenuto.class, dumpContenuto, false).toString();
	}
	/**
	 * Serialize to String the object <var>dumpContenuto</var> of type {@link org.openspcoop2.core.transazioni.DumpContenuto}
	 * 
	 * @param dumpContenuto Object to be serialized
	 * @param prettyPrint if true output the XML with indenting
	 * @return Object to be serialized as String
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public String toString(DumpContenuto dumpContenuto,boolean prettyPrint) throws SerializerException {
		return this.objToXml(DumpContenuto.class, dumpContenuto, prettyPrint).toString();
	}
	
	
	
	/*
	 =================================================================================
	 Object: dump-header-trasporto
	 =================================================================================
	*/
	
	/**
	 * Serialize to file system in <var>fileName</var> the object <var>dumpHeaderTrasporto</var> of type {@link org.openspcoop2.core.transazioni.DumpHeaderTrasporto}
	 * 
	 * @param fileName Xml file to serialize the object <var>dumpHeaderTrasporto</var>
	 * @param dumpHeaderTrasporto Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(String fileName,DumpHeaderTrasporto dumpHeaderTrasporto) throws SerializerException {
		this.objToXml(fileName, DumpHeaderTrasporto.class, dumpHeaderTrasporto, false);
	}
	/**
	 * Serialize to file system in <var>fileName</var> the object <var>dumpHeaderTrasporto</var> of type {@link org.openspcoop2.core.transazioni.DumpHeaderTrasporto}
	 * 
	 * @param fileName Xml file to serialize the object <var>dumpHeaderTrasporto</var>
	 * @param dumpHeaderTrasporto Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(String fileName,DumpHeaderTrasporto dumpHeaderTrasporto,boolean prettyPrint) throws SerializerException {
		this.objToXml(fileName, DumpHeaderTrasporto.class, dumpHeaderTrasporto, prettyPrint);
	}
	
	/**
	 * Serialize to file system in <var>file</var> the object <var>dumpHeaderTrasporto</var> of type {@link org.openspcoop2.core.transazioni.DumpHeaderTrasporto}
	 * 
	 * @param file Xml file to serialize the object <var>dumpHeaderTrasporto</var>
	 * @param dumpHeaderTrasporto Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(File file,DumpHeaderTrasporto dumpHeaderTrasporto) throws SerializerException {
		this.objToXml(file, DumpHeaderTrasporto.class, dumpHeaderTrasporto, false);
	}
	/**
	 * Serialize to file system in <var>file</var> the object <var>dumpHeaderTrasporto</var> of type {@link org.openspcoop2.core.transazioni.DumpHeaderTrasporto}
	 * 
	 * @param file Xml file to serialize the object <var>dumpHeaderTrasporto</var>
	 * @param dumpHeaderTrasporto Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(File file,DumpHeaderTrasporto dumpHeaderTrasporto,boolean prettyPrint) throws SerializerException {
		this.objToXml(file, DumpHeaderTrasporto.class, dumpHeaderTrasporto, prettyPrint);
	}
	
	/**
	 * Serialize to output stream <var>out</var> the object <var>dumpHeaderTrasporto</var> of type {@link org.openspcoop2.core.transazioni.DumpHeaderTrasporto}
	 * 
	 * @param out OutputStream to serialize the object <var>dumpHeaderTrasporto</var>
	 * @param dumpHeaderTrasporto Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(OutputStream out,DumpHeaderTrasporto dumpHeaderTrasporto) throws SerializerException {
		this.objToXml(out, DumpHeaderTrasporto.class, dumpHeaderTrasporto, false);
	}
	/**
	 * Serialize to output stream <var>out</var> the object <var>dumpHeaderTrasporto</var> of type {@link org.openspcoop2.core.transazioni.DumpHeaderTrasporto}
	 * 
	 * @param out OutputStream to serialize the object <var>dumpHeaderTrasporto</var>
	 * @param dumpHeaderTrasporto Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(OutputStream out,DumpHeaderTrasporto dumpHeaderTrasporto,boolean prettyPrint) throws SerializerException {
		this.objToXml(out, DumpHeaderTrasporto.class, dumpHeaderTrasporto, prettyPrint);
	}
			
	/**
	 * Serialize to byte array the object <var>dumpHeaderTrasporto</var> of type {@link org.openspcoop2.core.transazioni.DumpHeaderTrasporto}
	 * 
	 * @param dumpHeaderTrasporto Object to be serialized
	 * @return Object to be serialized in byte array
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public byte[] toByteArray(DumpHeaderTrasporto dumpHeaderTrasporto) throws SerializerException {
		return this.objToXml(DumpHeaderTrasporto.class, dumpHeaderTrasporto, false).toByteArray();
	}
	/**
	 * Serialize to byte array the object <var>dumpHeaderTrasporto</var> of type {@link org.openspcoop2.core.transazioni.DumpHeaderTrasporto}
	 * 
	 * @param dumpHeaderTrasporto Object to be serialized
	 * @param prettyPrint if true output the XML with indenting
	 * @return Object to be serialized in byte array
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public byte[] toByteArray(DumpHeaderTrasporto dumpHeaderTrasporto,boolean prettyPrint) throws SerializerException {
		return this.objToXml(DumpHeaderTrasporto.class, dumpHeaderTrasporto, prettyPrint).toByteArray();
	}
	
	/**
	 * Serialize to String the object <var>dumpHeaderTrasporto</var> of type {@link org.openspcoop2.core.transazioni.DumpHeaderTrasporto}
	 * 
	 * @param dumpHeaderTrasporto Object to be serialized
	 * @return Object to be serialized as String
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public String toString(DumpHeaderTrasporto dumpHeaderTrasporto) throws SerializerException {
		return this.objToXml(DumpHeaderTrasporto.class, dumpHeaderTrasporto, false).toString();
	}
	/**
	 * Serialize to String the object <var>dumpHeaderTrasporto</var> of type {@link org.openspcoop2.core.transazioni.DumpHeaderTrasporto}
	 * 
	 * @param dumpHeaderTrasporto Object to be serialized
	 * @param prettyPrint if true output the XML with indenting
	 * @return Object to be serialized as String
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public String toString(DumpHeaderTrasporto dumpHeaderTrasporto,boolean prettyPrint) throws SerializerException {
		return this.objToXml(DumpHeaderTrasporto.class, dumpHeaderTrasporto, prettyPrint).toString();
	}
	
	
	
	/*
	 =================================================================================
	 Object: transazione
	 =================================================================================
	*/
	
	/**
	 * Serialize to file system in <var>fileName</var> the object <var>transazione</var> of type {@link org.openspcoop2.core.transazioni.Transazione}
	 * 
	 * @param fileName Xml file to serialize the object <var>transazione</var>
	 * @param transazione Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(String fileName,Transazione transazione) throws SerializerException {
		this.objToXml(fileName, Transazione.class, transazione, false);
	}
	/**
	 * Serialize to file system in <var>fileName</var> the object <var>transazione</var> of type {@link org.openspcoop2.core.transazioni.Transazione}
	 * 
	 * @param fileName Xml file to serialize the object <var>transazione</var>
	 * @param transazione Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(String fileName,Transazione transazione,boolean prettyPrint) throws SerializerException {
		this.objToXml(fileName, Transazione.class, transazione, prettyPrint);
	}
	
	/**
	 * Serialize to file system in <var>file</var> the object <var>transazione</var> of type {@link org.openspcoop2.core.transazioni.Transazione}
	 * 
	 * @param file Xml file to serialize the object <var>transazione</var>
	 * @param transazione Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(File file,Transazione transazione) throws SerializerException {
		this.objToXml(file, Transazione.class, transazione, false);
	}
	/**
	 * Serialize to file system in <var>file</var> the object <var>transazione</var> of type {@link org.openspcoop2.core.transazioni.Transazione}
	 * 
	 * @param file Xml file to serialize the object <var>transazione</var>
	 * @param transazione Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(File file,Transazione transazione,boolean prettyPrint) throws SerializerException {
		this.objToXml(file, Transazione.class, transazione, prettyPrint);
	}
	
	/**
	 * Serialize to output stream <var>out</var> the object <var>transazione</var> of type {@link org.openspcoop2.core.transazioni.Transazione}
	 * 
	 * @param out OutputStream to serialize the object <var>transazione</var>
	 * @param transazione Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(OutputStream out,Transazione transazione) throws SerializerException {
		this.objToXml(out, Transazione.class, transazione, false);
	}
	/**
	 * Serialize to output stream <var>out</var> the object <var>transazione</var> of type {@link org.openspcoop2.core.transazioni.Transazione}
	 * 
	 * @param out OutputStream to serialize the object <var>transazione</var>
	 * @param transazione Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(OutputStream out,Transazione transazione,boolean prettyPrint) throws SerializerException {
		this.objToXml(out, Transazione.class, transazione, prettyPrint);
	}
			
	/**
	 * Serialize to byte array the object <var>transazione</var> of type {@link org.openspcoop2.core.transazioni.Transazione}
	 * 
	 * @param transazione Object to be serialized
	 * @return Object to be serialized in byte array
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public byte[] toByteArray(Transazione transazione) throws SerializerException {
		return this.objToXml(Transazione.class, transazione, false).toByteArray();
	}
	/**
	 * Serialize to byte array the object <var>transazione</var> of type {@link org.openspcoop2.core.transazioni.Transazione}
	 * 
	 * @param transazione Object to be serialized
	 * @param prettyPrint if true output the XML with indenting
	 * @return Object to be serialized in byte array
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public byte[] toByteArray(Transazione transazione,boolean prettyPrint) throws SerializerException {
		return this.objToXml(Transazione.class, transazione, prettyPrint).toByteArray();
	}
	
	/**
	 * Serialize to String the object <var>transazione</var> of type {@link org.openspcoop2.core.transazioni.Transazione}
	 * 
	 * @param transazione Object to be serialized
	 * @return Object to be serialized as String
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public String toString(Transazione transazione) throws SerializerException {
		return this.objToXml(Transazione.class, transazione, false).toString();
	}
	/**
	 * Serialize to String the object <var>transazione</var> of type {@link org.openspcoop2.core.transazioni.Transazione}
	 * 
	 * @param transazione Object to be serialized
	 * @param prettyPrint if true output the XML with indenting
	 * @return Object to be serialized as String
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public String toString(Transazione transazione,boolean prettyPrint) throws SerializerException {
		return this.objToXml(Transazione.class, transazione, prettyPrint).toString();
	}
	
	
	
	/*
	 =================================================================================
	 Object: transazione-extended-info
	 =================================================================================
	*/
	
	/**
	 * Serialize to file system in <var>fileName</var> the object <var>transazioneExtendedInfo</var> of type {@link org.openspcoop2.core.transazioni.TransazioneExtendedInfo}
	 * 
	 * @param fileName Xml file to serialize the object <var>transazioneExtendedInfo</var>
	 * @param transazioneExtendedInfo Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(String fileName,TransazioneExtendedInfo transazioneExtendedInfo) throws SerializerException {
		this.objToXml(fileName, TransazioneExtendedInfo.class, transazioneExtendedInfo, false);
	}
	/**
	 * Serialize to file system in <var>fileName</var> the object <var>transazioneExtendedInfo</var> of type {@link org.openspcoop2.core.transazioni.TransazioneExtendedInfo}
	 * 
	 * @param fileName Xml file to serialize the object <var>transazioneExtendedInfo</var>
	 * @param transazioneExtendedInfo Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(String fileName,TransazioneExtendedInfo transazioneExtendedInfo,boolean prettyPrint) throws SerializerException {
		this.objToXml(fileName, TransazioneExtendedInfo.class, transazioneExtendedInfo, prettyPrint);
	}
	
	/**
	 * Serialize to file system in <var>file</var> the object <var>transazioneExtendedInfo</var> of type {@link org.openspcoop2.core.transazioni.TransazioneExtendedInfo}
	 * 
	 * @param file Xml file to serialize the object <var>transazioneExtendedInfo</var>
	 * @param transazioneExtendedInfo Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(File file,TransazioneExtendedInfo transazioneExtendedInfo) throws SerializerException {
		this.objToXml(file, TransazioneExtendedInfo.class, transazioneExtendedInfo, false);
	}
	/**
	 * Serialize to file system in <var>file</var> the object <var>transazioneExtendedInfo</var> of type {@link org.openspcoop2.core.transazioni.TransazioneExtendedInfo}
	 * 
	 * @param file Xml file to serialize the object <var>transazioneExtendedInfo</var>
	 * @param transazioneExtendedInfo Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(File file,TransazioneExtendedInfo transazioneExtendedInfo,boolean prettyPrint) throws SerializerException {
		this.objToXml(file, TransazioneExtendedInfo.class, transazioneExtendedInfo, prettyPrint);
	}
	
	/**
	 * Serialize to output stream <var>out</var> the object <var>transazioneExtendedInfo</var> of type {@link org.openspcoop2.core.transazioni.TransazioneExtendedInfo}
	 * 
	 * @param out OutputStream to serialize the object <var>transazioneExtendedInfo</var>
	 * @param transazioneExtendedInfo Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(OutputStream out,TransazioneExtendedInfo transazioneExtendedInfo) throws SerializerException {
		this.objToXml(out, TransazioneExtendedInfo.class, transazioneExtendedInfo, false);
	}
	/**
	 * Serialize to output stream <var>out</var> the object <var>transazioneExtendedInfo</var> of type {@link org.openspcoop2.core.transazioni.TransazioneExtendedInfo}
	 * 
	 * @param out OutputStream to serialize the object <var>transazioneExtendedInfo</var>
	 * @param transazioneExtendedInfo Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(OutputStream out,TransazioneExtendedInfo transazioneExtendedInfo,boolean prettyPrint) throws SerializerException {
		this.objToXml(out, TransazioneExtendedInfo.class, transazioneExtendedInfo, prettyPrint);
	}
			
	/**
	 * Serialize to byte array the object <var>transazioneExtendedInfo</var> of type {@link org.openspcoop2.core.transazioni.TransazioneExtendedInfo}
	 * 
	 * @param transazioneExtendedInfo Object to be serialized
	 * @return Object to be serialized in byte array
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public byte[] toByteArray(TransazioneExtendedInfo transazioneExtendedInfo) throws SerializerException {
		return this.objToXml(TransazioneExtendedInfo.class, transazioneExtendedInfo, false).toByteArray();
	}
	/**
	 * Serialize to byte array the object <var>transazioneExtendedInfo</var> of type {@link org.openspcoop2.core.transazioni.TransazioneExtendedInfo}
	 * 
	 * @param transazioneExtendedInfo Object to be serialized
	 * @param prettyPrint if true output the XML with indenting
	 * @return Object to be serialized in byte array
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public byte[] toByteArray(TransazioneExtendedInfo transazioneExtendedInfo,boolean prettyPrint) throws SerializerException {
		return this.objToXml(TransazioneExtendedInfo.class, transazioneExtendedInfo, prettyPrint).toByteArray();
	}
	
	/**
	 * Serialize to String the object <var>transazioneExtendedInfo</var> of type {@link org.openspcoop2.core.transazioni.TransazioneExtendedInfo}
	 * 
	 * @param transazioneExtendedInfo Object to be serialized
	 * @return Object to be serialized as String
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public String toString(TransazioneExtendedInfo transazioneExtendedInfo) throws SerializerException {
		return this.objToXml(TransazioneExtendedInfo.class, transazioneExtendedInfo, false).toString();
	}
	/**
	 * Serialize to String the object <var>transazioneExtendedInfo</var> of type {@link org.openspcoop2.core.transazioni.TransazioneExtendedInfo}
	 * 
	 * @param transazioneExtendedInfo Object to be serialized
	 * @param prettyPrint if true output the XML with indenting
	 * @return Object to be serialized as String
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public String toString(TransazioneExtendedInfo transazioneExtendedInfo,boolean prettyPrint) throws SerializerException {
		return this.objToXml(TransazioneExtendedInfo.class, transazioneExtendedInfo, prettyPrint).toString();
	}
	
	
	
	/*
	 =================================================================================
	 Object: id-dump-messaggio
	 =================================================================================
	*/
	
	/**
	 * Serialize to file system in <var>fileName</var> the object <var>idDumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.IdDumpMessaggio}
	 * 
	 * @param fileName Xml file to serialize the object <var>idDumpMessaggio</var>
	 * @param idDumpMessaggio Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(String fileName,IdDumpMessaggio idDumpMessaggio) throws SerializerException {
		this.objToXml(fileName, IdDumpMessaggio.class, idDumpMessaggio, false);
	}
	/**
	 * Serialize to file system in <var>fileName</var> the object <var>idDumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.IdDumpMessaggio}
	 * 
	 * @param fileName Xml file to serialize the object <var>idDumpMessaggio</var>
	 * @param idDumpMessaggio Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(String fileName,IdDumpMessaggio idDumpMessaggio,boolean prettyPrint) throws SerializerException {
		this.objToXml(fileName, IdDumpMessaggio.class, idDumpMessaggio, prettyPrint);
	}
	
	/**
	 * Serialize to file system in <var>file</var> the object <var>idDumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.IdDumpMessaggio}
	 * 
	 * @param file Xml file to serialize the object <var>idDumpMessaggio</var>
	 * @param idDumpMessaggio Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(File file,IdDumpMessaggio idDumpMessaggio) throws SerializerException {
		this.objToXml(file, IdDumpMessaggio.class, idDumpMessaggio, false);
	}
	/**
	 * Serialize to file system in <var>file</var> the object <var>idDumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.IdDumpMessaggio}
	 * 
	 * @param file Xml file to serialize the object <var>idDumpMessaggio</var>
	 * @param idDumpMessaggio Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(File file,IdDumpMessaggio idDumpMessaggio,boolean prettyPrint) throws SerializerException {
		this.objToXml(file, IdDumpMessaggio.class, idDumpMessaggio, prettyPrint);
	}
	
	/**
	 * Serialize to output stream <var>out</var> the object <var>idDumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.IdDumpMessaggio}
	 * 
	 * @param out OutputStream to serialize the object <var>idDumpMessaggio</var>
	 * @param idDumpMessaggio Object to be serialized in xml file <var>fileName</var>
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(OutputStream out,IdDumpMessaggio idDumpMessaggio) throws SerializerException {
		this.objToXml(out, IdDumpMessaggio.class, idDumpMessaggio, false);
	}
	/**
	 * Serialize to output stream <var>out</var> the object <var>idDumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.IdDumpMessaggio}
	 * 
	 * @param out OutputStream to serialize the object <var>idDumpMessaggio</var>
	 * @param idDumpMessaggio Object to be serialized in xml file <var>fileName</var>
	 * @param prettyPrint if true output the XML with indenting
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public void write(OutputStream out,IdDumpMessaggio idDumpMessaggio,boolean prettyPrint) throws SerializerException {
		this.objToXml(out, IdDumpMessaggio.class, idDumpMessaggio, prettyPrint);
	}
			
	/**
	 * Serialize to byte array the object <var>idDumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.IdDumpMessaggio}
	 * 
	 * @param idDumpMessaggio Object to be serialized
	 * @return Object to be serialized in byte array
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public byte[] toByteArray(IdDumpMessaggio idDumpMessaggio) throws SerializerException {
		return this.objToXml(IdDumpMessaggio.class, idDumpMessaggio, false).toByteArray();
	}
	/**
	 * Serialize to byte array the object <var>idDumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.IdDumpMessaggio}
	 * 
	 * @param idDumpMessaggio Object to be serialized
	 * @param prettyPrint if true output the XML with indenting
	 * @return Object to be serialized in byte array
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public byte[] toByteArray(IdDumpMessaggio idDumpMessaggio,boolean prettyPrint) throws SerializerException {
		return this.objToXml(IdDumpMessaggio.class, idDumpMessaggio, prettyPrint).toByteArray();
	}
	
	/**
	 * Serialize to String the object <var>idDumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.IdDumpMessaggio}
	 * 
	 * @param idDumpMessaggio Object to be serialized
	 * @return Object to be serialized as String
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public String toString(IdDumpMessaggio idDumpMessaggio) throws SerializerException {
		return this.objToXml(IdDumpMessaggio.class, idDumpMessaggio, false).toString();
	}
	/**
	 * Serialize to String the object <var>idDumpMessaggio</var> of type {@link org.openspcoop2.core.transazioni.IdDumpMessaggio}
	 * 
	 * @param idDumpMessaggio Object to be serialized
	 * @param prettyPrint if true output the XML with indenting
	 * @return Object to be serialized as String
	 * @throws SerializerException The exception that is thrown when an error occurs during serialization
	 */
	public String toString(IdDumpMessaggio idDumpMessaggio,boolean prettyPrint) throws SerializerException {
		return this.objToXml(IdDumpMessaggio.class, idDumpMessaggio, prettyPrint).toString();
	}
	
	
	

}
