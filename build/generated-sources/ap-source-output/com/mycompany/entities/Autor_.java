package com.mycompany.entities;

import com.mycompany.entities.Obra;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-20T14:22:05")
@StaticMetamodel(Autor.class)
public class Autor_ { 

    public static volatile SingularAttribute<Autor, Integer> idAutor;
    public static volatile SingularAttribute<Autor, Character> sexo;
    public static volatile SingularAttribute<Autor, String> nombre;
    public static volatile CollectionAttribute<Autor, Obra> obraCollection;
    public static volatile SingularAttribute<Autor, String> nacionalidad;

}