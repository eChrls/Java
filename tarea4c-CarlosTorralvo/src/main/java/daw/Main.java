package daw;

public class Main {

    public static void main(String[] args) {
        //MAIN CON USO DE CONSTRUCTORES
        Cafetera cafetera = new Cafetera();
        cafetera.llenarCafetera();
        cafetera.servirCafe(200);
        System.out.println(cafetera);
        cafetera.vaciarCafetera();
        System.out.println(cafetera);
        cafetera.agregarCafe(500);
        System.out.println(cafetera);
        
            }
}
