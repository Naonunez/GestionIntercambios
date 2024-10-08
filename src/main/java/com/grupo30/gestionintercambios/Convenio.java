package com.grupo30.gestionintercambios;

import java.util.ArrayList;
import java.util.List;

public class Convenio {
    private String nombre;
    private String pais;
    private String universidad;
    private String fechaInicio;
    private String fechaFin;
    private String id;
    private List<Estudiante> estudiantes;
    

    public Convenio(String nombre, String id,String pais, String universidad, String fechaInicio, String fechaFin) {
        this.nombre = nombre;
        this.id = id;
        this.pais = pais;
        this.universidad = universidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        estudiantes = new ArrayList<>();
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
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    public void eliminarEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    @Override
    public String toString() {
    return "Convenio ID: " + id +
           ", Nombre: " + nombre +
           ", País: " + pais +
           ", Universidad: " + universidad +
           ", Fecha de Inicio: " + fechaInicio +
           ", Fecha de Fin: " + fechaFin;
}

}
