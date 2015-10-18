/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import enuns.CamposPesquisa;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Titular;
import modelo.Veiculo;
import persistencia.TitularDao;
import persistencia.VeiculoDao;
import util.Util;

/**
 *
 * @author Leandro
 */
@Stateless
public class VeiculoNeg extends AbstractNegocio implements VeiculoNegFacade {

    @EJB
    private VeiculoDao dao;
    @EJB
    private TitularDao daoTitular;

    @Override
    public Veiculo validaAntesDeSalvar(Veiculo veiculo) throws Exception {
        if (veiculo.getIdVeiculo() == null) {
            return salvar(veiculo);
        } else {
            return editar(veiculo);
        }
    }

    private Veiculo salvar(Veiculo veiculo) throws Exception {
        Veiculo Existe = dao.getByPlaca(veiculo.getPlaca());
        if (Existe == null) {
            throw new Exception("Veiculo já cadastrado na base de dados!");
        }
        return dao.save(camposObrigatorios(veiculo));
    }

    private Veiculo editar(Veiculo veiculo) throws Exception {
        return dao.update(camposObrigatorios(veiculo));
    }

    private Veiculo camposObrigatorios(Veiculo veiculo) throws Exception {
        if (veiculo.getTitular() == null || veiculo.getTitular().getNome() == "") {
            throw new Exception("Veiculo com o campo Nome nulo ou vazio");
        }
        if (veiculo.getModelo() == null || veiculo.getModelo() == "") {
            throw new Exception("Veiculo com o campo Modelo nulo ou vazio");
        }
        if (veiculo.getPlaca() == null || veiculo.getPlaca() == "") {
            throw new Exception("Veiculo com o campo Placa nulo ou vazio");
        } else {
            veiculo.setPlaca(Util.removerCaracteresEspeciais(veiculo.getPlaca()));
        }
        if (veiculo.getTipo() == null || veiculo.getTipo() == "") {
            throw new Exception("Veiculo com o campo Tipo nulo ou vazio");
        }
        return veiculo;
    }

    @Override
    public Veiculo getById(Integer pk) throws Exception {
        return dao.getById(pk);
    }

    @Override
    public void delete(String id) throws Exception {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public List<Veiculo> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List<Veiculo> findByTitular(int idTitular) throws Exception {
        return dao.getByVeiculoTitular(idTitular);
    }

    @Override
    public List<Titular> findAllTitular() throws Exception {
        return daoTitular.findAll();
    }

    @Override
    public List<Veiculo> findSQL(String valor, String campo) throws Exception {
        if (valor != null && valor != "" && campo != null && campo != "") {
            return dao.findVeiculoBySQL(valor, CamposPesquisa.retornaEnuCampo(campo));
        } else {
            return null;
        }
    }
}
