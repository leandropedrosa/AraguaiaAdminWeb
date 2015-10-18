/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import enuns.ApartamentoEnum;
import enuns.BlocoEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Permissao;
import modelo.Usuario;

/**
 *
 * @author Leandro
 */
public class AbstractControle {

    private List<String> blocos;
    private List<String> apartamentos;
    private Permissao PermissaoSelecionada;
    private boolean usuarioAdmin = false;
    private boolean usuarioTitular = false;

    public void mensagem(String tipo, String titulo, String mensagem) {
        switch (tipo) {
            case "i":
                intanciaCorrente().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensagem));
                break;

            case "a":
                intanciaCorrente().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, mensagem));
                break;

            case "e":
                intanciaCorrente().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, mensagem));
                break;

            case "f":
                intanciaCorrente().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, mensagem));
                break;

            default:
                intanciaCorrente().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Você digitou uma operação inválida.", "System Error"));
                break;
        }
    }

    public void exibirMensagem(FacesMessage mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, mensagem);
    }

    public void setUsuarioSessao(Usuario usuario) {
        HttpSession session = (HttpSession) intanciaCorrente().getExternalContext().getSession(false);
        session.setAttribute("usuario", usuario);
    }

    public Usuario getUsuarioSessao() {
        HttpSession session = (HttpSession) intanciaCorrente().getExternalContext().getSession(false);
        return (Usuario) session.getAttribute("usuario");
    }

    public Object getObjetoSessao(String atributo) {
        HttpSession session = (HttpSession) intanciaCorrente().getExternalContext().getSession(false);
        return (Object) session.getAttribute(atributo);
    }

    public void setObjetoSessao(Object objeto, String atributo) {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute(atributo, objeto);
    }

    public List<String> getBlocos() {
        if (blocos == null) {
            blocos = new ArrayList<String>();
            blocos.addAll(BlocoEnum.getLista());
        }
        return blocos;
    }

    public void setBlocos(List<String> blocos) {
        this.blocos = blocos;
    }

    public List<String> getApartamentos() {
        if (apartamentos == null) {
            apartamentos = new ArrayList<String>();
            apartamentos.addAll(ApartamentoEnum.getLista());
        }
        return apartamentos;
    }

    public void setApartamentos(List<String> apartamentos) {
        this.apartamentos = apartamentos;
    }

    public Map<String, String> retornaParamentros() {
        return intanciaCorrente().getExternalContext().getRequestParameterMap();
    }

    public Permissao getPermissaoSelecionada() {
        return PermissaoSelecionada;
    }

    public void setPermissaoSelecionada(Permissao PermissaoSelecionada) {
        this.PermissaoSelecionada = PermissaoSelecionada;
    }

    public FacesContext intanciaCorrente() {
        return FacesContext.getCurrentInstance();
    }

    public boolean isUsuarioAdmin() {
        return usuarioAdmin;
    }

    public void setUsuarioAdmin(boolean usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

    public boolean isUsuarioTitular() {
        return usuarioTitular;
    }

    public void setUsuarioTitular(boolean usuarioTitular) {
        this.usuarioTitular = usuarioTitular;
    }
}
