package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Movimentacao;
import modelo.Permissao;
import modelo.Porteiro;
import modelo.Titular;
import modelo.Zelador;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> situacao;
    public static volatile SingularAttribute<Usuario, String> primeiroAcesso;
    public static volatile ListAttribute<Usuario, Porteiro> porteiroList;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile SingularAttribute<Usuario, Permissao> permissao;
    public static volatile ListAttribute<Usuario, Zelador> zeladorList;
    public static volatile SingularAttribute<Usuario, Movimentacao> movimentacao;
    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile SingularAttribute<Usuario, byte[]> foto;
    public static volatile SingularAttribute<Usuario, String> cpf;
    public static volatile ListAttribute<Usuario, Titular> titularList;
    public static volatile SingularAttribute<Usuario, String> email;

}