Feature: Update Allegati Fruizioni

Background:

* call read('classpath:crud_commons.feature')

* def api_petstore = read('../api_petstore.json')
* eval randomize(api_petstore, ["nome"])
* eval api_petstore.referente = soggettoDefault
* def api_petstore_path = 'api/' + api_petstore.nome + '/' + api_petstore.versione

* def erogatore = read('../soggetto_erogatore.json')
* eval randomize (erogatore, ["nome", "credenziali.username"])

* def fruizione_petstore = read('../fruizione_petstore.json')
* eval fruizione_petstore.api_nome = api_petstore.nome
* eval fruizione_petstore.api_versione = api_petstore.versione
* eval fruizione_petstore.erogatore = erogatore.nome
* eval fruizione_petstore.api_referente = api_petstore.referente

* def fruizione_key = fruizione_petstore.erogatore + '/' + fruizione_petstore.api_nome + '/' + fruizione_petstore.api_versione
* def fruizione_petstore_path = 'fruizioni/' + fruizione_key

* def allegato = read('allegato.json')
* def allegato2 = read('allegato2.json')


@Update204
Scenario: Update Allegati Fruizioni 204

    * call create ({ resourcePath: 'api', body: api_petstore })
    * call create ({ resourcePath: 'soggetti', body: erogatore })
    * call create ({ resourcePath: 'fruizioni', body: fruizione_petstore })

    * call update_204 ( { resourcePath: fruizione_petstore_path + '/allegati', body: allegato, body_update: allegato2, key: allegato.allegato.nome, delete_key: allegato2.allegato.nome } )
  
    * call delete ({ resourcePath: 'fruizioni/' + fruizione_key })
    * call delete ({ resourcePath: 'soggetti/' + erogatore.nome })
    * call delete ({ resourcePath: api_petstore_path })


@Update404
Scenario: Update Allegati Fruizioni 404

    * call create ({ resourcePath: 'api', body: api_petstore })
    * call create ({ resourcePath: 'soggetti', body: erogatore })
    * call create ({ resourcePath: 'fruizioni', body: fruizione_petstore })
    
    * call update_404 ( { resourcePath: fruizione_petstore_path + '/allegati', body: allegato, key: allegato.allegato.nome } )
    
    * call delete ({ resourcePath: 'fruizioni/' + fruizione_key })
    * call delete ({ resourcePath: 'soggetti/' + erogatore.nome })
    * call delete ({ resourcePath: api_petstore_path })

