
package org.openspcoop2.core.registry.ws.client.soggetto.search;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.openspcoop2.core.registry.IdSoggetto;


/**
 * <p>Java class for findAllIdsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findAllIdsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idSoggetto" type="{http://www.openspcoop2.org/core/registry}id-soggetto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAllIdsResponse", propOrder = {
    "idSoggetto"
})
public class FindAllIdsResponse {

    protected List<IdSoggetto> idSoggetto;

    /**
     * Gets the value of the idSoggetto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idSoggetto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdSoggetto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdSoggetto }
     * 
     * 
     */
    public List<IdSoggetto> getIdSoggetto() {
        if (idSoggetto == null) {
            idSoggetto = new ArrayList<IdSoggetto>();
        }
        return this.idSoggetto;
    }

}
