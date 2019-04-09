
CREATE SEQUENCE seq_pd_auth_properties start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pd_auth_properties
(
	id_porta BIGINT NOT NULL,
	nome VARCHAR(255) NOT NULL,
	valore VARCHAR(255) NOT NULL,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_pd_auth_properties') NOT NULL,
	-- unique constraints
	CONSTRAINT uniq_pd_auth_props_1 UNIQUE (id_porta,nome,valore),
	-- fk/pk keys constraints
	CONSTRAINT fk_pd_auth_properties_1 FOREIGN KEY (id_porta) REFERENCES porte_delegate(id),
	CONSTRAINT pk_pd_auth_properties PRIMARY KEY (id)
);

-- index
CREATE INDEX INDEX_PD_AUTH_PROP ON pd_auth_properties (id_porta);



CREATE SEQUENCE seq_pa_auth_properties start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pa_auth_properties
(
	id_porta BIGINT NOT NULL,
	nome VARCHAR(255) NOT NULL,
	valore VARCHAR(255) NOT NULL,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_pa_auth_properties') NOT NULL,
	-- unique constraints
	CONSTRAINT uniq_pa_auth_props_1 UNIQUE (id_porta,nome,valore),
	-- fk/pk keys constraints
	CONSTRAINT fk_pa_auth_properties_1 FOREIGN KEY (id_porta) REFERENCES porte_applicative(id),
	CONSTRAINT pk_pa_auth_properties PRIMARY KEY (id)
);

-- index
CREATE INDEX INDEX_PA_AUTH_PROP ON pa_auth_properties (id_porta);







CREATE SEQUENCE seq_config_cache_regole start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE config_cache_regole
(
	status_min INT,
	status_max INT,
	fault INT DEFAULT 0,
	cache_seconds INT,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_config_cache_regole') NOT NULL,
	-- fk/pk keys constraints
	CONSTRAINT pk_config_cache_regole PRIMARY KEY (id)
);




CREATE SEQUENCE seq_pd_cache_regole start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pd_cache_regole
(
	id_porta BIGINT NOT NULL,
	status_min INT,
	status_max INT,
	fault INT DEFAULT 0,
	cache_seconds INT,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_pd_cache_regole') NOT NULL,
	-- fk/pk keys constraints
	CONSTRAINT fk_pd_cache_regole_1 FOREIGN KEY (id_porta) REFERENCES porte_delegate(id),
	CONSTRAINT pk_pd_cache_regole PRIMARY KEY (id)
);



CREATE SEQUENCE seq_pa_cache_regole start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pa_cache_regole
(
	id_porta BIGINT NOT NULL,
	status_min INT,
	status_max INT,
	fault INT DEFAULT 0,
	cache_seconds INT,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_pa_cache_regole') NOT NULL,
	-- fk/pk keys constraints
	CONSTRAINT fk_pa_cache_regole_1 FOREIGN KEY (id_porta) REFERENCES porte_applicative(id),
	CONSTRAINT pk_pa_cache_regole PRIMARY KEY (id)
);




ALTER TABLE configurazione ADD COLUMN response_cache_hash_hdr_list TEXT; 
ALTER TABLE configurazione ADD COLUMN response_cache_control_nocache INT;
ALTER TABLE configurazione ADD COLUMN response_cache_control_maxage INT;
ALTER TABLE configurazione ADD COLUMN response_cache_control_nostore INT;

ALTER TABLE porte_applicative ADD COLUMN response_cache_hash_hdr_list TEXT; 
ALTER TABLE porte_applicative ADD COLUMN response_cache_control_nocache INT;
ALTER TABLE porte_applicative ADD COLUMN response_cache_control_maxage INT;
ALTER TABLE porte_applicative ADD COLUMN response_cache_control_nostore INT;

ALTER TABLE porte_delegate ADD COLUMN response_cache_hash_hdr_list TEXT; 
ALTER TABLE porte_delegate ADD COLUMN response_cache_control_nocache INT;
ALTER TABLE porte_delegate ADD COLUMN response_cache_control_maxage INT;
ALTER TABLE porte_delegate ADD COLUMN response_cache_control_nostore INT;



CREATE SEQUENCE seq_pd_transform start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pd_transform
(
	id_porta BIGINT NOT NULL,
	nome VARCHAR(255) NOT NULL,
	posizione INT NOT NULL,
	applicabilita_azioni TEXT,
	applicabilita_ct TEXT,
	applicabilita_pattern TEXT,
	req_conversione_enabled INT NOT NULL DEFAULT 0,
	req_conversione_tipo VARCHAR(255),
	req_conversione_template BYTEA,
	req_content_type VARCHAR(255),
	rest_transformation INT NOT NULL DEFAULT 0,
	rest_method VARCHAR(255),
	rest_path VARCHAR(255),
	soap_transformation INT NOT NULL DEFAULT 0,
	soap_version VARCHAR(255),
	soap_action VARCHAR(255),
	soap_envelope INT NOT NULL DEFAULT 0,
	soap_envelope_as_attach INT NOT NULL DEFAULT 0,
	soap_envelope_tipo VARCHAR(255),
	soap_envelope_template BYTEA,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_pd_transform') NOT NULL,
	-- unique constraints
	CONSTRAINT unique_pd_transform_1 UNIQUE (id_porta,nome),
	CONSTRAINT unique_pd_transform_2 UNIQUE (id_porta,posizione),
	-- fk/pk keys constraints
	CONSTRAINT fk_pd_transform_1 FOREIGN KEY (id_porta) REFERENCES porte_delegate(id),
	CONSTRAINT pk_pd_transform PRIMARY KEY (id)
);




CREATE SEQUENCE seq_pd_transform_hdr start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pd_transform_hdr
(
	id_trasformazione BIGINT NOT NULL,
	tipo VARCHAR(255) NOT NULL,
	nome VARCHAR(255) NOT NULL,
	valore TEXT,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_pd_transform_hdr') NOT NULL,
	-- fk/pk keys constraints
	CONSTRAINT fk_pd_transform_hdr_1 FOREIGN KEY (id_trasformazione) REFERENCES pd_transform(id),
	CONSTRAINT pk_pd_transform_hdr PRIMARY KEY (id)
);

-- index
CREATE INDEX idx_pd_trasf_hdr_1 ON pd_transform_hdr (id_trasformazione);



CREATE SEQUENCE seq_pd_transform_url start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pd_transform_url
(
	id_trasformazione BIGINT NOT NULL,
	tipo VARCHAR(255) NOT NULL,
	nome VARCHAR(255) NOT NULL,
	valore TEXT,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_pd_transform_url') NOT NULL,
	-- fk/pk keys constraints
	CONSTRAINT fk_pd_transform_url_1 FOREIGN KEY (id_trasformazione) REFERENCES pd_transform(id),
	CONSTRAINT pk_pd_transform_url PRIMARY KEY (id)
);

-- index
CREATE INDEX idx_pd_trasf_url_1 ON pd_transform_url (id_trasformazione);



CREATE SEQUENCE seq_pd_transform_risp start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pd_transform_risp
(
	id_trasformazione BIGINT NOT NULL,
	nome VARCHAR(255) NOT NULL,
	posizione INT NOT NULL,
	applicabilita_status_min INT,
	applicabilita_status_max INT,
	applicabilita_ct TEXT,
	applicabilita_pattern TEXT,
	conversione_enabled INT NOT NULL DEFAULT 0,
	conversione_tipo VARCHAR(255),
	conversione_template BYTEA,
	content_type VARCHAR(255),
	return_code INT,
	soap_envelope INT NOT NULL DEFAULT 0,
	soap_envelope_as_attach INT NOT NULL DEFAULT 0,
	soap_envelope_tipo VARCHAR(255),
	soap_envelope_template BYTEA,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_pd_transform_risp') NOT NULL,
	-- unique constraints
	CONSTRAINT uniq_pd_trasf_resp_1 UNIQUE (id_trasformazione,nome),
	CONSTRAINT uniq_pd_trasf_resp_2 UNIQUE (id_trasformazione,posizione),
	-- fk/pk keys constraints
	CONSTRAINT fk_pd_transform_risp_1 FOREIGN KEY (id_trasformazione) REFERENCES pd_transform(id),
	CONSTRAINT pk_pd_transform_risp PRIMARY KEY (id)
);




CREATE SEQUENCE seq_pd_transform_risp_hdr start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pd_transform_risp_hdr
(
	id_transform_risp BIGINT NOT NULL,
	tipo VARCHAR(255) NOT NULL,
	nome VARCHAR(255) NOT NULL,
	valore TEXT,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_pd_transform_risp_hdr') NOT NULL,
	-- fk/pk keys constraints
	CONSTRAINT fk_pd_transform_risp_hdr_1 FOREIGN KEY (id_transform_risp) REFERENCES pd_transform_risp(id),
	CONSTRAINT pk_pd_transform_risp_hdr PRIMARY KEY (id)
);

-- index
CREATE INDEX idx_pd_trasf_hdr_resp_1 ON pd_transform_risp_hdr (id_transform_risp);



CREATE SEQUENCE seq_pa_transform start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pa_transform
(
	id_porta BIGINT NOT NULL,
	nome VARCHAR(255) NOT NULL,
	posizione INT NOT NULL,
	applicabilita_azioni TEXT,
	applicabilita_ct TEXT,
	applicabilita_pattern TEXT,
	req_conversione_enabled INT NOT NULL DEFAULT 0,
	req_conversione_tipo VARCHAR(255),
	req_conversione_template BYTEA,
	req_content_type VARCHAR(255),
	rest_transformation INT NOT NULL DEFAULT 0,
	rest_method VARCHAR(255),
	rest_path VARCHAR(255),
	soap_transformation INT NOT NULL DEFAULT 0,
	soap_version VARCHAR(255),
	soap_action VARCHAR(255),
	soap_envelope INT NOT NULL DEFAULT 0,
	soap_envelope_as_attach INT NOT NULL DEFAULT 0,
	soap_envelope_tipo VARCHAR(255),
	soap_envelope_template BYTEA,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_pa_transform') NOT NULL,
	-- unique constraints
	CONSTRAINT unique_pa_transform_1 UNIQUE (id_porta,nome),
	CONSTRAINT unique_pa_transform_2 UNIQUE (id_porta,posizione),
	-- fk/pk keys constraints
	CONSTRAINT fk_pa_transform_1 FOREIGN KEY (id_porta) REFERENCES porte_applicative(id),
	CONSTRAINT pk_pa_transform PRIMARY KEY (id)
);




CREATE SEQUENCE seq_pa_transform_hdr start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pa_transform_hdr
(
	id_trasformazione BIGINT NOT NULL,
	tipo VARCHAR(255) NOT NULL,
	nome VARCHAR(255) NOT NULL,
	valore TEXT,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_pa_transform_hdr') NOT NULL,
	-- fk/pk keys constraints
	CONSTRAINT fk_pa_transform_hdr_1 FOREIGN KEY (id_trasformazione) REFERENCES pa_transform(id),
	CONSTRAINT pk_pa_transform_hdr PRIMARY KEY (id)
);

-- index
CREATE INDEX idx_pa_trasf_hdr_1 ON pa_transform_hdr (id_trasformazione);



CREATE SEQUENCE seq_pa_transform_url start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pa_transform_url
(
	id_trasformazione BIGINT NOT NULL,
	tipo VARCHAR(255) NOT NULL,
	nome VARCHAR(255) NOT NULL,
	valore TEXT,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_pa_transform_url') NOT NULL,
	-- fk/pk keys constraints
	CONSTRAINT fk_pa_transform_url_1 FOREIGN KEY (id_trasformazione) REFERENCES pa_transform(id),
	CONSTRAINT pk_pa_transform_url PRIMARY KEY (id)
);

-- index
CREATE INDEX idx_pa_trasf_url_1 ON pa_transform_url (id_trasformazione);



CREATE SEQUENCE seq_pa_transform_risp start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pa_transform_risp
(
	id_trasformazione BIGINT NOT NULL,
	nome VARCHAR(255) NOT NULL,
	posizione INT NOT NULL,
	applicabilita_status_min INT,
	applicabilita_status_max INT,
	applicabilita_ct TEXT,
	applicabilita_pattern TEXT,
	conversione_enabled INT NOT NULL DEFAULT 0,
	conversione_tipo VARCHAR(255),
	conversione_template BYTEA,
	content_type VARCHAR(255),
	return_code INT,
	soap_envelope INT NOT NULL DEFAULT 0,
	soap_envelope_as_attach INT NOT NULL DEFAULT 0,
	soap_envelope_tipo VARCHAR(255),
	soap_envelope_template BYTEA,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_pa_transform_risp') NOT NULL,
	-- unique constraints
	CONSTRAINT uniq_pa_trasf_resp_1 UNIQUE (id_trasformazione,nome),
	CONSTRAINT uniq_pa_trasf_resp_2 UNIQUE (id_trasformazione,posizione),
	-- fk/pk keys constraints
	CONSTRAINT fk_pa_transform_risp_1 FOREIGN KEY (id_trasformazione) REFERENCES pa_transform(id),
	CONSTRAINT pk_pa_transform_risp PRIMARY KEY (id)
);




CREATE SEQUENCE seq_pa_transform_risp_hdr start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pa_transform_risp_hdr
(
	id_transform_risp BIGINT NOT NULL,
	tipo VARCHAR(255) NOT NULL,
	nome VARCHAR(255) NOT NULL,
	valore TEXT,
	-- fk/pk columns
	id BIGINT DEFAULT nextval('seq_pa_transform_risp_hdr') NOT NULL,
	-- fk/pk keys constraints
	CONSTRAINT fk_pa_transform_risp_hdr_1 FOREIGN KEY (id_transform_risp) REFERENCES pa_transform_risp(id),
	CONSTRAINT pk_pa_transform_risp_hdr PRIMARY KEY (id)
);

-- index
CREATE INDEX idx_pa_trasf_hdr_resp_1 ON pa_transform_risp_hdr (id_transform_risp);





-- Inizializzo per avere nuove visualizzazioni
delete from users_stati ;

