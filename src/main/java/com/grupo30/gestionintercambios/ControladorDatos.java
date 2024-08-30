package com.grupo30.gestionintercambios;
import java.io.* ;
import java.util.*;

public class ControladorDatos {
    private List<Estudiante> estudiantes;
    private List<Convenio> convenios;
    
    
    public ControladorDatos() {
        estudiantes = new ArrayList<>();
        convenios = new ArrayList<>();
    }
    
    public void registrarNuevoEstudiante() throws IOException {
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        
        System.out.print("Ingrese el ID del estudiante: ");
        String id = lector.readLine();
        
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = lector.readLine();
        
        System.out.print("Ingrese el programa de intercambio: ");
        String programa = lector.readLine();
        
        Estudiante estudiante = new Estudiante(id, nombre, programa);
        
        estudiantes.add(estudiante);
        System.out.println("Estudiante registrado exitosamente.");
    }
    
    
}
