package utils;

import entity.Usuario;
import entity.Pelicula;
import entity.Alquiler;
import entity.FichaTecnica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {

    public static void exportarUsuarios(List<Usuario> usuarios, File destino) throws IOException {
        FileWriter writer = new FileWriter(destino);
        writer.write("id_usuario,nombre,password,email\n");
        for (Usuario u : usuarios) {
            writer.write(u.getIdUsuario() + "," + u.getNombre() + "," + u.getPassword() + "," + u.getEmail() + "\n");
        }
        writer.close();
    }

    public static void exportarPeliculas(List<Pelicula> peliculas, File destino) throws IOException {
        FileWriter writer = new FileWriter(destino);
        writer.write("id_pelicula,titulo,anyo_estreno\n");
        for (Pelicula p : peliculas) {
            writer.write(p.getIdPelicula() + "," + p.getTitulo() + "," + p.getAnyoEstreno() + "\n");
        }
        writer.close();
    }

    public static void exportarAlquileres(List<Alquiler> alquileres, File destino) throws IOException {
        FileWriter writer = new FileWriter(destino);
        writer.write("id_alquiler,id_usuario,id_pelicula,fecha_alquiler\n");
        for (Alquiler a : alquileres) {
            writer.write(a.getIdAlquiler() + "," + a.getUsuario().getIdUsuario() + "," + a.getPelicula().getIdPelicula() + "," + a.getFechaAlquiler() + "\n");
        }
        writer.close();
    }

    public static void exportarFichasTecnicas(List<FichaTecnica> fichas, File destino) throws IOException {
        FileWriter writer = new FileWriter(destino);
        writer.write("id_ficha,id_pelicula,descripcion,genero\n");
        for (FichaTecnica f : fichas) {
            writer.write(f.getIdFicha() + "," + f.getPelicula().getIdPelicula() + "," + f.getDescripcion() + "," + f.getGenero() + "\n");
        }
        writer.close();
    }
}
