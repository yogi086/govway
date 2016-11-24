/*
 * OpenSPCoop - Customizable API Gateway 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2016 Link.it srl (http://link.it). 
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



package org.openspcoop2.message.config;

import org.openspcoop2.message.constants.IntegrationErrorMessageType;
import org.openspcoop2.message.constants.MessageType;

/**
 * IntegrationErrorConfiguration
 *
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author: apoli $
 * @version $Rev: 12237 $, $Date: 2016-10-04 11:41:45 +0200 (Tue, 04 Oct 2016) $
 */

public class IntegrationErrorConfiguration implements java.io.Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private IntegrationErrorMessageType errorType;
	private IntegrationErrorMessageType defaultErrorType;
	private int httpReturnCode;

	public IntegrationErrorConfiguration(IntegrationErrorMessageType errorType, int httpReturnCode){
		this.errorType = errorType;
		this.httpReturnCode = httpReturnCode;
	}
	
	void setDefaultErrorType(IntegrationErrorMessageType defaultErrorType) {
		this.defaultErrorType = defaultErrorType;
	}
	public int getHttpReturnCode() {
		return this.httpReturnCode;
	}
	
	public MessageType getMessageType(MessageType requestMsgType){
		switch (this.errorType) {
		case SOAP:
			if(MessageType.SOAP_11.equals(requestMsgType) || MessageType.SOAP_12.equals(requestMsgType) )
				return requestMsgType;
			return MessageType.BINARY; // content is null
		case XML:
			return MessageType.XML;
		case JSON:
			return MessageType.JSON;
		case SAME_AS_REQUEST:
			if(MessageType.SOAP_11.equals(requestMsgType) || MessageType.SOAP_12.equals(requestMsgType) )
				return requestMsgType;
			if(MessageType.XML.equals(requestMsgType) || MessageType.JSON.equals(requestMsgType) )
				return requestMsgType;
			return getDefaultMessageType(requestMsgType);
		default:
			return MessageType.BINARY; // content is null
		}
	}
	public MessageType getDefaultMessageType(MessageType requestMsgType){
		switch (this.defaultErrorType) {
		case SOAP:
			if(MessageType.SOAP_11.equals(requestMsgType) || MessageType.SOAP_12.equals(requestMsgType) )
				return requestMsgType;
			return MessageType.BINARY; // content is null
		case XML:
			return MessageType.XML;
		case JSON:
			return MessageType.JSON;
		default:
			return MessageType.BINARY; // content is null
		}
	}
}




