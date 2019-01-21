package org.openspcoop2.core.config.rs.server.model;

import org.openspcoop2.core.config.rs.server.model.APIImplAutenticazioneNew;
import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GruppoNuovaConfigurazione  {
  
  @Schema(required = true, description = "")
  private APIImplAutenticazioneNew autenticazione = null;
 /**
   * Get autenticazione
   * @return autenticazione
  **/
  @JsonProperty("autenticazione")
  @NotNull
  public APIImplAutenticazioneNew getAutenticazione() {
    return this.autenticazione;
  }

  public void setAutenticazione(APIImplAutenticazioneNew autenticazione) {
    this.autenticazione = autenticazione;
  }

  public GruppoNuovaConfigurazione autenticazione(APIImplAutenticazioneNew autenticazione) {
    this.autenticazione = autenticazione;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GruppoNuovaConfigurazione {\n");
    
    sb.append("    autenticazione: ").append(GruppoNuovaConfigurazione.toIndentedString(this.autenticazione)).append("\n");
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