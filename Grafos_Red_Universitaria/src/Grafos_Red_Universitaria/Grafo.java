package Grafos_Red_Universitaria;

import java.util.*; // Importa herramientas como ArrayList, Queue, etc.


public class Grafo {
    
    // Mapa que guarda cada sala de la Universidad y la lista de salas conectadas a ella
    private Map<String, List<String>> conexionesSalas;

    
    // Constructor: crea el grafo vacío
    public Grafo() {
        conexionesSalas = new HashMap<>();
    }

    
    
    // Agrega una sala nueva al grafo
    public void agregarSala(String nombreSala) {
        
        // Solo la agrega si aún no existe
        if (!conexionesSalas.containsKey(nombreSala)) {
            
            // Crea una lista vacía de conexiones para esa sala
            conexionesSalas.put(nombreSala, new ArrayList<>());
        }
        
    }

    
    
    // Crea una conexión (ida y vuelta) entre dos salas
    public void conectarSalas(String salaOrigen, String salaDestino) {
        
        // Verifica que ambas salas existan antes de conectarlas
        if (conexionesSalas.containsKey(salaOrigen) && conexionesSalas.containsKey(salaDestino)) {
            
            // Agrega la conexión en ambas direcciones (ya que el grafo es no dirigido)
            conexionesSalas.get(salaOrigen).add(salaDestino);
            conexionesSalas.get(salaDestino).add(salaOrigen);
        }
    }
    
    

    // Recorre el grafo con el algoritmo BFS (anchura)
    public void recorridoBFS(String salaInicio) {
        
        // Estructuras necesarias para el recorrido
        Queue<String> cola = new LinkedList<>(); // almacena las salas pendientes por visitar
        Set<String> visitadas = new HashSet<>(); // guarda las que ya fueron visitadas

        // Se agrega la sala inicial como punto de partida
        cola.add(salaInicio);
        visitadas.add(salaInicio);

        System.out.println("Recorrido BFS desde " + salaInicio + ":");

        
        
        while (!cola.isEmpty()) {
            
            // Se toma la primera sala de la cola
            String salaActual = cola.poll();
            System.out.print(salaActual + " ");

            
            // Se recorren todas las salas conectadas (vecinas)
            for (String salaVecina : conexionesSalas.get(salaActual)) {
                
                // Si una sala vecina aún no fue visitada, se agrega a la cola
                if (!visitadas.contains(salaVecina)) {
                    
                    cola.add(salaVecina);
                    visitadas.add(salaVecina);
                }
            }
        }
        
        System.out.println(); // salto de línea final
    }

    
    
    // Recorre el grafo con el algoritmo DFS (profundidad)
    public void recorridoDFS(String salaInicio) {
        
        Set<String> visitadas = new HashSet<>();
        
        System.out.println("Recorrido DFS desde " + salaInicio + ":");
        
        // Se llama al método recursivo que hace el recorrido completo
        recorrerDFSRecursivo(salaInicio, visitadas);
        
        System.out.println(); // salto de línea final
    }

    
    
    // Parte recursiva del DFS (se llama a sí misma para seguir explorando)
    private void recorrerDFSRecursivo(String salaActual, Set<String> visitadas) {
        
        // Muestra la sala actual y la marca como visitada
        System.out.print(salaActual + " ");
        visitadas.add(salaActual);

        
        
        // Recorre las salas conectadas a la actual
        for (String salaVecina : conexionesSalas.get(salaActual)) {
            
            // Si la sala vecina aún no fue visitada, entra en ella (llamada recursiva)
            if (!visitadas.contains(salaVecina)) {
                
                recorrerDFSRecursivo(salaVecina, visitadas);
            }
        }
    }
}
