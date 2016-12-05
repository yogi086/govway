package org.openspcoop2.protocol.sdk.properties;

import org.openspcoop2.protocol.sdk.ProtocolException;
import org.openspcoop2.protocol.sdk.constants.ConsoleItemType;

public class StringConsoleItem extends AbstractConsoleItem<String> {

	protected StringConsoleItem(String id, String label, ConsoleItemType type) throws ProtocolException {
		super(id, label, type);
	}

}