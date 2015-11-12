package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Porteiro;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Movimentacao.class)
public class Movimentacao_ { 

    public static volatile SingularAttribute<Movimentacao, String> tipo;
    public static volatile SingularAttribute<Movimentacao, Porteiro> porteiro;
    public static volatile SingularAttribute<Movimentacao, Date> dataHorario;
    public static volatile SingularAttribute<Movimentacao, Integer> idUsuario;
    public static volatile SingularAttribute<Movimentacao, Usuario> usuario;

}