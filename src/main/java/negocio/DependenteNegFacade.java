/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Local;
import modelo.Dependente;
import modelo.Titular;

/**
 *
 * @author Leandro
 */
@Local
public interface DependenteNegFacade {

    public Dependente validaAntesDeSalvar(Dependente dependente) throws Exception;

    public Dependente getById(Integer pk) throws Exception;

    public void delete(String id) throws Exception;

    public List<Dependente> findAll() throws Exception;

    public List<Titular> findAllTitular() throws Exception;

    public List<Dependente> findSQL(String valor, String campo) throws Exception;

    public List<Dependente> findTitular(Integer idTitular) throws Exception;

}
