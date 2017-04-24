-- Gli indici vengono eliminati automaticamente una volta eliminata la tabella
-- DROP INDEX index_politiche_sicurezza_1;
DROP TABLE politiche_sicurezza_init_seq;
DROP TABLE politiche_sicurezza;
DROP SEQUENCE seq_politiche_sicurezza;

-- Gli indici vengono eliminati automaticamente una volta eliminata la tabella
-- DROP INDEX INDEX_RUOLI_SA;
-- DROP INDEX INDEX_RUOLI;
DROP TABLE ruoli_sa_init_seq;
DROP TABLE ruoli_sa;
DROP SEQUENCE seq_ruoli_sa;


ALTER TABLE soggetti ADD COLUMN tipoauth VARCHAR(255);
ALTER TABLE soggetti ADD COLUMN utente VARCHAR(255);
ALTER TABLE soggetti ADD COLUMN password VARCHAR(255);
ALTER TABLE soggetti ADD COLUMN subject VARCHAR(255);

 
CREATE SEQUENCE seq_soggetti_ruoli AS BIGINT START WITH 1 INCREMENT BY 1 ; -- (Scommentare in hsql 2.x) NO CYCLE;

CREATE TABLE soggetti_ruoli
(
	id_soggetto BIGINT NOT NULL,
	id_ruolo BIGINT NOT NULL,
	-- fk/pk columns
	id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
	-- unique constraints
	CONSTRAINT unique_soggetti_ruoli_1 UNIQUE (id_soggetto,id_ruolo),
	-- fk/pk keys constraints
	CONSTRAINT fk_soggetti_ruoli_1 FOREIGN KEY (id_soggetto) REFERENCES soggetti(id),
	CONSTRAINT fk_soggetti_ruoli_2 FOREIGN KEY (id_ruolo) REFERENCES ruoli(id),
	CONSTRAINT pk_soggetti_ruoli PRIMARY KEY (id)
);

-- index
CREATE UNIQUE INDEX index_soggetti_ruoli_1 ON soggetti_ruoli (id_soggetto,id_ruolo);
CREATE TABLE soggetti_ruoli_init_seq (id BIGINT);
INSERT INTO soggetti_ruoli_init_seq VALUES (NEXT VALUE FOR seq_soggetti_ruoli);

-- **** Mapping con Porte ****

CREATE SEQUENCE seq_mapping_fruizione_pd AS BIGINT START WITH 1 INCREMENT BY 1 ; -- (Scommentare in hsql 2.x) NO CYCLE;

CREATE TABLE mapping_fruizione_pd
(
        id_fruizione BIGINT NOT NULL,
        id_porta BIGINT NOT NULL,
        -- fk/pk columns
        id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
        -- unique constraints
        CONSTRAINT unique_mapping_fruizione_pd_1 UNIQUE (id_fruizione),
        -- fk/pk keys constraints
        CONSTRAINT fk_mapping_fruizione_pd_1 FOREIGN KEY (id_fruizione) REFERENCES servizi_fruitori(id),
        CONSTRAINT fk_mapping_fruizione_pd_2 FOREIGN KEY (id_porta) REFERENCES porte_delegate(id),
        CONSTRAINT pk_mapping_fruizione_pd PRIMARY KEY (id)
);

-- index
CREATE UNIQUE INDEX index_mapping_fruizione_pd_1 ON mapping_fruizione_pd (id_fruizione);
CREATE TABLE mapping_fruizione_pd_init_seq (id BIGINT);
INSERT INTO mapping_fruizione_pd_init_seq VALUES (NEXT VALUE FOR seq_mapping_fruizione_pd);



CREATE SEQUENCE seq_mapping_erogazione_pa AS BIGINT START WITH 1 INCREMENT BY 1 ; -- (Scommentare in hsql 2.x) NO CYCLE;

CREATE TABLE mapping_erogazione_pa
(
        id_erogazione BIGINT NOT NULL,
        id_porta BIGINT NOT NULL,
        -- fk/pk columns
        id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
        -- unique constraints
        CONSTRAINT unique_mapping_erogazione_pa_1 UNIQUE (id_erogazione),
        -- fk/pk keys constraints
        CONSTRAINT fk_mapping_erogazione_pa_1 FOREIGN KEY (id_erogazione) REFERENCES servizi(id),
        CONSTRAINT fk_mapping_erogazione_pa_2 FOREIGN KEY (id_porta) REFERENCES porte_applicative(id),
        CONSTRAINT pk_mapping_erogazione_pa PRIMARY KEY (id)
);

-- index
CREATE UNIQUE INDEX index_mapping_erogazione_pa_1 ON mapping_erogazione_pa (id_erogazione);
CREATE TABLE mapping_erogazione_pa_init_seq (id BIGINT);
INSERT INTO mapping_erogazione_pa_init_seq VALUES (NEXT VALUE FOR seq_mapping_erogazione_pa);


