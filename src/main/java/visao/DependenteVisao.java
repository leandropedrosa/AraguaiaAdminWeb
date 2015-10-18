/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import enuns.CamposPesquisa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.Dependente;
import modelo.Titular;

/**
 *
 * @author Leandro
 */
public class DependenteVisao implements Serializable {

    private static final long serialVersionUID = 1L;
    private Dependente dependente;
    private Titular titular;
    private List<Titular> todosTitulares;
    private String valorPesquisa;
    private List<String> campos;
    private String valorSelecionado;

    public String getValorSelecionado() {
        return valorSelecionado;
    }

    public void setValorSelecionado(String valorSelecionado) {
        this.valorSelecionado = valorSelecionado;
    }

    public String getValorPesquisa() {
        return valorPesquisa;
    }

    public void setValorPesquisa(String valorPesquisa) {
        this.valorPesquisa = valorPesquisa;
    }

    public List<String> getCampos() {
        if (campos == null) {

            campos = CamposPesquisa.camposLista("Dependente");
        }
        return campos;
    }

    public Titular getTitular() {
        if (titular == null) {
            titular = new Titular();
        }
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public List<Titular> getTodosTitulares() {
        if (todosTitulares == null) {
            todosTitulares = new ArrayList<Titular>();
        }
        return todosTitulares;
    }

    public void setTodosTitulares(List<Titular> todosTitulares) {
        this.todosTitulares = todosTitulares;
    }

    public Dependente getDependente() {
        if (dependente == null) {
            dependente = new Dependente();
        }
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

}
