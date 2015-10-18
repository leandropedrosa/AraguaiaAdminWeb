/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Local;
import modelo.Imobiliaria;

/**
 *
 * @author Leandro
 */
@Local
public interface ImobiliariaNegFacade {

    public Imobiliaria validaAntesDeSalvar(Imobiliaria imobiliaria) throws Exception;

    public Imobiliaria getById(Integer pk) throws Exception;

    public void delete(Integer id) throws Exception;

    public List<Imobiliaria> findAll() throws Exception;
}
