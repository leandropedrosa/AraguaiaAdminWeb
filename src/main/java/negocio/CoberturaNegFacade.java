/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Local;
import modelo.Cobertura;

/**
 *
 * @author Leandro
 */
@Local
public interface CoberturaNegFacade {

    public Cobertura validaAntesDeSalvar(Cobertura cobertura) throws Exception;

    public Cobertura getById(Integer pk) throws Exception;

    public void delete(String id) throws Exception;

    public List<Cobertura> findAll() throws Exception;

    public List<Cobertura> findSQL(String valor, String campo) throws Exception;
}
