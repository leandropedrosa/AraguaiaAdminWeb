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
import modelo.Dependente;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class DependenteDao extends GenericDAO<Dependente> {

    public DependenteDao() {
        super(Dependente.class);
    }

    public Dependente getById(Integer pk) throws Exception {
        return (Dependente) super.find(pk);
    }

    public Dependente save(Dependente entity) throws Exception {
        return super.save(entity);
    }

    public Dependente update(Dependente entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Dependente.class);
    }

    public List<Dependente> findAll() throws Exception {
        return (List<Dependente>) super.findAll(Dependente.class);
    }

    public List<Dependente> getByTitular(Integer idTitular) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("idTitular", idTitular);
        return (List<Dependente>) super.findListResultName(Dependente.FIND_BY_TITULAR, parameters);
    }

    public List<Dependente> findUsuarioBySQL(String Valor, CamposPesquisa pesquisa) throws Exception {
        return (List<Dependente>) super.findSQLResult(CamposPesquisa.montaSQL(pesquisa, Valor, null));
    }
}
