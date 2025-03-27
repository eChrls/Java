/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carlosTorralvo1DAW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author carlos
 */
public abstract class Producto {

    private int codigo;
    private double precio;
    private int iva;
    private String descripcion;

    public Producto(int codigo, Double precio, int iva, String descripcion) {
        this.codigo = codigo;
        this.precio = precio;
        this.iva = iva;
        this.descripcion = descripcion;
    }

    public Producto() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", precio=" + precio + ", iva=" + iva + ", descripcion=" + descripcion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + Objects.hashCode(this.precio);
        hash = 29 * hash + this.iva;
        hash = 29 * hash + Objects.hashCode(this.descripcion);
        return hash;
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
        final Producto other = (Producto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.iva != other.iva) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return Objects.equals(this.precio, other.precio);
    }

    public Producto busquedaBinariaPorCodigo(ArrayList<Producto> listaProductos, int codigoBuscado) {
        Collections.sort(listaProductos, Comparator.comparingInt(Producto::getCodigo)); // ordenar por nº codigo
        int inicio = 0;
        int fin = listaProductos.size() - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2; //evita el desbordamiento
            Producto productoMedio = listaProductos.get(medio);
            int codigoMedio = productoMedio.getCodigo();

            if (codigoMedio == codigoBuscado) {
                return productoMedio; //se filtra por la mitad y se controla si aparece en esa posicion
            } else if (codigoMedio < codigoBuscado) {
                inicio = medio + 1; // si es mas grande busca en la mitad derecha
            } else {
                fin = medio - 1; //sino busca en la mitad izquierda
            }
        }
        return null; //sino se encuentra
    }

}

