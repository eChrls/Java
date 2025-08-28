/* 
Ejercicio de repaso:
Factorial :
n!= n * (n-1)!
0! = 1
1! = 1
2! = 2 * 1
3! = 3 * 2 * 1
4! = 4 * 3 * 2 * 1
Programa que calcule cualquier factorial

Suma de digitos
Dado un n.o cualquiera obtener la suma de los digitos
Ej: 623 = 6 + 2 + 3 = 11*/
package EjerciciosNavidad;

public class Factorial_Digitos_2 {
        
    public static int calcularFactorial (int n){
        
        int resultado = 1;
        
        if (n == 0){
            resultado = 1;
        }else{
            for (int i = 1; i <= n; i++) {
            resultado *= i;
            }
        }    
        return resultado; 
        }
    
    public static int calcularSumaDigitos (String n){
        int resultado = 0;
        
        for (int i = 0; i < n.length(); i++) {
            char nChar = n.charAt(i);
            String nString = String.valueOf(nChar);
            int nInt = Integer.parseInt(nString);
            resultado += nInt; 
        }
        
    
        return resultado; 
    }
    
    public static boolean esPalindromo (String palabra){
        
        String palabraF = palabra.trim().replaceAll("\\s+" , "");
        
        for (int i = 0; i < palabraF.length()/2; i++) {
            char c1 = palabraF.charAt(i);
            char c2 = palabraF.charAt(palabraF.length()-1-i);
            if (c1 != c2){
                return false; 
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        
        System.out.println(calcularFactorial(5));
        System.out.println(calcularSumaDigitos("172"));
        System.out.println(esPalindromo("ana ana"));
    }
    
}
