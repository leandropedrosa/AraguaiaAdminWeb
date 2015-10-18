/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import negocio.NegociacaoNegFacade;
import util.NegociacoesApartamentos;

/**
 *
 * @author Leandro
 */
@Stateless
@Path("util.NegociacoesApartamentos")
public class NegociacoesApartamentosFacadeREST {

    @EJB
    private NegociacaoNegFacade negocio;

    @GET
    @Produces({"application/xml", "application/json"})
    public Response findNegociacoesApartamentos() throws Exception {

        List<NegociacoesApartamentos> informacoes = negocio.retornaNegociacoesApartamentos();
        GenericEntity<List<NegociacoesApartamentos>> informacoesWrapper = new GenericEntity<List<NegociacoesApartamentos>>(informacoes) {
        };

        return Response.ok(informacoesWrapper).build();
    }
}
