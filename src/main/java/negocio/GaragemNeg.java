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
import modelo.Garagem;
import modelo.Titular;
import persistencia.GaragemDao;
import persistencia.TitularDao;

/**
 *
 * @author Leandro
 */
@Stateless
public class GaragemNeg extends AbstractNegocio implements GaragemNegFacade {

    @EJB
    private GaragemDao dao;

    @EJB
    private CoberturaNegFacade coberturaNeg;

    @EJB
    private TitularDao daoTitular;

    @Override
    public Garagem validaAntesDeSalvar(Garagem garagem) throws Exception {
        if (garagem.getCobertura() != null) {
            garagem.setCobertura(coberturaNeg.validaAntesDeSalvar(garagem.getCobertura()));
        }
        if (garagem.getIdGaragem() == null) {
            return salvar(garagem);
        } else {
            return editar(garagem);
        }
    }

    private Garagem salvar(Garagem garagem) throws Exception {
        List<Garagem> existe = dao.getByTitular(garagem.getTitular().getIdTitular());
        if (existe == null || existe.isEmpty()) {
            throw new Exception("Garagem já cadastrada na base de dados!");
        }
        return dao.save(camposObrigatorios(garagem));
    }

    private Garagem editar(Garagem garagem) throws Exception {
        return dao.update(camposObrigatorios(garagem));
    }

    private Garagem camposObrigatorios(Garagem garagem) throws Exception {
        if (garagem.getCobertura() == null || garagem.getCobertura().getTipo() == "") {
            throw new Exception("Garagem com o campo Cobertura nulo ou vazio");
        }
        if (garagem.getTitular() == null || garagem.getTitular().getNome() == "") {
            throw new Exception("Garagem com o campo Titular nulo ou vazio");
        }
        if (garagem.getNumero() == null || garagem.getNumero() == "") {
            throw new Exception("Garagem com o campo Número nulo ou vazio");
        }
        return garagem;
    }

    @Override
    public List<Garagem> findByTitular(Integer idTitular) throws Exception {
        return dao.getByTitular(idTitular);
    }

    @Override
    public Garagem getById(Integer pk) throws Exception {
        return dao.getById(pk);
    }

    private void save(Garagem entity) throws Exception {
        dao.save(entity);
    }

    private void update(Garagem entity) throws Exception {
        dao.update(entity);
    }

    @Override
    public void delete(String id) throws Exception {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public List<Garagem> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List<Titular> findAllTitular() throws Exception {
        return daoTitular.findAll();
    }

    @Override
    public List<Garagem> findSQL(String valor, String campo) throws Exception {
        if (valor != null && valor != "" && campo != null && campo != "") {
            return dao.findUsuarioBySQL(valor, CamposPesquisa.retornaEnuCampo(campo));
        } else {
            return null;
        }
    }
}
