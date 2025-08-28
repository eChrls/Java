/*16. Fábricas “El cometa” produce artículos con claves (1, 2, 3, 4, 5 y 6). 
Se requiere un programa para calcular los precios de venta, a partir del costo de la 
materia prima y la clave del producto. Para esto hay que considerar lo siguiente:
Costo de producción = costo materia prima + costo mano de obra + gastos de fabricación.
    Precio de venta = costo de producción + 35 % de costo de producción.
El costo de la mano de obra se obtiene de la siguiente forma: para los productos 
con clave 3 o 4 se carga 75 % del costo de la materia prima; para los que tienen 
clave 1 y 5 se carga 80 %, y para los que tienen clave 2 o 6, 85 %.
Para calcular el gasto de fabricación se considera que si el artículo que se 
va a producir tiene claves 2 o 5, este gasto representa 30 % sobre el costo de 
la materia prima; si las claves son 3 o 6, representa 35 %; si las claves son 1 o 4, 
representa 28 %. La materia prima tiene el mismo costo para cualquier clave. */
package EstructurasSeleccion;
import java.util.Scanner;
public class EstructuraSeleccion16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Solicitamos el coste de la materia prima
        System.out.print("Introduce el coste de la materia prima: ");
        double costeMateriaPrima = sc.nextDouble();
        // Solicitamos la clave del producto
        System.out.print("Introduce la clave del producto (1-6): ");
        int claveProducto = sc.nextInt();
        //1º Condicion (IF-ELSE IF) dependiendo de la clave
        //Calculamos el coste de la mano de obra según la clave del producto
        //Inicializamos coste de mano de obra
        double costeManoObra = 0;
        if (claveProducto == 3 || claveProducto == 4) {
            costeManoObra = costeMateriaPrima * 0.75;
        } else if (claveProducto == 1 || claveProducto == 5) {
            costeManoObra = costeMateriaPrima * 0.80;
        } else if (claveProducto == 2 || claveProducto == 6) {
            costeManoObra = costeMateriaPrima * 0.85;
        //ELSE para descartar inputs que no correspondan a los pedidos del 1 al 6    
        } else {
            System.out.println("Clave de producto no válida.");
        }
        // Calcular los gastos de fabricación según la clave del producto
        //Inicializamos gastosFabricación y repetimos condición IF-ELSE IF
        double gastosFabricacion = 0;
        if (claveProducto == 2 || claveProducto == 5) {
            gastosFabricacion = costeMateriaPrima * 0.30;
        } else if (claveProducto == 3 || claveProducto == 6) {
            gastosFabricacion = costeMateriaPrima * 0.35;
        } else if (claveProducto == 1 || claveProducto == 4) {
            gastosFabricacion = costeMateriaPrima * 0.28;
        }
        // Calcular el coste de producción
        double costeProduccion = costeMateriaPrima + costeManoObra + gastosFabricacion;
        // Calcular el precio de venta
        double precioVenta = costeProduccion + (costeProduccion * 0.35);
        // Mostrar los resultados
        System.out.printf("Costo de producción: %.2f€\n", costeProduccion);
        System.out.printf("Precio de venta: %.2f€\n", precioVenta);
    }
}    

