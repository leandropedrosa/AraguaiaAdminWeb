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
public enum BlocoEnum {

    A("A"), B("B"), C("C"), D("D");

    public String letra;

    BlocoEnum(String valor) {
        letra = valor;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public static List<String> getLista() {
        List<String> lista = new ArrayList<String>();
        for (BlocoEnum item : BlocoEnum.values()) {
            lista.add(item.letra);
        }
        return lista;
    }

    public BlocoEnum retornaPelaLetra(String numero) {
        return BlocoEnum.valueOf(numero);
    }
}
