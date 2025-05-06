/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package tarea7D;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Casa
 */
public class tarea7D {

    public static void main(String[] args) throws IOException {

        TelaAraña tela1 = new TelaAraña();
        TelaAraña tela2 = new TelaAraña();
        TelaAraña tela3 = new TelaAraña();

        tela1 = leerJson("./caso1.json");
        tela2 = leerJson("./caso2.json");
        tela3 = leerJson("./caso3.json");

        System.out.println("El fichero 1 tiene los siguientes nombres de elefantes en la red: " + nombresElefantesColumpiados(tela1));

        System.out.println("El fichero 2 tiene los siguientes nombres de elefantes en la red: " + nombresElefantesColumpiados(tela2));

        System.out.println("El fichero 3 tiene los siguientes nombres de elefantes en la red: " + nombresElefantesColumpiados(tela3));

    }

    /*Tienes que crear un programa, modularizado, que pregunte al usuario qué fichero leer entre los JSON que haya en la raíz de tu proyecto
    , y en función de la elección, el programa mostrará:*/
    public static TelaAraña leerJson(String ruta) throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
//        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        om.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
//        om.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
//        om.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
//        om.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
//        om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        om.enable(SerializationFeature.INDENT_OUTPUT);
//        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return om.readValue(new File(ruta), TelaAraña.class);

    }

    /*Nombres de los elefantes que se pudieron columpiar antes de que se rompiera la tela,
    suponiendo el orden de llegada el mismo que el que tiene el fichero. En caso de que no 
    se pueda columpiar ninguno, se mostrará "Ninguno".*/
    public static List<String> nombresElefantesColumpiados(TelaAraña tela) {

        List<String> listaNombres = new ArrayList<>();
        int pesoAcumulado = 0;

        for (Elefante elefante : tela.getElefantes()) {
            int peso = elefante.getPesoPositivo();
            pesoAcumulado += peso;

            if (pesoAcumulado <= tela.getPeso()) {
                listaNombres.add(elefante.getNombre());
            }
        }

        return listaNombres;
    }

}
