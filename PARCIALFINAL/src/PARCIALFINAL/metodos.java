package PARCIALFINAL;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class metodos {
    
    Scanner jh = new Scanner(System.in);
    ArrayList<Estudiante> lista = new ArrayList<>();
    
    
    // Constructor: carga los datos del archivo CSV
    public metodos() {
        cargarDesdeArchivo();
    }
    
    
    
    // Método para leer el archivo CSV
    private void cargarDesdeArchivo() {
        
        try (BufferedReader br = new BufferedReader(new FileReader("parcial_estudiantes.csv"))) {
            
            String linea;

            // *** NUEVO: leer y saltar la primera línea si es encabezado ***
            linea = br.readLine(); 
            if (linea != null && linea.toLowerCase().contains("codigo")) {
                // Es la fila de encabezados → NO la procesamos
            } else {
                // Si NO es encabezado, procesarla normalmente
                procesarLinea(linea);
            }

            
            
            // Leer el resto del archivo
            while ((linea = br.readLine()) != null) {
                procesarLinea(linea);
            }

            System.out.println("Datos cargados correctamente desde el archivo.\n");
        
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo CSV.\n");
        }
    }

    
    
    
    //  método auxiliar para evitar duplicar código
    private void procesarLinea(String linea) {
        if (linea == null) return;

        String[] datos = linea.split(",");

        if (datos.length == 3) {

            try {
                String nombre = datos[0].trim();
                int codigo = Integer.parseInt(datos[1].trim());
                double promedio = Double.parseDouble(datos[2].trim());

                lista.add(new Estudiante(nombre, codigo, promedio));

            } catch (NumberFormatException e) {
                // Evita que el programa explote si encuentra algo extraño
            }
        }
    }

    
    
    
    
    
    // Método para agregar estudiante
    public void agregarEstudiante(){
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = jh.nextLine();
        
        System.out.print("Ingrese el código del estudiante: ");
        int codigo = jh.nextInt();
        
        System.out.print("Ingrese el promedio del estudiante: ");
        double promedio = jh.nextDouble();
        jh.nextLine(); 
        
        Estudiante e = new Estudiante(nombre, codigo, promedio);
        lista.add(e);
        
        System.out.println("Estudiante agregado correctamente.\n");
    }

    
    
    
    
    
    
    
    // Método para eliminar estudiante
    public void eliminarEstudiante(){
        
        System.out.print("Ingrese el código del estudiante a eliminar: ");
        int codigo = jh.nextInt();
        jh.nextLine();
        
        boolean encontrado = false;
        
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).getcodigo() == codigo){
                lista.remove(i);
                encontrado = true;
                System.out.println("Estudiante eliminado con éxito.\n");
                break;
            }
        }
        
        if (!encontrado){
            System.out.println("No se encontró un estudiante con ese código.\n");
        }
    }

    
    
    
    
    
    // Método para mostrar estudiantes
    public void mostrarEstudiantes(){
        if (lista.isEmpty()){
            System.out.println("No hay estudiantes registrados.\n");
        } else {
            System.out.println("=== LISTA DE ESTUDIANTES ===");
            for (Estudiante e : lista){
                System.out.println(e.toString());
            }
            System.out.println();
        }
    }

    
    
    
    
    // Método para buscar estudiante
    public void buscarEstudiante(){
        System.out.print("Ingrese el código del estudiante a buscar: ");
        int codigo = jh.nextInt();
        jh.nextLine();

        boolean encontrado = false;
        for (Estudiante e : lista){
            if (e.getcodigo() == codigo){
                System.out.println("Estudiante encontrado: " + e.toString());
                encontrado = true;
                break;
            }
        }

        if (!encontrado){
            System.out.println("No se encontró un estudiante con ese código");
        }
    }
}
