/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Usuario;

/**
 *
 * @author Leandro
 */
@SessionScoped
@ManagedBean(name = "principalControle")
public class PrincipalControle extends AbstractControle implements Serializable {

    private static final long serialVersionUID = 1L;
    private Usuario usuarioLogado;
    private Boolean logado;

    @PostConstruct
    private void iniciar() {
    }

    public Usuario getUsuarioLogado() {
        if (usuarioLogado == null) {
            usuarioLogado = getUsuarioSessao();
            if (usuarioLogado == null) {
                usuarioLogado = new Usuario();
            }
        }
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public Boolean getLogado() {
        logado = getUsuarioSessao() != null;
        return logado;
    }

    public void setLogado(Boolean logado) {
        this.logado = logado;
    }

}
