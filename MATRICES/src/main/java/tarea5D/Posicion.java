package tarea5D;

/*Clase reciclable con posicion y metodos para los ejercicios de la tarea 5D*/
public class Posicion {

    public int fila;
    public int columna;

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public static boolean existeEnMatriz(int[][] matriz, int fila, int columna) {
        return fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz[0].length;
    }

}
