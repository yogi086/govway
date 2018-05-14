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
package org.openspcoop2.generic_project.serializer;


import java.io.InputStream;

import org.openspcoop2.utils.serialization.IDeserializer;
import org.openspcoop2.utils.serialization.SerializationConfig;
import org.openspcoop2.utils.serialization.SerializationFactory;
import org.openspcoop2.utils.serialization.SerializationFactory.SERIALIZATION_TYPE;


/**
 * JsonDeserializer
 * 
 * @author Poli Andrea (apoli@link.it)
 * @author $Author: apoli $
 * @version $Rev: 13934 $, $Date: 2018-05-11 10:49:42 +0200 (Fri, 11 May 2018) $
 */
public abstract class AbstractDeserializerWithFactory extends AbstractDeserializer {

	protected abstract SERIALIZATION_TYPE getSERIALIZATION_TYPE();
	
	@SuppressWarnings("unchecked")
	@Override
	protected <T> T _xmlToObj(InputStream is, Class<T> c) throws Exception {
		IDeserializer deserializer = SerializationFactory.getDeserializer(this.getSERIALIZATION_TYPE(), new SerializationConfig());
		try{
			return (T) deserializer.readObject(is, c);
		}finally{
		}
	}
	
}

