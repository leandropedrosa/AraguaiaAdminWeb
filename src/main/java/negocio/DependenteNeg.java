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
import modelo.Dependente;
import modelo.Titular;
import persistencia.DependenteDao;
import persistencia.TitularDao;

/**
 *
 * @author Leandro
 */
@Stateless
public class DependenteNeg extends AbstractNegocio implements DependenteNegFacade {

    @EJB
    private DependenteDao dao;

    @EJB
    private TitularDao daoTitular;

    @Override
    public Dependente validaAntesDeSalvar(Dependente dependente) throws Exception {
        if (dependente.getIdDependente() == null) {
            return salvar(dependente);
        } else {
            return editar(dependente);
        }
    }

    private Dependente salvar(Dependente dependente) throws Exception {
        return dao.save(camposObrigatorios(dependente));
    }

    private Dependente editar(Dependente dependente) throws Exception {
        return dao.update(camposObrigatorios(dependente));
    }

    private Dependente camposObrigatorios(Dependente dependente) throws Exception {
        if (dependente.getTitular() == null || dependente.getTitular().getNome() == "") {
            throw new Exception("Dependente com o campo Titular nulo ou vazio");
        }
        if (dependente.getNome() == null || dependente.getNome() == "") {
            throw new Exception("Dependente com o campo Nome nulo ou vazio");
        }
        if (dependente.getParentesco() == null || dependente.getParentesco() == "") {
            throw new Exception("Dependente com o campo Parentesco nulo ou vazio");
        }
        if (dependente.getDtNascimento() == null) {
            throw new Exception("Dependente com o campo DtNascimento nulo ou vazio");
        }
        if (dependente.getRg() == null || dependente.getRg() == "") {
            throw new Exception("Dependente com o campo RG nulo ou vazio");
        }
        return dependente;
    }

    @Override
    public Dependente getById(Integer pk) throws Exception {
        return dao.getById(pk);
    }

    @Override
    public void delete(String id) throws Exception {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public List<Dependente> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List<Dependente> findTitular(Integer idTitular) throws Exception {
        return dao.getByTitular(idTitular);
    }

    @Override
    public List<Titular> findAllTitular() throws Exception {
        return daoTitular.findAll();
    }

    @Override
    public List<Dependente> findSQL(String valor, String campo) throws Exception {
        if (valor != null && valor != "" && campo != null && campo != "") {
            return dao.findUsuarioBySQL(valor, CamposPesquisa.retornaEnuCampo(campo));
        } else {
            return null;
        }
    }
}
