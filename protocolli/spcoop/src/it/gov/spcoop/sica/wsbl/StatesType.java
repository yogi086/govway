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
package it.gov.spcoop.sica.wsbl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/** <p>Java class for statesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="statesType">
 * 		&lt;sequence>
 * 			&lt;element name="state-initial" type="{http://spcoop.gov.it/sica/wsbl}StateTypeInitial" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="state-final" type="{http://spcoop.gov.it/sica/wsbl}StateTypeFinal" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="state" type="{http://spcoop.gov.it/sica/wsbl}StateTypeNormal" minOccurs="1" maxOccurs="unbounded"/>
 * 		&lt;/sequence>
 * &lt;/complexType>
 * </pre>
 * 
 * @version $Rev$, $Date$
 * 
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "statesType", 
  propOrder = {
  	"stateInitial",
  	"stateFinal",
  	"state"
  }
)

@XmlRootElement(name = "statesType")

public class StatesType extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable {
  public StatesType() {
  }

  public StateTypeInitial getStateInitial() {
    return this.stateInitial;
  }

  public void setStateInitial(StateTypeInitial stateInitial) {
    this.stateInitial = stateInitial;
  }

  public StateTypeFinal getStateFinal() {
    return this.stateFinal;
  }

  public void setStateFinal(StateTypeFinal stateFinal) {
    this.stateFinal = stateFinal;
  }

  public void addState(StateTypeNormal state) {
    this.state.add(state);
  }

  public StateTypeNormal getState(int index) {
    return this.state.get( index );
  }

  public StateTypeNormal removeState(int index) {
    return this.state.remove( index );
  }

  public List<StateTypeNormal> getStateList() {
    return this.state;
  }

  public void setStateList(List<StateTypeNormal> state) {
    this.state=state;
  }

  public int sizeStateList() {
    return this.state.size();
  }

  private static final long serialVersionUID = 1L;



  @XmlElement(name="state-initial",required=true,nillable=false)
  protected StateTypeInitial stateInitial;

  @XmlElement(name="state-final",required=true,nillable=false)
  protected StateTypeFinal stateFinal;

  @XmlElement(name="state",required=true,nillable=false)
  protected List<StateTypeNormal> state = new ArrayList<StateTypeNormal>();

  /**
   * @deprecated Use method getStateList
   * @return List<StateTypeNormal>
  */
  @Deprecated
  public List<StateTypeNormal> getState() {
  	return this.state;
  }

  /**
   * @deprecated Use method setStateList
   * @param state List<StateTypeNormal>
  */
  @Deprecated
  public void setState(List<StateTypeNormal> state) {
  	this.state=state;
  }

  /**
   * @deprecated Use method sizeStateList
   * @return lunghezza della lista
  */
  @Deprecated
  public int sizeState() {
  	return this.state.size();
  }

}
