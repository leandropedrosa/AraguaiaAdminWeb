package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Apartamento;
import modelo.Dependente;
import modelo.Encomenda;
import modelo.Garagem;
import modelo.Solicitacao;
import modelo.Telefone;
import modelo.Usuario;
import modelo.Veiculo;
import modelo.Visitantes;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Titular.class)
public class Titular_ { 

    public static volatile ListAttribute<Titular, Telefone> telefoneList;
    public static volatile SingularAttribute<Titular, String> tipo;
    public static volatile SingularAttribute<Titular, String> situacao;
    public static volatile ListAttribute<Titular, Veiculo> veiculoList;
    public static volatile ListAttribute<Titular, Visitantes> visitantesList;
    public static volatile ListAttribute<Titular, Garagem> garagemList;
    public static volatile SingularAttribute<Titular, String> nome;
    public static volatile ListAttribute<Titular, Encomenda> encomendaList;
    public static volatile ListAttribute<Titular, Solicitacao> solicitacaoList;
    public static volatile SingularAttribute<Titular, Integer> idTitular;
    public static volatile SingularAttribute<Titular, String> rg;
    public static volatile ListAttribute<Titular, Apartamento> apartamentoList;
    public static volatile SingularAttribute<Titular, Usuario> usuario;
    public static volatile SingularAttribute<Titular, Date> dtNascimento;
    public static volatile SingularAttribute<Titular, String> email;
    public static volatile ListAttribute<Titular, Dependente> dependenteList;

}