/*
 - Lee dos variables int, una usando scanner y otra usando JOption, llamadas num1 y num2. Muestra los valores introducidos por teclado por el usuario.
 - Guarda en una variable booleana diferente para cada apartado el resultado de evaluar las siguientes expresiones, mostrando el resultado por consola.
Antes de comprobar el resultado con el IDE, realiza las operaciones en un papel, elabora la expresión completa usando operadores y ve obteniendo 
el resultado poco a poco teniendo en cuenta la precedencia de operadores. 
Una vez realizado el apartado en papel, programa en el entorno la expresión y comprueba el resultado:
a) num1 es mayor que num2 y num1 menos 10 es menor que num2-1.
b) num1 es par o num2 es par
c) num2 es impar y num1 es par
d) Al resto de dividir num1 entre 3 se le suma 1. Comprobar que el resultado es igual a 3
e) 10 es menor o igual que 2 multiplicado por num1 y 3 es menor que 4 o 8 no es mayor que 7 y num2 multiplicado por 2 es menor o igual que 4 por 2 menos 1
f) el resultado de negar la expresión: num2 es mayor que num1 y dos por num1 menor o igual a num2
g) num2/2<num1 y num1++/2>num2
h) num1 está entre 15 y 20
i) num1 está entre 15 y 20 o num2 es distinto de 7
j) num2 no es 100
k) num2 no está entre 50 y 100*/
package daw;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Expresiones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Lectura del primer número con Scanner
        System.out.println("Introduce un número: ");
        int num1 = sc.nextInt();

        //Lectura del segundo número con JOptionPane
        String num2St = JOptionPane.showInputDialog("Introduce el valor de otro número: ");
        int num2 = Integer.parseInt(num2St);

        //Mostrar valores por consola
        System.out.println("Valor del número 1: " + num1);
        System.out.println("Valor del número 2: " + num2);

        //Expresiones boolean
        //a) num1 es mayor que num2 y num1 menos 10 es menor que num2-1.
        boolean a = (num1 > num2) && ((num1 - 10) < (num2 - 1));
        //b) num1 es par o num2 es par
        boolean b = (num1 % 2 == 0) || (num2 % 2 == 0);
        //c) num2 es impar y num1 es par
        boolean c = (num2 % 2 != 0) && (num1 % 2 == 0);
        //d) Al resto de dividir num1 entre 3 se le suma 1. Comprobar que el resultado es igual a 3
        boolean d = ((num1 % 3) + 1) == 3;
        //e) 10 es menor o igual que 2 multiplicado por num1 
        //y 3 es menor que 4 o 8 no es mayor que 7 y num2 multiplicado por 2 es menor o igual que 4 por 2 menos 1
        boolean e = (10 <= (2 * num1)) && ((3 < 4) || (8 <= 7)) && ((num2 * 2) <= (4 * 2 - 1));
        //f) el resultado de negar la expresión: num2 es mayor que num1 y dos por num1 menor o igual a num2
        boolean f = !(num2 > num1 && (2 * num1) <= num2);
        //g) num2/2<num1 y num1++/2>num2
        boolean g = (num2 / 2 < num1) && (num1++ / 2 > num2);
        //h) num1 está entre 15 y 20
        boolean h = (num1 >= 15) && (num1 <= 20);
        //i) num1 está entre 15 y 20 o num2 es distinto de 7
        boolean i = ((num1 >= 15) && (num1 <= 20)) || (num2 != 7);
        //j) num2 no es 100
        boolean j = num2 != 100;
        //k) num2 no está entre 50 y 100
        boolean k = (num2 < 50) || (num2 > 100);
        //Resultados
        System.out.println("a) " + a);
        System.out.println("b) " + b);
        System.out.println("c) " + c);
        System.out.println("d) " + d);
        System.out.println("e) " + e);
        System.out.println("f) " + f);
        System.out.println("g) " + g);
        System.out.println("h) " + h);
        System.out.println("i) " + i);
        System.out.println("j) " + j);
        System.out.println("k) " + k);
    }
}
