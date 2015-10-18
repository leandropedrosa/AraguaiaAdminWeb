/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import enuns.CamposPesquisa;
import java.util.List;
import javax.ejb.Stateless;
import modelo.Visitantes;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class VisitantesDao extends GenericDAO<Visitantes> {

    public VisitantesDao() {
        super(Visitantes.class);
    }

    public Visitantes getById(Integer pk) throws Exception {
        return (Visitantes) super.find(pk);
    }

    public Visitantes save(Visitantes entity) throws Exception {
        return super.save(entity);
    }

    public Visitantes update(Visitantes entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Visitantes.class);
    }

    public List<Visitantes> findAll() throws Exception {
        return (List<Visitantes>) super.findAll(Visitantes.class);
    }

    public List<Visitantes> findUsuarioBySQL(String Valor, CamposPesquisa pesquisa) throws Exception {
        return (List<Visitantes>) super.findSQLResult(CamposPesquisa.montaSQL(pesquisa, Valor, null));
    }
}
