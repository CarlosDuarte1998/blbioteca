package com.mycompany.entities;

import com.mycompany.entities.Obra;
import com.mycompany.entities.Prestamo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-23T16:47:43")
@StaticMetamodel(Ejemplar.class)
public class Ejemplar_ { 

    public static volatile CollectionAttribute<Ejemplar, Prestamo> prestamoCollection;
    public static volatile SingularAttribute<Ejemplar, Integer> numeroEjemplar;
    public static volatile SingularAttribute<Ejemplar, String> estadoConservacion;
    public static volatile SingularAttribute<Ejemplar, Integer> idEjemplar;
    public static volatile SingularAttribute<Ejemplar, Obra> idObra;

}