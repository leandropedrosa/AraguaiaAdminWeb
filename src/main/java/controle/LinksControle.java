/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import enuns.LinksEnum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.ModuloLinks;

/**
 *
 * @author Leandro
 */
@SessionScoped
@ManagedBean(name = "linksControle")
public class LinksControle extends AbstractControle implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<LinksEnum> links;

    public String showPage() {
        String pageId = retornaParamentros().get("pageId");
        links = null;
        iniciar();
        if (pageId == null) {
            return "/pages/login/login.xhtml?faces-redirect=true";
        } else {
            iniciar();
            if (!verificaPermissao(pageId)) {
                super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_WARN, "Sem permissão!", "Usuário sem permissão para essa operação!!"));
                return "/home.xhtml?faces-redirect=true";
            }
            return "/pages/" + pageId + ".xhtml?faces-redirect=true";
        }
    }

    @PostConstruct
    private void iniciar() {
        try {
            if (links == null && getUsuarioSessao() != null) {
                links = new ArrayList<LinksEnum>();
                links.addAll(getLinksCadastro());
                links.addAll(getLinksResevar());
                links.addAll(getLinksFinanceiro());
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    private boolean verificaPermissao(String link) {
        if (link.contains("login")) {
            return true;
        }
        LinksEnum linkEnun = LinksEnum.retornaLink(link);
        if (!getLinks().contains(linkEnun) && linkEnun.getModulo().equals("Cadastros")) {
            return false;
        }
        if (!getLinks().contains(linkEnun) && linkEnun.getModulo().equals("Reservar")) {
            return false;
        }
        if (!getLinks().contains(linkEnun) && linkEnun.getModulo().equals("Financeiro")) {
            return false;
        }
        if (!getLinks().contains(linkEnun) && linkEnun.getModulo().equals("Home")) {
            return false;
        }
        return true;
    }

    public List<LinksEnum> getLinksCadastro() {
        return new ModuloLinks("Cadastros", getUsuarioSessao().getPermissao().getIdPermissao()).retornaMenuPermissao();
    }

    public List<LinksEnum> getLinksResevar() {
        return new ModuloLinks("Reservar", getUsuarioSessao().getPermissao().getIdPermissao()).retornaMenuPermissao();
    }

    public List<LinksEnum> getLinksFinanceiro() {
        return new ModuloLinks("Financeiro", getUsuarioSessao().getPermissao().getIdPermissao()).retornaMenuPermissao();
    }

    public int getQuantCadastro() {
        return new ModuloLinks("Cadastros", getUsuarioSessao().getPermissao().getIdPermissao()).retornaQuantidade();
    }

    public int getQuantResevar() {
        return new ModuloLinks("Reservar", getUsuarioSessao().getPermissao().getIdPermissao()).retornaQuantidade();
    }

    public int getQuantFinanceiro() {
        return new ModuloLinks("Financeiro", getUsuarioSessao().getPermissao().getIdPermissao()).retornaQuantidade();
    }

    public int getQuantHome() {
        return new ModuloLinks("Home", getUsuarioSessao().getPermissao().getIdPermissao()).retornaQuantidade();
    }

    public List<LinksEnum> getLinks() {
        return links;
    }

    public void setLinks(List<LinksEnum> links) {
        this.links = links;
    }

}
