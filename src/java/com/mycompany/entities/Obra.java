/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author inf-cduarte
 */
@Entity
@Table(name = "OBRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obra.findAll", query = "SELECT o FROM Obra o")
    , @NamedQuery(name = "Obra.findByIdObra", query = "SELECT o FROM Obra o WHERE o.idObra = :idObra")
    , @NamedQuery(name = "Obra.findByTitulo", query = "SELECT o FROM Obra o WHERE o.titulo = :titulo")
    , @NamedQuery(name = "Obra.findByNacionalidad", query = "SELECT o FROM Obra o WHERE o.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Obra.findByEditora", query = "SELECT o FROM Obra o WHERE o.editora = :editora")
    , @NamedQuery(name = "Obra.findByFechaPublicacion", query = "SELECT o FROM Obra o WHERE o.fechaPublicacion = :fechaPublicacion")})
public class Obra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_OBRA")
    private Integer idObra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 100)
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @Size(max = 100)
    @Column(name = "EDITORA")
    private String editora;
    @Column(name = "FECHA_PUBLICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    @JoinTable(name = "OBRA_AUTOR", joinColumns = {
        @JoinColumn(name = "ID_OBRA", referencedColumnName = "ID_OBRA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_AUTOR", referencedColumnName = "ID_AUTOR")})
    @ManyToMany
    private Collection<Autor> autorCollection;
    @OneToMany(mappedBy = "idObra")
    private Collection<Ejemplar> ejemplarCollection;

    public Obra() {
    }

    public Obra(Integer idObra) {
        this.idObra = idObra;
    }

    public Obra(Integer idObra, String titulo) {
        this.idObra = idObra;
        this.titulo = titulo;
    }

    public Integer getIdObra() {
        return idObra;
    }

    public void setIdObra(Integer idObra) {
        this.idObra = idObra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @XmlTransient
    public Collection<Autor> getAutorCollection() {
        return autorCollection;
    }

    public void setAutorCollection(Collection<Autor> autorCollection) {
        this.autorCollection = autorCollection;
    }

    @XmlTransient
    public Collection<Ejemplar> getEjemplarCollection() {
        return ejemplarCollection;
    }

    public void setEjemplarCollection(Collection<Ejemplar> ejemplarCollection) {
        this.ejemplarCollection = ejemplarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObra != null ? idObra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obra)) {
            return false;
        }
        Obra other = (Obra) object;
        if ((this.idObra == null && other.idObra != null) || (this.idObra != null && !this.idObra.equals(other.idObra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return titulo + "|"+ idObra ;
    }
    
}
