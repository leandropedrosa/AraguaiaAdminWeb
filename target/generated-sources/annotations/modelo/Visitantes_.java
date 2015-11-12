package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Titular;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Visitantes.class)
public class Visitantes_ { 

    public static volatile SingularAttribute<Visitantes, String> rg;
    public static volatile SingularAttribute<Visitantes, String> vinculoTitular;
    public static volatile SingularAttribute<Visitantes, Integer> idVisitantes;
    public static volatile SingularAttribute<Visitantes, String> livreAcesso;
    public static volatile SingularAttribute<Visitantes, String> nome;
    public static volatile SingularAttribute<Visitantes, Titular> titular;

}