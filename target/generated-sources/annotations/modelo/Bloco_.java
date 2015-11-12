package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Apartamento;
import modelo.Condominio;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Bloco.class)
public class Bloco_ { 

    public static volatile SingularAttribute<Bloco, Integer> idBloco;
    public static volatile SingularAttribute<Bloco, String> sigla;
    public static volatile SingularAttribute<Bloco, Condominio> condominio;
    public static volatile ListAttribute<Bloco, Apartamento> apartamentoList;

}