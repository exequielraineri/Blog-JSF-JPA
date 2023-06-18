/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Exequiel
 */
@Stateless
@Named
@ManagedBean
@RequestScoped
public class authController {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private usuarioBean usuarioBean;

    private String user = "";
    private String pass = "";
    private String email = "";
    private String nombre = "";
    private Usuario usuario = new Usuario();

    public String iniciar() {
        System.out.println("pasa");
        System.out.println("user: "+user);
        System.out.println("pass: "+pass);
        Usuario u =usuarioBean.obteneruUsuario(user);
        System.out.println("usuario : "+u.getEmail());
        if (u!=null && u.getPass().equals(pass)) {
            usuario = u;
            return "perfil";
        } else {
            return "login";
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String registrarUsuario() {
        
        Usuario usuarioExistente=usuarioBean.obteneruUsuario(user);
        if (usuarioExistente!=null) {
            return "index";
        }else{
            usuarioBean.registrarUsuario(nombre, email, user, pass);
            nombre="";
            email="";
            user="";
            pass="";
            return "login";
        }
    }

    public usuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(usuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    private void mostrarUsuario(Usuario u) {
        System.out.println("\nNombre: " + u.getNombre()
                + "\nEmail: " + u.getEmail()
                + "\nUser: " + u.getUser()
                + "\nPass: " + u.getPass());
    }

}
