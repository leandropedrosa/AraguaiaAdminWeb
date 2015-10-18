/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author Leandro
 */
public class AbstractNegocio {

    public FacesMessage mensagem(String tipo, String titulo, String mensagem) {
        switch (tipo) {
            case "i":
                return new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensagem);
            case "a":
                return new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, mensagem);

            case "e":
                return new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, mensagem);

            case "f":
                return new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, mensagem);

            default:
                return new FacesMessage(FacesMessage.SEVERITY_FATAL, "Você digitou uma operação inválida.", "System Error");
        }
    }

    public void setUsuarioSessao(Usuario usuario) {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("usuario", usuario);
    }

    public void setObjetoSessao(Object objeto, String atributo) {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute(atributo, objeto);
    }

//    public void enviarEmail(String email, String assunto, String corpoDoEmail) {
//        EmailBeanImp emailUtil = new EmailBeanImp();
//        try {
//            emailUtil.sendMessage(email, assunto, corpoDoEmail);
//        } catch (MessagingException ex) {
//            Logger.getLogger(SendMailTLS.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
