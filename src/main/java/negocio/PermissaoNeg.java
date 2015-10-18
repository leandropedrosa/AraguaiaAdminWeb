/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Permissao;
import persistencia.PermissaoDao;

/**
 *
 * @author Leandro
 */
@Stateless
public class PermissaoNeg extends AbstractNegocio implements PermissaoNegFacade {

    @EJB
    private PermissaoDao dao;

    @Override
    public Permissao validaAntesDeSalvar(Permissao permissao) throws Exception {
        if (permissao.getIdPermissao() == null) {
            return salvar(permissao);
        } else {
            return editar(permissao);
        }
    }

    private Permissao salvar(Permissao permissao) throws Exception {
        return dao.save(camposObrigatorios(permissao));
    }

    private Permissao editar(Permissao permissao) throws Exception {
        return dao.update(camposObrigatorios(permissao));
    }

    private Permissao camposObrigatorios(Permissao permissao) throws Exception {
        if (permissao.getTipo() == null || permissao.getTipo() == "") {
            throw new Exception("Permissao com o campo Tipo nulo ou vazio");
        }
        if (permissao.getSituacao() == null || permissao.getSituacao() == "") {
            throw new Exception("Permissao com o campo Situacao nulo ou vazio");
        }
        return permissao;
    }

    public Permissao getById(Integer pk) throws Exception {
        return dao.getById(pk);
    }

    @Override
    public void delete(String id) throws Exception {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public List<Permissao> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public Permissao findUsuarioByTipo(String tipo) throws Exception {
        return dao.findUsuarioByTipo(tipo);
    }
}
