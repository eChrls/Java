
package EstructurasDeAlmacenamiento.ArrayList;

import java.util.*;

public class ListaArrays2 {
    
    public static void main(String[] args) {
        
        Integer [] numeros = {1, 2, 3, 4, 5};
        
        //importar java util.
        //recuerda que el 100 no significa su tamaño solo la reserva, sino pones nada sera 10.
        //dentro de los diamantes van objetos
        ArrayList<Integer> lista = new ArrayList<>(100);
        System.out.println("Tamaño lista arriba " + lista.size());// 0
        lista.add(1);
        lista.add(2);
        System.out.println("Tamaño lista abajo " + lista.size());// 2
        //imprimir una lista segun la linea siguiente solo funciona
        //con clases envolventes ( numeros / boolean) y string. 
        System.out.println(lista);// [1, 2]
        
        //Para pasar un array a lista hay que hacer un casting.
        //La lista tiene como hijos la clase arraylist, linkedlist, etc.
        //una clase tipo hijo lo puede instanciar como un padre. 
        List<Integer> lista2 = (ArrayList)Arrays.asList(numeros);
        System.out.println(lista2);//1, 2, 3, 4, 5
        
        
        lista.add(5);
        System.out.println(lista);//1 , 2 , 5
        //Remove 
        lista.remove(0);
        System.out.println(lista);//2 , 5
        
        
        //SABER SI UN ELEMENTO ESTA
        // lista.contains = boolean
        System.out.println(lista.contains(5));//true
        
        
        //POSICION DE ELEMENTOS:
        //lista.get obtener posicion
        System.out.println(lista.get(1));//5
        
        //lista.indexOf te dice el indice del objeto, sino esta pondra -1
        System.out.println(lista.indexOf(5));//2
        
        //OJO cuidado con las posiciones de los indices
        //System.out.println(lista.get(10));
        
        //lista.set -- machaca la posicion
        lista.set(2, 100);//en la posicion 2 hay un 100
        System.out.println(lista);
        
        List<Integer> sublista = lista.subList(2 , 6);// coge del indice 2 al 6
        System.out.println(sublista);//100, 23, 13, 52
        
        lista = listaAleatoria(50);
        lista = listaAleatoriaDiferentes(10);
        System.out.println(lista);
    }
    //Lista de numeros aleatorios entre 5 y 67
    public static ArrayList<Integer> listaAleatoria (int tam){
        Random ran = new Random();
        ArrayList<Integer> lista = new ArrayList (tam);
        
        for (int i = 0; i < tam; i++) {
            lista.add(ran.nextInt(5, 68));
        }

        return lista;
    }//tam viene de listaAleatoria de arriba que vale 50
    
    //metodo aleatorios diferentes
    public static ArrayList<Integer> listaAleatoriaDiferentes (int tam){
        Random ran = new Random();
        ArrayList<Integer> lista = new ArrayList (tam);
        Integer aleatorio = 0;
        int longitud = 0;
        
        //si usas for puede hacer las iteraciones y repetir valores, entonces no los cogería
        // tendrias i iteraciones para menos numeros
        while(longitud < tam) {
            aleatorio = ran.nextInt(5,68);
            if (!lista.contains(aleatorio)){
            lista.add(aleatorio);
            longitud++;
            }
        }
        return lista;
    }//tam viene de listaAleatoria de arriba que vale 50
    
}
