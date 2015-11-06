-- **** Serial for ID ****

CREATE TABLE ID_MESSAGGIO
(
	COUNTER BIGINT NOT NULL,
	PROTOCOLLO VARCHAR(255) NOT NULL,
	ora_registrazione TIMESTAMP,
	-- fk/pk columns
	-- fk/pk keys constraints
	CONSTRAINT pk_ID_MESSAGGIO PRIMARY KEY (COUNTER,PROTOCOLLO)
);


ALTER TABLE ID_MESSAGGIO ALTER COLUMN ora_registrazione SET DEFAULT CURRENT_TIMESTAMP;


CREATE TABLE ID_MESSAGGIO_RELATIVO
(
	COUNTER BIGINT NOT NULL,
	PROTOCOLLO VARCHAR(255) NOT NULL,
	INFO_ASSOCIATA VARCHAR(255) NOT NULL,
	ora_registrazione TIMESTAMP,
	-- fk/pk columns
	-- fk/pk keys constraints
	CONSTRAINT pk_ID_MESSAGGIO_RELATIVO PRIMARY KEY (COUNTER,PROTOCOLLO,INFO_ASSOCIATA)
);


ALTER TABLE ID_MESSAGGIO_RELATIVO ALTER COLUMN ora_registrazione SET DEFAULT CURRENT_TIMESTAMP;


CREATE TABLE ID_MESSAGGIO_PRG
(
	PROGRESSIVO VARCHAR(255) NOT NULL,
	PROTOCOLLO VARCHAR(255) NOT NULL,
	ora_registrazione TIMESTAMP,
	-- fk/pk columns
	-- fk/pk keys constraints
	CONSTRAINT pk_ID_MESSAGGIO_PRG PRIMARY KEY (PROGRESSIVO,PROTOCOLLO)
);


ALTER TABLE ID_MESSAGGIO_PRG ALTER COLUMN ora_registrazione SET DEFAULT CURRENT_TIMESTAMP;


CREATE TABLE ID_MESSAGGIO_RELATIVO_PRG
(
	PROGRESSIVO VARCHAR(255) NOT NULL,
	PROTOCOLLO VARCHAR(255) NOT NULL,
	INFO_ASSOCIATA VARCHAR(255) NOT NULL,
	ora_registrazione TIMESTAMP,
	-- fk/pk columns
	-- fk/pk keys constraints
	CONSTRAINT pk_ID_MESSAGGIO_RELATIVO_PRG PRIMARY KEY (PROGRESSIVO,PROTOCOLLO,INFO_ASSOCIATA)
);


ALTER TABLE ID_MESSAGGIO_RELATIVO_PRG ALTER COLUMN ora_registrazione SET DEFAULT CURRENT_TIMESTAMP;

