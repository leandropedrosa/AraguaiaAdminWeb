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
@Table(name = "garagem")
@NamedQueries({
    @NamedQuery(name = "Garagem.findAll", query = "SELECT g FROM Garagem g"),
    @NamedQuery(name = "Garagem.findByTitularG", query = "SELECT g FROM Garagem g INNER JOIN g.titular t WHERE t.idTitular = :idTitular"),
    @NamedQuery(name = "Garagem.findByCobertura", query = "SELECT c FROM Garagem g INNER JOIN g.cobertura c WHERE g.idGaragem = :idGaragem")})
@XmlRootElement
public class Garagem implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String FIND_BY_TITULAR = "Garagem.findByTitularG";
    public static final String FIND_BY_COBERTURA = "Garagem.findByCobertura";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idGaragem")
    private Integer idGaragem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numero")
    private String numero;
    @JoinColumn(name = "idTitular", referencedColumnName = "idTitular")
    @ManyToOne(optional = false)
    private Titular titular;
    @JoinColumn(name = "idCobertura", referencedColumnName = "idCobertura")
    @ManyToOne(optional = false)
    private Cobertura cobertura;

    public Garagem() {
    }

    public Garagem(Integer idGaragem) {
        this.idGaragem = idGaragem;
    }

    public Garagem(Integer idGaragem, String numero) {
        this.idGaragem = idGaragem;
        this.numero = numero;
    }

    public Integer getIdGaragem() {
        return idGaragem;
    }

    public void setIdGaragem(Integer idGaragem) {
        this.idGaragem = idGaragem;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Cobertura getCobertura() {
        if (cobertura == null) {
            cobertura = new Cobertura();
        }
        return cobertura;
    }

    public void setCobertura(Cobertura cobertura) {
        this.cobertura = cobertura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGaragem != null ? idGaragem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garagem)) {
            return false;
        }
        Garagem other = (Garagem) object;
        if ((this.idGaragem == null && other.idGaragem != null) || (this.idGaragem != null && !this.idGaragem.equals(other.idGaragem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Garagem[ idGaragem=" + idGaragem + " ]";
    }

}
