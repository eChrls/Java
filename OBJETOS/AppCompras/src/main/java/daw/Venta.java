package daw;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {

    //Variables
    private int idVenta;
    private Cliente cliente;
    private LocalDate fechaVenta;
    private ArrayList<DetalleVenta> detalles;
    private double precioTotal;
    private static int contadorId = 101;

    //constructor
    public Venta(Cliente cliente) {
        this.idVenta = contadorId++;
        this.cliente = cliente;
        this.fechaVenta = LocalDate.now();
        this.detalles = new ArrayList<>();
        this.precioTotal = 0;

    }
    //funcion para agregar control de stock y sumar pvp total 
    public boolean agregarDetalle(DetalleVenta detalle) {
        
        Producto producto = detalle.getProducto();
        int cantidad = detalle.getCantidad();
        //verifica si hay suficiente stock
        if (producto.getStock() >= cantidad){
            producto.reducirStock(cantidad); //reduce el stock
            detalles.add(detalle); //recibe UN detalle 
            precioTotal += detalle.getPvpTotalArticulo(); //actualiza hasta el precio total
            return true;
        }
        return false;
    }
    
        
    public String generarTicket() {
        StringBuilder ticket = new StringBuilder();

        //Cabecera
        ticket.append("===PANADERIA MAR DE ALBORAN===\n");
        ticket.append("Fecha: ").append(fechaVenta).append("\n");
        ticket.append("Nº de ticket: ").append(idVenta).append("\n\n");

        //cliente
        ticket.append("Cliente: ").append(cliente.getNombre()).append(" ").append(cliente.getApellidos()).append("\n");
        ticket.append("NIF: ").append(cliente.getNif()).append("\n\n");

        //productos
        ticket.append("===PRODUCTOS===\n");
        ticket.append("--------------------\n");
        for (DetalleVenta detalle : detalles) {
            ticket.append(detalle.getProducto().getNombre())
                    .append(" x").append(detalle.getCantidad())
                    .append(" ").append(String.format("%.2f", detalle.getPvpTotalArticulo())).append("€\n");
        }

        //total con iva
        ticket.append("--------------------\n");
        ticket.append("Subtotal: ").append(String.format("%.2f", precioTotal)).append("€\n");
        ticket.append("IVA (21%): ").append(String.format("%.2f", precioTotal * 0.21)).append("€\n");
        ticket.append("TOTAL: ").append(String.format("%.2f", precioTotal * 1.21)).append("€\n");

        return ticket.toString();
    }

    @Override
    public String toString() {
        return "Venta nº =  " + idVenta + " , IDcliente =  " + cliente.getIdCliente() + "  Nif =  " + cliente.getNif()   + detalles.toString() + "  Total =  " + precioTotal;
    }
    
    

}
