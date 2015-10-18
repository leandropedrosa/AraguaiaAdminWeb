/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import enuns.ApartamentoEnum;
import enuns.CamposPesquisa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.Apartamento;
import modelo.Bloco;
import modelo.Diarista;
import modelo.Imobiliaria;
import modelo.Negociacao;
import modelo.Titular;

/**
 *
 * @author Leandro
 */
public class ApartamentoVisao implements Serializable {

    private static final long serialVersionUID = 1L;
    private Apartamento apartamento;
    private String apartamentoString;
    private Diarista diarista;
    private Imobiliaria imobiliaria;
    private Bloco bloco;
    private String blocoString;
    private Titular titular;
    private List<Titular> todosTitulares;
    private List<String> todosApartamentos;
    private boolean animais;
    private boolean arCondicionado;
    private boolean tvCabo;
    private boolean internet;
    private boolean bicicleta;
    private String valorPesquisa;
    private List<String> campos;
    private String valorSelecionado;
    private List<String> tipoNegociacao;
    private String tipoNegociacaoSelecionada;
    private List<Negociacao> listaNegociacao;
    private Float valorVenda;
    private Float valorAluguel;
    private boolean publicar;

    public void obtemValores() {
        getApartamento().setPossuiAnimais(isAnimais() ? "S" : "N");
        getApartamento().setPossuiArCondicionado(isArCondicionado() ? "S" : "N");
        getApartamento().setPossuiBicicleta(isBicicleta() ? "S" : "N");
        getApartamento().setPossuiInternet(isInternet() ? "S" : "N");
        getApartamento().setPossuiTvCabo(isTvCabo() ? "S" : "N");
        getApartamento().setDiarista(!"".equals(getDiarista().getNomeDiarista()) || getDiarista().getNomeDiarista() != null ? getDiarista() : null);
        getApartamento().setImobiliaria(!"".equals(getImobiliaria().getNomeImobiliaria()) || getImobiliaria().getNomeImobiliaria() != null ? getImobiliaria() : null);
        obtemNegociacao();
        getApartamento().setNegociacaoList(!getListaNegociacao().isEmpty() ? getListaNegociacao() : null);
    }

    private void obtemNegociacao() {
        if (getTipoNegociacaoSelecionada() != null && (getTipoNegociacaoSelecionada().equals("Aluguel") || getTipoNegociacaoSelecionada().equals("Ambos"))) {
            Negociacao negociacaoAluguel = new Negociacao();
            negociacaoAluguel.setTipo("A");
            negociacaoAluguel.setValor(getValorAluguel());
            negociacaoAluguel.setPublicar(isPublicar() ? "S" : "N");
            getListaNegociacao().add(negociacaoAluguel);

        }
        if (getTipoNegociacaoSelecionada() != null && (getTipoNegociacaoSelecionada().equals("Venda") || getTipoNegociacaoSelecionada().equals("Ambos"))) {
            Negociacao negociacaoVenda = new Negociacao();
            negociacaoVenda.setTipo("V");
            negociacaoVenda.setValor(getValorVenda());
            getListaNegociacao().add(negociacaoVenda);
        }
    }

    public List<String> getTodosApartamentos() {
        if (todosApartamentos == null) {
            todosApartamentos = ApartamentoEnum.getLista();
        }
        return todosApartamentos;
    }

    public void setTodosApartamentos(List<String> todosApartamentos) {
        this.todosApartamentos = todosApartamentos;
    }

    public boolean isPublicar() {
        return publicar;
    }

    public void setPublicar(boolean publicar) {
        this.publicar = publicar;
    }

    public Float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Float getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Float valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public String getTipoNegociacaoSelecionada() {
        return tipoNegociacaoSelecionada;
    }

    public void setTipoNegociacaoSelecionada(String tipoNegociacaoSelecionada) {
        this.tipoNegociacaoSelecionada = tipoNegociacaoSelecionada;
    }

    public List<String> getTipoNegociacao() {
        if (tipoNegociacao == null) {
            tipoNegociacao = new ArrayList<String>();
            tipoNegociacao.add(new String("Aluguel"));
            tipoNegociacao.add(new String("Venda"));
            tipoNegociacao.add(new String("Ambos"));
        }
        return tipoNegociacao;
    }

    public void setTipoNegociacao(List<String> tipoNegociacao) {
        this.tipoNegociacao = tipoNegociacao;
    }

    public List<Negociacao> getListaNegociacao() {
        if (listaNegociacao == null) {
            listaNegociacao = new ArrayList<Negociacao>();
        }

        return listaNegociacao;
    }

    public void setListaNegociacao(List<Negociacao> listaNegociacao) {
        this.listaNegociacao = listaNegociacao;
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

            campos = CamposPesquisa.camposLista("Apartamento");
        }
        return campos;
    }

    public void setCampos(List<String> campos) {
        this.campos = campos;
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

    public Apartamento getApartamento() {
        if (apartamento == null) {
            apartamento = new Apartamento();
        }
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    public Diarista getDiarista() {
        if (diarista == null) {
            diarista = new Diarista();
        }
        return diarista;
    }

    public void setDiarista(Diarista diarista) {
        this.diarista = diarista;
    }

    public Imobiliaria getImobiliaria() {
        if (imobiliaria == null) {
            imobiliaria = new Imobiliaria();
        }
        return imobiliaria;
    }

    public void setImobiliaria(Imobiliaria imobiliaria) {
        this.imobiliaria = imobiliaria;
    }

    public Bloco getBloco() {
        if (bloco == null) {
            bloco = new Bloco();
        }
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
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

    public String getApartamentoString() {
        return apartamentoString;
    }

    public void setApartamentoString(String apartamentoString) {
        this.apartamentoString = apartamentoString;
    }

    public String getBlocoString() {
        return blocoString;
    }

    public void setBlocoString(String blocoString) {
        this.blocoString = blocoString;
    }

    public boolean isAnimais() {
        return animais;
    }

    public void setAnimais(boolean animais) {
        this.animais = animais;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public boolean isTvCabo() {
        return tvCabo;
    }

    public void setTvCabo(boolean tvCabo) {
        this.tvCabo = tvCabo;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public boolean isBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(boolean bicicleta) {
        this.bicicleta = bicicleta;
    }

}
