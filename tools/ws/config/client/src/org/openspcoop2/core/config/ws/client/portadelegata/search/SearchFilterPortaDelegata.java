
package org.openspcoop2.core.config.ws.client.portadelegata.search;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.openspcoop2.core.config.constants.StatoFunzionalita;


/**
 * <p>Java class for search-filter-porta-delegata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="search-filter-porta-delegata"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="soggetto-erogatore" type="{http://www.openspcoop2.org/core/config/management}porta-delegata-soggetto-erogatore" minOccurs="0"/&gt;
 *         &lt;element name="servizio" type="{http://www.openspcoop2.org/core/config/management}porta-delegata-servizio" minOccurs="0"/&gt;
 *         &lt;element name="azione" type="{http://www.openspcoop2.org/core/config/management}porta-delegata-azione" minOccurs="0"/&gt;
 *         &lt;element name="ruoli" type="{http://www.openspcoop2.org/core/config/management}autorizzazione-ruoli" minOccurs="0"/&gt;
 *         &lt;element name="local-forward" type="{http://www.openspcoop2.org/core/config/management}porta-delegata-local-forward" minOccurs="0"/&gt;
 *         &lt;element name="mtom-processor" type="{http://www.openspcoop2.org/core/config/management}mtom-processor" minOccurs="0"/&gt;
 *         &lt;element name="validazione-contenuti-applicativi" type="{http://www.openspcoop2.org/core/config/management}validazione-contenuti-applicativi" minOccurs="0"/&gt;
 *         &lt;element name="tipo-soggetto-proprietario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nome-soggetto-proprietario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="stato-message-security" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descrizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="autenticazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="autenticazione-opzionale" type="{http://www.openspcoop2.org/core/config}StatoFunzionalita" minOccurs="0"/&gt;
 *         &lt;element name="autorizzazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="autorizzazione-contenuto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ricevuta-asincrona-simmetrica" type="{http://www.openspcoop2.org/core/config}StatoFunzionalita" minOccurs="0"/&gt;
 *         &lt;element name="ricevuta-asincrona-asimmetrica" type="{http://www.openspcoop2.org/core/config}StatoFunzionalita" minOccurs="0"/&gt;
 *         &lt;element name="integrazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="allega-body" type="{http://www.openspcoop2.org/core/config}StatoFunzionalita" minOccurs="0"/&gt;
 *         &lt;element name="scarta-body" type="{http://www.openspcoop2.org/core/config}StatoFunzionalita" minOccurs="0"/&gt;
 *         &lt;element name="gestione-manifest" type="{http://www.openspcoop2.org/core/config}StatoFunzionalita" minOccurs="0"/&gt;
 *         &lt;element name="stateless" type="{http://www.openspcoop2.org/core/config}StatoFunzionalita" minOccurs="0"/&gt;
 *         &lt;element name="ora-registrazione-min" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="ora-registrazione-max" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="orCondition" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="limit" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="offset" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "search-filter-porta-delegata", propOrder = {
    "soggettoErogatore",
    "servizio",
    "azione",
    "ruoli",
    "localForward",
    "mtomProcessor",
    "validazioneContenutiApplicativi",
    "tipoSoggettoProprietario",
    "nomeSoggettoProprietario",
    "statoMessageSecurity",
    "nome",
    "descrizione",
    "autenticazione",
    "autenticazioneOpzionale",
    "autorizzazione",
    "autorizzazioneContenuto",
    "ricevutaAsincronaSimmetrica",
    "ricevutaAsincronaAsimmetrica",
    "integrazione",
    "allegaBody",
    "scartaBody",
    "gestioneManifest",
    "stateless",
    "oraRegistrazioneMin",
    "oraRegistrazioneMax",
    "orCondition",
    "limit",
    "offset"
})
public class SearchFilterPortaDelegata {

    @XmlElement(name = "soggetto-erogatore")
    protected PortaDelegataSoggettoErogatore soggettoErogatore;
    protected PortaDelegataServizio servizio;
    protected PortaDelegataAzione azione;
    protected AutorizzazioneRuoli ruoli;
    @XmlElement(name = "local-forward")
    protected PortaDelegataLocalForward localForward;
    @XmlElement(name = "mtom-processor")
    protected MtomProcessor mtomProcessor;
    @XmlElement(name = "validazione-contenuti-applicativi")
    protected ValidazioneContenutiApplicativi validazioneContenutiApplicativi;
    @XmlElement(name = "tipo-soggetto-proprietario")
    protected String tipoSoggettoProprietario;
    @XmlElement(name = "nome-soggetto-proprietario")
    protected String nomeSoggettoProprietario;
    @XmlElement(name = "stato-message-security")
    protected String statoMessageSecurity;
    protected String nome;
    protected String descrizione;
    protected String autenticazione;
    @XmlElement(name = "autenticazione-opzionale")
    @XmlSchemaType(name = "string")
    protected StatoFunzionalita autenticazioneOpzionale;
    protected String autorizzazione;
    @XmlElement(name = "autorizzazione-contenuto")
    protected String autorizzazioneContenuto;
    @XmlElement(name = "ricevuta-asincrona-simmetrica")
    @XmlSchemaType(name = "string")
    protected StatoFunzionalita ricevutaAsincronaSimmetrica;
    @XmlElement(name = "ricevuta-asincrona-asimmetrica")
    @XmlSchemaType(name = "string")
    protected StatoFunzionalita ricevutaAsincronaAsimmetrica;
    protected String integrazione;
    @XmlElement(name = "allega-body")
    @XmlSchemaType(name = "string")
    protected StatoFunzionalita allegaBody;
    @XmlElement(name = "scarta-body")
    @XmlSchemaType(name = "string")
    protected StatoFunzionalita scartaBody;
    @XmlElement(name = "gestione-manifest")
    @XmlSchemaType(name = "string")
    protected StatoFunzionalita gestioneManifest;
    @XmlSchemaType(name = "string")
    protected StatoFunzionalita stateless;
    @XmlElement(name = "ora-registrazione-min")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar oraRegistrazioneMin;
    @XmlElement(name = "ora-registrazione-max")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar oraRegistrazioneMax;
    protected Boolean orCondition;
    protected BigInteger limit;
    protected BigInteger offset;

    /**
     * Gets the value of the soggettoErogatore property.
     * 
     * @return
     *     possible object is
     *     {@link PortaDelegataSoggettoErogatore }
     *     
     */
    public PortaDelegataSoggettoErogatore getSoggettoErogatore() {
        return soggettoErogatore;
    }

    /**
     * Sets the value of the soggettoErogatore property.
     * 
     * @param value
     *     allowed object is
     *     {@link PortaDelegataSoggettoErogatore }
     *     
     */
    public void setSoggettoErogatore(PortaDelegataSoggettoErogatore value) {
        this.soggettoErogatore = value;
    }

    /**
     * Gets the value of the servizio property.
     * 
     * @return
     *     possible object is
     *     {@link PortaDelegataServizio }
     *     
     */
    public PortaDelegataServizio getServizio() {
        return servizio;
    }

    /**
     * Sets the value of the servizio property.
     * 
     * @param value
     *     allowed object is
     *     {@link PortaDelegataServizio }
     *     
     */
    public void setServizio(PortaDelegataServizio value) {
        this.servizio = value;
    }

    /**
     * Gets the value of the azione property.
     * 
     * @return
     *     possible object is
     *     {@link PortaDelegataAzione }
     *     
     */
    public PortaDelegataAzione getAzione() {
        return azione;
    }

    /**
     * Sets the value of the azione property.
     * 
     * @param value
     *     allowed object is
     *     {@link PortaDelegataAzione }
     *     
     */
    public void setAzione(PortaDelegataAzione value) {
        this.azione = value;
    }

    /**
     * Gets the value of the ruoli property.
     * 
     * @return
     *     possible object is
     *     {@link AutorizzazioneRuoli }
     *     
     */
    public AutorizzazioneRuoli getRuoli() {
        return ruoli;
    }

    /**
     * Sets the value of the ruoli property.
     * 
     * @param value
     *     allowed object is
     *     {@link AutorizzazioneRuoli }
     *     
     */
    public void setRuoli(AutorizzazioneRuoli value) {
        this.ruoli = value;
    }

    /**
     * Gets the value of the localForward property.
     * 
     * @return
     *     possible object is
     *     {@link PortaDelegataLocalForward }
     *     
     */
    public PortaDelegataLocalForward getLocalForward() {
        return localForward;
    }

    /**
     * Sets the value of the localForward property.
     * 
     * @param value
     *     allowed object is
     *     {@link PortaDelegataLocalForward }
     *     
     */
    public void setLocalForward(PortaDelegataLocalForward value) {
        this.localForward = value;
    }

    /**
     * Gets the value of the mtomProcessor property.
     * 
     * @return
     *     possible object is
     *     {@link MtomProcessor }
     *     
     */
    public MtomProcessor getMtomProcessor() {
        return mtomProcessor;
    }

    /**
     * Sets the value of the mtomProcessor property.
     * 
     * @param value
     *     allowed object is
     *     {@link MtomProcessor }
     *     
     */
    public void setMtomProcessor(MtomProcessor value) {
        this.mtomProcessor = value;
    }

    /**
     * Gets the value of the validazioneContenutiApplicativi property.
     * 
     * @return
     *     possible object is
     *     {@link ValidazioneContenutiApplicativi }
     *     
     */
    public ValidazioneContenutiApplicativi getValidazioneContenutiApplicativi() {
        return validazioneContenutiApplicativi;
    }

    /**
     * Sets the value of the validazioneContenutiApplicativi property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidazioneContenutiApplicativi }
     *     
     */
    public void setValidazioneContenutiApplicativi(ValidazioneContenutiApplicativi value) {
        this.validazioneContenutiApplicativi = value;
    }

    /**
     * Gets the value of the tipoSoggettoProprietario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoSoggettoProprietario() {
        return tipoSoggettoProprietario;
    }

    /**
     * Sets the value of the tipoSoggettoProprietario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoSoggettoProprietario(String value) {
        this.tipoSoggettoProprietario = value;
    }

    /**
     * Gets the value of the nomeSoggettoProprietario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeSoggettoProprietario() {
        return nomeSoggettoProprietario;
    }

    /**
     * Sets the value of the nomeSoggettoProprietario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeSoggettoProprietario(String value) {
        this.nomeSoggettoProprietario = value;
    }

    /**
     * Gets the value of the statoMessageSecurity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoMessageSecurity() {
        return statoMessageSecurity;
    }

    /**
     * Sets the value of the statoMessageSecurity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoMessageSecurity(String value) {
        this.statoMessageSecurity = value;
    }

    /**
     * Gets the value of the nome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the value of the nome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Gets the value of the descrizione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Sets the value of the descrizione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizione(String value) {
        this.descrizione = value;
    }

    /**
     * Gets the value of the autenticazione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutenticazione() {
        return autenticazione;
    }

    /**
     * Sets the value of the autenticazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutenticazione(String value) {
        this.autenticazione = value;
    }

    /**
     * Gets the value of the autenticazioneOpzionale property.
     * 
     * @return
     *     possible object is
     *     {@link StatoFunzionalita }
     *     
     */
    public StatoFunzionalita getAutenticazioneOpzionale() {
        return autenticazioneOpzionale;
    }

    /**
     * Sets the value of the autenticazioneOpzionale property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatoFunzionalita }
     *     
     */
    public void setAutenticazioneOpzionale(StatoFunzionalita value) {
        this.autenticazioneOpzionale = value;
    }

    /**
     * Gets the value of the autorizzazione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutorizzazione() {
        return autorizzazione;
    }

    /**
     * Sets the value of the autorizzazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutorizzazione(String value) {
        this.autorizzazione = value;
    }

    /**
     * Gets the value of the autorizzazioneContenuto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutorizzazioneContenuto() {
        return autorizzazioneContenuto;
    }

    /**
     * Sets the value of the autorizzazioneContenuto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutorizzazioneContenuto(String value) {
        this.autorizzazioneContenuto = value;
    }

    /**
     * Gets the value of the ricevutaAsincronaSimmetrica property.
     * 
     * @return
     *     possible object is
     *     {@link StatoFunzionalita }
     *     
     */
    public StatoFunzionalita getRicevutaAsincronaSimmetrica() {
        return ricevutaAsincronaSimmetrica;
    }

    /**
     * Sets the value of the ricevutaAsincronaSimmetrica property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatoFunzionalita }
     *     
     */
    public void setRicevutaAsincronaSimmetrica(StatoFunzionalita value) {
        this.ricevutaAsincronaSimmetrica = value;
    }

    /**
     * Gets the value of the ricevutaAsincronaAsimmetrica property.
     * 
     * @return
     *     possible object is
     *     {@link StatoFunzionalita }
     *     
     */
    public StatoFunzionalita getRicevutaAsincronaAsimmetrica() {
        return ricevutaAsincronaAsimmetrica;
    }

    /**
     * Sets the value of the ricevutaAsincronaAsimmetrica property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatoFunzionalita }
     *     
     */
    public void setRicevutaAsincronaAsimmetrica(StatoFunzionalita value) {
        this.ricevutaAsincronaAsimmetrica = value;
    }

    /**
     * Gets the value of the integrazione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntegrazione() {
        return integrazione;
    }

    /**
     * Sets the value of the integrazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntegrazione(String value) {
        this.integrazione = value;
    }

    /**
     * Gets the value of the allegaBody property.
     * 
     * @return
     *     possible object is
     *     {@link StatoFunzionalita }
     *     
     */
    public StatoFunzionalita getAllegaBody() {
        return allegaBody;
    }

    /**
     * Sets the value of the allegaBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatoFunzionalita }
     *     
     */
    public void setAllegaBody(StatoFunzionalita value) {
        this.allegaBody = value;
    }

    /**
     * Gets the value of the scartaBody property.
     * 
     * @return
     *     possible object is
     *     {@link StatoFunzionalita }
     *     
     */
    public StatoFunzionalita getScartaBody() {
        return scartaBody;
    }

    /**
     * Sets the value of the scartaBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatoFunzionalita }
     *     
     */
    public void setScartaBody(StatoFunzionalita value) {
        this.scartaBody = value;
    }

    /**
     * Gets the value of the gestioneManifest property.
     * 
     * @return
     *     possible object is
     *     {@link StatoFunzionalita }
     *     
     */
    public StatoFunzionalita getGestioneManifest() {
        return gestioneManifest;
    }

    /**
     * Sets the value of the gestioneManifest property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatoFunzionalita }
     *     
     */
    public void setGestioneManifest(StatoFunzionalita value) {
        this.gestioneManifest = value;
    }

    /**
     * Gets the value of the stateless property.
     * 
     * @return
     *     possible object is
     *     {@link StatoFunzionalita }
     *     
     */
    public StatoFunzionalita getStateless() {
        return stateless;
    }

    /**
     * Sets the value of the stateless property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatoFunzionalita }
     *     
     */
    public void setStateless(StatoFunzionalita value) {
        this.stateless = value;
    }

    /**
     * Gets the value of the oraRegistrazioneMin property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOraRegistrazioneMin() {
        return oraRegistrazioneMin;
    }

    /**
     * Sets the value of the oraRegistrazioneMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOraRegistrazioneMin(XMLGregorianCalendar value) {
        this.oraRegistrazioneMin = value;
    }

    /**
     * Gets the value of the oraRegistrazioneMax property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOraRegistrazioneMax() {
        return oraRegistrazioneMax;
    }

    /**
     * Sets the value of the oraRegistrazioneMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOraRegistrazioneMax(XMLGregorianCalendar value) {
        this.oraRegistrazioneMax = value;
    }

    /**
     * Gets the value of the orCondition property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOrCondition() {
        return orCondition;
    }

    /**
     * Sets the value of the orCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOrCondition(Boolean value) {
        this.orCondition = value;
    }

    /**
     * Gets the value of the limit property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLimit() {
        return limit;
    }

    /**
     * Sets the value of the limit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLimit(BigInteger value) {
        this.limit = value;
    }

    /**
     * Gets the value of the offset property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOffset(BigInteger value) {
        this.offset = value;
    }

}
