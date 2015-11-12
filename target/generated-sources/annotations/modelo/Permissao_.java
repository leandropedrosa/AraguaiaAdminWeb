package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Permissao.class)
public class Permissao_ { 

    public static volatile SingularAttribute<Permissao, String> tipo;
    public static volatile SingularAttribute<Permissao, String> situacao;
    public static volatile ListAttribute<Permissao, Usuario> usuarioList;
    public static volatile SingularAttribute<Permissao, Integer> idPermissao;

}