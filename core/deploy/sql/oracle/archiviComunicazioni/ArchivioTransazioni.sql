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
	fault_cooperazione CLOB,
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
	servizio_applicativo_erogatore VARCHAR2(255),
	operazione_im VARCHAR2(255),
	location_richiesta VARCHAR2(255),
	location_risposta VARCHAR2(255),
	nome_porta VARCHAR2(4000),
	credenziali VARCHAR2(255),
	location_connettore CLOB,
	url_invocazione CLOB,
	-- filtro duplicati (0=originale,-1=duplicata,N=quanti duplicati esistono)
	duplicati_richiesta NUMBER,
	duplicati_risposta NUMBER,
	-- Cluster ID
	cluster_id VARCHAR2(100),
	-- Indirizzo IP client letto dal socket
	socket_client_address VARCHAR2(255),
	-- Indirizzo IP client letto dall'header di trasporto
	transport_client_address VARCHAR2(255),
	-- Eventi emessi durante la gestione della transazione
	eventi_gestione VARCHAR2(1000),
	-- fk/pk columns
	-- check constraints
	CONSTRAINT chk_transazioni_1 CHECK (pdd_ruolo IN ('delegata','applicativa','router','integrationManager')),
	-- fk/pk keys constraints
	CONSTRAINT pk_transazioni PRIMARY KEY (id)
);

-- index
CREATE INDEX INDEX_TR_ENTRY ON transazioni (data_ingresso_richiesta DESC,esito,esito_contesto,pdd_ruolo,pdd_codice,tipo_soggetto_erogatore,nome_soggetto_erogatore,tipo_servizio,nome_servizio);
CREATE INDEX INDEX_TR_MEDIUM ON transazioni (data_ingresso_richiesta DESC,esito,esito_contesto,pdd_ruolo,pdd_codice,tipo_soggetto_erogatore,nome_soggetto_erogatore,tipo_servizio,nome_servizio,azione,tipo_soggetto_fruitore,nome_soggetto_fruitore,servizio_applicativo_fruitore,servizio_applicativo_erogatore,stato);
CREATE INDEX INDEX_TR_FULL ON transazioni (data_ingresso_richiesta DESC,esito,esito_contesto,pdd_ruolo,pdd_codice,tipo_soggetto_erogatore,nome_soggetto_erogatore,tipo_servizio,nome_servizio,azione,tipo_soggetto_fruitore,nome_soggetto_fruitore,servizio_applicativo_fruitore,servizio_applicativo_erogatore,id_correlazione_applicativa,id_correlazione_risposta,stato,protocollo,eventi_gestione,cluster_id);
CREATE INDEX INDEX_TR_SEARCH ON transazioni (data_ingresso_richiesta DESC,esito,esito_contesto,pdd_ruolo,pdd_codice,tipo_soggetto_erogatore,nome_soggetto_erogatore,tipo_servizio,nome_servizio,azione,tipo_soggetto_fruitore,nome_soggetto_fruitore,servizio_applicativo_fruitore,servizio_applicativo_erogatore,id_correlazione_applicativa,id_correlazione_risposta,stato,protocollo,eventi_gestione,cluster_id,id,data_uscita_richiesta,data_ingresso_risposta,data_uscita_risposta);
CREATE INDEX INDEX_TR_STATS ON transazioni (data_ingresso_richiesta,pdd_ruolo,pdd_codice,tipo_soggetto_fruitore,nome_soggetto_fruitore,tipo_soggetto_erogatore,nome_soggetto_erogatore,tipo_servizio,nome_servizio,azione,servizio_applicativo_fruitore,servizio_applicativo_erogatore,esito,esito_contesto,stato,data_uscita_richiesta,data_ingresso_risposta,data_uscita_risposta,richiesta_ingresso_bytes,richiesta_uscita_bytes,risposta_ingresso_bytes,risposta_uscita_bytes);
CREATE INDEX INDEX_TR_FILTROD_REQ ON transazioni (id_messaggio_richiesta,pdd_ruolo);
CREATE INDEX INDEX_TR_FILTROD_RES ON transazioni (id_messaggio_risposta,pdd_ruolo);
CREATE INDEX INDEX_TR_FILTROD_REQ_2 ON transazioni (data_id_msg_richiesta,id_messaggio_richiesta);
CREATE INDEX INDEX_TR_FILTROD_RES_2 ON transazioni (data_id_msg_risposta,id_messaggio_risposta);

ALTER TABLE transazioni MODIFY duplicati_richiesta DEFAULT 0;
ALTER TABLE transazioni MODIFY duplicati_risposta DEFAULT 0;


-- DUMP - DATI

CREATE SEQUENCE seq_dump_messaggi MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 CYCLE;

CREATE TABLE dump_messaggi
(
	id_transazione VARCHAR2(255) NOT NULL,
	tipo_messaggio VARCHAR2(255) NOT NULL,
	body BLOB,
	dump_timestamp TIMESTAMP NOT NULL,
	post_process_content_type VARCHAR2(255),
	post_process_header CLOB,
	post_process_filename VARCHAR2(255),
	post_process_content BLOB,
	post_process_config_id VARCHAR2(4000),
	post_process_timestamp TIMESTAMP,
	post_processed NUMBER,
	-- fk/pk columns
	id NUMBER NOT NULL,
	-- check constraints
	CONSTRAINT chk_dump_messaggi_1 CHECK (tipo_messaggio IN ('RichiestaIngresso','RichiestaUscita','RispostaIngresso','RispostaUscita')),
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



CREATE SEQUENCE seq_dump_allegati MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 CYCLE;

CREATE TABLE dump_allegati
(
	id_allegato VARCHAR2(255),
	location VARCHAR2(255),
	mimetype VARCHAR2(255),
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

