/*
 * OpenSPCoop - Customizable API Gateway 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2018 Link.it srl (http://link.it).
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

package org.openspcoop2.generic_project.dao.jdbc.utils;

import org.openspcoop2.utils.TipiDatabase;
import org.openspcoop2.utils.sql.HyperSQLQueryObject;
import org.openspcoop2.utils.sql.ISQLQueryObject;
import org.openspcoop2.utils.sql.SQLQueryObjectException;

/**
 * JDBC_HyperQueryObject
 * 
 * @author Poli Andrea (apoli@link.it)
 * @author $Author: apoli $
 * @version $Rev: 13572 $, $Date: 2018-01-26 11:48:01 +0100 (Fri, 26 Jan 2018) $
 */
public class JDBC_HyperQueryObject extends HyperSQLQueryObject {

	private JDBC_SQLObjectFactory factory;

	public JDBC_HyperQueryObject(JDBC_SQLObjectFactory factory) {
		super(TipiDatabase.HSQL);
		this.factory = factory;
	}
	
	@Override
	public ISQLQueryObject newSQLQueryObject() throws SQLQueryObjectException {		
		return this.factory.createSQLQueryObject(this.getTipoDatabaseOpenSPCoop2());
	}
	
	
}