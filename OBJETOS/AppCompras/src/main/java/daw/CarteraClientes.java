package daw;

import java.util.ArrayList;
import java.util.List;

/*
clase catalogo clientes
estará compuesto entre 0 y n clientes → 
→ en catálogo de clientes tenemos un atributo que es una lista de clientes*/
public class CarteraClientes {

    private List<Cliente> lista;

    public CarteraClientes() {
        this.lista = new ArrayList<>(100);

    }
    //una vez hecha la lista, vamos a crear metodos para crear, borrar y modificar la lista
    //la logica del programa se trabajar en el main

    //metodo para anadir clientes
    //no miramos nada mas, ni id, ni ninguna restriccion.
    //es decir, la unica condicion sera que no sea nulo
    public void añadirCliente(Cliente cli) {
        if (cli != null) {
            this.lista.add(cli);
        }
    }

    public CarteraClientes(List<Cliente> lista) {
        this.lista = lista;
    }

    //sobreescribimos el metodo toString
    public String toString() {
        //forma 1: return lista.toString();
        /*forma 2 para darle ademas formato
        String tmp = "";
        for (Cliente cliente : lista){
            tmp+=cliente+"\n";
         */
        //forma3 llama al toString de cliente
        String tmp = "";
        for (Cliente cliente : lista) {
            tmp += cliente.toStringLista() + "\n";
        }
        return tmp;
    }

    //metodo para buscar cliente por nif (solo devuelve un cliente) 
    //y metodo de busqueda secuencial
    public Cliente buscarPorId(int id) {
        for (Cliente cliente : lista) {
            if (cliente.getIdCliente() == id) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String nif) {
        for (Cliente cliente : lista) {
            if (cliente.getNif().equals(nif)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> getLista() {
        return lista;
    }

    //Metodo para borrar cliente
    public boolean borrarCliente(String nif) {
        Cliente clienteABorrar = buscarCliente(nif);
        if (clienteABorrar != null) {
            return lista.remove(clienteABorrar);
        }
        return false;
    }

    //Metodo para mostrar todos los clientes
    public void mostrarClientes() {
        if (lista.isEmpty()) {
            System.out.println("Cartera de clientes vacía");
            return;
        }
        System.out.println("====LISTA DE CLIENTES====");
        for (Cliente cliente : lista) {
            System.out.println(cliente.toStringLista());
        }
        System.out.println("==========================");
    }

    //Metodo para saber el numero de clientes en cartera
    public int numeroClientes() {
        return lista.size();
    }

    //Metodo para comprobar si la lista está llena
    public boolean carteraLlena() {
        return lista.size() >= 100;
    }

    //Metodo para saber si existe un nif
    public boolean existeNif(String nif) {
        return buscarCliente(nif) != null;
    }

    //Metodo para borrar todos los clientes
    public void vaciarCartera() {
        lista.clear();
    }

}
