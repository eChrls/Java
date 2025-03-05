
package EstructurasDeAlmacenamiento.ArrayList;
import java.util.*;
public class ListaArrays {
    
    public static void main(String[] args) {
        //la capacidad () del array list es estimada, no es el length.
        ArrayList<Integer> lista = new ArrayList<>(10);
        
        for (int i = 0; i <  lista.size(); i++) {
            lista.add(2);   
        }
        Integer entero = 3; 
        lista.remove(3); //Borra el indice 3. INT INDEX
        lista.remove(entero);//Borra el elemento 3 si esta en la lista.OBJETO 
        System.out.println("lista.size = " + lista.size());     
        

    }//lista.size = 0, el parentesis del array list te guarda el espacio pero no lo crea.    
   
}

