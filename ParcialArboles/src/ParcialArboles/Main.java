
package ParcialArboles;


public class Main {
    
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        int[] valores = {48, 18, 78, 8, 28, 58, 8848, 18, 78, 8, 28, 58, 88};

        // Insertar valores y Recorrido Pos-Orden inicial
        System.out.println(" PARTE 1 Y RECORRIDO INICIAL ");
        
        
        for (int valor : valores) {
            
            arbol.insertar(valor);
        }
        
        
        System.out.println("Valores únicos insertados: 48, 18, 78, 8, 28, 58, 8848, 88."); // 8848 es el valor más grande.

        System.out.print("1. Recorrido Pos-Orden inicial: ");
        arbol.recorridoPosOrden(arbol.raiz);
        System.out.println("\n");

        
        // PARTE 2: Contar las Hojas 
        
        System.out.println(" CONTAR HOJAS ");
        System.out.println("2. Número de hojas encontradas: " + arbol.contarHojas());
        System.out.println();
        
        
         //PARTE 3: Insertar 33 y Recorrido Pos-Orden actualizado 
         
        System.out.println(" PARTE 3 INSERTAR 33 ");
        System.out.println("Insertando el valor 33...");
        arbol.insertar(33); // Se inserta como hijo derecho de 28.

        
        System.out.print("3. Recorrido Pos-Orden actualizado: ");
        arbol.recorridoPosOrden(arbol.raiz);
        System.out.println();
        
        
        
        //Ejercicio 2
        System.out.println("\n--- EJERCICIO 2: ELIMINACIÓN DE NODO 78 ---");
        System.out.println("4. Eliminando nodo con valor 78...");
        
        // **LLAMADA A LA FUNCIÓN DE ELIMINACIÓN**
        arbol.eliminar(78); 

        // 5. Mostrar el recorrido final después de la eliminación
        System.out.print("5. Recorrido Pos-Orden (Árbol Final): ");
        arbol.recorridoPosOrden(arbol.raiz);
        System.out.println();
    }
    
}
