/*
 * OpenSPCoop - Customizable API Gateway 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2017 Link.it srl (http://link.it). 
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


package org.openspcoop2.utils.swagger;

import java.io.File;
import java.net.URI;
import java.util.Map;

import org.openspcoop2.utils.LoggerWrapperFactory;
import org.openspcoop2.utils.rest.ApiFactory;
import org.openspcoop2.utils.rest.ApiFormats;
import org.openspcoop2.utils.rest.ApiReaderConfig;
import org.openspcoop2.utils.rest.IApiReader;
import org.openspcoop2.utils.rest.api.Api;
import org.openspcoop2.utils.transport.http.HttpRequestMethod;

import io.swagger.models.Model;
import io.swagger.util.Json;


/**
 * Test
 * 
 * @author Andrea Poli (apoli@link.it)
 * @author $Author: apoli $
 * @version $Rev: 13134 $, $Date: 2017-07-13 12:32:49 +0200(gio, 13 lug 2017) $
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {

		URI uri = Test.class.getResource("/org/openspcoop2/utils/swagger/test.json").toURI();
        
        IApiReader apiReader = ApiFactory.newApiReader(ApiFormats.SWAGGER);
        apiReader.init(LoggerWrapperFactory.getLogger(Test.class), new File(uri), new ApiReaderConfig());
        Api api = apiReader.read();
        
        String test = "http://petstore.swagger.io/v2/pet";
        System.out.println("API-Op ["+test+"]: "+api.findOperation(HttpRequestMethod.POST, test));
        
        String testSenzaBaseUri = "/pet";
        System.out.println("API-Op ["+testSenzaBaseUri+"]: "+api.findOperation(HttpRequestMethod.POST, testSenzaBaseUri));

        String testConPetid = "/pet/2";
        System.out.println("API-Op ["+testConPetid+"]: "+api.findOperation(HttpRequestMethod.GET, testConPetid));
        
        System.out.println("API-Op PUT ["+testConPetid+"]: "+api.findOperation(HttpRequestMethod.PUT, testConPetid));

        String testPathInesistente = "/pet/find/inesistente";
        System.out.println("API-Op ["+testPathInesistente+"]: "+api.findOperation(HttpRequestMethod.GET, testPathInesistente));
        
        
        String model = "Pet";
        Map<String, Model> definitions = ((SwaggerApi)api).getSwagger().getDefinitions();
        
		byte[] writeValueAsBytes = Json.pretty().writeValueAsBytes(definitions);
        String anyOf ="\"anyOf\": [{\"$ref\": \"#/definitions/"+model+"\"}]";
        	          
		System.out.println("{\"definitions\" : " + new String(writeValueAsBytes) + ", "+anyOf+"}");
		

	}
}