
package ficheros;


public record Vehiculo(String marca, String modelo, int año, String vin, String color, String matricula) {
    @Override
    public String toString() {
        return marca + "," + modelo + "," + año + "," + vin + "," + color + "," + matricula; //sobreescribo toString para facilitar la escritura en CSV
    }
}
