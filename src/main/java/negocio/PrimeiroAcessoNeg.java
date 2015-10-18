/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Apartamento;
import modelo.Dependente;
import modelo.Garagem;
import modelo.Titular;
import modelo.Usuario;
import modelo.Veiculo;
import visao.PrimeiroAcessoVisao;

/**
 *
 * @author Leandro
 */
@Stateless
public class PrimeiroAcessoNeg extends AbstractNegocio implements PrimeiroAcessoFacade {

    @EJB
    private ApartamentoNegFacade negocioAp;
    @EJB
    private DependenteNegFacade negocioDe;
    @EJB
    private GaragemNegFacade negocioGa;
    @EJB
    private VeiculoNegFacade negocioVe;
    @EJB
    private TitularNegFacade negocioTi;
    @EJB
    private UsuarioNegFacade negocioUs;

    private Titular titularSalvo;

    @Override
    public void validaAntesDeSalvar(PrimeiroAcessoVisao visao) throws Exception {
        setTitularSalvo(negocioTi.validaAntesDeSalvarRetorno(visao.getTodosTitulares().get(0)));
        salvarDependentes(visao.getTodosDependentes());
        salvarApartamentos(visao.getTodosApartamentos());
        salvarGaragens(visao.getTodosGaragens());
        salvarVeiculos(visao.getTodosVeiculos());
        alteraUsuario(visao.getTitular().getUsuario());
    }

    public void doIniciaSessaoUsuario(Usuario usuario) throws Exception {
        if (usuario.getPermissao().getTipo().equals("TITULAR")) {
            Titular titular = negocioTi.getByCPF(usuario.getCpf());
            setObjetoSessao(titular, "titular");
            List<Dependente> listaDependentes = negocioDe.findTitular(titular.getIdTitular());
            setObjetoSessao(listaDependentes, "listaDependentes");
            List<Apartamento> listaApartamentos = negocioAp.findByTitular(titular.getIdTitular());
            setObjetoSessao(listaApartamentos, "listaApartamentos");
            List<Garagem> listaGaragens = negocioGa.findByTitular(titular.getIdTitular());
            setObjetoSessao(listaGaragens, "listaGaragens");
            List<Veiculo> listaVeiculos = negocioVe.findByTitular(titular.getIdTitular());
            setObjetoSessao(listaVeiculos, "listaVeiculos");
        }
    }

    private void salvarDependentes(List<Dependente> dependentes) throws Exception {
        if (dependentes != null && !dependentes.isEmpty()) {
            for (Dependente item : dependentes) {
                item.setTitular(getTitularSalvo());
                negocioDe.validaAntesDeSalvar(item);
            }
        }
    }

    private void salvarApartamentos(List<Apartamento> apartamentos) throws Exception {
        if (apartamentos != null && !apartamentos.isEmpty()) {
            for (Apartamento item : apartamentos) {
                item.setTitular(getTitularSalvo());
                negocioAp.validaAntesDeSalvar(item);
            }
        }
    }

    private void salvarGaragens(List<Garagem> garagens) throws Exception {
        if (garagens != null && !garagens.isEmpty()) {
            for (Garagem item : garagens) {
                item.setTitular(getTitularSalvo());
                negocioGa.validaAntesDeSalvar(item);
            }
        }
    }

    private void salvarVeiculos(List<Veiculo> veiculos) throws Exception {
        if (veiculos != null && !veiculos.isEmpty()) {
            for (Veiculo item : veiculos) {
                item.setTitular(getTitularSalvo());
                negocioVe.validaAntesDeSalvar(item);
            }
        }
    }

    private void alteraUsuario(Usuario usuario) throws Exception {
        negocioUs.salvaUsuarioPrimeiroAcesso(usuario);
    }

    public Titular getTitularSalvo() {
        return titularSalvo;
    }

    public void setTitularSalvo(Titular titularSalvo) {
        this.titularSalvo = titularSalvo;
    }

}
