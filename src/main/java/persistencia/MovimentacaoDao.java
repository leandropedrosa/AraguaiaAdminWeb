/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import enuns.CamposPesquisa;
import java.util.List;
import javax.ejb.Stateless;
import modelo.Movimentacao;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class MovimentacaoDao extends GenericDAO<Movimentacao> {

    public MovimentacaoDao() {
        super(Movimentacao.class);
    }

    public Movimentacao getById(Integer pk) throws Exception {
        return (Movimentacao) super.find(pk);
    }

    public Movimentacao save(Movimentacao entity) throws Exception {
        return super.save(entity);
    }

    public Movimentacao update(Movimentacao entity) throws Exception {
        return super.update(entity);
    }

    public void delete(Integer pk) throws Exception {
        super.delete(pk, Movimentacao.class);
    }

    public List<Movimentacao> findAll() throws Exception {
        return (List<Movimentacao>) super.findAll(Movimentacao.class);
    }

    public List<Movimentacao> findUsuarioBySQL(String Valor, CamposPesquisa pesquisa) throws Exception {
        return (List<Movimentacao>) super.findSQLResult(CamposPesquisa.montaSQL(pesquisa, Valor, null));
    }
}
