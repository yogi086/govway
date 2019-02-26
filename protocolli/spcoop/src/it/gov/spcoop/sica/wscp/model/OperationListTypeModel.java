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
package it.gov.spcoop.sica.wscp.model;

import it.gov.spcoop.sica.wscp.OperationListType;

import org.openspcoop2.generic_project.beans.AbstractModel;
import org.openspcoop2.generic_project.beans.IField;
import org.openspcoop2.generic_project.beans.Field;
import org.openspcoop2.generic_project.beans.ComplexField;


/**     
 * Model OperationListType 
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class OperationListTypeModel extends AbstractModel<OperationListType> {

	public OperationListTypeModel(){
	
		super();
	
		this.COLLABORAZIONE = new it.gov.spcoop.sica.wscp.model.OperationTypeModel(new Field("collaborazione",it.gov.spcoop.sica.wscp.OperationType.class,"operationListType",OperationListType.class));
	
	}
	
	public OperationListTypeModel(IField father){
	
		super(father);
	
		this.COLLABORAZIONE = new it.gov.spcoop.sica.wscp.model.OperationTypeModel(new ComplexField(father,"collaborazione",it.gov.spcoop.sica.wscp.OperationType.class,"operationListType",OperationListType.class));
	
	}
	
	

	public it.gov.spcoop.sica.wscp.model.OperationTypeModel COLLABORAZIONE = null;
	 

	@Override
	public Class<OperationListType> getModeledClass(){
		return OperationListType.class;
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