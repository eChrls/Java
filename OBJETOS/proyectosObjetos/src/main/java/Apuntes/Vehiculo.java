package Apuntes;

public class Vehiculo {
    
    private String marca;
    private String modelo;
    private int anioMatriculacion;

    

    public Vehiculo(String marca, String modelo, int anioMatriculacion) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioMatriculacion = anioMatriculacion;
    }

    public Vehiculo() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioMatriculacion() {
        return anioMatriculacion;
    }

    public void setAnioMatriculacion(int anioMatriculacion) {
        this.anioMatriculacion = anioMatriculacion;
    }

    @Override
    public String toString() {
        return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", anioMatriculacion=" + anioMatriculacion + "]";
    }

    


}
