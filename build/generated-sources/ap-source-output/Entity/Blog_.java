package Entity;

import Entity.Comentario;
import Entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2023-06-17T21:41:47")
@StaticMetamodel(Blog.class)
public class Blog_ { 

    public static volatile SingularAttribute<Blog, String> contenido;
    public static volatile ListAttribute<Blog, Comentario> comentarioList;
    public static volatile SingularAttribute<Blog, Usuario> idUsuario;
    public static volatile SingularAttribute<Blog, String> titulo;
    public static volatile SingularAttribute<Blog, Integer> id;
    public static volatile SingularAttribute<Blog, Date> fechaPublicacion;

}