/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Negociacao;
import persistencia.InformacoesApartamentosDao;
import persistencia.NegociacaoDao;
import persistencia.NegociacoesApartamentosDao;
import util.InformacoesApartamentos;
import util.NegociacoesApartamentos;

/**
 *
 * @author Leandro
 */
@Stateless
public class NegociacaoNeg extends AbstractNegocio implements NegociacaoNegFacade {

    @EJB
    private NegociacaoDao dao;

    @EJB
    private NegociacoesApartamentosDao negAptsDao;

    @EJB
    private InformacoesApartamentosDao InfAptsDao;

    @Override
    public Negociacao validaAntesDeSalvar(Negociacao negociacao) throws Exception {
        if (negociacao.getIdNegociacao() == null) {
            return salvar(negociacao);
        } else {
            return editar(negociacao);
        }
    }

    private Negociacao salvar(Negociacao negociacao) throws Exception {
        return dao.save(camposObrigatorios(negociacao));
    }

    private Negociacao editar(Negociacao negociacao) throws Exception {
        return dao.update(camposObrigatorios(negociacao));
    }

    private Negociacao camposObrigatorios(Negociacao negociacao) throws Exception {
        if (negociacao.getApartamento().getNumero() == null || negociacao.getApartamento().getNumero() == "") {
            throw new Exception("Negociacao com o campo Apartamento nulo ou vazio");
        }
        if (negociacao.getTipo() == null || negociacao.getTipo() == "") {
            throw new Exception("Negociacao com o campo Tipo nulo ou vazio");
        }
        if (negociacao.getValor() == null || negociacao.getValor() == 0.00) {
            throw new Exception("Negociacao com o campo Valor nulo ou vazio");
        }
        return negociacao;
    }

    public Negociacao getById(Integer pk) throws Exception {
        return dao.getById(pk);
    }

    @Override
    public void delete(String id) throws Exception {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public List<Negociacao> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List<NegociacoesApartamentos> retornaNegociacoesApartamentos() throws Exception {
        return negAptsDao.getNegociacoesApartamentos();
    }

    @Override
    public List<Negociacao> findByApartamento(Integer idApartamento) throws Exception {
        return dao.getByApartamnto(idApartamento);
    }

    @Override
    public List<InformacoesApartamentos> retornaInformacoesApartamentos() throws Exception {
        return InfAptsDao.getInformacoesApartamentos();
    }
}
