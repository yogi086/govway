.. _modipa_passiPreliminari:

Passi preliminari di configurazione
-----------------------------------

In questa sezione viene indicato come effettuare una configurazione iniziale dei seguenti aspetti di gestione dei certificati X509 utilizzati all'interno dei token di sicurezza 'ModI PA'.

**TrustStore per la validazione dei Certificati**

Per le richieste, provenienti da amministrazioni esterne, GovWay deve validare il certificato presente all'interno del token di sicurezza al fine di verificare che sia rilasciato da una della CA conosciute, che non sia scaduto e che non sia stato eventualmente revocato. 
Per poter effettuare la validazione, deve essere configurato opportunamente GovWay per quanto riguarda le seguenti proprietà presenti nel file “/etc/govway/modipa_local.properties” (dove si assume che '/etc/govway' sia la directory di configurazione indicata in fase di installazione) tutte con prefisso 'org.openspcoop2.protocol.modipa.sicurezzaMessaggio.certificati.':

- *trustStore.path* (obbligatorio):  indica il path su file system di un trustStore contenente le CA conosciute.
- *trustStore.tipo* (obbligatorio): indica il tipo di trustStore (JKS)
- *trustStore.password* (obbligatorio): password per accedere al trustStore
- *trustStore.crls* (opzionale): permette di indicare un elenco, separato da virgola, di file CRL.

La configurazione sopra indicata rappresenta la configurazione di default che verrà proposta durante la gestione di una erogazione o di una fruizione. È sempre possibile ridefinire per ogni singola API tale configurazione

.. note::

	**TrustStore delle comunicazioni HTTPS**

	Nei profili di sicurezza per API REST, dove il riferimento al certificato utilizzato viaggia tramite il claim 'x5u', è possibile che GovWay debba effettuare il download del certificato tramite url https che espongono certificati server non validabili tramite le CA note. In tale contesto è possibile configurare un trustStore personalizzato agendo sulle proprietà presenti nel file “/etc/govway/modipa_local.properties” in maniera simile al trustStore dei certificati. Tali proprietà possiedono il prefisso 'org.openspcoop2.protocol.modipa.sicurezzaMessaggio.ssl.'.


**KeyStore per la firma della Risposte**

Nella figura :numref:`FruizioneModIPA` della sezione :ref:`modipa_sicurezzaMessaggio` è stato descritto come GovWay utilizzerà la chiave privata associata all'applicativo interno che ha scaturito la richiesta per firmare il token di sicurezza aggiunto al messaggio in uscita dal dominio di gestione.
Per quanto concerne invece le risposte che GovWay processa in una erogazione, la chiave privata utilizzata per firmare il token di sicurezza aggiunto alla risposta viene preso da una configurazione di default descritta di seguito. È sempre possibile ridefinire per ogni singola API tale configurazione.
 
Per poter firmare i token di sicurezza delle risposte, deve essere configurato opportunamente GovWay per quanto riguarda le seguenti proprietà presenti nel file “/etc/govway/modipa_local.properties” tutte con prefisso 'org.openspcoop2.protocol.modipa.sicurezzaMessaggio.certificati.':

- *keyStore.path* (obbligatorio):  indica il path su file system di un keyStore contenente la chiave privata.
- *keyStore.tipo* (obbligatorio): indica il tipo di trustStore (JKS)
- *keyStore.password* (obbligatorio): password per accedere al keyStore
- *key.alias* (obbligatorio): alias della chiave privata all'interno del keyStore.
- *key.password* (obbligatorio): password della chiave privata all'interno del keyStore.


