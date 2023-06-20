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
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
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
public class blogBean {

    @PersistenceContext
    private EntityManager entityManager;

    private List<Comentario> comentarios = new ArrayList<>();

    private Blog blog = new Blog();

    List<Blog> posteo = new ArrayList<>();

    private String comentario = "";

    public blogBean() {
    }

    public void postear(Blog blog) {
        entityManager.persist(blog);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public String comentar(Blog blog, Usuario u) {
        Comentario coment = new Comentario();
        coment.setContenido(comentario);
        coment.setFechaPublicacion(new Date());
        ComentarioPK cpk = new ComentarioPK();
        cpk.setIdBlog(blog.getId());
        coment.setComentarioPK(cpk);
        System.out.println("Posteo: " + blog.toString() + "comentariio; " + coment.toString() + "usuario: " + u.toString());
        //comentarioBean.agregarComentario(coment);
        return "perfil";
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<Blog> getPosteo() {
        return posteo;
    }

    public void setPosteo(List<Blog> posteo) {
        this.posteo = posteo;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Blog> posteosMasComentados() {
        Query sql = entityManager.createQuery("SELECT p FROM Blog p ORDER BY p.fechaPublicacion DESC ");
        posteo = sql.getResultList();
        return posteo;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Comentario> lista_comentarios(int id_blog) {
        Query sql = entityManager.createNamedQuery("Comentario.findByIdBlog");
        sql.setParameter("idBlog", id_blog);
        comentarios = sql.getResultList();
        return comentarios;
    }

    public List<Blog> posteosDelUsuario(Usuario u) {
        Query sql = entityManager.createQuery("SELECT p FROM Blog p WHERE p.idUsuario = :usuario ORDER BY p.fechaPublicacion DESC");
        sql.setParameter("usuario", u);
        posteo = sql.getResultList();
        return posteo;
    }

    public void eliminarBlog(Blog p) {
        Blog b = entityManager.merge(p); // Utiliza el parámetro 'p' en lugar de 'blogEntity'
        entityManager.remove(b);
    }

}
