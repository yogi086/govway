/*
 * GovWay - A customizable API Gateway 
 * https://govway.org
 * 
 * Copyright (c) 2005-2020 Link.it srl (https://link.it). 
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



package org.openspcoop2.pdd.core.trasformazioni;

import org.openspcoop2.message.OpenSPCoop2Message;
import org.openspcoop2.message.OpenSPCoop2MessageFactory;
import org.openspcoop2.message.constants.MessageRole;
import org.openspcoop2.message.constants.MessageType;
import org.openspcoop2.pdd.core.dynamic.ErrorMessage;

/**	
 * Contiene la definizione di una eccezione lanciata dalla classe GestoreTrasformazioni
 *
 * @author Andrea Poli <apoli@link.it>
 * @author $Author$
 * @version $Rev$, $Date$
 */


public class GestoreTrasformazioniException extends Exception  {
	
	/**
	 * SerialUID
	 */
	private static final long serialVersionUID = 1L;

	private ErrorMessage errorMessage = null;
	
	public GestoreTrasformazioniException(String message, Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public GestoreTrasformazioniException(Throwable cause)
	{
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public GestoreTrasformazioniException() {
		super();
    }
	public GestoreTrasformazioniException(String msg) {
        super(msg);
    }
	
	public GestoreTrasformazioniException(String detail, ErrorMessage errorMessage) {
        super(detail);
        this.errorMessage = errorMessage;
    }
	
	public ErrorMessage getErrorMessage() {
		return this.errorMessage;
	}
	public OpenSPCoop2Message getOpenSPCoop2ErrorMessage() {
		if(this.errorMessage==null) {
			return null;
		}
		OpenSPCoop2Message op2ErrorMessage = OpenSPCoop2MessageFactory.getDefaultMessageFactory().createEmptyMessage(MessageType.BINARY, MessageRole.FAULT);
		op2ErrorMessage.forceResponse(this.errorMessage);
		return op2ErrorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
}
