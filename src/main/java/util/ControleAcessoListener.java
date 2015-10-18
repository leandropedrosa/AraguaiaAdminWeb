/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controle.AbstractControle;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author Leandro
 */
public class ControleAcessoListener extends AbstractControle implements PhaseListener {

    private static final long serialVersionUID = 9000846487985704196L;

    public ControleAcessoListener() {
    }

    public void afterPhase(PhaseEvent event) {
        try {

            FacesContext context = event.getFacesContext();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);

            if (!context.getViewRoot().getViewId().contains("/login/")) {
                if (!context.getViewRoot().getViewId().contains("inicial")) {
                    Usuario usuario = (Usuario) session.getAttribute("usuario");

                    // can't use this here. only valid at render response phase?  
                    String viewId = context.getViewRoot().getViewId();
                    System.out.println(viewId);

                    if (usuario == null) {
                        System.out.println("desconectado");
                        setUsuarioSessao(null);
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/AraguaiaAdminWeb-1.0/inicial.xhtml?faces-redirect=true");
                    }

                    response.setHeader("Expires", "-1");
                    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidade, proxy-revalidade, private, post-check=0, pre-check=0");
                    response.setHeader("Pragma", "no-cache");
                }
            }
        } catch (Exception e) {
        }
    }

    public void beforePhase(PhaseEvent event) {
    }

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
