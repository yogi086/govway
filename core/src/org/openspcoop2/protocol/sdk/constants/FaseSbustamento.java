/*
 * OpenSPCoop - Customizable API Gateway 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2016 Link.it srl (http://link.it). 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
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


package org.openspcoop2.protocol.sdk.constants;

import java.io.Serializable;

/**
 * Contiene fasi di elaborazione della Pdd
 *
 * @author apoli@link.it
 * @author $Author: apoli $
 * @version $Rev: 12237 $, $Date: 2016-10-04 11:41:45 +0200 (Tue, 04 Oct 2016) $
 */

public enum FaseSbustamento implements Serializable {
	
	PRE_INVIO_RICHIESTA_PER_RIFERIMENTO, // ricezioneContenutiApplicativi invio della richiesta
	
	POST_VALIDAZIONE_SEMANTICA_RICHIESTA, // ricezioneBuste
	PRE_CONSEGNA_RICHIESTA, // connettore
	
	POST_VALIDAZIONE_SEMANTICA_RISPOSTA, // inoltroBuste
	PRE_CONSEGNA_RISPOSTA, // teoricamente sul servizio ricezioneContenutiApplicativi, in pratica su inoltroBuste
	
	POST_CONSEGNA_RISPOSTA_NEW_CONNECTION; // inoltroRisposte
	
}
