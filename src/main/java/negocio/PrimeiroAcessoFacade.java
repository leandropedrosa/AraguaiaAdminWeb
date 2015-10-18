/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import javax.ejb.Local;
import modelo.Usuario;
import visao.PrimeiroAcessoVisao;

/**
 *
 * @author Leandro
 */
@Local
public interface PrimeiroAcessoFacade {

    public void validaAntesDeSalvar(PrimeiroAcessoVisao visao) throws Exception;

    public void doIniciaSessaoUsuario(Usuario usuario) throws Exception;
}
