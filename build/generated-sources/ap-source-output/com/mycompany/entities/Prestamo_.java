package com.mycompany.entities;

import com.mycompany.entities.Ejemplar;
import com.mycompany.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-23T16:47:43")
@StaticMetamodel(Prestamo.class)
public class Prestamo_ { 

    public static volatile SingularAttribute<Prestamo, Date> fechaDevolucion;
    public static volatile SingularAttribute<Prestamo, Date> fechaInicio;
    public static volatile SingularAttribute<Prestamo, Integer> idPrestamo;
    public static volatile SingularAttribute<Prestamo, Usuario> duiUsuario;
    public static volatile SingularAttribute<Prestamo, Ejemplar> idEjemplar;

}