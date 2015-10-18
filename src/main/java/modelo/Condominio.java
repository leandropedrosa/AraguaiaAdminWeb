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
@Table(name = "condominio")
@NamedQueries({
    @NamedQuery(name = "Condominio.findAll", query = "SELECT c FROM Condominio c")})
@XmlRootElement
public class Condominio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCondominio")
    private Integer idCondominio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "sindico")
    private String sindico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condominio")
    private List<Bloco> blocoList;

    public Condominio() {
    }

    public Condominio(Integer idCondominio) {
        this.idCondominio = idCondominio;
    }

    public Condominio(Integer idCondominio, String nome, String sindico) {
        this.idCondominio = idCondominio;
        this.nome = nome;
        this.sindico = sindico;
    }

    public Integer getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(Integer idCondominio) {
        this.idCondominio = idCondominio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSindico() {
        return sindico;
    }

    public void setSindico(String sindico) {
        this.sindico = sindico;
    }

    @XmlTransient
    public List<Bloco> getBlocoList() {
        return blocoList;
    }

    public void setBlocoList(List<Bloco> blocoList) {
        this.blocoList = blocoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCondominio != null ? idCondominio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condominio)) {
            return false;
        }
        Condominio other = (Condominio) object;
        if ((this.idCondominio == null && other.idCondominio != null) || (this.idCondominio != null && !this.idCondominio.equals(other.idCondominio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Condominio[ idCondominio=" + idCondominio + " ]";
    }

}
