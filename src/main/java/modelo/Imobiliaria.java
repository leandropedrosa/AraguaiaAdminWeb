/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "imobiliaria")
@NamedQueries({
    @NamedQuery(name = "Imobiliaria.findAll", query = "SELECT i FROM Imobiliaria i")
})
@XmlRootElement
public class Imobiliaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idImobiliaria")
    private Integer idImobiliaria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nomeImobiliaria")
    private String nomeImobiliaria;
    @Size(max = 20)
    @Column(name = "telefoneImobiliaria")
    private String telefoneImobiliaria;
    @OneToMany(mappedBy = "imobiliaria")
    private List<Apartamento> apartamentoList;

    public Imobiliaria() {
    }

    public Imobiliaria(Integer idImobiliaria) {
        this.idImobiliaria = idImobiliaria;
    }

    public Imobiliaria(Integer idImobiliaria, String nomeImobiliaria) {
        this.idImobiliaria = idImobiliaria;
        this.nomeImobiliaria = nomeImobiliaria;
    }

    public Integer getIdImobiliaria() {
        return idImobiliaria;
    }

    public void setIdImobiliaria(Integer idImobiliaria) {
        this.idImobiliaria = idImobiliaria;
    }

    public String getNomeImobiliaria() {
        return nomeImobiliaria;
    }

    public void setNomeImobiliaria(String nomeImobiliaria) {
        this.nomeImobiliaria = nomeImobiliaria;
    }

    public String getTelefoneImobiliaria() {
        return telefoneImobiliaria;
    }

    public void setTelefoneImobiliaria(String telefoneImobiliaria) {
        this.telefoneImobiliaria = telefoneImobiliaria;
    }

    @XmlTransient
    public List<Apartamento> getApartamentoList() {
        return apartamentoList;
    }

    public void setApartamentoList(List<Apartamento> apartamentoList) {
        this.apartamentoList = apartamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImobiliaria != null ? idImobiliaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imobiliaria)) {
            return false;
        }
        Imobiliaria other = (Imobiliaria) object;
        if ((this.idImobiliaria == null && other.idImobiliaria != null) || (this.idImobiliaria != null && !this.idImobiliaria.equals(other.idImobiliaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Imobiliaria[ idImobiliaria=" + idImobiliaria + " ]";
    }

}
