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
public interface TitularNegFacade {

    public Titular validaAntesDeSalvar(Titular titular) throws Exception;

    public Titular validaAntesDeSalvarRetorno(Titular titular) throws Exception;

    public Titular getById(Integer pk) throws Exception;

    public void update(Titular entity) throws Exception;

    public void inativar(String id) throws Exception;

    public List<Titular> findAll() throws Exception;

    public List<Titular> findSQL(String valor, String campo) throws Exception;

    public Titular getByCPF(String cpf) throws Exception;

    public List<Telefone> getTelefones(Integer idTitular) throws Exception;
}
