package com.grupo30.gestionintercambios;
import java.io.* ;
import java.util.*;

public class ControladorDatos {
    private List<Estudiante> estudiantes;
    private Map<String, Convenio>  convenios;
    private Map<String, Tramite> tramites;
    
    
    public ControladorDatos() {
        estudiantes = new ArrayList<>();
        convenios = new HashMap<>();
        tramites = new HashMap<>();
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
    public void eliminarEstudiante(String id){
        for(int i= 0; i < estudiantes.size();i++){
            Estudiante estudiante = estudiantes.get(i);
            if(estudiante.getId() == id){
                estudiantes.remove(i);
                System.out.println("Estudiante eliminado exitosamente.");
            }
        }
        System.out.println("Estudiante no encontrado.");
    }
    
    public void administrarConvenios() throws IOException {
        boolean ciclo = false;
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        String opcion;
        while (!ciclo) {
            System.out.println("=== Administracion de convenios internacionales ===");
            System.out.println("1. Registrar convenio");
            System.out.println("2. Actualizar información de un convenio");
            System.out.println("3. Eliminar convenio");
            System.out.println("4. Buscar convenio");
            System.out.println("5. Volver al menu principal");
            System.out.print("Seleccione una opción: ");
            opcion = lector.readLine();
            
            switch (opcion) {
                case "1":
                    agregarNuevoConvenio();
                    break;
                case "2":
                    actualizarInformacionConvenio();
                    break;
                case "3":
                    eliminarConvenio();
                    break;
                case "4":
                    buscarConvenio();
                    break;
                case "5":
                    ciclo = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }        
    }
    public void agregarNuevoConvenio() throws IOException {
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        
        System.out.print("Ingrese el nombre del convenio: ");
        String nombre = lector.readLine();
        
        System.out.print("Ingrese el id del convenio: ");
        String id = lector.readLine();
        
        System.out.print("Ingrese el país asociado: ");
        String pais = lector.readLine();
        
        System.out.print("Ingrese la universidad asociada: ");
        String universidad = lector.readLine();
        
        System.out.print("Ingrese la fecha de inicio (DD-MM-YYYY): ");
        String fechaInicio = lector.readLine();
        
        System.out.print("Ingrese la fecha de fin (DD-MM-YYYY): ");
        String fechaFin = lector.readLine();
        
        Convenio convenio = new Convenio(nombre, id, pais, universidad, fechaInicio, fechaFin);
        convenios.put(nombre, convenio);
        
        System.out.println("Convenio agregado exitosamente.");
        
    }
    
    public void actualizarInformacionConvenio() throws IOException {
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        System.out.print("Ingrese el id del convenio a actualizar: ");
        String id = lector.readLine();
        
        if (convenios.containsKey(id)) {
            System.out.print("Ingrese el nombre del convenio: ");
            String nombre = lector.readLine();
            
            System.out.print("Ingrese el país asociado: ");
            String pais = lector.readLine();
            
            System.out.print("Ingrese la universidad asociada: ");
            String universidad = lector.readLine();
            
            System.out.print("Ingrese la fecha de inicio (DD-MM-YYYY): ");
            String fechaInicio = lector.readLine();
            
            System.out.print("Ingrese la fecha de fin (DD-MM-YYYY): ");
            String fechaFin = lector.readLine();

            Convenio convenio = new Convenio(nombre, id, pais, universidad, fechaInicio, fechaFin);
            convenios.put(id, convenio);
            System.out.println("Convenio actualizado exitosamente.");
        } else {
            System.out.println("Convenio no encontrado.");
        }
    }
    
    public void eliminarConvenio() throws IOException{
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        
        System.out.print("Ingrese el id del convenio a eliminar: ");
        String id = lector.readLine();
        
        if (convenios.remove(id) != null) {
            System.out.println("Convenio eliminado exitosamente.");
        } else {
            System.out.println("Convenio no encontrado.");
        }
    }
    
    public void buscarConvenio() throws IOException{
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        System.out.print("Ingrese el nombre del convenio a buscar: ");
        String id = lector.readLine();
        
        Convenio convenio = convenios.get(id);
        if (convenio != null) {
            System.out.println(convenio);
        } else {
            System.out.println("Convenio no encontrado.");
        }
    }
    
    public void listarConvenios() {
        if (convenios.isEmpty()) {
            System.out.println("No hay convenios registrados.");
        } else {
            for (Convenio convenio : convenios.values()) {
                System.out.println(convenio);
            }
        }
    }
    
    public void tramitesyDocs() throws IOException {
        boolean ciclo = false;
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        String opcion;
        while (!ciclo) {
            System.out.println("===Tramites y Documentacion===");
            System.out.println("1. Actualizar estado de trámite por ID");
            System.out.println("2. Marcar trámite como completado");
            System.out.println("3. Agregar comentarios al trámite");
            System.out.println("4. Cambiar fecha de finalización del trámite");
            System.out.println("5. Ver estado actual del trámite");
            System.out.println("6. Listar todos los trámites y sus estados");
            System.out.println("7. Filtrar trámites por estado");
            System.out.println("8. Cancelar trámite");
            System.out.println("9. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = lector.readLine();
            
            switch (opcion) {
                case "1":
                    //
                    break;
                case "2":
                    //
                    break;
                case "3":
                    //
                    break;
                case "4":
                    //
                    break;
                case "5":
                    //
                    break;
                case "6":
                    //
                    break;
                case "7":
                    //
                    break;
                case "8":
                    //
                    break;
                case "9":
                    ciclo = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
        
    }
}
