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

package org.openspcoop2.utils.csv;
import org.apache.commons.csv.CSVFormat;

/**
 * Format
 *
 * @author Andrea Poli (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class Format {

	private CSVFormat csvFormat;
	private boolean skipEmptyRecord;
	
	public CSVFormat getCsvFormat() {
		return this.csvFormat;
	}
	public void setCsvFormat(CSVFormat csvFormat) {
		this.csvFormat = csvFormat;
	}
	public boolean isSkipEmptyRecord() {
		return this.skipEmptyRecord;
	}
	public void setSkipEmptyRecord(boolean skipEmptyRecord) {
		this.skipEmptyRecord = skipEmptyRecord;
	}
	
}
