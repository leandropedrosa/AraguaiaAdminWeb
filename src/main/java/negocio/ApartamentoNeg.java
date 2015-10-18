/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import enuns.CamposPesquisa;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Apartamento;
import modelo.Diarista;
import modelo.Imobiliaria;
import modelo.Negociacao;
import modelo.Titular;
import persistencia.ApartamentoDao;
import persistencia.TitularDao;
import util.Util;

/**
 *
 * @author Leandro
 */
@Stateless
public class ApartamentoNeg extends AbstractNegocio implements ApartamentoNegFacade {

    @EJB
    private ApartamentoDao dao;

    @EJB
    private TitularDao daoTitular;

    @EJB
    private ImobiliariaNegFacade imobiliariaNeg;

    @EJB
    private DiaristaNegFacade diaristaNeg;

    @EJB
    private NegociacaoNegFacade negociacaoNeg;

    @Override
    public Apartamento validaAntesDeSalvar(Apartamento apartamento) throws Exception {
        if (apartamento.getIdApartamento() == null) {
            return salvar(apartamento);
        } else {
            return editar(apartamento);
        }
    }

    private Apartamento salvar(Apartamento apartamento) throws Exception {

        Apartamento existe = dao.getByNumero(apartamento.getNumero());
        if (existe != null && existe.getTitular() != null) {
            throw new Exception("Apartamento já vinculado há um titular na base de dados!");
        }
        Diarista diarista = null;
        Imobiliaria imobiliaria = null;
        Apartamento apartamentoSalvo = null;
        if (apartamento.getDiarista() != null && !"".equals(apartamento.getDiarista().getNomeDiarista())) {
            diarista = diaristaNeg.validaAntesDeSalvar(apartamento.getDiarista());
            apartamento.setDiarista(diarista);
        }
        if (apartamento.getImobiliaria() != null && !"".equals(apartamento.getImobiliaria().getNomeImobiliaria())) {
            imobiliaria = imobiliariaNeg.validaAntesDeSalvar(apartamento.getImobiliaria());
            apartamento.setImobiliaria(imobiliaria);
        }
        apartamento.setBloco(Util.retornaBlocoPeloLetra(apartamento.getNumero()));
        apartamento.setSituacao("O");
        List<Negociacao> listaNegociacao = apartamento.getNegociacaoList();
        apartamento.setNegociacaoList(null);
        apartamentoSalvo = dao.save(camposObrigatorios(apartamento));
        apartamentoSalvo.setNegociacaoList(listaNegociacao);
        salvarNegociacao(apartamentoSalvo);
        return apartamentoSalvo;
    }

    private Apartamento editar(Apartamento apartamento) throws Exception {
        dao.update(camposObrigatorios(apartamento));
        return dao.update(camposObrigatorios(apartamento));
    }

    private void salvarNegociacao(Apartamento apartamentoSalvo) throws Exception {
        if (apartamentoSalvo.getNegociacaoList() != null && !apartamentoSalvo.getNegociacaoList().isEmpty()) {
            for (Negociacao item : apartamentoSalvo.getNegociacaoList()) {
                item.setApartamento(apartamentoSalvo);
                negociacaoNeg.validaAntesDeSalvar(item);
            }
        }
    }

    @Override
    public void inativar(String id) throws Exception {
        Apartamento ap = dao.find(Integer.parseInt(id));
        ap.setDiarista(null);
        ap.setImobiliaria(null);
        ap.setTitular(null);

        ap.setPossuiAnimais(null);
        ap.setPossuiArCondicionado(null);
        ap.setPossuiBicicleta(null);
        ap.setPossuiAnimais(null);
        ap.setPossuiInternet(null);
        ap.setSituacao("I");
        dao.save(ap);
    }

    private Apartamento camposObrigatorios(Apartamento apartamento) throws Exception {
        if (apartamento.getQuartos() == null || apartamento.getQuartos() == 0) {
            throw new Exception("Apartamento com o campo Quartos nulo ou vazio");
        }
        if (apartamento.getNumero() == null || apartamento.getNumero() == "") {
            throw new Exception("Apartamento com o campo Numero nulo ou vazio");
        }
        if (apartamento.getTitular() == null || apartamento.getTitular().getNome() == "") {
            throw new Exception("Apartamento com o campo Titular nulo ou vazio");
        }
        if (apartamento.getBloco() == null || apartamento.getBloco().getSigla() == "") {
            throw new Exception("Apartamento com o campo Bloco nulo ou vazio");
        }
        if (apartamento.getSituacao() == null || apartamento.getSituacao() == "") {
            throw new Exception("Apartamento com o campo Situação nulo ou vazio");
        }
        return apartamento;
    }

    @Override
    public Apartamento getById(Integer pk) throws Exception {
        return dao.getById(pk);
    }

    @Override
    public List<Apartamento> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List<Titular> findAllTitular() throws Exception {
        return daoTitular.findAll();
    }

    @Override
    public List<Apartamento> findByTitular(Integer idTitular) throws Exception {
        return dao.getByTitular(idTitular);
    }

    @Override
    public List<Apartamento> findSQL(String valor, String campo) throws Exception {
        if (valor != null && valor != "" && campo != null && campo != "") {
            return dao.findUsuarioBySQL(valor, CamposPesquisa.retornaEnuCampo(campo));
        } else {
            return null;
        }
    }
}
