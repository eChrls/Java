package clasegenerica.excepciones;

// Esta clase representa una excepción personalizada que se lanza cuando
// se intenta manipular una pila.
// La clase hereda de Exception, lo que significa que es una excepción

public class PilaException extends Exception {
    // Constructor de la excepción
    // Se puede usar el constructor de la clase padre Exception
    // para crear la excepción con un mensaje específico.
    // Este mensaje se puede mostrar al usuario para indicar el error. 
    public PilaException (String mensaje) {
        super(mensaje);
    }

    public String obtenerMensajeError() {
        return "Error: " + getMessage();
    }
}

