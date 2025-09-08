
package preparcial;


public class Main {
    
    public static void main(String [] args){
        
        ArchivoEstudiante gestor = new ArchivoEstudiante();
        
        gestor.verificarExistencia();    //llamamos al metodo del mismo nombre y segun el caso se ejecuta el if o el else
        gestor.CrearArchivoSiNoExiste();
        gestor.leerArchivo();
        gestor.MostrarLineaEscogida();
        
        int cantidad = gestor.contarEstudiantesNotasAltas();
        
        System.out.println(" La Cantidad de Estudiantes con Nota >= 90 " + cantidad);
        
    }
    
}
