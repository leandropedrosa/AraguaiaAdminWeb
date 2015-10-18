/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Local;
import modelo.Titular;
import modelo.Veiculo;

/**
 *
 * @author Leandro
 */
@Local
public interface VeiculoNegFacade {

    public Veiculo validaAntesDeSalvar(Veiculo veiculo) throws Exception;

    public Veiculo getById(Integer pk) throws Exception;

    public void delete(String id) throws Exception;

    public List<Veiculo> findAll() throws Exception;

    public List<Titular> findAllTitular() throws Exception;

    public List<Veiculo> findSQL(String valor, String campo) throws Exception;

    public List<Veiculo> findByTitular(int idTitular) throws Exception;
}
