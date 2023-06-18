/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Blog;
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
import javax.persistence.TypedQuery;

@Stateless
@Named
@ManagedBean
public class usuarioBean {

    private Usuario usuario = new Usuario();

    private Blog blog = new Blog();

    @Inject
    private blogBean blogBean;

    @PersistenceContext
    private EntityManager entityManager;

    public Usuario obteneruUsuario(String user) {
        TypedQuery<Usuario> sql = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.user = :user", Usuario.class);
        sql.setParameter("user", user);
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = sql.getResultList();
        if (usuarios.isEmpty()) {
            System.out.println("ES NULO");
            return null;
        } else {
            System.out.println("NO ES NULO");
            usuario = usuarios.get(0);
            return usuarios.get(0);
        }

    }

    public void registrarUsuario(Usuario usuario) {
        entityManager.persist(usuario);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void registrarUsuario(String nombre, String email, String user, String pass) {
        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setEmail(email);
        u.setUser(user);
        u.setPass(pass);

        entityManager.persist(u);
    }

    public String postear() {
        Date fechaActual = new Date();
        blog.setFechaPublicacion(fechaActual);
        blog.setIdUsuario(usuario);

        blogBean.postear(blog);
        blog = new Blog();
        return "perfil";
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

}
