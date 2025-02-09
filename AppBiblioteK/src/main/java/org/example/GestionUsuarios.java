package org.example;

import java.time.*;
import java.util.*;

public class GestionUsuarios {
    // Aquí se implementarán las funciones para gestionar los usuarios.
    static ArrayList<Usuario> gestionUsuarios = new ArrayList<Usuario>();

    public static Usuario agregarUsuario(String dni, String nombre, LocalDate fechaNacimiento) {
        // Comprobar si el email ya está en uso
        for (Usuario u : gestionUsuarios) {
            if (u.getDni().equals(dni)) {
                System.out.println("Error: El dni ya está en uso.");
                return u;
            }
        }
        // Crear el nuevo usuario y añadirlo a la lista
        Usuario usuario = new Usuario(dni, nombre, fechaNacimiento);
        gestionUsuarios.add(usuario);
        System.out.println("Usuario creado correctamente.");

        return usuario;
    }

    public static void eliminarUsuario(String dni) {
        // Buscar el usuario por el dni
        for (int i = 0; i < gestionUsuarios.size(); i++) {
            Usuario u = gestionUsuarios.get(i);
            if (u.getDni().equals(dni)) {
                gestionUsuarios.remove(i);
                System.out.println("Usuario eliminado correctamente.");
                return;
            }
        }
        System.out.println("Error: No se encontró el usuario.");

    }

    public static void mostrarTodosLosUsuarios() {
        for (Usuario u : gestionUsuarios) {
            System.out.println(u);
        }

    }

    public static int CalcularEdad(Usuario usuario) {
        int presentYear = Calendar.getInstance().get(Calendar.YEAR);
        int birthYear = usuario.getFechaNacimiento().getYear();
        int Edad = birthYear - presentYear;
        return Edad;
    }


}

