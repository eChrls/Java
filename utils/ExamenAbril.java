/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Casa
 */
public class ExamenAbril {
    /****************************************************************************************************************
     * CONSTRUCTORES
class Pelicula {
    String titulo;
    int añoEstreno;
    List<String> actoresPrincipales;
    String[] generos;

    // Constructor personalizado: Título sin números y año de estreno posterior a 1950
    public Pelicula(String titulo, int añoEstreno) {
        if (tieneNumeros(titulo)) {
            System.out.println("El título no puede contener números.");
            this.titulo = "Título Inválido";
        } else if (añoEstreno <= 1950) {
            System.out.println("El año de estreno debe ser posterior a 1950.");
            this.añoEstreno = 1951; // Establecemos un valor por defecto válido
            this.titulo = titulo;
        } else {
            this.titulo = titulo;
            this.añoEstreno = añoEstreno;
        }
        this.actoresPrincipales = new ArrayList<>();
        this.generos = new String[3]; // Limitamos el array de géneros a 3
    }

    // Constructor con lista de actores (máximo 5 actores)
    public Pelicula(String titulo, int añoEstreno, List<String> actores) {
        this(titulo, añoEstreno); // Llamamos al constructor anterior para la validación del título y año
        if (actores.size() > 5) {
            System.out.println("Solo se permiten hasta 5 actores principales.");
            this.actoresPrincipales = actores.subList(0, 5); // Tomamos solo los primeros 5
        } else {
            this.actoresPrincipales = new ArrayList<>(actores); // Creamos una nueva lista con los actores
        }
        this.generos = new String[3];
    }

    // Constructor con array de géneros (se copian los que quepan hasta el límite)
    public Pelicula(String titulo, int añoEstreno, String[] generos) {
        this(titulo, añoEstreno);
        int limite = Math.min(generos.length, this.generos.length);
        System.arraycopy(generos, 0, this.generos, 0, limite);
    }

    // Constructor "película por defecto"
    public Pelicula() {
        this.titulo = "Película Desconocida";
        this.añoEstreno = 2000;
        this.actoresPrincipales = new ArrayList<>();
        this.generos = new String[3];
        this.generos[0] = "Drama"; // Le ponemos un género por defecto
    }

    // Método auxiliar para verificar si un string contiene números
    private boolean tieneNumeros(String texto) {
        for (char c : texto.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAñoEstreno() {
        return añoEstreno;
    }

    public List<String> getActoresPrincipales() {
        return actoresPrincipales;
    }

    public String[] getGeneros() {
        return generos;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
               "titulo='" + titulo + '\'' +
               ", añoEstreno=" + añoEstreno +
               ", actoresPrincipales=" + actoresPrincipales +
               ", generos=" + Arrays.toString(generos) +
               '}';
    }

    public static void main(String[] args) {
        Pelicula p1 = new Pelicula("Guardianes de la Galaxia 3", 2023);
        System.out.println("Película 1: " + p1);

        Pelicula p2 = new Pelicula("El Retorno del Jedi", 1983, Arrays.asList("Mark Hamill", "Harrison Ford", "Carrie Fisher", "Otro Actor"));
        System.out.println("Película 2: " + p2);

        Pelicula p3 = new Pelicula("Toy Story", 1995, new String[]{"Animación", "Comedia", "Aventura", "Familiar"});
        System.out.println("Película 3: " + p3);

        Pelicula p4 = new Pelicula();
        System.out.println("Película 4 (por defecto): " + p4);

        Pelicula p5 = new Pelicula("Pelicula con 2024 en el titulo", 2024); // Ejemplo de título inválido
        System.out.println("Película 5: " + p5);

        Pelicula p6 = new Pelicula("Una Pelicula Antigua", 1945); // Ejemplo de año inválido
        System.out.println("Película 6: " + p6);

        Pelicula p7 = new Pelicula("Los Asombrosos", 2004, Arrays.asList("Actor 1", "Actor 2", "Actor 3", "Actor 4", "Actor 5", "Actor 6")); // Ejemplo de demasiados actores
        System.out.println("Película 7: " + p7);
    }
}
    */
    
    /****************************************************************************************************************
    COMPARATOR STRING
    import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class ComparadorPalabraPorLongitud implements Comparator<Palabra> {
    @Override
    public int compare(Palabra palabra1, Palabra palabra2) {
        // Comparamos por la longitud de las palabras
        return Integer.compare(palabra1.getTexto().length(), palabra2.getTexto().length());
    }
}

public class EjemploComparatorString {
    public static void main(String[] args) {
        List<Palabra> listaDePalabras = new ArrayList<>();
        listaDePalabras.add(new Palabra("manzana"));
        listaDePalabras.add(new Palabra("banana"));
        listaDePalabras.add(new Palabra("cereza"));

        // Usamos nuestro comparador para ordenar por longitud
        Collections.sort(listaDePalabras, new ComparadorPalabraPorLongitud());

        for (Palabra palabra : listaDePalabras) {
            System.out.println(palabra.getTexto()); // Salida: banana, cereza, manzana (ordenadas por longitud)
        }
    }
}
     */

 /****************************************************************************************************************
    COMPARATOR INT
    
    import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class ComparadorNumeroDescendente implements Comparator<Numero> {
    @Override
    public int compare(Numero numero1, Numero numero2) {
        // Comparamos en orden descendente
        return Integer.compare(numero2.getValor(), numero1.getValor());
    }
}

public class EjemploComparatorInt {
    public static void main(String[] args) {
        List<Numero> listaDeNumeros = new ArrayList<>();
        listaDeNumeros.add(new Numero(5));
        listaDeNumeros.add(new Numero(2));
        listaDeNumeros.add(new Numero(8));

        // Usamos nuestro comparador para ordenar en orden descendente
        Collections.sort(listaDeNumeros, new ComparadorNumeroDescendente());

        for (Numero numero : listaDeNumeros) {
            System.out.println(numero.getValor()); // Salida: 8, 5, 2
        }
    }
}
     */

 /****************************************************************************************************************
    COMPARABLE INT
    
    class Numero implements Comparable<Numero> {
    int valor;

    public Numero(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public int compareTo(Numero otroNumero) {
        // Comparamos los valores de los dos números
        if (this.valor < otroNumero.valor) {
            return -1;
        } else if (this.valor > otroNumero.valor) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        java.util.List<Numero> listaDeNumeros = new java.util.ArrayList<>();
        listaDeNumeros.add(new Numero(5));
        listaDeNumeros.add(new Numero(2));
        listaDeNumeros.add(new Numero(8));

        java.util.Collections.sort(listaDeNumeros); // Usamos la comparación definida en compareTo

        for (Numero numero : listaDeNumeros) {
            System.out.println(numero.getValor()); // Salida: 2, 5, 8
        }
    }
}
     */
 /****************************************************************************************************************
    COMPARABLE STRING 
    
    class Palabra implements Comparable<Palabra> {
    String texto;

    public Palabra(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public int compareTo(Palabra otraPalabra) {
        // Usamos la comparación natural de los Strings (orden alfabético)
        return this.texto.compareTo(otraPalabra.texto);
    }

    public static void main(String[] args) {
        java.util.List<Palabra> listaDePalabras = new java.util.ArrayList<>();
        listaDePalabras.add(new Palabra("manzana"));
        listaDePalabras.add(new Palabra("banana"));
        listaDePalabras.add(new Palabra("cereza"));

        java.util.Collections.sort(listaDePalabras);

        for (Palabra palabra : listaDePalabras) {
            System.out.println(palabra.getTexto()); // Salida: banana, cereza, manzana
        }
    }
}
     */
}
