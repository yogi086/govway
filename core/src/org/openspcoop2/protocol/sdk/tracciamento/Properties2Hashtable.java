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
package org.openspcoop2.protocol.sdk.tracciamento;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.xml.bind.annotation.adapters.XmlAdapter;


/**
 * Properties2Hashtable
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class Properties2Hashtable extends XmlAdapter<Properties, Hashtable<String, String>>
{
	@Override
	public Properties marshal(Hashtable<String, String> hash) throws Exception {
		Properties prop = new Properties();
		Iterator<Entry<String,String>> i = hash.entrySet().iterator();
		while(i.hasNext()){
			Entry<String,String> e = i.next();
			prop.getEntry().add(new Properties.Entry(e.getKey(),e.getValue()));
		}
		return prop;
	}
	@Override
	public Hashtable<String, String> unmarshal(Properties prop) throws Exception {
		Hashtable<String, String> hash = new Hashtable<String, String>();
		Iterator<Properties.Entry> i = prop.getEntry().iterator();
		while(i.hasNext()){
			Properties.Entry e = i.next();
			hash.put(e.getKey(), e.getValue());
		}
		return hash;
	}
}

