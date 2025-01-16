/*10. Crear un algoritmo para calcular el salario semanal de unos empleados a los que se les 
paga 15 euros por hora si éstas no superan las 35 horas. Cada hora por encima de 35 se 
considerará extra y se paga a 22 €. El programa pide las horas del trabajador y devuelve el 
salario que se le debe pagar. Modifica el algoritmo anterior para que pregunte si deseamos 
calcular otro salario, si  escribimos “s” el programa se vuelve a repetir, en otro caso termina. 
Además si el usuario se equivoca e introduce un número de horas negativas, el programa automáticamente 
las considerará horas positivas.*/
package EstructurasRepetitivas;
import java.util.*;
public class EstRepetitivas10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        //Establecemos variables, inicializamos las que van a entrar en fórmula directamente. 
        int horas;
        int salario = 0;
        int salario35 = 35*15;
        int horas35 = 35;
        //bucle DO para descartar que se introduzcan horas no correctas
        do{
            System.out.println("Introduce las horas trabajadas");
            horas = sc.nextInt();
            if (horas < 1 || horas > 48){
            System.out.println("Horas introducidas no válidas.");
            }
        //bucle WHILE + fórmulas para calcular los salarios.     
        }while (horas < 1 || horas > 48);{
            if (horas <= 35 ){
            salario = horas * 15;
            }else {
            int diferencia = horas - horas35;     
            salario = diferencia * 22 + salario35;
            }
            System.out.println("El salario calculado es = " + salario + " €.");
        }
     }    
}
