package com.grupo30.gestionintercambios;
import java.io.* ;
public class Main {

    public static void main(String[] args) throws IOException {
        ControladorDatos control = new ControladorDatos();
        mostrarMenuPrincipal(control);
    }
    
    public static void mostrarMenuPrincipal(ControladorDatos control) throws IOException{
        boolean salir = false;
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        String opcion;
        
         while (!salir) {
              System.out.println("=== Gestión de Programas de Intercambio Estudiantil ===");
              System.out.println("1. Registrar nuevo estudiante");
              System.out.println("2. Administración de convenios internacionales");
              System.out.println("3. Trámites y documentación");
              System.out.println("4. Mostrar todos los convenios");
              System.out.println("5. Mostrar todos los estudiantes");              
              System.out.println("6. Buscar estudiante por ID o nombre");
              System.out.println("7. Filtrar convenios por país o universidad");
              System.out.println("8. Eliminar estudiante");        
              System.out.println("9. Salir");
              System.out.print("Seleccione una opción: ");
              opcion = lector.readLine();
              
              switch (opcion) {
                  case "1":
                      control.registrarNuevoEstudiante();
                  case "2":
                      control.administrarConvenios();
                      break;
                  case "3":
                      control.tramitesyDocs();
                      break;
                  case "4":
                      control.listarConvenios();
                      break;
                  case "5":
                      //Definir
                      break;
                  case "6":
                      //Definir
                      break;
                  case "7":
                      //Definir
                      break;
                  case "8":
                      System.out.print("Ingrese el ID del estudiante: ");
                      String id = lector.readLine();
                      
                      control.eliminarEstudiante(id);
                      break;
                  case "9":
                      salir = true;
                      break;
                  default:
                    System.out.println("Opción inválida. Intente nuevamente.");
              }
         
         }
    }
}
