/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controle.UsuarioControle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import modelo.Usuario;
import negocio.UsuarioNegFacade;

/**
 *
 * @author Leandro
 */
@Stateless
@Path("modelo.usuario")
public class UsuarioFacadeREST {

    @EJB
    private UsuarioNegFacade negocio;

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        try {
            negocio.delete(id.toString());
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Usuario entity) {
        try {
            negocio.validaAntesDeSalvar(entity);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
        try {
            negocio.validaAntesDeSalvar(entity);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
