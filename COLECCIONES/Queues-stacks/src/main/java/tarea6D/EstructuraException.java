/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package tarea6D;

/**
 *
 * @author carlos
 */
public class EstructuraException extends Exception {

    /**
     * Creates a new instance of <code>EstructuraException</code> without detail
     * message.
     */
    public EstructuraException() {
    }

    /**
     * Constructs an instance of <code>EstructuraException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EstructuraException(String msg) {
        super(msg);
    }
    
    
    public String obtenerExcepcion(){
        return "Excepción : " + getMessage();
    }
}
