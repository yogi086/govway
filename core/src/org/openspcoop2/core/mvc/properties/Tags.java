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
package org.openspcoop2.core.mvc.properties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/** <p>Java class for tags complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tags">
 * 		&lt;sequence>
 * 			&lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="1" maxOccurs="unbounded"/>
 * 		&lt;/sequence>
 * 		&lt;attribute name="and" type="{http://www.w3.org/2001/XMLSchema}boolean" use="optional" default="true"/>
 * 		&lt;attribute name="not" type="{http://www.w3.org/2001/XMLSchema}boolean" use="optional" default="false"/>
 * &lt;/complexType>
 * </pre>
 * 
 * @version $Rev$, $Date$
 * 
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tags", 
  propOrder = {
  	"tag"
  }
)

@XmlRootElement(name = "tags")

public class Tags extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable {
  public Tags() {
  }

  public void addTag(java.lang.String tag) {
    this.tag.add(tag);
  }

  public java.lang.String getTag(int index) {
    return this.tag.get( index );
  }

  public java.lang.String removeTag(int index) {
    return this.tag.remove( index );
  }

  public List<java.lang.String> getTagList() {
    return this.tag;
  }

  public void setTagList(List<java.lang.String> tag) {
    this.tag=tag;
  }

  public int sizeTagList() {
    return this.tag.size();
  }

  public boolean isAnd() {
    return this.and;
  }

  public boolean getAnd() {
    return this.and;
  }

  public void setAnd(boolean and) {
    this.and = and;
  }

  public boolean isNot() {
    return this.not;
  }

  public boolean getNot() {
    return this.not;
  }

  public void setNot(boolean not) {
    this.not = not;
  }

  private static final long serialVersionUID = 1L;



  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="tag",required=true,nillable=false)
  protected List<java.lang.String> tag = new ArrayList<java.lang.String>();

  /**
   * @deprecated Use method getTagList
   * @return List<java.lang.String>
  */
  @Deprecated
  public List<java.lang.String> getTag() {
  	return this.tag;
  }

  /**
   * @deprecated Use method setTagList
   * @param tag List<java.lang.String>
  */
  @Deprecated
  public void setTag(List<java.lang.String> tag) {
  	this.tag=tag;
  }

  /**
   * @deprecated Use method sizeTagList
   * @return lunghezza della lista
  */
  @Deprecated
  public int sizeTag() {
  	return this.tag.size();
  }

  @javax.xml.bind.annotation.XmlSchemaType(name="boolean")
  @XmlAttribute(name="and",required=false)
  protected boolean and = true;

  @javax.xml.bind.annotation.XmlSchemaType(name="boolean")
  @XmlAttribute(name="not",required=false)
  protected boolean not = false;

}
