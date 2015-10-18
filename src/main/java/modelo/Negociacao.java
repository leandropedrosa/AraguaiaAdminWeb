/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name = "negociacao")
@NamedQueries({
    @NamedQuery(name = "Negociacao.findAll", query = "SELECT n FROM Negociacao n"),
    @NamedQuery(name = "Negociacao.findApartamentoAll", query = "SELECT n FROM Negociacao n inner join n.apartamento a WHERE a.idApartamento = :idApartamento")})
@XmlRootElement
public class Negociacao implements Serializable {

    public static final String FIND_BY_APARTAEMNTO = "Negociacao.findApartamentoAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idNegociacao")
    private Integer idNegociacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private Float valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "publicar")
    private String publicar;
    @JoinColumn(name = "idApartamento", referencedColumnName = "idApartamento")
    @ManyToOne(optional = false)
    private Apartamento apartamento;

    public Negociacao() {
    }

    public Negociacao(Integer idNegociacao) {
        this.idNegociacao = idNegociacao;
    }

    public Negociacao(Integer idNegociacao, String tipo, float valor, String publicar) {
        this.idNegociacao = idNegociacao;
        this.tipo = tipo;
        this.valor = valor;
        this.publicar = publicar;
    }

    public Integer getIdNegociacao() {
        return idNegociacao;
    }

    public void setIdNegociacao(Integer idNegociacao) {
        this.idNegociacao = idNegociacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getPublicar() {
        return publicar;
    }

    public void setPublicar(String publicar) {
        this.publicar = publicar;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNegociacao != null ? idNegociacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Negociacao)) {
            return false;
        }
        Negociacao other = (Negociacao) object;
        if ((this.idNegociacao == null && other.idNegociacao != null) || (this.idNegociacao != null && !this.idNegociacao.equals(other.idNegociacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Negociacao[ idNegociacao=" + idNegociacao + " ]";
    }

}
