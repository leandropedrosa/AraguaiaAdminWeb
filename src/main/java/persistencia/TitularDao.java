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
import modelo.Titular;
import util.Util;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class TitularDao extends GenericDAO<Titular> {

    public TitularDao() {
        super(Titular.class);
    }

    public Titular getById(Integer pk) throws Exception {
        return (Titular) super.find(pk);
    }

    public Titular save(Titular entity) throws Exception {
        return super.save(entity);
    }

    public Titular update(Titular entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Titular.class);
    }

    public List<Titular> findAll() throws Exception {
        return (List<Titular>) super.findAll(Titular.class);
    }

    public List<Titular> findTitularBySQL(String Valor, CamposPesquisa pesquisa) throws Exception {
        return (List<Titular>) super.findSQLResult(CamposPesquisa.montaSQL(pesquisa, Valor, null));
    }

    public Titular getByRG(String rg) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("rg", Util.removerCaracteresEspeciais(rg));
        return (Titular) super.findOneResultName(Titular.FIND_BY_RG, parameters);
    }

    public Titular getByCPF(String cpf) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("cpf", Util.removerCaracteresEspeciais(cpf));
        return (Titular) super.findOneResultName(Titular.FIND_BY_CPF, parameters);
    }
}
