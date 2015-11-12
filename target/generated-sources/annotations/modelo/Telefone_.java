package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Titular;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Telefone.class)
public class Telefone_ { 

    public static volatile SingularAttribute<Telefone, String> tipo;
    public static volatile SingularAttribute<Telefone, String> numero;
    public static volatile SingularAttribute<Telefone, Integer> idTelefone;
    public static volatile SingularAttribute<Telefone, Titular> titular;

}