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
import modelo.Cobertura;
import persistencia.CoberturaDao;

/**
 *
 * @author Leandro
 */
@Stateless
public class CoberturaNeg extends AbstractNegocio implements CoberturaNegFacade {

    @EJB
    private CoberturaDao dao;

    @Override
    public Cobertura validaAntesDeSalvar(Cobertura cobertura) throws Exception {
        if (cobertura.getIdCobertura() == null) {
            return salvar(cobertura);
        } else {
            return editar(cobertura);
        }
    }

    private Cobertura salvar(Cobertura cobertura) throws Exception {
        return dao.save(camposObrigatorios(cobertura));
    }

    private Cobertura editar(Cobertura cobertura) throws Exception {
        return dao.update(camposObrigatorios(cobertura));
    }

    private Cobertura camposObrigatorios(Cobertura cobertura) throws Exception {
        if (cobertura.getTipo() == null || cobertura.getTipo() == "") {
            throw new Exception("Cobertura com o campo Tipo nulo ou vazio");
        }
        return cobertura;
    }

    @Override
    public Cobertura getById(Integer pk) throws Exception {
        return dao.getById(pk);
    }

    @Override
    public void delete(String id) throws Exception {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public List<Cobertura> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List<Cobertura> findSQL(String valor, String campo) throws Exception {
        if (valor != null && valor != "" && campo != null && campo != "") {
            return dao.findUsuarioBySQL(valor, CamposPesquisa.retornaEnuCampo(campo));
        } else {
            return null;
        }
    }
}
