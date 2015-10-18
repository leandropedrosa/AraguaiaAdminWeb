/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import enuns.CamposPesquisa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.Telefone;
import modelo.Titular;
import modelo.Usuario;

/**
 *
 * @author Leandro
 */
public class TitularVisao implements Serializable {

    private static final long serialVersionUID = 1L;
    private Titular titular;
    private Usuario usuario;
    private List<Usuario> todosUsuarios;
    private List<Titular> todosTitulares;
    private Telefone telefoneResidencial;
    private Telefone telefoneCelular;
    private Telefone telefoneComercial;
    private Telefone telefoneEmergencia;
    private Telefone telefoneEmergencia2;
    private String valorPesquisa;
    private List<String> campos;
    private String valorSelecionado;

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

            campos = CamposPesquisa.camposLista("Titular");
        }
        return campos;
    }

    public List<Usuario> getTodosUsuarios() {
        if (todosUsuarios == null) {
            todosUsuarios = new ArrayList<Usuario>();
        }
        return todosUsuarios;
    }

    public void setTodosUsuarios(List<Usuario> todosUsuarios) {
        this.todosUsuarios = todosUsuarios;
    }

    public Telefone getTelefoneResidencial() {
        if (telefoneResidencial == null) {
            telefoneResidencial = new Telefone();
        }
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(Telefone telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public Telefone getTelefoneCelular() {
        if (telefoneCelular == null) {
            telefoneCelular = new Telefone();
        }
        return telefoneCelular;
    }

    public void setTelefoneCelular(Telefone telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public Telefone getTelefoneComercial() {
        if (telefoneComercial == null) {
            telefoneComercial = new Telefone();
        }
        return telefoneComercial;
    }

    public void setTelefoneComercial(Telefone telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public Telefone getTelefoneEmergencia() {
        if (telefoneEmergencia == null) {
            telefoneEmergencia = new Telefone();
        }
        return telefoneEmergencia;
    }

    public void setTelefoneEmergencia(Telefone telefoneEmergencia) {
        this.telefoneEmergencia = telefoneEmergencia;
    }

    public Telefone getTelefoneEmergencia2() {
        if (telefoneEmergencia2 == null) {
            telefoneEmergencia2 = new Telefone();
        }
        return telefoneEmergencia2;
    }

    public void setTelefoneEmergencia2(Telefone telefoneEmergencia2) {
        this.telefoneEmergencia2 = telefoneEmergencia2;
    }

    public List<Titular> getTodosTitulares() {
        if (todosTitulares == null) {
            todosTitulares = new ArrayList<Titular>();
        }
        return todosTitulares;
    }

    public void setTodosTitulares(List<Titular> todosTitulares) {
        this.todosTitulares = todosTitulares;
    }

    public Titular getTitular() {
        if (titular == null) {
            titular = new Titular();
        }
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
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

    public void converListTelefone(List<Telefone> lista) {
        if (lista != null && !lista.isEmpty()) {
            for (Telefone item : lista) {
                if (item.getTipo().equals("R")) {
                    setTelefoneResidencial(item);
                }
                if (item.getTipo().equals("C")) {
                    setTelefoneCelular(item);
                }
                if (item.getTipo().equals("O")) {
                    setTelefoneComercial(item);
                }
                if (item.getTipo().equals("1")) {
                    setTelefoneEmergencia(item);
                }
                if (item.getTipo().equals("2")) {
                    setTelefoneEmergencia2(item);
                }
            }
        }
    }
}
