/*16. Una cadena de tiendas de autoservicio cuenta con sucursales en C ciudades diferentes del país, en cada ciudad cuenta con 
T tiendas y cada tienda cuenta con N empleados, asimismo, cada una registra lo que vende de manera individual cada empleado, cuánto fue 
lo que vendió cada tienda, cuánto se vendió en cada ciudad y cuánto recaudó la cadena en un solo día. Realiza un algoritmo que permita 
introducir en un día, lo que vendió cada empleado de cada tienda de cada ciudad y saber las ventas totales por tienda, por ciudad y totales.*/
package EstructurasRepetitivas;
import java.util.*;
public class EstRepetitivas16 {
    public static void main(String[] args) {
        //hacemos el ejercicio con 1 ciudad, 2 tiendas, 3 trabajadores por tienda. 
        Scanner s = new Scanner(System.in);
        
        final int ciudades = 2;
        final int tiendas = 2; 
        final int trabajadores = 2; 
        //inicializamos todas las variables vamos a usar
        int cuentaTiendas = 0, cuentaEmpleados = 0, cuentaCiudades = 0, importeTotal = 0, importeEmpleados = 0, importeTiendas = 0, importeCiudades = 0, importeTotalEmpleados = 0, importeTotalTiendas = 0, importeTotalCiudades = 0;
        //estructura triple bucle for, para ciudades, tiendas y empleados
        for(int i = 0; i <ciudades; i++){
            importeCiudades = 0;
            System.out.println("Ciudad numero   " + (i + 1) + "\n");
                for(int j = 0; j < tiendas ; j++){
                    importeTiendas = 0;
                    System.out.println("Tienda numero " + (j + 1) + "\n");
                        for (int k = 0; k < trabajadores; k++){
                            importeEmpleados = 0;
                            System.out.println("Introduce las ventas del empleado: ");
                            importeEmpleados = s.nextInt();
                            importeTotalEmpleados += importeEmpleados;
            }
            //acumulamos importe tiendas con las ventas de los empleados totales
            importeTiendas = importeTotalEmpleados;
        
            System.out.println("Las ventas de la tienda " + (j + 1) + ":" + importeTiendas + "\n");
            //acumulamos el importe total de tiendas para la ciudad
            importeTotalTiendas += importeTiendas;
        
    }
            importeCiudades = importeTotalTiendas;
            System.out.println("La ganancia de la ciudad " + (i + 1) + ":" + importeCiudades + "\n");
            //acumulamos el importe total de las ciudades para saber la cifra final
            importeTotalCiudades += importeCiudades;
    }
            importeTotal = importeTotalEmpleados + importeTotalTiendas + importeTotalCiudades;
            System.out.println("Las ventas totales de la compañía son:  " + importeTotal + "€");
    }
}
