

package Ordenacion;


public class Burbuja {

    public static void main(String[] args) {
        int var = 0; 
        Integer[]array = {6 , 5 , 4 , 3 , 1 , 2};
        //Burbuja
            System.out.print("Array desordenado = [  ");
            for(int num : array){
            System.out.print(num + "  ");
            }
            System.out.println("] ");
            
        //usamos la i para recorrer el array la j para comparar valores
        for (int i = 0; i < array.length - 1 ; i++) {
            for (int j = 0; j < array.length -1; j++) {
                if (array[j] > array[j+1]){ // 6 > 5
                    var = array [j]; // var = 6
                    array[j] = array[ j + 1]; // [ 5 , 5, 4 , 3 ....]
                    array[j + 1] = var; // [ 5 , 6 , 4,  3.....]
                }
            }
        }   
            System.out.print("Array ordenado = [  ");
            for(int num : array){
            System.out.print(num + "  ");
        }
            System.out.print("] ");
    }
}
