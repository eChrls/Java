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
        if (cpostal.length() != 5) {
            this.cpostal = "00000";
        } else {
            this.cpostal = cpostal;
        }
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

}
