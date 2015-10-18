/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name = "encomenda")
@NamedQueries({
    @NamedQuery(name = "Encomenda.findAll", query = "SELECT e FROM Encomenda e")})
@XmlRootElement
public class Encomenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEncomenda")
    private Integer idEncomenda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "situacao")
    private String situacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataChegada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataChegada;
    @Column(name = "dataEntregue")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntregue;
    @JoinColumn(name = "idTitular", referencedColumnName = "idTitular")
    @ManyToOne(optional = false)
    private Titular titular;
    @JoinColumn(name = "idPorteiro", referencedColumnName = "idPorteiro")
    @ManyToOne(optional = false)
    private Porteiro porteiro;

    public Encomenda() {
    }

    public Encomenda(Integer idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public Encomenda(Integer idEncomenda, String descricao, String situacao, Date dataChegada) {
        this.idEncomenda = idEncomenda;
        this.descricao = descricao;
        this.situacao = situacao;
        this.dataChegada = dataChegada;
    }

    public Integer getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(Integer idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Date getDataEntregue() {
        return dataEntregue;
    }

    public void setDataEntregue(Date dataEntregue) {
        this.dataEntregue = dataEntregue;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Porteiro getPorteiro() {
        return porteiro;
    }

    public void setPorteiro(Porteiro porteiro) {
        this.porteiro = porteiro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncomenda != null ? idEncomenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encomenda)) {
            return false;
        }
        Encomenda other = (Encomenda) object;
        if ((this.idEncomenda == null && other.idEncomenda != null) || (this.idEncomenda != null && !this.idEncomenda.equals(other.idEncomenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Encomenda[ idEncomenda=" + idEncomenda + " ]";
    }

}
