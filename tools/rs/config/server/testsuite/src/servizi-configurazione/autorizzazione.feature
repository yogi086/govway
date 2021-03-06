Feature: Configurazione Controllo Accessi Autorizzazione

Background:

    * def autorizzazione_disabilitata = ({ autorizzazione: { tipo: 'disabilitato' } })
    * def autorizzazione = read('classpath:bodies/controllo-accessi-autorizzazione-puntuale.json')
    * def autorizzazione_xacml = read('classpath:bodies/controllo-accessi-autorizzazione-xacml.json')
    * def autorizzazione_custom = read('classpath:bodies/controllo-accessi-autorizzazione-custom.json')


@UpdateAutorizzazione
Scenario: Update Autorizzazione

    * eval autorizzazione.autorizzazione.configurazione = ({ richiedente: true, ruoli: true, scope: false, token: false })

    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione'
    And header Authorization = govwayConfAuth
    And request autorizzazione
    And params query_params
    When method put
    Then status 204

    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione'
    And header Authorization = govwayConfAuth
    And params query_params
    When method get
    Then status 200
    And match response.autorizzazione.tipo == "abilitato"
    And match response.autorizzazione.configurazione contains ({richiedente: true, ruoli: true, scope: false, token: false })

@UpdateAutorizzazioneXacml
Scenario: Update Autorizzazione Xacml

    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione'
    And header Authorization = govwayConfAuth
    And request autorizzazione_xacml
    And params query_params
    When method put
    Then status 204

    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione'
    And header Authorization = govwayConfAuth
    And params query_params
    When method get
    Then status 200
    And match response.autorizzazione.tipo == "xacml-Policy"
    And match response.autorizzazione.configurazione_xacml contains ({ ruoli_fonte: 'esterna' })


@UpdateAutorizzazioneCustom
Scenario: Update Autorizzazione Custom

    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione'
    And header Authorization = govwayConfAuth
    And request autorizzazione_custom
    And params query_params
    When method put
    Then status 204

    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione'
    And header Authorization = govwayConfAuth
    And params query_params
    When method get
    Then status 200
    And match response.autorizzazione.tipo == "custom"
    And match response.autorizzazione.configurazione_custom.nome == autorizzazione_custom.autorizzazione.configurazione_custom.nome

@GetAutorizzazione
Scenario: Get Autorizzazione

    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione'
    And header Authorization = govwayConfAuth
    And params query_params
    When method get
    Then status 200


@DownloadXacmlPolicy200
Scenario: DOWNLOAD XACML POLICY

    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione'
    And header Authorization = govwayConfAuth
    And request autorizzazione_xacml
    And params query_params
    When method put
    Then status 204


    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione', 'download-xacml-policy'
    And header Authorization = govwayConfAuth
    And params query_params
    When method get
    Then status 200


@AutorizzazioneRuoli
Scenario: Controllo accessi autorizzazione ruoli

    * eval autorizzazione.autorizzazione.configurazione = ({ richiedente: false, ruoli: true, scope: false, token: false })
    # Imposto l'autorizzazione in modo che supporti l'autorizzazione per ruoli
    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione'
    And header Authorization = govwayConfAuth
    And request autorizzazione
    And params query_params
    When method put
    Then status 204

    * def ruolo_registro = read('classpath:bodies/ruolo.json')
    * eval randomize(ruolo_registro, ["nome"] )
    * def ruolo = ({ ruolo: ruolo_registro.nome })
    
    # Creo il ruolo nel registro
    Given url configUrl
    And path 'ruoli'
    And header Authorization = govwayConfAuth
    And request ruolo_registro
    And params query_params
    When method post
    Then status 201

    # Aggiungo il ruolo all'autorizzazione
    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione', 'ruoli'
    And header Authorization = govwayConfAuth
    And request ruolo
    And params query_params
    When method post
    Then status 201

    # Recupero il ruolo appena aggiunto per mezzo della findall
    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione', 'ruoli'
    And header Authorization = govwayConfAuth
    And params query_params
    When method get
    Then status 200
    And match response.ruoli contains ([ruolo.ruolo])

    # Rimuovo il ruolo dall'autorizzazione
    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione', 'ruoli', ruolo.ruolo
    And header Authorization = govwayConfAuth
    And params query_params
    When method delete
    Then status 204

    # Rimuovo il ruolo dal registro
    Given url configUrl
    And path 'ruoli', ruolo_registro.nome
    And header Authorization = govwayConfAuth
    And params query_params
    When method delete
    Then status 204

@AutorizzazioneTokenClaims
Scenario: Controllo Accessi Autorizzazione Token Claims

    # Disabilito l'autorizzazione
    * eval autorizzazione.autorizzazione.tipo = 'disabilitato'
    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione'
    And header Authorization = govwayConfAuth
    And request autorizzazione
    And params query_params
    When method put
    Then status 204

    # Abilito la gestione dei tokens
    * def gestione_token_body = read('classpath:bodies/gestione-token-petstore.json')

    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'gestione-token'
    And header Authorization = govwayConfAuth
    And request gestione_token_body
    And params query_params
    When method put
    Then status 204

    # Abilito l'autorizzazione per token claim
    * eval autorizzazione.autorizzazione.configurazione = ({ richiedente: false, ruoli: false, scope: false, token: true, token_claims:"user=pippo" })
    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione'
    And header Authorization = govwayConfAuth
    And request autorizzazione
    And params query_params
    When method put
    Then status 204

    # TODO: Matcha la risposta.



@AutorizzazioneScope
Scenario: Controllo Accessi Autorizzazione Scope

    # Abilito la gestione dei tokens
    * def gestione_token_body = read('classpath:bodies/gestione-token-petstore.json')

    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'gestione-token'
    And header Authorization = govwayConfAuth
    And request gestione_token_body
    And params query_params
    When method put
    Then status 204

    # Abilito l'autorizzazione per scope
    * eval autorizzazione.autorizzazione.configurazione = ({ richiedente: false, ruoli: false, scope: true, token: false })

    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione'
    And header Authorization = govwayConfAuth
    And request autorizzazione
    And params query_params
    When method put
    Then status 204

    * def scope_registro = read('classpath:bodies/scope.json')
    * eval randomize(scope_registro, ["nome"])
    * def scope = ({ scope: scope_registro.nome })

    # Creo lo scope nel registro
    * call create ({ resourcePath: 'scope', body: scope_registro })

    # Aggiungo lo scope all'autorizzazione
    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione', 'scope'
    And header Authorization = govwayConfAuth
    And request scope
    And params query_params
    When method post
    Then status 201

    # Recupero lo scope appena aggiunto per mezzo della findall
    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione', 'scope'
    And header Authorization = govwayConfAuth
    And params query_params
    When method get
    Then status 200
    And match response.scope contains ([scope.scope])

    # Rimuovo lo scope dall'autorizzazione
    Given url configUrl
    And path servizio_path, 'configurazioni', 'controllo-accessi', 'autorizzazione', 'scope', scope.scope
    And header Authorization = govwayConfAuth
    And params query_params
    When method delete
    Then status 204

    # Rimuovo lo scope dal registro
    * call delete ({ resourcePath: 'scope/' +  scope_registro.nome })
