package Grafos_Red_Universitaria;

public class main {

    public static void main(String[] args) {
        
        // Se crea el objeto grafo (representa el piso o red de salas) Bacicamente el objeto
        Grafo piso13 = new Grafo();

        
        
        
        //Agregar las salas del piso
        
        piso13.agregarSala("Pasillo Principal");
        piso13.agregarSala("Laboratorio 1301");
        piso13.agregarSala("Laboratorio 1302");
        piso13.agregarSala("Baño Mujeres");
        piso13.agregarSala("Baño Hombres");
        piso13.agregarSala("Sala de Profesores");
        piso13.agregarSala("Ascensor");
        piso13.agregarSala("Escaleras de Emergencia");

        
        
      
        //Conectar las salas entre si
        
        
        piso13.conectarSalas("Pasillo Principal", "Laboratorio 1301");
        piso13.conectarSalas("Pasillo Principal", "Laboratorio 1302");
        piso13.conectarSalas("Pasillo Principal", "Baño Mujeres");
        piso13.conectarSalas("Baño Mujeres", "Baño Hombres");
        piso13.conectarSalas("Laboratorio 1302", "Sala de Profesores");
        piso13.conectarSalas("Pasillo Principal", "Ascensor");
        piso13.conectarSalas("Ascensor", "Escaleras de Emergencia");

        
        
       
        // Recorrido del Grafo
        
        // Se muestra el orden en que se visitan las salas
        
        System.out.println(" ===== RECORRIDOS EN EL GRAFO ===== ");

        piso13.recorridoBFS("Pasillo Principal");  // recorrido en anchura
        System.out.println();
        piso13.recorridoDFS("Pasillo Principal");  // recorrido en profundidad

        System.out.println();
    }
}
