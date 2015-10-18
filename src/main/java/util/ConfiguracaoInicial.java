/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Bloco;
import modelo.Condominio;
import modelo.Permissao;
import modelo.Usuario;
import persistencia.BlocoDao;
import persistencia.CondominioDao;
import persistencia.PermissaoDao;
import persistencia.UsuarioDao;

/**
 *
 * @author Leandro
 */
@Stateless
public class ConfiguracaoInicial implements ConfiguracaoInicialFacade {

    @EJB
    UsuarioDao usuarioDao;

    @EJB
    CondominioDao condominioDao;

    @EJB
    BlocoDao blocodao;

    @EJB
    PermissaoDao permissaoDao;

    @Override
    public void verificaConfiguracaoInicial() {
        try {
            Usuario usuario = usuarioDao.findUsuarioByLogin("05853163680", "123");
            if (usuario == null) {
                salvaPermissao();
                salvaCondominio();
                salvaBlocos();
                salvaUsuarioADM();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void salvaPermissao() throws Exception {
        Permissao permissaoAdmin = new Permissao();
        Permissao permissaoPorteiro = new Permissao();
        Permissao permissaoZelador = new Permissao();
        Permissao permissaoTitular = new Permissao();
        Permissao permissaoTemporario = new Permissao();

        permissaoAdmin.setSituacao("A");
        permissaoAdmin.setTipo("ADMIN");
        permissaoDao.save(permissaoAdmin);

        permissaoZelador.setSituacao("A");
        permissaoZelador.setTipo("ZELADOR");
        permissaoDao.save(permissaoZelador);

        permissaoPorteiro.setSituacao("A");
        permissaoPorteiro.setTipo("PORTEIRO");
        permissaoDao.save(permissaoPorteiro);

        permissaoTitular.setSituacao("A");
        permissaoTitular.setTipo("TITULAR");
        permissaoDao.save(permissaoTitular);

        permissaoTemporario.setSituacao("A");
        permissaoTemporario.setTipo("TEMPORARIO");
        permissaoDao.save(permissaoTemporario);
    }

    private void salvaCondominio() throws Exception {
        Condominio condominio = new Condominio();
        condominio.setNome("Eco Ville Araguaia");
        condominio.setSindico("Desiré");
        condominioDao.save(condominio);
    }

    private void salvaBlocos() throws Exception {
        Bloco blocoA = new Bloco();
        Bloco blocoB = new Bloco();
        Bloco blocoC = new Bloco();
        Bloco blocoD = new Bloco();

        blocoA.setCondominio(condominioDao.getById(1));
        blocoA.setSigla("A");
        blocodao.save(blocoA);

        blocoB.setCondominio(condominioDao.getById(1));
        blocoB.setSigla("B");
        blocodao.save(blocoB);

        blocoC.setCondominio(condominioDao.getById(1));
        blocoC.setSigla("C");
        blocodao.save(blocoC);

        blocoD.setCondominio(condominioDao.getById(1));
        blocoD.setSigla("D");
        blocodao.save(blocoD);

    }

    private void salvaUsuarioADM() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setEmail("leandropedrosalp@gmail.com");
        usuario.setCpf("05853163680");
        usuario.setSenha(Util.criptografar("123"));
        usuario.setSituacao("A");
        usuario.setNome("Leandro Pedrosa");
        usuario.setPermissao(permissaoDao.findUsuarioByTipo("ADMIN"));
        usuarioDao.save(usuario);
    }

    private void setUsuarioSessao(Usuario usuario) throws Exception {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("usuario", usuario);
    }
}
