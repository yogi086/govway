package org.openspcoop2.core.registry.ws.client.portadominio.crud;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2017-04-24T12:01:56.459+02:00
 * Generated source version: 3.1.7
 * 
 */
@WebService(targetNamespace = "http://www.openspcoop2.org/core/registry/management", name = "PortaDominio")
@XmlSeeAlso({ObjectFactory.class, org.openspcoop2.core.registry.ObjectFactory.class})
public interface PortaDominio {

    @WebResult(name = "count", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "deleteAll", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.portadominio.crud.DeleteAll")
    @WebMethod(action = "deleteAll")
    @ResponseWrapper(localName = "deleteAllResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.portadominio.crud.DeleteAllResponse")
    public long deleteAll() throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @RequestWrapper(localName = "delete", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.portadominio.crud.Delete")
    @WebMethod(action = "delete")
    @ResponseWrapper(localName = "deleteResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.portadominio.crud.DeleteResponse")
    public void delete(
        @WebParam(name = "portaDominio", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.PortaDominio portaDominio
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @RequestWrapper(localName = "deleteById", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.portadominio.crud.DeleteById")
    @WebMethod(action = "deleteById")
    @ResponseWrapper(localName = "deleteByIdResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.portadominio.crud.DeleteByIdResponse")
    public void deleteById(
        @WebParam(name = "idPortaDominio", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.IdPortaDominio idPortaDominio
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @RequestWrapper(localName = "updateOrCreate", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.portadominio.crud.UpdateOrCreate")
    @WebMethod(action = "updateOrCreate")
    @ResponseWrapper(localName = "updateOrCreateResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.portadominio.crud.UpdateOrCreateResponse")
    public void updateOrCreate(
        @WebParam(name = "oldIdPortaDominio", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.IdPortaDominio oldIdPortaDominio,
        @WebParam(name = "portaDominio", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.PortaDominio portaDominio
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @WebResult(name = "count", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "deleteAllByFilter", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.portadominio.crud.DeleteAllByFilter")
    @WebMethod(action = "deleteAllByFilter")
    @ResponseWrapper(localName = "deleteAllByFilterResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.portadominio.crud.DeleteAllByFilterResponse")
    public long deleteAllByFilter(
        @WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.ws.client.portadominio.crud.SearchFilterPortaDominio filter
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @RequestWrapper(localName = "create", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.portadominio.crud.Create")
    @WebMethod(action = "create")
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.portadominio.crud.CreateResponse")
    public void create(
        @WebParam(name = "portaDominio", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.PortaDominio portaDominio
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @RequestWrapper(localName = "update", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.portadominio.crud.Update")
    @WebMethod(action = "update")
    @ResponseWrapper(localName = "updateResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.portadominio.crud.UpdateResponse")
    public void update(
        @WebParam(name = "oldIdPortaDominio", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.IdPortaDominio oldIdPortaDominio,
        @WebParam(name = "portaDominio", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.PortaDominio portaDominio
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception, RegistryNotFoundException_Exception;
}
