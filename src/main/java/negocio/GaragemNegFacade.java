/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Local;
import modelo.Garagem;
import modelo.Titular;

/**
 *
 * @author Leandro
 */
@Local
public interface GaragemNegFacade {

    public Garagem validaAntesDeSalvar(Garagem garagem) throws Exception;

    public Garagem getById(Integer pk) throws Exception;

    public void delete(String id) throws Exception;

    public List<Garagem> findAll() throws Exception;

    public List<Titular> findAllTitular() throws Exception;

    public List<Garagem> findSQL(String valor, String campo) throws Exception;

    public List<Garagem> findByTitular(Integer idTitular) throws Exception;
}
