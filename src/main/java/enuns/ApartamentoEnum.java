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
public enum ApartamentoEnum {

    A100("100A", BlocoEnum.A), A101("101A", BlocoEnum.A), A102("102A", BlocoEnum.A), A103("103A", BlocoEnum.A), A104("104A", BlocoEnum.A), A105("105A", BlocoEnum.A), A106("106A", BlocoEnum.A), A107("107A", BlocoEnum.A), A108("108A", BlocoEnum.A),
    A200("200A", BlocoEnum.A), A201("201A", BlocoEnum.A), A202("202A", BlocoEnum.A), A203("203A", BlocoEnum.A), A204("204A", BlocoEnum.A), A205("205A", BlocoEnum.A), A206("206A", BlocoEnum.A), A207("207A", BlocoEnum.A), A208("208A", BlocoEnum.A),
    A300("300A", BlocoEnum.A), A301("301A", BlocoEnum.A), A302("302A", BlocoEnum.A), A303("303A", BlocoEnum.A), A304("304A", BlocoEnum.A), A305("305A", BlocoEnum.A), A306("306A", BlocoEnum.A), A307("307A", BlocoEnum.A), A308("308A", BlocoEnum.A),
    A400("400A", BlocoEnum.A), A401("401A", BlocoEnum.A), A402("402A", BlocoEnum.A), A403("403A", BlocoEnum.A), A404("404A", BlocoEnum.A), A405("405A", BlocoEnum.A), A406("406A", BlocoEnum.A), A407("407A", BlocoEnum.A), A408("408A", BlocoEnum.A),
    A500("500A", BlocoEnum.A), A501("501A", BlocoEnum.A), A502("502A", BlocoEnum.A), A503("503A", BlocoEnum.A), A504("504A", BlocoEnum.A), A505("505A", BlocoEnum.A), A506("506A", BlocoEnum.A), A507("507A", BlocoEnum.A), A508("508A", BlocoEnum.A),
    A600("600A", BlocoEnum.A), A601("601A", BlocoEnum.A), A602("602A", BlocoEnum.A), A603("603A", BlocoEnum.A), A604("604A", BlocoEnum.A), A605("605A", BlocoEnum.A), A606("606A", BlocoEnum.A), A607("607A", BlocoEnum.A), A608("608A", BlocoEnum.A),
    A700("700A", BlocoEnum.A), A701("701A", BlocoEnum.A), A702("702A", BlocoEnum.A), A703("703A", BlocoEnum.A), A704("704A", BlocoEnum.A), A705("705A", BlocoEnum.A), A706("706A", BlocoEnum.A), A707("707A", BlocoEnum.A), A708("708A", BlocoEnum.A),
    A800("800A", BlocoEnum.A), A801("801A", BlocoEnum.A), A802("802A", BlocoEnum.A), A803("803A", BlocoEnum.A), A804("804A", BlocoEnum.A), A805("805A", BlocoEnum.A), A806("806A", BlocoEnum.A), A807("807A", BlocoEnum.A), A808("808A", BlocoEnum.A),
    B100("100B", BlocoEnum.B), B101("101B", BlocoEnum.B), B102("102B", BlocoEnum.B), B103("103B", BlocoEnum.B), B104("104B", BlocoEnum.B), B105("105B", BlocoEnum.B), B106("106B", BlocoEnum.B), B107("107B", BlocoEnum.B), B108("108B", BlocoEnum.B),
    B200("200B", BlocoEnum.B), B201("201B", BlocoEnum.B), B202("202B", BlocoEnum.B), B203("203B", BlocoEnum.B), B204("204B", BlocoEnum.B), B205("205B", BlocoEnum.B), B206("206B", BlocoEnum.B), B207("207B", BlocoEnum.B), B208("208B", BlocoEnum.B),
    B300("300B", BlocoEnum.B), B301("301B", BlocoEnum.B), B302("302B", BlocoEnum.B), B303("303B", BlocoEnum.B), B304("304B", BlocoEnum.B), B305("305B", BlocoEnum.B), B306("306B", BlocoEnum.B), B307("307B", BlocoEnum.B), B308("308B", BlocoEnum.B),
    B400("400B", BlocoEnum.B), B401("401B", BlocoEnum.B), B402("402B", BlocoEnum.B), B403("403B", BlocoEnum.B), B404("404B", BlocoEnum.B), B405("405B", BlocoEnum.B), B406("406B", BlocoEnum.B), B407("407B", BlocoEnum.B), B408("408B", BlocoEnum.B),
    B500("500B", BlocoEnum.B), B501("501B", BlocoEnum.B), B502("502B", BlocoEnum.B), B503("503B", BlocoEnum.B), B504("504B", BlocoEnum.B), B505("505B", BlocoEnum.B), B506("506B", BlocoEnum.B), B507("507B", BlocoEnum.B), B508("508B", BlocoEnum.B),
    B600("600B", BlocoEnum.B), B601("601B", BlocoEnum.B), B602("602B", BlocoEnum.B), B603("603B", BlocoEnum.B), B604("604B", BlocoEnum.B), B605("605B", BlocoEnum.B), B606("606B", BlocoEnum.B), B607("607B", BlocoEnum.B), B608("608B", BlocoEnum.B),
    B700("700B", BlocoEnum.B), B701("701B", BlocoEnum.B), B702("702B", BlocoEnum.B), B703("703B", BlocoEnum.B), B704("704B", BlocoEnum.B), B705("705B", BlocoEnum.B), B706("706B", BlocoEnum.B), B707("707B", BlocoEnum.B), B708("708B", BlocoEnum.B),
    B800("800B", BlocoEnum.B), B801("801B", BlocoEnum.B), B802("802B", BlocoEnum.B), B803("803B", BlocoEnum.B), B804("804B", BlocoEnum.B), B805("805B", BlocoEnum.B), B806("806B", BlocoEnum.B), B807("807B", BlocoEnum.B), B808("808B", BlocoEnum.B),
    C100("100C", BlocoEnum.C), C101("101C", BlocoEnum.C), C102("102C", BlocoEnum.C), C103("103C", BlocoEnum.C), C104("104C", BlocoEnum.C), C105("105C", BlocoEnum.C), C106("106C", BlocoEnum.C), C107("107C", BlocoEnum.C), C108("108C", BlocoEnum.C),
    C200("200C", BlocoEnum.C), C201("201C", BlocoEnum.C), C202("202C", BlocoEnum.C), C203("203C", BlocoEnum.C), C204("204C", BlocoEnum.C), C205("205C", BlocoEnum.C), C206("206C", BlocoEnum.C), C207("207C", BlocoEnum.C), C208("208C", BlocoEnum.C),
    C300("300C", BlocoEnum.C), C301("301C", BlocoEnum.C), C302("302C", BlocoEnum.C), C303("303C", BlocoEnum.C), C304("304C", BlocoEnum.C), C305("305C", BlocoEnum.C), C306("306C", BlocoEnum.C), C307("307C", BlocoEnum.C), C308("308C", BlocoEnum.C),
    C400("400C", BlocoEnum.C), C401("401C", BlocoEnum.C), C402("402C", BlocoEnum.C), C403("403C", BlocoEnum.C), C404("404C", BlocoEnum.C), C405("405C", BlocoEnum.C), C406("406C", BlocoEnum.C), C407("407C", BlocoEnum.C), C408("408C", BlocoEnum.C),
    C500("500C", BlocoEnum.C), C501("501C", BlocoEnum.C), C502("502C", BlocoEnum.C), C503("503C", BlocoEnum.C), C504("504C", BlocoEnum.C), C505("505C", BlocoEnum.C), C506("506C", BlocoEnum.C), C507("507C", BlocoEnum.C), C508("508C", BlocoEnum.C),
    C600("600C", BlocoEnum.C), C601("601C", BlocoEnum.C), C602("602C", BlocoEnum.C), C603("603C", BlocoEnum.C), C604("604C", BlocoEnum.C), C605("605C", BlocoEnum.C), C606("606C", BlocoEnum.C), C607("607C", BlocoEnum.C), C608("608C", BlocoEnum.C),
    C700("700C", BlocoEnum.C), C701("701C", BlocoEnum.C), C702("702C", BlocoEnum.C), C703("703C", BlocoEnum.C), C704("704C", BlocoEnum.C), C705("705C", BlocoEnum.C), C706("706C", BlocoEnum.C), C707("707C", BlocoEnum.C), C708("708C", BlocoEnum.C),
    C800("800C", BlocoEnum.C), C801("801C", BlocoEnum.C), C802("802C", BlocoEnum.C), C803("803C", BlocoEnum.C), C804("804C", BlocoEnum.C), C805("805C", BlocoEnum.C), C806("806C", BlocoEnum.C), C807("807C", BlocoEnum.C), C808("808C", BlocoEnum.C),
    D100("100D", BlocoEnum.D), D101("101D", BlocoEnum.D), D102("102D", BlocoEnum.D), D103("103D", BlocoEnum.D), D104("104D", BlocoEnum.D), D105("105D", BlocoEnum.D), D106("106D", BlocoEnum.D), D107("107D", BlocoEnum.D), D108("108D", BlocoEnum.D),
    D200("200D", BlocoEnum.D), D201("201D", BlocoEnum.D), D202("202D", BlocoEnum.D), D203("203D", BlocoEnum.D), D204("204D", BlocoEnum.D), D205("205D", BlocoEnum.D), D206("206D", BlocoEnum.D), D207("207D", BlocoEnum.D), D208("208D", BlocoEnum.D),
    D300("300D", BlocoEnum.D), D301("301D", BlocoEnum.D), D302("302D", BlocoEnum.D), D303("303D", BlocoEnum.D), D304("304D", BlocoEnum.D), D305("305D", BlocoEnum.D), D306("306D", BlocoEnum.D), D307("307D", BlocoEnum.D), D308("308D", BlocoEnum.D),
    D400("400D", BlocoEnum.D), D401("401D", BlocoEnum.D), D402("402D", BlocoEnum.D), D403("403D", BlocoEnum.D), D404("404D", BlocoEnum.D), D405("405D", BlocoEnum.D), D406("406D", BlocoEnum.D), D407("407D", BlocoEnum.D), D408("408D", BlocoEnum.D),
    D500("500D", BlocoEnum.D), D501("501D", BlocoEnum.D), D502("502D", BlocoEnum.D), D503("503D", BlocoEnum.D), D504("504D", BlocoEnum.D), D505("505D", BlocoEnum.D), D506("506D", BlocoEnum.D), D507("507D", BlocoEnum.D), D508("508D", BlocoEnum.D),
    D600("600D", BlocoEnum.D), D601("601D", BlocoEnum.D), D602("602D", BlocoEnum.D), D603("603D", BlocoEnum.D), D604("604D", BlocoEnum.D), D605("605D", BlocoEnum.D), D606("606D", BlocoEnum.D), D607("607D", BlocoEnum.D), D608("608D", BlocoEnum.D),
    D700("700D", BlocoEnum.D), D701("701D", BlocoEnum.D), D702("702D", BlocoEnum.D), D703("703D", BlocoEnum.D), D704("704D", BlocoEnum.D), D705("705D", BlocoEnum.D), D706("706D", BlocoEnum.D), D707("707D", BlocoEnum.D), D708("708D", BlocoEnum.D),
    D800("800D", BlocoEnum.D), D801("801D", BlocoEnum.D), D802("802D", BlocoEnum.D), D803("803D", BlocoEnum.D), D804("804D", BlocoEnum.D), D805("805D", BlocoEnum.D), D806("806D", BlocoEnum.D), D807("807D", BlocoEnum.D), D808("808D", BlocoEnum.D);

    public String numero;
    public BlocoEnum bloco;

    ApartamentoEnum(String valor, BlocoEnum blocoEnu) {
        numero = valor;
        bloco = blocoEnu;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BlocoEnum getBloco() {
        return bloco;
    }

    public void setBloco(BlocoEnum bloco) {
        this.bloco = bloco;
    }
    
    public static List<String> getLista() {
        List<String> lista = new ArrayList<String>();
        for (ApartamentoEnum item : ApartamentoEnum.values()) {
            lista.add(item.numero);
        }
        return lista;
    }
    
    public ApartamentoEnum retornaPeloNumero(String numero){
        return ApartamentoEnum.valueOf(numero);
    }
}
