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
package org.openspcoop2.core.config.rs.server.model;

import org.openspcoop2.core.config.rs.server.model.RateLimitingPolicyBaseConIdentificazione;
import org.openspcoop2.core.config.rs.server.model.RateLimitingPolicyFiltroErogazione;
import org.openspcoop2.core.config.rs.server.model.RateLimitingPolicyGroupBy;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;

public class RateLimitingPolicyErogazione extends RateLimitingPolicyBaseConIdentificazione {
  
  @Schema(description = "")
  private RateLimitingPolicyFiltroErogazione filtro = null;
  
  @Schema(description = "")
  private RateLimitingPolicyGroupBy raggruppamento = null;
 /**
   * Get filtro
   * @return filtro
  **/
  @JsonProperty("filtro")
  @Valid
  public RateLimitingPolicyFiltroErogazione getFiltro() {
    return this.filtro;
  }

  public void setFiltro(RateLimitingPolicyFiltroErogazione filtro) {
    this.filtro = filtro;
  }

  public RateLimitingPolicyErogazione filtro(RateLimitingPolicyFiltroErogazione filtro) {
    this.filtro = filtro;
    return this;
  }

 /**
   * Get raggruppamento
   * @return raggruppamento
  **/
  @JsonProperty("raggruppamento")
  @Valid
  public RateLimitingPolicyGroupBy getRaggruppamento() {
    return this.raggruppamento;
  }

  public void setRaggruppamento(RateLimitingPolicyGroupBy raggruppamento) {
    this.raggruppamento = raggruppamento;
  }

  public RateLimitingPolicyErogazione raggruppamento(RateLimitingPolicyGroupBy raggruppamento) {
    this.raggruppamento = raggruppamento;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RateLimitingPolicyErogazione {\n");
    sb.append("    ").append(RateLimitingPolicyErogazione.toIndentedString(super.toString())).append("\n");
    sb.append("    filtro: ").append(RateLimitingPolicyErogazione.toIndentedString(this.filtro)).append("\n");
    sb.append("    raggruppamento: ").append(RateLimitingPolicyErogazione.toIndentedString(this.raggruppamento)).append("\n");
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