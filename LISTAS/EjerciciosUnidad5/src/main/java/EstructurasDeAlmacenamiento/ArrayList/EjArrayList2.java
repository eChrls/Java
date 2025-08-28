/*
 2.- Escribir un programa que lea del teclado el tamaño de dos arraylist de enteros 
(el mismo tamaño para los dos listas). El programa inicializará los arraylist con números aleatorios 
entre 1 y 100. Existirá un método llamado multiplicar que recibirá los dos arraylist e irá 
multiplicando los elementos dos a dos, empezando por los elementos que ocupan la posición cero, 
luego la uno, etc, guardando el resultado en otro arraylist, que será devuelto por el método. 
Además existirá un método para imprimir por pantalla los valores de los arrays. 
Los métodos puedes estar en la misma clase del main.
 */
package EstructurasDeAlmacenamiento.ArrayList;

import java.util.*;

public class EjArrayList2 {

    public static void main(String[] args) {
    //DECLARAMOS VARIABLES Y OBJETOS RANDOM Y SCANNER
    //MUY IMPORTANTE COMO SE NOMBRAN PARA ENTENDER EL EJERCICIO Y LO QUE SE QUIERE HACER
    //IMPORTANTE DECLARAR LAS LISTAS Y SU TAMAÑO COMO INT
        Scanner sc = new Scanner(System.in);
        Random aleatorio = new Random();
        int tamLista = 0; 
        int aleatorios = 0;
        ArrayList <Integer> lista1 = new ArrayList<>();
        ArrayList <Integer> lista2 = new ArrayList<>();
        //BUCLE DOW PARA PEDIR VALORES VALIDOS + INTRODUCCION DE ALEATORIOS EN LISTAS.
        //EL ; GENERA EN LA SIGUIENTE LINEA NUEVOS RANDOMS PARA QUE NO SE REPITAN
        //USAMOS VARIABLE ALEATORIOS INT, PARA DECARGAR Y LISTA.ADD(VARIABLE ALEATORIOS) PARA ACUMULAR
        do {            
           
        System.out.println("El programa multiplica dos arrays aleatorios del tamaño que indiques. Introduce el tamaño del array: ");
        tamLista = sc.nextInt();
            if (tamLista<=0) {
                System.out.println("Numero introducido incorrecto, vuelve a introducir un numero");                
            }
            for (int i = 0; i < tamLista; i++) {
                aleatorios = aleatorio.nextInt(1, 101);
                lista1.add(aleatorios);
                
                aleatorios = aleatorio.nextInt(1, 101);
                lista2.add(aleatorios);
            }
            
            //RESULTADO TRAS HACER LOS METODOS DE MULTIPLICACION Y MOSTRAR RESULTADO DE LISTAS
            //IMPORTANTE DECLARAR LA LISTA RESULTADO EN EL MAIN Y AÑADIRLE LA FUNCION QUE TIENE QUE DEVOLVER
            ArrayList <Integer> listaResultado = EjArrayList2.multiplicar(lista1, lista2);
            EjArrayList2.imprimirResultado(listaResultado);
            
        } while (tamLista <= 0);
        
        
        
        
        
    }//METODO DE ARRAYLIST NO DE INT. AÑADIMOS ARRAYLIST LISTA 1 Y LISTA 2
    //INICIALIZAMOS DENTRO LA LISTA RESULTADO QUE SERA EL RETORNO
    //INICIALIZAMOS RESULTADO DE LA MULTIPLICACION EN INT PARA QUE DESCARGUE LOS VALORES DE LA OPERACION
    //OJO! LA OPERACION SE OBTIENE CON LISTA.GET(I) * LISTA.GET(I) 
    //LA LISTA RESULTADO ACUMULA LOS VALORES CON .ADD(RESULTADO)
    public static ArrayList <Integer> multiplicar (ArrayList <Integer> lista1, ArrayList <Integer> lista2){
       
        ArrayList <Integer> listaResultado = new ArrayList <>();
        int resultado = 0;
        
        for (int i = 0; i < lista1.size(); i++) {
            resultado = lista1.get(i) * lista2.get(i);    
            listaResultado.add(resultado);
        }
        
        return listaResultado; 
    }
    //METODO IMPRIMIR, NO ME SALIO Y ES UNA TONTERIA, ES SIEMPRE VOID PERO EN EL PARENTESIS HAY QUE 
    //ANADIR EL OBJETO QUE SE QUIERE OBTENER, EN ESTE CASO ES UN SOUT QUE TENGA UNA LISTA DE ARRAYS.
    public static void imprimirResultado(ArrayList <Integer> listaResultado){
        
        System.out.println("El resultado de las listas aleatorias multiplicadas es " + listaResultado);
    }
    
}
