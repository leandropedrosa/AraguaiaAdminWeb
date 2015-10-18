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
@Table(name = "telefone")
@NamedQueries({
    @NamedQuery(name = "Telefone.findAll", query = "SELECT t FROM Telefone t"),
    @NamedQuery(name = "Telefone.findTitularT", query = "SELECT t FROM Telefone t INNER JOIN t.titular ti WHERE ti.idTitular = :idTitular")})
@XmlRootElement
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String FIND_BY_TITULAR = "Telefone.findTitularT";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTelefone")
    private Integer idTelefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 30)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "idTitular", referencedColumnName = "idTitular")
    @ManyToOne(optional = false)
    private Titular titular;

    public Telefone() {
    }

    public Telefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public Telefone(Integer idTelefone, String numero, String tipo) {
        this.idTelefone = idTelefone;
        this.numero = numero;
        this.tipo = tipo;
    }

    public Integer getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        hash += (idTelefone != null ? idTelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        if ((this.idTelefone == null && other.idTelefone != null) || (this.idTelefone != null && !this.idTelefone.equals(other.idTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Telefone[ idTelefone=" + idTelefone + " ]";
    }

}
