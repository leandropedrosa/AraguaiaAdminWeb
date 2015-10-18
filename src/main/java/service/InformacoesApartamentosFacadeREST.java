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
import util.InformacoesApartamentos;

/**
 *
 * @author Leandro
 */
@Stateless
@Path("util.InformacoesApartamentos")
public class InformacoesApartamentosFacadeREST {

    @EJB
    private NegociacaoNegFacade negocio;

    @GET
    @Produces({"application/xml", "application/json"})
    public Response findInformacoesApartamentos() throws Exception {

        List<InformacoesApartamentos> informacoes = negocio.retornaInformacoesApartamentos();
        GenericEntity<List<InformacoesApartamentos>> informacoesWrapper = new GenericEntity<List<InformacoesApartamentos>>(informacoes) {
        };

        return Response.ok(informacoesWrapper).build();
    }

}
