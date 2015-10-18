/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enuns;

import util.Util;

/**
 *
 * @author Leandro
 */
public enum TipoCampoPesquisa {

    STRING(" LIKE "), DATAS(" between "), DATA(" = "), INT(" = "), MASCARA(" LIKE ");

    private String selecionador;

    TipoCampoPesquisa(String selecionador) {
        this.selecionador = selecionador;
    }

    private String getSelecionador() {
        return selecionador;
    }

    private void setSelecionador(String selecionador) {
        this.selecionador = selecionador;
    }

    public static String buscaCompleta(String valor1, String valor2, TipoCampoPesquisa tipo) {
        if (tipo == TipoCampoPesquisa.STRING) {
            return tipo.getSelecionador() + "'" + valor1 + "%'";
        }
        if (tipo == TipoCampoPesquisa.DATAS) {
            return tipo.getSelecionador() + "'" + valor1 + "' AND '" + valor2 + "'";
        }
        if (tipo == TipoCampoPesquisa.DATA) {
            return tipo.getSelecionador() + "'" + valor1+ "'";
        }
        if (tipo == TipoCampoPesquisa.INT) {
            return tipo.getSelecionador() + valor1;
        }
        if (tipo == TipoCampoPesquisa.MASCARA) {
            return tipo.getSelecionador() + "'" + Util.removerCaracteresEspeciais(valor1)+ "%'";
        }
        return null;
    }
}
