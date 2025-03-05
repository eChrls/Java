


package daw;

/**
 *
 * @author carlos
 */
public class Producto implements Comparable<Producto> {
    private int id; 
    private String nombre; 
    private double precio;
    private int stock; 
    
    public Producto (int id, String nombre, double precio, int stock){
    
        this.id = id; 
        this.nombre = nombre; 
        this.precio = precio; 
        this.stock = stock;     

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.id != other.id){
            return false;
        }
        return true;
    }   

    //Si dos objetos son iguales dara el mismo hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 97 * hash + this.stock;
        return hash;
    }


    @Override
    public int compareTo(Producto o) {
        
        /*if (this.id == o.id){
            return 0;
        }
        if (this.id > o.id){
            return 1;
        }
        return -1;*/
        //Lo mismo que arriba
        return this.id - o.id;
    }   
    
    



}
    



