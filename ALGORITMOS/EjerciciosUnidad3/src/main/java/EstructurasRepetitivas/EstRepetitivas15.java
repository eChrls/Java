/*15. Una persona adquirió un producto para pagar en 20 meses. El primer mes pagó 10 euros, el segundo 20, el tercero 40 y así sucesivamente. 
Realiza un algoritmo para determinar cuánto debe pagar mensualmente y el total de lo que pagó después de los 20 meses.*/
package EstructurasRepetitivas;


public class EstRepetitivas15 {

    public static void main(String[] args) {
        
        int valorProducto = 5;
        int acumulacion = 0;
        
        for(int i = 1; i < 21 ; i++){
            
            valorProducto = valorProducto * 2;
            acumulacion += valorProducto;
        }System.out.printf("El valor del producto despues de los 20 meses es %d €", acumulacion);
            
        
    }
    
}
