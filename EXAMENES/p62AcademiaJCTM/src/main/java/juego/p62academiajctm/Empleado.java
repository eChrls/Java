
package juego.p62academiajctm;

/**
 *
 * @author carlos
 */
public abstract class Empleado extends Persona{
    private String numeroSeguridadSocial;
    private double salarioBase;

    public Empleado() {
    }

    public Empleado(String numeroSeguridadSocial, double salarioBase, String nombre, String apellidos, String nif) {
        super(nombre, apellidos, nif);
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.salarioBase = salarioBase;
    }

    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    
    
    
    
    public abstract double calcularIRPF();
    
}
