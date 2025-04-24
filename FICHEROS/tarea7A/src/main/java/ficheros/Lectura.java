/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class Lectura {
    
    
//       public static List<Vehiculo> leerCsv(String nombre) throws IOException {
//        List<Vehiculo>vehiculos = new ArrayList<>();
//        FileInputStream fis;
//        Vehiculo tmp; 
//        try{
//            fis = new FileInputStream (nombre);
//            try(ObjectInputStream flujo = new ObjectInputStream(fis)){
//                //devuelve el numero estimado de bytes, si llega a 0 es que ha terminado
//                while(fis.available()>0){
//                }   
//            }catch(IOException e){
//                System.out.println("Error en lectura" + e.getMessage());
//            }
//        }catch (FileNotFoundException ex){
//            System.out.println("El fichero a leer no existe" + ex.getMessage());
//        }

//       public static List<Vehiculo> leerCsv(String nombre)  {
//        try (Scanner sc = new Scanner(new File(nombre))) {//scanner de new file
//            boolean primeraLinea = true;
//            while (sc.hasNextLine()) {   //iteracion
//                String linea = sc.nextLine().trim(); //elimina los espacios
//                Vehiculo vehiculo = new Vehiculo(nombre, nombre, nombre, nombre, nombre, nombre);
//             if(primeraLinea){
//                 primeraLinea = false;
//                 continue;
//                }
//             String[] datos = linea.split(separador);//divide la linea por cada separador
//             String marca = datos[0];//añadimos los datos en cada posicion
//             String modelo = datos[1];
//             String year = datos[2];
//             String vin= datos[3];
//             String color=  datos[4];
//             String licencia= datos[5];     
//            }   
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException("Archivo no encontrado" + nombre, e);
//        }
//        return vehiculos;
//    }
}
