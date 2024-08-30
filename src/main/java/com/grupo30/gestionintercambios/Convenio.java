package com.grupo30.gestionintercambios;

public class Convenio {
    private String nombre;
    private String pais;
    private String universidad;

    public Convenio(String nombre, String pais, String universidad) {
        this.nombre = nombre;
        this.pais = pais;
        this.universidad = universidad;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
        }

    
    public String getNombre() {
        return nombre;
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

}
