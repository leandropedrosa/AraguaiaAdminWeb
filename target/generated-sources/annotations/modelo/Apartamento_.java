package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Bloco;
import modelo.Diarista;
import modelo.Imobiliaria;
import modelo.Negociacao;
import modelo.Titular;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Apartamento.class)
public class Apartamento_ { 

    public static volatile SingularAttribute<Apartamento, String> situacao;
    public static volatile SingularAttribute<Apartamento, String> numero;
    public static volatile SingularAttribute<Apartamento, Bloco> bloco;
    public static volatile ListAttribute<Apartamento, Negociacao> negociacaoList;
    public static volatile SingularAttribute<Apartamento, String> possuiInternet;
    public static volatile SingularAttribute<Apartamento, String> possuiTvCabo;
    public static volatile SingularAttribute<Apartamento, Diarista> diarista;
    public static volatile SingularAttribute<Apartamento, String> possuiArCondicionado;
    public static volatile SingularAttribute<Apartamento, Integer> quartos;
    public static volatile SingularAttribute<Apartamento, Integer> idApartamento;
    public static volatile SingularAttribute<Apartamento, Imobiliaria> imobiliaria;
    public static volatile SingularAttribute<Apartamento, String> possuiBicicleta;
    public static volatile SingularAttribute<Apartamento, String> ramal;
    public static volatile SingularAttribute<Apartamento, String> possuiAnimais;
    public static volatile SingularAttribute<Apartamento, Titular> titular;

}