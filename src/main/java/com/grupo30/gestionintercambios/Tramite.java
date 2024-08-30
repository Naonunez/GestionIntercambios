package com.grupo30.gestionintercambios;

public class Tramite {
    private String id;
    private String estado;
    private String comentarios;
    private String fechaFinalizacion;
    private String estudiante;
    private String universidad;
    
    
    public Tramite(String id, String estado, String comentarios, String fechaFinalizacion, String estudiante,String universidad) {
        this.id = id;
        this.estado = estado;
        this.comentarios = comentarios;
        this.fechaFinalizacion = fechaFinalizacion;
        this.estudiante = estudiante;
        this.universidad = universidad;
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

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
}
