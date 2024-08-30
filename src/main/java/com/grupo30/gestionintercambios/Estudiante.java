package com.grupo30.gestionintercambios;

public class Estudiante {
    private String id;
    private String nombre;
    private String programa;

    public Estudiante(String id, String nombre, String programa) {
        this.id = id;
        this.nombre = nombre;
        this.programa = programa;
    }
       
    public void setId(String id){
        this.id = id;
    }
    public String getId() {
        return id;
    }
       
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
       
    public void setPrograma(String programa){
        this.programa = programa;
    }

    public String getPrograma() {
        return programa;
    }
    
}
