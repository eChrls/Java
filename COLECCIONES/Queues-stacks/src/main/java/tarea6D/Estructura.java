/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package tarea6D;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author carlos
 * @param <T>
 */
public abstract class Estructura<T> {

    protected final List<T> elementos;
    protected final int capacidad;

    public Estructura(int capacidad) {
        this.elementos = new ArrayList<>(capacidad);
        this.capacidad = capacidad;
    }

    public Estructura() {
        this(5);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estructura<?> other = (Estructura<?>) obj;
        if (this.capacidad != other.capacidad) {
            return false;
        }
        return Objects.equals(this.elementos, other.elementos);
    }

    public abstract void añadir(T elemento) throws EstructuraException;

    public abstract T quitar() throws EstructuraException;

    public abstract boolean estaLlena();

    public abstract int numeroElementosGuardados();


    public int obtenerCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Estructura{" + "elementos=" + elementos + ", capacidad=" + capacidad + '}';
    }

}
