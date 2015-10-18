/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Stateless;
import modelo.Diarista;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class DiaristaDao extends GenericDAO<Diarista> {

    public DiaristaDao() {
        super(Diarista.class);
    }

    public Diarista getById(Integer pk) throws Exception {
        return (Diarista) super.find(pk);
    }

    public Diarista save(Diarista entity) throws Exception {
        return super.save(entity);
    }

    public Diarista update(Diarista entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Diarista.class);
    }

    public List<Diarista> findAll() throws Exception {
        return (List<Diarista>) super.findAll(Diarista.class);
    }
}
