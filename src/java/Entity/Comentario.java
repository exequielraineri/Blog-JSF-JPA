/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Exequiel
 */
@Entity
@Table(name = "comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c")
    , @NamedQuery(name = "Comentario.findById", query = "SELECT c FROM Comentario c WHERE c.comentarioPK.id = :id")
    , @NamedQuery(name = "Comentario.findByIdBlog", query = "SELECT c FROM Comentario c WHERE c.comentarioPK.idBlog = :idBlog")
    , @NamedQuery(name = "Comentario.findByContenido", query = "SELECT c FROM Comentario c WHERE c.contenido = :contenido")
    , @NamedQuery(name = "Comentario.findByFechaPublicacion", query = "SELECT c FROM Comentario c WHERE c.fechaPublicacion = :fechaPublicacion")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComentarioPK comentarioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contenido")
    private String contenido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaPublicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion;
    @JoinColumn(name = "id_blog", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Blog blog;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Comentario() {
    }

    public Comentario(ComentarioPK comentarioPK) {
        this.comentarioPK = comentarioPK;
    }

    public Comentario(ComentarioPK comentarioPK, String contenido, Date fechaPublicacion) {
        this.comentarioPK = comentarioPK;
        this.contenido = contenido;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Comentario(int id, int idBlog) {
        this.comentarioPK = new ComentarioPK(id, idBlog);
    }

    public ComentarioPK getComentarioPK() {
        return comentarioPK;
    }

    public void setComentarioPK(ComentarioPK comentarioPK) {
        this.comentarioPK = comentarioPK;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String mostrarFecha(){
        SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy  HH:mm");
        return sf.format(fechaPublicacion);
    }
    
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comentarioPK != null ? comentarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.comentarioPK == null && other.comentarioPK != null) || (this.comentarioPK != null && !this.comentarioPK.equals(other.comentarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Comentario[ comentarioPK=" + comentarioPK + " ]";
    }
    
}
