/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package proyectosobjetos.B;

/**
 *
 * @author Casa
 */
public enum TipoVuelo {
    TURISTA(1.00),
    BUSINESS(1.50),
    PREMIUM(2.00);

  private double precioClase;

    public double getPrecioClase() {
        return precioClase;
    }

    public void setPrecioClase(double precioClase) {
        this.precioClase = precioClase;
    }

    private TipoVuelo(double precioClase) {
        this.precioClase = precioClase;
    }


  
    
    
    
}
