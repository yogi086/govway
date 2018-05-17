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
package org.openspcoop2.monitor.engine.config.statistiche;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/** <p>Java class for id-configurazione-statistica complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="id-configurazione-statistica">
 * 		&lt;sequence>
 * 			&lt;element name="id-configurazione-servizio-azione" type="{http://www.openspcoop2.org/monitor/engine/config/statistiche}id-configurazione-servizio-azione" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="id-configurazione-statistica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="1" maxOccurs="1"/>
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
@XmlType(name = "id-configurazione-statistica", 
  propOrder = {
  	"idConfigurazioneServizioAzione",
  	"idConfigurazioneStatistica"
  }
)

@XmlRootElement(name = "id-configurazione-statistica")

public class IdConfigurazioneStatistica extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable {
  public IdConfigurazioneStatistica() {
  }

  public Long getId() {
    if(this.id!=null)
		return this.id;
	else
		return Long.valueOf(-1);
  }

  public void setId(Long id) {
    if(id!=null)
		this.id=id;
	else
		this.id=Long.valueOf(-1);
  }

  public IdConfigurazioneServizioAzione getIdConfigurazioneServizioAzione() {
    return this.idConfigurazioneServizioAzione;
  }

  public void setIdConfigurazioneServizioAzione(IdConfigurazioneServizioAzione idConfigurazioneServizioAzione) {
    this.idConfigurazioneServizioAzione = idConfigurazioneServizioAzione;
  }

  public java.lang.String getIdConfigurazioneStatistica() {
    return this.idConfigurazioneStatistica;
  }

  public void setIdConfigurazioneStatistica(java.lang.String idConfigurazioneStatistica) {
    this.idConfigurazioneStatistica = idConfigurazioneStatistica;
  }

  private static final long serialVersionUID = 1L;

  @XmlTransient
  private Long id;



  @XmlElement(name="id-configurazione-servizio-azione",required=true,nillable=false)
  protected IdConfigurazioneServizioAzione idConfigurazioneServizioAzione;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="id-configurazione-statistica",required=true,nillable=false)
  protected java.lang.String idConfigurazioneStatistica;

}