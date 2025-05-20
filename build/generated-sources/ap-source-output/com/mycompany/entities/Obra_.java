package com.mycompany.entities;

import com.mycompany.entities.Autor;
import com.mycompany.entities.Ejemplar;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-20T14:22:05")
@StaticMetamodel(Obra.class)
public class Obra_ { 

    public static volatile CollectionAttribute<Obra, Ejemplar> ejemplarCollection;
    public static volatile CollectionAttribute<Obra, Autor> autorCollection;
    public static volatile SingularAttribute<Obra, String> titulo;
    public static volatile SingularAttribute<Obra, String> editora;
    public static volatile SingularAttribute<Obra, Date> fechaPublicacion;
    public static volatile SingularAttribute<Obra, Integer> idObra;
    public static volatile SingularAttribute<Obra, String> nacionalidad;

}