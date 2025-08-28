/*3.- Implementa un programa que guarde en un array 10 
números enteros que se leen por teclado. A continuación 
se recorre el array y calcula el número total de 
positivos, de negativos y de ceros. Calcula y muestra 
la media aritmética de los valores positivos y la de los 
valores negativos del array. Implementar métodos para:

    Leer valores por teclado y almacenarlos en el array. 
Se le pasará el array como parámetro y no devolverá nada.
    Contar positivos, se le pasará el array como 
parámetro y devolverá el número de positivos almacenados en el array.
    Contar negativos, se le pasará el array como parámetro 
y devolverá el número de negativos almacenados en el array.
    Contar ceros, se le pasará el array como parámetro y
devolverá el número de ceros almacenados en el array.
    Mostrar array, se le pasará el array como parámetro 
y no devolverá nada, sólo imprimirá por pantalla el array.
    Calcular media positivos, se le pasará el array como
parámetro y no devolverá nada, sólo imprimirá por pantalla 
la media aritmética de los positivos.
    Calcular media negativos, se le pasará el array como 
parámetro y no devolverá nada, sólo imprimirá por pantalla 
la media aritmética de los negativos.
 */
package EstructurasDeAlmacenamiento;

import java.util.Scanner;

public class EjercicioArrays3 {
    
    // Método para leer valores y almacenarlos en el array
    //original = public static void leerArray() {
    public static void leerArray(int[] numeros) {
        Scanner s = new Scanner(System.in);
        
        // Original: el método no recibía el array como parámetro y, por lo tanto, 
        //no podía almacenar los valores ingresados en el array principal.
        // for (int i = 0; i < numeros.length - 1; i++) {
        //     valores = s.nextInt();
        //     numeros[i] = valores;
        // }

        // Corrección: Ahora recibe el array como parámetro y 
        //almacena correctamente cada número ingresado.
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Introduce un número: ");
            numeros[i] = s.nextInt();
        }
    }

    // Método para contar positivos 
    //Original   public static int contarPositivos(int totalP) {
    public static int contarPositivos(int[] numeros) {
        int totalP = 0; // Inicializamos el contador
        
        // Original: se creaba un nuevo array vacío y la condición terminaba con ";", lo cual evitaba que contara los valores positivos.      
        // Corrección: Ahora, recorremos el array recibido como parámetro y contamos correctamente los valores positivos.
        for (int i = 0; i < numeros.length; i++) {
            /* if (valores > 0);
            totalP = +i;*/            
            if (numeros[i] > 0) { // Verificamos si el número es positivo
                totalP++; // Incrementamos el contador
            }
        }
        return totalP;
    }

    // Método para contar negativos
    public static int contarNegativos(int[] numeros) {
        int totalN = 0;

        // Original: se creaba un array vacío y no contaba negativos correctamente. 
        // if (valores < 0);
        // totalN = +i;

        // Corrección: Ahora, recorremos el array recibido como parámetro y contamos correctamente los valores negativos.
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] < 0) {
                totalN++;
            }
        }
        return totalN;
    }

    // Método para contar ceros
    public static int contarCeros(int[] numeros) {
        int totalC = 0;

        // Original: se creaba un array vacío y no contaba ceros correctamente.
        // if (valores == 0);
        // totalC = +i;

        // Corrección: Ahora, recorremos el array recibido como parámetro y contamos correctamente los ceros.
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == 0) {
                totalC++;
            }
        }
        return totalC;
    }

    // Método para mostrar el array
    public static void mostrarArray(int[] numeros) {
        // Original: se creaba un array vacío --public static void mostrarArray() {--, 
        //por lo que nunca se mostraban los valores ingresados.
        // int[] numeros;
        // numeros = new int[10];

        // Corrección: Ahora se recibe el array como parámetro y se muestran los valores correctamente.
        System.out.print("El array es: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
    }

    // Método para calcular y mostrar la media de los positivos
    public static void mediaP(int[] numeros) {
        int sumaP = 0;
        int contadorP = 0;
        
        // Original: el método creaba un array vacío --public static void mediaP() {--
        //y no calculaba la media correctamente, sumando el índice en lugar de los valores positivos.
        // valores = +i;
        // mediaP = valores / numeros.length;
        
        // Corrección: Sumamos los valores positivos y dividimos por la cantidad de positivos, si existen.
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > 0) {
                sumaP += numeros[i];
                contadorP++;
            }
        }
        
        if (contadorP > 0) {
            double mediaP = (double) sumaP / contadorP;
            System.out.printf("La media de los positivos es: %.2f%n", mediaP);
        } else {
            System.out.println("No hay números positivos en el array.");
        }
    }

    // Método para calcular y mostrar la media de los negativos
    public static void mediaN(int[] numeros) {
        int sumaN = 0;
        int contadorN = 0;
        
        // Original: el método creaba un array vacío y no calculaba la media correctamente, sumando el índice en lugar de los valores negativos.
        // valores = +i;
        // mediaN = valores / numeros.length;
        
        // Corrección: Sumamos los valores negativos y dividimos por la cantidad de negativos, si existen.
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] < 0) {
                sumaN += numeros[i];
                contadorN++;
            }
        }
        
        
        if (contadorN > 0) {
            double mediaN = (double) sumaN / contadorN;
            System.out.printf("La media de los negativos es: %.2f%n", mediaN);
        } else {
            System.out.println("No hay números negativos en el array.");
        }
    }

    public static void main(String[] args) {
        int[] numeros = new int[10];
        
        System.out.println("Bienvenido al programa de cálculos en el array");

        // Original: se llamaba al método leerArray() sin pasar el array, lo que resultaba en un error.
        // leerArray();
        
        // Corrección: Llamamos al método leerArray() y le pasamos el array 
        //'numeros' como argumento para almacenar los valores correctamente.
        leerArray(numeros);
        
        // Mostramos el array ingresado
        mostrarArray(numeros);
        
        // Mostramos los resultados de los conteos
        System.out.println("Cantidad de positivos: " + contarPositivos(numeros));
        System.out.println("Cantidad de negativos: " + contarNegativos(numeros));
        System.out.println("Cantidad de ceros: " + contarCeros(numeros));
        
        // Calculamos y mostramos las medias
        mediaP(numeros);
        mediaN(numeros);
    }
}
//VERSION CLASE:
//ArrayList<Integer> lista = new ArrayList<>(20);
//        
//        System.out.println(lista.size());
//        
//        // ArrayList<int> lista = new ArrayList<>(); Esto no 
//        
//        llenarLista(lista, 20);
//        
//        System.out.println(contPosLista(lista));
//        System.out.println(contNegLista(lista));
//        System.out.println(cerLista(lista));
//        mostrarLista(lista);
//        mostrarMediaPos(lista);
//        mostrarMediaNeg(lista);
//
//        
//    }
//
//    public static int scN() {
//
//        Scanner sc = new Scanner(System.in);
//
//        int num;
//        do {
//
//            try {
//
//                num = sc.nextInt();
//                return num;
//
//            } catch (InputMismatchException ime) {
//
//                System.out.println("Valor invalido, por favor introduce un numero entero");
//                sc.nextLine();
//            }
//
//        } while (true);
//    }
//
//    public static void llenarLista(ArrayList<Integer> lista, int numElementos) {
//
//        int num;
//
//        for (int i = 0; i < numElementos; i++) {
//
//            System.out.println("Introduce un numero");
//            num = scN();
//            lista.add(num);
//
//        }
//    }
//
//    public static int contPosLista(ArrayList<Integer> lista) {
//
//        
//        int cantPos = 0;
//        
//        
//        for (int i = 0; i < lista.size(); i++) {
//            
//            if (lista.get(i) > 0) {
//                
//                cantPos ++;
//                
//                
//            }
//        }
//
//        return (cantPos);
//    }
//    
//    public static int contNegLista(ArrayList<Integer> lista) {
//
//        
//        int cantNeg = 0;
//        
//        
//        for (int i = 0; i < lista.size(); i++) {
//            
//            if (lista.get(i) < 0) {
//                
//                cantNeg ++;
//                
//                
//            }
//        }
//
//        return (cantNeg);
//    }
//    
//    public static int cerLista(ArrayList<Integer> lista) {
//
//        
//        int cantCer = 0;
//        
//        
//        for (int i = 0; i < lista.size(); i++) {
//            
//            if (lista.get(i) == 0) {
//                
//                cantCer ++;
//                
//            }
//        }
//
//        return cantCer;
//    }
//    
//    public static void mostrarLista(ArrayList<Integer> lista){
//    
//        System.out.println(lista);
//    
//    }
//    
//    public static void mostrarMediaPos (ArrayList<Integer> lista){
//        
//        int totPos = 0;
//        int cantPos = 0;
//        
//        
//        for (int i = 0; i < lista.size(); i++) {
//            
//            if (lista.get(i) > 0) {
//                
//                cantPos ++;
//                totPos += lista.get(i);
//                
//            }
//        }
//
//        System.out.println("la media de los posivos en la lista es : " + (double)totPos / cantPos);
//        
//    }
//    
//    public static void mostrarMediaNeg(ArrayList<Integer> lista){
//        
//        int totNeg = 0;
//        int cantNeg = 0;
//        
//        
//        for (int i = 0; i < lista.size(); i++) {
//            
//            if (lista.get(i) < 0) {
//                
//                cantNeg ++;
//                totNeg += lista.get(i);
//                
//            }
//        }
//
//        System.out.println("la media de los posivos en la lista es : " + (double)totNeg / cantNeg);
//        
//        
//    }
//    
//}
