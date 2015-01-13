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

package org.openspcoop2.core.config.ws.client.portaapplicativa.all;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.openspcoop2.core.config.IdPortaApplicativa;


/**
 * <p>Java class for inUse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="inUse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idPortaApplicativa" type="{http://www.openspcoop2.org/core/config}id-porta-applicativa"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inUse", propOrder = {
    "idPortaApplicativa"
})
public class InUse {

    @XmlElement(required = true)
    protected IdPortaApplicativa idPortaApplicativa;

    /**
     * Gets the value of the idPortaApplicativa property.
     * 
     * @return
     *     possible object is
     *     {@link IdPortaApplicativa }
     *     
     */
    public IdPortaApplicativa getIdPortaApplicativa() {
        return this.idPortaApplicativa;
    }

    /**
     * Sets the value of the idPortaApplicativa property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdPortaApplicativa }
     *     
     */
    public void setIdPortaApplicativa(IdPortaApplicativa value) {
        this.idPortaApplicativa = value;
    }

}
