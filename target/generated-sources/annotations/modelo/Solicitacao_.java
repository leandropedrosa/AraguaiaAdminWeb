package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Titular;
import modelo.Zelador;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Solicitacao.class)
public class Solicitacao_ { 

    public static volatile SingularAttribute<Solicitacao, String> situacao;
    public static volatile SingularAttribute<Solicitacao, Zelador> zelador;
    public static volatile SingularAttribute<Solicitacao, Date> dataTermino;
    public static volatile SingularAttribute<Solicitacao, Integer> idSolicitacao;
    public static volatile SingularAttribute<Solicitacao, Date> dataCriacao;
    public static volatile SingularAttribute<Solicitacao, Titular> titular;
    public static volatile SingularAttribute<Solicitacao, String> descricao;

}