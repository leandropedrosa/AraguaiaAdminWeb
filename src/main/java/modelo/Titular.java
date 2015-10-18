/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name = "titular")
@NamedQueries({
    @NamedQuery(name = "Titular.findAll", query = "SELECT t FROM Titular t"),
    @NamedQuery(name = "Titular.findUserByRg", query = "SELECT t FROM Titular t WHERE t.rg = :rg"),
    @NamedQuery(name = "Titular.findUserByCpf", query = "SELECT t FROM Titular t INNER JOIN t.usuario u  WHERE u.cpf = :cpf")
})
@XmlRootElement
public class Titular implements Serializable {

    public static final String FIND_BY_RG = "Titular.findUserByRg";
    public static final String FIND_BY_CPF = "Titular.findUserByCpf";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTitular")
    private Integer idTitular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtNascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtNascimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "situacao")
    private String situacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "titular")
    private List<Veiculo> veiculoList;
    @OneToMany(mappedBy = "titular")
    private List<Apartamento> apartamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "titular")
    private List<Telefone> telefoneList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "titular")
    private List<Dependente> dependenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "titular")
    private List<Solicitacao> solicitacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "titular")
    private List<Visitantes> visitantesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "titular")
    private List<Garagem> garagemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "titular")
    private List<Encomenda> encomendaList;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Titular() {
    }

    public Titular(Integer idTitular) {
        this.idTitular = idTitular;
    }

    public Titular(Integer idTitular, String nome, String email, Date dtNascimento, String rg, String tipo, String situacao) {
        this.idTitular = idTitular;
        this.nome = nome;
        this.email = email;
        this.dtNascimento = dtNascimento;
        this.rg = rg;
        this.tipo = tipo;
        this.situacao = situacao;
    }

    public Integer getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Integer idTitular) {
        this.idTitular = idTitular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @XmlTransient
    public List<Veiculo> getVeiculoList() {
        return veiculoList;
    }

    public void setVeiculoList(List<Veiculo> veiculoList) {
        this.veiculoList = veiculoList;
    }

    @XmlTransient
    public List<Apartamento> getApartamentoList() {
        return apartamentoList;
    }

    public void setApartamentoList(List<Apartamento> apartamentoList) {
        this.apartamentoList = apartamentoList;
    }

    @XmlTransient
    public List<Telefone> getTelefoneList() {
        return telefoneList;
    }

    public void setTelefoneList(List<Telefone> telefoneList) {
        this.telefoneList = telefoneList;
    }

    @XmlTransient
    public List<Dependente> getDependenteList() {
        return dependenteList;
    }

    public void setDependenteList(List<Dependente> dependenteList) {
        this.dependenteList = dependenteList;
    }

    @XmlTransient
    public List<Solicitacao> getSolicitacaoList() {
        return solicitacaoList;
    }

    public void setSolicitacaoList(List<Solicitacao> solicitacaoList) {
        this.solicitacaoList = solicitacaoList;
    }

    @XmlTransient
    public List<Visitantes> getVisitantesList() {
        return visitantesList;
    }

    public void setVisitantesList(List<Visitantes> visitantesList) {
        this.visitantesList = visitantesList;
    }

    @XmlTransient
    public List<Garagem> getGaragemList() {
        return garagemList;
    }

    public void setGaragemList(List<Garagem> garagemList) {
        this.garagemList = garagemList;
    }

    @XmlTransient
    public List<Encomenda> getEncomendaList() {
        return encomendaList;
    }

    public void setEncomendaList(List<Encomenda> encomendaList) {
        this.encomendaList = encomendaList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTitular != null ? idTitular.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titular)) {
            return false;
        }
        Titular other = (Titular) object;
        if ((this.idTitular == null && other.idTitular != null) || (this.idTitular != null && !this.idTitular.equals(other.idTitular))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Titular[ idTitular=" + idTitular + " ]";
    }

}
