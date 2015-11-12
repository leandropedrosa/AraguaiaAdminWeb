package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Apartamento;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Diarista.class)
public class Diarista_ { 

    public static volatile SingularAttribute<Diarista, String> nomeDiarista;
    public static volatile ListAttribute<Diarista, Apartamento> apartamentoList;
    public static volatile SingularAttribute<Diarista, Integer> idDiarista;
    public static volatile SingularAttribute<Diarista, String> telefoneDiarista;

}