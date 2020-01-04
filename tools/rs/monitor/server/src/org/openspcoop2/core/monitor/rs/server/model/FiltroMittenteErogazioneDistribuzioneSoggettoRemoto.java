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
package org.openspcoop2.core.monitor.rs.server.model;

import io.swagger.v3.oas.annotations.media.Schema;
import org.openspcoop2.core.monitor.rs.server.model.TipoFiltroMittenteErogazioneSoggettoRemotoEnum;
import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.Valid;

/**
  * Descrive le informazioni di filtraggio relative al mittente per la ricerca di transazioni relative ad erogazioni di servizio
 **/
@Schema(description="Descrive le informazioni di filtraggio relative al mittente per la ricerca di transazioni relative ad erogazioni di servizio")
public class FiltroMittenteErogazioneDistribuzioneSoggettoRemoto  {
  
  @Schema(description = "")
  private TipoFiltroMittenteErogazioneSoggettoRemotoEnum tipo = null;
  
  @Schema(description = "")
  private Object id = null;
 /**
   * Get tipo
   * @return tipo
  **/
  @JsonProperty("tipo")
  @Valid
  public TipoFiltroMittenteErogazioneSoggettoRemotoEnum getTipo() {
    return tipo;
  }

  public void setTipo(TipoFiltroMittenteErogazioneSoggettoRemotoEnum tipo) {
    this.tipo = tipo;
  }

  public FiltroMittenteErogazioneDistribuzioneSoggettoRemoto tipo(TipoFiltroMittenteErogazioneSoggettoRemotoEnum tipo) {
    this.tipo = tipo;
    return this;
  }

 /**
   * Get id
   * @return id
  **/
  @JsonProperty("id")
  @Valid
  public Object getId() {
    return id;
  }

  public void setId(Object id) {
    this.id = id;
  }

  public FiltroMittenteErogazioneDistribuzioneSoggettoRemoto id(Object id) {
    this.id = id;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FiltroMittenteErogazioneDistribuzioneSoggettoRemoto {\n");
    
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
