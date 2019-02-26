/*
 * GovWay - A customizable API Gateway 
 * http://www.govway.org
 *
 * from the Link.it OpenSPCoop project codebase
 * 
 * Copyright (c) 2005-2019 Link.it srl (http://link.it). 
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



package org.openspcoop2.utils.date;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openspcoop2.utils.UtilsException;

/**
 * Classe per la produzione di date utilizzando la data di Java.
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class JavaDate implements IDate{

	/**
	 * Impostazione delle proprieta' per il DateManager
	 */
	@Override
	public void init(java.util.Properties properties) throws UtilsException{}
	
	/**
	 * Close il DataManager
	 * 
	 * @throws UtilsException
	 */
	@Override
	public void close() throws UtilsException{}
	
	/**
	 * Ritorna la data corrente.
	 * 
	 * @return Data corrente
	 */
	@Override
	public Date getDate() throws UtilsException{
		return new Date();
	}
	
	/**
	 * Ritorna la data corrente in millisecondi da Gennaio 1.4970.
	 * 
	 * @return Data corrente
	 */
	@Override
	public long getTimeMillis() throws UtilsException{
		return new Date().getTime();
	}
	
	/**
	 * Ritorna la data corrente come timestamp SQL.
	 * 
	 * @return Data corrente
	 */
	@Override
	public Timestamp getTimestamp() throws UtilsException{
		return new Timestamp(new Date().getTime());
	}
	
	/**
	 * Ritorna la data corrente come Calendar
	 * 
	 * @return Data corrente
	 */
	@Override
	public Calendar getCalendar() throws UtilsException{
		Calendar c = new GregorianCalendar();
		c.setTime(this.getDate());
		return c;
	}
}
