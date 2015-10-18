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
import modelo.Cobertura;
import modelo.Garagem;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class CoberturaDao extends GenericDAO<Cobertura> {

    public CoberturaDao() {
        super(Cobertura.class);
    }

    public Cobertura getById(Integer pk) throws Exception {
        return (Cobertura) super.find(pk);
    }

    public Cobertura save(Cobertura entity) throws Exception {
        return super.save(entity);
    }

    public Cobertura update(Cobertura entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Cobertura.class);
    }

    public List<Cobertura> findAll() throws Exception {
        return (List<Cobertura>) super.findAll(Cobertura.class);
    }

    public Cobertura getByCobertura(Integer idGaragem) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("idGaragem", idGaragem);
        return (Cobertura) super.findOneResultName(Garagem.FIND_BY_COBERTURA, parameters);
    }

    public List<Cobertura> findUsuarioBySQL(String Valor, CamposPesquisa pesquisa) throws Exception {
        return (List<Cobertura>) super.findSQLResult(CamposPesquisa.montaSQL(pesquisa, Valor, null));
    }
}
