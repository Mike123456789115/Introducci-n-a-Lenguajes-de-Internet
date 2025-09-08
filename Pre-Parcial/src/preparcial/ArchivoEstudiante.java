
package preparcial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.Scanner;


public class ArchivoEstudiante {
    
    //Metodo para verificar si el Archivo Existe  1.a
    public void verificarExistencia() {
    
    File archivo1 = new File ("estudiantes.txt");//Aqui llamamos a file que es una de las clase De la Biblioteca de java como Scanner o Array sirve para que si el archivo estudiantes.txt esta en la carpeta raiz del proyecto con file podamos acceder a el y modificasrlo
    
    
    if (archivo1.exists()) {    //Esto archivo1.exist pregunta o verifica si el archivo existe "Archivo existe?       
        
        System.out.println(" El Archivo Si Existe ");
        
     }else{
    
    System.out.println(" El Archivo No Existe ");
    
}
    
 }
    
    
    //Metodo en caso de que el archivo estudiantes.txt no exista y se tengan que crear los 3 registros  1.b
    public void CrearArchivoSiNoExiste(){
        
        File archivo1 = new File ("estudiantes.txt");
        
        if (!archivo1.exists()) {
            
            
            try {      //Intenta Hacer Lo siguiente
                
                FileWriter FWCreaArchivoXD = new FileWriter(archivo1);//Crea el archivo en caso de que no exista y FWcreaArchivoXD es el nombre de que le quise poner a FileWriter no se esta chistoso
                
                BufferedWriter BWLine = new BufferedWriter(FWCreaArchivoXD);//Esto nos permite escribir en el Archivo Creado Lineas de texto y saltos de lineas // este le puse de nombre BWLine
                
                //Escribimos los 3 Registros Iniciales
                
                
                BWLine.write("Ana,21,89");
                BWLine.newLine();//Esto nos da un salto de linea
                
                
                BWLine.write("Luis,23,92");
                BWLine.newLine();
                
                
                BWLine.write("Marta,20,95");
                BWLine.newLine();
                
                System.out.println("Archivo Creado y Registros Creados Exitosamente");
                
            }catch (IOException Errorcito){//catch es si algo sale mal haz esto y IOException eses el tipo de error que se captura y Errorcito es el nombre que le puse
                
                System.out.println(" Error al crear el Archivo o Escribir el Archivo el try fallo " + Errorcito.getMessage());
            }
            
        }else{
            
            System.out.println(" El Archivo ya Existe no se necesita Crear Porque ya Existe ");
        }
    }
    
    
    
    
    //Metodo para que se lea y muestre todo el contenido del Archivo (Acceso Secuencial)  1.c
    
   public void leerArchivo() {
       
        File archivo1 = new File("estudiantes.txt"); //Es nesesario llamar A File Archivo1 estudiantes.txt porque cada metodo tiene su propio espacio de trabajo
                                                     //En java cada variable solo existe dentro de su propio metodo  por eso se declara de nuevo

        if (archivo1.exists()) { 
            
            try {
                
                FileReader Leo = new FileReader(archivo1); // Abre el Archivo para que pueda ser leido por BufferedReader
                
                BufferedReader LeoLineas = new BufferedReader(Leo); // Nos permite leer línea por línea

                
                String linea; // Variable para guardar cada línea que el Archivo lea , en esta variable se guarda el contenido de la linea actual que fue leida
                
                while ((linea = LeoLineas.readLine()) != null) { //BufferedLeoLineas empieza en la linea 0 un que no existe por eso es necesario usar LeoLineas.readLine porque salta a la primera linea de texto y en cada repeticion read.Line salta a la siguiente
                    
                    System.out.println(linea); // Imprime cada línea en la consola
                }

                
            } catch (IOException Errormini) {//catch es si algo sale mal haz esto y IOException eses el tipo de error que se captura o nos puede salir y Errorcito es el nombre que le puse
                System.out.println(" Error al leer el archivo " + Errormini.getMessage());
            }
            
        } else {
            System.out.println(" El archivo no existe ");

        }
   }
   
   
   //Metodo para Que el usuario elija una linea y se le muestre solo la linea que el eligio(Acceso Directo)  2
   
   public void MostrarLineaEscogida(){
       
       Scanner jh = new Scanner (System.in);
       
       System.out.println(" Digite el numero de la linea que quiere seleccionar ");
       
       int NumeroLinea=jh.nextInt();
       
       
       File archivo1 = new File ("estudiantes.txt");//Recordar que para cada metodo debemos usar file para acceder al archivo txt
       
       if (archivo1.exists()) {
           
           try{
               
              FileReader AbrirAchiv = new FileReader(archivo1); // Abre el Archivo para que pueda ser leido por BufferedReader
                
              BufferedReader LeerLinea = new BufferedReader(AbrirAchiv); //Lee Linea Por line Recuerda
              
              
              String LineaActual;//LineaActual es la variable que guarda el contenido de la linea actual
              
              int Contador=0;//Contador de la linea actual es la variable que se encarga de mostrar la linea actual
              
              
              while ((LineaActual = LeerLinea.readLine()) != null) {//Mientras que linea elegida sea = A la linea Actual y su contenido o no sea nula se repite el bucle
                  
                  Contador = Contador + 1;//En cada Repeticion del bucle Cambiamos de linea Contador refleja este cambio
                    
                    if (Contador == NumeroLinea) {//NumeroLinea es la que el usuario escogio y si es igual a contador significa que el numero de linea actual es el mismo que escogio el usuario por locual se imprime la linea
                        
                        System.out.println(" Linea Numero " + NumeroLinea + " " + LineaActual); 
                  }     
                           
                }
              
               if (NumeroLinea > Contador) {//Si el Archivo tiene solo 5 Lineas y el usuario digita un numero que sobrepasa esa cantidad Pues Se le menciona e informa que el txt no tiene tantas lineas
                   System.out.println(" El archivo no cuentas con Tantas Lineas ");
                   
               }
              
           }catch (IOException ERR) {
                System.out.println(" Error al leer el archivo " + ERR.getMessage());
            }
           
       }else{
           
           System.out.println(" Lo Sentimos el Archivo No Existe Perdon ");              
       }
       
   }
       
   
       //Metodo  Para Contar la Cantidad de Estudiantes con nota mayor o igual a 90    4
       
   
   
         public int contarEstudiantesNotasAltas() {
             
        File archivo1 = new File("estudiantes.txt");
        
        
       if (!archivo1.exists()) {
           
           
        System.out.println("El archivo no existe");
        return 0;
    }

    try {
        BufferedReader br = new BufferedReader(new FileReader(archivo1));
        
        
        return contarRecursivo(br, 0);
        
        
        
    } catch (IOException e) {
        
        System.out.println("Error al leer el archivo: " + e.getMessage());
        return 0;
    }
}
         
         

// Método privado que hace la recursión línea por línea
         
         
   private int contarRecursivo(BufferedReader br, int contador) throws IOException {
       
       
      String linea = br.readLine();
      
      
    if (linea == null) { // Caso base: fin del archivo
        
        return contador;
        
        
    } else {
        
        String[] datos = linea.split(","); // Separa esto Nombre,Edad,Nota
        
        
        int nota = Integer.parseInt(datos[2]);
        
        if (nota >= 90) {
            contador++;
        }
        return contarRecursivo(br, contador); // Llamada recursiva a la siguiente línea
    }
}
  
  }
   
    



