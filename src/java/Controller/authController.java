/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Usuario;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    private Usuario usuario = new Usuario();

    private String mensajeLogin = "";

    public String iniciar() {
        Usuario u = usuarioBean.obteneruUsuario(usuario.getUser());
        if (u != null && u.getPass().equals(usuario.getPass())) {
            usuario = u;
            mensajeLogin = "";
            return "perfil";
        } else {
            mensajeLogin = "Usuario y/o Contraseña incorrecta!";
            return "login";
        }

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

    public String registrarUsuario() {
        mensajeLogin="";
        Usuario usuarioExistente = usuarioBean.obteneruUsuario(usuario.getUser());
        if (usuarioExistente != null) {
            mensajeLogin = "Usuario ya existente";
            return "index";
        } else {
            usuarioBean.registrarUsuario(usuario);
            mensajeLogin = "Se registro con exitos!";
            return "index";
        }
    }

    public usuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(usuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public String inicio() {
        return "inicio";
    }

    public String perfil() {
        return "perfil";
    }

    public String cerrarSession() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login";
    }

    public String getMensajeLogin() {
        return mensajeLogin;
    }

    public void setMensajeLogin(String mensajeLogin) {
        this.mensajeLogin = mensajeLogin;
    }

    
    public String login(){
        mensajeLogin="";
        return "login";
    }
    
}
