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
package it.gov.fatturapa.sdi.fatturapa.v1_1.model;

import it.gov.fatturapa.sdi.fatturapa.v1_1.ScontoMaggiorazioneType;

import org.openspcoop2.generic_project.beans.AbstractModel;
import org.openspcoop2.generic_project.beans.IField;
import org.openspcoop2.generic_project.beans.Field;
import org.openspcoop2.generic_project.beans.ComplexField;


/**     
 * Model ScontoMaggiorazioneType 
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class ScontoMaggiorazioneTypeModel extends AbstractModel<ScontoMaggiorazioneType> {

	public ScontoMaggiorazioneTypeModel(){
	
		super();
	
		this.TIPO = new Field("Tipo",java.lang.String.class,"ScontoMaggiorazioneType",ScontoMaggiorazioneType.class);
		this.PERCENTUALE = new Field("Percentuale",java.lang.Double.class,"ScontoMaggiorazioneType",ScontoMaggiorazioneType.class);
		this.IMPORTO = new Field("Importo",java.lang.Double.class,"ScontoMaggiorazioneType",ScontoMaggiorazioneType.class);
	
	}
	
	public ScontoMaggiorazioneTypeModel(IField father){
	
		super(father);
	
		this.TIPO = new ComplexField(father,"Tipo",java.lang.String.class,"ScontoMaggiorazioneType",ScontoMaggiorazioneType.class);
		this.PERCENTUALE = new ComplexField(father,"Percentuale",java.lang.Double.class,"ScontoMaggiorazioneType",ScontoMaggiorazioneType.class);
		this.IMPORTO = new ComplexField(father,"Importo",java.lang.Double.class,"ScontoMaggiorazioneType",ScontoMaggiorazioneType.class);
	
	}
	
	

	public IField TIPO = null;
	 
	public IField PERCENTUALE = null;
	 
	public IField IMPORTO = null;
	 

	@Override
	public Class<ScontoMaggiorazioneType> getModeledClass(){
		return ScontoMaggiorazioneType.class;
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