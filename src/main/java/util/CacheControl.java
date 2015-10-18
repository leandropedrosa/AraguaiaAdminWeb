/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leandro
 */

public class CacheControl implements PhaseListener {

    private static final long serialVersionUID = 1L;

    public PhaseId getPhaseId() {

        return PhaseId.RENDER_RESPONSE;

    }

    public void afterPhase(PhaseEvent event) {

    }

    public void beforePhase(PhaseEvent event) {

        FacesContext facesContext = event.getFacesContext();

        HttpServletResponse response = (HttpServletResponse) facesContext
                .getExternalContext().getResponse();

        response.addHeader("Pragma", "no-cache");

        response.addHeader("Cache-Control", "no-cache");

        response.addHeader("Cache-Control", "no-store");

        response.addHeader("Cache-Control", "must-revalidate");

        response.addHeader("Expires", "Mon, 8 Aug 2006 10:00:00 GMT");

    }

}
