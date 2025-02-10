
package tema5_ejercicios_estructuras_almacenamiento;

public class Ej04 {

  
    public static void main(String[] args) {
        
        
        int[] array= new int[50];
        
        for (int i = 0; i < array.length; i++) {
            
            array[i]=utilidades.Utilidades.numeroEnteroRandom(1, 50);
            
        }
        
        for (int i = 0; i < array.length; i++) {
            
            if (i < array.length - 1) {

                System.out.print("[" + array[i] + "]" + "-");
            } else {
                System.out.print("[" + array[i] + "]");
            }
        }
        
        int numero=utilidades.Utilidades.numeroEnteroRandom(1, 10);;
        System.out.println("");
        
        for (int i = 0; i < array.length; i++) {
            
            if(array[i]==numero){
            
                System.out.println("El numero "+numero+" se encuentra en la posicion "+i+" del array");
                break;
            }
        }
       
    }
    
}
