package tarea7f;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class tarea7f {

    public static void main(String[] args) throws IOException {
        List<Horario> horarios = new ArrayList<>();
        horarios = leerCsv();
        horarios.forEach(System.out::println);
        Set<String> grupos = new TreeSet<>();
        grupos = sacarSetOrdenado(horarios);
        System.out.println("**********************************************************************************************************************");
        System.out.println("Elige el horario del curso que quieras ver el horario");
        grupos.forEach(System.out::println);
        Scanner sc = new Scanner (System.in);
        String curso = sc.nextLine();
        if(grupos.contains(curso)){
        System.out.println("**********************************************************************************************************************");
        //1ESOA
        Horario[][] th = obtenerHorario(horarios, curso);
        mostrarHorario(th);
        convertirTxt(th, curso);
         }else{
            System.out.println("No existe curso con ese nombre.");
        }
    }

    /*1. Todos los registros se guardarán en una lista de objetos, cuya clase se ha de crear para tal efecto. 
    El nombre de la clase lo decides tú, pero debe ser significativo. Una vez guardados los objetos en la lista, 
    ésta debe quedar ordenada primero por día y luego por hora.*/
    public static List<Horario> leerCsv() throws IOException {
        String ruta = "./hor_curso_1920_final.csv";
        String separador = ";";
        List<Horario> horarios = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(separador);

                //Primero limpio todos los campos en un bucle for
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = datos[i].trim();
                    if (datos[i].startsWith("\"") && datos[i].endsWith("\"")) {
                        datos[i] = datos[i].substring(1, datos[i].length() - 1);
                        datos[i] = datos[i].trim();

                    }
                }
                //DESPUÉS de ese bucle (no dentro), creo UN SOLO objeto Horario por línea
                if (datos.length >= 7) {
                    try {

                        Horario horario = new Horario(datos[0], datos[1], datos[2], datos[3], datos[4], Integer.parseInt(datos[5]), Integer.parseInt(datos[6]));
                        horarios.add(horario);

                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir a numero la linea " + line);
                    }
                }

            }
        } catch (IOException e) {
            System.out.println("Error en el catch");
        }

        horarios.sort(Comparator.comparing(Horario::getDia).thenComparing(Horario::getHora));

        return horarios;
    }

    public static Horario verHorarioCurso(List<Horario> horarios, String curso) {

        return new Horario();
    }

    /*2. Una vez obtenida la lista original de datos, hay que obtener un conjunto de grupos únicos ordenados alfabéticamente. */
    public static Set<String> sacarSetOrdenado(List<Horario> horarios) {
        Set<String> cursos = new TreeSet();

        cursos = horarios.stream().map(Horario::getCurso).collect(Collectors.toCollection(TreeSet::new));

        return cursos;
    }

    //1ESOA
    public static Horario[][] obtenerHorario(List<Horario> horarios, String curso) {

        Horario[][] th = new Horario[5][6];
        //1º filtrar por curso
        //2º ubicar coordenadas segun dia y hora
        // 3º insertar horario en esas cordenadas
        horarios.stream().filter(h -> h.getCurso().equals(curso))
                .forEach(h -> {
                    int hora = h.getHora();
                    if (hora >= 5) {
                        hora--;
                    }
                    th[h.getDia() - 1][hora - 1] = h;
                });

        return th;
    }

    public static void mostrarHorario(Horario[][] th) {
        String[] dias = {"Lunes", "Martes", "Mierc", "Jueves", "Viernes"};

        for (int i = 0; i < dias.length; i++) {
            System.out.print(dias[i] + "\t");
        }
        System.out.println();

        for (int hora = 0; hora < th[0].length; hora++) {
            for (int dia = 0; dia < th.length; dia++) {

                if (th[dia][hora] != null) {
                    System.out.print(th[dia][hora].getAsignatura() + "\t");
                } else {
                    System.out.print("   \t");
                }
            }
            System.out.println();
        }
    }

    public static void convertirTxt(Horario[][] th, String curso) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter(new File(curso + ".txt"));

        String[] dias = {"Lunes", "Martes", "Mierc", "Jueves", "Viernes"};

        for (int i = 0; i < dias.length; i++) {
            pw.print(dias[i] + "\t");
        }
        pw.println();

        for (int hora = 0; hora < th[0].length; hora++) {
            for (int dia = 0; dia < th.length; dia++) {

                if (th[dia][hora] != null) {
                    pw.print(th[dia][hora].getAsignatura() + "\t");
                } else {
                    pw.print("   \t");
                }
            }
            pw.println();
        }
        pw.close();
    }

}


