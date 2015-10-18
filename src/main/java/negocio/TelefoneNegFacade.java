/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Local;
import modelo.Telefone;
import modelo.Titular;

/**
 *
 * @author Leandro
 */
@Local
public interface TelefoneNegFacade {

    public void validaAntesDeSalvar(Titular titular) throws Exception;

    public Telefone getById(Integer pk) throws Exception;

    public void delete(String id) throws Exception;

    public List<Telefone> findAll() throws Exception;

    public List<Telefone> findByTitular(Integer idTitular) throws Exception;
}
