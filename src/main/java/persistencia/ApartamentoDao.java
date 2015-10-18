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
import modelo.Apartamento;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class ApartamentoDao extends GenericDAO<Apartamento> {

    public ApartamentoDao() {
        super(Apartamento.class);
    }

    public Apartamento getById(Integer pk) throws Exception {
        return (Apartamento) super.find(pk);
    }

    public Apartamento save(Apartamento entity) throws Exception {
        return super.save(entity);
    }

    public Apartamento update(Apartamento entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Apartamento.class);
    }

    public List<Apartamento> findAll() throws Exception {
        return (List<Apartamento>) super.findAll(Apartamento.class);
    }

    public List<Apartamento> getByTitular(Integer idTitular) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("idTitular", idTitular);
        return (List<Apartamento>) super.findListResultName(Apartamento.FIND_BY_TITULAR, parameters);
    }

    public Apartamento getByNumero(String numero) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("numero", numero);
        return (Apartamento) super.findOneResultName(Apartamento.FIND_BY_NUMERO, parameters);
    }

    public Apartamento getByDiarista(Integer idApartamento) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("idApartamento", idApartamento);
        return (Apartamento) super.findOneResultName(Apartamento.FIND_BY_DIARISTA, parameters);
    }

    public Apartamento getByImobiliaria(Integer idApartamento) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("idApartamento", idApartamento);
        return (Apartamento) super.findOneResultName(Apartamento.FIND_BY_IMOBILIARIA, parameters);
    }

    public List<Apartamento> findUsuarioBySQL(String Valor, CamposPesquisa pesquisa) throws Exception {
        return (List<Apartamento>) super.findSQLResult(CamposPesquisa.montaSQL(pesquisa, Valor, null));
    }
}
