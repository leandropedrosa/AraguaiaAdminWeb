/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name = "porteiro")
@NamedQueries({
    @NamedQuery(name = "Porteiro.findAll", query = "SELECT p FROM Porteiro p")})
@XmlRootElement
public class Porteiro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPorteiro")
    private Integer idPorteiro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "porteiro")
    private List<Movimentacao> movimentacaoList;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "porteiro")
    private List<Encomenda> encomendaList;

    public Porteiro() {
    }

    public Porteiro(Integer idPorteiro) {
        this.idPorteiro = idPorteiro;
    }

    public Porteiro(Integer idPorteiro, String nome) {
        this.idPorteiro = idPorteiro;
        this.nome = nome;
    }

    public Integer getIdPorteiro() {
        return idPorteiro;
    }

    public void setIdPorteiro(Integer idPorteiro) {
        this.idPorteiro = idPorteiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Movimentacao> getMovimentacaoList() {
        return movimentacaoList;
    }

    public void setMovimentacaoList(List<Movimentacao> movimentacaoList) {
        this.movimentacaoList = movimentacaoList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Encomenda> getEncomendaList() {
        return encomendaList;
    }

    public void setEncomendaList(List<Encomenda> encomendaList) {
        this.encomendaList = encomendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPorteiro != null ? idPorteiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Porteiro)) {
            return false;
        }
        Porteiro other = (Porteiro) object;
        if ((this.idPorteiro == null && other.idPorteiro != null) || (this.idPorteiro != null && !this.idPorteiro.equals(other.idPorteiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Porteiro[ idPorteiro=" + idPorteiro + " ]";
    }

}
