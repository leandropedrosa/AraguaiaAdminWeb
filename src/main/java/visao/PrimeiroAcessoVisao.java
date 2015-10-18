/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import enuns.ApartamentoEnum;
import java.util.ArrayList;
import java.util.List;
import modelo.Apartamento;
import modelo.Dependente;
import modelo.Diarista;
import modelo.Garagem;
import modelo.Imobiliaria;
import modelo.Negociacao;
import modelo.Telefone;
import modelo.Titular;
import modelo.Usuario;
import modelo.Veiculo;

/**
 *
 * @author Leandro
 */
public class PrimeiroAcessoVisao {

    private Boolean cadastroTitular;
    private Boolean cadastroDependentes;
    private Boolean cadastroApartamento;
    private Boolean cadastroGaragem;
    private Boolean cadastroVeiculo;
    private Boolean cadastroFinalizar;
    private int etapas = 1;

    private Titular titular;
    private List<Titular> todosTitulares;
    private Telefone telefoneResidencial;
    private Telefone telefoneCelular;
    private Telefone telefoneComercial;
    private Telefone telefoneEmergencia;
    private Telefone telefoneEmergencia2;
    private List<Usuario> todosUsuarios;

    private Apartamento apartamento;
    private List<Apartamento> todosApartamentos;
    private String apartamentoString;
    private Diarista diarista;
    private Imobiliaria imobiliaria;
    private List<String> listaApartamentos;
    private boolean animais;
    private boolean arCondicionado;
    private boolean tvCabo;
    private boolean internet;
    private boolean bicicleta;
    private Float valorVenda;
    private Float valorAluguel;
    private boolean publicar;
    private List<String> tipoNegociacao;
    private String tipoNegociacaoSelecionada;
    private List<Negociacao> listaNegociacao;

    private Dependente dependente;
    private List<Dependente> todosDependentes;

    private Garagem garagem;
    private List<Garagem> todosGaragens;
    private List<String> listaDeNumeros;

    private Veiculo veiculo;
    private List<Veiculo> todosVeiculos;

    public Boolean isCadastroTitular() {
        return cadastroTitular;
    }

    public void setCadastroTitular(Boolean cadastroTitular) {
        this.cadastroTitular = cadastroTitular;
    }

    public Boolean isCadastroDependentes() {
        return cadastroDependentes;
    }

    public void setCadastroDependentes(Boolean cadastroDependentes) {
        this.cadastroDependentes = cadastroDependentes;
    }

    public Boolean isCadastroApartamento() {
        return cadastroApartamento;
    }

    public void setCadastroApartamento(Boolean cadastroApartamento) {
        this.cadastroApartamento = cadastroApartamento;
    }

    public Boolean isCadastroGaragem() {
        return cadastroGaragem;
    }

    public void setCadastroGaragem(Boolean cadastroGaragem) {
        this.cadastroGaragem = cadastroGaragem;
    }

    public Boolean isCadastroVeiculo() {
        return cadastroVeiculo;
    }

    public void setCadastroVeiculo(Boolean cadastroVeiculo) {
        this.cadastroVeiculo = cadastroVeiculo;
    }

    public Boolean isCadastroFinalizar() {
        return cadastroFinalizar;
    }

    public void setCadastroFinalizar(Boolean cadastroFinalizar) {
        this.cadastroFinalizar = cadastroFinalizar;
    }

    public int getEtapas() {
        return etapas;
    }

    public void setEtapas(int etapas) {
        this.etapas = etapas;
    }

    public Titular getTitular() {
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

    public List<Usuario> getTodosUsuarios() {
        return todosUsuarios;
    }

    public void setTodosUsuarios(List<Usuario> todosUsuarios) {
        this.todosUsuarios = todosUsuarios;
    }

    public Telefone getTelefoneResidencial() {
        if (telefoneResidencial == null) {
            telefoneResidencial = new Telefone();
        }

        return telefoneResidencial;
    }

    public void setTelefoneResidencial(Telefone telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public Telefone getTelefoneCelular() {
        if (telefoneCelular == null) {
            telefoneCelular = new Telefone();
        }

        return telefoneCelular;
    }

    public void setTelefoneCelular(Telefone telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public Telefone getTelefoneComercial() {
        if (telefoneComercial == null) {
            telefoneComercial = new Telefone();
        }

        return telefoneComercial;
    }

    public void setTelefoneComercial(Telefone telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public Telefone getTelefoneEmergencia() {
        if (telefoneEmergencia == null) {
            telefoneEmergencia = new Telefone();
        }

        return telefoneEmergencia;
    }

    public void setTelefoneEmergencia(Telefone telefoneEmergencia) {
        this.telefoneEmergencia = telefoneEmergencia;
    }

    public Telefone getTelefoneEmergencia2() {
        if (telefoneEmergencia2 == null) {
            telefoneEmergencia2 = new Telefone();
        }

        return telefoneEmergencia2;
    }

    public void setTelefoneEmergencia2(Telefone telefoneEmergencia2) {
        this.telefoneEmergencia2 = telefoneEmergencia2;
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
            negociacaoVenda.setPublicar(isPublicar() ? "S" : "N");
            getListaNegociacao().add(negociacaoVenda);
        }
        getApartamento().setNegociacaoList(listaNegociacao);
    }

    public void adicionaTelefone() {
        List<Telefone> listaTelefone = new ArrayList<Telefone>();
        if (getTitular().getNome() != null) {
            if (getTelefoneCelular() != null) {
                listaTelefone.add(new Telefone(null, getTelefoneCelular().getNumero(), "C"));
            }
            if (getTelefoneComercial().getNumero() != null) {
                listaTelefone.add(new Telefone(null, getTelefoneComercial().getNumero(), "O"));
            }
            if (getTelefoneEmergencia().getNumero() != null) {
                listaTelefone.add(new Telefone(null, getTelefoneEmergencia().getNumero(), "1"));
            }
            if (getTelefoneEmergencia2().getNumero() != null) {
                listaTelefone.add(new Telefone(null, getTelefoneEmergencia2().getNumero(), "2"));
            }
            if (getTelefoneResidencial().getNumero() != null) {
                listaTelefone.add(new Telefone(null, getTelefoneResidencial().getNumero(), "R"));
            }
            getTitular().setTelefoneList(listaTelefone);
        }
    }

    public String getApartamentoString() {
        return apartamentoString;
    }

    public void setApartamentoString(String apartamentoString) {
        this.apartamentoString = apartamentoString;
    }

    public List<Apartamento> getTodosApartamentos() {
        if (todosApartamentos == null) {
            todosApartamentos = new ArrayList<Apartamento>();
        }

        return todosApartamentos;
    }

    public void setTodosApartamentos(List<Apartamento> todosApartamentos) {
        this.todosApartamentos = todosApartamentos;
    }

    public List<String> getListaApartamentos() {
        if (listaApartamentos == null) {
            listaApartamentos = ApartamentoEnum.getLista();
        }
        return listaApartamentos;
    }

    public void setListaApartamentos(List<String> listaApartamentos) {
        this.listaApartamentos = listaApartamentos;
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

    public Dependente getDependente() {
        if (dependente == null) {
            dependente = new Dependente();
        }

        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public List<Dependente> getTodosDependentes() {
        if (todosDependentes == null) {
            todosDependentes = new ArrayList<Dependente>();
        }

        return todosDependentes;
    }

    public void setTodosDependentes(List<Dependente> todosDependentes) {
        this.todosDependentes = todosDependentes;
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

    public List<Garagem> getTodosGaragens() {
        if (todosGaragens == null) {
            todosGaragens = new ArrayList<Garagem>();
        }

        return todosGaragens;
    }

    public void setTodosGaragens(List<Garagem> todosGaragens) {
        this.todosGaragens = todosGaragens;
    }

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

    public Veiculo getVeiculo() {
        if (veiculo == null) {
            veiculo = new Veiculo();
        }

        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Veiculo> getTodosVeiculos() {
        if (todosVeiculos == null) {
            todosVeiculos = new ArrayList<Veiculo>();
        }

        return todosVeiculos;
    }

    public void setTodosVeiculos(List<Veiculo> todosVeiculos) {
        this.todosVeiculos = todosVeiculos;
    }

}
