
package daw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {


    
    public static void main(String[] args) {
       
        List<Producto> productos = new ArrayList<Producto>();

        Producto p1 = new Producto(1, "Producto 1", 10.0, 10);
        Producto p2 = new Producto(2, "Producto 2", 20.0, 20);
        Producto p3 = new Producto(3, "Producto 3", 30.0, 30);
        Producto p4 = new Producto(2, "Producto 2", 20.0, 20);
        Producto p5 = new Producto(5, "Producto 5", 50.0, 50);


        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);


        System.out.println("Prod 1 y prod 2 iguales???" + p1.equals(p2));

        System.out.println("hashCode de p1: " + p1.hashCode());
        System.out.println("hashCode de p2: " + p2.hashCode()); 


        System.out.println("Prod 2 y Prod 4 son iguales???" + p2.equals(p4));


        for(Producto p : productos){
            System.out.println(p);
        }       
        //es lo mismo que arriba -> inferencia de tipos (expresion lambda, con flecha)
        //puedes usar instancias con p al mostrar.
        productos.forEach(p->System.out.println(p));

        //es lo mismo que arriba -> inferencia de tipos (expresion lambda, con doble dos puntos)
        //no puedes cambiar el p, solo puedes mostrar el objeto completo.
        productos.forEach(System.out::println);

        //lo mismo usado para sacar el iva. 
        productos.forEach(p->extracted(p));
                productos.forEach(System.out::println);
        
        
                //Explicacion metodo compareTo
                // 0 -> si son iguales
                // 1 -> si el primero es mayor que el segundo 
                //-1 -> si el primero es menor que el segundo
                //siempre se compara el primero con el segundo.
                Integer n1 = 2;
                Integer n2 = 4;
        
                System.out.println(n1.compareTo(n2)); // -1
        
        
                String a = "abc";
                String b = "def";
        
                System.out.println(a.compareTo(b)); // -3
        
                System.out.println(p1.compareTo(p3)); // -1
                System.out.println(p1.compareTo(p1)); // 0
                System.out.println(p3.compareTo(p1)); // 1
        
                //Ordenar la lista de productos
                Collections.sort(productos); 
                //Clase collections, metodo sort, ordena la lista ascendente acorde al orden natural (interfaz comparable, por id)
                //para usarlo en clase Producto se debe implementar la interfaz comparable. public class Producto implements Comparable<Producto> {
                productos.forEach(System.out::println);
                
                //metodo 2
                productos.sort((p, o) -> p.compareTo(o));
        
        
                // Collections.sort(lista, new CriterioPrecio());
                
                // System.out.println(lista);
        
        
        
                
        
        
        
        
        
        
            }

        
            private static void extracted(Producto p) {
                p.setPrecio(p.getPrecio()*1.21);
            }























}
