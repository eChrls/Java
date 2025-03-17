
package tarea5D;

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
    
    
}
