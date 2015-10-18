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
@Table(name = "dependente")
@NamedQueries({
    @NamedQuery(name = "Dependente.findAll", query = "SELECT d FROM Dependente d"),
    @NamedQuery(name = "Dependente.findTitulatD", query = "SELECT d FROM Dependente d INNER JOIN d.titular t WHERE t.idTitular = :idTitular ")})
@XmlRootElement
public class Dependente implements Serializable {

    public static final String FIND_BY_TITULAR = "Dependente.findTitulatD";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idDependente")
    private Integer idDependente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "parentesco")
    private String parentesco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtNascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtNascimento;
    @Size(max = 20)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "rg")
    private String rg;
    @JoinColumn(name = "idTitular", referencedColumnName = "idTitular")
    @ManyToOne(optional = false)
    private Titular titular;

    public Dependente() {
    }

    public Dependente(Integer idDependente) {
        this.idDependente = idDependente;
    }

    public Dependente(Integer idDependente, String nome, String parentesco, Date dtNascimento, String rg) {
        this.idDependente = idDependente;
        this.nome = nome;
        this.parentesco = parentesco;
        this.dtNascimento = dtNascimento;
        this.rg = rg;
    }

    public Integer getIdDependente() {
        return idDependente;
    }

    public void setIdDependente(Integer idDependente) {
        this.idDependente = idDependente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDependente != null ? idDependente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependente)) {
            return false;
        }
        Dependente other = (Dependente) object;
        if ((this.idDependente == null && other.idDependente != null) || (this.idDependente != null && !this.idDependente.equals(other.idDependente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Dependente[ idDependente=" + idDependente + " ]";
    }

}
