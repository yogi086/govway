//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.08 at 10:03:41 AM CET 
//


package org.openspcoop2.web.monitor.transazioni.core.search;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for transazione_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transazione_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipologia-transazioni" type="{http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search}tipologia-transazioni_type"/>
 *         &lt;element name="tipologia-ricerca-transazioni" type="{http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search}tipologia-ricerca-transazioni_type"/>
 *         &lt;element name="periodo">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="data_inizio" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                 &lt;attribute name="data_fine" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="protocollo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="soggetto-locale" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="tipo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="soggetto-remoto" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="tipo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="soggetto-mittente" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="tipo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="soggetto-destinatario" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="tipo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="servizio-applicativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="azione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="esito" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="codice" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="contesto" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="codice" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="evento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id-messaggio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id-applicativo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="modalita" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="filtro-contenuti" type="{http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search}filtro-contenuti" minOccurs="0"/>
 *         &lt;element name="transazioni-identificate" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="totale" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="selezionate" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transazione_type", namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search", propOrder = {
    "tipologiaTransazioni",
    "tipologiaRicercaTransazioni",
    "periodo",
    "protocollo",
    "soggettoLocale",
    "soggettoRemoto",
    "soggettoMittente",
    "soggettoDestinatario",
    "servizioApplicativo",
    "servizio",
    "azione",
    "esito",
    "contesto",
    "evento",
    "idMessaggio",
    "idApplicativo",
    "filtroContenuti",
    "transazioniIdentificate"
})
public class TransazioneType {

    @XmlElement(name = "tipologia-transazioni", namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search", required = true)
    protected TipologiaTransazioniType tipologiaTransazioni;
    @XmlElement(name = "tipologia-ricerca-transazioni", namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search", required = true)
    protected TipologiaRicercaTransazioniType tipologiaRicercaTransazioni;
    @XmlElement(namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search", required = true)
    protected TransazioneType.Periodo periodo;
    @XmlElement(namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected String protocollo;
    @XmlElement(name = "soggetto-locale", namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected TransazioneType.SoggettoLocale soggettoLocale;
    @XmlElement(name = "soggetto-remoto", namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected TransazioneType.SoggettoRemoto soggettoRemoto;
    @XmlElement(name = "soggetto-mittente", namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected TransazioneType.SoggettoMittente soggettoMittente;
    @XmlElement(name = "soggetto-destinatario", namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected TransazioneType.SoggettoDestinatario soggettoDestinatario;
    @XmlElement(name = "servizio-applicativo", namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected String servizioApplicativo;
    @XmlElement(namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected String servizio;
    @XmlElement(namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected String azione;
    @XmlElement(namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected TransazioneType.Esito esito;
    @XmlElement(namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected TransazioneType.Contesto contesto;
    @XmlElement(namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected String evento;
    @XmlElement(name = "id-messaggio", namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected String idMessaggio;
    @XmlElement(name = "id-applicativo", namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected TransazioneType.IdApplicativo idApplicativo;
    @XmlElement(name = "filtro-contenuti", namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected FiltroContenuti filtroContenuti;
    @XmlElement(name = "transazioni-identificate", namespace = "http://www.link.it/pdd/monitor/web/pddmonitor/transazioni/core/search")
    protected TransazioneType.TransazioniIdentificate transazioniIdentificate;

    /**
     * Gets the value of the tipologiaTransazioni property.
     * 
     * @return
     *     possible object is
     *     {@link TipologiaTransazioniType }
     *     
     */
    public TipologiaTransazioniType getTipologiaTransazioni() {
        return this.tipologiaTransazioni;
    }

    /**
     * Sets the value of the tipologiaTransazioni property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipologiaTransazioniType }
     *     
     */
    public void setTipologiaTransazioni(TipologiaTransazioniType value) {
        this.tipologiaTransazioni = value;
    }

    /**
     * Gets the value of the tipologiaRicercaTransazioni property.
     * 
     * @return
     *     possible object is
     *     {@link TipologiaRicercaTransazioniType }
     *     
     */
    public TipologiaRicercaTransazioniType getTipologiaRicercaTransazioni() {
        return this.tipologiaRicercaTransazioni;
    }

    /**
     * Sets the value of the tipologiaRicercaTransazioni property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipologiaRicercaTransazioniType }
     *     
     */
    public void setTipologiaRicercaTransazioni(TipologiaRicercaTransazioniType value) {
        this.tipologiaRicercaTransazioni = value;
    }

    /**
     * Gets the value of the periodo property.
     * 
     * @return
     *     possible object is
     *     {@link TransazioneType.Periodo }
     *     
     */
    public TransazioneType.Periodo getPeriodo() {
        return this.periodo;
    }

    /**
     * Sets the value of the periodo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransazioneType.Periodo }
     *     
     */
    public void setPeriodo(TransazioneType.Periodo value) {
        this.periodo = value;
    }

    /**
     * Gets the value of the protocollo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocollo() {
        return this.protocollo;
    }

    /**
     * Sets the value of the protocollo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocollo(String value) {
        this.protocollo = value;
    }

    /**
     * Gets the value of the soggettoLocale property.
     * 
     * @return
     *     possible object is
     *     {@link TransazioneType.SoggettoLocale }
     *     
     */
    public TransazioneType.SoggettoLocale getSoggettoLocale() {
        return this.soggettoLocale;
    }

    /**
     * Sets the value of the soggettoLocale property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransazioneType.SoggettoLocale }
     *     
     */
    public void setSoggettoLocale(TransazioneType.SoggettoLocale value) {
        this.soggettoLocale = value;
    }

    /**
     * Gets the value of the soggettoRemoto property.
     * 
     * @return
     *     possible object is
     *     {@link TransazioneType.SoggettoRemoto }
     *     
     */
    public TransazioneType.SoggettoRemoto getSoggettoRemoto() {
        return this.soggettoRemoto;
    }

    /**
     * Sets the value of the soggettoRemoto property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransazioneType.SoggettoRemoto }
     *     
     */
    public void setSoggettoRemoto(TransazioneType.SoggettoRemoto value) {
        this.soggettoRemoto = value;
    }

    /**
     * Gets the value of the soggettoMittente property.
     * 
     * @return
     *     possible object is
     *     {@link TransazioneType.SoggettoMittente }
     *     
     */
    public TransazioneType.SoggettoMittente getSoggettoMittente() {
        return this.soggettoMittente;
    }

    /**
     * Sets the value of the soggettoMittente property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransazioneType.SoggettoMittente }
     *     
     */
    public void setSoggettoMittente(TransazioneType.SoggettoMittente value) {
        this.soggettoMittente = value;
    }

    /**
     * Gets the value of the soggettoDestinatario property.
     * 
     * @return
     *     possible object is
     *     {@link TransazioneType.SoggettoDestinatario }
     *     
     */
    public TransazioneType.SoggettoDestinatario getSoggettoDestinatario() {
        return this.soggettoDestinatario;
    }

    /**
     * Sets the value of the soggettoDestinatario property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransazioneType.SoggettoDestinatario }
     *     
     */
    public void setSoggettoDestinatario(TransazioneType.SoggettoDestinatario value) {
        this.soggettoDestinatario = value;
    }

    /**
     * Gets the value of the servizioApplicativo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServizioApplicativo() {
        return this.servizioApplicativo;
    }

    /**
     * Sets the value of the servizioApplicativo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServizioApplicativo(String value) {
        this.servizioApplicativo = value;
    }

    /**
     * Gets the value of the servizio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServizio() {
        return this.servizio;
    }

    /**
     * Sets the value of the servizio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServizio(String value) {
        this.servizio = value;
    }

    /**
     * Gets the value of the azione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAzione() {
        return this.azione;
    }

    /**
     * Sets the value of the azione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAzione(String value) {
        this.azione = value;
    }

    /**
     * Gets the value of the esito property.
     * 
     * @return
     *     possible object is
     *     {@link TransazioneType.Esito }
     *     
     */
    public TransazioneType.Esito getEsito() {
        return this.esito;
    }

    /**
     * Sets the value of the esito property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransazioneType.Esito }
     *     
     */
    public void setEsito(TransazioneType.Esito value) {
        this.esito = value;
    }

    /**
     * Gets the value of the contesto property.
     * 
     * @return
     *     possible object is
     *     {@link TransazioneType.Contesto }
     *     
     */
    public TransazioneType.Contesto getContesto() {
        return this.contesto;
    }

    /**
     * Sets the value of the contesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransazioneType.Contesto }
     *     
     */
    public void setContesto(TransazioneType.Contesto value) {
        this.contesto = value;
    }

    /**
     * Gets the value of the evento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvento() {
        return this.evento;
    }

    /**
     * Sets the value of the evento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvento(String value) {
        this.evento = value;
    }

    /**
     * Gets the value of the idMessaggio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdMessaggio() {
        return this.idMessaggio;
    }

    /**
     * Sets the value of the idMessaggio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdMessaggio(String value) {
        this.idMessaggio = value;
    }

    /**
     * Gets the value of the idApplicativo property.
     * 
     * @return
     *     possible object is
     *     {@link TransazioneType.IdApplicativo }
     *     
     */
    public TransazioneType.IdApplicativo getIdApplicativo() {
        return this.idApplicativo;
    }

    /**
     * Sets the value of the idApplicativo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransazioneType.IdApplicativo }
     *     
     */
    public void setIdApplicativo(TransazioneType.IdApplicativo value) {
        this.idApplicativo = value;
    }

    /**
     * Gets the value of the filtroContenuti property.
     * 
     * @return
     *     possible object is
     *     {@link FiltroContenuti }
     *     
     */
    public FiltroContenuti getFiltroContenuti() {
        return this.filtroContenuti;
    }

    /**
     * Sets the value of the filtroContenuti property.
     * 
     * @param value
     *     allowed object is
     *     {@link FiltroContenuti }
     *     
     */
    public void setFiltroContenuti(FiltroContenuti value) {
        this.filtroContenuti = value;
    }

    /**
     * Gets the value of the transazioniIdentificate property.
     * 
     * @return
     *     possible object is
     *     {@link TransazioneType.TransazioniIdentificate }
     *     
     */
    public TransazioneType.TransazioniIdentificate getTransazioniIdentificate() {
        return this.transazioniIdentificate;
    }

    /**
     * Sets the value of the transazioniIdentificate property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransazioneType.TransazioniIdentificate }
     *     
     */
    public void setTransazioniIdentificate(TransazioneType.TransazioniIdentificate value) {
        this.transazioniIdentificate = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="codice" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Contesto {

        @XmlValue
        protected String value;
        @XmlAttribute
        protected String codice;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return this.value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the codice property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodice() {
            return this.codice;
        }

        /**
         * Sets the value of the codice property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodice(String value) {
            this.codice = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="codice" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Esito {

        @XmlValue
        protected String value;
        @XmlAttribute
        protected BigInteger codice;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return this.value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the codice property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getCodice() {
            return this.codice;
        }

        /**
         * Sets the value of the codice property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setCodice(BigInteger value) {
            this.codice = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="modalita" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class IdApplicativo {

        @XmlValue
        protected String value;
        @XmlAttribute(required = true)
        protected String modalita;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return this.value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the modalita property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModalita() {
            return this.modalita;
        }

        /**
         * Sets the value of the modalita property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModalita(String value) {
            this.modalita = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="data_inizio" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *       &lt;attribute name="data_fine" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Periodo {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "data_inizio", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataInizio;
        @XmlAttribute(name = "data_fine", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataFine;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return this.value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the dataInizio property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDataInizio() {
            return this.dataInizio;
        }

        /**
         * Sets the value of the dataInizio property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDataInizio(XMLGregorianCalendar value) {
            this.dataInizio = value;
        }

        /**
         * Gets the value of the dataFine property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDataFine() {
            return this.dataFine;
        }

        /**
         * Sets the value of the dataFine property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDataFine(XMLGregorianCalendar value) {
            this.dataFine = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="tipo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class SoggettoDestinatario {

        @XmlValue
        protected String value;
        @XmlAttribute(required = true)
        protected String tipo;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return this.value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the tipo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTipo() {
            return this.tipo;
        }

        /**
         * Sets the value of the tipo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTipo(String value) {
            this.tipo = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="tipo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class SoggettoLocale {

        @XmlValue
        protected String value;
        @XmlAttribute(required = true)
        protected String tipo;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return this.value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the tipo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTipo() {
            return this.tipo;
        }

        /**
         * Sets the value of the tipo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTipo(String value) {
            this.tipo = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="tipo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class SoggettoMittente {

        @XmlValue
        protected String value;
        @XmlAttribute(required = true)
        protected String tipo;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return this.value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the tipo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTipo() {
            return this.tipo;
        }

        /**
         * Sets the value of the tipo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTipo(String value) {
            this.tipo = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="tipo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class SoggettoRemoto {

        @XmlValue
        protected String value;
        @XmlAttribute(required = true)
        protected String tipo;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return this.value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the tipo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTipo() {
            return this.tipo;
        }

        /**
         * Sets the value of the tipo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTipo(String value) {
            this.tipo = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="totale" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="selezionate" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class TransazioniIdentificate {

        @XmlValue
        protected String value;
        @XmlAttribute(required = true)
        protected int totale;
        @XmlAttribute(required = true)
        protected int selezionate;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return this.value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the totale property.
         * 
         */
        public int getTotale() {
            return this.totale;
        }

        /**
         * Sets the value of the totale property.
         * 
         */
        public void setTotale(int value) {
            this.totale = value;
        }

        /**
         * Gets the value of the selezionate property.
         * 
         */
        public int getSelezionate() {
            return this.selezionate;
        }

        /**
         * Sets the value of the selezionate property.
         * 
         */
        public void setSelezionate(int value) {
            this.selezionate = value;
        }

    }

}