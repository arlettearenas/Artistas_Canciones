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
    public static void mostrarArtista(String artista) {
        
    }
    public static void leerArchivo(String name) {
    File archivo = null; //Apunta a un archivo fisico del dd
    FileReader fr = null;
    BufferedReader bufer = null;
    try {
        //creamos un apuntador al archivo físico
        archivo = new File("C:\\" + name + ".txt");
        //abrimos el archivo para lectura
        fr = new FileReader(archivo);
        //configurar bufer para hacer la lectura
        bufer = new BufferedReader(fr);
        
        
        //Lectura del contenido del archivo
        String linea;
        //mientras haya información en el archivo
        while ((linea = bufer.readLine()) != null)
            System.out.println("Línea del archivo: " + linea);
            
    } catch(Exception e){
        System.out.println("Error: No se encuentra el archivo");
        e.printStackTrace();
    }finally {
        //Esta cláusula se ejecuta siempre
        //Se cierra el archivo
        try {
            //si se logró abrir el archivo, debemos cerrarlo
            if(null != fr){
                fr.close();
            }
        } catch(Exception e2){
            System.out.println("Error al cerrar el archivo");
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

    public static void main(String[] args) throws IOException {
        BufferedReader buferTeclado = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        String fileName;
        int opcion;
        
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
        System.out.println("Escribe el nombre del archivo");
        entrada = buferTeclado.readLine();
        fileName = entrada;
        
        switch(opcion){
            case 1: {
                //Leer de un archivo de texto
                System.out.println("Lectura de un archivo existente");
                System.out.println("Contenido del archivo: ");
                leerArchivo(entrada);
            }
            break;
            case 2: {
                System.out.println("Creación de un archivo de texto");
                InsertarArtista(fileName);
            }
            break;
            default: System.out.println("Opción no válida");
            
        }
        
        
        
        
        
         
    }
    
}

