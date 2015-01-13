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
package org.openspcoop2.core.config.ws.server;

import org.openspcoop2.core.config.ws.server.filter.SearchFilterPortaApplicativa;
import java.util.List;

import org.openspcoop2.core.config.ws.server.beans.UseInfo;

import org.openspcoop2.core.config.PortaApplicativa;

import org.openspcoop2.core.config.ws.server.exception.ConfigServiceException;
import org.openspcoop2.core.config.ws.server.exception.ConfigNotFoundException;
import org.openspcoop2.core.config.ws.server.exception.ConfigMultipleResultException;
import org.openspcoop2.core.config.ws.server.exception.ConfigNotImplementedException;
import org.openspcoop2.core.config.ws.server.exception.ConfigNotAuthorizedException;

import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

/**     
 * PortaApplicativaSearch
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */

@javax.jws.WebService(targetNamespace = "http://www.openspcoop2.org/core/config/management", name = "PortaApplicativa")
public interface PortaApplicativaSearch {
	/**
	 * It allows you to retrieve all objects of type PortaApplicativa that matching the filter parameter
	 *
	 * @param filter Filter
	 * @return List objects of type PortaApplicativa
	 * @throws ConfigServiceException
	 * @throws ConfigNotImplementedException
	 */
	@javax.xml.ws.ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.wrapped.FindAllPortaApplicativaResponse")
    @javax.xml.ws.RequestWrapper(localName = "findAll", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.wrapped.FindAllPortaApplicativa")
    @javax.jws.WebResult(name = "itemsFound", targetNamespace = "http://www.openspcoop2.org/core/config/management")
    @javax.jws.soap.SOAPBinding(parameterStyle=ParameterStyle.WRAPPED,style=Style.DOCUMENT,use=Use.LITERAL)
    @javax.jws.WebMethod(action="findAll",operationName="findAll")
	public List<PortaApplicativa> findAll(
		@javax.jws.WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/config/management")
		SearchFilterPortaApplicativa filter
	) throws ConfigServiceException,ConfigNotImplementedException,ConfigNotAuthorizedException;

	/**
	 * It allows you to retrieve the object of type PortaApplicativa that matching the filter parameter
	 *
	 * @param filter Filter
	 * @return object of type PortaApplicativa
	 * @throws ConfigServiceException
	 * @throws ConfigNotFoundException
	 * @throws ConfigMultipleResultException
	 * @throws ConfigNotImplementedException
	 */
	@javax.xml.ws.ResponseWrapper(localName = "findResponse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.wrapped.FindPortaApplicativaResponse")
    @javax.xml.ws.RequestWrapper(localName = "find", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.wrapped.FindPortaApplicativa")
    @javax.jws.WebResult(name = "portaApplicativa", targetNamespace = "http://www.openspcoop2.org/core/config/management")
    @javax.jws.soap.SOAPBinding(parameterStyle=ParameterStyle.WRAPPED,style=Style.DOCUMENT,use=Use.LITERAL)
    @javax.jws.WebMethod(action="find",operationName="find")
	public PortaApplicativa find(
	    @javax.jws.WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/config/management")
		SearchFilterPortaApplicativa filter
	) throws ConfigServiceException,ConfigNotFoundException,ConfigMultipleResultException,ConfigNotImplementedException,ConfigNotAuthorizedException;

	/**
	 * It allows you to count all objects of type PortaApplicativa that matching the filter parameter
	 *
	 * @param filter Filter
	 * @return Count all objects of type PortaApplicativa
	 * @throws ConfigServiceException
	 * @throws ConfigNotImplementedException
	 */
	@javax.xml.ws.ResponseWrapper(localName = "countResponse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.wrapped.CountPortaApplicativaResponse")
    @javax.xml.ws.RequestWrapper(localName = "count", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.wrapped.CountPortaApplicativa")
    @javax.jws.WebResult(name = "countItems", targetNamespace = "http://www.openspcoop2.org/core/config/management")
    @javax.jws.soap.SOAPBinding(parameterStyle=ParameterStyle.WRAPPED,style=Style.DOCUMENT,use=Use.LITERAL)
    @javax.jws.WebMethod(action="count",operationName="count")
	public long count(
		@javax.jws.WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/config/management")
		SearchFilterPortaApplicativa filter
	) throws ConfigServiceException,ConfigNotImplementedException,ConfigNotAuthorizedException;

	/**
	 * It allows you to retrieve the object of type PortaApplicativa identified by the id parameter.
	 *
	 * @param id Object Id
	 * @return object of type PortaApplicativa
	 * @throws ConfigServiceException
	 * @throws ConfigNotFoundException
	 * @throws ConfigMultipleResultException
	 * @throws ConfigNotImplementedException
	 */
	@javax.xml.ws.ResponseWrapper(localName = "getResponse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.wrapped.GetPortaApplicativaResponse")
    @javax.xml.ws.RequestWrapper(localName = "get", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.wrapped.GetPortaApplicativa")
    @javax.jws.WebResult(name = "portaApplicativa", targetNamespace = "http://www.openspcoop2.org/core/config/management")
    @javax.jws.soap.SOAPBinding(parameterStyle=ParameterStyle.WRAPPED,style=Style.DOCUMENT,use=Use.LITERAL)
    @javax.jws.WebMethod(action="get",operationName="get")
	public PortaApplicativa get(
		@javax.jws.WebParam(name = "id", targetNamespace = "http://www.openspcoop2.org/core/config/management")
		org.openspcoop2.core.config.IdPortaApplicativa id
	) throws ConfigServiceException,ConfigNotFoundException,ConfigMultipleResultException,ConfigNotImplementedException,ConfigNotAuthorizedException;

	/**
	 * Indicates the existence of the instance of the object PortaApplicativa identified by the id parameter.
	 *
	 * @param id Object Id
	 * @return Indicates the existence of the instance of the object PortaApplicativa identified by the id parameter. 
	 * @throws ConfigServiceException
	 * @throws ConfigMultipleResultException
	 * @throws ConfigNotImplementedException
	 */	
	@javax.xml.ws.ResponseWrapper(localName = "existsResponse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.wrapped.ExistsPortaApplicativaResponse")
    @javax.xml.ws.RequestWrapper(localName = "exists", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.wrapped.ExistsPortaApplicativa")
    @javax.jws.WebResult(name = "exists", targetNamespace = "http://www.openspcoop2.org/core/config/management")
    @javax.jws.soap.SOAPBinding(parameterStyle=ParameterStyle.WRAPPED,style=Style.DOCUMENT,use=Use.LITERAL)
    @javax.jws.WebMethod(action="exists",operationName="exists")
	public boolean exists(
		@javax.jws.WebParam(name = "id", targetNamespace = "http://www.openspcoop2.org/core/config/management")
		org.openspcoop2.core.config.IdPortaApplicativa id
	) throws ConfigServiceException,ConfigMultipleResultException,ConfigNotImplementedException,ConfigNotAuthorizedException;

	/**
	 * It allows you to retrieve all object Ids of type org.openspcoop2.core.config.IdPortaApplicativa that matching the filter parameter
	 *
	 * @param filter Filter
	 * @return List object ids of type org.openspcoop2.core.config.IdPortaApplicativa
	 * @throws ConfigServiceException
	 * @throws ConfigNotImplementedException
	 */
	@javax.xml.ws.ResponseWrapper(localName = "findAllIdsResponse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.wrapped.FindAllIdsPortaApplicativaResponse")
    @javax.xml.ws.RequestWrapper(localName = "findAllIds", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.wrapped.FindAllIdsPortaApplicativa")
    @javax.jws.WebResult(name = "itemsFound", targetNamespace = "http://www.openspcoop2.org/core/config/management")
    @javax.jws.soap.SOAPBinding(parameterStyle=ParameterStyle.WRAPPED,style=Style.DOCUMENT,use=Use.LITERAL)
    @javax.jws.WebMethod(action="findAllIds",operationName="findAllIds")
	public List<org.openspcoop2.core.config.IdPortaApplicativa> findAllIds(
		@javax.jws.WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/config/management")
		SearchFilterPortaApplicativa filter
	) throws ConfigServiceException,ConfigNotImplementedException,ConfigNotAuthorizedException;

	/**
	 * Indicates the use of the object (identified by parameter) by other components
	 *
	 * @return Indicates the use of the object (identified by parameter) by other components
	 * @throws ConfigServiceException
	 * @throws ConfigNotFoundException
	 * @throws ConfigNotImplementedException
	 */
	@javax.xml.ws.ResponseWrapper(localName = "inUseResponse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.wrapped.UseInfoPortaApplicativaResponse")
    @javax.xml.ws.RequestWrapper(localName = "inUse", targetNamespace = "http://www.openspcoop2.org/core/config/management", className = "org.openspcoop2.core.config.ws.wrapped.UseInfoPortaApplicativa")
    @javax.jws.WebResult(name = "inUse", targetNamespace = "http://www.openspcoop2.org/core/config/management")
	@javax.jws.soap.SOAPBinding(parameterStyle=ParameterStyle.WRAPPED,style=Style.DOCUMENT,use=Use.LITERAL)
    @javax.jws.WebMethod(action="inUse",operationName="inUse")
	public UseInfo inUse(
		@javax.jws.WebParam(name = "id", targetNamespace = "http://www.openspcoop2.org/core/config/management")
		org.openspcoop2.core.config.IdPortaApplicativa id
	) throws ConfigServiceException,ConfigNotFoundException,ConfigNotImplementedException,ConfigNotAuthorizedException;

}