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
package org.openspcoop2.utils.jaxb;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * DateTime2Date
 *
 *
 * @author Nardi Lorenzo (nardi@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class DateTime2String extends XmlAdapter<String, Date>
{
	@Override
	public String marshal(Date dt) throws Exception {
		if(dt==null){
			return null;
		}
		Calendar cal = new GregorianCalendar();
	    cal.setTime(dt);
	    return DatatypeConverter.printDateTime(cal);
	}
	@Override
	public Date unmarshal(String sParam) throws Exception {
		if(sParam==null){
			return null;
		}
		String s = sParam.trim();
		return DatatypeConverter.parseDateTime(s).getTime();
	}
}

