/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import enuns.CamposPesquisa;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Telefone;
import modelo.Titular;
import persistencia.TitularDao;

/**
 *
 * @author Leandro
 */
@Stateless
public class TitularNeg extends AbstractNegocio implements TitularNegFacade {

    @EJB
    private TitularDao dao;

    @EJB
    private TelefoneNegFacade telefoneNeg;

    private Titular titularSalvo;

    @Override
    public Titular validaAntesDeSalvar(Titular titular) throws Exception {
        if (titular.getIdTitular() == null) {
            return salvar(titular);
        } else {
            return editar(titular);
        }
    }

    @Override
    public Titular validaAntesDeSalvarRetorno(Titular titular) throws Exception {
        return salvar(titular);
    }

    private Titular salvar(Titular titular) throws Exception {
        Titular encontrado = dao.getByRG(titular.getRg());
        if (encontrado != null) {
            throw new Exception("Titular já cadastrado na base de dados!");
        }
        titular.setIdTitular(null);
        List<Telefone> telefones = titular.getTelefoneList();
        titular.setTelefoneList(null);
        titular.setSituacao("A");
        if (telefones == null || telefones.isEmpty()) {
            throw new Exception("Titular com o campo Telefone nulo ou vazio");
        } else {
            setTitularSalvo(dao.save(camposObrigatorios(titular)));
            getTitularSalvo().setTelefoneList(telefones);
            telefoneNeg.validaAntesDeSalvar(titularSalvo);
        }

        return getTitularSalvo();
    }

    private Titular editar(Titular titular) throws Exception {
        return dao.update(camposObrigatorios(titular));
    }

    private Titular camposObrigatorios(Titular titular) throws Exception {
        if (titular.getUsuario() == null || titular.getUsuario().getCpf() == "") {
            throw new Exception("Titular com o campo Usuário nulo ou vazio");
        }
        if (titular.getTipo() == null || titular.getTipo() == "") {
            throw new Exception("Titular com o campo Tipo nulo ou vazio");
        }
        if (titular.getNome() == null || titular.getNome() == "") {
            throw new Exception("Titular com o campo Nome nulo ou vazio");
        }
        if (titular.getEmail() == null || titular.getEmail() == "") {
            throw new Exception("Titular com o campo Email nulo ou vazio");
        }
        if (titular.getDtNascimento() == null) {
            throw new Exception("Titular com o campo DtNascimento nulo ou vazio");
        }
        if (titular.getRg() == null || titular.getRg() == "") {
            throw new Exception("Titular com o campo Rg nulo ou vazio");
        }

        return titular;
    }

    public Titular getTitularSalvo() throws Exception {
        return titularSalvo;
    }

    public void setTitularSalvo(Titular titularSalvo) throws Exception {
        this.titularSalvo = titularSalvo;
    }

    @Override
    public Titular getById(Integer pk) throws Exception {
        return dao.getById(pk);
    }

    @Override
    public void update(Titular entity) throws Exception {
        dao.update(entity);
    }

    @Override
    public void inativar(String id) throws Exception {
        Titular titularSalvo = dao.find(Integer.parseInt(id));
        titularSalvo.setSituacao("I");
        dao.save(titularSalvo);
    }

    @Override
    public Titular getByCPF(String cpf) throws Exception {
        return dao.getByCPF(cpf);
    }

    @Override
    public List<Titular> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List<Telefone> getTelefones(Integer idTitular) throws Exception {
        return telefoneNeg.findByTitular(idTitular);
    }

    @Override
    public List<Titular> findSQL(String valor, String campo) throws Exception {
        if (valor != null && valor != "" && campo != null && campo != "") {
            return dao.findTitularBySQL(valor, CamposPesquisa.retornaEnuCampo(campo));
        } else {
            return null;
        }
    }
}
