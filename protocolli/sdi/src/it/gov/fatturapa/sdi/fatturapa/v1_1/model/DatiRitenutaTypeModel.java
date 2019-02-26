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

import it.gov.fatturapa.sdi.fatturapa.v1_1.DatiRitenutaType;

import org.openspcoop2.generic_project.beans.AbstractModel;
import org.openspcoop2.generic_project.beans.IField;
import org.openspcoop2.generic_project.beans.Field;
import org.openspcoop2.generic_project.beans.ComplexField;


/**     
 * Model DatiRitenutaType 
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class DatiRitenutaTypeModel extends AbstractModel<DatiRitenutaType> {

	public DatiRitenutaTypeModel(){
	
		super();
	
		this.TIPO_RITENUTA = new Field("TipoRitenuta",java.lang.String.class,"DatiRitenutaType",DatiRitenutaType.class);
		this.IMPORTO_RITENUTA = new Field("ImportoRitenuta",java.lang.Double.class,"DatiRitenutaType",DatiRitenutaType.class);
		this.ALIQUOTA_RITENUTA = new Field("AliquotaRitenuta",java.lang.Double.class,"DatiRitenutaType",DatiRitenutaType.class);
		this.CAUSALE_PAGAMENTO = new Field("CausalePagamento",java.lang.String.class,"DatiRitenutaType",DatiRitenutaType.class);
	
	}
	
	public DatiRitenutaTypeModel(IField father){
	
		super(father);
	
		this.TIPO_RITENUTA = new ComplexField(father,"TipoRitenuta",java.lang.String.class,"DatiRitenutaType",DatiRitenutaType.class);
		this.IMPORTO_RITENUTA = new ComplexField(father,"ImportoRitenuta",java.lang.Double.class,"DatiRitenutaType",DatiRitenutaType.class);
		this.ALIQUOTA_RITENUTA = new ComplexField(father,"AliquotaRitenuta",java.lang.Double.class,"DatiRitenutaType",DatiRitenutaType.class);
		this.CAUSALE_PAGAMENTO = new ComplexField(father,"CausalePagamento",java.lang.String.class,"DatiRitenutaType",DatiRitenutaType.class);
	
	}
	
	

	public IField TIPO_RITENUTA = null;
	 
	public IField IMPORTO_RITENUTA = null;
	 
	public IField ALIQUOTA_RITENUTA = null;
	 
	public IField CAUSALE_PAGAMENTO = null;
	 

	@Override
	public Class<DatiRitenutaType> getModeledClass(){
		return DatiRitenutaType.class;
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