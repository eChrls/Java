/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.p62academiajctm;

/**
 *
 * @author carlos
 */
public class Direccion {

    private String calleNumero;
    private String cpostal;
    private String poblacion;

    public Direccion() {

    }

    public Direccion(String calleNumero, String cpostal, String poblacion) {
        this.calleNumero = calleNumero;
        if (cpostal.length() != 5) {
            this.cpostal = "00000";
        } else {
            this.cpostal = cpostal;
        }
        this.poblacion = poblacion;
    }

    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Direccion{" + "calleNumero=" + calleNumero + ", cpostal=" + cpostal + ", poblacion=" + poblacion + '}';
    }

}
