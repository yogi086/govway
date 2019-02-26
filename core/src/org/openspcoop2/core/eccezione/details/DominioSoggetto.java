/*
 * GovWay - A customizable API Gateway 
 * http://www.govway.org
 *
 * from the Link.it OpenSPCoop project codebase
 * 
 * Copyright (c) 2005-2019 Link.it srl (http://link.it).
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
package org.openspcoop2.core.eccezione.details;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/** <p>Java class for dominio-soggetto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dominio-soggetto">
 * 		<xsd:simpleContent>
 * 			<xsd:extension base="{http://www.w3.org/2001/XMLSchema}string">
 * 				&lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" use="required"/>
 * 			</xsd:extension>
 * 		</xsd:simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @version $Rev$, $Date$
 * 
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dominio-soggetto")

@XmlRootElement(name = "dominio-soggetto")

public class DominioSoggetto extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable {
  public DominioSoggetto() {
  }

  public String getBase() {
    if(this.base!=null && ("".equals(this.base)==false)){
		return this.base.trim();
	}else{
		return null;
	}

  }

  public void setBase(String base) {
    this.base=base;
  }

  public java.lang.String getType() {
    return this.type;
  }

  public void setType(java.lang.String type) {
    this.type = type;
  }

  private static final long serialVersionUID = 1L;



  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @javax.xml.bind.annotation.XmlValue()
  public String base;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlAttribute(name="type",required=true)
  protected java.lang.String type;

}
