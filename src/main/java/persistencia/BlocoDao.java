/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Stateless;
import modelo.Bloco;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class BlocoDao extends GenericDAO<Bloco> {

    public BlocoDao() {
        super(Bloco.class);
    }

    public Bloco getById(Integer pk) throws Exception {
        return (Bloco) super.find(pk);
    }

    public Bloco save(Bloco entity) throws Exception {
        return super.save(entity);
    }

    public Bloco update(Bloco entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Bloco.class);
    }

    public List<Bloco> findAll() throws Exception {
        return (List<Bloco>) super.findAll(Bloco.class);
    }
}
