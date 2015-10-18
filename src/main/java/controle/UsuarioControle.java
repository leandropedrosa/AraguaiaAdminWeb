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
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import modelo.Permissao;
import modelo.Usuario;
import negocio.UsuarioNegFacade;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import visao.UsuarioVisao;

@ViewScoped
@ManagedBean(name = "usuarioControle")
public class UsuarioControle extends AbstractControle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private UsuarioNegFacade negocio;
    private UsuarioVisao visao = null;
    private List<Usuario> todosUsuarios;
    private List<Permissao> todasPermissao;
    private Part foto;
    private String fileContent;

    private StreamedContent imagemEnviada = new DefaultStreamedContent();
    private String imagemTemporaria;
    private CroppedImage croppedImage;
    private boolean exibeBotao = false;

    @PostConstruct
    private void iniciar() {
        try {
            if (visao == null) {
                visao = new UsuarioVisao();
            }
            if (getUsuarioSessao() != null) {
                if (getUsuarioSessao().getPermissao().getTipo().equals("ADMIN") || getUsuarioSessao().getPermissao().getTipo().equals("SINDICO") || getUsuarioSessao().getPermissao().getTipo().equals("PORTEIRO")) {
                    if (todosUsuarios == null) {
                        todosUsuarios = negocio.findAll();
                    }
                    if (todasPermissao == null) {
                        todasPermissao = negocio.findAllPermissoes();
                    }
                    setUsuarioAdmin(true);
                } else {
                    if (getUsuarioSessao().getPermissao().getTipo().equals("TITULAR")) {
                        getVisao().setUsuario(getUsuarioSessao());
                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void salvar() {
        try {
            setTodosUsuarios(null);
            negocio.validaAntesDeSalvar(getVisao().getUsuario());
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Usuario cadastrado com sucesso!!"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void excluir() {
        try {
            setTodosUsuarios(null);
            String id = retornaParamentros().get("excluir");
            negocio.delete(id);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Usuario excluído com sucesso!!"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void editar() {
        try {
            String user = retornaParamentros().get("editar");
            Usuario entity = negocio.getById(Integer.parseInt(user));
            getVisao().setUsuario(entity);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void cancelar() {
        getVisao().setUsuario(null);
    }

    public void pesquisar() {
        try {
            setTodosUsuarios(negocio.findSQL(getVisao().getValorPesquisa(), getVisao().getValorSelecionado()));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void fireSelection(AjaxBehaviorEvent ev) {
        getVisao().setValorSelecionado((String) ((UIOutput) ev.getSource()).getValue());
    }

    public String salvarUsuarioInicial() {
        try {
            getVisao().getUsuario().setPrimeiroAcesso("S");
            Usuario usuario = negocio.validaAntesDeSalvar(getVisao().getUsuario());
            if (usuario != null) {
                super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Usuario salvo com sucesso!!"));
                return "/pages/login/login.xhtml?faces-redirect=true";
            } else {
                super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_WARN, "Operação Não Realizada!", "Usuario não cadastrado!!"));
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
        return null;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public void doResetarSenha() {
        try {
            negocio.resetarSenha(getVisao().getCpfResetarSenha());
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada!", "Nova senha enviada!!"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
        }
    }

    public void criaArquivo(byte[] bytes, String arquivo) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(arquivo);
            fos.write(bytes);
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void upload(FileUploadEvent event) {
        if (getFoto() != null) {
            InputStream is;
            try {
                setFileContent(new Scanner(event.getFile().getInputstream()).useDelimiter("\\A").next());
                byte[] results = new byte[(int) foto.getSize()];
                InputStream in = foto.getInputStream();
                in.read(results);
                getVisao().getUsuario().setFoto(results);
            } catch (IOException ex) {
                Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
                super.exibirMensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operação!", ex.getMessage()));
            }
        }
    }

    public void enviarImagem(FileUploadEvent event) {
        byte[] img = event.getFile().getContents();
        imagemTemporaria = event.getFile().getFileName();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
        String arquivo = scontext.getRealPath("/resources/dist/img/" + imagemTemporaria);
        criaArquivo(img, arquivo);
        setExibeBotao(true);
    }

    public void crop() {
        setImagemEnviada(new DefaultStreamedContent(new ByteArrayInputStream(croppedImage.getBytes())));
    }

    public UsuarioNegFacade getNegocio() {
        return negocio;
    }

    public void setNegocio(UsuarioNegFacade negocio) {
        this.negocio = negocio;
    }

    public StreamedContent getImagemEnviada() {
        return imagemEnviada;
    }

    public void setImagemEnviada(StreamedContent imagemEnviada) {
        this.imagemEnviada = imagemEnviada;
    }

    public String getImagemTemporaria() {
        return imagemTemporaria;
    }

    public void setImagemTemporaria(String imagemTemporaria) {
        this.imagemTemporaria = imagemTemporaria;
    }

    public CroppedImage getCroppedImage() {
        return croppedImage;
    }

    public void setCroppedImage(CroppedImage croppedImage) {
        this.croppedImage = croppedImage;
    }

    public boolean isExibeBotao() {
        return exibeBotao;
    }

    public void setExibeBotao(boolean exibeBotao) {
        this.exibeBotao = exibeBotao;
    }

    public UsuarioVisao getVisao() {
        return visao;
    }

    public void setVisao(UsuarioVisao visao) {
        this.visao = visao;
    }

    public List<Usuario> getTodosUsuarios() {
        return todosUsuarios;
    }

    public void setTodosUsuarios(List<Usuario> todosUsuarios) {
        this.todosUsuarios = todosUsuarios;
    }

    public List<Permissao> getTodasPermissao() {
        return todasPermissao;
    }

    public void setTodasPermissao(List<Permissao> todasPermissao) {
        this.todasPermissao = todasPermissao;
    }

    public Part getFoto() {
        return foto;
    }

    public void setFoto(Part foto) {
        this.foto = foto;
    }

}
