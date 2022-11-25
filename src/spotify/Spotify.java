/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author arlet
 */
public class Spotify {
    public static void Artistas (String name) {
    File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("C:\\Spotify\\artistas.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            System.out.println(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   }
    public static void InsertarArtista (String name) {
        FileWriter archivo = null;
        PrintWriter pw = null;
        BufferedReader bufer2 = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char respuesta;
        try{
            archivo = new FileWriter("C:\\" + name + ".txt");
            pw = new PrintWriter(archivo);
            do{
                System.out.println("Escribe información a guardar en el archivo: ");
                entrada = bufer2.readLine();
                //Agrega lo leído en teclado al archivo disco
                pw.println(entrada);
                System.out.println("Escribe n para pasar ");
                entrada = bufer2.readLine();
                respuesta = entrada.charAt(0);
            } while ( respuesta != 'n');
        } catch (Exception e){
            System.out.println("Error al escribir en archivo: " + name);
            e.printStackTrace();
        } finally {
            try{
                //Cerrar el archivo si es que se pudo abrir para escritura
                if (null != archivo){
                    archivo.close();
                }
            } catch (Exception e2){
                System.out.println("Error al cerrar archivo" + name);
                e2.printStackTrace();
            }
        }
    }
    public static void eliminarArtista (String name) {
        File archivo = new File("C:\\" + name + ".txt"); 
    if (archivo.delete()) { 
      System.out.println("El artista: " + archivo.getName() + " ha sido eliminado con éxito");
    } else {
      System.out.println("Algo salió mal al eliminar este artista, intenta más tarde");
    } 
  } 
    
    public static void main (String[] args) throws IOException {
        BufferedReader buferTeclado = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        String fileName;
        int opcion;
        
        System.out.println("SPOTIFY");
        System.out.println("Buenas tardes!");
        System.out.println("--------------------------------------");
        System.out.println("1 - Ver artistas");
        System.out.println("2 - Insertar artista");
        System.out.println("3 - Eliminar artista");
        System.out.println("4 - Agregar albúm");
        System.out.println("5 - Ver albúm");
        System.out.println("6 - Agregar canción");
        System.out.println("7 - Ver canción");
        System.out.println("¿Qué quieres hacer? ");
        entrada = buferTeclado.readLine();
        opcion = Integer.parseInt(entrada);
        entrada = buferTeclado.readLine();
        fileName = entrada;
   
        switch(opcion){
            case 1: {
                //Leer de un archivo de texto
                System.out.println("Estos son los artistas que te gustan: ");
                Artistas(fileName);
            }
            break;
            case 2: {
                System.out.println("Creación de un archivo de texto");
                InsertarArtista(fileName);
            }
            break;
        case 3: {
                eliminarArtista(fileName);      
        }
        
}
        
}    
       
         
    }
    

