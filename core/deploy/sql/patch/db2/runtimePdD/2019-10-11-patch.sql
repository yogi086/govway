ALTER TABLE MSG_SERVIZI_APPLICATIVI ADD LOCK_CONSEGNA TIMESTAMP;
ALTER TABLE MSG_SERVIZI_APPLICATIVI ADD CLUSTER_ID VARCHAR(255);
ALTER TABLE MSG_SERVIZI_APPLICATIVI ADD ATTESA_ESITO INT;