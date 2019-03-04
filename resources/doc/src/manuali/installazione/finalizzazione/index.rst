.. _finalizzazione:

=================================
Finalizzazione dell'Installazione
=================================

Terminati i passi descritti nelle precedenti sezioni, GovWay è
pienamente operativo e può essere utilizzato per proteggere le proprie
API. Il prodotto viene dispiegato con dei parametri di configurazione
che possiedono dei valori di default relativamente alle seguenti
tematiche:

#. *URL di Invocazione*

   Per conoscere l'url di invocazione di una API protetta da GovWay è
   possibile accedere al dettaglio di una erogazione o fruizione tramite
   la govwayConsole. L'url fornita avrà un prefisso
   *http://localhost:8080/govway*.

   Se il gateway è stato dispiegato in modo da essere raggiungibile
   tramite un host, porta o contesto differente è possibile configurare
   tale prefisso seguendo le indicazioni descritte nella sezione :ref:`urlInvocazione`.

#. *Multi-Tenant*

   I processi di configurazione e monitoraggio attuabili tramite le
   console sono ottimizzati nell'ottica di gestire sempre un unico
   dominio rappresentato da un soggetto interno il cui nome è stato
   fornito durante l'esecuzione dell'installer (:numref:`interop_fig`).

   Per estendere l'ambito delle configurazioni e del monitoraggio
   tramite console a più di un soggetto interno al dominio seguire le
   indicazioni presenti nella sezione :ref:`multiTenant`.

#. *Gestione CORS*

   Nella configurazione di default di GovWay è abilitata la gestione del
   *cross-origin HTTP request (CORS)*; è possibile modificarne la
   configurazione seguendo le indicazioni presenti nella sezione :ref:`cors`.

#. *Rate Limiting - Numero Complessivo Richieste Simultanee*

   GovWay permette definire un rate limiting sulle singole erogazioni o
   fruizioni di API. Le metriche utilizzabili riguardano il numero di
   richieste all'interno di un intervallo temporale, l'occupazione di
   banda, il tempo di risposta etc.

   Oltre al rate limiting GovWay consente di fissare un numero limite
   complessivo, indipendente dalle APIs, riguardo alle richieste
   gestibili simultaneamente dal gateway, bloccando le richieste in
   eccesso.

   Per default GovWay è configurato per gestire simultaneamente al
   massimo 200 richieste. Per modificare tale configurazione seguire le
   indicazioni presenti nella sezione :ref:`maxRequests`.

5. *Tempi Risposta*

   GovWay è preconfigurato con dei parametri di timeout per quanto
   concerne la gestione delle connessioni verso gli applicativi interni
   (erogazioni) o esterni (fruizioni) dal dominio di gestione. Per
   effettuare un tuning di tali parametri seguire le indicazioni
   descritte nella sezione :ref:`tempiRisposta`.

6. *Caching della Risposta - Disk Cache*

   In GovWay è possibile abilitare il salvataggio delle risposte in una
   cache sia globalmente, in modo che sia attivo per tutte le APIs, che
   singolarmente sulla singola erogazione o fruizione. Questa
   funzionalità permette ad un backend server di non dover riprocessare
   le stesse richieste più volte.

   La configurazione di default prevede di salvare in una cache, che
   risiede in memoria RAM, fino a 5.000 risposte (ogni risposta comporta
   il salvataggio di due elementi in cache). In caso venga superato il
   numero massimo di elementi che possano risiedere in cache, vengono
   eliminate le risposte meno recenti secondo una politica *LRU*.

   GovWay consente di personalizzare la configurazione della cache in
   modo da aggiungere una memoria secondaria dove salvare gli elementi
   in eccesso. Per abilitare la memoria secondaria seguire le
   indicazioni descritte nella sezione :ref:`cachingRisposta`.

7. *Load Balancing*

   Il prodotto è preconfigurato per funzionare su di una singola
   istanza. Per realizzare un'installazione in load balancing seguire le
   indicazioni descritte nella sezione :ref:`cluster`.

.. toctree::
        :maxdepth: 2

        urlInvocazione
	multiTenant
	cors
	maxRequests
	tempiRisposta
	cachingRisposta
	cluster/index