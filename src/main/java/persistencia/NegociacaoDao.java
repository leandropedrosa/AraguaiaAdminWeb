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
import modelo.Negociacao;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class NegociacaoDao extends GenericDAO<Negociacao> {

    public NegociacaoDao() {
        super(Negociacao.class);
    }

    public Negociacao getById(Integer pk) throws Exception {
        return (Negociacao) super.find(pk);
    }

    public Negociacao save(Negociacao entity) throws Exception {
        return super.save(entity);
    }

    public Negociacao update(Negociacao entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Negociacao.class);
    }

    public List<Negociacao> findAll() throws Exception {
        return (List<Negociacao>) super.findAll(Negociacao.class);
    }

    public List<Negociacao> getByApartamnto(Integer idApartamento) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("idApartamento", idApartamento);
        return (List<Negociacao>) super.findOneResultName(Negociacao.FIND_BY_APARTAEMNTO, parameters);
    }

    public List<Negociacao> findUsuarioBySQL(String Valor, CamposPesquisa pesquisa) throws Exception {
        return (List<Negociacao>) super.findSQLResult(CamposPesquisa.montaSQL(pesquisa, Valor, null));
    }
}
