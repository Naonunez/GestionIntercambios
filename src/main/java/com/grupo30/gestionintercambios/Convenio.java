package com.grupo30.gestionintercambios;

public class Convenio {
    private String nombre;
    private String pais;
    private String universidad;
    private String fechaInicio;
    private String fechaFin;
    private String id;
    

    public Convenio(String nombre, String id,String pais, String universidad, String fechaInicio, String fechaFin) {
        this.nombre = nombre;
        this.id = id;
        this.pais = pais;
        this.universidad = universidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
        }

    
    public String getNombre() {
        return nombre;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId() {
        return id;
    }
    
    public void setPais(String pais){
            this.pais = pais;
        }

    public String getPais() {
        return pais;
    }
    
    public void setUniversidad(String universidad){
        this.universidad = universidad;
    }

    public String getUniversidad() {
        return universidad;
    }
    
    public void setfechaInicio(String fechaInicio){
        this.fechaInicio = fechaInicio;
    }
    
    public String getfechaInicio() {
        return fechaInicio;
    }
    
    public void setfechaFin(String fechaFin){
        this.fechaFin = fechaFin;
    }
    
    public String getfechaFin() {
        return fechaFin;
    }

}
