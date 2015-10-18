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
import modelo.Dependente;
import modelo.Titular;
import negocio.DependenteNegFacade;
import visao.DependenteVisao;

/**
 *
 * @author Leandro
 */
@ViewScoped
@ManagedBean(name = "dependenteControle")
public class DependenteControle extends AbstractControle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private DependenteNegFacade negocio;
    private DependenteVisao visao = null;
    private List<Dependente> todosDependentes;

    @PostConstruct
    private void iniciar() {
        try {
            if (visao == null) {
                visao = new DependenteVisao();
            }
            if (getUsuarioSessao().getPermissao().getTipo().equals("ADMIN") || getUsuarioSessao().getPermissao().getTipo().equals("SINDICO") || getUsuarioSessao().getPermissao().getTipo().equals("PORTEIRO")) {
                if (todosDependentes == null) {
                    todosDependentes = negocio.findAll();
                }
                setUsuarioAdmin(true);
            } else {
                if (getUsuarioSessao().getPermissao().getTipo().equals("TITULAR")) {
                    setTodosDependentes((List<Dependente>) getObjetoSessao("listaDependentes"));
                    getVisao().getDependente().setTitular((Titular) getObjetoSessao("titular"));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void salvar() {
        try {
            setTodosDependentes(null);
            negocio.validaAntesDeSalvar(getVisao().getDependente());
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Dependente cadastrado com sucesso!!"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void excluir() {
        try {
            setTodosDependentes(null);
            String id = retornaParamentros().get("excluir");
            negocio.delete(id);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Dependente excluído com sucesso!!"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void novo() {
        setVisao(null);
        setVisao(new DependenteVisao());
        getVisao().getDependente().setTitular((Titular) getObjetoSessao("titular"));
    }

    public void editar() {
        try {
            String user = retornaParamentros().get("editar");
            Dependente entity = negocio.getById(Integer.parseInt(user));
            getVisao().setDependente(entity);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void cancelar() {
        getVisao().setDependente(null);
    }

    public void pesquisar() {
        try {
            setTodosDependentes(negocio.findSQL(getVisao().getValorPesquisa(), getVisao().getValorSelecionado()));
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

    public DependenteVisao getVisao() {
        return visao;
    }

    public void setVisao(DependenteVisao visao) {
        this.visao = visao;
    }

    public List<Dependente> getTodosDependentes() {
        return todosDependentes;
    }

    public void setTodosDependentes(List<Dependente> todosDependentes) {
        this.todosDependentes = todosDependentes;
    }
}
