package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Solicitacao;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Zelador.class)
public class Zelador_ { 

    public static volatile ListAttribute<Zelador, Solicitacao> solicitacaoList;
    public static volatile SingularAttribute<Zelador, String> situacao;
    public static volatile SingularAttribute<Zelador, String> nome;
    public static volatile SingularAttribute<Zelador, Usuario> usuario;
    public static volatile SingularAttribute<Zelador, Integer> idZelador;

}