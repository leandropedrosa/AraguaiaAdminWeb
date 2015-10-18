/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import modelo.Telefone;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class TelefoneDao extends GenericDAO<Telefone> {

    public TelefoneDao() {
        super(Telefone.class);
    }

    public Telefone getById(Integer pk) throws Exception {
        return (Telefone) super.find(pk);
    }

    public Telefone save(Telefone entity) throws Exception {
        return super.save(entity);
    }

    public Telefone update(Telefone entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Telefone.class);
    }

    public List<Telefone> findAll() throws Exception {
        return (List<Telefone>) super.findAll(Telefone.class);
    }

    public List<Telefone> getByTitular(Integer idTitular) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("idTitular", idTitular);
        return (List<Telefone>) super.findListResultName(Telefone.FIND_BY_TITULAR, parameters);
    }
}
