/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqueteB;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaLoteria {
    // Usamos HashMap ya que no necesitamos ordenar las claves
    // HashMap proporciona acceso más rápido a los elementos
    private Map<String, Double> decimos;
    
    // Constructor que inicializa el sistema
    public SistemaLoteria() {
        decimos = new HashMap<>();
    }
    
    // Método para registrar un décimo con su premio
    public void registrarDecimo(String numeroDecimo, double premio) {
        // Aseguramos que el número del décimo tenga el formato correcto (5 dígitos)
        numeroDecimo = formatearNumeroDecimo(numeroDecimo);
        // Guardamos el décimo con su premio asociado
        decimos.put(numeroDecimo, premio);
    }
    
    // Método para formatear el número del décimo (añade ceros a la izquierda)
    private String formatearNumeroDecimo(String numeroDecimo) {
        // Añadimos ceros a la izquierda si es necesario para tener 5 dígitos
        while (numeroDecimo.length() < 5) {
            numeroDecimo = "0" + numeroDecimo;
        }
        return numeroDecimo;
    }
    
    // Método para consultar el premio de un décimo
    public Double consultarPremio(String numeroDecimo) {
        // Formateamos el número del décimo antes de consultar
        numeroDecimo = formatearNumeroDecimo(numeroDecimo);
        // Devolvemos el premio asociado al décimo o null si no existe
        return decimos.get(numeroDecimo);
    }
    
    // Método para generar décimos aleatorios con premios
    public void generarDecimosAleatorios(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            // Generamos un número aleatorio entre 0 y 99999
            int numero = (int) (Math.random() * 100000);
            // Convertimos el número a String y lo formateamos
            String numeroDecimo = formatearNumeroDecimo(String.valueOf(numero));
            // Generamos un premio aleatorio entre 0 y 1000000
            double premio = Math.random() * 1000000;
            // Registramos el décimo con su premio
            decimos.put(numeroDecimo, premio);
        }
    }
    
    // Método para contar cuántos décimos hay registrados
    public int contarDecimos() {
        // El método size() devuelve el número de entradas en el Map
        return decimos.size();
    }
}
