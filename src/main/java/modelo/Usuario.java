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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findUserByLogin", query = "SELECT u FROM Usuario u JOIN FETCH u.permissao p WHERE u.cpf = :cpf and u.senha = :senha"),
    @NamedQuery(name = "Usuario.findUserByCpf", query = "SELECT u FROM Usuario u JOIN FETCH u.permissao p where u.cpf = :cpf")})
@XmlRootElement
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String FIND_BY_LOGIN = "Usuario.findUserByLogin";
    public static final String FIND_BY_CPF = "Usuario.findUserByCpf";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "situacao")
    private String situacao;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome")
    private String nome;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Size(max = 1)
    @Column(name = "primeiroAcesso")
    private String primeiroAcesso;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Movimentacao movimentacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Porteiro> porteiroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Zelador> zeladorList;
    @JoinColumn(name = "idPermissao", referencedColumnName = "idPermissao")
    @ManyToOne(optional = false)
    private Permissao permissao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Titular> titularList;
    @Transient
    private String senhaConfirmacao;

    public String getSenhaConfirmacao() {
        return senhaConfirmacao;
    }

    public void setSenhaConfirmacao(String senhaConfirmacao) {
        this.senhaConfirmacao = senhaConfirmacao;
    }

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String cpf, String senha, String situacao, String email, String nome) {
        this.idUsuario = idUsuario;
        this.cpf = cpf;
        this.senha = senha;
        this.situacao = situacao;
        this.email = email;
        this.nome = nome;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getPrimeiroAcesso() {
        return primeiroAcesso;
    }

    public void setPrimeiroAcesso(String primeiroAcesso) {
        this.primeiroAcesso = primeiroAcesso;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    @XmlTransient
    public List<Porteiro> getPorteiroList() {
        return porteiroList;
    }

    public void setPorteiroList(List<Porteiro> porteiroList) {
        this.porteiroList = porteiroList;
    }

    @XmlTransient
    public List<Zelador> getZeladorList() {
        return zeladorList;
    }

    public void setZeladorList(List<Zelador> zeladorList) {
        this.zeladorList = zeladorList;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    @XmlTransient
    public List<Titular> getTitularList() {
        return titularList;
    }

    public void setTitularList(List<Titular> titularList) {
        this.titularList = titularList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuario[ idUsuario=" + idUsuario + " ]";
    }

}
