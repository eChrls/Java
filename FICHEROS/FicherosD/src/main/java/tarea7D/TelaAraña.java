
package tarea7D;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class TelaAraña {
    
    private int peso; 
    private List<Elefante> elefantes;

    public TelaAraña() {
       this.elefantes=new ArrayList<>();
    }

    public TelaAraña(int peso, List<Elefante> elefantes) {
        this.peso = peso;
        this.elefantes = elefantes;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public List<Elefante> getElefantes() {
        return elefantes;
    }

    public void setElefantes(List<Elefante> elefantes) {
        this.elefantes = elefantes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.peso;
        hash = 71 * hash + Objects.hashCode(this.elefantes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TelaAraña other = (TelaAraña) obj;
        return true;
    }

    @Override
    public String toString() {
        return "TelaAra\u00f1a{" + "peso=" + peso + ", elefantes=" + elefantes + '}';
    }
    

}