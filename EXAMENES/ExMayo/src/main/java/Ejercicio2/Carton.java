
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author carlos
 */
public class Carton {
    private int fila;
    private int columna;
    private int valor;

    public Carton() {
    }

    public Carton(int fila, int columna, int valor) {
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
    }

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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Carton{" + "fila=" + fila + ", columna=" + columna + ", valor=" + valor + '}';
    }
    
    
      public static List<Carton> leerJson() throws IOException {
        String ruta="./cartonbingo.json";
         ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(ruta), new TypeReference<List<Carton>>() {});
          
}
}
