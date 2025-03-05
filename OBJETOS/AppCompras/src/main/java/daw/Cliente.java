package daw;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Cliente {
    //ATRIBUTOS DE INSTANCIA
    //NO LLEVAN STATIC, esos son los atributos de clase
    //Estos atributos se inicializan por defecto
    //Objetos a null, numeros a 0 y boolean a false.

    //Visibilidad de atributos y metodos. IMPORTANTE
    //default (se ven desde la propia clase y clases del paquete)
    //public : cualquier clase tiene acceso
    //protected : propia clase, clases del paquete y subclases (nota: para herencias)
    //private : propia clase
    private int idCliente;
    private String nombre;
    private String apellidos;
    private String nif;
    private String telefono;
    private LocalDate fecNac;

    // Sobreescritura metodo toString
    //Devuelve un String con la representacion del objeto
//    @Override
//    public String toString() {
//
//        return "nombre: " + nombre + " apellidos: " + apellidos + " nif : " + nif + " id " + idCliente;
//    }
    //metodo GET  para el id
    public int getIdCliente() {
        return idCliente;
    }

    public String getNombreCliente() {
        return nombre;
    }

    //metodo SET (igual que un void)
    public void setApellidos(String nuevoAp) {
        apellidos = nuevoAp;
    }

    public void setIdCliente(int nuevoId) {
        if (nuevoId > 0) {
            idCliente = nuevoId;
        }
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }

    //CONSTRUCTOR - se debe llamar igual que la clase
    //No devuelve nada pero no se le pone void
    //Permite crear objetos 
    public Cliente(int identificador, String nomCliente, String apeCliente, String nifCliente, String telefCliente, LocalDate fechaNacimiento) {
        //A la IZQUIERDA -> LOS ATRIBUTOS DEL OBJETO
        //A la DERECHA -> LOS PARAMETROS DEL CONSTRUCTOR
        idCliente = identificador;
        nombre = nomCliente;
        apellidos = apeCliente;
        nif = nifCliente;
        telefono = telefCliente;
        fecNac = fechaNacimiento;

    }

    //METODO EN CLASE CLIENTE QUE NOS DE LA EDAD DEL CLIENTE
    public int getEdad() {
        return (int) ChronoUnit.YEARS.between(this.fecNac, LocalDate.now());//tambien puedes poner fecNac solo o fechaNacimiento

    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // UN ALIAS NO ES UNA COPIA DE UN OBJETO
    // Para ello podemos hacer:
    // constructor copia
    public Cliente(Cliente origen) {
        this.nombre = origen.nombre;
        this.apellidos = origen.apellidos;
        this.nif = origen.nif;
        this.telefono = origen.telefono;
        this.fecNac = origen.fecNac;
    }

    //SOBREESCRITURA DEL METODO TO STRING
    //DEVUELVE UN STRING CON LA REPRESENTACION DE UN OBJETO
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("idCliente=").append(idCliente);
        sb.append(", nombre = ").append(nombre);
        sb.append(", apellidos= ").append(apellidos);
        sb.append(", nif= ").append(nif);
        sb.append(", telefono=").append(telefono);
        sb.append(",  fechaNacimiento = ").append(fecNac);
        sb.append("}");
        return sb.toString();
    }

    //metodo para cartera clientes, forma 3, para llamarlo ya formateado
    public String toStringLista() {

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("idCliente=").append(idCliente);
        sb.append(", nombre = ").append(nombre);
        sb.append(", nif= ").append(nif);
        sb.append("}");
        return sb.toString();
    }

    // metodo copiar
    public static Cliente copiar(Cliente origen) {
        return new Cliente(origen.getIdCliente(), origen.nombre,
                origen.apellidos, origen.nif, origen.telefono,
                origen.fecNac);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idCliente;
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + Objects.hashCode(this.apellidos);
        hash = 71 * hash + Objects.hashCode(this.nif);
        hash = 71 * hash + Objects.hashCode(this.telefono);
        hash = 71 * hash + Objects.hashCode(this.fecNac);
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
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.nif, other.nif)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return Objects.equals(this.fecNac, other.fecNac);
    }

    //Constructor por defecto sin parametros
    //Metodos sobrecargados
    public Cliente() {

    }

}
