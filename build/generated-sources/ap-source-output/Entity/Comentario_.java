package Entity;

import Entity.Blog;
import Entity.ComentarioPK;
import Entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2023-06-17T21:41:47")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, String> contenido;
    public static volatile SingularAttribute<Comentario, Usuario> idUsuario;
    public static volatile SingularAttribute<Comentario, Date> fechaPublicacion;
    public static volatile SingularAttribute<Comentario, Blog> blog;
    public static volatile SingularAttribute<Comentario, ComentarioPK> comentarioPK;

}