/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Local;
import modelo.Apartamento;
import modelo.Titular;

/**
 *
 * @author Leandro
 */
@Local
public interface ApartamentoNegFacade {

    public Apartamento validaAntesDeSalvar(Apartamento apartamento) throws Exception;

    public Apartamento getById(Integer pk) throws Exception;

    public List<Apartamento> findAll() throws Exception;

    public List<Titular> findAllTitular() throws Exception;

    public List<Apartamento> findSQL(String valor, String campo) throws Exception;

    public void inativar(String id) throws Exception;

    public List<Apartamento> findByTitular(Integer idTitular) throws Exception;
}
