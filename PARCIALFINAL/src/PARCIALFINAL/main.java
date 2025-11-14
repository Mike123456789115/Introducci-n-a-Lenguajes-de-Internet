package PARCIALFINAL;

import java.util.Scanner;

public class main {
    
    public static void main(String[] args) {
        
        Scanner jh = new Scanner(System.in);
        metodos met = new metodos(); // Aquí se carga automáticamente el archivo CSV
        int opcion;
        
        do {
            System.out.println("=== MENÚ ESTUDIANTES ===");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Mostrar estudiantes");
            System.out.println("4. Buscar estudiante");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            while (!jh.hasNextInt()) {
                System.out.print("Por favor ingrese un número válido: ");
                jh.next();
            }
            
            opcion = jh.nextInt();
            jh.nextLine();
            
            switch(opcion) {
                case 1:
                    met.agregarEstudiante();
                    break;
                case 2:
                    met.eliminarEstudiante();
                    break;
                case 3:
                    met.mostrarEstudiantes();
                    break;
                case 4:
                    met.buscarEstudiante();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.\n");
            }
        } while(opcion != 5);
    }
}