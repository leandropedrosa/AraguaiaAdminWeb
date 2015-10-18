/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import enuns.CamposPesquisa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import modelo.Usuario;
import util.Util;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class UsuarioDao extends GenericDAO<Usuario> {

    public UsuarioDao() {
        super(Usuario.class);
    }

    public Usuario getById(Integer pk) throws Exception {
        return (Usuario) super.find(pk);
    }

    public Usuario save(Usuario entity) throws Exception {
        return super.save(entity);
    }

    public Usuario update(Usuario entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Usuario.class);
    }

    public List<Usuario> findAll() throws Exception {
        return (List<Usuario>) super.findAll(Usuario.class);
    }

    public List<Usuario> findUsuarioBySQL(String Valor, CamposPesquisa pesquisa) throws Exception {
        return (List<Usuario>) super.findSQLResult(CamposPesquisa.montaSQL(pesquisa, Valor, null));
    }

    public Usuario findUsuarioByLogin(String login, String senha) throws Exception {
        Usuario usuario = null;
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("cpf", Util.removerCaracteresEspeciais(login));
        parameters.put("senha", Util.criptografar(senha));
        usuario = (Usuario) super.findOneResultName(Usuario.FIND_BY_LOGIN, parameters);
        if (usuario != null && usuario.getNome() != "") {
            usuario.setNome(usuario.getNome().split(" ")[0]);
        }
        return usuario;
    }

    public Usuario getByCPF(String cpf) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("cpf", Util.removerCaracteresEspeciais(cpf));
        return (Usuario) super.findOneResultName(Usuario.FIND_BY_CPF, parameters);
    }
}
