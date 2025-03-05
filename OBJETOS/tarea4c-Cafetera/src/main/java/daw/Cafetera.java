package daw;

public class Cafetera {

    // Atributos privados para la capacidad máxima y la cantidad actual de café en la cafetera
    private final int capacidadMaxima; // Capacidad máxima de la cafetera (en mililitros)
    private int cantidadActual = 0;     // Cantidad actual de café en la cafetera (inicia en 0)

    // Constructor sin parámetros: inicializa la cafetera con la capacidad máxima y vacía
    public Cafetera() {
        this.capacidadMaxima = 1000; // Inicializa la capacidad máxima a 1000 ml
        this.cantidadActual = 0;    // Inicializa la cantidad actual de café a 0
    }

    public Cafetera(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadActual = capacidadMaxima;
    }

    public Cafetera(int capacidadMaxima, int cantidadActual) {
        this.capacidadMaxima = capacidadMaxima;
        if (capacidadMaxima < cantidadActual) {
            this.cantidadActual = capacidadMaxima;
        } else {
            this.cantidadActual = cantidadActual;
        }
    }

    @Override
    public String toString() {
        return "Cafetera{" + "capacidadMaxima=" + capacidadMaxima + ", cantidadActual=" + cantidadActual + '}';
    }

    // Método para llenar completamente la cafetera
    public void llenarCafetera() {
        this.cantidadActual = this.capacidadMaxima; // Llena la cafetera al máximo
    }

    // Método para servir una cantidad específica de café
    // Reduce la cantidad actual de café en la cafetera según la cantidad solicitada
    public void servirCafe(int cantidad) {
        if (cantidad >= cantidadActual) { //Controlamos que no se sirva mas de lo que tiene la cafetera
            this.cantidadActual = 0;
        }else if (cantidad < 0){ //controlamos para que si la cantidad es negativa no haga nada
           
        } else {
            this.cantidadActual -= cantidad; // Resta la cantidad de café servida de la cantidad actual
        }
    }

    // Método para vaciar completamente la cafetera
    public void vaciarCafetera() {
        this.cantidadActual = 0; // Establece la cantidad actual de café en 0
    }

    // Método para agregar una cantidad específica de café a la cafetera
    public void agregarCafe(int cantidad) {
        if ((cantidad + cantidadActual) > capacidadMaxima) {//controlamos que no se llene mas que la capacidad
            this.cantidadActual = capacidadMaxima; 
        }else if (cantidad < 0){//controlamos para que si la cantidad es negativa no haga nada
           
        }else{
            this.cantidadActual += cantidad; // Suma la cantidad agregada a la cantidad actual
        }
    }

    // Método que devuelve la cantidad actual de café en la cafetera
    public int getCantidadActual() {
        return this.cantidadActual; // Retorna el valor de la cantidad actual
    }

    // Método que devuelve la capacidad máxima de la cafetera
    public int getCapacidadMaxima() {
        return this.capacidadMaxima; // Retorna el valor de la capacidad máxima
    }

//    // Método para establecer un nuevo valor para la cantidad actual de café
//    public void setCantidadActual(int cantidadActual) {
//        this.cantidadActual = cantidadActual; // Actualiza la cantidad actual con el valor proporcionado
//    }

//    // Método para establecer una nueva capacidad máxima para la cafetera
//    public void setCapacidadMaxima(int capacidadMaxima) {
//        this.capacidadMaxima = capacidadMaxima; // Actualiza la capacidad máxima con el valor proporcionado
//    }

}
