/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import enuns.ApartamentoEnum;
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
import modelo.Apartamento;
import modelo.Titular;
import negocio.ApartamentoNegFacade;
import visao.ApartamentoVisao;

/**
 *
 * @author Leandro
 */
@ViewScoped
@ManagedBean(name = "apartamentoControle")
public class ApartamentoControle extends AbstractControle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private ApartamentoNegFacade negocio;

    private ApartamentoVisao visao = null;
    private List<Apartamento> todosApartamento;
    private List<Titular> todosTitulares;

    @PostConstruct
    private void iniciar() {
        try {
            if (visao == null) {
                visao = new ApartamentoVisao();
            }
            if (getUsuarioSessao().getPermissao().getTipo().equals("ADMIN") || getUsuarioSessao().getPermissao().getTipo().equals("SINDICO") || getUsuarioSessao().getPermissao().getTipo().equals("PORTEIRO")) {
                setUsuarioAdmin(true);
                if (todosApartamento == null) {
                    todosApartamento = negocio.findAll();
                }
                if (todosTitulares == null) {
                    todosTitulares = negocio.findAllTitular();
                }
            } else {
                if (getUsuarioSessao().getPermissao().getTipo().equals("TITULAR")) {
                    setTodosApartamento((List<Apartamento>) getObjetoSessao("listaApartamentos"));
                    getVisao().getApartamento().setTitular((Titular) getObjetoSessao("titular"));
                    getVisao().getApartamento().setSituacao("O");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void salvar() {
        try {
            getVisao().obtemValores();
            negocio.validaAntesDeSalvar(getVisao().getApartamento());
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Apartamento cadastrado com sucesso!!"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void novo() {
        setVisao(null);
        setVisao(new ApartamentoVisao());
        getVisao().getApartamento().setTitular((Titular) getObjetoSessao("titular"));
        getVisao().getApartamento().setSituacao("O");
    }

    public void editar() {
        try {
            String ap = retornaParamentros().get("editar");
            Apartamento entity = negocio.getById(Integer.parseInt(ap));
            getVisao().setApartamento(entity);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void cancelar() {
        getVisao().setApartamento(null);
    }

    public void inativar() {
        try {
            String ap = retornaParamentros().get("inativar");
            getVisao().setApartamento(null);
            negocio.inativar(ap);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Apartamento inativado com sucesso!!"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void pesquisar() {
        try {
            setTodosApartamento(negocio.findSQL(getVisao().getValorPesquisa(), getVisao().getValorSelecionado()));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void selecionarTitular(ValueChangeEvent event) {
        getVisao().getApartamento().setTitular((Titular) event.getNewValue());
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

    public List<String> completeApartamento(String query) {
        List<String> results = new ArrayList<String>();
        for (String item : ApartamentoEnum.getLista()) {
            if (item.contains(query)) {
                results.add(item);
            }
        }
        return results;
    }

    public ApartamentoVisao getVisao() {
        return visao;
    }

    public void setVisao(ApartamentoVisao visao) {
        this.visao = visao;
    }

    public List<Apartamento> getTodosApartamento() {
        return todosApartamento;
    }

    public void setTodosApartamento(List<Apartamento> todosApartamento) {
        this.todosApartamento = todosApartamento;
    }

    public List<Titular> getTodosTitulares() {
        return todosTitulares;
    }

    public void setTodosTitulares(List<Titular> todosTitulares) {
        this.todosTitulares = todosTitulares;
    }

}
