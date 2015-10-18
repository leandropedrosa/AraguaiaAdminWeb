/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import enuns.CamposPesquisa;
import java.io.Serializable;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Leandro
 */
public class UsuarioVisao implements Serializable {

    private Usuario usuario;
    private String cpfResetarSenha;
    private String valorPesquisa;
    private List<String> campos;
    private String valorSelecionado = "";

    public String getValorSelecionado() {
        return valorSelecionado;
    }

    public void setValorSelecionado(String valorSelecionado) {
        this.valorSelecionado = valorSelecionado;
    }

    public String getValorPesquisa() {
        return valorPesquisa;
    }

    public void setValorPesquisa(String valorPesquisa) {
        this.valorPesquisa = valorPesquisa;
    }

    public List<String> getCampos() {
        if (campos == null) {

            campos = CamposPesquisa.camposLista("Usuario");
        }
        return campos;
    }

    public void setCampos(List<String> campos) {
        this.campos = campos;
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCpfResetarSenha() {
        return cpfResetarSenha;
    }

    public void setCpfResetarSenha(String cpfResetarSenha) {
        this.cpfResetarSenha = cpfResetarSenha;
    }

}
