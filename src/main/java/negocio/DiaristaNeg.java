/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Diarista;
import persistencia.DiaristaDao;
import util.Util;

/**
 *
 * @author Leandro
 */
@Stateless
public class DiaristaNeg extends AbstractNegocio implements DiaristaNegFacade {

    @EJB
    private DiaristaDao dao;

    @Override
    public Diarista validaAntesDeSalvar(Diarista diarista) throws Exception {
        if (diarista.getIdDiarista() == null) {
            return salvar(diarista);
        } else {
            return editar(diarista);
        }
    }

    private Diarista salvar(Diarista diarista) throws Exception {
        if (diarista.getTelefoneDiarista() != null) {
            diarista.setTelefoneDiarista(Util.removerCaracteresEspeciais(diarista.getTelefoneDiarista()));
        }
        return dao.save(camposObrigatorios(diarista));
    }

    private Diarista editar(Diarista diarista) throws Exception {
        if (diarista.getTelefoneDiarista() != null) {
            diarista.setTelefoneDiarista(Util.removerCaracteresEspeciais(diarista.getTelefoneDiarista()));
        }
        return dao.update(camposObrigatorios(diarista));
    }

    private Diarista camposObrigatorios(Diarista diarista) throws Exception {
        if (diarista.getNomeDiarista() == null || diarista.getNomeDiarista() == "") {
            throw new Exception("Diarista com o campo Nome nulo ou vazio");
        }
        return diarista;
    }

    public Diarista getById(Integer pk) throws Exception {
        return dao.getById(pk);
    }

    @Override
    public void delete(String id) throws Exception {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public List<Diarista> findAll() throws Exception {
        return dao.findAll();
    }
}
