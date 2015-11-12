package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Encomenda;
import modelo.Movimentacao;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Porteiro.class)
public class Porteiro_ { 

    public static volatile ListAttribute<Porteiro, Movimentacao> movimentacaoList;
    public static volatile SingularAttribute<Porteiro, Integer> idPorteiro;
    public static volatile SingularAttribute<Porteiro, String> nome;
    public static volatile SingularAttribute<Porteiro, Usuario> usuario;
    public static volatile ListAttribute<Porteiro, Encomenda> encomendaList;

}