/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ADMIN
 */
@Embeddable
public class ComentarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_blog")
    private int idBlog;

    public ComentarioPK() {
    }

    public ComentarioPK(int id, int idBlog) {
        this.id = id;
        this.idBlog = idBlog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) idBlog;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioPK)) {
            return false;
        }
        ComentarioPK other = (ComentarioPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.idBlog != other.idBlog) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ComentarioPK[ id=" + id + ", idBlog=" + idBlog + " ]";
    }
    
}
