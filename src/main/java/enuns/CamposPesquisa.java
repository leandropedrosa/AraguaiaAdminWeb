/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enuns;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leandro
 */
public enum CamposPesquisa {

    //USUARIO
    CPF_USUARIO("cpf", "Usuario", "u", TipoCampoPesquisa.MASCARA, null, null), SITUACAO("situacao", "Usuario", "u", TipoCampoPesquisa.STRING, null, null), NOME_USUARIO("nome", "Usuario", "u", TipoCampoPesquisa.STRING, null, null), PERMISSAO("p.tipo", "Usuario", "u", TipoCampoPesquisa.MASCARA, "permissao", "p"),
    //VEICULO
    TITULAR_VEICULO("t.nome", "Veiculo", "v", TipoCampoPesquisa.STRING, "titular", "t"), PLACA("placa", "Veiculo", "v", TipoCampoPesquisa.MASCARA, null, null),
    //TITULAR
    NOME_TITULAR("nome", "Titular", "t", TipoCampoPesquisa.STRING, null, null), SITUACAO_TITULAR("situacao", "Titular", "t", TipoCampoPesquisa.STRING, null, null), DTNASCIMENTO_TITULAR("dtNascimento", "Titular", "t", TipoCampoPesquisa.DATA, null, null), TIPO_TITULAR("tipo", "Titular", "t", TipoCampoPesquisa.STRING, null, null), RG("rg", "Titular", "t", TipoCampoPesquisa.STRING, null, null),
    //TELEFONE
    TITULAR_TELEFONE("t.nome", "Telefone", "te", TipoCampoPesquisa.STRING, "titular", "t"), TIPO_TELEFONE("tipo", "Telefone", "te", TipoCampoPesquisa.STRING, null, null),
    //IMOBILIARIA
    NOME_IMOBILIARIA("nomeImobiliaria", "Imobiliaria", "i", TipoCampoPesquisa.STRING, null, null),
    //PORTEIRO
    NOME_PORTEIRO("nome", "Porteiro", "p", TipoCampoPesquisa.STRING, null, null),
    //GARAGEM
    TITULAR_GARAGEM("t.nome", "Garagem", "g", TipoCampoPesquisa.STRING, "Titular", "t"), COBERTURA("c.tipo", "Garagem", "g", TipoCampoPesquisa.STRING, "cobertura", "c"), NUMERO_GARAGEM("numero", "Garagem", "g", TipoCampoPesquisa.STRING, null, null),
    //DIARISTA
    NOME_DIARISTA("nomeDiarista", "Diarista", "d", TipoCampoPesquisa.STRING, null, null),
    //NEGOCIACAO
    TIPO_NEGOCIACAO("tipo", "Negociacao", "N", TipoCampoPesquisa.STRING, null, null), VALOR_NEGOCIACAO("valor", "Negociacao", "N", TipoCampoPesquisa.STRING, null, null), AP_NEGOCIACAO("a.apartamento", "Negociacao", "N", TipoCampoPesquisa.STRING, "apartamento", "a"),
    //DEPENDENTE
    NOME_DEPENDENTE("nome", "Dependente", "d", TipoCampoPesquisa.STRING, null, null), TITULAR_DEPENDENTE("titular.nome", "Dependente", "d", TipoCampoPesquisa.STRING, "titular", "t"), PARENTESCO("parentesco", "Dependente", "d", TipoCampoPesquisa.STRING, null, null), DTNASCIMENTO_DEPENDENTE("dtNascimento", "Dependente", "d", TipoCampoPesquisa.DATA, null, null), RG_DEPENDENTE("rg", "Dependente", "d", TipoCampoPesquisa.STRING, null, null),
    //COBERTURA
    TIPO_COBERTURA("tipo", "Cobertura", "c", TipoCampoPesquisa.STRING, null, null),
    //VISITANTE
    NOME_VISITANTE("nome", "Visitantes", "v", TipoCampoPesquisa.STRING, null, null), RG_VISITANTE("rg", "Visitantes", "v", TipoCampoPesquisa.STRING, null, null), VINCULO_VISITANTE("vinculoTitular", "Visitantes", "v", TipoCampoPesquisa.STRING, null, null), LIVRE_ACESSO("livreAcesso", "Visitantes", "v", TipoCampoPesquisa.STRING, null, null), TITULAR_VISITANTE("t.nome", "Visitantes", "v", TipoCampoPesquisa.STRING, "titular", "t"),
    //APARTAMENTO
    DIARISTA("d.nomeDiarista", "Apartamento", "a", TipoCampoPesquisa.STRING, "diarista", "d"), IMOBILIARIA("i.nomeImobiliaria", "Apartamento", "a", TipoCampoPesquisa.STRING, "imobiliaria", "i"), TITULAR_APARTAMENTO("t.nome", "Apartamento", "a", TipoCampoPesquisa.STRING, "titular", "t"), BLOCO("b.sigla", "Apartamento", "a", TipoCampoPesquisa.STRING, "bloco", "b"), QUARTOS("quartos", "Apartamento", "a", TipoCampoPesquisa.INT, null, null), NUMERO("numero", "Apartamento", "a", TipoCampoPesquisa.STRING, null, null), POSSUI_AR("possuiArCondicionado", "Apartamento", "a", TipoCampoPesquisa.STRING, null, null), POSSUI_INTERNET("possuiInternet", "Apartamento", "a", TipoCampoPesquisa.STRING, null, null), POSSUI_TVCABO("possuiTvCabo", "Apartamento", "c", TipoCampoPesquisa.STRING, null, null), POSSUI_ANIMAIS("possuiAnimais", "Apartamento", "a", TipoCampoPesquisa.STRING, null, null);

    public String objeto;
    public String alias;
    public String campo;
    public String objetoFilho;
    public TipoCampoPesquisa tipo;
    public String aliasFilho;

    CamposPesquisa(String campo, String objeto, String alias, TipoCampoPesquisa tipo, String objetoFilho, String aliasFilho) {
        this.campo = campo;
        this.objeto = objeto;
        this.tipo = tipo;
        this.alias = alias;
        this.objetoFilho = objetoFilho;
        this.aliasFilho = aliasFilho;
    }

    public String getAliasFilho() {
        return aliasFilho;
    }

    public void setAliasFilho(String aliasFilho) {
        this.aliasFilho = aliasFilho;
    }

    public String getObjetoFilho() {
        return objetoFilho;
    }

    public void setObjetoFilho(String objetoFilho) {
        this.objetoFilho = objetoFilho;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public TipoCampoPesquisa getTipo() {
        return tipo;
    }

    public void setTipo(TipoCampoPesquisa tipo) {
        this.tipo = tipo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public static String montaSQL(CamposPesquisa pesquisa, String valor1, String valor2) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select ");
        sql.append(pesquisa.getAlias() + " ");
        sql.append(" from ");
        sql.append(pesquisa.getObjeto() + " " + pesquisa.getAlias());
        if (pesquisa.getObjetoFilho() != null) {
            sql.append(" " + pesquisa.getAlias() + "." + pesquisa.getObjetoFilho() + " " + pesquisa.getAliasFilho());
        }
        sql.append(" where ");
        sql.append(pesquisa.getAlias() + "." + pesquisa.getCampo() + " ");
        sql.append(TipoCampoPesquisa.buscaCompleta(valor1, valor2, pesquisa.getTipo()));
        return sql.toString();
    }

    public static CamposPesquisa retornaEnuCampo(String campo) {
        for (CamposPesquisa item : CamposPesquisa.values()) {
            if (campo.equals(item.getCampo())) {
                return item;
            }
        }
        return null;
    }

    public static List<String> camposLista(String objeto) {
        List<String> lista = new ArrayList<String>();
        for (CamposPesquisa item : CamposPesquisa.values()) {
            if (item.getObjeto().equals(objeto)) {
                lista.add(item.getCampo());
            }
        }
        return lista.isEmpty() ? null : lista;
    }
}
