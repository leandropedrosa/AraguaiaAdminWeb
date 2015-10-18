/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Local;
import modelo.Negociacao;
import util.InformacoesApartamentos;
import util.NegociacoesApartamentos;

/**
 *
 * @author Leandro
 */
@Local
public interface NegociacaoNegFacade {

    public Negociacao validaAntesDeSalvar(Negociacao negociacao) throws Exception;

    public Negociacao getById(Integer pk) throws Exception;

    public void delete(String id) throws Exception;

    public List<Negociacao> findAll() throws Exception;

    public List<InformacoesApartamentos> retornaInformacoesApartamentos() throws Exception;

    public List<NegociacoesApartamentos> retornaNegociacoesApartamentos() throws Exception;

    public List<Negociacao> findByApartamento(Integer idApartamento) throws Exception;
}
