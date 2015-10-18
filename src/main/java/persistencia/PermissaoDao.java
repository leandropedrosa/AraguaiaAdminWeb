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
import modelo.Permissao;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class PermissaoDao extends GenericDAO<Permissao> {

    public PermissaoDao() {
        super(Permissao.class);
    }

    public Permissao getById(Integer pk) throws Exception {
        return (Permissao) super.find(pk);
    }

    public Permissao save(Permissao entity) throws Exception {
        return super.save(entity);
    }

    public Permissao update(Permissao entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Permissao.class);
    }

    public List<Permissao> findAll() throws Exception {
        return (List<Permissao>) super.findAll(Permissao.class);
    }

    public Permissao findUsuarioByTipo(String tipo) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("tipo", tipo);
        return (Permissao) super.findOneResultName(Permissao.FIND_BY_TIPO, parameters);
    }

    public List<Permissao> findUsuarioBySQL(String Valor, CamposPesquisa pesquisa) throws Exception {
        return (List<Permissao>) super.findSQLResult(CamposPesquisa.montaSQL(pesquisa, Valor, null));
    }
}
