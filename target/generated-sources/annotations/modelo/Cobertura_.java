package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Garagem;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Cobertura.class)
public class Cobertura_ { 

    public static volatile SingularAttribute<Cobertura, String> tipo;
    public static volatile ListAttribute<Cobertura, Garagem> garagemList;
    public static volatile SingularAttribute<Cobertura, Integer> idCobertura;

}