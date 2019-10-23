ALTER TABLE msgdiagnostici ADD COLUMN applicativo VARCHAR(2000);

ALTER TABLE MSG_SERVIZI_APPLICATIVI ALTER COLUMN SERVIZIO_APPLICATIVO TYPE VARCHAR(2000);

ALTER TABLE transazioni ALTER COLUMN servizio_applicativo_erogatore TYPE VARCHAR(2000);

ALTER TABLE dump_messaggi ADD COLUMN servizio_applicativo_erogatore VARCHAR(2000);

CREATE SEQUENCE seq_transazioni_sa start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 CYCLE;

CREATE TABLE transazioni_sa
(
	id_transazione VARCHAR(255) NOT NULL,
	servizio_applicativo_erogatore VARCHAR(2000) NOT NULL,
	data_registrazione TIMESTAMP NOT NULL,
	-- Esito della Transazione
	consegna_successo BOOLEAN DEFAULT false,
	dettaglio_esito INT,
	-- Consegna via Integration Manager
	consegna_im BOOLEAN DEFAULT false,
	identificativo_messaggio VARCHAR(255),
	data_accettazione_richiesta TIMESTAMP,
	data_uscita_richiesta TIMESTAMP,
	data_accettazione_risposta TIMESTAMP,
	data_ingresso_risposta TIMESTAMP,
	-- Dimensione messaggi gestiti
	richiesta_uscita_bytes BIGINT,
	-- Dimensione messaggi gestiti
	risposta_ingresso_bytes BIGINT,
	location_connettore TEXT,
	codice_risposta VARCHAR(10),
	-- Eventuali FAULT
	fault TEXT,
	formato_fault VARCHAR(20),
	data_primo_tentativo TIMESTAMP,
	numero_tentativi INT DEFAULT 0,
	-- Cluster ID
	cluster_id VARCHAR(100),
	-- Informazioni relative all'ultimo tentativo di consegna fallito
	data_ultimo_errore TIMESTAMP,
	dettaglio_esito_ultimo_errore INT,
	codice_risposta_ultimo_errore VARCHAR(10),
	ultimo_errore TEXT,
	location_ultimo_errore TEXT,
	cluster_id_ultimo_errore VARCHAR(100),
	-- Eventuali FAULT
	fault_ultimo_errore TEXT,
	formato_fault_ultimo_errore VARCHAR(20),
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_transazioni_sa') NOT NULL,
	-- fk/pk keys constraints
	CONSTRAINT pk_transazioni_sa PRIMARY KEY (id)
);

-- index
CREATE INDEX index_transazioni_sa_1 ON transazioni_sa (id_transazione);
