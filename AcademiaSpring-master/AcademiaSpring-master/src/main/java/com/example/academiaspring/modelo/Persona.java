package com.example.academiaspring.modelo;

import jakarta.persistence.*;


@Entity //Establacemos que esta clase, es la entidad principal
@Table( name = "persona" ) //Nos va a crear la tabla con el atributo persona
public class Persona {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    //Con esto hacemos referencia que esto es el id de la tabla persona

    //Establacemos los atributos que va a manejar nuestra app

    private int id;

    private String name;

    private String apellido;

    public Persona(){}

    public Persona(int id, String name, String apellido) {
        this.id = id;
        this.name = name;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


}
