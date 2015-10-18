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
import modelo.Veiculo;
import util.Util;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class VeiculoDao extends GenericDAO<Veiculo> {

    public VeiculoDao() {
        super(Veiculo.class);
    }

    public Veiculo getById(Integer pk) throws Exception {
        return (Veiculo) super.find(pk);
    }

    public Veiculo save(Veiculo entity) throws Exception {
        return super.save(entity);
    }

    public Veiculo update(Veiculo entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Veiculo.class);
    }

    public List<Veiculo> findAll() throws Exception {
        return (List<Veiculo>) super.findAll(Veiculo.class);
    }

    public Veiculo getByPlaca(String placa) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("placa", Util.removerCaracteresEspeciais(placa));
        return (Veiculo) super.findOneResultName(Veiculo.FIND_BY_PLACA, parameters);
    }

    public List<Veiculo> getByVeiculoTitular(int idTitular) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("idTitular", idTitular);
        return (List<Veiculo>) super.findListResultName(Veiculo.FIND_BY_VEICULO_TITULAR, parameters);
    }

    public List<Veiculo> findVeiculoBySQL(String Valor, CamposPesquisa pesquisa) throws Exception {
        return (List<Veiculo>) super.findSQLResult(CamposPesquisa.montaSQL(pesquisa, Valor, null));
    }
}
