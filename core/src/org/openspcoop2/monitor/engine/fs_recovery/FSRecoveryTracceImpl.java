package org.openspcoop2.monitor.engine.fs_recovery;

import java.io.File;
import java.sql.Connection;

import org.slf4j.Logger;
import org.openspcoop2.core.tracciamento.Traccia;
import org.openspcoop2.core.tracciamento.utils.serializer.JaxbDeserializer;
import org.openspcoop2.protocol.sdk.tracciamento.ITracciaProducer;

/**
 * FSRecoveryTracceImpl
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class FSRecoveryTracceImpl extends AbstractFSRecovery {
	private ITracciaProducer tracciamentoAppender;

	public FSRecoveryTracceImpl( 
			Logger log,
			boolean debug,
			ITracciaProducer tracciamentoAppender,
			File directory, File directoryDLQ,
			int tentativi,
			int minutiAttesaProcessingFile) {
		super(log, debug, directory, directoryDLQ, tentativi, minutiAttesaProcessingFile);
		this.tracciamentoAppender = tracciamentoAppender;
	}

	@Override
	public void process(Connection connection) {
		this.log.info("Recovery Tracce ...");
		super.process(connection);
		this.log.info("Recovery Tracce completato");
	}

	@Override
	public void insertObject(File file, Connection connection) throws Exception {
		JaxbDeserializer deserializer = new JaxbDeserializer();
		Traccia traccia = deserializer.readTraccia(file);
		org.openspcoop2.protocol.sdk.tracciamento.Traccia tracciaOp2 = new org.openspcoop2.protocol.sdk.tracciamento.Traccia(traccia);
		this.tracciamentoAppender.log(connection, tracciaOp2);
	}


}