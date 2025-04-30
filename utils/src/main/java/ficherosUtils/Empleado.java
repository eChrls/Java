/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package ficherosUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Empleado(int id, String nombre, int edad, double salario) {

        public static void main(String[] args) {
                // Crear una lista para almacenar los empleados
                List<Empleado> listaEmpleados = new ArrayList<>();

                // Añadir 10 empleados a la lista
                listaEmpleados.add(new Empleado(1, "Ana Martínez", 28, 2500.00));
                listaEmpleados.add(new Empleado(2, "Carlos López", 35, 3200.50));
                listaEmpleados.add(new Empleado(3, "Laura García", 42, 4100.75));
                listaEmpleados.add(new Empleado(4, "Miguel Rodríguez", 31, 2800.25));
                listaEmpleados.add(new Empleado(5, "Elena Fernández", 27, 2300.00));
                listaEmpleados.add(new Empleado(6, "Javier Torres", 45, 4500.00));
                listaEmpleados.add(new Empleado(7, "Sofía Ruiz", 29, 2600.50));
                listaEmpleados.add(new Empleado(8, "Pablo Sánchez", 38, 3700.00));
                listaEmpleados.add(new Empleado(9, "Lucía Gómez", 33, 3100.25));
                listaEmpleados.add(new Empleado(10, "David Pérez", 41, 3900.75));

                // 1- Dada una lista de números enteros, obtener una nueva lista que contenga
                // solo los números pares.
                // Creo una lista de enteros
                List<Integer> listaEnteros = new ArrayList<>();

                for (int i = 0; i < listaEmpleados.size(); i++) {
                        int idTemp = listaEmpleados.get(i).id;
                        listaEnteros.add(idTemp);
                }

                /* forma 2 de hacerlo, con streams */
                List<Integer> listaDeIds = listaEmpleados.stream().map(Empleado::id)// Por cada empleado , dame el id
                                .collect(Collectors.toList());// conversión a lista

                Predicate<Integer> predicate = x -> x % 2 == 0;
                Stream<Integer> numerosParesStream = listaEnteros.stream().filter(predicate);

                // Conversión de Stream a Lista
                List<Integer> listaPares = numerosParesStream.collect(Collectors.toList());

                System.out.println("Lista de Pares : ");
                System.out.print(listaPares);
                System.out.println("\n");

                // 2- Dada una lista de números enteros, calcular la suma de todos los
                // elementos.
                // Para usar IntStream convierto la lista a array
                int[] array = new int[listaEnteros.size()];
                for (int i = 0; i < listaEnteros.size(); i++) {
                        array[i] = listaEnteros.get(i);
                }
                // Creamos stream del array
                IntStream streamOperaciones = IntStream.of(array);

                /* forma 2 de hacer la lista de pares con stream creado */
                System.out.println("Lista de pares 2 : ");
                streamOperaciones.filter(i -> i % 2 == 0).forEach(System.out::println);
                System.out.println("\n");

                // Mostramos la suma
                System.out.println("Suma : " + IntStream.of(array).sum());
                System.out.println("\n");

                // 3- Realiza el ejercicio anterior usando la función reduce.
                // reduce(T, BinaryOperator<T>) realiza la reducción usando un valor inicial y
                // una función asociativa. Se devuelve un valor como resultado.
                // streamOperaciones esta consumido, produce excepcion.
                IntStream streamSumaReduce = IntStream.of(array);
                int suma = streamSumaReduce.reduce(0, (acumulador, numero) -> acumulador + numero); // acumulador +=
                                                                                                    // numero
                System.out.println("Suma con reduce: " + suma);
                System.out.println("\n");

                // 4- Dada una lista de números enteros, obtener el numero mínimo o cero si la
                // lista está vacía.
                System.out.println("Maximo : " + IntStream.of(array).max().orElse(0)); // orElse devuelve 0 si esta
                                                                                       // vacio
                System.out.println("Minimo : " + IntStream.of(array).min().orElse(0));
                System.out.println("\n");
                int[] vacio = new int[0];
                System.out.println("Prueba vacio (devuelve 0) :  " + IntStream.of(vacio).min().orElse(0)); // devuelve 0
                System.out.println("\n");

                // 5- Dada una lista de números enteros, obtener una nueva lista que contenga
                // solo los números impares multiplicados por dos.
                // Para evitar excepcion creamos nuevo IntStream
                IntStream nuevaOperacion = IntStream.of(array);
                System.out.println("Impares multiplicados por 2 : ");
                // El stream va a descargar en una lista
                List<Integer> imparesX2 = nuevaOperacion.filter(i -> (i % 2 != 0)) // impares
                                .map(i -> i * 2) // siempre se comienza con i -> +operacion
                                .boxed() // casteo del IntStream (int) a Stream<Integer>
                                .collect(Collectors.toList());
                imparesX2.forEach(System.out::println);
                System.out.println("\n");

                // 6-Sobre la lista de impares anterior, contar el total de elementos.
                long total = imparesX2.stream().count();
                System.out.println("Total de elemento de la lista anterior : " + total);
                System.out.println("\n");

                // 7- Dada una lista de cadenas, obtener una nueva lista que contenga las mismas
                // cadenas, pero en mayúsculas.
                List<String> listaNombres = listaEmpleados.stream().map(Empleado::nombre)
                                .collect(Collectors.toList()); // Conversión a lista

                Stream<String> enMayus = listaNombres.stream().map(cadena -> cadena.toUpperCase()); // (String::toUpperCase);
                System.out.println("Nombres en mayusculas: ");
                enMayus.forEach(System.out::println);
                System.out.println("\n");

                // metodo 2
                Set<String> listaNombres2 = listaEmpleados.stream().map(Empleado::nombre)
                                .map(String::toUpperCase)
                                .collect(Collectors.toSet());

                // 8- Cadenas que son distintas en mayusculas
                System.out.println("Nombres en mayusculas distintos: ");
                List<String> enMayusDistintas = listaNombres.stream().map(cadena -> cadena.toUpperCase())
                                .distinct()
                                .collect(Collectors.toList());
                enMayusDistintas.forEach(System.out::println);
                System.out.println("\n");

                // 9- Imprimir por pantalla la longitud de cada string de la lista de cadenas
                // original.
                System.out.println("Longitud de cada nombre : ");
                listaNombres.stream().mapToInt(nombre -> nombre.replaceAll(" ", "").length())
                                .forEach(num -> System.out.print("  " + num));
                System.out.println("\n");

                System.out.println("Lista de longitud de cada nombre con nombre : ");
                listaNombres.stream()
                                .map(nombre -> nombre + " : " + nombre.replaceAll(" ", "").length()) // reemplaza un
                                                                                                     // espacio por nada
                                .forEach(System.out::println);
                System.out.println("\n");

                // 10 - Sobre la lista de cadenas original, obtener una nueva lista que contenga
                // solo las cadenas que comienzan con la letra "A",
                // y luego convierte esas cadenas a minúsculas.
                System.out.println("Nombres que empiezan por A en minúsculas : ");
                Stream<String> stream = listaNombres.stream()
                                .filter(s -> s.startsWith("A") || s.startsWith("a"))
                                .map(nombre -> nombre.toLowerCase());
                stream.forEach(System.out::println);
                System.out.println("\n");

                // 11 - Ordenar la lista de empleados por edad de forma ascendente.
                System.out.println("Ordenación por edad ascendente");

                // Ordenar empleados por edad
                listaEmpleados.sort(Comparator.comparingInt(Empleado::edad));
                listaEmpleados.forEach(System.out::println);
                System.out.println("\n");

                // 12 - Ordenar la lista por salario de forma descendente. Usa reversed en el
                // objeto Comparator.
                System.out.println("Ordenación por salario descendente");
                List<Double> listaSalario = listaEmpleados.stream()
                                .map(Empleado::salario)
                                .collect(Collectors.toList());

                /*Collections.sort(listaSalario);// hay que ordenar primero para que el reverse funcione.
                Collections.reverse(listaSalario);
                System.out.println(listaSalario);*/
                listaEmpleados.sort(Comparator.comparingDouble(Empleado::salario));
                System.out.println(listaEmpleados.reversed());
                System.out.println("\n");
                

                // 13- Ordenar la lista por nombre y obtener una nueva lista con los tres
                // primeros elementos.
                System.out.println("Lista con los tres primeros nombres alfabéticamente : ");
                List<Empleado>listanueva=(listaEmpleados).stream()
                                            .sorted(Comparator.comparing(Empleado::nombre))
                                            .limit(3)
                                            .collect(Collectors.toList());
                
                
                
                
                Stream<String> streamLimitado = listaNombres.stream().limit(3);
                streamLimitado.forEach(System.out::println);
                System.out.println("\n");
                
                

                // 14 - Comprobar si algún empleado tiene salario superior a 100. *Nota : Lo
                // cambio a 3000 para filtrar.
                System.out.println("Comprobando salarios superiores a 3000* (ver nota)");
                    boolean comprobacion = listaSalario.stream().anyMatch(s -> s>3000);
                      System.out.println(comprobacion); 
                                /*.filter(s -> s > 3000)
                                .collect(Collectors.toList());*/
                
                
               // salariosAltos.forEach(System.out::println);
                System.out.println("\n");

                // 15 - Obtener un set con los nombres de los empleados mayores de 18 años.
                // *Nota: Lo cambio a 40 años para filtrar.
                System.out.println("Set de empleados veteranos, edad superior a 40 años* (ver nota)");
                List<Integer>listaEdades =  listaEmpleados.stream().map(Empleado::edad).collect(Collectors.toList());
                Set<Integer> setEdades = new HashSet(listaEdades);
                Set<String> veteranos = listaEmpleados.stream()
                                .filter(empleado -> empleado.edad() > 40)
                                .map(Empleado::nombre)
                                .collect(Collectors.toSet());
                veteranos.forEach(System.out::println);
                System.out.println("\n");
                
                
                // 16- Obtener el empleado con salario más alto. Usa la función max.
                Optional<Empleado> salarioMax = listaEmpleados.stream()
                                .max((e1, e2) -> Double.compare(e1.salario(), e2.salario()));

                System.out.println("Salario más alto : " + salarioMax + " €.");
                System.out.println("\n");

                // 17- Calcular el salario total de todos los empleados.
                // transformación a array para usar DoubleStream
                double[] arraySalarios = new double[listaSalario.size()];
                for (int i = 0; i < listaSalario.size(); i++) {
                        arraySalarios[i] = listaSalario.get(i);
                }

                DoubleStream streamSalarios = DoubleStream.of(arraySalarios);
                System.out.println("La suma de los salarios es = " + streamSalarios.sum() + " €.");
                System.out.println("\n");
                
                listaEmpleados.stream()
                                            .mapToDouble(Empleado::salario)
                                            .sum();
                
                listaEmpleados.stream()
                                          .map(Empleado::salario)
                                          .reduce(0.0, Double::sum);
                
                                          
                // 18 - Agrupar (obtener un map) los empleados por id y salario asociado.

                Map<Integer, Double> mapaFinal = listaEmpleados.stream()
                                .collect(Collectors.toMap(Empleado::id, Empleado::salario));
                System.out.println("IDs y Salarios: ");
                System.out.println(mapaFinal);

                
        }
}
