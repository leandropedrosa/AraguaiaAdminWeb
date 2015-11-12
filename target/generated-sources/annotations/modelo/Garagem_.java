package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cobertura;
import modelo.Titular;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Garagem.class)
public class Garagem_ { 

    public static volatile SingularAttribute<Garagem, Integer> idGaragem;
    public static volatile SingularAttribute<Garagem, Cobertura> cobertura;
    public static volatile SingularAttribute<Garagem, String> numero;
    public static volatile SingularAttribute<Garagem, Titular> titular;

}