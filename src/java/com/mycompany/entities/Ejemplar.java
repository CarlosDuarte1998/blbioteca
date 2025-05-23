/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author inf-cduarte
 */
@Entity
@Table(name = "EJEMPLAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejemplar.findAll", query = "SELECT e FROM Ejemplar e")
    , @NamedQuery(name = "Ejemplar.findByIdEjemplar", query = "SELECT e FROM Ejemplar e WHERE e.idEjemplar = :idEjemplar")
    , @NamedQuery(name = "Ejemplar.findByNumeroEjemplar", query = "SELECT e FROM Ejemplar e WHERE e.numeroEjemplar = :numeroEjemplar")
    , @NamedQuery(name = "Ejemplar.findByEstadoConservacion", query = "SELECT e FROM Ejemplar e WHERE e.estadoConservacion = :estadoConservacion")})
public class Ejemplar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EJEMPLAR")
    private Integer idEjemplar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_EJEMPLAR")
    private int numeroEjemplar;
    @Size(max = 100)
    @Column(name = "ESTADO_CONSERVACION")
    private String estadoConservacion;
    @JoinColumn(name = "ID_OBRA", referencedColumnName = "ID_OBRA")
    @ManyToOne
    private Obra idObra;
    @OneToMany(mappedBy = "idEjemplar")
    private Collection<Prestamo> prestamoCollection;

    public Ejemplar() {
    }

    public Ejemplar(Integer idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Ejemplar(Integer idEjemplar, int numeroEjemplar) {
        this.idEjemplar = idEjemplar;
        this.numeroEjemplar = numeroEjemplar;
    }

    public Integer getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(Integer idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public int getNumeroEjemplar() {
        return numeroEjemplar;
    }

    public void setNumeroEjemplar(int numeroEjemplar) {
        this.numeroEjemplar = numeroEjemplar;
    }

    public String getEstadoConservacion() {
        return estadoConservacion;
    }

    public void setEstadoConservacion(String estadoConservacion) {
        this.estadoConservacion = estadoConservacion;
    }

    public Obra getIdObra() {
        return idObra;
    }

    public void setIdObra(Obra idObra) {
        this.idObra = idObra;
    }

    @XmlTransient
    public Collection<Prestamo> getPrestamoCollection() {
        return prestamoCollection;
    }

    public void setPrestamoCollection(Collection<Prestamo> prestamoCollection) {
        this.prestamoCollection = prestamoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEjemplar != null ? idEjemplar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejemplar)) {
            return false;
        }
        Ejemplar other = (Ejemplar) object;
        if ((this.idEjemplar == null && other.idEjemplar != null) || (this.idEjemplar != null && !this.idEjemplar.equals(other.idEjemplar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Ejemplar[ idEjemplar=" + idEjemplar + " ]";
    }
}
