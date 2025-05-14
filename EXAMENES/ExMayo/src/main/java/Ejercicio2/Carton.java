package Ejercicio2;
// Representación de una casilla del cartón
public class Carton {
    private int fila;
    private int columna;
    private int valor;

    public Carton() {}

    public Carton(int fila, int columna, int valor) {
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public int getValor() {
        return valor;
    }
}


