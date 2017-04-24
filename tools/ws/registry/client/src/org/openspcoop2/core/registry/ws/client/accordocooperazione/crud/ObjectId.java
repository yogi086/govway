
package org.openspcoop2.core.registry.ws.client.accordocooperazione.crud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for objectId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="objectId"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://www.openspcoop2.org/core/registry/management}wrapperIdAccordoCooperazione"/&gt;
 *         &lt;element ref="{http://www.openspcoop2.org/core/registry/management}wrapperIdAccordoServizioParteComune"/&gt;
 *         &lt;element ref="{http://www.openspcoop2.org/core/registry/management}wrapperIdPortaDominio"/&gt;
 *         &lt;element ref="{http://www.openspcoop2.org/core/registry/management}wrapperIdSoggetto"/&gt;
 *         &lt;element ref="{http://www.openspcoop2.org/core/registry/management}wrapperIdAccordoServizioParteSpecifica"/&gt;
 *         &lt;element ref="{http://www.openspcoop2.org/core/registry/management}wrapperIdRuolo"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "objectId", propOrder = {
    "wrapperIdAccordoCooperazione",
    "wrapperIdAccordoServizioParteComune",
    "wrapperIdPortaDominio",
    "wrapperIdSoggetto",
    "wrapperIdAccordoServizioParteSpecifica",
    "wrapperIdRuolo"
})
public class ObjectId {

    protected WrapperIdAccordoCooperazione wrapperIdAccordoCooperazione;
    protected WrapperIdAccordoServizioParteComune wrapperIdAccordoServizioParteComune;
    protected WrapperIdPortaDominio wrapperIdPortaDominio;
    protected WrapperIdSoggetto wrapperIdSoggetto;
    protected WrapperIdAccordoServizioParteSpecifica wrapperIdAccordoServizioParteSpecifica;
    protected WrapperIdRuolo wrapperIdRuolo;

    /**
     * Gets the value of the wrapperIdAccordoCooperazione property.
     * 
     * @return
     *     possible object is
     *     {@link WrapperIdAccordoCooperazione }
     *     
     */
    public WrapperIdAccordoCooperazione getWrapperIdAccordoCooperazione() {
        return wrapperIdAccordoCooperazione;
    }

    /**
     * Sets the value of the wrapperIdAccordoCooperazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link WrapperIdAccordoCooperazione }
     *     
     */
    public void setWrapperIdAccordoCooperazione(WrapperIdAccordoCooperazione value) {
        this.wrapperIdAccordoCooperazione = value;
    }

    /**
     * Gets the value of the wrapperIdAccordoServizioParteComune property.
     * 
     * @return
     *     possible object is
     *     {@link WrapperIdAccordoServizioParteComune }
     *     
     */
    public WrapperIdAccordoServizioParteComune getWrapperIdAccordoServizioParteComune() {
        return wrapperIdAccordoServizioParteComune;
    }

    /**
     * Sets the value of the wrapperIdAccordoServizioParteComune property.
     * 
     * @param value
     *     allowed object is
     *     {@link WrapperIdAccordoServizioParteComune }
     *     
     */
    public void setWrapperIdAccordoServizioParteComune(WrapperIdAccordoServizioParteComune value) {
        this.wrapperIdAccordoServizioParteComune = value;
    }

    /**
     * Gets the value of the wrapperIdPortaDominio property.
     * 
     * @return
     *     possible object is
     *     {@link WrapperIdPortaDominio }
     *     
     */
    public WrapperIdPortaDominio getWrapperIdPortaDominio() {
        return wrapperIdPortaDominio;
    }

    /**
     * Sets the value of the wrapperIdPortaDominio property.
     * 
     * @param value
     *     allowed object is
     *     {@link WrapperIdPortaDominio }
     *     
     */
    public void setWrapperIdPortaDominio(WrapperIdPortaDominio value) {
        this.wrapperIdPortaDominio = value;
    }

    /**
     * Gets the value of the wrapperIdSoggetto property.
     * 
     * @return
     *     possible object is
     *     {@link WrapperIdSoggetto }
     *     
     */
    public WrapperIdSoggetto getWrapperIdSoggetto() {
        return wrapperIdSoggetto;
    }

    /**
     * Sets the value of the wrapperIdSoggetto property.
     * 
     * @param value
     *     allowed object is
     *     {@link WrapperIdSoggetto }
     *     
     */
    public void setWrapperIdSoggetto(WrapperIdSoggetto value) {
        this.wrapperIdSoggetto = value;
    }

    /**
     * Gets the value of the wrapperIdAccordoServizioParteSpecifica property.
     * 
     * @return
     *     possible object is
     *     {@link WrapperIdAccordoServizioParteSpecifica }
     *     
     */
    public WrapperIdAccordoServizioParteSpecifica getWrapperIdAccordoServizioParteSpecifica() {
        return wrapperIdAccordoServizioParteSpecifica;
    }

    /**
     * Sets the value of the wrapperIdAccordoServizioParteSpecifica property.
     * 
     * @param value
     *     allowed object is
     *     {@link WrapperIdAccordoServizioParteSpecifica }
     *     
     */
    public void setWrapperIdAccordoServizioParteSpecifica(WrapperIdAccordoServizioParteSpecifica value) {
        this.wrapperIdAccordoServizioParteSpecifica = value;
    }

    /**
     * Gets the value of the wrapperIdRuolo property.
     * 
     * @return
     *     possible object is
     *     {@link WrapperIdRuolo }
     *     
     */
    public WrapperIdRuolo getWrapperIdRuolo() {
        return wrapperIdRuolo;
    }

    /**
     * Sets the value of the wrapperIdRuolo property.
     * 
     * @param value
     *     allowed object is
     *     {@link WrapperIdRuolo }
     *     
     */
    public void setWrapperIdRuolo(WrapperIdRuolo value) {
        this.wrapperIdRuolo = value;
    }

}
