package com.mycompany.entities;

import com.mycompany.entities.Prestamo;
import com.mycompany.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-20T14:22:05")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile CollectionAttribute<Usuario, Prestamo> prestamoCollection;
    public static volatile SingularAttribute<Usuario, Usuario> duiAval;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, String> dui;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile CollectionAttribute<Usuario, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Usuario, String> nombre;

}