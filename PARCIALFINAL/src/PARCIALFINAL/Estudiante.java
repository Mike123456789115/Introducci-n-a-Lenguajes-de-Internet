package PARCIALFINAL;


public class Estudiante {
    
    //Atributos 
    
    String nombre;
    int codigo;
    double promedio;
    
    
    //METODO CONSTRUCTOR
    public Estudiante (String nombre , int codigo , double promedio){
        
        this.nombre = nombre;
        this.codigo = codigo;
        this.promedio = promedio;
    }
    
    
    //Metodos get
    
    public String getnombre(){
        
        return nombre;
        
    }
    
    
    public int getcodigo(){
        
        return codigo;
    }
    
    
    public double getpromedio(){
        
        return promedio;
    }
    
    
    @Override
    public String toString() {
        return nombre + " (Código: " + codigo + ", Promedio: " + promedio + ")";
    }
}