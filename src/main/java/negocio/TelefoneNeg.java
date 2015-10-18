/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Telefone;
import modelo.Titular;
import persistencia.TelefoneDao;
import util.Util;

/**
 *
 * @author Leandro
 */
@Stateless
public class TelefoneNeg extends AbstractNegocio implements TelefoneNegFacade {

    @EJB
    private TelefoneDao dao;

    @Override
    public void validaAntesDeSalvar(Titular titular) throws Exception {
        if (titular.getTelefoneList() != null && !titular.getTelefoneList().isEmpty()) {
            for (Telefone item : titular.getTelefoneList()) {
                if (item.getIdTelefone() == null) {
                    item.setTitular(titular);
                    salvar(item);
                } else {
                    editar(item);
                }
            }
        }
    }

    private Telefone salvar(Telefone telefone) throws Exception {
        return dao.save(camposObrigatorios(telefone));
    }

    private Telefone editar(Telefone telefone) throws Exception {
        return dao.update(camposObrigatorios(telefone));
    }

    private Telefone camposObrigatorios(Telefone telefone) throws Exception {
        if (telefone.getNumero() == null || telefone.getNumero() == "") {
            throw new Exception("Telefone com o campo Número nulo ou vazio");
        } else {
            telefone.setNumero(Util.removerCaracteresEspeciais(telefone.getNumero()));
        }
        if (telefone.getTitular() == null || telefone.getTitular().getNome() == "") {
            throw new Exception("Telefone com o campo Titular nulo ou vazio");
        }
        if (telefone.getTipo() == null || telefone.getTipo() == "") {
            throw new Exception("Telefone com o campo Tipo nulo ou vazio");
        }
        return telefone;
    }

    @Override
    public Telefone getById(Integer pk) throws Exception {
        return dao.getById(pk);
    }

    @Override
    public List<Telefone> findByTitular(Integer idTitular) throws Exception {
        return dao.getByTitular(idTitular);
    }

    @Override
    public void delete(String id) throws Exception {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public List<Telefone> findAll() throws Exception {
        return dao.findAll();
    }
}
