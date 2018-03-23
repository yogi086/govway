package org.openspcoop2.core.transazioni.ws.server.filter;

/**
 * <p>Java class for SearchFilterTransazione complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="search-filter-transazione">
 *     &lt;sequence>
 *         &lt;element name="id-transazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="stato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="esito" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="esito-contesto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="protocollo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="data-accettazione-richiesta-min" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="data-accettazione-richiesta-max" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="data-ingresso-richiesta-min" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="data-ingresso-richiesta-max" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="data-uscita-richiesta-min" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="data-uscita-richiesta-max" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="data-accettazione-risposta-min" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="data-accettazione-risposta-max" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="data-ingresso-risposta-min" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="data-ingresso-risposta-max" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="data-uscita-risposta-min" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="data-uscita-risposta-max" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="richiesta-ingresso-bytes-min" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="richiesta-ingresso-bytes-max" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="richiesta-uscita-bytes-min" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="richiesta-uscita-bytes-max" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="risposta-ingresso-bytes-min" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="risposta-ingresso-bytes-max" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="risposta-uscita-bytes-min" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="risposta-uscita-bytes-max" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="pdd-codice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="pdd-tipo-soggetto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="pdd-nome-soggetto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="pdd-ruolo" type="{http://www.openspcoop2.org/core/transazioni}pdd-ruolo" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="tipo-soggetto-fruitore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="nome-soggetto-fruitore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="idporta-soggetto-fruitore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="indirizzo-soggetto-fruitore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="tipo-soggetto-erogatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="nome-soggetto-erogatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="idporta-soggetto-erogatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="indirizzo-soggetto-erogatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="id-messaggio-richiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="id-messaggio-risposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="profilo-collaborazione-op2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="profilo-collaborazione-prot" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="id-collaborazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="uri-accordo-servizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="tipo-servizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="nome-servizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="versione-servizio" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="azione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="id-asincrono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="tipo-servizio-correlato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="nome-servizio-correlato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="id-correlazione-applicativa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="id-correlazione-applicativa-risposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="servizio-applicativo-fruitore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="servizio-applicativo-erogatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="operazione-im" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="location-richiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="location-risposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="nome-porta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="credenziali" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="location-connettore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="url-invocazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="cluster-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="socket-client-address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="transport-client-address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="limit" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="offset" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0" maxOccurs="1" />
 *         &lt;element name="descOrder" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0" maxOccurs="1" default="new Boolean("false")" />
 *     &lt;/sequence>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
 
import java.io.Serializable;
 
import javax.xml.bind.annotation.XmlElement;
import org.openspcoop2.core.transazioni.constants.PddRuolo;
import java.util.Date;

/**     
 * SearchFilterTransazione
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
@javax.xml.bind.annotation.XmlType(name = "search-filter-transazione", namespace="http://www.openspcoop2.org/core/transazioni/management", propOrder = {
    "idTransazione",
    "stato",
    "esito",
    "esitoContesto",
    "protocollo",
    "dataAccettazioneRichiestaMin",
    "dataAccettazioneRichiestaMax",
    "dataIngressoRichiestaMin",
    "dataIngressoRichiestaMax",
    "dataUscitaRichiestaMin",
    "dataUscitaRichiestaMax",
    "dataAccettazioneRispostaMin",
    "dataAccettazioneRispostaMax",
    "dataIngressoRispostaMin",
    "dataIngressoRispostaMax",
    "dataUscitaRispostaMin",
    "dataUscitaRispostaMax",
    "richiestaIngressoBytesMin",
    "richiestaIngressoBytesMax",
    "richiestaUscitaBytesMin",
    "richiestaUscitaBytesMax",
    "rispostaIngressoBytesMin",
    "rispostaIngressoBytesMax",
    "rispostaUscitaBytesMin",
    "rispostaUscitaBytesMax",
    "pddCodice",
    "pddTipoSoggetto",
    "pddNomeSoggetto",
    "pddRuolo",
    "tipoSoggettoFruitore",
    "nomeSoggettoFruitore",
    "idportaSoggettoFruitore",
    "indirizzoSoggettoFruitore",
    "tipoSoggettoErogatore",
    "nomeSoggettoErogatore",
    "idportaSoggettoErogatore",
    "indirizzoSoggettoErogatore",
    "idMessaggioRichiesta",
    "idMessaggioRisposta",
    "profiloCollaborazioneOp2",
    "profiloCollaborazioneProt",
    "idCollaborazione",
    "uriAccordoServizio",
    "tipoServizio",
    "nomeServizio",
    "versioneServizio",
    "azione",
    "idAsincrono",
    "tipoServizioCorrelato",
    "nomeServizioCorrelato",
    "idCorrelazioneApplicativa",
    "idCorrelazioneApplicativaRisposta",
    "servizioApplicativoFruitore",
    "servizioApplicativoErogatore",
    "operazioneIm",
    "locationRichiesta",
    "locationRisposta",
    "nomePorta",
    "credenziali",
    "locationConnettore",
    "urlInvocazione",
    "clusterId",
    "socketClientAddress",
    "transportClientAddress",
    "limit",
    "offset",
    "descOrder"
})
@javax.xml.bind.annotation.XmlRootElement(name = "search-filter-transazione")
public class SearchFilterTransazione extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable {
	
	private static final long serialVersionUID = -1L;
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="id-transazione",required=false,nillable=false)
	private String idTransazione;
	
	public void setIdTransazione(String idTransazione){
		this.idTransazione = idTransazione;
	}
	
	public String getIdTransazione(){
		return this.idTransazione;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="stato",required=false,nillable=false)
	private String stato;
	
	public void setStato(String stato){
		this.stato = stato;
	}
	
	public String getStato(){
		return this.stato;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="int")
  @XmlElement(name="esito",required=false,nillable=false)
	private Integer esito;
	
	public void setEsito(Integer esito){
		this.esito = esito;
	}
	
	public Integer getEsito(){
		return this.esito;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="esito-contesto",required=false,nillable=false)
	private String esitoContesto;
	
	public void setEsitoContesto(String esitoContesto){
		this.esitoContesto = esitoContesto;
	}
	
	public String getEsitoContesto(){
		return this.esitoContesto;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="protocollo",required=false,nillable=false)
	private String protocollo;
	
	public void setProtocollo(String protocollo){
		this.protocollo = protocollo;
	}
	
	public String getProtocollo(){
		return this.protocollo;
	}
	
	
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.DateTime2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="dateTime")
  @XmlElement(name="data-accettazione-richiesta-min",required=false,nillable=false)
	private Date dataAccettazioneRichiestaMin;
	
	public void setDataAccettazioneRichiestaMin(Date dataAccettazioneRichiestaMin){
		this.dataAccettazioneRichiestaMin = dataAccettazioneRichiestaMin;
	}
	
	public Date getDataAccettazioneRichiestaMin(){
		return this.dataAccettazioneRichiestaMin;
	}
	
	
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.DateTime2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="dateTime")
  @XmlElement(name="data-accettazione-richiesta-max",required=false,nillable=false)
	private Date dataAccettazioneRichiestaMax;
	
	public void setDataAccettazioneRichiestaMax(Date dataAccettazioneRichiestaMax){
		this.dataAccettazioneRichiestaMax = dataAccettazioneRichiestaMax;
	}
	
	public Date getDataAccettazioneRichiestaMax(){
		return this.dataAccettazioneRichiestaMax;
	}
	
	
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.DateTime2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="dateTime")
  @XmlElement(name="data-ingresso-richiesta-min",required=false,nillable=false)
	private Date dataIngressoRichiestaMin;
	
	public void setDataIngressoRichiestaMin(Date dataIngressoRichiestaMin){
		this.dataIngressoRichiestaMin = dataIngressoRichiestaMin;
	}
	
	public Date getDataIngressoRichiestaMin(){
		return this.dataIngressoRichiestaMin;
	}
	
	
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.DateTime2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="dateTime")
  @XmlElement(name="data-ingresso-richiesta-max",required=false,nillable=false)
	private Date dataIngressoRichiestaMax;
	
	public void setDataIngressoRichiestaMax(Date dataIngressoRichiestaMax){
		this.dataIngressoRichiestaMax = dataIngressoRichiestaMax;
	}
	
	public Date getDataIngressoRichiestaMax(){
		return this.dataIngressoRichiestaMax;
	}
	
	
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.DateTime2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="dateTime")
  @XmlElement(name="data-uscita-richiesta-min",required=false,nillable=false)
	private Date dataUscitaRichiestaMin;
	
	public void setDataUscitaRichiestaMin(Date dataUscitaRichiestaMin){
		this.dataUscitaRichiestaMin = dataUscitaRichiestaMin;
	}
	
	public Date getDataUscitaRichiestaMin(){
		return this.dataUscitaRichiestaMin;
	}
	
	
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.DateTime2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="dateTime")
  @XmlElement(name="data-uscita-richiesta-max",required=false,nillable=false)
	private Date dataUscitaRichiestaMax;
	
	public void setDataUscitaRichiestaMax(Date dataUscitaRichiestaMax){
		this.dataUscitaRichiestaMax = dataUscitaRichiestaMax;
	}
	
	public Date getDataUscitaRichiestaMax(){
		return this.dataUscitaRichiestaMax;
	}
	
	
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.DateTime2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="dateTime")
  @XmlElement(name="data-accettazione-risposta-min",required=false,nillable=false)
	private Date dataAccettazioneRispostaMin;
	
	public void setDataAccettazioneRispostaMin(Date dataAccettazioneRispostaMin){
		this.dataAccettazioneRispostaMin = dataAccettazioneRispostaMin;
	}
	
	public Date getDataAccettazioneRispostaMin(){
		return this.dataAccettazioneRispostaMin;
	}
	
	
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.DateTime2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="dateTime")
  @XmlElement(name="data-accettazione-risposta-max",required=false,nillable=false)
	private Date dataAccettazioneRispostaMax;
	
	public void setDataAccettazioneRispostaMax(Date dataAccettazioneRispostaMax){
		this.dataAccettazioneRispostaMax = dataAccettazioneRispostaMax;
	}
	
	public Date getDataAccettazioneRispostaMax(){
		return this.dataAccettazioneRispostaMax;
	}
	
	
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.DateTime2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="dateTime")
  @XmlElement(name="data-ingresso-risposta-min",required=false,nillable=false)
	private Date dataIngressoRispostaMin;
	
	public void setDataIngressoRispostaMin(Date dataIngressoRispostaMin){
		this.dataIngressoRispostaMin = dataIngressoRispostaMin;
	}
	
	public Date getDataIngressoRispostaMin(){
		return this.dataIngressoRispostaMin;
	}
	
	
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.DateTime2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="dateTime")
  @XmlElement(name="data-ingresso-risposta-max",required=false,nillable=false)
	private Date dataIngressoRispostaMax;
	
	public void setDataIngressoRispostaMax(Date dataIngressoRispostaMax){
		this.dataIngressoRispostaMax = dataIngressoRispostaMax;
	}
	
	public Date getDataIngressoRispostaMax(){
		return this.dataIngressoRispostaMax;
	}
	
	
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.DateTime2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="dateTime")
  @XmlElement(name="data-uscita-risposta-min",required=false,nillable=false)
	private Date dataUscitaRispostaMin;
	
	public void setDataUscitaRispostaMin(Date dataUscitaRispostaMin){
		this.dataUscitaRispostaMin = dataUscitaRispostaMin;
	}
	
	public Date getDataUscitaRispostaMin(){
		return this.dataUscitaRispostaMin;
	}
	
	
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.DateTime2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="dateTime")
  @XmlElement(name="data-uscita-risposta-max",required=false,nillable=false)
	private Date dataUscitaRispostaMax;
	
	public void setDataUscitaRispostaMax(Date dataUscitaRispostaMax){
		this.dataUscitaRispostaMax = dataUscitaRispostaMax;
	}
	
	public Date getDataUscitaRispostaMax(){
		return this.dataUscitaRispostaMax;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="unsignedLong")
  @XmlElement(name="richiesta-ingresso-bytes-min",required=false,nillable=false)
	private Long richiestaIngressoBytesMin;
	
	public void setRichiestaIngressoBytesMin(Long richiestaIngressoBytesMin){
		this.richiestaIngressoBytesMin = richiestaIngressoBytesMin;
	}
	
	public Long getRichiestaIngressoBytesMin(){
		return this.richiestaIngressoBytesMin;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="unsignedLong")
  @XmlElement(name="richiesta-ingresso-bytes-max",required=false,nillable=false)
	private Long richiestaIngressoBytesMax;
	
	public void setRichiestaIngressoBytesMax(Long richiestaIngressoBytesMax){
		this.richiestaIngressoBytesMax = richiestaIngressoBytesMax;
	}
	
	public Long getRichiestaIngressoBytesMax(){
		return this.richiestaIngressoBytesMax;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="unsignedLong")
  @XmlElement(name="richiesta-uscita-bytes-min",required=false,nillable=false)
	private Long richiestaUscitaBytesMin;
	
	public void setRichiestaUscitaBytesMin(Long richiestaUscitaBytesMin){
		this.richiestaUscitaBytesMin = richiestaUscitaBytesMin;
	}
	
	public Long getRichiestaUscitaBytesMin(){
		return this.richiestaUscitaBytesMin;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="unsignedLong")
  @XmlElement(name="richiesta-uscita-bytes-max",required=false,nillable=false)
	private Long richiestaUscitaBytesMax;
	
	public void setRichiestaUscitaBytesMax(Long richiestaUscitaBytesMax){
		this.richiestaUscitaBytesMax = richiestaUscitaBytesMax;
	}
	
	public Long getRichiestaUscitaBytesMax(){
		return this.richiestaUscitaBytesMax;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="unsignedLong")
  @XmlElement(name="risposta-ingresso-bytes-min",required=false,nillable=false)
	private Long rispostaIngressoBytesMin;
	
	public void setRispostaIngressoBytesMin(Long rispostaIngressoBytesMin){
		this.rispostaIngressoBytesMin = rispostaIngressoBytesMin;
	}
	
	public Long getRispostaIngressoBytesMin(){
		return this.rispostaIngressoBytesMin;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="unsignedLong")
  @XmlElement(name="risposta-ingresso-bytes-max",required=false,nillable=false)
	private Long rispostaIngressoBytesMax;
	
	public void setRispostaIngressoBytesMax(Long rispostaIngressoBytesMax){
		this.rispostaIngressoBytesMax = rispostaIngressoBytesMax;
	}
	
	public Long getRispostaIngressoBytesMax(){
		return this.rispostaIngressoBytesMax;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="unsignedLong")
  @XmlElement(name="risposta-uscita-bytes-min",required=false,nillable=false)
	private Long rispostaUscitaBytesMin;
	
	public void setRispostaUscitaBytesMin(Long rispostaUscitaBytesMin){
		this.rispostaUscitaBytesMin = rispostaUscitaBytesMin;
	}
	
	public Long getRispostaUscitaBytesMin(){
		return this.rispostaUscitaBytesMin;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="unsignedLong")
  @XmlElement(name="risposta-uscita-bytes-max",required=false,nillable=false)
	private Long rispostaUscitaBytesMax;
	
	public void setRispostaUscitaBytesMax(Long rispostaUscitaBytesMax){
		this.rispostaUscitaBytesMax = rispostaUscitaBytesMax;
	}
	
	public Long getRispostaUscitaBytesMax(){
		return this.rispostaUscitaBytesMax;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="pdd-codice",required=false,nillable=false)
	private String pddCodice;
	
	public void setPddCodice(String pddCodice){
		this.pddCodice = pddCodice;
	}
	
	public String getPddCodice(){
		return this.pddCodice;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="pdd-tipo-soggetto",required=false,nillable=false)
	private String pddTipoSoggetto;
	
	public void setPddTipoSoggetto(String pddTipoSoggetto){
		this.pddTipoSoggetto = pddTipoSoggetto;
	}
	
	public String getPddTipoSoggetto(){
		return this.pddTipoSoggetto;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="pdd-nome-soggetto",required=false,nillable=false)
	private String pddNomeSoggetto;
	
	public void setPddNomeSoggetto(String pddNomeSoggetto){
		this.pddNomeSoggetto = pddNomeSoggetto;
	}
	
	public String getPddNomeSoggetto(){
		return this.pddNomeSoggetto;
	}
	
	
	@XmlElement(name="pdd-ruolo",required=false,nillable=false)
	private PddRuolo pddRuolo;
	
	public void setPddRuolo(PddRuolo pddRuolo){
		this.pddRuolo = pddRuolo;
	}
	
	public PddRuolo getPddRuolo(){
		return this.pddRuolo;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="tipo-soggetto-fruitore",required=false,nillable=false)
	private String tipoSoggettoFruitore;
	
	public void setTipoSoggettoFruitore(String tipoSoggettoFruitore){
		this.tipoSoggettoFruitore = tipoSoggettoFruitore;
	}
	
	public String getTipoSoggettoFruitore(){
		return this.tipoSoggettoFruitore;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="nome-soggetto-fruitore",required=false,nillable=false)
	private String nomeSoggettoFruitore;
	
	public void setNomeSoggettoFruitore(String nomeSoggettoFruitore){
		this.nomeSoggettoFruitore = nomeSoggettoFruitore;
	}
	
	public String getNomeSoggettoFruitore(){
		return this.nomeSoggettoFruitore;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="idporta-soggetto-fruitore",required=false,nillable=false)
	private String idportaSoggettoFruitore;
	
	public void setIdportaSoggettoFruitore(String idportaSoggettoFruitore){
		this.idportaSoggettoFruitore = idportaSoggettoFruitore;
	}
	
	public String getIdportaSoggettoFruitore(){
		return this.idportaSoggettoFruitore;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="indirizzo-soggetto-fruitore",required=false,nillable=false)
	private String indirizzoSoggettoFruitore;
	
	public void setIndirizzoSoggettoFruitore(String indirizzoSoggettoFruitore){
		this.indirizzoSoggettoFruitore = indirizzoSoggettoFruitore;
	}
	
	public String getIndirizzoSoggettoFruitore(){
		return this.indirizzoSoggettoFruitore;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="tipo-soggetto-erogatore",required=false,nillable=false)
	private String tipoSoggettoErogatore;
	
	public void setTipoSoggettoErogatore(String tipoSoggettoErogatore){
		this.tipoSoggettoErogatore = tipoSoggettoErogatore;
	}
	
	public String getTipoSoggettoErogatore(){
		return this.tipoSoggettoErogatore;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="nome-soggetto-erogatore",required=false,nillable=false)
	private String nomeSoggettoErogatore;
	
	public void setNomeSoggettoErogatore(String nomeSoggettoErogatore){
		this.nomeSoggettoErogatore = nomeSoggettoErogatore;
	}
	
	public String getNomeSoggettoErogatore(){
		return this.nomeSoggettoErogatore;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="idporta-soggetto-erogatore",required=false,nillable=false)
	private String idportaSoggettoErogatore;
	
	public void setIdportaSoggettoErogatore(String idportaSoggettoErogatore){
		this.idportaSoggettoErogatore = idportaSoggettoErogatore;
	}
	
	public String getIdportaSoggettoErogatore(){
		return this.idportaSoggettoErogatore;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="indirizzo-soggetto-erogatore",required=false,nillable=false)
	private String indirizzoSoggettoErogatore;
	
	public void setIndirizzoSoggettoErogatore(String indirizzoSoggettoErogatore){
		this.indirizzoSoggettoErogatore = indirizzoSoggettoErogatore;
	}
	
	public String getIndirizzoSoggettoErogatore(){
		return this.indirizzoSoggettoErogatore;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="id-messaggio-richiesta",required=false,nillable=false)
	private String idMessaggioRichiesta;
	
	public void setIdMessaggioRichiesta(String idMessaggioRichiesta){
		this.idMessaggioRichiesta = idMessaggioRichiesta;
	}
	
	public String getIdMessaggioRichiesta(){
		return this.idMessaggioRichiesta;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="id-messaggio-risposta",required=false,nillable=false)
	private String idMessaggioRisposta;
	
	public void setIdMessaggioRisposta(String idMessaggioRisposta){
		this.idMessaggioRisposta = idMessaggioRisposta;
	}
	
	public String getIdMessaggioRisposta(){
		return this.idMessaggioRisposta;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="profilo-collaborazione-op2",required=false,nillable=false)
	private String profiloCollaborazioneOp2;
	
	public void setProfiloCollaborazioneOp2(String profiloCollaborazioneOp2){
		this.profiloCollaborazioneOp2 = profiloCollaborazioneOp2;
	}
	
	public String getProfiloCollaborazioneOp2(){
		return this.profiloCollaborazioneOp2;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="profilo-collaborazione-prot",required=false,nillable=false)
	private String profiloCollaborazioneProt;
	
	public void setProfiloCollaborazioneProt(String profiloCollaborazioneProt){
		this.profiloCollaborazioneProt = profiloCollaborazioneProt;
	}
	
	public String getProfiloCollaborazioneProt(){
		return this.profiloCollaborazioneProt;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="id-collaborazione",required=false,nillable=false)
	private String idCollaborazione;
	
	public void setIdCollaborazione(String idCollaborazione){
		this.idCollaborazione = idCollaborazione;
	}
	
	public String getIdCollaborazione(){
		return this.idCollaborazione;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="uri-accordo-servizio",required=false,nillable=false)
	private String uriAccordoServizio;
	
	public void setUriAccordoServizio(String uriAccordoServizio){
		this.uriAccordoServizio = uriAccordoServizio;
	}
	
	public String getUriAccordoServizio(){
		return this.uriAccordoServizio;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="tipo-servizio",required=false,nillable=false)
	private String tipoServizio;
	
	public void setTipoServizio(String tipoServizio){
		this.tipoServizio = tipoServizio;
	}
	
	public String getTipoServizio(){
		return this.tipoServizio;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="nome-servizio",required=false,nillable=false)
	private String nomeServizio;
	
	public void setNomeServizio(String nomeServizio){
		this.nomeServizio = nomeServizio;
	}
	
	public String getNomeServizio(){
		return this.nomeServizio;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="int")
  @XmlElement(name="versione-servizio",required=false,nillable=false)
	private Integer versioneServizio;
	
	public void setVersioneServizio(Integer versioneServizio){
		this.versioneServizio = versioneServizio;
	}
	
	public Integer getVersioneServizio(){
		return this.versioneServizio;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="azione",required=false,nillable=false)
	private String azione;
	
	public void setAzione(String azione){
		this.azione = azione;
	}
	
	public String getAzione(){
		return this.azione;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="id-asincrono",required=false,nillable=false)
	private String idAsincrono;
	
	public void setIdAsincrono(String idAsincrono){
		this.idAsincrono = idAsincrono;
	}
	
	public String getIdAsincrono(){
		return this.idAsincrono;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="tipo-servizio-correlato",required=false,nillable=false)
	private String tipoServizioCorrelato;
	
	public void setTipoServizioCorrelato(String tipoServizioCorrelato){
		this.tipoServizioCorrelato = tipoServizioCorrelato;
	}
	
	public String getTipoServizioCorrelato(){
		return this.tipoServizioCorrelato;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="nome-servizio-correlato",required=false,nillable=false)
	private String nomeServizioCorrelato;
	
	public void setNomeServizioCorrelato(String nomeServizioCorrelato){
		this.nomeServizioCorrelato = nomeServizioCorrelato;
	}
	
	public String getNomeServizioCorrelato(){
		return this.nomeServizioCorrelato;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="id-correlazione-applicativa",required=false,nillable=false)
	private String idCorrelazioneApplicativa;
	
	public void setIdCorrelazioneApplicativa(String idCorrelazioneApplicativa){
		this.idCorrelazioneApplicativa = idCorrelazioneApplicativa;
	}
	
	public String getIdCorrelazioneApplicativa(){
		return this.idCorrelazioneApplicativa;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="id-correlazione-applicativa-risposta",required=false,nillable=false)
	private String idCorrelazioneApplicativaRisposta;
	
	public void setIdCorrelazioneApplicativaRisposta(String idCorrelazioneApplicativaRisposta){
		this.idCorrelazioneApplicativaRisposta = idCorrelazioneApplicativaRisposta;
	}
	
	public String getIdCorrelazioneApplicativaRisposta(){
		return this.idCorrelazioneApplicativaRisposta;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="servizio-applicativo-fruitore",required=false,nillable=false)
	private String servizioApplicativoFruitore;
	
	public void setServizioApplicativoFruitore(String servizioApplicativoFruitore){
		this.servizioApplicativoFruitore = servizioApplicativoFruitore;
	}
	
	public String getServizioApplicativoFruitore(){
		return this.servizioApplicativoFruitore;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="servizio-applicativo-erogatore",required=false,nillable=false)
	private String servizioApplicativoErogatore;
	
	public void setServizioApplicativoErogatore(String servizioApplicativoErogatore){
		this.servizioApplicativoErogatore = servizioApplicativoErogatore;
	}
	
	public String getServizioApplicativoErogatore(){
		return this.servizioApplicativoErogatore;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="operazione-im",required=false,nillable=false)
	private String operazioneIm;
	
	public void setOperazioneIm(String operazioneIm){
		this.operazioneIm = operazioneIm;
	}
	
	public String getOperazioneIm(){
		return this.operazioneIm;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="location-richiesta",required=false,nillable=false)
	private String locationRichiesta;
	
	public void setLocationRichiesta(String locationRichiesta){
		this.locationRichiesta = locationRichiesta;
	}
	
	public String getLocationRichiesta(){
		return this.locationRichiesta;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="location-risposta",required=false,nillable=false)
	private String locationRisposta;
	
	public void setLocationRisposta(String locationRisposta){
		this.locationRisposta = locationRisposta;
	}
	
	public String getLocationRisposta(){
		return this.locationRisposta;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="nome-porta",required=false,nillable=false)
	private String nomePorta;
	
	public void setNomePorta(String nomePorta){
		this.nomePorta = nomePorta;
	}
	
	public String getNomePorta(){
		return this.nomePorta;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="credenziali",required=false,nillable=false)
	private String credenziali;
	
	public void setCredenziali(String credenziali){
		this.credenziali = credenziali;
	}
	
	public String getCredenziali(){
		return this.credenziali;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="location-connettore",required=false,nillable=false)
	private String locationConnettore;
	
	public void setLocationConnettore(String locationConnettore){
		this.locationConnettore = locationConnettore;
	}
	
	public String getLocationConnettore(){
		return this.locationConnettore;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="url-invocazione",required=false,nillable=false)
	private String urlInvocazione;
	
	public void setUrlInvocazione(String urlInvocazione){
		this.urlInvocazione = urlInvocazione;
	}
	
	public String getUrlInvocazione(){
		return this.urlInvocazione;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="cluster-id",required=false,nillable=false)
	private String clusterId;
	
	public void setClusterId(String clusterId){
		this.clusterId = clusterId;
	}
	
	public String getClusterId(){
		return this.clusterId;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="socket-client-address",required=false,nillable=false)
	private String socketClientAddress;
	
	public void setSocketClientAddress(String socketClientAddress){
		this.socketClientAddress = socketClientAddress;
	}
	
	public String getSocketClientAddress(){
		return this.socketClientAddress;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="transport-client-address",required=false,nillable=false)
	private String transportClientAddress;
	
	public void setTransportClientAddress(String transportClientAddress){
		this.transportClientAddress = transportClientAddress;
	}
	
	public String getTransportClientAddress(){
		return this.transportClientAddress;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="integer")
  @XmlElement(name="limit",required=false,nillable=false)
	private Integer limit;
	
	public void setLimit(Integer limit){
		this.limit = limit;
	}
	
	public Integer getLimit(){
		return this.limit;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="integer")
  @XmlElement(name="offset",required=false,nillable=false)
	private Integer offset;
	
	public void setOffset(Integer offset){
		this.offset = offset;
	}
	
	public Integer getOffset(){
		return this.offset;
	}
	
	
	@javax.xml.bind.annotation.XmlSchemaType(name="boolean")
  @XmlElement(name="descOrder",required=false,nillable=false,defaultValue="false")
	private Boolean descOrder = new Boolean("false");
	
	public void setDescOrder(Boolean descOrder){
		this.descOrder = descOrder;
	}
	
	public Boolean getDescOrder(){
		return this.descOrder;
	}
	
	
	
	
}