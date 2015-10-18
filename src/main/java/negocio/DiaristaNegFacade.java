/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Local;
import modelo.Diarista;

/**
 *
 * @author Leandro
 */
@Local
public interface DiaristaNegFacade {

    public Diarista validaAntesDeSalvar(Diarista apartamento) throws Exception;

    public Diarista getById(Integer pk) throws Exception;

    public void delete(String id) throws Exception;

    public List<Diarista> findAll() throws Exception;
}
