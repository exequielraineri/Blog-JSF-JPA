package Entity;

import Entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2023-06-20T11:28:57")
@StaticMetamodel(Blog.class)
public class Blog_ { 

    public static volatile SingularAttribute<Blog, String> contenido;
    public static volatile SingularAttribute<Blog, Usuario> idUsuario;
    public static volatile SingularAttribute<Blog, String> titulo;
    public static volatile SingularAttribute<Blog, Integer> id;
    public static volatile SingularAttribute<Blog, Date> fechaPublicacion;

}