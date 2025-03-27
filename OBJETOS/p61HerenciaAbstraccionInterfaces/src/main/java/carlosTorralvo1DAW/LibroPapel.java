/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carlosTorralvo1DAW;

/**
 *
 * @author carlos
 */
public class LibroPapel extends Libro implements SeEnvia{

    private int numPaginas;
    
    
    
    

    public LibroPapel(int par, String string, String string1, double par1, double par2, String libro_de_papel) {
    }


    public LibroPapel(int numPaginas, String isbn, int codigo, Double precio, int iva, String descripcion) {
        super(isbn, codigo, precio, iva, descripcion);
        this.numPaginas = numPaginas;
    }

    
    
    
    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.numPaginas;
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
        final LibroPapel other = (LibroPapel) obj;
        return this.numPaginas == other.numPaginas;
    }


    public void enviar(String direccion){
        
        System.out.println("Libro id = " + this.getCodigo() + " - se envia a la direccion " + direccion);
    }

    
    
    
    
    
    
    
    
    
    
    


    
}
