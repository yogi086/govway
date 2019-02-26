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
package it.gov.fatturapa.sdi.fatturapa.v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/** <p>Java class for ContattiType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContattiType">
 * 		&lt;sequence>
 * 			&lt;element name="Telefono" type="{http://www.fatturapa.gov.it/sdi/fatturapa/v1.0}normalizedString" minOccurs="0" maxOccurs="1"/>
 * 			&lt;element name="Fax" type="{http://www.fatturapa.gov.it/sdi/fatturapa/v1.0}normalizedString" minOccurs="0" maxOccurs="1"/>
 * 			&lt;element name="Email" type="{http://www.fatturapa.gov.it/sdi/fatturapa/v1.0}string" minOccurs="0" maxOccurs="1"/>
 * 		&lt;/sequence>
 * &lt;/complexType>
 * </pre>
 * 
 * @version $Rev$, $Date$
 * 
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContattiType", 
  propOrder = {
  	"telefono",
  	"fax",
  	"email"
  }
)

@XmlRootElement(name = "ContattiType")

public class ContattiType extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable {
  public ContattiType() {
  }

  public java.lang.String getTelefono() {
    return this.telefono;
  }

  public void setTelefono(java.lang.String telefono) {
    this.telefono = telefono;
  }

  public java.lang.String getFax() {
    return this.fax;
  }

  public void setFax(java.lang.String fax) {
    this.fax = fax;
  }

  public java.lang.String getEmail() {
    return this.email;
  }

  public void setEmail(java.lang.String email) {
    this.email = email;
  }

  private static final long serialVersionUID = 1L;



  @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(javax.xml.bind.annotation.adapters.NormalizedStringAdapter.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="normalizedString")
  @XmlElement(name="Telefono",required=false,nillable=false)
  protected java.lang.String telefono;

  @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(javax.xml.bind.annotation.adapters.NormalizedStringAdapter.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="normalizedString")
  @XmlElement(name="Fax",required=false,nillable=false)
  protected java.lang.String fax;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="Email",required=false,nillable=false)
  protected java.lang.String email;

}
