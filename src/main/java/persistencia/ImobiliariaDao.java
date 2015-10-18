/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Stateless;
import modelo.Imobiliaria;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class ImobiliariaDao extends GenericDAO<Imobiliaria> {

    public ImobiliariaDao() {
        super(Imobiliaria.class);
    }

    public Imobiliaria getById(Integer pk) throws Exception {
        return (Imobiliaria) super.find(pk);
    }

    public Imobiliaria save(Imobiliaria entity) throws Exception {
        return super.save(entity);
    }

    public Imobiliaria update(Imobiliaria entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Imobiliaria.class);
    }

    public List<Imobiliaria> findAll() throws Exception {
        return (List<Imobiliaria>) super.findAll(Imobiliaria.class);
    }
}
