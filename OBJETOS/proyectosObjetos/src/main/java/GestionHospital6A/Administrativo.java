/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionHospital6A;

import java.time.LocalDate;

/**
 *
 * @author Casa
 */
public class Administrativo extends Empleado{
    private Grupo grupo;
    private int numRegistros;

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public int getNumRegistros() {
        return numRegistros;
    }

    public void setNumRegistros(int numRegistros) {
        this.numRegistros = numRegistros;
    }

    public Administrativo(Grupo grupo, int numRegistros, double salario, LocalDate fechaCont, String nombreCompleto, NIF nif, LocalDate fechaNac) {
        super(salario, fechaCont, nombreCompleto, nif, fechaNac);
        this.grupo = grupo;
        this.numRegistros = 0;
    }
    
    
    public void registrarDoc(String tipoDocumento){
        /*Este metodo simula el registro de un documento por parte de un administrativo
        Incrementa el contador de registros realizados y muestra un mensaje informativo*/
        
        numRegistros++;
        System.out.println("El administrativo " + this.nombreCompleto + " ha registrado un documento de tipo " + 
                tipoDocumento + ". Total de registros = " + numRegistros + " .");
        
    }
    
    @Override
    public double calcularIRPF() {
        return salario * grupo.getPorcentajeIRPF();
    }

    @Override
    public String toString() {
        return "Administrativo{" + super.toString()+ "grupo=" + grupo + ", numRegistros=" + numRegistros + '}';
    }
    
    
}
