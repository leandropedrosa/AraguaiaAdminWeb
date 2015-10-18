/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Local;
import modelo.Permissao;
import modelo.Usuario;

/**
 *
 * @author Leandro
 */
@Local
public interface UsuarioNegFacade {

    public Usuario validaAntesDeLogar(Usuario usuario) throws Exception;

    public Usuario validaAntesDeSalvar(Usuario usuario) throws Exception;

    public void delete(String id) throws Exception;

    public void resetarSenha(String cpf) throws Exception;

    public Usuario getById(Integer pk) throws Exception;

    public List<Usuario> findAll() throws Exception;

    public Usuario getByCPF(String cpf) throws Exception;

    public List<Usuario> findSQL(String valor, String campo) throws Exception;

    public List<Permissao> findAllPermissoes() throws Exception;

    public Usuario salvaUsuarioPrimeiroAcesso(Usuario usuario) throws Exception;
}
