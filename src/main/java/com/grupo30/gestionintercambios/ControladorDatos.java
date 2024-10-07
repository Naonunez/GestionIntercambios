package com.grupo30.gestionintercambios;
import java.io.* ;
import java.util.*;

public class ControladorDatos {
    public List<Estudiante> estudiantes;
    public Map<String, Convenio>  convenios;
    public Map<String, Tramite> tramites;
    private final String archivoEst = "estudiantes.txt";
    private final String archivoConvenios = "convenios.txt";
    private final String archivoTramites = "tramites.txt";
    
    
        
    
    public ControladorDatos() {
        estudiantes = new ArrayList<>();
        convenios = new HashMap<>();
        tramites = new HashMap<>();
        
        //Datos iniciales estudiante
        estudiantes.add(new Estudiante("001", "Juan Perez", "Ingenieria de Sistemas"));
        estudiantes.add(new Estudiante("002", "Maria Gomez", "Derecho"));
        estudiantes.add(new Estudiante("003", "Carlos Sanchez", "Medicina"));
        estudiantes.add(new Estudiante("004", "Ana Rodriguez", "Administracion de Empresas"));
        
        //Datos iniciales convenio
        convenios.put("C001", new Convenio("Convenio A", "C001", "España", "Universidad de Barcelona", "01-01-2023", "01-01-2024"));
        convenios.put("C002", new Convenio("Convenio B", "C002", "Francia", "Universidad de Paris", "05-10-2022", "05-10-2023"));
        convenios.put("C003", new Convenio("Convenio C", "C003", "Mexico", "Universidad Nacional Autonoma de México", "03-15-2023", "03-15-2024"));
        convenios.put("C004", new Convenio("Convenio D", "C004", "Colombia", "Universidad de los Andes", "09-01-2022", "09-01-2023"));
        
        //Datos iniciales tramites
        tramites.put("T001", new Tramite("T001", "Pendiente", "Falta completar documentos", "01-15-2024", estudiantes.get(0), convenios.get("C001")));
        tramites.put("T002", new Tramite("T002", "En proceso", "Revision en curso", "12-10-2023", estudiantes.get(1), convenios.get("C002")));
        tramites.put("T003", new Tramite("T003", "Finalizado", "Tramite completado con exito", "11-05-2023", estudiantes.get(2), convenios.get("C003")));
        tramites.put("T004", new Tramite("T004", "Cancelado", "Tramite cancelado por el estudiante", "10-20-2023", estudiantes.get(3), convenios.get("C004")));

    }
    
    
    public void gestionEstudiantes()throws IOException{
        boolean salir = false;
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        String opcion;
        
  
        while (!salir) {
            System.out.println("=== Gestion estudiantes ===");
            System.out.println("1. Registrar nuevo estudiante");
            System.out.println("2. Actualizar nombre y programa");
            System.out.println("3. Actualizar todos los datos del estudiante");
            System.out.println("4.Volver");
            System.out.print("Seleccione una opcion: ");
            opcion = lector.readLine();
            
            switch (opcion) {
                case "1":
                    registrarNuevoEstudiante();
                    break;
                case "2":
                    System.out.print("Ingrese el ID del estudiante a actualizar: ");
                    String id = lector.readLine();
                    Estudiante estudiante = buscarEstudiantePorId(id);
                    
                    if (estudiante != null) {
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = lector.readLine();

                    System.out.print("Ingrese el nuevo programa: ");
                    String nuevoPrograma = lector.readLine();
                    
                    estudiante.actualizarDatos(nuevoNombre, nuevoPrograma);
                    System.out.println("Datos del estudiante actualizados correctamente.");
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case "3":
                    System.out.print("Ingrese el ID del estudiante a actualizar: ");
                    String Id = lector.readLine();
                    Estudiante estudianteId = buscarEstudiantePorId(Id);
                    
                    if (estudianteId != null) {
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = lector.readLine();

                    System.out.print("Ingrese el nuevo programa: ");
                    String nuevoPrograma = lector.readLine();
                    
                    System.out.print("Ingrese el nuevo Id: ");
                    String nuevoId = lector.readLine();
                    
                    estudianteId.actualizarDatos(nuevoNombre, nuevoPrograma, nuevoId);
                    System.out.println("Datos del estudiante actualizados correctamente.");
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
            }
        }
    }
    public void registrarNuevoEstudiante() throws IOException {
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        
        System.out.print("Ingrese el ID del estudiante: ");
        String id = lector.readLine();
        
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = lector.readLine();
        
        System.out.print("Ingrese el programa universitario: ");
        String programa = lector.readLine();
        
        Estudiante estudiante = new Estudiante(id, nombre, programa);
        
        estudiantes.add(estudiante);
        System.out.println("Estudiante registrado exitosamente.");
    }
    
    
    public Estudiante buscarEstudiantePorId(String id) {
        for (Estudiante e : estudiantes) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }
    private void buscarPorNombre(String nombre) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre)) {
                mostrarInformacionEstudiante(estudiante);
                return;
            }
        }
        System.out.println("No se encontro un estudiante con el nombre: " + nombre);
    }
    private void mostrarInformacionEstudiante(Estudiante estudiante) {
        System.out.println("ID: " + estudiante.getId());
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Programa: " + estudiante.getPrograma());
    }
    
    
    public void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            for (Estudiante estudiante : estudiantes) {
                System.out.println("ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNombre() + 
                                   ", Programa: " + estudiante.getPrograma());
            }
        }
    }
    
    public void eliminarEstudiante(String id){
        for(int i= 0; i < estudiantes.size();i++){
            Estudiante estudiante = estudiantes.get(i);
            if(estudiante.getId().equals(id)){
                estudiantes.remove(i);
                System.out.println("Estudiante eliminado exitosamente.");
            }
        }
        System.out.println("Estudiante no encontrado.");
    }
    
    public void buscarEstudiante()throws IOException {
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        System.out.println("Seleccione una opcion");
        System.out.println("1.Por id");
        System.out.println("2.Por nombre");
        String opcion = lector.readLine();
        
        if (opcion.equals("1")) {
            System.out.print("Ingrese el ID del estudiante: ");
            String idBuscado = lector.readLine();
            buscarEstudiantePorId(idBuscado);
            
            if(idBuscado == null){
                System.out.println("No se encontro un estudiante con el ID: " + idBuscado);
            }
            
        } else if(opcion.equals("2")){
            System.out.print("Ingrese el nombre del estudiante: ");
            String nombreBuscado = lector.readLine();
            buscarPorNombre(nombreBuscado);
            
        }else {
            System.out.println("Opcion no valida.");
        }
        
        
    }
    
    public void administrarConvenios() throws IOException {
        boolean ciclo = false;
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        String opcion;
        while (!ciclo) {
            System.out.println("=== Administracion de convenios internacionales ===");
            System.out.println("1. Registrar convenio");
            System.out.println("2. Actualizar informacion de un convenio");
            System.out.println("3. Eliminar convenio");
            System.out.println("4. Buscar convenio");
            System.out.println("5. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
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
                    ciclo = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
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
        convenios.put(id, convenio);
        
        System.out.println("Convenio agregado exitosamente.");
        
    }
    
    public void actualizarInformacionConvenio() throws IOException {
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        System.out.print("Ingrese el id del convenio a actualizar: ");
        String id = lector.readLine();
        
        if (convenios.containsKey(id)) {
            System.out.print("Ingrese el nombre del convenio: ");
            String nombre = lector.readLine();
            
            System.out.print("Ingrese el pais asociado: ");
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
    
    public Convenio buscarConvenioPorId(String id) {
        return convenios.get(id); 
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
    
    private void mostrarConveniosFiltrados(List<Convenio> conveniosFiltrados) {
        if (conveniosFiltrados.isEmpty()) {
            System.out.println("No se encontraron convenios.");
        } else {
            for (Convenio convenio : conveniosFiltrados) {
                System.out.println("Convenio ID: " + convenio.getId() +
                                   ", Universidad: " + convenio.getUniversidad() +
                                   ", Pais: " + convenio.getPais() +
                                   ", Fecha de Inicio: " + convenio.getfechaInicio() +
                                   ", Fecha de Fin: " + convenio.getfechaFin());
            }
        }
    }
    
    private void filtrarPorPais(String pais) {
        List<Convenio> filtrados = new ArrayList<>();
        for (Convenio convenio : convenios.values()) {
            if (convenio.getPais().equalsIgnoreCase(pais)) {
                filtrados.add(convenio);
            }
        }
        mostrarConveniosFiltrados(filtrados);
    }
    
    private void filtrarPorUniversidad(String universidad) {
        List<Convenio> filtrados = new ArrayList<>();
        for (Convenio convenio : convenios.values()) {
            if (convenio.getUniversidad().equalsIgnoreCase(universidad)) {
                filtrados.add(convenio);
            }
        }
        mostrarConveniosFiltrados(filtrados);
    }
    
    public void filtrarConvenios()throws IOException{
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        System.out.println("Seleccione una opcion");
        System.out.println("1.Por pais");
        System.out.println("2.Por universidad");
        String opcion = lector.readLine();
        
        if (opcion.equals("1")) {
            System.out.print("Ingrese el nombre del pais: ");
            String paisBuscado = lector.readLine();
            filtrarPorPais(paisBuscado);
            
        }else if (opcion.equals("2")) {
            System.out.print("Ingrese el nombre de la universidad: ");
            String universidadBuscada = lector.readLine();
            filtrarPorUniversidad(universidadBuscada);
            
        }else {
            System.out.println("Opcion no valida.");
        }
        
    }
    
    public void tramitesyDocs() throws IOException {
        boolean ciclo = false;
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        String opcion;
        while (!ciclo) {
            System.out.println("===Tramites y Documentacion===");
            System.out.println("1. Crear tramite");
            System.out.println("2. Actualizar estado de tramite por ID");
            System.out.println("3. Agregar comentarios al tramite");
            System.out.println("4. Ver estado actual del tramite");
            System.out.println("5. Listar todos los tramites y sus estados");
            System.out.println("6. Filtrar tramites por estado");
            System.out.println("7. Cancelar tramite");
            System.out.println("8. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = lector.readLine();
            
            switch (opcion) {
                case "1":
                    crearTramite();
                    break;
                case "2":
                    actualizarTramID();
                    break;
                case "3":
                    agregarCom();
                    break;
                case "4":
                    verEstado();
                    break;
                case "5":
                    verTodosTramites();
                    break;
                case "6":
                    filtrarPorEstado();
                    break;
                case "7":
                    cancelarTramite();
                    break;
                case "8":
                    ciclo = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        }
        
    }
    public void crearTramite() throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese el ID del tramite: ");
        String id = lector.readLine();

        if (tramites.containsKey(id)) {
            System.out.println("Ya existe un tramite con ese ID.");
            return;
        }

        System.out.print("Ingrese el estado del tramite: ");
        String estado = lector.readLine();

        System.out.print("Ingrese los comentarios del tramite: ");
        String comentarios = lector.readLine();

        System.out.print("Ingrese la fecha de inicio (DD-MM-YYYY): ");
        String fechaInicio = lector.readLine();

        System.out.print("Ingrese el ID del estudiante: ");
        String idEstudiante = lector.readLine();
        Estudiante estudiante = buscarEstudiantePorId(idEstudiante);

        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.print("Ingrese el ID del convenio: ");
        String idConvenio = lector.readLine();
        Convenio convenio = buscarConvenioPorId(idConvenio);

        if (convenio == null) {
            System.out.println("Convenio no encontrado.");
            return;
        }

        Tramite nuevoTramite = new Tramite(id, estado, comentarios, fechaInicio, estudiante, convenio);
        tramites.put(id, nuevoTramite);

        convenio.agregarEstudiante(estudiante);

        System.out.println("Tramite creado exitosamente.");
        }
        public void actualizarTramID() throws IOException {
            BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
            System.out.print("Ingrese el id del tramite a actualizar: ");
            String id = lector.readLine();

            System.out.print("Ingrese el nuevo estado del tramite a actualizar: ");
            String nuevoEstado = lector.readLine();

            Tramite tramite = tramites.get(id);
            if (tramite != null) {
                tramite.setEstado(nuevoEstado);
                System.out.println("Estado actualizado correctamente.");
            } else {
                System.out.println("Tramite no encontrado.");
            }
    }
    //Sobrecarga de metodo
    public void actualizarTramID(String id, String nuevoEstado) {
    Tramite tramite = tramites.get(id);
    if (tramite != null) {
        tramite.setEstado(nuevoEstado);
    } else {
        System.out.println("Trámite no encontrado.");
    }
}
    
    public void agregarCom() throws IOException{
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        System.out.print("Ingrese el ID del tramite: ");
        String id = lector.readLine();
        
        System.out.print("Ingrese el comentario: ");
        String comentario = lector.readLine();
        
        Tramite tramite = tramites.get(id);
        if (tramite != null) {
            tramite.setComentarios(comentario);
            System.out.println("Comentario agregado correctamente.");
        } else {
            System.out.println("Tramite no encontrado.");
        }
    }
    
    public void verEstado() throws IOException{
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        System.out.print("Ingrese el ID del tramite: ");
        String id = lector.readLine();
        
        Tramite tramite = tramites.get(id);
        if (tramite != null) {
            System.out.println(tramite);
        }else {
            System.out.println("Tramite no encontrado.");
        }
    }
    
    
    
    public void verTodosTramites(){
        if (tramites.isEmpty()) {
            System.out.println("No hay tramites registrados.");
        } else {
            tramites.values().forEach(tramite ->
            System.out.println("ID: " + tramite.getId() + ", Estado: " + tramite.getEstado()));
        }
    }
    
    private List<Tramite> obtenerTramitesPorEstado(String estado) {
        List<Tramite> resultados = new ArrayList<>();
        for (Tramite tramite : tramites.values()) {
            if (tramite.getEstado().equalsIgnoreCase(estado)) {
                resultados.add(tramite);
            }
        }
        return resultados;
    }
    
    public void filtrarPorEstado() throws IOException {
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        String opcion;
        boolean ciclo = false;
        while (!ciclo) {
            System.out.println("Estados:");
            System.out.println("1. Pendiente");
            System.out.println("2. En proceso");
            System.out.println("3. Finalizado");
            System.out.println("4. Cancelado");
            System.out.println("5. Volver");

            System.out.print("Seleccione una opcion: ");
            opcion = lector.readLine();
            List<Tramite> filtrados = new ArrayList<>();
            
            switch (opcion) {
                case "1":
                    filtrados = obtenerTramitesPorEstado("Pendiente");
                    break;
                case "2":
                    filtrados = obtenerTramitesPorEstado("En proceso");
                    break;
                case "3":
                    filtrados = obtenerTramitesPorEstado("Finalizado");
                    break;
                case "4":
                    filtrados = obtenerTramitesPorEstado("Cancelado");
                    break;
                case "5":
                    ciclo = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
                    
            }
            
            if (!filtrados.isEmpty()) {
                for (Tramite tramite : filtrados) {
                    System.out.println("ID: " + tramite.getId() + ", Estado: " + tramite.getEstado() +
                                       ", Estudiante: " + tramite.getEstudiante().getNombre() +
                                       ", Convenio: " + tramite.getConvenio().getNombre());
                }
            } else {
                System.out.println("No hay tramites en el estado seleccionado.");
            }
        }
    }
    
    public void cancelarTramite() throws IOException{
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        System.out.print("Ingrese el ID del tramite: ");
        String id = lector.readLine();
        
        Tramite tramite = tramites.get(id);
        if (tramite != null) {
            tramite.setEstado("Cancelado");
            System.out.println("Tramite cancelado.");
        } else {
            System.out.println("Tramite no encontrado.");
        }
    }
    
    public void cargarDatosEst() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEst))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String id = datos[0];
                    String nombre = datos[1];
                    String programa = datos[2];
                    estudiantes.add(new Estudiante(id, nombre, programa));
                }
            }
            System.out.println("Datos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    public void guardarDatosEst() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoEst))) {
            for (Estudiante estudiante : estudiantes) {
                bw.write(estudiante.toString());
                bw.newLine();
            }
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    public void cargarDatosConvenio() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoConvenios))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    String id = datos[0];
                    String nombre = datos[1];
                    String pais = datos[2];
                    String universidad = datos[3];
                    String fechaInicio = datos[4];
                    String fechaFin = datos[5];
                    
                    List<Estudiante> estudiantesAsociados = obtenerEstudiantesDeConvenio(datos[6]);

                    Convenio convenio = new Convenio(nombre, id, pais, universidad, fechaInicio, fechaFin);

                    for (Estudiante estudiante : estudiantesAsociados) {
                        convenio.agregarEstudiante(estudiante);
                    }

                    convenios.put(id, convenio);
                }
            }
            System.out.println("Convenios cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de convenios: " + e.getMessage());
        }
    }

    private List<Estudiante> obtenerEstudiantesDeConvenio(String listaIdsEstudiantes) {
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        String[] ids = listaIdsEstudiantes.split(";"); // Separar los IDs por ";"

        // Buscar los estudiantes por su ID en la lista de estudiantes global
        for (String id : ids) {
            for (Estudiante estudiante : estudiantes) {
                if (String.valueOf(estudiante.getId()).equals(id)) {
                    listaEstudiantes.add(estudiante);
                }
            }
        }
        return listaEstudiantes;
    }
    
    public void guardarConvenios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoConvenios))) {
            for (Map.Entry<String, Convenio> entry : convenios.entrySet()) {
                Convenio convenio = entry.getValue();

                StringBuilder sbEstudiantes = new StringBuilder();
                for (Estudiante estudiante : convenio.getEstudiantes()) {
                    if (sbEstudiantes.length() > 0) {
                        sbEstudiantes.append(";"); 
                    }
                    sbEstudiantes.append(estudiante.getId());  
                }

                
                bw.write(convenio.getId() + "," +
                         convenio.getNombre() + "," +
                         convenio.getPais() + "," +
                         convenio.getUniversidad() + "," +
                         convenio.getfechaInicio() + "," +
                         convenio.getfechaFin() + "," +
                         sbEstudiantes.toString()); 

                bw.newLine();  
            }
            System.out.println("Convenios guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los convenios: " + e.getMessage());
        }
    }
    
    public void cargarDatosTramite() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoTramites))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) {
                    String id = datos[0];
                    String estado = datos[1];
                    String comentarios = datos[2];
                    String fechaInicio = datos[3];
                    String idEstudiante = datos[4];
                    String idConvenio = datos[5];

                    Estudiante estudiante = buscarEstudiantePorId(idEstudiante);

                    Convenio convenio = convenios.get(idConvenio);

                    Tramite tramite = new Tramite(id, estado, comentarios, fechaInicio, estudiante, convenio);
                    
                    tramites.put(id, tramite);
                }
            }
            System.out.println("Trámites cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de trámites: " + e.getMessage());
        }
    }
    
    public void guardarTramites() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTramites))) {
            for (Map.Entry<String, Tramite> entry : tramites.entrySet()) {
                Tramite tramite = entry.getValue();

                bw.write(tramite.getId() + "," +
                         tramite.getEstado() + "," +
                         tramite.getComentarios() + "," +
                         tramite.getFechaInicio() + "," +
                         tramite.getEstudiante().getId() + "," + 
                         tramite.getConvenio().getId());         

                bw.newLine(); 
            }
            System.out.println("Trámites guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los trámites: " + e.getMessage());
        }
    }

}
