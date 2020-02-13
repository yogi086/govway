ALTER TABLE msgdiagnostici ADD COLUMN applicativo VARCHAR(2000);

ALTER TABLE MSG_SERVIZI_APPLICATIVI ALTER COLUMN SERVIZIO_APPLICATIVO VARCHAR(2000);

ALTER TABLE transazioni ALTER COLUMN servizio_applicativo_erogatore VARCHAR(2000);
ALTER TABLE transazioni ADD COLUMN esito_sincrono INT;
ALTER TABLE transazioni ADD COLUMN consegne_multiple INT;

ALTER TABLE dump_messaggi ADD COLUMN servizio_applicativo_erogatore VARCHAR(2000);
ALTER TABLE dump_messaggi ADD COLUMN data_consegna_erogatore TIMESTAMP;


CREATE SEQUENCE seq_transazioni_sa AS BIGINT START WITH 1 INCREMENT BY 1 ; -- (Scommentare in hsql 2.x) CYCLE;

CREATE TABLE transazioni_sa
(
	id_transazione VARCHAR(255) NOT NULL,
	servizio_applicativo_erogatore VARCHAR(2000) NOT NULL,
	connettore_nome VARCHAR(255),
	data_registrazione TIMESTAMP NOT NULL,
	-- Esito della Consegna
	consegna_terminata BOOLEAN,
	data_messaggio_scaduto TIMESTAMP,
	dettaglio_esito INT,
	-- Consegna ad un Backend Applicativo
	consegna_trasparente BOOLEAN,
	-- Consegna via Integration Manager
	consegna_im BOOLEAN,
	-- Identificativo del messaggio
	identificativo_messaggio VARCHAR(255),
	-- Date
	data_accettazione_richiesta TIMESTAMP,
	data_uscita_richiesta TIMESTAMP,
	data_accettazione_risposta TIMESTAMP,
	data_ingresso_risposta TIMESTAMP,
	-- Dimensione messaggi gestiti
	richiesta_uscita_bytes BIGINT,
	risposta_ingresso_bytes BIGINT,
	location_connettore VARCHAR(65535),
	codice_risposta VARCHAR(10),
	-- Eventuale FAULT
	fault LONGVARCHAR,
	formato_fault VARCHAR(20),
	-- Tentativi di Consegna
	data_primo_tentativo TIMESTAMP,
	numero_tentativi INT,
	-- Cluster ID
	cluster_id_in_coda VARCHAR(100),
	cluster_id_consegna VARCHAR(100),
	-- Informazioni relative all'ultimo tentativo di consegna fallito
	data_ultimo_errore TIMESTAMP,
	dettaglio_esito_ultimo_errore INT,
	codice_risposta_ultimo_errore VARCHAR(10),
	ultimo_errore LONGVARCHAR,
	location_ultimo_errore VARCHAR(65535),
	cluster_id_ultimo_errore VARCHAR(100),
	fault_ultimo_errore LONGVARCHAR,
	formato_fault_ultimo_errore VARCHAR(20),
	-- Date relative alla gestione via IntegrationManager
	data_primo_prelievo_im TIMESTAMP,
	data_prelievo_im TIMESTAMP,
	numero_prelievi_im INT,
	data_eliminazione_im TIMESTAMP,
	cluster_id_prelievo_im VARCHAR(100),
	cluster_id_eliminazione_im VARCHAR(100),
	-- fk/pk columns
	id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
	-- fk/pk keys constraints
	CONSTRAINT pk_transazioni_sa PRIMARY KEY (id)
);

-- index
CREATE INDEX index_transazioni_sa_1 ON transazioni_sa (id_transazione);

ALTER TABLE transazioni_sa ALTER COLUMN consegna_terminata SET DEFAULT false;
ALTER TABLE transazioni_sa ALTER COLUMN consegna_trasparente SET DEFAULT false;
ALTER TABLE transazioni_sa ALTER COLUMN consegna_im SET DEFAULT false;
ALTER TABLE transazioni_sa ALTER COLUMN numero_tentativi SET DEFAULT 0;
ALTER TABLE transazioni_sa ALTER COLUMN numero_prelievi_im SET DEFAULT 0;

CREATE TABLE transazioni_sa_init_seq (id BIGINT);
INSERT INTO transazioni_sa_init_seq VALUES (NEXT VALUE FOR seq_transazioni_sa);
