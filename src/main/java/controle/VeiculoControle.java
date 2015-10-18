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
import modelo.Titular;
import modelo.Veiculo;
import negocio.VeiculoNegFacade;
import visao.VeiculoVisao;

/**
 *
 * @author Leandro
 */
@ViewScoped
@ManagedBean(name = "veiculoControle")
public class VeiculoControle extends AbstractControle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private VeiculoNegFacade negocio;
    private VeiculoVisao visao = null;
    private List<Veiculo> todosVeiculos;
    private List<Titular> todosTitulares;

    @PostConstruct
    private void iniciar() {
        try {
            if (visao == null) {
                visao = new VeiculoVisao();
            }
            if (getUsuarioSessao().getPermissao().getTipo().equals("ADMIN") || getUsuarioSessao().getPermissao().getTipo().equals("SINDICO") || getUsuarioSessao().getPermissao().getTipo().equals("PORTEIRO")) {
                if (todosVeiculos == null) {
                    todosVeiculos = negocio.findAll();
                }
                if (todosTitulares == null) {
                    todosTitulares = negocio.findAllTitular();
                }
                setUsuarioAdmin(true);
            } else {
                if (getUsuarioSessao().getPermissao().getTipo().equals("TITULAR")) {
                    setTodosVeiculos((List<Veiculo>) getObjetoSessao("listaVeiculos"));
                    getVisao().getVeiculo().setTitular((Titular) getObjetoSessao("titular"));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void salvar() {
        try {
            setTodosVeiculos(null);
            negocio.validaAntesDeSalvar(getVisao().getVeiculo());
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Veículo cadastrado com sucesso!!"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void excluir() {
        try {
            setTodosVeiculos(null);
            String id = retornaParamentros().get("excluir");
            negocio.delete(id);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Veículo excluído com sucesso!!"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void novo() {
        setVisao(null);
        setVisao(new VeiculoVisao());
        getVisao().getVeiculo().setTitular((Titular) getObjetoSessao("titular"));
    }

    public void editar() {
        try {
            String user = retornaParamentros().get("editar");
            Veiculo entity = negocio.getById(Integer.parseInt(user));
            getVisao().setVeiculo(entity);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void cancelar() {
        getVisao().setVeiculo(null);
    }

    public void pesquisar() {
        try {
            setTodosVeiculos(negocio.findSQL(getVisao().getValorPesquisa(), getVisao().getValorSelecionado()));
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
        List<Titular> filteredThemes = new ArrayList<Titular>();
        try {
            if (getVisao().getTodosTitulares().isEmpty()) {
                getVisao().setTodosTitulares(negocio.findAllTitular());
            }
            for (Titular item : getVisao().getTodosTitulares()) {
                if (item.getNome().contains(query)) {
                    filteredThemes.add(item);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
        return filteredThemes;
    }

    public VeiculoVisao getVisao() {

        return visao;
    }

    public void setVisao(VeiculoVisao visao) {
        this.visao = visao;
    }

    public List<Veiculo> getTodosVeiculos() {
        return todosVeiculos;
    }

    public void setTodosVeiculos(List<Veiculo> todosVeiculos) {
        this.todosVeiculos = todosVeiculos;
    }

    public List<Titular> getTodosTitulares() {

        return todosTitulares;
    }

    public void setTodosTitulares(List<Titular> todosTitulares) {
        this.todosTitulares = todosTitulares;
    }

}
