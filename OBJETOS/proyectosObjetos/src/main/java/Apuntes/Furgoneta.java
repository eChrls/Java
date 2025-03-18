package Apuntes;

public class Furgoneta extends Vehiculo {
    /*
     * Furgoneta hereda atributos y metodos de vehiculo. Pero en herencia NUNCA los
     * constructores.
     */
    private int cargaMaxima;
    

    public Furgoneta(String marca, String modelo, int anioMatriculacion, int cargaMaxima) {
        //La primera linea de código del constructor de la subclase debe ser la llamada al constructor de la superclase
        super(marca, modelo, anioMatriculacion);
        this.cargaMaxima = cargaMaxima;
    }
    
    public Furgoneta() {
        super();
    }

    public int getCargaMaxima() {
        return cargaMaxima;
    }
    
    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }
    //concatenamos el toString de la superclase con el de la subclase
    @Override
    public String toString() {
        return super.toString() + ", Furgoneta [cargaMaxima=" + cargaMaxima + "]";
    }

}
