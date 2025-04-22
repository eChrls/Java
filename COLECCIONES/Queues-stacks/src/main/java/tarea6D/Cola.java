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
public class Cola<T> extends Estructura<T>{
    
    private final Queue<T>cola;
    private final int capacidad;

    public Cola(int capacidad) {
        this.capacidad = capacidad;
        this.cola = new ArrayDeque(capacidad);
        // se puede inicializar vacio, tambien LinkedList(); vacio tambien.
    }
    
    public Cola(){
        this(5);
    }

    
    public void añadirElemento(T e) throws EstructuraException {//add
        
        if(estaLlena()){
            throw new EstructuraException("La cola está llena");
                }
        cola.add(e);
    }

    public T sacar() throws EstructuraException{//remove
           if(cola.isEmpty()){
            throw new EstructuraException("La cola está vacia");
                }
        return cola.remove();
    }


    
    public boolean estaLlena(){
        return cola.size() >= capacidad;
    }

    public int cantidadElementosGuardados(){
        return cola.size();
}
    
    public int obtenerCapacidad(){
        return capacidad;
    }

    @Override
    public String toString() {
        return "Queue{" + "cola=" + cola + ", capacidad=" + capacidad + '}';
    }

    @Override
    public void añadir(T elemento) throws EstructuraException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T quitar() throws EstructuraException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
