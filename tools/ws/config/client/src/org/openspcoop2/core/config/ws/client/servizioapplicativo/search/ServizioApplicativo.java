package org.openspcoop2.core.config.ws.client.servizioapplicativo.search;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2017-04-24T11:51:45.741+02:00
 * Generated source version: 3.1.7
 * 
 */
@WebService(targetNamespace = "http://www.openspcoop2.org/core/config/management", name = "ServizioApplicativo")
@XmlSeeAlso({ObjectFactory.class, org.openspcoop2.core.config.ObjectFactory.class})
public interface ServizioApplicativo {

    @WebResult(name = "idServizioApplicativo", targetNamespace = "http://www.openspcoop2.org/core/config/management")
    @RequestWrapper(localName = "findAllIds", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.client.servizioapplicativo.search.FindAllIds")
    @WebMethod(action = "findAllIds")
    @ResponseWrapper(localName = "findAllIdsResponse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.client.servizioapplicativo.search.FindAllIdsResponse")
    public java.util.List<org.openspcoop2.core.config.IdServizioApplicativo> findAllIds(
        @WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/config/management")
        org.openspcoop2.core.config.ws.client.servizioapplicativo.search.SearchFilterServizioApplicativo filter
    ) throws ConfigNotAuthorizedException_Exception, ConfigNotImplementedException_Exception, ConfigServiceException_Exception;

    @WebResult(name = "servizioApplicativo", targetNamespace = "http://www.openspcoop2.org/core/config/management")
    @RequestWrapper(localName = "find", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.client.servizioapplicativo.search.Find")
    @WebMethod(action = "find")
    @ResponseWrapper(localName = "findResponse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.client.servizioapplicativo.search.FindResponse")
    public org.openspcoop2.core.config.ServizioApplicativo find(
        @WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/config/management")
        org.openspcoop2.core.config.ws.client.servizioapplicativo.search.SearchFilterServizioApplicativo filter
    ) throws ConfigNotFoundException_Exception, ConfigNotAuthorizedException_Exception, ConfigNotImplementedException_Exception, ConfigMultipleResultException_Exception, ConfigServiceException_Exception;

    @WebResult(name = "servizioApplicativo", targetNamespace = "http://www.openspcoop2.org/core/config/management")
    @RequestWrapper(localName = "get", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.client.servizioapplicativo.search.Get")
    @WebMethod(action = "get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.client.servizioapplicativo.search.GetResponse")
    public org.openspcoop2.core.config.ServizioApplicativo get(
        @WebParam(name = "idServizioApplicativo", targetNamespace = "http://www.openspcoop2.org/core/config/management")
        org.openspcoop2.core.config.IdServizioApplicativo idServizioApplicativo
    ) throws ConfigNotFoundException_Exception, ConfigNotAuthorizedException_Exception, ConfigNotImplementedException_Exception, ConfigMultipleResultException_Exception, ConfigServiceException_Exception;

    @WebResult(name = "servizioApplicativo", targetNamespace = "http://www.openspcoop2.org/core/config/management")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.client.servizioapplicativo.search.FindAll")
    @WebMethod(action = "findAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.client.servizioapplicativo.search.FindAllResponse")
    public java.util.List<org.openspcoop2.core.config.ServizioApplicativo> findAll(
        @WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/config/management")
        org.openspcoop2.core.config.ws.client.servizioapplicativo.search.SearchFilterServizioApplicativo filter
    ) throws ConfigNotAuthorizedException_Exception, ConfigNotImplementedException_Exception, ConfigServiceException_Exception;

    @WebResult(name = "inUse", targetNamespace = "http://www.openspcoop2.org/core/config/management")
    @RequestWrapper(localName = "inUse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.client.servizioapplicativo.search.InUse")
    @WebMethod(action = "inUse")
    @ResponseWrapper(localName = "inUseResponse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.client.servizioapplicativo.search.InUseResponse")
    public org.openspcoop2.core.config.ws.client.servizioapplicativo.search.UseInfo inUse(
        @WebParam(name = "idServizioApplicativo", targetNamespace = "http://www.openspcoop2.org/core/config/management")
        org.openspcoop2.core.config.IdServizioApplicativo idServizioApplicativo
    ) throws ConfigNotFoundException_Exception, ConfigNotAuthorizedException_Exception, ConfigNotImplementedException_Exception, ConfigServiceException_Exception;

    @WebResult(name = "exists", targetNamespace = "http://www.openspcoop2.org/core/config/management")
    @RequestWrapper(localName = "exists", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.client.servizioapplicativo.search.Exists")
    @WebMethod(action = "exists")
    @ResponseWrapper(localName = "existsResponse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.client.servizioapplicativo.search.ExistsResponse")
    public boolean exists(
        @WebParam(name = "idServizioApplicativo", targetNamespace = "http://www.openspcoop2.org/core/config/management")
        org.openspcoop2.core.config.IdServizioApplicativo idServizioApplicativo
    ) throws ConfigNotAuthorizedException_Exception, ConfigNotImplementedException_Exception, ConfigMultipleResultException_Exception, ConfigServiceException_Exception;

    @WebResult(name = "count", targetNamespace = "http://www.openspcoop2.org/core/config/management")
    @RequestWrapper(localName = "count", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.client.servizioapplicativo.search.Count")
    @WebMethod(action = "count")
    @ResponseWrapper(localName = "countResponse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.client.servizioapplicativo.search.CountResponse")
    public long count(
        @WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/config/management")
        org.openspcoop2.core.config.ws.client.servizioapplicativo.search.SearchFilterServizioApplicativo filter
    ) throws ConfigNotAuthorizedException_Exception, ConfigNotImplementedException_Exception, ConfigServiceException_Exception;
}
