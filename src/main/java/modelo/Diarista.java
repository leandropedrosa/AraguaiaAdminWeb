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
@Table(name = "diarista")
@NamedQueries({
    @NamedQuery(name = "Diarista.findAll", query = "SELECT d FROM Diarista d")})
@XmlRootElement
public class Diarista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idDiarista")
    private Integer idDiarista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nomeDiarista")
    private String nomeDiarista;
    @Size(max = 20)
    @Column(name = "telefoneDiarista")
    private String telefoneDiarista;
    @OneToMany(mappedBy = "diarista")
    private List<Apartamento> apartamentoList;

    public Diarista() {
    }

    public Diarista(Integer idDiarista) {
        this.idDiarista = idDiarista;
    }

    public Diarista(Integer idDiarista, String nomeDiarista) {
        this.idDiarista = idDiarista;
        this.nomeDiarista = nomeDiarista;
    }

    public Integer getIdDiarista() {
        return idDiarista;
    }

    public void setIdDiarista(Integer idDiarista) {
        this.idDiarista = idDiarista;
    }

    public String getNomeDiarista() {
        return nomeDiarista;
    }

    public void setNomeDiarista(String nomeDiarista) {
        this.nomeDiarista = nomeDiarista;
    }

    public String getTelefoneDiarista() {
        return telefoneDiarista;
    }

    public void setTelefoneDiarista(String telefoneDiarista) {
        this.telefoneDiarista = telefoneDiarista;
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
        hash += (idDiarista != null ? idDiarista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diarista)) {
            return false;
        }
        Diarista other = (Diarista) object;
        if ((this.idDiarista == null && other.idDiarista != null) || (this.idDiarista != null && !this.idDiarista.equals(other.idDiarista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Diarista[ idDiarista=" + idDiarista + " ]";
    }

}
