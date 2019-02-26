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

package org.openspcoop2.core.registry.ws.client.accordocooperazione.all;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.openspcoop2.core.registry.AccordoCooperazione;
import org.openspcoop2.core.registry.IdAccordoCooperazione;


/**
 * <p>Java class for update complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="update"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="oldIdAccordoCooperazione" type="{http://www.openspcoop2.org/core/registry}id-accordo-cooperazione"/&gt;
 *         &lt;element name="accordoCooperazione" type="{http://www.openspcoop2.org/core/registry}accordo-cooperazione"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "update", propOrder = {
    "oldIdAccordoCooperazione",
    "accordoCooperazione"
})
public class Update {

    @XmlElement(required = true)
    protected IdAccordoCooperazione oldIdAccordoCooperazione;
    @XmlElement(required = true)
    protected AccordoCooperazione accordoCooperazione;

    /**
     * Gets the value of the oldIdAccordoCooperazione property.
     * 
     * @return
     *     possible object is
     *     {@link IdAccordoCooperazione }
     *     
     */
    public IdAccordoCooperazione getOldIdAccordoCooperazione() {
        return this.oldIdAccordoCooperazione;
    }

    /**
     * Sets the value of the oldIdAccordoCooperazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdAccordoCooperazione }
     *     
     */
    public void setOldIdAccordoCooperazione(IdAccordoCooperazione value) {
        this.oldIdAccordoCooperazione = value;
    }

    /**
     * Gets the value of the accordoCooperazione property.
     * 
     * @return
     *     possible object is
     *     {@link AccordoCooperazione }
     *     
     */
    public AccordoCooperazione getAccordoCooperazione() {
        return this.accordoCooperazione;
    }

    /**
     * Sets the value of the accordoCooperazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccordoCooperazione }
     *     
     */
    public void setAccordoCooperazione(AccordoCooperazione value) {
        this.accordoCooperazione = value;
    }

}
