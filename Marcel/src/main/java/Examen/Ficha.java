/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen;

public class Ficha {

    // Constantes para el número de ficha mayor y menor
    public static final int NUMERO_FICHA_MENOR = 1;
    public static final int NUMERO_FICHA_MAYOR = 13;

    // Atributos encapsulados
    private int numero;
    private Color color;

    // Constructor por defecto
    public Ficha() {
    }

    // Constructor parametrizado
    public Ficha(int numero, Color color) {
        // Validación del número de ficha
        if (numero < NUMERO_FICHA_MENOR || numero > NUMERO_FICHA_MAYOR) {
            throw new IllegalArgumentException("Número de ficha no válido");
        }
        this.numero = numero;
        this.color = color;
    }

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        // Validación del número de ficha
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

    // Método toString()
    @Override
    public String toString() {
        return numero + " " + color;
    }

    // Métodos equals() y hashCode()
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