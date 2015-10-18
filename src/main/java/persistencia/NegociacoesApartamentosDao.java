/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import util.NegociacoesApartamentos;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class NegociacoesApartamentosDao extends GenericDAO<NegociacoesApartamentos> {

    public NegociacoesApartamentosDao() {
        super(NegociacoesApartamentos.class);
    }

    public List<NegociacoesApartamentos> getNegociacoesApartamentos() throws Exception {
        List<NegociacoesApartamentos> retorno = null;
        try {
            Query query = em.createNativeQuery(montaSql(), NegociacoesApartamentos.class);
            retorno = (List<NegociacoesApartamentos>) query.getResultList();

        } catch (NoResultException nre) {
            return null;
        }
        return retorno;
    }

    private String montaSql() throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select \n"
                + "	n.idNegociacao, \n"
                + "	n.tipo as tipoNegociacao, \n"
                + "	n.valor as valorNegociacao, \n"
                + "	a.quartos as quantidadeDeQuartos, \n"
                + "	t.email as titularEmail, \n"
                + "	t.nome as titularNome,\n"
                + "	te.numero as telefoneNumero, \n"
                + "	a.numero as apartamentoNumero \n"
                + " from apartamento a\n"
                + " inner join negociacao n on n.idApartamento = a.idApartamento \n"
                + " inner join titular t on t.idTitular = a.idTitular \n"
                + " inner join telefone te on te.idTitular = a.idTitular \n"
                + " where n.publicar = 'S' and te.tipo = 'R' ");
        return sql.toString();
    }
}
