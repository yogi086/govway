package org.openspcoop2.protocol.as4.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.HashMap;

import javax.jms.MapMessage;

import org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.CollaborationInfo;
import org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.From;
import org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.MessageInfo;
import org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.MessageProperties;
import org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.PartInfo;
import org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.PartProperties;
import org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.PartyId;
import org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.PartyInfo;
import org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.PayloadInfo;
import org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.Property;
import org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.Service;
import org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.To;
import org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.UserMessage;
import org.openspcoop2.protocol.as4.constants.AS4Costanti;
import org.openspcoop2.utils.threads.RunnableLogger;

public class RicezioneBusteConnettoreUtils {

	private RunnableLogger log;
	public RicezioneBusteConnettoreUtils(RunnableLogger log) {
		this.log = log;
	}
	
	public void debug(MapMessage map) throws Exception {
		Enumeration<?> mapNames = map.getMapNames();
		while (mapNames.hasMoreElements()) {
			Object name = (Object) mapNames.nextElement();
			if(name instanceof String) {
				String key = (String) name;
				Object value = map.getObjectProperty(key);
				if(value!=null) {
					this.log.debug("\t-Map["+key+"]("+value.getClass().getName()+"): "+value);
				}
				else {
					byte[] bytes = map.getBytes(key);
					if(bytes!=null) {
						File f = File.createTempFile("content", ".bin");
						FileOutputStream fos =new FileOutputStream(f);
						fos.write(bytes);
						fos.flush();
						fos.close();
						this.log.debug("\t-Map["+key+"] scritto in "+f.getAbsolutePath());
					}
					else {
						this.log.debug("\t-Map["+key+"]: "+value);
					}
				}
			}
			else {
				this.log.debug("\t-Map con key diverso dal tipo String: "+name);
			}
		}
		
		this.log.debug("Ricevuto msg: "+map.getJMSMessageID());
		this.log.debug("Ricevuto msg: "+map.getClass().getName());
		Enumeration<?> en = map.getPropertyNames();
		while (en.hasMoreElements()) {
			Object name = (Object) en.nextElement();
			if(name instanceof String) {
				String key = (String) name;
				Object value = map.getObjectProperty(key);
				if(value!=null) {
					this.log.debug("\t-Property["+key+"]("+value.getClass().getName()+"): "+value);
				}
				else {
					this.log.debug("\t-Property["+key+"]: "+value);
				}
			}
			else {
				this.log.debug("\t-Property con key diverso dal tipo String: "+name);
			}
		}
	}

	
	public void fillUserMessage(MapMessage map, UserMessage userMessage,HashMap<String, byte[]> content) throws Exception {
		// PartyInfo
		
		PartyInfo partyInfo = new PartyInfo();
		userMessage.setPartyInfo(partyInfo);
		
		// PartyInfo (From)

		From from = new From();
		PartyId partyIdFrom = new PartyId();
		partyIdFrom.setBase(this.getPropertyJms(map, AS4Costanti.JMS_FROM_PARTY_ID, true));
		partyIdFrom.setType(this.getPropertyJms(map, AS4Costanti.JMS_FROM_PARTY_TYPE, true));
		from.addPartyId(partyIdFrom);
		from.setRole(this.getPropertyJms(map, AS4Costanti.JMS_FROM_ROLE, true));
		partyInfo.setFrom(from);
		
		// PartyInfo (To)

		To destinatario = new To();
		PartyId partyIdTo = new PartyId();
		partyIdTo.setBase(this.getPropertyJms(map, AS4Costanti.JMS_TO_PARTY_ID, true));
		partyIdTo.setType(this.getPropertyJms(map, AS4Costanti.JMS_TO_PARTY_TYPE, true));
		destinatario.addPartyId(partyIdTo);
		destinatario.setRole(this.getPropertyJms(map, AS4Costanti.JMS_TO_ROLE, true));
		partyInfo.setTo(destinatario);
						
		// CollaborationInfo

		CollaborationInfo collaborationInfo = new CollaborationInfo();
		userMessage.setCollaborationInfo(collaborationInfo);
		
		// CollaborationInfo (Service)
		
		Service service = new Service();
		service.setBase(this.getPropertyJms(map, AS4Costanti.JMS_SERVICE, true));
		service.setType(this.getPropertyJms(map, AS4Costanti.JMS_SERVICE_TYPE, false));
		collaborationInfo.setService(service);
		
		// CollaborationInfo (Action)
		
		collaborationInfo.setAction(this.getPropertyJms(map, AS4Costanti.JMS_ACTION, true));
		
		// CollaborationInfo (Conversation)
		
		collaborationInfo.setConversationId(this.getPropertyJms(map, AS4Costanti.JMS_CONVERSATION_ID, true));
		
		// MessageInfo
		
		MessageInfo messageInfo = new MessageInfo();
		messageInfo.setMessageId(this.getPropertyJms(map, AS4Costanti.JMS_MESSAGE_ID, true));
		messageInfo.setRefToMessageId(this.getPropertyJms(map, AS4Costanti.JMS_REF_TO_MESSAGE_ID, false));
		userMessage.setMessageInfo(messageInfo);
		
		// PayloadInfo
		
		PayloadInfo payloadInfo = new PayloadInfo();
		int payloadNumber = this.getIntPropertyJms(map, AS4Costanti.JMS_PAYLOADS_NUMBER, true);
		for (int i = 0; i < payloadNumber; i++) {
			int index = i+1;
			PartInfo partInfo = new PartInfo();
			
			String contentIdKey = AS4Costanti.JMS_PAYLOAD_PREFIX+index+AS4Costanti.JMS_PAYLOAD_MIME_CONTENT_ID_SUFFIX;
			partInfo.setHref("cid:"+this.getPropertyJms(map, contentIdKey, true));
			
			PartProperties partProperties = new PartProperties();
			Property property = new Property();
			property.setName(AS4Costanti.AS4_USER_MESSAGE_PAYLOAD_INFO_PROPERTIES_MIME_TYPE);
			String contentTypeKey = AS4Costanti.JMS_PAYLOAD_PREFIX+index+AS4Costanti.JMS_PAYLOAD_MIME_TYPE_SUFFIX;
			property.setBase(this.getPropertyJms(map, contentTypeKey, true));
			partProperties.addProperty(property);
			partInfo.setPartProperties(partProperties);
			
			String contentPayloadKey = AS4Costanti.JMS_PAYLOAD_PREFIX+index;
			content.put(partInfo.getHref(),map.getBytes(contentPayloadKey));
			
			payloadInfo.addPartInfo(partInfo);
		}
		userMessage.setPayloadInfo(payloadInfo);
		
		// Metto dentro properties tutte le restanti proprieta'
		// Se valorizzata viene compresa anche AS4Costanti.JMS_AGREEMENT_REF
		// escludo JMS_PROTOCOL (valorizzata come 'AS4' e JMS_MESSAGE_TYPE valorizzata come 'incomingMessage')
		
		MessageProperties messageProperties = new MessageProperties();
		
		Enumeration<?> en = map.getPropertyNames();
		while (en.hasMoreElements()) {
			Object name = (Object) en.nextElement();
			if(name instanceof String) {
				String key = (String) name;
				Object value = map.getObjectProperty(key);
				if(value!=null && value instanceof String) {
					if( !AS4Costanti.JMS_FROM_PARTY_ID.equals(key) &&
							!AS4Costanti.JMS_FROM_PARTY_TYPE.equals(key) &&
							!AS4Costanti.JMS_FROM_ROLE.equals(key) &&
							!AS4Costanti.JMS_TO_PARTY_ID.equals(key) &&
							!AS4Costanti.JMS_TO_PARTY_TYPE.equals(key) &&
							!AS4Costanti.JMS_TO_ROLE.equals(key) &&
							!AS4Costanti.JMS_SERVICE.equals(key) &&
							!AS4Costanti.JMS_SERVICE_TYPE.equals(key) &&
							!AS4Costanti.JMS_ACTION.equals(key) &&
							!AS4Costanti.JMS_CONVERSATION_ID.equals(key) &&
							!AS4Costanti.JMS_MESSAGE_ID.equals(key) &&
							!AS4Costanti.JMS_REF_TO_MESSAGE_ID.equals(key) &&
							!AS4Costanti.JMS_PAYLOADS_NUMBER.equals(key) &&
							!key.startsWith(AS4Costanti.JMS_PAYLOAD_PREFIX) &&
							!AS4Costanti.JMS_PROTOCOL.equals(key)&&
							!AS4Costanti.JMS_MESSAGE_TYPE.equals(key)) {
						Property propertyOriginalSender = new Property();
						propertyOriginalSender.setName(key);
						propertyOriginalSender.setBase((String)value);
						messageProperties.addProperty(propertyOriginalSender);
					}
				}
			}
		}
		
		userMessage.setMessageProperties(messageProperties);
		
	}
	private String getPropertyJms(MapMessage map, String property, boolean required) throws Exception {
		Object value = map.getObjectProperty(property);
		if(value==null) {
			if(required) {
				throw new Exception("Property '"+property+"' not found");
			}
			else {
				return null;
			}
		}
		if(!(value instanceof String)) {
			throw new Exception("Property '"+property+"' with wrong type (expected:String found:"+value.getClass().getName()+")");
		}
		return (String) value;
	}
	private Integer getIntPropertyJms(MapMessage map, String property, boolean required) throws Exception {
		Object value = map.getObjectProperty(property);
		if(value==null) {
			if(required) {
				throw new Exception("Property '"+property+"' not found");
			}
			else {
				return null;
			}
		}
		if(!(value instanceof Integer)) {
			throw new Exception("Property '"+property+"' with wrong type (expected:Integer found:"+value.getClass().getName()+")");
		}
		return (Integer) value;
	}
}
