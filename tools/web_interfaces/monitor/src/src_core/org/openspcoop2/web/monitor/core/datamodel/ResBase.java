package org.openspcoop2.web.monitor.core.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ResBase {

	private List<Number> somme = null;
	private Map<String, Number> objects = null; 
	private TreeMap<String, String> parent= null;
	
	//	private Number somma;

	public ResBase(){
		this.somme = new ArrayList<Number>();
		this.objects = new HashMap<String, Number>();
		this.parent = new TreeMap<String, String>();
	}

	public Number getSomma() {
		return this.somme!= null ? this.somme.get(0) : null;
	}

	public void setSomma(Number somma) {
		this.somme = new ArrayList<Number>();
		this.objects = new HashMap<String, Number>();

		String key = this.somme.size() + ""; 
		this.somme.add(somma);
		this.objects.put(key, somma);
	}

	public void inserisciSomma(Number somma){
		if(this.somme == null){
			this.somme = new ArrayList<Number>();
			this.objects = new HashMap<String, Number>();
		}

		String key = this.somme.size() + ""; 
		this.somme.add(somma);
		this.objects.put(key, somma);
	}

	public void setSomme(List<Number> lst){
		this.somme.addAll(lst);
	}

	public List<Number> getSomme(){
		return this.somme;
	}

	public Map<String, Number> getObjectsMap() {
		return this.objects;
	}
	
	@Override
	public String toString(){
		StringBuffer bf = new StringBuffer();
		bf.append("=== Risultato ====");
		bf.append("\n");
		if(this.somme!=null){
			bf.append("\tSomme size: ["+this.somme.size()+"]");
			for (int i = 0; i < this.somme.size(); i++) {
				bf.append("\n");
				bf.append("\tSomma["+i+"]: ["+this.somme.get(i)+"]");
			}
		}
		else{
			bf.append("\tSomme: [undefined]");
		}
		
		bf.append("\n");
		if(this.parent!=null && this.parent.size()>0){
			bf.append("\tParent size: ["+this.parent.size()+"]");
			Iterator<String> keys = this.parent.keySet().iterator();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				String value = this.parent.get(key);
				bf.append("\n");
				bf.append("\tParent["+key+"]: ["+value+"]");
			}
		}
		else{
			bf.append("\tParent: [undefined]");
		}
		
		return bf.toString();
	}

	public TreeMap<String, String> getParentMap() {
		return this.parent;
	}
}