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
package org.openspcoop2.core.config.rs.server.model;

import org.openspcoop2.core.config.rs.server.model.APIImplAutenticazione;
import org.openspcoop2.core.config.rs.server.model.ApiImplConfigurazioneStato;
import org.openspcoop2.core.config.rs.server.model.ControlloAccessiAutenticazioneToken;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;

public class ControlloAccessiAutenticazione extends ApiImplConfigurazioneStato {
  
  @Schema(description = "")
  private APIImplAutenticazione autenticazione = null;
  
  @Schema(description = "")
  private ControlloAccessiAutenticazioneToken token = null;
 /**
   * Get autenticazione
   * @return autenticazione
  **/
  @JsonProperty("autenticazione")
  @Valid
  public APIImplAutenticazione getAutenticazione() {
    return this.autenticazione;
  }

  public void setAutenticazione(APIImplAutenticazione autenticazione) {
    this.autenticazione = autenticazione;
  }

  public ControlloAccessiAutenticazione autenticazione(APIImplAutenticazione autenticazione) {
    this.autenticazione = autenticazione;
    return this;
  }

 /**
   * Get token
   * @return token
  **/
  @JsonProperty("token")
  @Valid
  public ControlloAccessiAutenticazioneToken getToken() {
    return this.token;
  }

  public void setToken(ControlloAccessiAutenticazioneToken token) {
    this.token = token;
  }

  public ControlloAccessiAutenticazione token(ControlloAccessiAutenticazioneToken token) {
    this.token = token;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ControlloAccessiAutenticazione {\n");
    sb.append("    ").append(ControlloAccessiAutenticazione.toIndentedString(super.toString())).append("\n");
    sb.append("    autenticazione: ").append(ControlloAccessiAutenticazione.toIndentedString(this.autenticazione)).append("\n");
    sb.append("    token: ").append(ControlloAccessiAutenticazione.toIndentedString(this.token)).append("\n");
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
