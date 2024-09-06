package com.grupo30.gestionintercambios;

public class Tramite {
    private String id;
    private String estado;
    private String comentarios;
    private String fechaInicio;
    private Estudiante estudiante;
    private Convenio convenio;  
    
    
    public Tramite(String id, String estado, String comentarios, String fechaInicio, Estudiante estudiante, Convenio convenio) {
        this.id = id;
        this.estado = estado;
        this.comentarios = comentarios;
        this.fechaInicio = fechaInicio;
        this.estudiante = estudiante;
        this.convenio = convenio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }
}
