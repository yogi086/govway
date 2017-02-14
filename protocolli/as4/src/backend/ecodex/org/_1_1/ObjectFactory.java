/*
 * OpenSPCoop - Customizable API Gateway 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2017 Link.it srl (http://link.it).
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
package backend.ecodex.org._1_1;

import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the backend.ecodex.org._1_1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
*/

@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: backend.ecodex.org._1_1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetErrorsRequest }
     */
    public GetErrorsRequest createGetErrorsRequest() {
        return new GetErrorsRequest();
    }

    /**
     * Create an instance of {@link ListPendingMessagesResponse }
     */
    public ListPendingMessagesResponse createListPendingMessagesResponse() {
        return new ListPendingMessagesResponse();
    }

    /**
     * Create an instance of {@link PayloadType }
     */
    public PayloadType createPayloadType() {
        return new PayloadType();
    }

    /**
     * Create an instance of {@link SendRequest }
     */
    public SendRequest createSendRequest() {
        return new SendRequest();
    }

    /**
     * Create an instance of {@link Collection }
     */
    public Collection createCollection() {
        return new Collection();
    }

    /**
     * Create an instance of {@link SendRequestURL }
     */
    public SendRequestURL createSendRequestURL() {
        return new SendRequestURL();
    }

    /**
     * Create an instance of {@link ErrorResultImpl }
     */
    public ErrorResultImpl createErrorResultImpl() {
        return new ErrorResultImpl();
    }

    /**
     * Create an instance of {@link DownloadMessageRequest }
     */
    public DownloadMessageRequest createDownloadMessageRequest() {
        return new DownloadMessageRequest();
    }

    /**
     * Create an instance of {@link DownloadMessageResponse }
     */
    public DownloadMessageResponse createDownloadMessageResponse() {
        return new DownloadMessageResponse();
    }

    /**
     * Create an instance of {@link MessageStatusRequest }
     */
    public MessageStatusRequest createMessageStatusRequest() {
        return new MessageStatusRequest();
    }

    /**
     * Create an instance of {@link SendResponse }
     */
    public SendResponse createSendResponse() {
        return new SendResponse();
    }

    /**
     * Create an instance of {@link MessageErrorsRequest }
     */
    public MessageErrorsRequest createMessageErrorsRequest() {
        return new MessageErrorsRequest();
    }

    /**
     * Create an instance of {@link FaultDetail }
     */
    public FaultDetail createFaultDetail() {
        return new FaultDetail();
    }

    /**
     * Create an instance of {@link ErrorResultImplArray }
     */
    public ErrorResultImplArray createErrorResultImplArray() {
        return new ErrorResultImplArray();
    }

    /**
     * Create an instance of {@link GetStatusRequest }
     */
    public GetStatusRequest createGetStatusRequest() {
        return new GetStatusRequest();
    }

    /**
     * Create an instance of {@link PayloadURLType }
     */
    public PayloadURLType createPayloadURLType() {
        return new PayloadURLType();
    }

    private final static QName _GetMessageErrorsResponse = new QName("http://org.ecodex.backend/1_1/", "getMessageErrorsResponse");

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorResultImplArray }{@code >}}
     */
    @XmlElementDecl(namespace = "http://org.ecodex.backend/1_1/", name="getMessageErrorsResponse")
    public JAXBElement<ErrorResultImplArray> createGetMessageErrorsResponse() {
        return new JAXBElement<ErrorResultImplArray>(_GetMessageErrorsResponse, ErrorResultImplArray.class, null, this.createErrorResultImplArray());
    }
    public JAXBElement<ErrorResultImplArray> createGetMessageErrorsResponse(ErrorResultImplArray getMessageErrorsResponse) {
        return new JAXBElement<ErrorResultImplArray>(_GetMessageErrorsResponse, ErrorResultImplArray.class, null, getMessageErrorsResponse);
    }


 }