package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Porteiro;
import modelo.Titular;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Encomenda.class)
public class Encomenda_ { 

    public static volatile SingularAttribute<Encomenda, Integer> idEncomenda;
    public static volatile SingularAttribute<Encomenda, String> situacao;
    public static volatile SingularAttribute<Encomenda, Porteiro> porteiro;
    public static volatile SingularAttribute<Encomenda, Date> dataChegada;
    public static volatile SingularAttribute<Encomenda, Date> dataEntregue;
    public static volatile SingularAttribute<Encomenda, Titular> titular;
    public static volatile SingularAttribute<Encomenda, String> descricao;

}