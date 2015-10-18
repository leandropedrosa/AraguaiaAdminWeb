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
import modelo.Garagem;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class GaragemDao extends GenericDAO<Garagem> {

    public GaragemDao() {
        super(Garagem.class);
    }

    public Garagem getById(Integer pk) throws Exception {
        return (Garagem) super.find(pk);
    }

    public Garagem save(Garagem entity) throws Exception {
        return super.save(entity);
    }

    public Garagem update(Garagem entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Garagem.class);
    }

    public List<Garagem> findAll() throws Exception {
        return (List<Garagem>) super.findAll(Garagem.class);
    }

    public List<Garagem> getByTitular(Integer idTitular) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("idTitular", idTitular);
        return (List<Garagem>) super.findListResultName(Garagem.FIND_BY_TITULAR, parameters);
    }

    public List<Garagem> findUsuarioBySQL(String Valor, CamposPesquisa pesquisa) throws Exception {
        return (List<Garagem>) super.findSQLResult(CamposPesquisa.montaSQL(pesquisa, Valor, null));
    }
}
