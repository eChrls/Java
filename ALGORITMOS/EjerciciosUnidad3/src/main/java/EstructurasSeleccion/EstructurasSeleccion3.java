/*
3. Algoritmo que lea un número entero y muestre si el número es múltiplo de 10.
 */
package EstructurasSeleccion;

public class EstructurasSeleccion3 {
    public static void main(String[] args) {
    //declaramos variable
    int numero = 2;
    //condición con fórmula módulo
    if (numero % 10 == 0){
        System.out.println("El número es múltiplo de 10");
    }else{
        System.out.println("El número no es múltiplo de 10");
    }
    }
}
