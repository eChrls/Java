/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen.VersionSet;

import Examen.VersionArray.*;

public class Ficha {

    // "Crea una clase llamada Ficha, con dos atributos encapsulados: número (entre 1 y 13) y color (Rojo, Negro, Amarillo y Azul). Usa un Enum para el color. Esta clase tiene dos constantes públicas para indicar el número de ficha mayor y menor."
    public static final int NUMERO_FICHA_MENOR = 1;
    public static final int NUMERO_FICHA_MAYOR = 13;

    private int numero;
    private Color color;

    // "Incluye constructores (por defecto y parametrizado), getters, setters, toString, equals y hashCode."
    public Ficha() {
    }

    public Ficha(int numero, Color color) {
        if (numero < NUMERO_FICHA_MENOR || numero > NUMERO_FICHA_MAYOR) {
            throw new IllegalArgumentException("Número de ficha no válido");
        }
        this.numero = numero;
        this.color = color;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero < NUMERO_FICHA_MENOR || numero > NUMERO_FICHA_MAYOR) {
            throw new IllegalArgumentException("Número de ficha no válido");
        }
        this.numero = numero;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return numero + " " + color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ficha ficha = (Ficha) o;
        return numero == ficha.numero && color == ficha.color;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(numero, color);
    }
}