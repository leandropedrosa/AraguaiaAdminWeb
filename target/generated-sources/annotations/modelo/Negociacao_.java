package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Apartamento;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Negociacao.class)
public class Negociacao_ { 

    public static volatile SingularAttribute<Negociacao, String> publicar;
    public static volatile SingularAttribute<Negociacao, Apartamento> apartamento;
    public static volatile SingularAttribute<Negociacao, String> tipo;
    public static volatile SingularAttribute<Negociacao, Integer> idNegociacao;
    public static volatile SingularAttribute<Negociacao, Float> valor;

}