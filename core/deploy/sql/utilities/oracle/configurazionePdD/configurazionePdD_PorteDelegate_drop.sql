-- Gli indici vengono eliminati automaticamente una volta eliminata la tabella
-- DROP INDEX INDEX_PD_WSSRES;
-- DROP INDEX INDEX_PD_WSSREQ;
-- DROP INDEX INDEX_PD_MTOMTRES;
-- DROP INDEX INDEX_PD_MTOMTREQ;
-- DROP INDEX INDEX_PD_PROP;
-- DROP INDEX INDEX_PD_SA;
DROP TRIGGER trg_pd_azioni;
DROP TRIGGER trg_pd_ruoli;
DROP TRIGGER trg_pd_correlazione_risposta;
DROP TRIGGER trg_pd_correlazione;
DROP TRIGGER trg_pd_security_response;
DROP TRIGGER trg_pd_security_request;
DROP TRIGGER trg_pd_mtom_response;
DROP TRIGGER trg_pd_mtom_request;
DROP TRIGGER trg_pd_properties;
DROP TRIGGER trg_porte_delegate_sa;
DROP TRIGGER trg_porte_delegate;
DROP TABLE pd_azioni;
DROP TABLE pd_ruoli;
DROP TABLE pd_correlazione_risposta;
DROP TABLE pd_correlazione;
DROP TABLE pd_security_response;
DROP TABLE pd_security_request;
DROP TABLE pd_mtom_response;
DROP TABLE pd_mtom_request;
DROP TABLE pd_properties;
DROP TABLE porte_delegate_sa;
DROP TABLE porte_delegate;
DROP SEQUENCE seq_pd_azioni;
DROP SEQUENCE seq_pd_ruoli;
DROP SEQUENCE seq_pd_correlazione_risposta;
DROP SEQUENCE seq_pd_correlazione;
DROP SEQUENCE seq_pd_security_response;
DROP SEQUENCE seq_pd_security_request;
DROP SEQUENCE seq_pd_mtom_response;
DROP SEQUENCE seq_pd_mtom_request;
DROP SEQUENCE seq_pd_properties;
DROP SEQUENCE seq_porte_delegate_sa;
DROP SEQUENCE seq_porte_delegate;
