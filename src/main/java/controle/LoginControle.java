/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author Leandro
 */
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Usuario;
import negocio.PrimeiroAcessoFacade;
import negocio.UsuarioNegFacade;
import visao.UsuarioVisao;

@SessionScoped
@ManagedBean(name = "loginControle")
public class LoginControle extends AbstractControle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private UsuarioNegFacade negocio;

    @EJB
    private PrimeiroAcessoFacade primeiroAcessoNeg;

    private UsuarioVisao visao;

    @PostConstruct
    private void iniciar() {
        try {
            if (visao == null) {
                visao = new UsuarioVisao();
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public String doLogar() {
        try {
            Usuario usuario = negocio.validaAntesDeLogar(getVisao().getUsuario());
            if (usuario != null) {
                super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo!", "Bem vindo " + usuario.getNome() + "!!"));
                if (!getUsuarioSessao().getPrimeiroAcesso().equals("S")) {
                    primeiroAcessoNeg.doIniciaSessaoUsuario(usuario);
                    return "/home.xhtml?faces-redirect=true";
                } else {
                    return "/primeiroAcesso.xhtml?faces-redirect=true";
                }
            } else {
                super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_WARN, "Dados incorretos!", "Login ou senha incorretos!!"));
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
        return null;
    }

    public String doSair() {
        setUsuarioSessao(null);
        return "/inicial.xhtml?faces-redirect=true";
    }

    public UsuarioVisao getVisao() {
        return visao;
    }

    public void setVisao(UsuarioVisao visao) {
        this.visao = visao;
    }

}
