/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea6D;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author carlos
 * @param <T>
 */
public class Cola<T> extends Estructura<T> {

    private final Queue<T> cola;
    private final int capacidad;

    public Cola(int capacidad) {
        this.capacidad = capacidad;
        this.cola = new ArrayDeque(capacidad);
        // se puede inicializar vacio, tambien LinkedList(); vacio tambien.
    }

    public Cola() {
        this(5);
    }

    public boolean estaLlena() {
        return cola.size() >= capacidad;
    }

    public int numeroElementosGuardados() {
        return cola.size();
    }

    public int obtenerCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Queue{" + "cola=" + cola + ", capacidad=" + capacidad + '}';
    }

    @Override
    public void añadir(T elemento) throws EstructuraException {
        if (cola.size() >= capacidad) {
            throw new EstructuraException("La cola está llena");
        }
        this.elementos.add(elemento);
    }

    @Override
    public T quitar() throws EstructuraException {
        if (cola.isEmpty()) {
            throw new EstructuraException("La cola está vacia");
        }
        return this.elementos.remove(0);
    }

    // Metodos especificos Queue
    public T primero() throws EstructuraException {
        if (cola.isEmpty()) {
            throw new EstructuraException("La cola está vacía");
        }
        return this.elementos.get(0);
    }

}
