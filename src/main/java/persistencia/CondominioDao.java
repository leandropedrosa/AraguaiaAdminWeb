/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Stateless;
import modelo.Condominio;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class CondominioDao extends GenericDAO<Condominio> {

    public CondominioDao() {
        super(Condominio.class);
    }

    public Condominio getById(Integer pk) throws Exception {
        return (Condominio) super.find(pk);
    }

    public Condominio save(Condominio entity) throws Exception {
        return super.save(entity);
    }

    public Condominio update(Condominio entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Condominio.class);
    }

    public List<Condominio> findAll() throws Exception {
        return (List<Condominio>) super.findAll(Condominio.class);
    }
}
