/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import enuns.CamposPesquisa;
import java.util.List;
import javax.ejb.Stateless;
import modelo.Porteiro;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class PorteiroDao extends GenericDAO<Porteiro> {

    public PorteiroDao() {
        super(Porteiro.class);
    }

    public Porteiro getById(Integer pk) throws Exception {
        return (Porteiro) super.find(pk);
    }

    public Porteiro save(Porteiro entity) throws Exception {
        return super.save(entity);
    }

    public Porteiro update(Porteiro entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Porteiro.class);
    }

    public List<Porteiro> findAll() throws Exception {
        return (List<Porteiro>) super.findAll(Porteiro.class);
    }

    public List<Porteiro> findUsuarioBySQL(String Valor, CamposPesquisa pesquisa) throws Exception {
        return (List<Porteiro>) super.findSQLResult(CamposPesquisa.montaSQL(pesquisa, Valor, null));
    }
}
