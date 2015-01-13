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
package org.openspcoop2.generic_project.beans;

import java.util.Date;

import org.openspcoop2.generic_project.exception.ExpressionException;
import org.openspcoop2.generic_project.expression.impl.sql.ISQLFieldConverter;
import org.openspcoop2.utils.sql.ISQLQueryObject;
import org.openspcoop2.utils.sql.SQLObjectFactory;
import org.openspcoop2.utils.sql.SQLQueryObjectException;

/**
 * TimestampIntervalField
 * 
 * @author Poli Andrea (apoli@link.it)
 * @author $Author: apoli $
 * @version $Rev: 9740 $, $Date: 2014-03-06 17:01:50 +0100 (Thu, 06 Mar 2014) $
 */
public class UnixTimestampIntervalField extends CustomField {
	
	public UnixTimestampIntervalField(String fieldName,ISQLFieldConverter fieldConverter,boolean appendTablePrefix, IField maxInterval, IField minInterval) throws ExpressionException, SQLQueryObjectException{
		super(fieldName, Long.class, buildFunction(fieldConverter,appendTablePrefix,maxInterval,minInterval), fieldName, "", "");
	}
	
	private static String buildFunction(ISQLFieldConverter fieldConverter, boolean appendTablePrefix, IField maxInterval, IField minInterval) throws ExpressionException, SQLQueryObjectException{
		if(maxInterval==null){
			throw new ExpressionException("MaxInterval is null");
		}
		if(minInterval==null){
			throw new ExpressionException("MinInterval is null");
		}
		if(!Date.class.getName().equals(maxInterval.getFieldType().getName())){
			throw new ExpressionException("MaxInterval with wrong type, expected:"+Date.class.getName()+" found:"+maxInterval.getFieldType());
		}
		if(!Date.class.getName().equals(minInterval.getFieldType().getName())){
			throw new ExpressionException("MinInterval with wrong type, expected:"+Date.class.getName()+" found:"+minInterval.getFieldType());
		}
		ISQLQueryObject sqlQueryObject = SQLObjectFactory.createSQLQueryObject(fieldConverter.getDatabaseType());
		return sqlQueryObject.getDiffUnixTimestamp(fieldConverter.toColumn(maxInterval, appendTablePrefix), fieldConverter.toColumn(minInterval, appendTablePrefix));
	}
	

}
