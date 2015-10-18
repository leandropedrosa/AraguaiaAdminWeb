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
@Table(name = "visitantes")
@NamedQueries({
    @NamedQuery(name = "Visitantes.findAll", query = "SELECT v FROM Visitantes v")})
@XmlRootElement
public class Visitantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idVisitantes")
    private Integer idVisitantes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome")
    private String nome;
    @Size(max = 15)
    @Column(name = "rg")
    private String rg;
    @Size(max = 80)
    @Column(name = "vinculoTitular")
    private String vinculoTitular;
    @Size(max = 1)
    @Column(name = "livreAcesso")
    private String livreAcesso;
    @JoinColumn(name = "idTitular", referencedColumnName = "idTitular")
    @ManyToOne(optional = false)
    private Titular titular;

    public Visitantes() {
    }

    public Visitantes(Integer idVisitantes) {
        this.idVisitantes = idVisitantes;
    }

    public Visitantes(Integer idVisitantes, String nome) {
        this.idVisitantes = idVisitantes;
        this.nome = nome;
    }

    public Integer getIdVisitantes() {
        return idVisitantes;
    }

    public void setIdVisitantes(Integer idVisitantes) {
        this.idVisitantes = idVisitantes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getVinculoTitular() {
        return vinculoTitular;
    }

    public void setVinculoTitular(String vinculoTitular) {
        this.vinculoTitular = vinculoTitular;
    }

    public String getLivreAcesso() {
        return livreAcesso;
    }

    public void setLivreAcesso(String livreAcesso) {
        this.livreAcesso = livreAcesso;
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
        hash += (idVisitantes != null ? idVisitantes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitantes)) {
            return false;
        }
        Visitantes other = (Visitantes) object;
        if ((this.idVisitantes == null && other.idVisitantes != null) || (this.idVisitantes != null && !this.idVisitantes.equals(other.idVisitantes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Visitantes[ idVisitantes=" + idVisitantes + " ]";
    }

}
