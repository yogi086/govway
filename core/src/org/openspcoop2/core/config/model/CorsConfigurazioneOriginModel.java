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
package org.openspcoop2.core.config.model;

import org.openspcoop2.core.config.CorsConfigurazioneOrigin;

import org.openspcoop2.generic_project.beans.AbstractModel;
import org.openspcoop2.generic_project.beans.IField;
import org.openspcoop2.generic_project.beans.Field;
import org.openspcoop2.generic_project.beans.ComplexField;


/**     
 * Model CorsConfigurazioneOrigin 
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class CorsConfigurazioneOriginModel extends AbstractModel<CorsConfigurazioneOrigin> {

	public CorsConfigurazioneOriginModel(){
	
		super();
	
		this.ORIGIN = new Field("origin",java.lang.String.class,"cors-configurazione-origin",CorsConfigurazioneOrigin.class);
	
	}
	
	public CorsConfigurazioneOriginModel(IField father){
	
		super(father);
	
		this.ORIGIN = new ComplexField(father,"origin",java.lang.String.class,"cors-configurazione-origin",CorsConfigurazioneOrigin.class);
	
	}
	
	

	public IField ORIGIN = null;
	 

	@Override
	public Class<CorsConfigurazioneOrigin> getModeledClass(){
		return CorsConfigurazioneOrigin.class;
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