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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import modelo.Telefone;
import modelo.Titular;
import modelo.Usuario;
import negocio.TitularNegFacade;
import negocio.UsuarioNegFacade;
import visao.TitularVisao;

@ViewScoped
@ManagedBean(name = "titularControle")
public class TitularControle extends AbstractControle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private TitularNegFacade negocio;

    @EJB
    private UsuarioNegFacade usuarioNeg;

    private List<Titular> todosTitulares;
    private List<Usuario> todosUsuarios;

    private TitularVisao visao = null;

    @PostConstruct
    private void iniciar() {
        try {
            if (visao == null) {
                visao = new TitularVisao();
            }
            if (getUsuarioSessao().getPermissao().getTipo().equals("ADMIN") || getUsuarioSessao().getPermissao().getTipo().equals("SINDICO") || getUsuarioSessao().getPermissao().getTipo().equals("PORTEIRO")) {
                if (todosTitulares == null) {
                    todosTitulares = negocio.findAll();
                }
                if (todosUsuarios == null) {
                    todosUsuarios = usuarioNeg.findAll();
                }
                setUsuarioAdmin(true);
            } else {
                if (getUsuarioSessao().getPermissao().getTipo().equals("TITULAR")) {
                    getVisao().setTitular((Titular) getObjetoSessao("titular"));
                    getVisao().getTitular().setUsuario(getUsuarioSessao());
                    getVisao().converListTelefone(negocio.getTelefones(getVisao().getTitular().getIdTitular()));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void salvar() {
        try {
            adicionaTelefone();
            negocio.validaAntesDeSalvar(getVisao().getTitular());
            setTodosTitulares(null);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Titular cadastrado com sucesso!!"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void excluir() {
        try {
            String id = retornaParamentros().get("excluir");
            negocio.inativar(id);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Titular excluído com sucesso!!"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void editar() {
        try {
            String user = retornaParamentros().get("editar");
            Titular entity = negocio.getById(Integer.parseInt(user));
            getVisao().setTitular(entity);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void cancelar() {
        getVisao().setTitular(null);
    }

    public void selecionarUsuario(AjaxBehaviorEvent ev) {
        Usuario usuarioSelecionado = (Usuario) ((UIInput) ev.getComponent()).getValue();
        getVisao().getTitular().setUsuario(usuarioSelecionado);
        getVisao().getTitular().setNome(usuarioSelecionado.getNome());
    }

    public List<Titular> getTodosTitulares() {
        return todosTitulares;
    }

    public void setTodosTitulares(List<Titular> todosTitulares) {
        this.todosTitulares = todosTitulares;
    }

    public List<Usuario> getTodosUsuarios() {
        return todosUsuarios;
    }

    public void setTodosUsuarios(List<Usuario> todosUsuarios) {
        this.todosUsuarios = todosUsuarios;
    }

    public TitularVisao getVisao() {
        return visao;
    }

    public void setVisao(TitularVisao visao) {
        this.visao = visao;
    }

    private void adicionaTelefone() {
        List<Telefone> listaTelefone = new ArrayList<Telefone>();
        if (getVisao().getTitular().getNome() != null) {
            if (getVisao().getTelefoneCelular() != null) {
                listaTelefone.add(new Telefone(null, getVisao().getTelefoneCelular().getNumero(), "C"));
            }
            if (getVisao().getTelefoneComercial().getNumero() != null) {
                listaTelefone.add(new Telefone(null, getVisao().getTelefoneComercial().getNumero(), "O"));
            }
            if (getVisao().getTelefoneEmergencia().getNumero() != null) {
                listaTelefone.add(new Telefone(null, getVisao().getTelefoneEmergencia().getNumero(), "1"));
            }
            if (getVisao().getTelefoneEmergencia2().getNumero() != null) {
                listaTelefone.add(new Telefone(null, getVisao().getTelefoneEmergencia2().getNumero(), "2"));
            }
            if (getVisao().getTelefoneResidencial().getNumero() != null) {
                listaTelefone.add(new Telefone(null, getVisao().getTelefoneResidencial().getNumero(), "R"));
            }
            getVisao().getTitular().setTelefoneList(listaTelefone);
        }
    }
}
