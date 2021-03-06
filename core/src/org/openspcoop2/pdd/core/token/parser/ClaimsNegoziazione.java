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
package org.openspcoop2.pdd.core.token.parser;

/**     
 * Claims
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class ClaimsNegoziazione {

	// https://tools.ietf.org/html/rfc6749
	
	public final static String OAUTH2_RFC_6749_ACCESS_TOKEN = "access_token";
	public final static String OAUTH2_RFC_6749_REFRESH_TOKEN = "refresh_token";
	public final static String OAUTH2_RFC_6749_TOKEN_TYPE = "token_type";
	public final static String OAUTH2_RFC_6749_EXPIRES_IN = "expires_in";
	public final static String OAUTH2_RFC_6749_SCOPE = "scope";
	
	public final static String OAUTH2_RFC_6749_REQUEST_GRANT_TYPE = "grant_type";
	public final static String OAUTH2_RFC_6749_REQUEST_GRANT_TYPE_CLIENT_CREDENTIALS_GRANT = "client_credentials";
	public final static String OAUTH2_RFC_6749_REQUEST_GRANT_TYPE_RESOURCE_OWNER_PASSWORD_CREDENTIALS_GRANT = "password";
	public final static String OAUTH2_RFC_6749_REQUEST_USERNAME = "username";
	public final static String OAUTH2_RFC_6749_REQUEST_PASSWORD = "password";
	public final static String OAUTH2_RFC_6749_REQUEST_CLIENT_ID = "client_id";
	public final static String OAUTH2_RFC_6749_REQUEST_CLIENT_SECRET = "client_secret";
	public final static String OAUTH2_RFC_6749_REQUEST_SCOPE = "scope";
	public final static String OAUTH2_RFC_6749_REQUEST_AUDIENCE = "audience"; // es. https://auth0.com/docs/api-auth/tutorials/client-credentials
	
}
