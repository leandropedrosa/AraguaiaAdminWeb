/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import modelo.Garagem;
import modelo.Titular;
import negocio.GaragemNegFacade;
import visao.GaragemVisao;

/**
 *
 * @author Leandro
 */
@ViewScoped
@ManagedBean(name = "garagemControle")
public class GaragemControle extends AbstractControle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private GaragemNegFacade negocio;
    private GaragemVisao visao = null;
    private List<Garagem> todosGaragems;
    private List<Titular> todosTitulares;

    @PostConstruct
    private void iniciar() {
        try {
            if (visao == null) {
                visao = new GaragemVisao();
            }
            if (getUsuarioSessao().getPermissao().getTipo().equals("ADMIN") || getUsuarioSessao().getPermissao().getTipo().equals("SINDICO") || getUsuarioSessao().getPermissao().getTipo().equals("PORTEIRO")) {
                if (todosGaragems == null) {
                    todosGaragems = negocio.findAll();
                }
                if (todosTitulares == null) {
                    todosTitulares = negocio.findAllTitular();
                }
                setUsuarioAdmin(true);
            } else {
                if (getUsuarioSessao().getPermissao().getTipo().equals("TITULAR")) {
                    setTodosGaragems((List<Garagem>) getObjetoSessao("listaGaragens"));
                    getVisao().getGaragem().setTitular((Titular) getObjetoSessao("titular"));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void salvar() {
        try {
            setTodosGaragems(null);
            negocio.validaAntesDeSalvar(getVisao().getGaragem());
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Garagem cadastrada com sucesso!!"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void excluir() {
        try {
            setTodosGaragems(null);
            String id = retornaParamentros().get("excluir");
            negocio.delete(id);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Garagem excluída com sucesso!!"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void novo() {
        setVisao(null);
        setVisao(new GaragemVisao());
        getVisao().getGaragem().setTitular((Titular) getObjetoSessao("titular"));
    }

    public void editar() {
        try {
            String user = retornaParamentros().get("editar");
            Garagem entity = negocio.getById(Integer.parseInt(user));
            getVisao().setGaragem(entity);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void cancelar() {
        getVisao().setGaragem(null);
    }

    public void pesquisar() {
        try {
            setTodosGaragems(negocio.findSQL(getVisao().getValorPesquisa(), getVisao().getValorSelecionado()));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void fireSelection(ValueChangeEvent event) {
        System.out.println("New: " + event.getNewValue() + ", Old: " + event.getOldValue());
        getVisao().setValorSelecionado((String) event.getNewValue());
    }

    public List<Titular> completeTitular(String query) {
        try {
            List<Titular> filteredThemes = new ArrayList<Titular>();
            if (getVisao().getTodosTitulares().isEmpty()) {
                getVisao().setTodosTitulares(negocio.findAllTitular());
            }
            for (Titular item : getVisao().getTodosTitulares()) {
                if (item.getNome().contains(query)) {
                    filteredThemes.add(item);
                }
            }
            return filteredThemes;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
        return null;
    }

    public GaragemVisao getVisao() {
        return visao;
    }

    public void setVisao(GaragemVisao visao) {
        this.visao = visao;
    }

    public List<Garagem> getTodosGaragems() {
        return todosGaragems;
    }

    public void setTodosGaragems(List<Garagem> todosGaragems) {
        this.todosGaragems = todosGaragems;
    }

    public List<Titular> getTodosTitulares() {

        return todosTitulares;
    }

    public void setTodosTitulares(List<Titular> todosTitulares) {
        this.todosTitulares = todosTitulares;
    }
}
