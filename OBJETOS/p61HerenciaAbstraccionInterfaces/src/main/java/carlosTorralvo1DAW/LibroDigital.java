/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carlosTorralvo1DAW;
/**
 *
 * @author carlos
 */
public final class LibroDigital extends Libro implements SeDescarga{

    private int numKBytes;

    public LibroDigital() {
    }


    
    public LibroDigital(int par, String string, String string1, double par1, double par2, String libro_Digital) {
    }

    public LibroDigital(int numKBytes) {
        this.numKBytes = numKBytes;
    }

    public int getNumKBytes() {
        return numKBytes;
    }

    public void setNumKBytes(int numKBytes) {
        this.numKBytes = numKBytes;
    }

    
    
    @Override
    public String toString() {
        return "LibroDigital{" + "numKBytes=" + numKBytes + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.numKBytes;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LibroDigital other = (LibroDigital) obj;
        return this.numKBytes == other.numKBytes;
    }
    
    public void descargar(){
        System.out.println("https://www.carlostorralvo.daw/" + this.hashCode());
    
    }



    
    
    
}
