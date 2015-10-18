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
import modelo.Cobertura;
import modelo.Garagem;
import modelo.Titular;

/**
 *
 * @author Leandro
 */
public class GaragemVisao implements Serializable {

    private static final long serialVersionUID = 1L;
    private Titular titular;
    private Garagem garagem;
    private Cobertura cobertura;
    private List<Titular> todosTitulares;
    private String valorPesquisa;
    private List<String> campos;
    private String valorSelecionado;
    private List<String> listaDeNumeros;

    public List<String> getListaDeNumeros() {
        if (listaDeNumeros == null) {
            listaDeNumeros = new ArrayList<String>();
            Integer x = 1;
            while (x < 298) {
                listaDeNumeros.add(x.toString());
                x++;
            }
        }
        return listaDeNumeros;
    }

    public void setListaDeNumeros(List<String> listaDeNumeros) {
        this.listaDeNumeros = listaDeNumeros;
    }

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

            campos = CamposPesquisa.camposLista("Garagem");
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

    public Garagem getGaragem() {
        if (garagem == null) {
            garagem = new Garagem();
        }
        return garagem;
    }

    public void setGaragem(Garagem garagem) {
        this.garagem = garagem;
    }

    public Cobertura getCobertura() {
        if (cobertura == null) {
            cobertura = new Cobertura();
        }
        return cobertura;
    }

    public void setCobertura(Cobertura cobertura) {
        this.cobertura = cobertura;
    }

}
