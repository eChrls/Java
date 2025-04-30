package ficherosUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamUtils {

    /*INDICE
1.  filtrar(Collection<T>, Predicate<T>)
2.  mapear(Collection<T>, Function<T, R>)
3.  flatMapear(Collection<T>, Function<T, java.util.stream.Stream<R>>)
4.  ordenar(Collection<T>)
5.  ordenar(Collection<T>, Comparator<T>)
6.  contar(Collection<T>)
7.  minimo(Collection<T>, Comparator<T>)
8.  maximo(Collection<T>, Comparator<T>)
9.  reducir(Collection<T>, T, BinaryOperator<T>)
10. agruparPor(Collection<T>, Function<T, K>)
11. obtenerDistintos(Collection<T>)
12. limitar(Collection<T>, long)
13. saltar(Collection<T>, long)
14. existeAlguno(Collection<T>, Predicate<T>)
15. existenTodos(Collection<T>, Predicate<T>)
16. noExisteNinguno(Collection<T>, Predicate<T>)
17. encontrarPrimero(Collection<T>)
18. encontrarCualquiera(Collection<T>)
19. convertirAMapa(Collection<T>, Function<T, K>, Function<T, V>)
20. encontrarPrimeroQueCumpla(Collection<T>, Predicate<T>)
21. obtenerElementosMientrasCumplen(Collection<T>, Predicate<T>)
22. obtenerElementosHastaQueCumplen(Collection<T>, Predicate<T>)
23. agruparYMapear(Collection<T>, Function<T, K>, Function<T, V>)
24. agruparYObtenerSet(Collection<T>, Function<T, K>, Function<T, V>)
25. reducirConIdentidadDiferente(Collection<T>, U, BiFunction<U, T, U>)
26. reducirSinIdentidad(Collection<T>, BinaryOperator<T>)
27. obtenerValoresOrdenadosPorClave(Map<K, V>)
28. invertirMapa(Map<K, V>)
29. filtrarMapaPorClave(Map<K, V>, Predicate<K>)
30. contarPorClave(Collection<T>, Function<T, K>)
31. obtenerElementoAleatorio(Collection<T>)
32. particionarEnSublistas(List<T>, int)
33. obtenerDiasDeLaSemana(List<Empleado>)*/

    public static <T> List<T> filtrar(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream().filter(predicate).collect(Collectors.toList());
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // List<Empleado> empleadosMayoresDe30 = StreamUtils.filtrar(listaDeEmpleados, empleado -> empleado.getEdad() > 30);
    // Por ejemplo, si listaDeEmpleados tiene a Ana (28), Carlos (35), Laura (42), empleadosMayoresDe30 contendrá a Carlos y Laura.

    public static <T, R> List<R> mapear(Collection<T> collection, Function<T, R> mapper) {
        return collection.stream().map(mapper).collect(Collectors.toList());
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // List<String> nombresDeEmpleados = StreamUtils.mapear(listaDeEmpleados, Empleado::getNombre);
    // Si listaDeEmpleados tiene a Ana, Carlos, Laura, nombresDeEmpleados contendrá ["Ana Martínez", "Carlos López", "Laura García"].

    public static <T, R> List<R> flatMapear(Collection<T> collection, Function<T, java.util.stream.Stream<R>> mapper) {
        return collection.stream().flatMap(mapper).collect(Collectors.toList());
    }
    // Ejemplo de uso (asumiendo que Empleado tiene un método getHabilidades() que devuelve List<String>):
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados y cada empleado tiene una lista de habilidades:
    // List<String> todasLasHabilidades = StreamUtils.flatMapear(listaDeEmpleados, empleado -> empleado.getHabilidades().stream());
    // Si Ana tiene ["Java", "Spring"] y Carlos tiene ["C++", "Python"], todasLasHabilidades contendrá ["Java", "Spring", "C++", "Python"].

    public static <T> List<T> ordenar(Collection<T> collection) {
        return collection.stream().sorted().collect(Collectors.toList());
    }
    // Ejemplo de uso (si la clase Empleado implementara la interfaz Comparable basada en algún atributo, por ejemplo, el ID):
    // Suponiendo que la clase Empleado implementa Comparable comparando por ID:
    // List<Empleado> empleadosOrdenadosNaturalmente = StreamUtils.ordenar(listaDeEmpleados);
    // Si listaDeEmpleados tiene empleados con IDs 3, 1, 2, empleadosOrdenadosNaturalmente contendrá la lista ordenada por ID: [Empleado(id=1,...), Empleado(id=2,...), Empleado(id=3,...)].

    public static <T> List<T> ordenar(Collection<T> collection, Comparator<T> comparator) {
        return collection.stream().sorted(comparator).collect(Collectors.toList());
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // List<Empleado> empleadosOrdenadosPorSalario = StreamUtils.ordenar(listaDeEmpleados, Comparator.comparingDouble(Empleado::getSalario));
    // listaDeEmpleados se ordenará de forma ascendente según el salario.

    public static <T> long contar(Collection<T> collection) {
        return collection.stream().count();
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // long numeroTotalDeEmpleados = StreamUtils.contar(listaDeEmpleados);
    // Si listaDeEmpleados tiene 10 empleados, numeroTotalDeEmpleados será 10.

    public static <T> Optional<T> minimo(Collection<T> collection, Comparator<T> comparator) {
        return collection.stream().min(comparator);
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // Optional<Empleado> empleadoConMenorEdad = StreamUtils.minimo(listaDeEmpleados, Comparator.comparingInt(Empleado::getEdad()));
    // Si la lista no está vacía, empleadoConMenorEdad contendrá al empleado con la edad más baja.

    public static <T> Optional<T> maximo(Collection<T> collection, Comparator<T> comparator) {
        return collection.stream().max(comparator);
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // Optional<Empleado> empleadoConMayorSalario = StreamUtils.maximo(listaDeEmpleados, Comparator.comparingDouble(Empleado::getSalario()));
    // Si la lista no está vacía, empleadoConMayorSalario contendrá al empleado con el salario más alto.

    public static <T> T reducir(Collection<T> collection, T identity, BinaryOperator<T> accumulator) {
        return collection.stream().reduce(identity, accumulator);
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // int sumaDeEdades = StreamUtils.reducir(listaDeEmpleados, 0, (acumulador, empleado) -> acumulador + empleado.getEdad());
    // sumaDeEdades contendrá la suma de las edades de todos los empleados.

    public static <T, K> Map<K, List<T>> agruparPor(Collection<T> collection, Function<T, K> classifier) {
        return collection.stream().collect(Collectors.groupingBy(classifier));
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // Map<Integer, List<Empleado>> empleadosPorEdad = StreamUtils.agruparPor(listaDeEmpleados, Empleado::getEdad);
    // empleadosPorEdad será un mapa donde las claves son las edades y los valores son listas de empleados con esa edad. Por ejemplo, {28=[Empleado(Ana)], 35=[Empleado(Carlos)], 42=[Empleado(Laura)]}.

    public static <T> Set<T> obtenerDistintos(Collection<T> collection) {
        return collection.stream().distinct().collect(Collectors.toSet());
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // Set<Integer> edadesUnicas = StreamUtils.obtenerDistintos(StreamUtils.mapear(listaDeEmpleados, Empleado::getEdad));
    // Si las edades son 28, 35, 28, 42, edadesUnicas contendrá {28, 35, 42}.

    public static <T> List<T> limitar(Collection<T> collection, long maxSize) {
        return collection.stream().limit(maxSize).collect(Collectors.toList());
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // List<Empleado> primerosTresEmpleados = StreamUtils.limitar(listaDeEmpleados, 3);
    // primerosTresEmpleados contendrá los primeros tres empleados de la lista original.

    public static <T> List<T> saltar(Collection<T> collection, long n) {
        return collection.stream().skip(n).collect(Collectors.toList());
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // List<Empleado> empleadosDespuesDelTercero = StreamUtils.saltar(listaDeEmpleados, 3);
    // empleadosDespuesDelTercero contendrá todos los empleados a partir del cuarto elemento de la lista original.

    public static <T> boolean existeAlguno(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream().anyMatch(predicate);
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // boolean hayEmpleadoConSalarioMayorA4000 = StreamUtils.existeAlguno(listaDeEmpleados, empleado -> empleado.getSalario() > 4000);
    // Si al menos un empleado tiene un salario mayor a 4000, hayEmpleadoConSalarioMayorA4000 será true.

    public static <T> boolean existenTodos(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream().allMatch(predicate);
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // boolean todosLosEmpleadosSonMayoresDe25 = StreamUtils.existenTodos(listaDeEmpleados, empleado -> empleado.getEdad() > 25);
    // Si todos los empleados tienen más de 25 años, todosLosEmpleadosSonMayoresDe25 será true.

    public static <T> boolean noExisteNinguno(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream().noneMatch(predicate);
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // boolean ningunEmpleadoTieneSalarioMenorA2000 = StreamUtils.noExisteNinguno(listaDeEmpleados, empleado -> empleado.getSalario() < 2000);
    // Si ningún empleado tiene un salario menor a 2000, ningunEmpleadoTieneSalarioMenorA2000 será true.

    public static <T> Optional<T> encontrarPrimero(Collection<T> collection) {
        return collection.stream().findFirst();
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // Optional<Empleado> primerEmpleadoEnLaLista = StreamUtils.encontrarPrimero(listaDeEmpleados);
    // Si la lista no está vacía, primerEmpleadoEnLaLista contendrá el primer empleado de la lista.

    public static <T> Optional<T> encontrarCualquiera(Collection<T> collection) {
        return collection.stream().findAny();
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // Optional<Empleado> cualquierEmpleado = StreamUtils.encontrarCualquiera(listaDeEmpleados);
    // Devolverá un Optional que contiene algún empleado de la lista. En streams secuenciales, suele ser el primero.

    public static <T, K, V> Map<K, V> convertirAMapa(Collection<T> collection, Function<T, K> keyMapper, Function<T, V> valueMapper) {
        return collection.stream().collect(Collectors.toMap(keyMapper, valueMapper));
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // Map<Integer, String> mapaIdNombre = StreamUtils.convertirAMapa(listaDeEmpleados, Empleado::getId, Empleado::getNombre);
    // mapaIdNombre será un mapa donde la clave es el ID del empleado y el valor es su nombre. Por ejemplo, {1="Ana Martínez", 2="Carlos López", ...}.

    public static <T> Optional<T> encontrarPrimeroQueCumpla(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream().filter(predicate).findFirst();
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // Optional<Empleado> primerEmpleadoMayorDe40 = StreamUtils.encontrarPrimeroQueCumpla(listaDeEmpleados, empleado -> empleado.getEdad() > 40);
    // Devolverá el primer empleado en la lista que tenga una edad mayor de 40, o un Optional vacío si no hay ninguno.

    public static <T> List<T> obtenerElementosMientrasCumplen(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream().takeWhile(predicate).collect(Collectors.toList());
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados ordenada por edad: [Ana(28), Sofía(29), Miguel(31), ...]:
    // List<Empleado> empleadosMientrasMenoresDe35 = StreamUtils.obtenerElementosMientrasCumplen(listaDeEmpleados, empleado -> empleado.getEdad() < 35);
    // empleadosMientrasMenoresDe35 contendrá [Ana(28), Sofía(29), Miguel(31)]. Se detiene al encontrar el primer empleado que no cumple la condición.

    public static <T> List<T> obtenerElementosHastaQueCumplen(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream().dropWhile(predicate).collect(Collectors.toList());
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados ordenada por edad: [Ana(28), Sofía(29), Miguel(31), Laura(42), ...]:
    // List<Empleado> empleadosDesdeEdad40 = StreamUtils.obtenerElementosHastaQueCumplen(listaDeEmpleados, empleado -> empleado.getEdad() < 40);
    // empleadosDesdeEdad40 contendrá [Laura(42), ...]. Se salta los empleados mientras cumplan la condición.

    public static <T, K, V> Map<K, List<V>> agruparYMapear(Collection<T> collection, Function<T, K> keyMapper, Function<T, V> valueMapper) {
        return collection.stream().collect(Collectors.groupingBy(keyMapper, Collectors.mapping(valueMapper, Collectors.toList())));
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // Map<Integer, List<String>> nombresPorEdad = StreamUtils.agruparYMapear(listaDeEmpleados, Empleado::getEdad, Empleado::getNombre);
    // nombresPorEdad será un mapa donde la clave es la edad y el valor es una lista de los nombres de los empleados con esa edad. Por ejemplo, {28=["Ana Martínez"], 35=["Carlos López"], 42=["Laura García"]}.

    public static <T, K, V> Map<K, Set<V>> agruparYObtenerSet(Collection<T> collection, Function<T, K> keyMapper, Function<T, V> valueMapper) {
        return collection.stream().collect(Collectors.groupingBy(keyMapper, Collectors.mapping(valueMapper, Collectors.toSet())));
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // Map<Character, Set<Integer>> edadesPorInicialNombre = StreamUtils.agruparYObtenerSet(listaDeEmpleados, empleado -> empleado.getNombre().charAt(0), Empleado::getEdad);
    // edadesPorInicialNombre será un mapa donde la clave es la primera letra del nombre y el valor es un conjunto de las edades de los empleados cuyo nombre comienza con esa letra. Por ejemplo, {'A'=[28], 'C'=[35], 'L'=[42]}.

    public static <T, U> U reducirConIdentidadDiferente(Collection<T> collection, U identity, BiFunction<U, T, U> accumulator) {
        return collection.stream().reduce(identity, accumulator, (a, b) -> b);
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // String nombresConcatenados = StreamUtils.reducirConIdentidadDiferente(listaDeEmpleados, "Nombres: ", (texto, empleado) -> texto + empleado.getNombre() + ", ");
    // nombresConcatenados contendrá una cadena con todos los nombres de los empleados concatenados, precedidos por "Nombres: ". Por ejemplo, "Nombres: Ana Martínez, Carlos López, Laura García, ".

    public static <T> Optional<T> reducirSinIdentidad(Collection<T> collection, BinaryOperator<T> accumulator) {
        return collection.stream().reduce(accumulator);
    }
    // Ejemplo de uso:
    // Suponiendo que tienes una List<Empleado> llamada listaDeEmpleados:
    // Optional<Empleado> empleadoConSalarioMaximoReduce = StreamUtils.reducirSinIdentidad(listaDeEmpleados, (e1, e2) -> e1.getSalario() > e2.getSalario() ? e1 : e2);
    // empleadoConSalarioMaximoReduce contendrá el empleado con el salario más alto (si la lista no está vacía).

    public static <K extends Comparable<? super K>, V> List<V> obtenerValoresOrdenadosPorClave(Map<K, V> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.<K, V>comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
    // Ejemplo de uso:
    // Suponiendo que tienes un Map<Integer, String> llamado empleadoIdNombreMap que mapea IDs de empleados a sus nombres:
    // Map<Integer, String> empleadoIdNombreMap = Map.of(3, "Carlos", 1, "Ana", 2, "Beatriz");
    // List<String> nombresOrdenadosPorId = StreamUtils.obtenerValoresOrdenadosPorClave(empleadoIdNombreMap);
    // nombresOrdenadosPorId contendrá ["Ana", "Beatriz", "Carlos"], ya que los nombres se ordenan según las claves (los IDs).

    public static <K, V> Map<V, K> invertirMapa(Map<K, V> map) {
        return map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }
    // Ejemplo de uso:
    // Suponiendo que tienes un Map<Integer, String> llamado empleadoIdNombreMap:
    // Map<Integer, String> empleadoIdNombreMap = Map.of(1, "Ana", 2, "Carlos", 3, "Ana");
    // Map<String, Integer> nombreIdMap = StreamUtils.invertirMapa(empleadoIdNombreMap);
    // nombreIdMap contendrá {"Ana"=3, "Carlos"=2}. Si hay claves duplicadas en los valores, se conservará la última clave asociada a ese valor.

    public static <K, V> Map<K, V> filtrarMapaPorClave(Map<K, V> map, Predicate<K> keyPredicate) {
        return map.entrySet().stream().filter(entry -> keyPredicate.test(entry.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    // Ejemplo de uso:
    // Suponiendo que tienes un Map<Integer, String> llamado empleadoIdNombreMap:
    // Map<Integer, String> empleadoIdNombreMap = Map.of(1, "Ana", 2, "Carlos", 3, "Laura", 4, "Sofía");
    // Map<Integer, String> empleadosConIdPar = StreamUtils.filtrarMapaPorClave(empleadoIdNombreMap, id -> id % 2 == 0);
    // empleadosConIdPar contendrá {2="Carlos", 4="Sofía"}, ya que solo se incluyen las entradas con claves pares.

    public static <T, K> Map<K, Long> contarPorClave(Collection<T> collection, Function<T, K> keyMapper) {
        return collection.stream().collect(Collectors.groupingBy(keyMapper, Collectors.counting()));
    }
    // Ejemplo de uso:
    // Map<String, Long> conteoNombres = StreamUtils.contarPorClave(listaDeEmpleados, Empleado::getNombre);
    // conteoNombres.forEach((nombre, cantidad) -> System.out.println(nombre + ": " + cantidad));

    public static <T> Optional<T> obtenerElementoAleatorio(Collection<T> collection) {
        if (collection.isEmpty()) {
            return Optional.empty();
        }
        Random random = new Random();
        int randomIndex = random.nextInt(collection.size());
        return collection.stream().skip(randomIndex).findFirst();
    }
    // Ejemplo de uso:
    // Optional<Empleado> empleadoAleatorio = StreamUtils.obtenerElementoAleatorio(listaDeEmpleados);
    // empleadoAleatorio.ifPresent(empleado -> System.out.println("Empleado aleatorio: " + empleado.getNombre()));

    public static <T> List<List<T>> particionarEnSublistas(List<T> list, int tamanioSublista) {
        if (tamanioSublista <= 0) {
            throw new IllegalArgumentException("El tamaño de la sublista debe ser positivo.");
        }
        List<List<T>> sublistas = new ArrayList<>();
        for (int i = 0; i < list.size(); i += tamanioSublista) {
            sublistas.add(list.subList(i, Math.min(i + tamanioSublista, list.size())));
        }
        return sublistas;
    }
    // Ejemplo de uso:
    // List<List<Empleado>> gruposDeEmpleados = StreamUtils.particionarEnSublistas(listaDeEmpleados, 3);
    // gruposDeEmpleados.forEach(grupo -> System.out.println("Grupo: " + grupo));

    
    
/*    public static Set<DayOfWeek> obtenerDiasDeLaSemana(List<Empleado> empleados) {
        return empleados.stream()
                .map(Empleado::getFechaContratacion)
                .map(java.time.LocalDate::getDayOfWeek)
                .collect(Collectors.toSet());
    }*/
    // Ejemplo de uso:
    // Set<DayOfWeek> diasContratacion = StreamUtils.obtenerDiasDeLaSemana(listaDeEmpleados);
    // System.out.println("Días de contratación: " + diasContratacion);

}
