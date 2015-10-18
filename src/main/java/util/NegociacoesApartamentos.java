/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leandro
 */
@Entity
@XmlRootElement
public class NegociacoesApartamentos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idNegociacao")
    private Integer idNegociacao;
    @Column(name = "tipoNegociacao")
    private String tipoNegociacao;
    @Column(name = "valorNegociacao")
    private Float valorNegociacao;
    @Column(name = "quantidadeDeQuartos")
    private Integer quantidadeDeQuartos;
    @Column(name = "titularEmail")
    private String titularEmail;
    @Column(name = "titularNome")
    private String titularNome;
    @Column(name = "telefoneNumero")
    private String telefoneNumero;
    @Column(name = "apartamentoNumero")
    private String apartamentoNumero;

    public Integer getIdNegociacao() {
        return idNegociacao;
    }

    public void setIdNegociacao(Integer idNegociacao) {
        this.idNegociacao = idNegociacao;
    }

    public String getTipoNegociacao() {
        return tipoNegociacao;
    }

    public void setTipoNegociacao(String tipoNegociacao) {
        this.tipoNegociacao = tipoNegociacao;
    }

    public Float getValorNegociacao() {
        return valorNegociacao;
    }

    public void setValorNegociacao(Float valorNegociacao) {
        this.valorNegociacao = valorNegociacao;
    }

    public Integer getQuantidadeDeQuartos() {
        return quantidadeDeQuartos;
    }

    public void setQuantidadeDeQuartos(Integer quantidadeDeQuartos) {
        this.quantidadeDeQuartos = quantidadeDeQuartos;
    }

    public String getTitularEmail() {
        return titularEmail;
    }

    public void setTitularEmail(String titularEmail) {
        this.titularEmail = titularEmail;
    }

    public String getTitularNome() {
        return titularNome;
    }

    public void setTitularNome(String titularNome) {
        this.titularNome = titularNome;
    }

    public String getTelefoneNumero() {
        return telefoneNumero;
    }

    public void setTelefoneNumero(String telefoneNumero) {
        this.telefoneNumero = telefoneNumero;
    }

    public String getApartamentoNumero() {
        return apartamentoNumero;
    }

    public void setApartamentoNumero(String apartamentoNumero) {
        this.apartamentoNumero = apartamentoNumero;
    }

}
