/*
 * OpenSPCoop - Customizable API Gateway 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2016 Link.it srl (http://link.it).
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
package org.openspcoop2.core.registry.model;

import org.openspcoop2.core.registry.ConfigurazioneServizioAzioneFruitore;

import org.openspcoop2.generic_project.beans.AbstractModel;
import org.openspcoop2.generic_project.beans.IField;
import org.openspcoop2.generic_project.beans.Field;
import org.openspcoop2.generic_project.beans.ComplexField;


/**     
 * Model ConfigurazioneServizioAzioneFruitore 
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class ConfigurazioneServizioAzioneFruitoreModel extends AbstractModel<ConfigurazioneServizioAzioneFruitore> {

	public ConfigurazioneServizioAzioneFruitoreModel(){
	
		super();
	
		this.CONNETTORE = new org.openspcoop2.core.registry.model.ConnettoreModel(new Field("connettore",org.openspcoop2.core.registry.Connettore.class,"configurazione-servizio-azione-fruitore",ConfigurazioneServizioAzioneFruitore.class));
		this.TIPO = new Field("tipo",java.lang.String.class,"configurazione-servizio-azione-fruitore",ConfigurazioneServizioAzioneFruitore.class);
		this.NOME = new Field("nome",java.lang.String.class,"configurazione-servizio-azione-fruitore",ConfigurazioneServizioAzioneFruitore.class);
	
	}
	
	public ConfigurazioneServizioAzioneFruitoreModel(IField father){
	
		super(father);
	
		this.CONNETTORE = new org.openspcoop2.core.registry.model.ConnettoreModel(new ComplexField(father,"connettore",org.openspcoop2.core.registry.Connettore.class,"configurazione-servizio-azione-fruitore",ConfigurazioneServizioAzioneFruitore.class));
		this.TIPO = new ComplexField(father,"tipo",java.lang.String.class,"configurazione-servizio-azione-fruitore",ConfigurazioneServizioAzioneFruitore.class);
		this.NOME = new ComplexField(father,"nome",java.lang.String.class,"configurazione-servizio-azione-fruitore",ConfigurazioneServizioAzioneFruitore.class);
	
	}
	
	

	public org.openspcoop2.core.registry.model.ConnettoreModel CONNETTORE = null;
	 
	public IField TIPO = null;
	 
	public IField NOME = null;
	 

	@Override
	public Class<ConfigurazioneServizioAzioneFruitore> getModeledClass(){
		return ConfigurazioneServizioAzioneFruitore.class;
	}
	
	@Override
	public String toString(){
		if(this.getModeledClass()!=null){
			return this.getModeledClass().getName();
		}else{
			return "N.D.";
		}
	}

}