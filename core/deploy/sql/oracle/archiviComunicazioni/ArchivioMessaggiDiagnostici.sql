CREATE SEQUENCE seq_msgdiagnostici MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 CYCLE;

CREATE TABLE msgdiagnostici
(
	gdo TIMESTAMP NOT NULL,
	pdd_codice VARCHAR2(255) NOT NULL,
	pdd_tipo_soggetto VARCHAR2(255) NOT NULL,
	pdd_nome_soggetto VARCHAR2(255) NOT NULL,
	idfunzione VARCHAR2(255) NOT NULL,
	severita NUMBER NOT NULL,
	messaggio CLOB NOT NULL,
	-- Eventuale id della richiesta in gestione (informazione non definita dalla specifica)
	idmessaggio VARCHAR2(255),
	-- Eventuale id della risposta correlata alla richiesta (informazione non definita dalla specifica)
	idmessaggio_risposta VARCHAR2(255),
	-- Codice del diagnostico emesso
	codice VARCHAR2(255) NOT NULL,
	-- Protocollo (puo' non essere presente per i diagnostici di 'servizio' della porta)
	protocollo VARCHAR2(255),
	-- fk/pk columns
	id NUMBER NOT NULL,
	-- check constraints
	CONSTRAINT chk_msgdiagnostici_1 CHECK (severita IN (0,1,2,3,4,5,6,7)),
	-- fk/pk keys constraints
	CONSTRAINT pk_msgdiagnostici PRIMARY KEY (id)
);

-- index
CREATE INDEX MSG_DIAG_ID ON msgdiagnostici (idmessaggio);
CREATE INDEX MSG_DIAG_GDO ON msgdiagnostici (gdo DESC);
CREATE TRIGGER trg_msgdiagnostici
BEFORE
insert on msgdiagnostici
for each row
begin
   IF (:new.id IS NULL) THEN
      SELECT seq_msgdiagnostici.nextval INTO :new.id
                FROM DUAL;
   END IF;
end;
/



CREATE SEQUENCE seq_msgdiag_correlazione MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 CYCLE;

CREATE TABLE msgdiag_correlazione
(
	-- Dati di Correlazione con i messaggi diagnostici
	idmessaggio VARCHAR2(255) NOT NULL,
	pdd_codice VARCHAR2(255) NOT NULL,
	pdd_tipo_soggetto VARCHAR2(255) NOT NULL,
	pdd_nome_soggetto VARCHAR2(255) NOT NULL,
	-- Data di registrazione
	gdo TIMESTAMP NOT NULL,
	-- nome porta delegata/applicativa
	porta VARCHAR2(255),
	-- (1/0 true/false) True se siamo in un contesto di porta delegata, False se in un contesto di porta applicativa
	delegata NUMBER NOT NULL,
	tipo_fruitore VARCHAR2(255),
	fruitore VARCHAR2(255),
	tipo_erogatore VARCHAR2(255) NOT NULL,
	erogatore VARCHAR2(255) NOT NULL,
	tipo_servizio VARCHAR2(255) NOT NULL,
	servizio VARCHAR2(255) NOT NULL,
	versione_servizio NUMBER NOT NULL,
	azione VARCHAR2(255),
	-- Identificatore correlazione applicativa
	id_correlazione_applicativa VARCHAR2(255),
	id_correlazione_risposta VARCHAR2(255),
	-- Protocollo
	protocollo VARCHAR2(255) NOT NULL,
	-- fk/pk columns
	id NUMBER NOT NULL,
	-- fk/pk keys constraints
	CONSTRAINT pk_msgdiag_correlazione PRIMARY KEY (id)
);

-- index
CREATE INDEX MSG_CORR_INDEX ON msgdiag_correlazione (idmessaggio,delegata);
CREATE INDEX MSG_CORR_GDO ON msgdiag_correlazione (gdo DESC);
CREATE INDEX MSG_CORR_APP ON msgdiag_correlazione (id_correlazione_applicativa,delegata);
CREATE INDEX MSG_CORR_APP_RISP ON msgdiag_correlazione (id_correlazione_risposta,delegata);
CREATE TRIGGER trg_msgdiag_correlazione
BEFORE
insert on msgdiag_correlazione
for each row
begin
   IF (:new.id IS NULL) THEN
      SELECT seq_msgdiag_correlazione.nextval INTO :new.id
                FROM DUAL;
   END IF;
end;
/



CREATE TABLE msgdiag_correlazione_sa
(
	id_correlazione NUMBER NOT NULL,
	-- Identita ServizioApplicativo
	servizio_applicativo VARCHAR2(255) NOT NULL,
	-- fk/pk columns
	-- fk/pk keys constraints
	CONSTRAINT fk_msgdiag_correlazione_sa_1 FOREIGN KEY (id_correlazione) REFERENCES msgdiag_correlazione(id) ON DELETE CASCADE,
	CONSTRAINT pk_msgdiag_correlazione_sa PRIMARY KEY (id_correlazione,servizio_applicativo)
);

