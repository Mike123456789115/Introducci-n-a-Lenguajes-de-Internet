
package ParcialArboles;


public class ArbolBinarioBusqueda {
    
    //Clase principal que implementa las operaciones del Árbol Binario de Búsqueda (ABB)
    //para el Ejercicio 1.

    Nodo raiz;

    public ArbolBinarioBusqueda() {
        
        this.raiz = null;
    }

    // INSERTAR LOS NUMEROS 
    
    
    public void insertar(int valor) {
        
        raiz = insertarRecursivo(raiz, valor);
    }

    
    private Nodo insertarRecursivo(Nodo actual, int valor) {
        
        if (actual == null) {
            
            return new Nodo(valor);
        }
        
        

        if (valor < actual.valor) {
            
            
            actual.izquierda = insertarRecursivo(actual.izquierda, valor);
            
        } else if (valor > actual.valor) {
            
            actual.derecha = insertarRecursivo(actual.derecha, valor);
        }
        // No hace nada si el valor es igual 
        return actual;
    }

    // --- REQUISITO 1: RECORRIDO POS-ORDEN ---

    
      //Realiza e imprime el recorrido Pos-Orden (Izquierda -> Derecha -> Raíz).
     
    public void recorridoPosOrden(Nodo nodo) {
        if (nodo != null) {
            recorridoPosOrden(nodo.izquierda);
            recorridoPosOrden(nodo.derecha);
            System.out.print(nodo.valor + " ");
        }
    }

    // --- REQUISITO 2: FUNCIÓN RECURSIVA PARA CONTAR HOJAS ---

    
     //Cuenta el número total de hojas osea los nodos finales que no tienen ningun hijo
     
    public int contarHojas() {
        
        return contarHojasRecursivo(raiz);
    }

    
    private int contarHojasRecursivo(Nodo nodo) {
        
        // Caso base 1: El subárbol es nulo.
        if (nodo == null) {
            
            return 0;
        }

        
        // Caso  2: El nodo es una hoja.
        if (nodo.izquierda == null && nodo.derecha == null) {
            
            return 1;
        }

        //La Recursividad :)
        return contarHojasRecursivo(nodo.izquierda) + contarHojasRecursivo(nodo.derecha);
    
}
    
    private Nodo encontrarMinimo(Nodo nodo) {
        if (nodo.izquierda == null) {
            return nodo;
        }
        return encontrarMinimo(nodo.izquierda);
    }

    
    
    // Función pública para iniciar la eliminación de un valor del ABB.
     
    public void eliminar(int valor) {
        
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo actual, int valor) {
        
        if (actual == null) return null;

        // 1. Búsqueda del nodo.
        if (valor < actual.valor) {
            
            actual.izquierda = eliminarRecursivo(actual.izquierda, valor);
            
        } else if (valor > actual.valor) {
            
            actual.derecha = eliminarRecursivo(actual.derecha, valor);
        } 
        
        
        
        // 2. Eliminación (Nodo encontrado).
        else {
            
            // Caso A: 0 o 1 hijo
            if (actual.izquierda == null) {
                
                return actual.derecha; 
                
            } else if (actual.derecha == null) {
                
                return actual.izquierda; 
            }
            
            

            // Caso B: 2 hijos (reemplazar por el sucesor inorden)
            
            Nodo sucesor = encontrarMinimo(actual.derecha);

            // Copia el valor del sucesor
            actual.valor = sucesor.valor;

            // Elimina el sucesor original
            actual.derecha = eliminarRecursivo(actual.derecha, sucesor.valor);
        }

        return actual;
    }
    
}
