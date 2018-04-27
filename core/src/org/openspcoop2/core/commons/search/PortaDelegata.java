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
package org.openspcoop2.core.commons.search;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/** <p>Java class for porta-delegata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="porta-delegata">
 * 		&lt;sequence>
 * 			&lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="stato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1"/>
 * 			&lt;element name="id-soggetto" type="{http://www.openspcoop2.org/core/commons/search}id-soggetto" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="tipo_soggetto_erogatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="nome_soggetto_erogatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="tipo_servizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="nome_servizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="nome_azione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="porta-delegata-servizio-applicativo" type="{http://www.openspcoop2.org/core/commons/search}porta-delegata-servizio-applicativo" minOccurs="0" maxOccurs="unbounded"/>
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
@XmlType(name = "porta-delegata", 
  propOrder = {
  	"nome",
  	"stato",
  	"idSoggetto",
  	"tipoSoggettoErogatore",
  	"nomeSoggettoErogatore",
  	"tipoServizio",
  	"nomeServizio",
  	"nomeAzione",
  	"portaDelegataServizioApplicativo"
  }
)

@XmlRootElement(name = "porta-delegata")

public class PortaDelegata extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable {
  public PortaDelegata() {
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

  public java.lang.String getNome() {
    return this.nome;
  }

  public void setNome(java.lang.String nome) {
    this.nome = nome;
  }

  public java.lang.String getStato() {
    return this.stato;
  }

  public void setStato(java.lang.String stato) {
    this.stato = stato;
  }

  public IdSoggetto getIdSoggetto() {
    return this.idSoggetto;
  }

  public void setIdSoggetto(IdSoggetto idSoggetto) {
    this.idSoggetto = idSoggetto;
  }

  public java.lang.String getTipoSoggettoErogatore() {
    return this.tipoSoggettoErogatore;
  }

  public void setTipoSoggettoErogatore(java.lang.String tipoSoggettoErogatore) {
    this.tipoSoggettoErogatore = tipoSoggettoErogatore;
  }

  public java.lang.String getNomeSoggettoErogatore() {
    return this.nomeSoggettoErogatore;
  }

  public void setNomeSoggettoErogatore(java.lang.String nomeSoggettoErogatore) {
    this.nomeSoggettoErogatore = nomeSoggettoErogatore;
  }

  public java.lang.String getTipoServizio() {
    return this.tipoServizio;
  }

  public void setTipoServizio(java.lang.String tipoServizio) {
    this.tipoServizio = tipoServizio;
  }

  public java.lang.String getNomeServizio() {
    return this.nomeServizio;
  }

  public void setNomeServizio(java.lang.String nomeServizio) {
    this.nomeServizio = nomeServizio;
  }

  public java.lang.String getNomeAzione() {
    return this.nomeAzione;
  }

  public void setNomeAzione(java.lang.String nomeAzione) {
    this.nomeAzione = nomeAzione;
  }

  public void addPortaDelegataServizioApplicativo(PortaDelegataServizioApplicativo portaDelegataServizioApplicativo) {
    this.portaDelegataServizioApplicativo.add(portaDelegataServizioApplicativo);
  }

  public PortaDelegataServizioApplicativo getPortaDelegataServizioApplicativo(int index) {
    return this.portaDelegataServizioApplicativo.get( index );
  }

  public PortaDelegataServizioApplicativo removePortaDelegataServizioApplicativo(int index) {
    return this.portaDelegataServizioApplicativo.remove( index );
  }

  public List<PortaDelegataServizioApplicativo> getPortaDelegataServizioApplicativoList() {
    return this.portaDelegataServizioApplicativo;
  }

  public void setPortaDelegataServizioApplicativoList(List<PortaDelegataServizioApplicativo> portaDelegataServizioApplicativo) {
    this.portaDelegataServizioApplicativo=portaDelegataServizioApplicativo;
  }

  public int sizePortaDelegataServizioApplicativoList() {
    return this.portaDelegataServizioApplicativo.size();
  }

  private static final long serialVersionUID = 1L;

  @XmlTransient
  private Long id;

  private static org.openspcoop2.core.commons.search.model.PortaDelegataModel modelStaticInstance = null;
  private static synchronized void initModelStaticInstance(){
	  if(org.openspcoop2.core.commons.search.PortaDelegata.modelStaticInstance==null){
  			org.openspcoop2.core.commons.search.PortaDelegata.modelStaticInstance = new org.openspcoop2.core.commons.search.model.PortaDelegataModel();
	  }
  }
  public static org.openspcoop2.core.commons.search.model.PortaDelegataModel model(){
	  if(org.openspcoop2.core.commons.search.PortaDelegata.modelStaticInstance==null){
	  		initModelStaticInstance();
	  }
	  return org.openspcoop2.core.commons.search.PortaDelegata.modelStaticInstance;
  }


  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="nome",required=true,nillable=false)
  protected java.lang.String nome;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="stato",required=false,nillable=false)
  protected java.lang.String stato;

  @XmlElement(name="id-soggetto",required=true,nillable=false)
  protected IdSoggetto idSoggetto;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="tipo_soggetto_erogatore",required=true,nillable=false)
  protected java.lang.String tipoSoggettoErogatore;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="nome_soggetto_erogatore",required=true,nillable=false)
  protected java.lang.String nomeSoggettoErogatore;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="tipo_servizio",required=true,nillable=false)
  protected java.lang.String tipoServizio;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="nome_servizio",required=true,nillable=false)
  protected java.lang.String nomeServizio;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="nome_azione",required=true,nillable=false)
  protected java.lang.String nomeAzione;

  @XmlElement(name="porta-delegata-servizio-applicativo",required=true,nillable=false)
  protected List<PortaDelegataServizioApplicativo> portaDelegataServizioApplicativo = new ArrayList<PortaDelegataServizioApplicativo>();

  /**
   * @deprecated Use method getPortaDelegataServizioApplicativoList
   * @return List<PortaDelegataServizioApplicativo>
  */
  @Deprecated
  public List<PortaDelegataServizioApplicativo> getPortaDelegataServizioApplicativo() {
  	return this.portaDelegataServizioApplicativo;
  }

  /**
   * @deprecated Use method setPortaDelegataServizioApplicativoList
   * @param portaDelegataServizioApplicativo List<PortaDelegataServizioApplicativo>
  */
  @Deprecated
  public void setPortaDelegataServizioApplicativo(List<PortaDelegataServizioApplicativo> portaDelegataServizioApplicativo) {
  	this.portaDelegataServizioApplicativo=portaDelegataServizioApplicativo;
  }

  /**
   * @deprecated Use method sizePortaDelegataServizioApplicativoList
   * @return lunghezza della lista
  */
  @Deprecated
  public int sizePortaDelegataServizioApplicativo() {
  	return this.portaDelegataServizioApplicativo.size();
  }

}