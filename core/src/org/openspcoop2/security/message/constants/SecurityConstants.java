/*
 * OpenSPCoop v2 - Customizable SOAP Message Broker 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2016 Link.it srl (http://link.it). 
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

package org.openspcoop2.security.message.constants;

import java.util.Hashtable;

import javax.xml.namespace.QName;

import org.apache.ws.security.handler.WSHandlerConstants;
import org.openspcoop2.utils.digest.Constants;

/**
 * WSSConstants
 *
 * @author Andrea Poli <apoli@link.it>
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class SecurityConstants {

	public static final String ACTION = WSHandlerConstants.ACTION;
		
	public static final String TIPO_SECURITY_ENGINE_SEPARATOR = " ";
	public static final String TIPO_SECURITY_ACTION_SEPARATOR = ",";
	public static String convertActionToString(Hashtable<String, Object> flow){
		if(flow!=null){
			if(flow.containsKey(ACTION)){
				
				String engine = SECURITY_ENGINE_WSS4J;
				if(flow.containsKey(SECURITY_ENGINE)){
					Object o = flow.get(SECURITY_ENGINE);
					if(o!=null && o instanceof String){
						engine = (String) o;
					}
				}
				
				Object o = flow.get(ACTION);
				if(o!=null && o instanceof String){
					String actions = (String) o;
					actions = actions.trim();
					if(actions.contains(" ")){
						String [] tmp = actions.split(" ");
						StringBuffer bf = new StringBuffer();
						bf.append(engine);
						bf.append(TIPO_SECURITY_ENGINE_SEPARATOR);
						for (int i = 0; i < tmp.length; i++) {
							if(tmp[i]!=null){
								if(i>0){
									bf.append(TIPO_SECURITY_ACTION_SEPARATOR);
								}
								bf.append(tmp[i].trim());
							}
						}
						return bf.toString();
					}
					else{
						return engine + TIPO_SECURITY_ENGINE_SEPARATOR + actions; // una sola azione presente
					}
				}
			}
		}
		return null;
	}
	
	public static final String SECURITY_ENGINE = "securityEngine";
	public static final String SECURITY_ENGINE_WSS4J = "wss4j";
	public static final String SECURITY_ENGINE_SOAPBOX = "soapbox";
	public static final String SECURITY_ENGINE_DSS = "dss";
	
	public static final String SIGNATURE_ENGINE = "signatureEngine";
	public static final String SIGNATURE_ENGINE_SUN = "sun";
	public static final String SIGNATURE_ENGINE_XMLSEC = "xmlSec";

	public static QName QNAME_WSS_ELEMENT_SECURITY = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd","Security");
	
	public static final String WSS_HEADER_ELEMENT = "Security";
    public static final String WSS_HEADER_ELEMENT_NAMESPACE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
    public static final String WSS_HEADER_UTILITY_NAMESPACE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";					  
    public static final String WSS_HEADER_ATTRIBUTE_REFERENCE_ID_WSSECURITY = "Id";
    public static final String WSS_HEADER_DS_NAMESPACE = Constants.WSS_HEADER_DS_NAMESPACE;
    public static final String WSS_HEADER_DS_REFERENCE_ELEMENT = Constants.WSS_HEADER_DS_REFERENCE_ELEMENT;
    public static final String WSS_HEADER_DS_REFERENCE_ATTRIBUTE_URI = Constants.WSS_HEADER_DS_REFERENCE_ATTRIBUTE_URI;
    public static final String WSS_HEADER_DS_REFERENCE_DIGEST_VALUE_ELEMENT = Constants.WSS_HEADER_DS_REFERENCE_DIGEST_VALUE_ELEMENT;
    
    public static final String ACTOR = WSHandlerConstants.ACTOR;
    
    public static final String MUST_UNDERSTAND = WSHandlerConstants.MUST_UNDERSTAND;
    
    public static final boolean SECURITY_CLIENT = true;
    public static final boolean SECUIRYT_SERVER = false;
    
    public static final String USER = WSHandlerConstants.USER;
    
    public static final String MULTI_USER_KEYWORD_PORTA_DOMINIO_FRUITORE = "#MultiPropUsePddFruitoreAsAlias#";
    public static final String MULTI_USER_KEYWORD_PORTA_DOMINIO_EROGATORE = "#MultiPropUsePddErogatoreAsAlias#";
    public static final String MULTI_USER_KEYWORD_IDENTIFICATIVO_PORTA_FRUITORE = "#MultiPropUseIdentificativoPortaFruitoreAsAlias#";
    public static final String MULTI_USER_KEYWORD_IDENTIFICATIVO_PORTA_EROGATORE = "#MultiPropUseIdentificativoPortaErogatoreAsAlias#";
    public static final String MULTI_USER_KEYWORD_FRUITORE = "#MultiPropUseFruitoreAsAlias#";
    public static final String MULTI_USER_KEYWORD_EROGATORE = "#MultiPropUseErogatoreAsAlias#";
    public static final String MULTI_USER_KEYWORD_FRUITORE_EROGATORE = "#MultiPropUseFruitoreErogatoreAsAlias#";
    
    public static final String ENCRYPT_ACTION = WSHandlerConstants.ENCRYPT;
    public static final String ENCRYPTION_USER = WSHandlerConstants.ENCRYPTION_USER;
    public static final String ENCRYPTION_PASSWORD = "encryptionPassword";
    public static final String ENCRYPTION_SOAP_FAULT = "encryptionSOAPFault";
    public static final String ENCRYPTION_PARTS = WSHandlerConstants.ENCRYPTION_PARTS;
    public static final String ENCRYPTION_PARTS_VERIFY = "encryptionPartsVerify";
    // ENCRYPTION_ATTACHMENTS_PARTS: {Content/Complete}{indice} 
    // Il valore * o '' puo' essere usato come indice per indicare qualsiasi, altrimenti l'indice indica la posizione dell'attachment
    public static final String ENCRYPTION_NAMESPACE_ATTACH = "Attach";
    public static final String ENCRYPTION_PART_CONTENT = "Content";
    public static final String ENCRYPTION_PART_COMPLETE = "Complete";
    public static final String ENCRYPTION_PART_ELEMENT = "Element";
    public static final String ENCRYPTION_PROPERTY_FILE = WSHandlerConstants.ENC_PROP_FILE;
    public static final String ENCRYPTION_TRUSTSTORE_PROPERTY_FILE = "encryptionTrustStorePropFile";
    public static final String ENCRYPTION_MULTI_PROPERTY_FILE = "encryptionMultiPropFile";
    public static final String ENCRYPTION_SYMMETRIC_KEY_VALUE = "encryptionSymmetricKeyValue";
    public static final String ENCRYPTION_SYMMETRIC = "encryptionSymmetricKey";
    public static final String ENCRYPTION_KEY_SIZE = "encryptionKeySize";
    public static final String ENCRYPTION_KEY_TRANSPORT_ALGORITHM = WSHandlerConstants.ENC_KEY_TRANSPORT;
    public static final String ENCRYPTION_SYMMETRIC_ALGORITHM = WSHandlerConstants.ENC_SYM_ALGO;
    public static final String ENCRYPTION_KEY_IDENTIFIER = WSHandlerConstants.ENC_KEY_ID;
    public static final String DECRYPTION_PROPERTY_FILE = WSHandlerConstants.DEC_PROP_FILE;
    public static final String DECRYPTION_TRUSTSTORE_PROPERTY_FILE = "decryptionTrustStorePropFile";
    public static final String DECRYPTION_MULTI_PROPERTY_FILE = "decryptionMultiPropFile";
    public static final String DECRYPTION_SYMMETRIC_KEY_VALUE = "decryptionSymmetricKeyValue";
    public static final String DECRYPTION_SYMMETRIC_ALGORITHM = "decryptionSymAlgorithm";
    public static final String DECRYPTION_USER = "decryptionUser";
    public static final String DECRYPTION_PASSWORD = "decryptionPassword";
    public static final String DECRYPTION_SYMMETRIC = "decryptionSymmetricKey";
	
    public static final String SIGNATURE_ACTION = WSHandlerConstants.SIGNATURE;
    public static final String SIGNATURE_USER = WSHandlerConstants.SIGNATURE_USER;
    public static final String SIGNATURE_PASSWORD = "signaturePassword";
    public static final String USE_REQ_SIG_CERT = WSHandlerConstants.USE_REQ_SIG_CERT;
    public static final String SIGNATURE_SOAP_FAULT = "signatureSOAPFault";
    public static final String SIGNATURE_PARTS = WSHandlerConstants.SIGNATURE_PARTS;
    public static final String SIGNATURE_PARTS_VERIFY = "signaturePartsVerify";
    // SIGNATURE_ATTACHMENTS_PARTS: {Content/Complete}{indice} 
    // Il valore * o '' puo' essere usato come indice per indicare qualsiasi, altrimenti l'indice indica la posizione dell'attachment
    public static final String SIGNATURE_NAMESPACE_ATTACH = "Attach";
    public static final String SIGNATURE_PART_CONTENT = "Content";
    public static final String SIGNATURE_PART_COMPLETE = "Complete";
    public static final String SIGNATURE_PART_ELEMENT = "Element";
    public static final String SIGNATURE_PROPERTY_FILE = WSHandlerConstants.SIG_PROP_FILE;
    public static final String SIGNATURE_TRUSTSTORE_PROPERTY_FILE = "signatureTrustStorePropFile";
    public static final String SIGNATURE_MULTI_PROPERTY_FILE = "signatureMultiPropFile";
    public static final String SIGNATURE_C14N_ALGORITHM = "signatureC14nAlgorithm";
    public static final String SIGNATURE_DIGEST_ALGORITHM = WSHandlerConstants.SIG_DIGEST_ALGO;
    public static final String SIGNATURE_ALGORITHM = WSHandlerConstants.SIG_ALGO;
    public static final String SIGNATURE_KEY_IDENTIFIER = WSHandlerConstants.SIG_KEY_ID;
    public static final String SIGNATURE_CRL = "signatureCRL";
    
    
    public static final String TIMESTAMP_ACTION = WSHandlerConstants.TIMESTAMP;
    public static final String TIMESTAMP_TTL = WSHandlerConstants.TTL_TIMESTAMP;
    
	public static final String TIMESTAMP_STRICT = WSHandlerConstants.TIMESTAMP_STRICT;
	public static final String TIMESTAMP_PRECISION = WSHandlerConstants.TIMESTAMP_PRECISION;
    public static final String TIMESTAMP_FUTURE_TTL = WSHandlerConstants.TTL_FUTURE_TIMESTAMP;
    
    public static final String TIMESTAMP_SOAPBOX_TTL_DEFAULT = "300";
	public static final String TIMESTAMP_SOAPBOX_FUTURE_TTL_DEFAULT =  "60";

	
	// Do not perform any action, do nothing. Only applies to DOM code.
	public static final String ACTION_NO_SECURITY = "NoSecurity"; //USARE COSTANTE QUANDO SI FA UPDATE WSHandlerConstants.ACTION_NO_SECURITY; // WSS4J 2.0.0
	// Perform a UsernameTokenSignature action.
	public static final String ACTION_USERNAME_TOKEN_SIGNATURE = "UsernameTokenSignature"; //USARE COSTANTE QUANDO SI FA UPDATE WSHandlerConstants.USERNAME_TOKEN_SIGNATURE; // WSS4J 2.0.0
	// Perform a UsernameToken action.
	public static final String ACTION_USERNAME_TOKEN = WSHandlerConstants.USERNAME_TOKEN; 
	// Used on the receiving side to specify a UsernameToken with no password
	public static final String ACTION_USERNAME_TOKEN_NO_PASSWORD = WSHandlerConstants.USERNAME_TOKEN_NO_PASSWORD; 
	// Perform an unsigned SAML Token action.
	public static final String ACTION_SAML_TOKEN_UNSIGNED = WSHandlerConstants.SAML_TOKEN_UNSIGNED; 	
	// Perform a signed SAML Token action.
	public static final String ACTION_SAML_TOKEN_SIGNED = WSHandlerConstants.SAML_TOKEN_SIGNED; 	
	// Perform a signature action.
	public static final String ACTION_SIGNATURE = SIGNATURE_ACTION;
	// Perform a encryption action.
	public static final String ACTION_ENCRYPT = ENCRYPT_ACTION;
	// Perform a Timestamp action.
	public static final String ACTION_TIMESTAMP = TIMESTAMP_ACTION;
	// Perform a Signature action with derived keys.
	public static final String ACTION_SIGNATURE_DERIVED = "SignatureDerived"; //USARE COSTANTE QUANDO SI FA UPDATE WSHandlerConstants.SIGNATURE_DERIVED; // WSS4J 2.0.0
	// Perform a Encryption action with derived keys.
	public static final String ACTION_ENCRYPT_DERIVED = "EncryptDerived"; //USARE COSTANTE QUANDO SI FA UPDATE WSHandlerConstants.ENCRYPT_DERIVED; // WSS4J 2.0.0
	// Perform a Signature action with a kerberos token. Only for StAX code.
	public static final String ACTION_SIGNATURE_WITH_KERBEROS_TOKEN = "SignatureWithKerberosToken"; //USARE COSTANTE QUANDO SI FA UPDATE WSHandlerConstants.SIGNATURE_WITH_KERBEROS_TOKEN; // WSS4J 2.0.0
	// Perform a Encryption action with a kerberos token. Only for StAX code.
	public static final String ACTION_ENCRYPT_WITH_KERBEROS_TOKEN = "EncryptWithKerberosToken"; //USARE COSTANTE QUANDO SI FA UPDATE WSHandlerConstants.ENCRYPT_WITH_KERBEROS_TOKEN; // WSS4J 2.0.0
	// Add a kerberos token.
	public static final String ACTION_KERBEROS_TOKEN = "KerberosToken"; //USARE COSTANTE QUANDO SI FA UPDATE WSHandlerConstants.KERBEROS_TOKEN; // WSS4J 2.0.0
	// Add a "Custom" token from a CallbackHandler
	public static final String ACTION_CUSTOM_TOKEN = "CustomToken"; //USARE COSTANTE QUANDO SI FA UPDATE WSHandlerConstants.CUSTOM_TOKEN; // WSS4J 2.0.0
	// Perform a .NET specific signature using a Username Token action.
	public static final String ACTION_SIGN_WITH_UT_KEY = WSHandlerConstants.SIGN_WITH_UT_KEY; 	// SOLO IN WSS4J 1.6.x QUANDO SI PASSA A 2.0.0 TRASFORMARLO IN STRINGA

	
    
    public static final String KEY_IDENTIFIER_BST_DIRECT_REFERENCE = "DirectReference";
    public static final String KEY_IDENTIFIER_ISSUER_SERIAL = "IssuerSerial";
    public static final String KEY_IDENTIFIER_X509 = "X509KeyIdentifier";
    public static final String KEY_IDENTIFIER_SKI = "SKIKeyIdentifier";
    public static final String KEY_IDENTIFIER_EMBEDDED_KEY_NAME = "EmbeddedKeyName";
    public static final String KEY_IDENTIFIER_THUMBPRINT = "Thumbprint";
    public static final String KEY_IDENTIFIER_ENCRYPTED_KEY_SHA1 = "EncryptedKeySHA1";
    
    public static final String IS_BSP_COMPLIANT = WSHandlerConstants.IS_BSP_COMPLIANT;
    
    public static final String AUTHORIZATION_CLASS = "authorizationClass";
    
    public static final String TRUE = "true";
    public static final String FALSE = "false";

}
