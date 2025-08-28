
package EstructurasDeAlmacenamiento;

import java.util.Arrays;

public class PasoPorReferencia2 {
    //Paso por referencia, puedo modificar la variable array
    // y se ven los cambios al acabar la funcion
    public static void pasoValor(int[] array){
       
        array [0] = 100;
        
    }
        
    public static void main(String[] args) {
      
        int[] a = {1 , 2 , 3};
        System.out.println(Arrays.toString(a));
        //Invocacion de un metodo pasando por valor el array
        PasoPorReferencia2.pasoValor(a);
        System.out.println(Arrays.toString(a));
        
        
    }
    

    }   
