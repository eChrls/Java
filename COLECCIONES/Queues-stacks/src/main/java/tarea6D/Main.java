/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea6D;

/**
 *
 * @author carlos
 */
public class Main {
    public static void main(String[] args) {
        
        try{
            Estructura<Integer> pilaMain = new Pila<>(5);
            Estructura<String> colaMain = new Cola<>(5);
            
            System.out.println("Pruebas : ");
            pilaMain.añadir(1);
            pilaMain.añadir(2);
            pilaMain.añadir(3);
            pilaMain.añadir(4);
            pilaMain.añadir(5);
            
            colaMain.añadir("A");
            colaMain.añadir("B");
            colaMain.añadir("C");
            colaMain.añadir("D");
            colaMain.añadir("E");
            
            
            
        }catch (EstructuraException e){
            System.out.println(e.obtenerExcepcion());
        }
    }
    
}
