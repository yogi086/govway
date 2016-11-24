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
package org.openspcoop2.protocol.manifest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.openspcoop2.protocol.manifest.constants.ServiceBinding;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/** <p>Java class for Context complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Context">
 * 		&lt;sequence>
 * 			&lt;element name="subContext" type="{http://www.openspcoop2.org/protocol/manifest}SubContextMapping" minOccurs="0" maxOccurs="unbounded"/>
 * 			&lt;element name="emptySubContext" type="{http://www.openspcoop2.org/protocol/manifest}EmptySubContextMapping" minOccurs="0" maxOccurs="1"/>
 * 			&lt;element name="soapMediaTypeCollection" type="{http://www.openspcoop2.org/protocol/manifest}SoapMediaTypeCollection" minOccurs="0" maxOccurs="1"/>
 * 			&lt;element name="restMediaTypeCollection" type="{http://www.openspcoop2.org/protocol/manifest}RestMediaTypeCollection" minOccurs="0" maxOccurs="1"/>
 * 		&lt;/sequence>
 * 		&lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" use="required"/>
 * 		&lt;attribute name="binding" type="{http://www.openspcoop2.org/protocol/manifest}ServiceBinding" use="optional"/>
 * &lt;/complexType>
 * </pre>
 * 
 * @version $Rev$, $Date$
 * 
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Context", 
  propOrder = {
  	"subContext",
  	"emptySubContext",
  	"soapMediaTypeCollection",
  	"restMediaTypeCollection"
  }
)

@XmlRootElement(name = "Context")

public class Context extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable {
  public Context() {
  }

  public Long getId() {
    if(this.id!=null)
		return this.id;
	else
		return new Long(-1);
  }

  public void setId(Long id) {
    if(id!=null)
		this.id=id;
	else
		this.id=new Long(-1);
  }

  public void addSubContext(SubContextMapping subContext) {
    this.subContext.add(subContext);
  }

  public SubContextMapping getSubContext(int index) {
    return this.subContext.get( index );
  }

  public SubContextMapping removeSubContext(int index) {
    return this.subContext.remove( index );
  }

  public List<SubContextMapping> getSubContextList() {
    return this.subContext;
  }

  public void setSubContextList(List<SubContextMapping> subContext) {
    this.subContext=subContext;
  }

  public int sizeSubContextList() {
    return this.subContext.size();
  }

  public EmptySubContextMapping getEmptySubContext() {
    return this.emptySubContext;
  }

  public void setEmptySubContext(EmptySubContextMapping emptySubContext) {
    this.emptySubContext = emptySubContext;
  }

  public SoapMediaTypeCollection getSoapMediaTypeCollection() {
    return this.soapMediaTypeCollection;
  }

  public void setSoapMediaTypeCollection(SoapMediaTypeCollection soapMediaTypeCollection) {
    this.soapMediaTypeCollection = soapMediaTypeCollection;
  }

  public RestMediaTypeCollection getRestMediaTypeCollection() {
    return this.restMediaTypeCollection;
  }

  public void setRestMediaTypeCollection(RestMediaTypeCollection restMediaTypeCollection) {
    this.restMediaTypeCollection = restMediaTypeCollection;
  }

  public java.lang.String getName() {
    return this.name;
  }

  public void setName(java.lang.String name) {
    this.name = name;
  }

  public void set_value_binding(String value) {
    this.binding = (ServiceBinding) ServiceBinding.toEnumConstantFromString(value);
  }

  public String get_value_binding() {
    if(this.binding == null){
    	return null;
    }else{
    	return this.binding.toString();
    }
  }

  public org.openspcoop2.protocol.manifest.constants.ServiceBinding getBinding() {
    return this.binding;
  }

  public void setBinding(org.openspcoop2.protocol.manifest.constants.ServiceBinding binding) {
    this.binding = binding;
  }

  private static final long serialVersionUID = 1L;

  @XmlTransient
  private Long id;



  @XmlElement(name="subContext",required=true,nillable=false)
  protected List<SubContextMapping> subContext = new ArrayList<SubContextMapping>();

  /**
   * @deprecated Use method getSubContextList
   * @return List<SubContextMapping>
  */
  @Deprecated
  public List<SubContextMapping> getSubContext() {
  	return this.subContext;
  }

  /**
   * @deprecated Use method setSubContextList
   * @param subContext List<SubContextMapping>
  */
  @Deprecated
  public void setSubContext(List<SubContextMapping> subContext) {
  	this.subContext=subContext;
  }

  /**
   * @deprecated Use method sizeSubContextList
   * @return lunghezza della lista
  */
  @Deprecated
  public int sizeSubContext() {
  	return this.subContext.size();
  }

  @XmlElement(name="emptySubContext",required=false,nillable=false)
  protected EmptySubContextMapping emptySubContext;

  @XmlElement(name="soapMediaTypeCollection",required=false,nillable=false)
  protected SoapMediaTypeCollection soapMediaTypeCollection;

  @XmlElement(name="restMediaTypeCollection",required=false,nillable=false)
  protected RestMediaTypeCollection restMediaTypeCollection;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlAttribute(name="name",required=true)
  protected java.lang.String name;

  @XmlTransient
  protected java.lang.String _value_binding;

  @XmlAttribute(name="binding",required=false)
  protected ServiceBinding binding;

}