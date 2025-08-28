package tarea7D;



public record Elefante(String nombre, int peso) {

    public Elefante(String nombre, int peso) {
        this.nombre = nombre;
        this.peso = Math.abs(peso);
    }

    public int getPesoPositivo(){
        return Math.abs(this.peso);
    }
    
    public String getNombre(){
        return this.nombre;
    }
}
