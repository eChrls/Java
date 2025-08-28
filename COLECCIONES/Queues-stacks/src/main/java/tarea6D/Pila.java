/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea6D;

import java.util.Stack;

/**
 *
 * @author carlos
 * @param <T>
 */
public class Pila<T> extends Estructura<T>{

    private final Stack<T> pila;
    private final int capacidad;

    public Pila(int capacidad) throws EstructuraException {
        if (capacidad <= 0) {
            throw new EstructuraException("La capacidad debe ser mayor que 0");
        }
        this.pila = new Stack<>();//se inicializa vacio
        this.capacidad = capacidad;
    }

//    //meter
//    public void push(T elemento) throws EstructuraException {
//        if (pila.size() >= capacidad) {
//            throw new EstructuraException("Pila llena");
//        }
//        pila.push(elemento);
//    }

    //Quitar
//    public T pop() throws EstructuraException {
//        if (pila.isEmpty()) {
//            throw new EstructuraException("Pila vacia");
//        }
//        return pila.pop();
//    }


    public int obtenerCapacidad() {
        return capacidad;
    }

    public int numeroElementosGuardados() {
        return pila.size();
    }

    @Override
    public void añadir(T elemento) throws EstructuraException {
        if (pila.size() >= capacidad) {
            throw new EstructuraException("Pila llena");
        }
        pila.push(elemento);
    }

    @Override
    public T quitar() throws EstructuraException {
        if (pila.isEmpty()) {
            throw new EstructuraException("Pila vacia");
        }
        return pila.pop();
    }

    @Override
    public boolean estaLlena() {
        return pila.size() >= capacidad;
    }


    // Método específico de Pila
    public T peek() throws EstructuraException {
        if (pila.isEmpty()) {
            throw new EstructuraException("Pila vacía");
        }
        return this.elementos.get(this.elementos.size() - 1);
    }


}
