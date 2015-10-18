/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import controle.LoginControle;
import email.EmailBeanFacade;
import enuns.CamposPesquisa;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Permissao;
import modelo.Usuario;
import persistencia.UsuarioDao;
import util.ConfiguracaoInicialFacade;
import util.Email;
import util.Util;

/**
 *
 * @author Leandro
 */
@Stateless
public class UsuarioNeg extends AbstractNegocio implements UsuarioNegFacade {

    @EJB
    private UsuarioDao dao;
    @EJB
    private EmailBeanFacade email;

    @EJB
    private PermissaoNegFacade permissaoNeg;

    @EJB
    private ConfiguracaoInicialFacade configuracaoInicial;

    @Override
    public Usuario validaAntesDeLogar(Usuario usuario) throws Exception {
        Usuario usuariologado = null;
        primeiraCargaDoSistema(usuario);
        usuariologado = (Usuario) dao.findUsuarioByLogin(usuario.getCpf(), usuario.getSenha());
        if (usuariologado == null) {
            throw new Exception("Login ou senha divergentes!");
        } else {
            if (usuariologado.getSituacao().equals("I")) {
                throw new Exception("Ainda não foi ativado seu cadastro!");
            }
//                carregarAvatar(usuariologado.getFoto());
            setUsuarioSessao(usuariologado);
        }

        return usuariologado;
    }

    private void primeiraCargaDoSistema(Usuario usuario) throws Exception {
        if (usuario.getCpf().equals("111.111.111-11")) {
            System.out.print(Util.criptografar(usuario.getSenha()));
            if (Util.criptografar(usuario.getSenha()).equals("21232F297A57A5A743894A0E4A801FC3")) {
                configuracaoInicial.verificaConfiguracaoInicial();
                throw new Exception("Base de dados atualizada!");
            } else {
                throw new Exception("Senha Administrativa Incorreta!");
            }
        }
    }

    @Override
    public Usuario validaAntesDeSalvar(Usuario usuario) throws Exception {
        if (!Util.isCPF(Util.removerCaracteresEspeciais(usuario.getCpf()))) {
            throw new Exception("Erro na confirmação do CPF. Valor inválido.");
        } else {
            if (usuario.getCpf() != null) {
                if (usuario.getIdUsuario() == null && !usuario.getSenha().equals(usuario.getSenhaConfirmacao())) {
                    throw new Exception("Erro na confirmação da senha. Valor inválido.");
                } else {
                    if (usuario.getIdUsuario() == null && !Util.isEmailValid(usuario.getEmail())) {
                        throw new Exception("E-mail com formatação inválida!");
                    } else {
                        if (usuario.getIdUsuario() == null) {
                            return salvar(usuario);
                        } else {
                            return editar(usuario);
                        }
                    }
                }
            } else {
                throw new Exception("Algum erro ao salvar o usuário!");
            }
        }
    }

    @Override
    public Usuario salvaUsuarioPrimeiroAcesso(Usuario usuario) throws Exception {
        if (usuario != null) {
            usuario.setPrimeiroAcesso("N");
            usuario.setPermissao(permissaoNeg.getById(4));
            return editar(usuario);
        } else {
            throw new Exception("Usuário não encontrado para cpf informado");
        }
    }

    public List<Permissao> findAllPermissoes() throws Exception {
        return permissaoNeg.findAll();
    }

    private Usuario salvar(Usuario usuario) throws Exception {
        Usuario usuarioSalvo = null;
        Usuario usuarioEncontrato = dao.getByCPF(usuario.getCpf());
        String cpf, senha;
        Usuario usuarioEmail = null;
        if (usuarioEncontrato == null) {
            if (usuario.getSituacao() == null) {
                usuario.setSituacao("I");
                if (usuario.getPermissao() == null || usuario.getPermissao().getTipo() == "") {
                    Permissao permissao = permissaoNeg.findUsuarioByTipo("TEMPORARIO");
                    usuario.setPermissao(permissao);
                }
            }
            usuarioEmail = clonaUsuario(usuario);
            cpf = usuario.getCpf();
            senha = usuario.getSenha();
            usuario.setCpf(Util.removerCaracteresEspeciais(usuario.getCpf()));
            usuario.setSenha(Util.criptografar(usuario.getSenha()));
            usuarioSalvo = dao.save(camposObrigatorios(usuario));
            Email enviar = new Email(usuarioEmail.getEmail(), "Bem vindo!", "Login:" + usuarioEmail.getCpf() + "  Senha:" + usuarioEmail.getSenha(), null);
            usuarioEmail.setCpf(cpf);
            usuarioEmail.setSenha(senha);
            enviar.setUsuario(usuarioEmail);
            enviar.setTipoEmail("NovoUsuario");
            email.sendMessage(enviar);
        } else {
            throw new Exception("CPF já cadastrado. Recupere sua senha.");
        }
        return usuarioSalvo;
    }

    private Usuario clonaUsuario(Usuario usuario) throws Exception {
        Usuario usuarioclonado = new Usuario();
        usuarioclonado.setCpf(usuario.getCpf());
        usuarioclonado.setEmail(usuario.getEmail());
        usuarioclonado.setNome(usuario.getNome());
        usuarioclonado.setSenha(usuario.getSenha());
        usuarioclonado.setSituacao(usuario.getSituacao());
        usuarioclonado.setPermissao(usuario.getPermissao());
        return usuarioclonado;
    }

    private Usuario editar(Usuario usuario) throws Exception {
        return dao.update(camposObrigatorios(usuario));
    }

    private Usuario camposObrigatorios(Usuario usuario) throws Exception {
        if (usuario.getPermissao() == null || usuario.getPermissao().getTipo() == "") {
            throw new Exception("Usuário com o campo Permissão nulo ou vazio");
        }
        if (usuario.getCpf() == null || usuario.getCpf() == "") {
            throw new Exception("Usuário com o campo CPF nulo ou vazio");
        }
        if (usuario.getSenha() == null || usuario.getSenha() == "") {
            throw new Exception("Usuário com o campo Senha nulo ou vazio");
        }
        if (usuario.getSituacao() == null || usuario.getSituacao() == "") {
            throw new Exception("Usuário com o campo Situação nulo ou vazio");
        }
        if (usuario.getEmail() == null || usuario.getEmail() == "") {
            throw new Exception("Usuário com o campo Email nulo ou vazio");
        }
        if (usuario.getNome() == null || usuario.getNome() == "") {
            throw new Exception("Usuário com o campo Nome nulo ou vazio");
        }
        return usuario;
    }

    @Override
    public void delete(String id) throws Exception {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public void resetarSenha(String cpf) throws Exception {
        Usuario usuarioEncontrato = dao.getByCPF(cpf);
        if (usuarioEncontrato != null) {
            usuarioEncontrato.setSenha(Util.criptografar("123"));
            dao.update(camposObrigatorios(usuarioEncontrato));
            Email enviar = new Email(usuarioEncontrato.getEmail(), "Bem vindo!", "Login:" + usuarioEncontrato.getCpf() + "  Senha: 123", null);
            Usuario usuarioEmail = new Usuario();
            usuarioEmail.setSenha("123");
            usuarioEmail.setCpf(cpf);
            enviar.setUsuario(usuarioEmail);
            enviar.setTipoEmail("NovaSenha");
            email.sendMessage(enviar);
        } else {
            throw new Exception("Não foi encontrado o CPF cadastro!");
        }
    }

    private void carregarAvatar(byte[] foto) throws Exception {
        FileOutputStream avatar = null;
        try {
            avatar = new FileOutputStream("resources/dist/img/usuario.png");
            avatar.write(foto);
            avatar.close();
        } catch (Exception ex) {
            Logger.getLogger(LoginControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                avatar.close();
            } catch (IOException ex) {
                Logger.getLogger(LoginControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Usuario getById(Integer pk) throws Exception {
        return dao.getById(pk);
    }

    @Override
    public Usuario getByCPF(String cpf) throws Exception {
        return dao.getByCPF(cpf);
    }

    @Override
    public List<Usuario> findAll() throws Exception {
        return (List<Usuario>) dao.findAll();
    }

    @Override
    public List<Usuario> findSQL(String valor, String campo) throws Exception {
        if (valor != null && valor != "" && campo != null && campo != "") {
            return dao.findUsuarioBySQL(valor, CamposPesquisa.retornaEnuCampo(campo));
        } else {
            return null;
        }
    }
}
