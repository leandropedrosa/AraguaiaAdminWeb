/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import enuns.LinksEnum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leandro
 */
public class ModuloLinks {

    private String nome;
    private Integer permissao;
    private List<LinksEnum> listaLinks;

    public ModuloLinks(String nome, int permissao) {
        this.nome = nome;
        this.permissao = permissao;
    }

    public List<Integer> doRetornaPermissoes() {
        List<Integer> lista = new ArrayList<Integer>();
        if (this.nome.equals("Cadastros")) {
            lista.add(1);
            lista.add(6);
            lista.add(3);
            lista.add(4);
            return lista;
        }
        if (this.nome.equals("Home")) {
            lista.add(1);
            lista.add(6);
            lista.add(3);
            lista.add(4);
            return lista;
        }
        if (this.nome.equals("Reservar")) {
            lista.add(1);
            lista.add(6);
            lista.add(3);
            lista.add(4);
            return lista;
        }
        if (this.nome.equals("Financeiro")) {
            lista.add(1);
            lista.add(6);
            return lista;
        }
        return null;
    }

    public int retornaQuantidade() {
        return retornaMenuPermissao().size();
    }

    public List<LinksEnum> retornaMenuPermissao() {
        listaLinks = new ArrayList<LinksEnum>();
        List<Integer> permissoes = doRetornaPermissoes();
        for (LinksEnum item : LinksEnum.values()) {
            if (permissoes.contains(this.permissao) && item.getModulo().equals(this.nome)) {
                listaLinks.add(item);
            }
        }
        return listaLinks;
    }
}
