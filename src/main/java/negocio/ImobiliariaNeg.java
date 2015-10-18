/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Imobiliaria;
import persistencia.ImobiliariaDao;
import util.Util;

/**
 *
 * @author Leandro
 */
@Stateless
public class ImobiliariaNeg extends AbstractNegocio implements ImobiliariaNegFacade {

    @EJB
    private ImobiliariaDao dao;

    @Override
    public Imobiliaria validaAntesDeSalvar(Imobiliaria imobiliaria) throws Exception {
        if (imobiliaria.getIdImobiliaria() == null) {
            return salvar(imobiliaria);
        } else {
            return editar(imobiliaria);
        }
    }

    private Imobiliaria salvar(Imobiliaria imobiliaria) throws Exception {
        if (imobiliaria.getTelefoneImobiliaria() != null) {
            imobiliaria.setTelefoneImobiliaria(Util.removerCaracteresEspeciais(imobiliaria.getTelefoneImobiliaria()));
        }
        return dao.save(camposObrigatorios(imobiliaria));
    }

    private Imobiliaria editar(Imobiliaria imobiliaria) throws Exception {
        if (imobiliaria.getTelefoneImobiliaria() != null) {
            imobiliaria.setTelefoneImobiliaria(Util.removerCaracteresEspeciais(imobiliaria.getTelefoneImobiliaria()));
        }
        return dao.update(camposObrigatorios(imobiliaria));
    }

    private Imobiliaria camposObrigatorios(Imobiliaria imobiliaria) throws Exception {
        if (imobiliaria.getNomeImobiliaria() == null || imobiliaria.getNomeImobiliaria() == "") {
            throw new Exception("Imobiliaria com o campo Nome nulo ou vazio");
        }
        return imobiliaria;
    }

    @Override
    public Imobiliaria getById(Integer pk) throws Exception {
        return dao.getById(pk);
    }

    @Override
    public void delete(Integer id) throws Exception {
        dao.delete(id);
    }

    @Override
    public List<Imobiliaria> findAll() throws Exception {
        return dao.findAll();
    }
}
