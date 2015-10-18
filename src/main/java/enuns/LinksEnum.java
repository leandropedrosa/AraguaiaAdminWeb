/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enuns;

/**
 *
 * @author Leandro
 */
public enum LinksEnum {

    HOME("Home", "home/estatisticas", "Home"),
    URUARIOS("Usuários", "cadastros/usuarios", "Cadastros"),
    TITULARES("Titulares", "cadastros/titulares", "Cadastros"),
    APARTAMENTOS("Apartamentos", "cadastros/apartamentos", "Cadastros"),
    DEPENDENTES("Dependentes", "cadastros/dependentes", "Cadastros"),
    GARAGENS("Garagens", "cadastros/garagens", "Cadastros"),
    VEICULOS("Veículos", "cadastros/veiculos", "Cadastros"),
    PRIMEIROACESSO("Primeiro Acesso", "home/primeiroAcesso", "PrimeiroAcesso"),
    RESERVAR("Resevar", "reservar/reservar", "Reservar"),
    FINANCEIRO("Usuários", "financeiro/financeiro", "Financeiro");

    public String nome;
    public String link;
    public String modulo;

    LinksEnum(String nome, String link, String modulo) {
        this.nome = nome;
        this.link = link;
        this.modulo = modulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public static LinksEnum retornaLink(String link) {
        for (LinksEnum item : LinksEnum.values()) {
            if (item.getLink().equals(link)) {
                return item;
            }
        }
        return null;
    }
}
