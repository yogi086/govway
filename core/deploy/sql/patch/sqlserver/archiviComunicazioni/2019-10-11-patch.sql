ALTER TABLE msgdiagnostici ADD applicativo VARCHAR(2000);

ALTER TABLE MSG_SERVIZI_APPLICATIVI ALTER COLUMN SERVIZIO_APPLICATIVO VARCHAR(2000);

ALTER TABLE transazioni ALTER COLUMN servizio_applicativo_erogatore VARCHAR(2000);

ALTER TABLE dump_messaggi ADD servizio_applicativo_erogatore VARCHAR(2000);


CREATE TABLE transazioni_sa
(
	id_transazione VARCHAR(255) NOT NULL,
	servizio_applicativo_erogatore VARCHAR(2000) NOT NULL,
	data_registrazione DATETIME2 NOT NULL,
	-- Esito della Transazione
	consegna_successo BIT DEFAULT 'false',
	dettaglio_esito INT,
	-- Consegna via Integration Manager
	consegna_im BIT DEFAULT 'false',
	identificativo_messaggio VARCHAR(255),
	data_accettazione_richiesta DATETIME2,
	data_uscita_richiesta DATETIME2,
	data_accettazione_risposta DATETIME2,
	data_ingresso_risposta DATETIME2,
	-- Dimensione messaggi gestiti
	richiesta_uscita_bytes BIGINT,
	-- Dimensione messaggi gestiti
	risposta_ingresso_bytes BIGINT,
	location_connettore VARCHAR(max),
	codice_risposta VARCHAR(10),
	-- Eventuali FAULT
	fault VARCHAR(max),
	formato_fault VARCHAR(20),
	data_primo_tentativo DATETIME2,
	numero_tentativi INT DEFAULT 0,
	-- Cluster ID
	cluster_id VARCHAR(100),
	-- Informazioni relative all'ultimo tentativo di consegna fallito
	data_ultimo_errore DATETIME2,
	dettaglio_esito_ultimo_errore INT,
	codice_risposta_ultimo_errore VARCHAR(10),
	ultimo_errore VARCHAR(max),
	location_ultimo_errore VARCHAR(max),
	cluster_id_ultimo_errore VARCHAR(100),
	-- Eventuali FAULT
	fault_ultimo_errore VARCHAR(max),
	formato_fault_ultimo_errore VARCHAR(20),
	-- fk/pk columns
	id BIGINT IDENTITY,
	-- fk/pk keys constraints
	CONSTRAINT pk_transazioni_sa PRIMARY KEY (id)
);

-- index
CREATE INDEX index_transazioni_sa_1 ON transazioni_sa (id_transazione);


