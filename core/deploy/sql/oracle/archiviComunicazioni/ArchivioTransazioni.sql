-- IDENTIFICATIVO MITTENTE

CREATE SEQUENCE seq_credenziale_mittente MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 NOCYCLE;

CREATE TABLE credenziale_mittente
(
	tipo VARCHAR2(20) NOT NULL,
	credenziale VARCHAR2(2900) NOT NULL,
	ora_registrazione TIMESTAMP NOT NULL,
	-- fk/pk columns
	id NUMBER NOT NULL,
	-- unique constraints
	CONSTRAINT unique_credenziale_mittente_1 UNIQUE (tipo,credenziale),
	-- fk/pk keys constraints
	CONSTRAINT pk_credenziale_mittente PRIMARY KEY (id)
);


ALTER TABLE credenziale_mittente MODIFY ora_registrazione DEFAULT CURRENT_TIMESTAMP;

CREATE TRIGGER trg_credenziale_mittente
BEFORE
insert on credenziale_mittente
for each row
begin
   IF (:new.id IS NULL) THEN
      SELECT seq_credenziale_mittente.nextval INTO :new.id
                FROM DUAL;
   END IF;
end;
/



-- TRANSAZIONI

CREATE TABLE transazioni
(
	-- Identificativo di transazione
	id VARCHAR2(36) NOT NULL,
	-- Stato della Transazione
	stato VARCHAR2(100),
	-- Ruolo della transazione
	-- sconosciuto (-1)
	-- invocazioneOneway (1)
	-- invocazioneSincrona (2)
	-- invocazioneAsincronaSimmetrica (3)
	-- rispostaAsincronaSimmetrica (4)
	-- invocazioneAsincronaAsimmetrica (5)
	-- richiestaStatoAsincronaAsimmetrica (6)
	-- integrationManager (7)
	ruolo_transazione NUMBER NOT NULL,
	-- Esito della Transazione
	esito NUMBER,
	esito_contesto VARCHAR2(20),
	-- Protocollo utilizzato per la transazione
	protocollo VARCHAR2(20) NOT NULL,
	-- Informazioni Http
	tipo_richiesta VARCHAR2(10),
	codice_risposta_ingresso VARCHAR2(10),
	codice_risposta_uscita VARCHAR2(10),
	-- Tempi di latenza
	data_accettazione_richiesta TIMESTAMP,
	data_ingresso_richiesta TIMESTAMP,
	data_uscita_richiesta TIMESTAMP,
	data_accettazione_risposta TIMESTAMP,
	data_ingresso_risposta TIMESTAMP,
	data_uscita_risposta TIMESTAMP,
	-- Dimensione messaggi gestiti
	richiesta_ingresso_bytes NUMBER,
	-- Dimensione messaggi gestiti
	richiesta_uscita_bytes NUMBER,
	-- Dimensione messaggi gestiti
	risposta_ingresso_bytes NUMBER,
	-- Dimensione messaggi gestiti
	risposta_uscita_bytes NUMBER,
	-- Dati Porta di Dominio
	pdd_codice VARCHAR2(110),
	pdd_tipo_soggetto VARCHAR2(20),
	pdd_nome_soggetto VARCHAR2(80),
	pdd_ruolo VARCHAR2(20),
	-- Eventuali FAULT
	fault_integrazione CLOB,
	formato_fault_integrazione VARCHAR2(20),
	fault_cooperazione CLOB,
	formato_fault_cooperazione VARCHAR2(20),
	-- Soggetto Fruitore
	tipo_soggetto_fruitore VARCHAR2(20),
	nome_soggetto_fruitore VARCHAR2(80),
	idporta_soggetto_fruitore VARCHAR2(110),
	indirizzo_soggetto_fruitore VARCHAR2(255),
	-- Soggetto Erogatore
	tipo_soggetto_erogatore VARCHAR2(20),
	nome_soggetto_erogatore VARCHAR2(80),
	idporta_soggetto_erogatore VARCHAR2(110),
	indirizzo_soggetto_erogatore VARCHAR2(110),
	-- Identificativi Messaggi
	id_messaggio_richiesta VARCHAR2(255),
	id_messaggio_risposta VARCHAR2(255),
	data_id_msg_richiesta TIMESTAMP,
	data_id_msg_risposta TIMESTAMP,
	-- Altre informazioni di protocollo
	profilo_collaborazione_op2 VARCHAR2(255),
	profilo_collaborazione_prot VARCHAR2(255),
	id_collaborazione VARCHAR2(255),
	uri_accordo_servizio VARCHAR2(255),
	tipo_servizio VARCHAR2(20),
	nome_servizio VARCHAR2(255),
	versione_servizio NUMBER,
	azione VARCHAR2(255),
	-- Identificativo asincrono se utilizzato come riferimento messaggio nella richiesta (2 fase asincrona)
	-- e altre informazioni utilizzate nei profili asincroni
	id_asincrono VARCHAR2(255),
	tipo_servizio_correlato VARCHAR2(20),
	nome_servizio_correlato VARCHAR2(255),
	-- Header Protocollo richiesta/risposta
	header_protocollo_richiesta CLOB,
	digest_richiesta CLOB,
	prot_ext_info_richiesta CLOB,
	header_protocollo_risposta CLOB,
	digest_risposta CLOB,
	prot_ext_info_risposta CLOB,
	-- Tracciatura e Diagnostica emessa dalla PdD
	traccia_richiesta CLOB,
	traccia_risposta CLOB,
	diagnostici CLOB,
	diagnostici_list_1 VARCHAR2(255),
	diagnostici_list_2 CLOB,
	diagnostici_list_ext CLOB,
	diagnostici_ext CLOB,
	-- informazioni di integrazione
	id_correlazione_applicativa VARCHAR2(255),
	id_correlazione_risposta VARCHAR2(255),
	servizio_applicativo_fruitore VARCHAR2(255),
	servizio_applicativo_erogatore VARCHAR2(2000),
	operazione_im VARCHAR2(255),
	location_richiesta VARCHAR2(255),
	location_risposta VARCHAR2(255),
	nome_porta VARCHAR2(2000),
	credenziali CLOB,
	location_connettore CLOB,
	url_invocazione CLOB,
	trasporto_mittente VARCHAR2(20),
	token_issuer VARCHAR2(20),
	token_client_id VARCHAR2(20),
	token_subject VARCHAR2(20),
	token_username VARCHAR2(20),
	token_mail VARCHAR2(20),
	token_info CLOB,
	tempi_elaborazione VARCHAR2(4000),
	-- filtro duplicati (0=originale,-1=duplicata,N=quanti duplicati esistono)
	duplicati_richiesta NUMBER,
	duplicati_risposta NUMBER,
	-- Cluster ID
	cluster_id VARCHAR2(100),
	-- Indirizzo IP client letto dal socket
	socket_client_address VARCHAR2(255),
	-- Indirizzo IP client letto dall'header di trasporto
	transport_client_address VARCHAR2(255),
	-- Indirizzo IP client
	client_address VARCHAR2(20),
	-- Eventi emessi durante la gestione della transazione
	eventi_gestione VARCHAR2(20),
	-- Tipologia di API
	tipo_api NUMBER,
	-- Gruppi a cui appartiene l'api invocata
	gruppi VARCHAR2(20),
	-- fk/pk columns
	-- check constraints
	CONSTRAINT chk_transazioni_1 CHECK (pdd_ruolo IN ('delegata','applicativa','router','integrationManager')),
	-- fk/pk keys constraints
	CONSTRAINT pk_transazioni PRIMARY KEY (id)
);

-- index
CREATE INDEX INDEX_TR_ENTRY ON transazioni (data_ingresso_richiesta DESC,esito,esito_contesto,pdd_ruolo,pdd_codice,tipo_soggetto_erogatore,nome_soggetto_erogatore,tipo_servizio,nome_servizio);
-- CREATE INDEX INDEX_TR_MEDIUM ON transazioni (data_ingresso_richiesta DESC,esito,esito_contesto,pdd_ruolo,pdd_codice,tipo_soggetto_erogatore,nome_soggetto_erogatore,tipo_servizio,nome_servizio,azione,tipo_soggetto_fruitore,nome_soggetto_fruitore,servizio_applicativo_fruitore,trasporto_mittente,token_issuer,token_client_id,token_subject,token_username,token_mail,stato,client_address,gruppi);
-- CREATE INDEX INDEX_TR_FULL ON transazioni (data_ingresso_richiesta DESC,esito,esito_contesto,pdd_ruolo,pdd_codice,tipo_soggetto_erogatore,nome_soggetto_erogatore,tipo_servizio,nome_servizio,azione,tipo_soggetto_fruitore,nome_soggetto_fruitore,servizio_applicativo_fruitore,trasporto_mittente,token_issuer,token_client_id,token_subject,token_username,token_mail,id_correlazione_applicativa,id_correlazione_risposta,stato,protocollo,client_address,gruppi,eventi_gestione,cluster_id);
-- CREATE INDEX INDEX_TR_SEARCH ON transazioni (data_ingresso_richiesta DESC,esito,esito_contesto,pdd_ruolo,pdd_codice,tipo_soggetto_erogatore,nome_soggetto_erogatore,tipo_servizio,nome_servizio,azione,tipo_soggetto_fruitore,nome_soggetto_fruitore,servizio_applicativo_fruitore,trasporto_mittente,token_issuer,token_client_id,token_subject,token_username,token_mail,id_correlazione_applicativa,id_correlazione_risposta,stato,protocollo,client_address,gruppi,eventi_gestione,cluster_id,id,data_uscita_richiesta,data_ingresso_risposta,data_uscita_risposta);
-- CREATE INDEX INDEX_TR_STATS ON transazioni (data_ingresso_richiesta,pdd_ruolo,pdd_codice,tipo_soggetto_fruitore,nome_soggetto_fruitore,tipo_soggetto_erogatore,nome_soggetto_erogatore,tipo_servizio,nome_servizio,azione,servizio_applicativo_fruitore,trasporto_mittente,token_issuer,token_client_id,token_subject,token_username,token_mail,esito,esito_contesto,stato,client_address,gruppi,data_uscita_richiesta,data_ingresso_risposta,data_uscita_risposta,richiesta_ingresso_bytes,richiesta_uscita_bytes,risposta_ingresso_bytes,risposta_uscita_bytes);
CREATE INDEX INDEX_TR_FILTROD_REQ ON transazioni (id_messaggio_richiesta,pdd_ruolo);
CREATE INDEX INDEX_TR_FILTROD_RES ON transazioni (id_messaggio_risposta,pdd_ruolo);
CREATE INDEX INDEX_TR_FILTROD_REQ_2 ON transazioni (data_id_msg_richiesta,id_messaggio_richiesta);
CREATE INDEX INDEX_TR_FILTROD_RES_2 ON transazioni (data_id_msg_risposta,id_messaggio_risposta);
CREATE INDEX INDEX_TR_COLLABORAZIONE ON transazioni (id_collaborazione);
CREATE INDEX INDEX_TR_RIF_RICHIESTA ON transazioni (id_asincrono);

ALTER TABLE transazioni MODIFY duplicati_richiesta DEFAULT 0;
ALTER TABLE transazioni MODIFY duplicati_risposta DEFAULT 0;


CREATE SEQUENCE seq_transazioni_sa MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 CYCLE;

CREATE TABLE transazioni_sa
(
	id_transazione VARCHAR2(255) NOT NULL,
	servizio_applicativo_erogatore VARCHAR2(2000) NOT NULL,
	data_registrazione TIMESTAMP NOT NULL,
	-- Esito della Transazione
	consegna_successo NUMBER,
	dettaglio_esito NUMBER,
	-- Consegna via Integration Manager
	consegna_im NUMBER,
	-- Identificativo del messaggio
	identificativo_messaggio VARCHAR2(255),
	-- Date
	data_accettazione_richiesta TIMESTAMP,
	data_uscita_richiesta TIMESTAMP,
	data_accettazione_risposta TIMESTAMP,
	data_ingresso_risposta TIMESTAMP,
	-- Dimensione messaggi gestiti
	richiesta_uscita_bytes NUMBER,
	risposta_ingresso_bytes NUMBER,
	location_connettore CLOB,
	codice_risposta VARCHAR2(10),
	-- Eventuale FAULT
	fault CLOB,
	formato_fault VARCHAR2(20),
	-- Tentativi di Consegna
	data_primo_tentativo TIMESTAMP,
	numero_tentativi NUMBER,
	-- Cluster ID
	cluster_id VARCHAR2(100),
	-- Informazioni relative all'ultimo tentativo di consegna fallito
	data_ultimo_errore TIMESTAMP,
	dettaglio_esito_ultimo_errore NUMBER,
	codice_risposta_ultimo_errore VARCHAR2(10),
	ultimo_errore CLOB,
	location_ultimo_errore CLOB,
	cluster_id_ultimo_errore VARCHAR2(100),
	fault_ultimo_errore CLOB,
	formato_fault_ultimo_errore VARCHAR2(20),
	-- Date relative alla gestione via IntegrationManager
	data_primo_prelievo_im TIMESTAMP,
	data_prelievo_im TIMESTAMP,
	numero_prelievi_im NUMBER,
	data_eliminazione_im TIMESTAMP,
	-- fk/pk columns
	id NUMBER NOT NULL,
	-- fk/pk keys constraints
	CONSTRAINT pk_transazioni_sa PRIMARY KEY (id)
);

-- index
CREATE INDEX index_transazioni_sa_1 ON transazioni_sa (id_transazione);

ALTER TABLE transazioni_sa MODIFY consegna_successo DEFAULT 0;
ALTER TABLE transazioni_sa MODIFY consegna_im DEFAULT 0;
ALTER TABLE transazioni_sa MODIFY numero_tentativi DEFAULT 0;
ALTER TABLE transazioni_sa MODIFY numero_prelievi_im DEFAULT 0;

CREATE TRIGGER trg_transazioni_sa
BEFORE
insert on transazioni_sa
for each row
begin
   IF (:new.id IS NULL) THEN
      SELECT seq_transazioni_sa.nextval INTO :new.id
                FROM DUAL;
   END IF;
end;
/



CREATE TABLE transazioni_info
(
	tipo VARCHAR2(255) NOT NULL,
	data TIMESTAMP NOT NULL,
	-- fk/pk columns
	-- unique constraints
	CONSTRAINT unique_transazioni_info_1 UNIQUE (tipo)
);


CREATE SEQUENCE seq_transazioni_export MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 CYCLE;

CREATE TABLE transazioni_export
(
	-- Intervallo utilizzato dall'esportazione
	intervallo_inizio TIMESTAMP NOT NULL,
	intervallo_fine TIMESTAMP NOT NULL,
	-- Eventuale nome del file/dir dello zip esportato
	nome VARCHAR2(255),
	-- Stato procedura Esportazione
	export_state VARCHAR2(255) NOT NULL,
	export_error CLOB,
	export_time_start TIMESTAMP NOT NULL,
	export_time_end TIMESTAMP,
	-- Stato procedura Eliminazione
	delete_state VARCHAR2(255) NOT NULL,
	delete_error CLOB,
	delete_time_start TIMESTAMP,
	delete_time_end TIMESTAMP,
	-- fk/pk columns
	id NUMBER NOT NULL,
	-- check constraints
	CONSTRAINT chk_transazioni_export_1 CHECK (export_state IN ('executing','completed','error')),
	CONSTRAINT chk_transazioni_export_2 CHECK (delete_state IN ('undefined','executing','completed','error')),
	-- unique constraints
	CONSTRAINT unique_transazioni_export_1 UNIQUE (intervallo_inizio,intervallo_fine),
	-- fk/pk keys constraints
	CONSTRAINT pk_transazioni_export PRIMARY KEY (id)
);

CREATE TRIGGER trg_transazioni_export
BEFORE
insert on transazioni_export
for each row
begin
   IF (:new.id IS NULL) THEN
      SELECT seq_transazioni_export.nextval INTO :new.id
                FROM DUAL;
   END IF;
end;
/



-- DUMP - DATI

CREATE SEQUENCE seq_dump_messaggi MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 CYCLE;

CREATE TABLE dump_messaggi
(
	id_transazione VARCHAR2(255) NOT NULL,
	protocollo VARCHAR2(20) NOT NULL,
	servizio_applicativo_erogatore VARCHAR2(2000),
	tipo_messaggio VARCHAR2(255) NOT NULL,
	formato_messaggio VARCHAR2(20),
	content_type VARCHAR2(255),
	multipart_content_type VARCHAR2(255),
	multipart_content_id VARCHAR2(255),
	multipart_content_location VARCHAR2(255),
	body BLOB,
	dump_timestamp TIMESTAMP NOT NULL,
	post_process_header CLOB,
	post_process_filename VARCHAR2(255),
	post_process_content BLOB,
	post_process_config_id VARCHAR2(2000),
	post_process_timestamp TIMESTAMP,
	post_processed NUMBER,
	-- fk/pk columns
	id NUMBER NOT NULL,
	-- check constraints
	CONSTRAINT chk_dump_messaggi_1 CHECK (tipo_messaggio IN ('RichiestaIngresso','RichiestaUscita','RispostaIngresso','RispostaUscita','RichiestaIngressoDumpBinario','RichiestaUscitaDumpBinario','RispostaIngressoDumpBinario','RispostaUscitaDumpBinario','IntegrationManager')),
	-- fk/pk keys constraints
	CONSTRAINT pk_dump_messaggi PRIMARY KEY (id)
);

-- index
CREATE INDEX index_dump_messaggi_1 ON dump_messaggi (id_transazione);
CREATE INDEX index_dump_messaggi_2 ON dump_messaggi (post_processed,post_process_timestamp);
CREATE INDEX index_dump_messaggi_3 ON dump_messaggi (post_process_config_id);

ALTER TABLE dump_messaggi MODIFY post_processed DEFAULT 1;

CREATE TRIGGER trg_dump_messaggi
BEFORE
insert on dump_messaggi
for each row
begin
   IF (:new.id IS NULL) THEN
      SELECT seq_dump_messaggi.nextval INTO :new.id
                FROM DUAL;
   END IF;
end;
/



CREATE SEQUENCE seq_dump_multipart_header MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 CYCLE;

CREATE TABLE dump_multipart_header
(
	nome VARCHAR2(255) NOT NULL,
	valore CLOB,
	dump_timestamp TIMESTAMP NOT NULL,
	-- fk/pk columns
	id NUMBER NOT NULL,
	id_messaggio NUMBER NOT NULL,
	-- unique constraints
	CONSTRAINT unique_dump_multipart_header_1 UNIQUE (id,nome),
	-- fk/pk keys constraints
	CONSTRAINT fk_dump_multipart_header_1 FOREIGN KEY (id_messaggio) REFERENCES dump_messaggi(id),
	CONSTRAINT pk_dump_multipart_header PRIMARY KEY (id)
);

-- index
CREATE INDEX index_dump_multipart_header_1 ON dump_multipart_header (id_messaggio);
CREATE TRIGGER trg_dump_multipart_header
BEFORE
insert on dump_multipart_header
for each row
begin
   IF (:new.id IS NULL) THEN
      SELECT seq_dump_multipart_header.nextval INTO :new.id
                FROM DUAL;
   END IF;
end;
/



CREATE SEQUENCE seq_dump_header_trasporto MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 CYCLE;

CREATE TABLE dump_header_trasporto
(
	nome VARCHAR2(255) NOT NULL,
	valore CLOB,
	dump_timestamp TIMESTAMP NOT NULL,
	-- fk/pk columns
	id NUMBER NOT NULL,
	id_messaggio NUMBER NOT NULL,
	-- unique constraints
	CONSTRAINT unique_dump_header_trasporto_1 UNIQUE (id,nome),
	-- fk/pk keys constraints
	CONSTRAINT fk_dump_header_trasporto_1 FOREIGN KEY (id_messaggio) REFERENCES dump_messaggi(id),
	CONSTRAINT pk_dump_header_trasporto PRIMARY KEY (id)
);

-- index
CREATE INDEX index_dump_header_trasporto_1 ON dump_header_trasporto (id_messaggio);
CREATE TRIGGER trg_dump_header_trasporto
BEFORE
insert on dump_header_trasporto
for each row
begin
   IF (:new.id IS NULL) THEN
      SELECT seq_dump_header_trasporto.nextval INTO :new.id
                FROM DUAL;
   END IF;
end;
/



CREATE SEQUENCE seq_dump_allegati MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 CYCLE;

CREATE TABLE dump_allegati
(
	content_type VARCHAR2(255),
	content_id VARCHAR2(255),
	content_location VARCHAR2(255),
	allegato BLOB,
	dump_timestamp TIMESTAMP NOT NULL,
	-- fk/pk columns
	id NUMBER NOT NULL,
	id_messaggio NUMBER NOT NULL,
	-- fk/pk keys constraints
	CONSTRAINT fk_dump_allegati_1 FOREIGN KEY (id_messaggio) REFERENCES dump_messaggi(id),
	CONSTRAINT pk_dump_allegati PRIMARY KEY (id)
);

-- index
CREATE INDEX index_dump_allegati_1 ON dump_allegati (id_messaggio);
CREATE TRIGGER trg_dump_allegati
BEFORE
insert on dump_allegati
for each row
begin
   IF (:new.id IS NULL) THEN
      SELECT seq_dump_allegati.nextval INTO :new.id
                FROM DUAL;
   END IF;
end;
/



CREATE SEQUENCE seq_dump_header_allegato MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 CYCLE;

CREATE TABLE dump_header_allegato
(
	nome VARCHAR2(255) NOT NULL,
	valore CLOB,
	dump_timestamp TIMESTAMP NOT NULL,
	-- fk/pk columns
	id NUMBER NOT NULL,
	id_allegato NUMBER NOT NULL,
	-- unique constraints
	CONSTRAINT unique_dump_header_allegato_1 UNIQUE (id,nome),
	-- fk/pk keys constraints
	CONSTRAINT fk_dump_header_allegato_1 FOREIGN KEY (id_allegato) REFERENCES dump_allegati(id),
	CONSTRAINT pk_dump_header_allegato PRIMARY KEY (id)
);

-- index
CREATE INDEX index_dump_header_allegato_1 ON dump_header_allegato (id_allegato);
CREATE TRIGGER trg_dump_header_allegato
BEFORE
insert on dump_header_allegato
for each row
begin
   IF (:new.id IS NULL) THEN
      SELECT seq_dump_header_allegato.nextval INTO :new.id
                FROM DUAL;
   END IF;
end;
/



CREATE SEQUENCE seq_dump_contenuti MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 CYCLE;

CREATE TABLE dump_contenuti
(
	nome VARCHAR2(255) NOT NULL,
	valore VARCHAR2(4000) NOT NULL,
	valore_as_bytes BLOB,
	dump_timestamp TIMESTAMP NOT NULL,
	-- fk/pk columns
	id NUMBER NOT NULL,
	id_messaggio NUMBER NOT NULL,
	-- unique constraints
	CONSTRAINT unique_dump_contenuti_1 UNIQUE (id,nome),
	-- fk/pk keys constraints
	CONSTRAINT fk_dump_contenuti_1 FOREIGN KEY (id_messaggio) REFERENCES dump_messaggi(id),
	CONSTRAINT pk_dump_contenuti PRIMARY KEY (id)
);

-- index
CREATE INDEX index_dump_contenuti_1 ON dump_contenuti (id_messaggio);
CREATE TRIGGER trg_dump_contenuti
BEFORE
insert on dump_contenuti
for each row
begin
   IF (:new.id IS NULL) THEN
      SELECT seq_dump_contenuti.nextval INTO :new.id
                FROM DUAL;
   END IF;
end;
/


