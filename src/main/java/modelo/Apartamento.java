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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "apartamento")
@NamedQueries({
    @NamedQuery(name = "Apartamento.findAll", query = "SELECT a FROM Apartamento a"),
    @NamedQuery(name = "Apartamento.findByTitularA", query = "SELECT a FROM Apartamento a INNER JOIN a.titular t WHERE t.idTitular = :idTitular"),
    @NamedQuery(name = "Apartamento.findByNumero", query = "SELECT a FROM Apartamento a INNER JOIN a.titular t WHERE a.numero = :numero"),
    @NamedQuery(name = "Apartamento.findByDiarista", query = "SELECT d FROM Apartamento a INNER JOIN a.diarista d WHERE a.idApartamento = :idApartamento"),
    @NamedQuery(name = "Apartamento.findByImobiliaria", query = "SELECT i FROM Apartamento a INNER JOIN a.imobiliaria i WHERE a.idApartamento = :idApartamento")
})
@XmlRootElement
public class Apartamento implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String FIND_BY_TITULAR = "Apartamento.findByTitularA";
    public static final String FIND_BY_NUMERO = "Apartamento.findByNumero";
    public static final String FIND_BY_DIARISTA = "Apartamento.findByDiarista";
    public static final String FIND_BY_IMOBILIARIA = "Apartamento.findByImobiliaria";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idApartamento")
    private Integer idApartamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quartos")
    private Integer quartos;
    @Size(max = 10)
    @Column(name = "ramal")
    private String ramal;
    @Size(max = 1)
    @Column(name = "possuiInternet")
    private String possuiInternet;
    @Size(max = 1)
    @Column(name = "possuiAnimais")
    private String possuiAnimais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numero")
    private String numero;
    @Size(max = 1)
    @Column(name = "possuiArCondicionado")
    private String possuiArCondicionado;
    @Size(max = 1)
    @Column(name = "possuiTvCabo")
    private String possuiTvCabo;
    @Size(max = 1)
    @Column(name = "possuiBicicleta")
    private String possuiBicicleta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "situacao")
    private String situacao;
    @JoinColumn(name = "idBloco", referencedColumnName = "idBloco")
    @ManyToOne(optional = false)
    private Bloco bloco;
    @JoinColumn(name = "idTitular", referencedColumnName = "idTitular")
    @ManyToOne
    private Titular titular;
    @JoinColumn(name = "idImobiliaria", referencedColumnName = "idImobiliaria")
    @ManyToOne
    private Imobiliaria imobiliaria;
    @JoinColumn(name = "idDiarista", referencedColumnName = "idDiarista")
    @ManyToOne
    private Diarista diarista;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apartamento")
    private List<Negociacao> negociacaoList;

    public Apartamento() {
    }

    public Apartamento(Integer idApartamento) {
        this.idApartamento = idApartamento;
    }

    public Apartamento(Integer idApartamento, Integer quartos, String numero, String situacao) {
        this.idApartamento = idApartamento;
        this.quartos = quartos;
        this.numero = numero;
        this.situacao = situacao;
    }

    public Integer getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(Integer idApartamento) {
        this.idApartamento = idApartamento;
    }

    public Integer getQuartos() {
        return quartos;
    }

    public void setQuartos(Integer quartos) {
        this.quartos = quartos;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getPossuiInternet() {
        return possuiInternet;
    }

    public void setPossuiInternet(String possuiInternet) {
        this.possuiInternet = possuiInternet;
    }

    public String getPossuiAnimais() {
        return possuiAnimais;
    }

    public void setPossuiAnimais(String possuiAnimais) {
        this.possuiAnimais = possuiAnimais;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPossuiArCondicionado() {
        return possuiArCondicionado;
    }

    public void setPossuiArCondicionado(String possuiArCondicionado) {
        this.possuiArCondicionado = possuiArCondicionado;
    }

    public String getPossuiTvCabo() {
        return possuiTvCabo;
    }

    public void setPossuiTvCabo(String possuiTvCabo) {
        this.possuiTvCabo = possuiTvCabo;
    }

    public String getPossuiBicicleta() {
        return possuiBicicleta;
    }

    public void setPossuiBicicleta(String possuiBicicleta) {
        this.possuiBicicleta = possuiBicicleta;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Imobiliaria getImobiliaria() {
        return imobiliaria;
    }

    public void setImobiliaria(Imobiliaria imobiliaria) {
        this.imobiliaria = imobiliaria;
    }

    public Diarista getDiarista() {
        return diarista;
    }

    public void setDiarista(Diarista diarista) {
        this.diarista = diarista;
    }

    @XmlTransient
    public List<Negociacao> getNegociacaoList() {
        return negociacaoList;
    }

    public void setNegociacaoList(List<Negociacao> negociacaoList) {
        this.negociacaoList = negociacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApartamento != null ? idApartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apartamento)) {
            return false;
        }
        Apartamento other = (Apartamento) object;
        if ((this.idApartamento == null && other.idApartamento != null) || (this.idApartamento != null && !this.idApartamento.equals(other.idApartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Apartamento[ idApartamento=" + idApartamento + " ]";
    }

}
