/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Blog;
import Entity.Comentario;
import Entity.ComentarioPK;
import Entity.Usuario;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Exequiel
 */
@Stateless
@Named
@ManagedBean
public class comentarioBean {

    private Comentario comentario=new Comentario();
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public String comentar(int id_blog,int id_usuario){
        //Query sql=entityManager.createNamedQuery("Blog.findById");
        //sql.setParameter("id", id_blog);
        Blog blog=entityManager.find(Blog.class, id_blog);
        comentario.setBlog(blog);
        ComentarioPK cpk=new ComentarioPK();
        cpk.setIdBlog(blog.getId());
        comentario.setComentarioPK(cpk);
        comentario.setContenido(comentario.getContenido());
        comentario.setFechaPublicacion(new Date());
        Usuario usuario=entityManager.find(Usuario.class, id_usuario);
        comentario.setIdUsuario(usuario);
        
        entityManager.persist(comentario);
        comentario=new Comentario();
        return "perfil";
    }
    
    

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    
    
    //alta
    public void altaComentario(Comentario coment) {
        entityManager.persist(coment);
    }
    
    //baja
    public void eliminarComentario(Comentario c){
        entityManager.remove(c);
    }
    
    //oobtener
    public Comentario obtenerComentario(int id){
        Comentario c=entityManager.find(Comentario.class, id);
        return c;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
    
    
    
    
}
