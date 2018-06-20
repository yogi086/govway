package org.openspcoop2.monitor.engine.statistic;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openspcoop2.core.constants.TipoPdD;
import org.openspcoop2.core.id.IDSoggetto;
import org.openspcoop2.generic_project.beans.AliasTableComplexField;
import org.openspcoop2.generic_project.beans.ComplexField;
import org.openspcoop2.generic_project.beans.Function;
import org.openspcoop2.generic_project.beans.FunctionField;
import org.openspcoop2.generic_project.beans.IAliasTableField;
import org.openspcoop2.generic_project.beans.IField;
import org.openspcoop2.generic_project.beans.UnixTimestampIntervalField;
import org.openspcoop2.generic_project.exception.ExpressionException;
import org.openspcoop2.generic_project.exception.ExpressionNotImplementedException;
import org.openspcoop2.generic_project.expression.IExpression;
import org.openspcoop2.generic_project.expression.impl.sql.ISQLFieldConverter;
import org.openspcoop2.utils.sql.SQLQueryObjectException;

import org.openspcoop2.core.transazioni.Transazione;
import org.openspcoop2.core.transazioni.constants.PddRuolo;
import org.openspcoop2.core.statistiche.StatisticaContenuti;
import org.openspcoop2.monitor.engine.utils.ContentFormatter;
import org.openspcoop2.monitor.engine.exceptions.EngineException;
import org.openspcoop2.monitor.engine.condition.FilterUtils;
import org.openspcoop2.monitor.engine.constants.Costanti;
import org.openspcoop2.monitor.engine.transaction.TransactionContentUtils;
import org.openspcoop2.monitor.sdk.statistic.StatisticFilterName;
import org.openspcoop2.monitor.sdk.statistic.StatisticResourceFilter;

/**
 * StatisticsUtils
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class StatisticsUtils {

	
	public static Long readLongValue(Map<String, Object> row, String alias){
		Object object = row.get(alias);
		if(object!=null){
			if(object instanceof org.apache.commons.lang.ObjectUtils.Null){
				return null;
			}
			else{
				return (Long) object;
			}
		}
		return null;
	}
	
	public static void setExpression(IExpression expr, Date data, Date dateNext, TipoPdD tipoPdD, boolean setNotNullDate, StatisticBean stat,
			ISQLFieldConverter fieldConverter) throws Exception{
		setExpressionEngine(expr, data, dateNext, tipoPdD, setNotNullDate, stat, fieldConverter, false, null,null);
	}
	public static void setExpressionByStato(IExpression expr, Date data, Date dateNext, TipoPdD tipoPdD, boolean setNotNullDate, StatisticBean stat,
			ISQLFieldConverter fieldConverter) throws Exception{
		setExpressionEngine(expr, data, dateNext, tipoPdD, setNotNullDate, stat, fieldConverter, true, null,null);
	}
	public static void setExpressionStatsPersonalizzate(IExpression expr, Date data, Date dateNext, TipoPdD tipoPdD, boolean setNotNullDate, StatisticBean stat,
			ISQLFieldConverter fieldConverter,
			List<AliasFilter> aliases,
			String idRisorsa,
			StatisticResourceFilter ... risorseFiltri) throws Exception{
		setExpressionEngine(expr, data, dateNext, tipoPdD, setNotNullDate, stat, fieldConverter,false,
				aliases,idRisorsa, risorseFiltri);
	}
	private static void setExpressionEngine(IExpression expr, Date data, Date dateNext, TipoPdD tipoPdD, boolean setNotNullDate, StatisticBean stat,
			ISQLFieldConverter fieldConverter,
			boolean groupByStato,
			List<AliasFilter> aliases,
			String idRisorsa,
			StatisticResourceFilter ... risorseFiltri) throws Exception{
		
		expr.and();
		
		// indice
		expr.between(Transazione.model().DATA_INGRESSO_RICHIESTA,data , dateNext);
		expr.isNotNull(Transazione.model().DATA_INGRESSO_RICHIESTA);
		
		if(TipoPdD.DELEGATA.equals(tipoPdD)){
			expr.equals(Transazione.model().PDD_RUOLO, PddRuolo.DELEGATA);
		}else{
			expr.equals(Transazione.model().PDD_RUOLO, PddRuolo.APPLICATIVA);
		}
		expr.isNotNull(Transazione.model().PDD_RUOLO);
		
		expr.isNotNull(Transazione.model().ESITO_CONTESTO);
		
		if(stat!=null){
			// condizioni di group by messe anche in equals
//			expr.equals(Transazione.model().PDD_CODICE,stat.getIdPorta());
//			expr.equals(Transazione.model().TIPO_SOGGETTO_FRUITORE, stat.getMittente()!=null ? stat.getMittente().getTipo() : null);
//			expr.equals(Transazione.model().NOME_SOGGETTO_FRUITORE, stat.getMittente()!=null ? stat.getMittente().getNome() : null);
//			expr.equals(Transazione.model().TIPO_SOGGETTO_EROGATORE, stat.getDestinatario()!=null ? stat.getDestinatario().getTipo() : null);
//			expr.equals(Transazione.model().NOME_SOGGETTO_EROGATORE, stat.getDestinatario()!=null ? stat.getDestinatario().getNome() : null);
//			expr.equals(Transazione.model().TIPO_SERVIZIO, stat.getTipoServizio());
//			expr.equals(Transazione.model().NOME_SERVIZIO, stat.getServizio());
//			expr.equals(Transazione.model().AZIONE, stat.getAzione());

			// Gestisco i possibili valori null con '-'.
			// Sono state prese le informazioni anche con null poichè senno non venivano contate nelle statistiche le transazioni che non possedevano info sui servizi. (es porta delegata non trovata)
			String pddCodice = stat.getIdPorta();
			setCondition(expr, pddCodice, Transazione.model().PDD_CODICE);
			String tipoMittente = stat.getMittente()!=null ? stat.getMittente().getTipo() : null;
			setCondition(expr, tipoMittente, Transazione.model().TIPO_SOGGETTO_FRUITORE);
			String nomeMittente = stat.getMittente()!=null ? stat.getMittente().getNome() : null;
			setCondition(expr, nomeMittente, Transazione.model().NOME_SOGGETTO_FRUITORE);
			String tipoDestinatario = stat.getDestinatario()!=null ? stat.getDestinatario().getTipo() : null;
			setCondition(expr, tipoDestinatario, Transazione.model().TIPO_SOGGETTO_EROGATORE);
			String nomeDestinatario = stat.getDestinatario()!=null ? stat.getDestinatario().getNome() : null;
			setCondition(expr, nomeDestinatario, Transazione.model().NOME_SOGGETTO_EROGATORE);
			String tipoServizio = stat.getTipoServizio();
			setCondition(expr, tipoServizio, Transazione.model().TIPO_SERVIZIO);
			String nomeServizio = stat.getServizio();
			setCondition(expr, nomeServizio, Transazione.model().NOME_SERVIZIO);
			Integer versioneServizio = stat.getVersioneServizio();
			setCondition(expr, versioneServizio, Transazione.model().VERSIONE_SERVIZIO);
			String azione = stat.getAzione();
			setCondition(expr, azione, Transazione.model().AZIONE);
			
			
			if(TipoPdD.DELEGATA.equals(tipoPdD)){
				if(Costanti.SERVIZIO_APPLICATIVO_ANONIMO.equals(stat.getServizioApplicativo()) || stat.getServizioApplicativo()==null){
					expr.isNull(Transazione.model().SERVIZIO_APPLICATIVO_FRUITORE);
				}
				else{
					expr.equals(Transazione.model().SERVIZIO_APPLICATIVO_FRUITORE,stat.getServizioApplicativo());
				}
			}else{
				if(Costanti.SERVIZIO_APPLICATIVO_ANONIMO.equals(stat.getServizioApplicativo()) || stat.getServizioApplicativo()==null){
					expr.isNull(Transazione.model().SERVIZIO_APPLICATIVO_EROGATORE);
				}
				else{
					expr.equals(Transazione.model().SERVIZIO_APPLICATIVO_EROGATORE,stat.getServizioApplicativo());
				}
			}
			
			String trasportoMittente = stat.getTrasportoMittente();
			setCondition(expr, trasportoMittente, Transazione.model().TRASPORTO_MITTENTE);
			
			String tokenIssuer = stat.getTokenIssuer();
			setCondition(expr, tokenIssuer, Transazione.model().TOKEN_ISSUER);
			String tokenClientId = stat.getTokenClientId();
			setCondition(expr, tokenClientId, Transazione.model().TOKEN_CLIENT_ID);
			String tokenSubject = stat.getTokenSubject();
			setCondition(expr, tokenSubject, Transazione.model().TOKEN_SUBJECT);
			String tokenUsername = stat.getTokenUsername();
			setCondition(expr, tokenUsername, Transazione.model().TOKEN_USERNAME);
			String tokenMail = stat.getTokenMail();
			setCondition(expr, tokenMail, Transazione.model().TOKEN_MAIL);
			
			expr.equals(Transazione.model().ESITO, stat.getEsito()!=null ? stat.getEsito() : -1);
			
			String esitoContesto = stat.getEsitoContesto();
			setCondition(expr, esitoContesto, Transazione.model().ESITO_CONTESTO);
		}
		else{
			// Gestisco i possibili valori null con '-'.
			// Sono state prese le informazioni anche con null poichè senno non venivano contate nelle statistiche le transazioni che non possedevano info sui servizi. (es porta delegata non trovata)
//			expr.isNotNull(Transazione.model().PDD_CODICE);
//			expr.isNotNull(Transazione.model().TIPO_SOGGETTO_FRUITORE);
//			expr.isNotNull(Transazione.model().NOME_SOGGETTO_FRUITORE);
//			expr.isNotNull(Transazione.model().TIPO_SOGGETTO_EROGATORE);
//			expr.isNotNull(Transazione.model().NOME_SOGGETTO_EROGATORE);
//			expr.isNotNull(Transazione.model().TIPO_SERVIZIO);
//			expr.isNotNull(Transazione.model().NOME_SERVIZIO);
//			expr.isNotNull(Transazione.model().VERSIONE_SERVIZIO);
		}
		
		if(setNotNullDate){
			expr.isNotNull(Transazione.model().DATA_USCITA_RICHIESTA);
			expr.isNotNull(Transazione.model().DATA_INGRESSO_RISPOSTA);
			expr.isNotNull(Transazione.model().DATA_USCITA_RISPOSTA);
		}

		if(idRisorsa!=null){
			expr.equals(Transazione.model().DUMP_MESSAGGIO.CONTENUTO.NOME,idRisorsa);
		}
		if(risorseFiltri!=null && risorseFiltri.length>0){
			for (int i = 0; i < risorseFiltri.length; i++) {
				AliasFilter af = new AliasFilter();
				IAliasTableField atf = new AliasTableComplexField((ComplexField)Transazione.model().DUMP_MESSAGGIO.CONTENUTO.NOME, FilterUtils.getNextAliasStatisticsTable());
				//System.out.println("FILTRO["+i+"]= ("+af.getAliasTable()+") "+risorseFiltri[i]);
				af.setNomeFiltro(atf);
				af.setStatisticFilterName(risorseFiltri[i].getStatisticFilterName());
				aliases.add(af);
				expr.equals(atf,risorseFiltri[i].getResourceID());	
			}
		}
		
		// ** GROUP BY **
		expr.addGroupBy(Transazione.model().PDD_RUOLO);
		expr.addGroupBy(Transazione.model().PDD_CODICE);
		expr.addGroupBy(Transazione.model().TIPO_SOGGETTO_FRUITORE);
		expr.addGroupBy(Transazione.model().NOME_SOGGETTO_FRUITORE);
		expr.addGroupBy(Transazione.model().TIPO_SOGGETTO_EROGATORE);
		expr.addGroupBy(Transazione.model().NOME_SOGGETTO_EROGATORE);
		expr.addGroupBy(Transazione.model().TIPO_SERVIZIO);
		expr.addGroupBy(Transazione.model().NOME_SERVIZIO);
		expr.addGroupBy(Transazione.model().VERSIONE_SERVIZIO);
		expr.addGroupBy(Transazione.model().AZIONE);
		if(TipoPdD.DELEGATA.equals(tipoPdD)){
			expr.addGroupBy(Transazione.model().SERVIZIO_APPLICATIVO_FRUITORE);
		}else{
			expr.addGroupBy(Transazione.model().SERVIZIO_APPLICATIVO_EROGATORE);
		}
		expr.addGroupBy(Transazione.model().TRASPORTO_MITTENTE);
		expr.addGroupBy(Transazione.model().TOKEN_ISSUER);
		expr.addGroupBy(Transazione.model().TOKEN_CLIENT_ID);
		expr.addGroupBy(Transazione.model().TOKEN_SUBJECT);
		expr.addGroupBy(Transazione.model().TOKEN_USERNAME);
		expr.addGroupBy(Transazione.model().TOKEN_MAIL);
		expr.addGroupBy(Transazione.model().ESITO);
		expr.addGroupBy(Transazione.model().ESITO_CONTESTO);
		if(groupByStato){
			expr.addGroupBy(Transazione.model().STATO);
		}
		if(idRisorsa!=null){
			expr.addGroupBy(Transazione.model().DUMP_MESSAGGIO.CONTENUTO.NOME);
			expr.addGroupBy(Transazione.model().DUMP_MESSAGGIO.CONTENUTO.VALORE);
		}
		if(aliases!=null && aliases.size()>0){
			for (AliasFilter aliasFilter : aliases) {
				IAliasTableField afName = aliasFilter.getNomeFiltro(); 
				expr.addGroupBy(afName);
				
				String tableAlias = afName.getAliasTable();
				IAliasTableField afValue = new AliasTableComplexField((ComplexField)Transazione.model().DUMP_MESSAGGIO.CONTENUTO.VALORE, tableAlias);
				aliasFilter.setValoreFiltro(afValue);
				
				expr.addGroupBy(afValue);
			}
		}
	}
	
	private static void setCondition(IExpression expr, String value,IField field) throws ExpressionNotImplementedException, ExpressionException{
		if(value==null || "".equals(value) || Costanti.INFORMAZIONE_NON_DISPONIBILE.equals(value)){
			expr.isNull(field);
		}
		else{
			expr.equals(field,value);
		}
	}
	
	private static void setCondition(IExpression expr, Integer value,IField field) throws ExpressionNotImplementedException, ExpressionException{
		if(value==null || "".equals(value) || value.intValue() == Costanti.INFORMAZIONE_VERSIONE_NON_DISPONIBILE){
			expr.equals(field,Costanti.INFORMAZIONE_VERSIONE_NON_DISPONIBILE);
		}
		else{
			expr.equals(field,value);
		}
	}
	
	public static void addSelectFieldCountTransaction(List<FunctionField> selectList) throws ExpressionException{
		
		// Numero Transazioni
		FunctionField fCount = new FunctionField(
				//Transazione.model().ID_TRANSAZIONE,
				Transazione.model().DATA_INGRESSO_RICHIESTA, // piu' efficente
				//Function.COUNT_DISTINCT,
				Function.COUNT,
				"richieste");
		selectList.add(fCount);
		
	}
	
	public static void addSelectFieldSizeTransaction(TipoPdD tipoPdD,List<FunctionField> selectList) throws ExpressionException{
		
		// Dimensione Transazioni
		FunctionField fSum1 = null, fSum2= null, fSum3= null, fSum4= null;
		
		fSum1 = new FunctionField(Transazione.model().RICHIESTA_INGRESSO_BYTES, Function.SUM, "message_bytes_in_richiesta");
		fSum2 = new FunctionField(Transazione.model().RICHIESTA_USCITA_BYTES, Function.SUM, "message_bytes_out_richiesta");
		fSum3 = new FunctionField(Transazione.model().RISPOSTA_INGRESSO_BYTES, Function.SUM, "message_bytes_in_risposta");
		fSum4 = new FunctionField(Transazione.model().RISPOSTA_USCITA_BYTES, Function.SUM, "message_bytes_out_risposta");

		selectList.add(fSum1);
		selectList.add(fSum2);
		selectList.add(fSum3);
		selectList.add(fSum4);
	}
	
	public static void addSelectFieldLatencyTransaction(TipoPdD tipoPdD,ISQLFieldConverter fieldConverter, List<FunctionField> selectList) throws ExpressionException, SQLQueryObjectException{
		
		// Latenza Totale
		UnixTimestampIntervalField latenzaTotale = new UnixTimestampIntervalField("unix_latenza_totale", fieldConverter, true, 
				Transazione.model().DATA_USCITA_RISPOSTA, Transazione.model().DATA_INGRESSO_RICHIESTA);
		FunctionField fLatenzaTotaleAvg = new FunctionField(latenzaTotale, Function.AVG, "latenza_totale");
		selectList.add(fLatenzaTotaleAvg);
		
		// Latenza Servizio
		UnixTimestampIntervalField latenzaServizio = new UnixTimestampIntervalField("unix_latenza_servizio", fieldConverter, true, 
				Transazione.model().DATA_INGRESSO_RISPOSTA, Transazione.model().DATA_USCITA_RICHIESTA);
		FunctionField fLatenzaServizioAvg = new FunctionField(latenzaServizio, Function.AVG, "latenza_servizio");
		selectList.add(fLatenzaServizioAvg);
		
		// Latenza Porta Richiesta
		UnixTimestampIntervalField latenzaPortaRichiesta = new UnixTimestampIntervalField("unix_latenza_richiesta", fieldConverter, true, 
				Transazione.model().DATA_USCITA_RICHIESTA, Transazione.model().DATA_INGRESSO_RICHIESTA);
		FunctionField fLatenzaPortaRichiestaAvg = new FunctionField(latenzaPortaRichiesta, Function.AVG, "latenza_porta_richiesta");
		selectList.add(fLatenzaPortaRichiestaAvg);
		
		// Latenza Porta Risposta
		UnixTimestampIntervalField latenzaPortaRisposta = new UnixTimestampIntervalField("unix_latenza_risposta", fieldConverter, true, 
				Transazione.model().DATA_USCITA_RISPOSTA, Transazione.model().DATA_INGRESSO_RISPOSTA);
		FunctionField fLatenzaPortaRispostaAvg = new FunctionField(latenzaPortaRisposta, Function.AVG, "latenza_porta_risposta");
		selectList.add(fLatenzaPortaRispostaAvg);
		
	}
	
	
	public static StatisticBean readStatisticBean(StatisticBean stat,Map<String, Object> row){
		
		stat.setIdPorta(getValueFromMap(Transazione.model().PDD_CODICE,row));
		String TipoPortaS = (String) row.get(Transazione.model().PDD_RUOLO.getFieldName());
		String sa= null;
		TipoPdD tipo = TipoPdD.toTipoPdD(TipoPortaS);
		stat.setTipoPorta(tipo);
		Object saObject = null;
		if(tipo.equals(TipoPdD.DELEGATA)){
			saObject = row.get(Transazione.model().SERVIZIO_APPLICATIVO_FRUITORE.getFieldName());
		}else{
			saObject = row.get(Transazione.model().SERVIZIO_APPLICATIVO_EROGATORE.getFieldName());
		}
		if(saObject!=null){
			if(saObject instanceof org.apache.commons.lang.ObjectUtils.Null){
				sa = null;
			}
			else{
				sa = (String) saObject;
			}
		}
		stat.setServizioApplicativo(sa != null ? sa : Costanti.SERVIZIO_APPLICATIVO_ANONIMO);
				
		stat.setTrasportoMittente(getValueFromMap(Transazione.model().TRASPORTO_MITTENTE,row));
		
		stat.setTokenIssuer(getValueFromMap(Transazione.model().TOKEN_ISSUER,row));
		stat.setTokenClientId(getValueFromMap(Transazione.model().TOKEN_CLIENT_ID,row));
		stat.setTokenSubject(getValueFromMap(Transazione.model().TOKEN_SUBJECT,row));
		stat.setTokenUsername(getValueFromMap(Transazione.model().TOKEN_USERNAME,row));
		stat.setTokenMail(getValueFromMap(Transazione.model().TOKEN_MAIL,row));
		
//		stat.setMittente(new IDSoggetto((String)row.get(Transazione.model().TIPO_SOGGETTO_FRUITORE.getFieldName()), (String)row.get(Transazione.model().NOME_SOGGETTO_FRUITORE .getFieldName())));
//		stat.setDestinatario(new IDSoggetto((String)row.get(Transazione.model().TIPO_SOGGETTO_EROGATORE.getFieldName()),(String)row.get(Transazione.model().NOME_SOGGETTO_EROGATORE.getFieldName())));
//		stat.setTipoServizio((String)row.get(Transazione.model().TIPO_SERVIZIO.getFieldName()));
//		stat.setServizio((String)row.get(Transazione.model().NOME_SERVIZIO.getFieldName()));
//		Object azObject = row.get(Transazione.model().AZIONE.getFieldName());
//		String az = null;
//		if(azObject!=null && !(azObject instanceof org.apache.commons.lang.ObjectUtils.Null)){ 
//			az = (String) azObject;
//		}
//		stat.setAzione(az != null ? az : " ");
		
		// Gestisco i possibili valori null con '-'.
		// Sono state prese le informazioni anche con null poichè senno non venivano contate nelle statistiche le transazioni che non possedevano info sui servizi. (es porta delegata non trovata)
		stat.setMittente(new IDSoggetto(getValueFromMap(Transazione.model().TIPO_SOGGETTO_FRUITORE,row), 
										getValueFromMap(Transazione.model().NOME_SOGGETTO_FRUITORE,row)));
		
		stat.setDestinatario(new IDSoggetto(getValueFromMap(Transazione.model().TIPO_SOGGETTO_EROGATORE,row), 
											getValueFromMap(Transazione.model().NOME_SOGGETTO_EROGATORE,row)));
		
		stat.setTipoServizio(getValueFromMap(Transazione.model().TIPO_SERVIZIO,row));
		stat.setServizio(getValueFromMap(Transazione.model().NOME_SERVIZIO,row));
		stat.setVersioneServizio(getVersionValueFromMap(Transazione.model().VERSIONE_SERVIZIO,row));
		
		stat.setAzione(getValueFromMap(Transazione.model().AZIONE,row));
		
		stat.setEsito((Integer)row.get(Transazione.model().ESITO.getFieldName()));
		
		stat.setEsitoContesto(getValueFromMap(Transazione.model().ESITO_CONTESTO,row));
		
		return stat;
	}
	private static String getValueFromMap(IField field, Map<String, Object> row){
		Object tmpObject = row.get(field.getFieldName());
		String tmp = null;
		if(tmpObject!=null && !(tmpObject instanceof org.apache.commons.lang.ObjectUtils.Null)){ 
			tmp = (String) tmpObject;
		}
		if(tmp!=null && !"".equals(tmp)){
			return tmp;
		}
		else{
			return Costanti.INFORMAZIONE_NON_DISPONIBILE;
		}
	}
	private static Integer getVersionValueFromMap(IField field, Map<String, Object> row){
		Object tmpObject = row.get(field.getFieldName());
		Integer tmp = null;
		if(tmpObject!=null && !(tmpObject instanceof org.apache.commons.lang.ObjectUtils.Null)){ 
			tmp = (Integer) tmpObject;
		}
		if(tmp!=null && tmp.intValue()>0){
			return tmp;
		}
		else{
			return Costanti.INFORMAZIONE_VERSIONE_NON_DISPONIBILE;
		}
	}
	
	public static void updateStatisticBeanCountTransactionInfo(StatisticBean stat,Map<String, Object> row){
		
		Long tmp = StatisticsUtils.readLongValue(row, "richieste");
		if(tmp!=null){
			stat.setRichieste(tmp);
		}

	}
	
	public static void updateStatisticBeanSizeTransactionInfo(StatisticBean stat,Map<String, Object> row){
				
		long messageBytesInRequest = 0;
		Long tmp = StatisticsUtils.readLongValue(row, "message_bytes_in_richiesta");
		if(tmp!=null){
			messageBytesInRequest = tmp.longValue();
		}
		long messageBytesOutRequest = 0;
		tmp = StatisticsUtils.readLongValue(row, "message_bytes_out_richiesta");
		if(tmp!=null){
			messageBytesOutRequest = tmp.longValue();
		}
		long messageBytesInResponse = 0;
		tmp = StatisticsUtils.readLongValue(row, "message_bytes_in_risposta");
		if(tmp!=null){
			messageBytesInResponse = tmp.longValue();
		}
		long messageBytesOutResponse = 0;
		tmp = StatisticsUtils.readLongValue(row, "message_bytes_out_risposta");
		if(tmp!=null){
			messageBytesOutResponse = tmp.longValue();
		}
		
		switch (stat.getTipoPorta()) {
		case DELEGATA:
			stat.setBytesBandaInterna(messageBytesInRequest+messageBytesOutResponse);
			stat.setBytesBandaEsterna(messageBytesOutRequest+messageBytesInResponse);
			break;
		default:
			stat.setBytesBandaInterna(messageBytesOutRequest+messageBytesInResponse);
			stat.setBytesBandaEsterna(messageBytesInRequest+messageBytesOutResponse);
			break;
		}
		stat.setBytesBandaTotale(stat.getBytesBandaInterna()+stat.getBytesBandaEsterna());
		
	}
	
	public static void updateStatisticsBeanLatencyTransactionInfo(StatisticBean stat,Map<String, Object> row){
		// Latenza Totale
		long latenzaTotaleValue = -1;
		Long tmp = StatisticsUtils.readLongValue(row, "latenza_totale");
		if(tmp!=null){
			latenzaTotaleValue = tmp.longValue();
		}
		stat.setLatenzaTotale(latenzaTotaleValue);
		
		// Latenza Servizio
		long latenzaServizioValue = -1;
		tmp = StatisticsUtils.readLongValue(row, "latenza_servizio");
		if(tmp!=null){
			latenzaServizioValue = tmp.longValue();
		}
		stat.setLatenzaServizio(latenzaServizioValue);
		
		// Latenza Porta
		long latenzaPortaRichiestaValue = -1;
		tmp = StatisticsUtils.readLongValue(row, "latenza_porta_richiesta");
		if(tmp!=null){
			latenzaPortaRichiestaValue = tmp.longValue();
		}
		long latenzaPortaRispostaValue = -1;
		tmp = StatisticsUtils.readLongValue(row, "latenza_porta_risposta");
		if(tmp!=null){
			latenzaPortaRispostaValue = tmp.longValue();
		}
		long latenzaPortaValue = -1;
		if(latenzaPortaRichiestaValue>=0){
			latenzaPortaValue = latenzaPortaRichiestaValue;
			if(latenzaPortaRispostaValue>=0){
				latenzaPortaValue = latenzaPortaValue + latenzaPortaRispostaValue;
			}
		}
		else{
			if(latenzaPortaRispostaValue>=0){
				latenzaPortaValue = latenzaPortaRispostaValue;
			}
		}
		stat.setLatenzaPorta(latenzaPortaValue);
	}
	
	public static void fillStatisticsContenutiByStato(String idStatisticaPersonalizzata,StatisticaContenuti statisticaContenuti,Map<String, Object> row) throws EngineException{
		String aliasValore = Transazione.model().STATO.getFieldName();
		Object oValore = row.get(aliasValore);
		String valore = null;
		if(oValore!=null && oValore instanceof String){
			String s = (String) oValore;
			if(!"".equals(s)){
				valore = s;
			}
			else{
				valore = org.openspcoop2.monitor.engine.constants.Costanti.TRANSAZIONE_SENZA_STATO;
			}
		}else{
			valore = org.openspcoop2.monitor.engine.constants.Costanti.TRANSAZIONE_SENZA_STATO;
		}
		setRisorsaValore(statisticaContenuti, idStatisticaPersonalizzata, valore);
	}
	
	public static void fillStatisticsContenuti(String idStatisticaPersonalizzata,StatisticaContenuti statisticaContenuti,Map<String, Object> row,
			List<AliasFilter> aliases,RisorsaSemplice risorsaSemplice) throws EngineException{
		
		String risorsaNome = null;
		if(risorsaSemplice.getIdStatistica()!=null){
			risorsaNome = idStatisticaPersonalizzata+"-"+risorsaSemplice.getIdStatistica();
		}
		else{
			risorsaNome = idStatisticaPersonalizzata;
		}
		
		String aliasValore = Transazione.model().DUMP_MESSAGGIO.getBaseField().getFieldName()+"."+
				Transazione.model().DUMP_MESSAGGIO.CONTENUTO.getBaseField().getFieldName()+"."+
				Transazione.model().DUMP_MESSAGGIO.CONTENUTO.VALORE.getFieldName();
		
		setRisorsaValore(statisticaContenuti, risorsaNome, (String)row.get(aliasValore));
		
		
//		java.util.Iterator<String> itS = row.keySet().iterator();
//		while (itS.hasNext()) {
//			String key = (String) itS.next();
//			System.out.println("ESEMPIO KEY["+key+"]");
//		}
		
		if(aliases.size()>0){
			for (int i = 0; i < aliases.size(); i++) {
				AliasFilter af = aliases.get(i);
				IAliasTableField afName = af.getNomeFiltro();
				IAliasTableField afValore = af.getValoreFiltro();
				
				String aliasFiltroNome = afName.getAliasTable()+"."+
						Transazione.model().DUMP_MESSAGGIO.CONTENUTO.NOME.getFieldName();
				String aliasFiltroValore = afValore.getAliasTable()+"."+
						Transazione.model().DUMP_MESSAGGIO.CONTENUTO.VALORE.getFieldName();
				
				setFiltro(statisticaContenuti, 
						af.getStatisticFilterName(), 
						(String)row.get(aliasFiltroNome), 
						(String)row.get(aliasFiltroValore));
				
			}
		}
		
	}
	
	public static void fillStatisticsContenuti(String idStatistica,StatisticaContenuti statisticaContenuti,RisorsaAggregata risorsaAggregata) throws EngineException{
		
		setRisorsaValore(statisticaContenuti, idStatistica, risorsaAggregata.getValoreRisorsaAggregata());
		if(risorsaAggregata.getFiltri()!=null && risorsaAggregata.getFiltri().size()>0){
			for (int i = 0; i < risorsaAggregata.getFiltri().size(); i++) {
				String nome = risorsaAggregata.getFiltri().get(i).getResourceID();
				String valore = ContentFormatter.toString(risorsaAggregata.getFiltri().get(i).getValue());
				
				setFiltro(statisticaContenuti, 
						risorsaAggregata.getFiltri().get(i).getStatisticFilterName(), 
						nome, 
						valore);
				
			}
		}
	}
	
	private static void setRisorsaValore(StatisticaContenuti statisticaContenuti,String risorsaNome,String valore) throws EngineException{
		if(valore.length()>TransactionContentUtils.SOGLIA_VALUE_TOO_LONG){
			throw new EngineException("Valore fornito per il contenuto statistico ["+risorsaNome
					+"] è troppo grande (>"+TransactionContentUtils.SOGLIA_VALUE_TOO_LONG+") per essere utilizzato come informazione statistica. Valore fornito: "+valore);
		}
		if(TransactionContentUtils.KEY_COMPRESSED.equals(valore)){
			throw new EngineException("Una risorsa compressa è stata fornita per il contenuto statistico ["+risorsaNome
					+"]; questo tipo di risorsa non è utilizzabile come informazione statistica");
		}
		if(TransactionContentUtils.KEY_VALUE_TOO_LONG.equals(valore)){
			throw new EngineException("Una risorsa con valore > "+TransactionContentUtils.SOGLIA_VALUE_TOO_LONG+
					" caratteri è stata fornita per il contenuto statistico ["+risorsaNome
					+"]; questo tipo di risorsa non è utilizzabile come informazione statistica");
		}
		statisticaContenuti.setRisorsaNome(risorsaNome);
		statisticaContenuti.setRisorsaValore(valore);
	}
	
	private static void setFiltro(StatisticaContenuti statisticaContenuti,StatisticFilterName filterName,
			String nome,String valore) throws EngineException{
		
		if(nome.length()>255){
			throw new EngineException("Nome assegnato a "+filterName.name()+" ("+nome
					+") è troppo grande (>255)");
		}
		if(valore.length()>TransactionContentUtils.SOGLIA_VALUE_TOO_LONG){
			throw new EngineException("Valore fornito per "+filterName.name()+" ["+nome
					+"] è troppo grande (>"+TransactionContentUtils.SOGLIA_VALUE_TOO_LONG+") per essere utilizzato come filtro. Valore fornito: "+valore);
		}
		if(TransactionContentUtils.KEY_COMPRESSED.equals(valore)){
			throw new EngineException("Una risorsa compressa è stata fornita per "+filterName.name()+" ["+nome
					+"]; questo tipo di risorsa non è utilizzabile come valore per un filtro");
		}
		if(TransactionContentUtils.KEY_VALUE_TOO_LONG.equals(valore)){
			throw new EngineException("Una risorsa con valore > "+TransactionContentUtils.SOGLIA_VALUE_TOO_LONG+" caratteri è stata fornita per "+
					filterName.name()+" ["+nome
					+"]; questo tipo di risorsa non è utilizzabile come valore per un filtro");
		}
		
		switch (filterName) {
		case FILTER_1:
			statisticaContenuti.setFiltroNome1(nome);
			statisticaContenuti.setFiltroValore1(valore);
			break;
		case FILTER_2:
			statisticaContenuti.setFiltroNome2(nome);
			statisticaContenuti.setFiltroValore2(valore);
			break;
		case FILTER_3:
			statisticaContenuti.setFiltroNome3(nome);
			statisticaContenuti.setFiltroValore3(valore);
			break;
		case FILTER_4:
			statisticaContenuti.setFiltroNome4(nome);
			statisticaContenuti.setFiltroValore4(valore);
			break;
		case FILTER_5:
			statisticaContenuti.setFiltroNome5(nome);
			statisticaContenuti.setFiltroValore5(valore);
			break;
		case FILTER_6:
			statisticaContenuti.setFiltroNome6(nome);
			statisticaContenuti.setFiltroValore6(valore);
			break;
		case FILTER_7:
			statisticaContenuti.setFiltroNome7(nome);
			statisticaContenuti.setFiltroValore7(valore);
			break;
		case FILTER_8:
			statisticaContenuti.setFiltroNome8(nome);
			statisticaContenuti.setFiltroValore8(valore);
			break;
		case FILTER_9:
			statisticaContenuti.setFiltroNome9(nome);
			statisticaContenuti.setFiltroValore9(valore);
			break;
		case FILTER_10:
			statisticaContenuti.setFiltroNome10(nome);
			statisticaContenuti.setFiltroValore10(valore);
			break;
		}
	}
	
	public static String buildKey(StatisticaContenuti statisticaContenuti){
		StringBuffer bf = new StringBuffer();
		
		bf.append(statisticaContenuti.getRisorsaNome());
		bf.append("=");
		bf.append(statisticaContenuti.getRisorsaValore());
		
		if(statisticaContenuti.getFiltroNome1()!=null){
			bf.append(statisticaContenuti.getFiltroNome1());
			bf.append("=");
			bf.append(statisticaContenuti.getFiltroValore1());
		}
		
		if(statisticaContenuti.getFiltroNome2()!=null){
			bf.append(statisticaContenuti.getFiltroNome2());
			bf.append("=");
			bf.append(statisticaContenuti.getFiltroValore2());
		}
		
		if(statisticaContenuti.getFiltroNome3()!=null){
			bf.append(statisticaContenuti.getFiltroNome3());
			bf.append("=");
			bf.append(statisticaContenuti.getFiltroValore3());
		}
		
		if(statisticaContenuti.getFiltroNome4()!=null){
			bf.append(statisticaContenuti.getFiltroNome4());
			bf.append("=");
			bf.append(statisticaContenuti.getFiltroValore4());
		}
		
		if(statisticaContenuti.getFiltroNome5()!=null){
			bf.append(statisticaContenuti.getFiltroNome5());
			bf.append("=");
			bf.append(statisticaContenuti.getFiltroValore5());
		}
		
		if(statisticaContenuti.getFiltroNome6()!=null){
			bf.append(statisticaContenuti.getFiltroNome6());
			bf.append("=");
			bf.append(statisticaContenuti.getFiltroValore6());
		}
		
		if(statisticaContenuti.getFiltroNome7()!=null){
			bf.append(statisticaContenuti.getFiltroNome7());
			bf.append("=");
			bf.append(statisticaContenuti.getFiltroValore7());
		}
		
		if(statisticaContenuti.getFiltroNome8()!=null){
			bf.append(statisticaContenuti.getFiltroNome8());
			bf.append("=");
			bf.append(statisticaContenuti.getFiltroValore8());
		}
		
		if(statisticaContenuti.getFiltroNome9()!=null){
			bf.append(statisticaContenuti.getFiltroNome9());
			bf.append("=");
			bf.append(statisticaContenuti.getFiltroValore9());
		}
		
		if(statisticaContenuti.getFiltroNome10()!=null){
			bf.append(statisticaContenuti.getFiltroNome10());
			bf.append("=");
			bf.append(statisticaContenuti.getFiltroValore10());
		}
		
		return bf.toString();
		
	}
}
