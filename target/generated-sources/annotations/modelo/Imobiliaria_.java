package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Apartamento;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Imobiliaria.class)
public class Imobiliaria_ { 

    public static volatile SingularAttribute<Imobiliaria, Integer> idImobiliaria;
    public static volatile SingularAttribute<Imobiliaria, String> nomeImobiliaria;
    public static volatile SingularAttribute<Imobiliaria, String> telefoneImobiliaria;
    public static volatile ListAttribute<Imobiliaria, Apartamento> apartamentoList;

}