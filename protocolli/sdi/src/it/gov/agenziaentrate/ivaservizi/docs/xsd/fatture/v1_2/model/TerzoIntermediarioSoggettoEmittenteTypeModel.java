/*
 * GovWay - A customizable API Gateway 
 * http://www.govway.org
 *
 * from the Link.it OpenSPCoop project codebase
 * 
 * Copyright (c) 2005-2019 Link.it srl (http://link.it).
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3, as published by
 * the Free Software Foundation.
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
package it.gov.agenziaentrate.ivaservizi.docs.xsd.fatture.v1_2.model;

import it.gov.agenziaentrate.ivaservizi.docs.xsd.fatture.v1_2.TerzoIntermediarioSoggettoEmittenteType;

import org.openspcoop2.generic_project.beans.AbstractModel;
import org.openspcoop2.generic_project.beans.IField;
import org.openspcoop2.generic_project.beans.Field;
import org.openspcoop2.generic_project.beans.ComplexField;


/**     
 * Model TerzoIntermediarioSoggettoEmittenteType 
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class TerzoIntermediarioSoggettoEmittenteTypeModel extends AbstractModel<TerzoIntermediarioSoggettoEmittenteType> {

	public TerzoIntermediarioSoggettoEmittenteTypeModel(){
	
		super();
	
		this.DATI_ANAGRAFICI = new it.gov.agenziaentrate.ivaservizi.docs.xsd.fatture.v1_2.model.DatiAnagraficiTerzoIntermediarioTypeModel(new Field("DatiAnagrafici",it.gov.agenziaentrate.ivaservizi.docs.xsd.fatture.v1_2.DatiAnagraficiTerzoIntermediarioType.class,"TerzoIntermediarioSoggettoEmittenteType",TerzoIntermediarioSoggettoEmittenteType.class));
	
	}
	
	public TerzoIntermediarioSoggettoEmittenteTypeModel(IField father){
	
		super(father);
	
		this.DATI_ANAGRAFICI = new it.gov.agenziaentrate.ivaservizi.docs.xsd.fatture.v1_2.model.DatiAnagraficiTerzoIntermediarioTypeModel(new ComplexField(father,"DatiAnagrafici",it.gov.agenziaentrate.ivaservizi.docs.xsd.fatture.v1_2.DatiAnagraficiTerzoIntermediarioType.class,"TerzoIntermediarioSoggettoEmittenteType",TerzoIntermediarioSoggettoEmittenteType.class));
	
	}
	
	

	public it.gov.agenziaentrate.ivaservizi.docs.xsd.fatture.v1_2.model.DatiAnagraficiTerzoIntermediarioTypeModel DATI_ANAGRAFICI = null;
	 

	@Override
	public Class<TerzoIntermediarioSoggettoEmittenteType> getModeledClass(){
		return TerzoIntermediarioSoggettoEmittenteType.class;
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