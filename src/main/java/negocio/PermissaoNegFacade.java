/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Local;
import modelo.Permissao;

/**
 *
 * @author Leandro
 */
@Local
public interface PermissaoNegFacade {

    public Permissao validaAntesDeSalvar(Permissao permissao) throws Exception;

    public Permissao getById(Integer pk) throws Exception;

    public void delete(String id) throws Exception;

    public List<Permissao> findAll() throws Exception;

    public Permissao findUsuarioByTipo(String tipo) throws Exception;
}
