package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Titular;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-10-18T11:57:07")
@StaticMetamodel(Dependente.class)
public class Dependente_ { 

    public static volatile SingularAttribute<Dependente, Integer> idDependente;
    public static volatile SingularAttribute<Dependente, String> rg;
    public static volatile SingularAttribute<Dependente, String> parentesco;
    public static volatile SingularAttribute<Dependente, String> cpf;
    public static volatile SingularAttribute<Dependente, String> nome;
    public static volatile SingularAttribute<Dependente, Date> dtNascimento;
    public static volatile SingularAttribute<Dependente, Titular> titular;

}