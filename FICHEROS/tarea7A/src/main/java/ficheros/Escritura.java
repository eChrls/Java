/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author carlos
 */
public class Escritura {
        public static <T> void escribirCsv(String nombre, List<T> datos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombre))) {

            for (T dato : datos) {
                bw.write(dato.toString());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void escribirCsv(String nombre, T fichero) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombre))) {

            bw.write(fichero.toString());
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
