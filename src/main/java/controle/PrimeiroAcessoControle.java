/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author Leandro
 */
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import modelo.Apartamento;
import modelo.Dependente;
import modelo.Garagem;
import modelo.Titular;
import modelo.Usuario;
import modelo.Veiculo;
import negocio.PrimeiroAcessoFacade;
import negocio.UsuarioNegFacade;
import visao.PrimeiroAcessoVisao;

@ViewScoped
@ManagedBean(name = "primeiroAcessoControle")
public class PrimeiroAcessoControle extends AbstractControle implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private PrimeiroAcessoFacade negocio;

    @EJB
    private UsuarioNegFacade negocioUs;

    @EJB
    private UsuarioNegFacade usuarioNeg;

    private PrimeiroAcessoVisao visao;

    @PostConstruct
    private void iniciar() {
        try {
            if (getVisao().getTitular() == null) {
                if (getUsuarioSessao() != null) {
                    getVisao().setTitular(new Titular());
                    Usuario usuario = obtemUsuario();
                    if (usuario != null) {
                        getVisao().getTitular().setNome(usuario.getNome());
                        getVisao().getTitular().setEmail(usuario.getEmail());
                        getVisao().getTitular().setUsuario(usuario);
                        setUsuarioAdmin(true);
                    } else {
                        setUsuarioAdmin(false);
                    }
                    getVisao().setCadastroTitular(Boolean.TRUE);
                }
            }
            if (getVisao().getTodosUsuarios() == null) {
                getVisao().setTodosUsuarios(usuarioNeg.findAll());
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void selecionarUsuario(AjaxBehaviorEvent ev) {
        Usuario usuarioSelecionado = (Usuario) ((UIInput) ev.getComponent()).getValue();
        getVisao().getTitular().setUsuario(usuarioSelecionado);
        getVisao().getTitular().setNome(usuarioSelecionado.getNome());
        getVisao().getTitular().setEmail(usuarioSelecionado.getEmail());
    }

    private Usuario obtemUsuario() throws Exception {
        if (getUsuarioSessao().getPermissao().getTipo().equals("TEMPORARIO")) {
            return negocioUs.getByCPF(getUsuarioSessao().getCpf());
        }
        return null;
    }

    public String doSalvarCadastro() {
        try {
            negocio.validaAntesDeSalvar(getVisao());
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Dados enviados com sucesso!!"));
            return "/home.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
        return null;
    }

    public String doCancelarCadastro() {
        setVisao(null);
        setUsuarioSessao(null);
        return "/AraguaiaAdminWeb-1.0/inicial.xhtml?faces-redirect=true";
    }

    public void doDirecionar() {
        String etapasId = retornaParamentros().get("etapasId");
        if (etapasId != null && !etapasId.equals("")) {
            getVisao().setCadastroTitular(etapasId.equals("titular"));
            getVisao().setCadastroDependentes(etapasId.equals("dependentes"));
            getVisao().setCadastroApartamento(etapasId.equals("apartamento"));
            getVisao().setCadastroGaragem(etapasId.equals("garagem"));
            getVisao().setCadastroVeiculo(etapasId.equals("veiculo"));
            getVisao().setCadastroFinalizar(etapasId.equals("finalizar"));
        }
    }

    public void doAvancar() {
        String etapasId = retornaParamentros().get("etapasId");
        if (etapasId != null && !etapasId.equals("")) {
            getVisao().setEtapas(getVisao().getEtapas() + 1);
            doDirecionar();
        }
    }

    public void doIncluirTitular() {
        if (getVisao().getTitular().getNome() != null) {
            getVisao().adicionaTelefone();
            getVisao().getTodosTitulares().add(getVisao().getTitular());
        }
    }

    public void dosSelecionarTitular() {
        getVisao().setTitular(getVisao().getTodosTitulares().get(0));
    }

    public void doExcluirTitular() {
        getVisao().getTodosTitulares().clear();
    }

    public void doIncluirApartamento() {
        if (getVisao().getApartamento().getNumero() != null) {
            getVisao().obtemValores();
            getVisao().getTodosApartamentos().add(getVisao().getApartamento());
        }
        getVisao().setApartamento(null);
    }

    public void doSelecionarApartamento() {
        String ap = retornaParamentros().get("editarAp");
        if (ap != null) {
            for (Apartamento item : getVisao().getTodosApartamentos()) {
                if (item.getNumero().equals(ap)) {
                    getVisao().setApartamento(item);
                }
            }
        }
    }

    public void doExcluirApartamento() {
        Apartamento excluido = null;
        String ap = retornaParamentros().get("excluirAp");
        if (ap != null) {
            for (Apartamento item : getVisao().getTodosApartamentos()) {
                if (item.getNumero().equals(ap)) {
                    excluido = item;
                }
            }
            getVisao().getTodosApartamentos().remove(excluido);
        }
    }

    public void doIncluirDependente() {
        if (getVisao().getDependente() != null) {
            getVisao().getTodosDependentes().add(getVisao().getDependente());
        }
        getVisao().setDependente(null);
    }

    public void doSelecionarDependente() {
        String de = retornaParamentros().get("editarDe");
        if (de != null) {
            for (Dependente item : getVisao().getTodosDependentes()) {
                if (item.getRg().equals(de)) {
                    getVisao().setDependente(item);
                }
            }
        }
    }

    public void doExcluirDependente() {
        Dependente excluido = null;
        String de = retornaParamentros().get("excluirDe");
        if (de != null) {
            for (Dependente item : getVisao().getTodosDependentes()) {
                if (item.getRg().equals(de)) {
                    excluido = item;
                }
            }
            getVisao().getTodosDependentes().remove(excluido);
        }
    }

    public void doIncluirGaragem() {
        if (getVisao().getGaragem() != null) {
            getVisao().getTodosGaragens().add(getVisao().getGaragem());
        }
        getVisao().setGaragem(null);
    }

    public void doSelecionarGaragem() {
        String ga = retornaParamentros().get("editarGa");
        if (ga != null) {
            for (Garagem item : getVisao().getTodosGaragens()) {
                if (item.getNumero().equals(ga)) {
                    getVisao().setGaragem(item);
                }
            }
        }
    }

    public void doExcluirGaragem() {
        Garagem excluido = null;
        String ga = retornaParamentros().get("excluirGa");
        if (ga != null) {
            for (Garagem item : getVisao().getTodosGaragens()) {
                if (item.getNumero().equals(ga)) {
                    excluido = item;
                }
            }
            getVisao().getTodosGaragens().remove(excluido);
        }
    }

    public void doIncluirVeiculo() {
        if (getVisao().getVeiculo() != null) {
            getVisao().getTodosVeiculos().add(getVisao().getVeiculo());
        }
        getVisao().setVeiculo(null);
    }

    public void doSelecionarVeiculo() {
        String ve = retornaParamentros().get("editarVe");
        if (ve != null) {
            for (Veiculo item : getVisao().getTodosVeiculos()) {
                if (item.getPlaca().equals(ve)) {
                    getVisao().setVeiculo(item);
                }
            }
        }
    }

    public void doExcluirVeiculo() {
        Veiculo excluido = null;
        String ve = retornaParamentros().get("excluirVe");
        if (ve != null) {
            for (Veiculo item : getVisao().getTodosVeiculos()) {
                if (item.getPlaca().equals(ve)) {
                    excluido = item;
                }
            }
            getVisao().getTodosVeiculos().remove(excluido);
        }
    }

    public PrimeiroAcessoVisao getVisao() {
        if (visao == null) {
            visao = new PrimeiroAcessoVisao();
        }
        return visao;
    }

    public void setVisao(PrimeiroAcessoVisao visao) {
        this.visao = visao;
    }

}
