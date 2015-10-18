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
import util.InformacoesApartamentos;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("unchecked")
@Stateless
public class InformacoesApartamentosDao extends GenericDAO<InformacoesApartamentos> {

    public InformacoesApartamentosDao() {
        super(InformacoesApartamentos.class);
    }

    public List<InformacoesApartamentos> getInformacoesApartamentos() throws Exception {
        List<InformacoesApartamentos> retorno = null;
        try {
            Query query = em.createNativeQuery(montaSql(), InformacoesApartamentos.class);
            retorno = (List<InformacoesApartamentos>) query.getResultList();

        } catch (NoResultException nre) {
            return null;
        }
        return retorno;
    }

    private String montaSql() throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" -- Apartamentos Ocupados \n"
                + " select 'Apartamento Ocupados' as tipo, count(a.idApartamento) as contador \n"
                + " from apartamento a \n"
                + " where a.idTitular is not null \n"
                + " \n"
                + " union \n"
                + " \n"
                + "-- Apartamentos vazios \n"
                + " select 'Apartamento vazios' as tipo, count(a.idApartamento) as contador \n"
                + " from apartamento a \n"
                + " where a.idTitular is null \n"
                + " \n"
                + " union \n"
                + " \n"
                + "-- Apartamentos para alugar \n"
                + " select 'Apartamento Alugar' as tipo, count(a.idApartamento) as contador \n"
                + " from apartamento a \n"
                + " inner join negociacao n on n.idApartamento = a.idApartamento \n"
                + " where n.tipo = 'A' \n"
                + " \n"
                + "union \n"
                + " \n"
                + "-- Apartamentos para alugar \n"
                + " select 'Apartamento Venda' as tipo, count(*) as contador \n"
                + " from apartamento \n"
                + " inner join negociacao on negociacao.idApartamento = apartamento.idApartamento \n"
                + " where negociacao.tipo = 'V' ");
        return sql.toString();
    }
}
