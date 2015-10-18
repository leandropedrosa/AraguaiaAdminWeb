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
@Table(name = "solicitacao")
@NamedQueries({
    @NamedQuery(name = "Solicitacao.findAll", query = "SELECT s FROM Solicitacao s")})
@XmlRootElement
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idSolicitacao")
    private Integer idSolicitacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "situacao")
    private String situacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataCriacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Column(name = "dataTermino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTermino;
    @JoinColumn(name = "idTitular", referencedColumnName = "idTitular")
    @ManyToOne(optional = false)
    private Titular titular;
    @JoinColumn(name = "idZelador", referencedColumnName = "idZelador")
    @ManyToOne(optional = false)
    private Zelador zelador;

    public Solicitacao() {
    }

    public Solicitacao(Integer idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public Solicitacao(Integer idSolicitacao, String situacao, String descricao, Date dataCriacao) {
        this.idSolicitacao = idSolicitacao;
        this.situacao = situacao;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
    }

    public Integer getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(Integer idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Zelador getZelador() {
        return zelador;
    }

    public void setZelador(Zelador zelador) {
        this.zelador = zelador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitacao != null ? idSolicitacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitacao)) {
            return false;
        }
        Solicitacao other = (Solicitacao) object;
        if ((this.idSolicitacao == null && other.idSolicitacao != null) || (this.idSolicitacao != null && !this.idSolicitacao.equals(other.idSolicitacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Solicitacao[ idSolicitacao=" + idSolicitacao + " ]";
    }

}
