/*
 * GovWay - A customizable API Gateway 
 * https://govway.org
 * 
 * Copyright (c) 2005-2020 Link.it srl (https://link.it).
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

import org.openspcoop2.core.monitor.rs.server.model.TipoInformazioneReportEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;

public class TipoInformazioneReportMultiLine  {
  
  @Schema(description = "")
  private TipoInformazioneReportEnum tipo = null;
  
  @Schema(description = "")
  private Object valori = null;
 /**
   * Get tipo
   * @return tipo
  **/
  @JsonProperty("tipo")
  @Valid
  public TipoInformazioneReportEnum getTipo() {
    return this.tipo;
  }

  public void setTipo(TipoInformazioneReportEnum tipo) {
    this.tipo = tipo;
  }

  public TipoInformazioneReportMultiLine tipo(TipoInformazioneReportEnum tipo) {
    this.tipo = tipo;
    return this;
  }

 /**
   * Get valori
   * @return valori
  **/
  @JsonProperty("valori")
  @Valid
  public Object getValori() {
    return this.valori;
  }

  public void setValori(Object valori) {
    this.valori = valori;
  }

  public TipoInformazioneReportMultiLine valori(Object valori) {
    this.valori = valori;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TipoInformazioneReportMultiLine {\n");
    
    sb.append("    tipo: ").append(TipoInformazioneReportMultiLine.toIndentedString(this.tipo)).append("\n");
    sb.append("    valori: ").append(TipoInformazioneReportMultiLine.toIndentedString(this.valori)).append("\n");
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
