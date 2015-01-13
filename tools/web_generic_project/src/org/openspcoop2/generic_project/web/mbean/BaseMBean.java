/*
 * OpenSPCoop v2 - Customizable SOAP Message Broker 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2015 Link.it srl (http://link.it).
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.openspcoop2.generic_project.web.mbean;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.openspcoop2.generic_project.web.core.MessageUtils;
import org.openspcoop2.generic_project.web.core.Utils;
import org.openspcoop2.generic_project.web.form.BaseSearchForm;
import org.openspcoop2.generic_project.web.iservice.IBaseService;


/**
 * BaseMBean classe generica che fornisce il supporto alle informazioni che vengono visualizzate in una pagina.
 * 
 * service: interfaccia con il livello service per l'accesso ai dati.
 * selectedElement: in caso di visualizzazione di tipo Elenco -> Dettaglio, 
 * fornisce il supporto per la gestione della selezione di un elemento da parte dell'utente.
 * selectedIds: se i dati sono presentati all'interno di un widget che fornisce il supporto alla selezione multipla,
 * tiene traccia della selezione effettuata.
 * toRemove: se i dati sono presentati all'interno di un widget che consente la cancellazione dei dati,
 * tiene traccia degli elementi da eliminare.
 * selectAll: flag che indica se sono stati selezionati tutti i dati.
 * search: Bean della ricerca relativa alle informazioni visualizzate.
 * 
 * @param <T> tipo dell'oggetto
 * @param <K> tipo della chiave dell'oggetto
 * @param <S> form di ricerca.
 * 
 * @author Pintori Giuliano (pintori@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class BaseMBean<T,K,S extends BaseSearchForm> {

	protected IBaseService<T,K,S> service;
	protected T selectedElement;
	protected Map<T, Boolean> selectedIds = new HashMap<T, Boolean>();
	protected ArrayList<T> toRemove;
	private boolean selectedAll = false;
	protected S search;
	protected T metadata;

	public void setService(IBaseService<T, K,S> service) {
		this.service = service;
	}

	@SuppressWarnings("unchecked")
	public T getSelectedElement() throws Exception{
		if(this.selectedElement==null){
			try{
				ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
				this.selectedElement = ((Class<T>)parameterizedType.getActualTypeArguments()[0]).newInstance();
			}catch (Exception e) {
				throw e;
			}
		}
		return this.selectedElement;
	}

	public void setSelectedElement(T selectedElement) {
		this.selectedElement = selectedElement;
	}

	public Map<T, Boolean> getSelectedIds() {
		return this.selectedIds;
	}

	public void setSelectedIds(Map<T, Boolean> selectedIds) {
		this.selectedIds = selectedIds;
	}


	public String delete(){
		this.toRemove = new ArrayList<T>();
		Iterator<T> it = this.selectedIds.keySet().iterator();
		while (it.hasNext()) {
			T elem = it.next();
			if(this.selectedIds.get(elem).booleanValue()){
				this.toRemove.add(elem);
				it.remove();
			}
		}

		for (T elem : this.toRemove) {
			try{
				this.service.delete(elem);
			}catch (Exception e) {
//				FacesContext ctx = FacesContext.getCurrentInstance();
				String m = Utils.getMessageFromCommonsResourceBundle("DELETE_ERROR");
				MessageUtils.addErrorMsg(m + ": " + e.getMessage());
//				String m = Utils.getMessageFromResourceBundle(ctx.getApplication().getMessageBundle(), "DELETE_ERROR", new String[]{elem.toString()}, ctx.getViewRoot().getLocale());
//				ctx.addMessage(null, new FacesMessage(m,e.getLocalizedMessage()));
			}

		}


		return null;
	}

	public List<FacesMessage> getMessages(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		Iterator<FacesMessage> ite = ctx.getMessages();
		ArrayList<FacesMessage> list = new ArrayList<FacesMessage>();
		while (ite.hasNext()) {
			list.add(ite.next());
		}
		return list;
	}

	public boolean isSelectedAll() {
		return this.selectedAll;
	}

	public void setSelectedAll(boolean selectedAll) {
		this.selectedAll = selectedAll;
	}

	public S getSearch() {
		return this.search;
	}

	public void setSearch(S search) {
		this.search = search;
	}

	@SuppressWarnings("unchecked")
	public T getMetadata() throws Exception{
		if(this.metadata==null){
			try{
				ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
				this.metadata = ((Class<T>)parameterizedType.getActualTypeArguments()[0]).newInstance();
			}catch (Exception e) {
				throw e;
			}
		}
		return this.metadata;
	}

	public void setMetadata(T metadata) {
		this.metadata = metadata;
	}
	
	/**
	 * Listener eseguito prima di aggiungere un nuovo ricerca, setta a null il selectedElement
	 * in modo da "scordarsi" i valori gia' impostati.
	 * @param ae
	 */
	public void addNewListener(ActionEvent ae){
		this.selectedElement = null;
	}
}
