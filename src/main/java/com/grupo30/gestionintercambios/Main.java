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
              System.out.println("3. Actualizar estado de trámite");
              System.out.println("4. Manejo de trámites y documentación");
              System.out.println("5. Mostrar todos los convenios");
              System.out.println("6. Mostrar todos los estudiantes");              
              System.out.println("7. Buscar estudiante por ID o nombre");
              System.out.println("8. Filtrar convenios por país o universidad");
              System.out.println("9. Eliminar estudiante");        
              System.out.println("10. Salir");
              System.out.print("Seleccione una opción: ");
              opcion = lector.readLine();
              
              switch (opcion) {
                  case "1":
                      //Definir
                  case "2":
                      //Definir
                      break;
                  case "3":
                      //Definir
                      break;
                  case "4":
                      //Definir
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
                      //Definir
                      break;
                  case "9":
                      //Definir
                      break;
                  case "10":
                    salir = true;
                    break;
                  default:
                    System.out.println("Opción inválida. Intente nuevamente.");
              }
         
         }
    }
}
