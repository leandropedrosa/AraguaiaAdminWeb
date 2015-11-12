package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Bloco;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Condominio.class)
public class Condominio_ { 

    public static volatile SingularAttribute<Condominio, Integer> idCondominio;
    public static volatile SingularAttribute<Condominio, String> nome;
    public static volatile ListAttribute<Condominio, Bloco> blocoList;
    public static volatile SingularAttribute<Condominio, String> sindico;

}