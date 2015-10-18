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
@Table(name = "cobertura")
@NamedQueries({
    @NamedQuery(name = "Cobertura.findAll", query = "SELECT c FROM Cobertura c")})
@XmlRootElement
public class Cobertura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCobertura")
    private Integer idCobertura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cobertura")
    private List<Garagem> garagemList;

    public Cobertura() {
    }

    public Cobertura(Integer idCobertura) {
        this.idCobertura = idCobertura;
    }

    public Cobertura(Integer idCobertura, String tipo) {
        this.idCobertura = idCobertura;
        this.tipo = tipo;
    }

    public Integer getIdCobertura() {
        return idCobertura;
    }

    public void setIdCobertura(Integer idCobertura) {
        this.idCobertura = idCobertura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Garagem> getGaragemList() {
        return garagemList;
    }

    public void setGaragemList(List<Garagem> garagemList) {
        this.garagemList = garagemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCobertura != null ? idCobertura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cobertura)) {
            return false;
        }
        Cobertura other = (Cobertura) object;
        if ((this.idCobertura == null && other.idCobertura != null) || (this.idCobertura != null && !this.idCobertura.equals(other.idCobertura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cobertura[ idCobertura=" + idCobertura + " ]";
    }

}
