/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author carlos
 */
public class README {

    /*
ENUNCIADO TAREA 5C    
Crea un proyecto nuevo llamado Tarea5C+tunombre. Dentro del paquete daw, 
crea las clases necesarias para resolver el siguiente supuesto.
    
Se necesita desarrollar un programa que administre alumnos y los cursos en 
los que están matriculados. Para ello, a partir de sendas listas 
de alumnos (nombre y nif) y listas de cursos (nombre y número de horas), 
en las que puede haber elementos repetidos, 
 se deben obtener estructuras con instancias únicas de ambos tipos. 
 El instituto quiere mantener qué alumnos/as están 
 matriculados/as en cada curso y qué cursos tiene un alumno concreto. 
Para ello, debes permitir matricular y desmatricular 
alumnado en los diferentes cursos. Para ello puedes usar estructuras MAP, 
una asociando el nif del alumno a sus cursos matriculados 
y otra asociando el nombre del curso al conjunto de alumnos que están matriculados en él.
Finalmente, guarda en una estructura apropiada 
el total de horas que cursa cada alumno e imprime por pantalla , siguiendo el siguiente formato. 
Ten en cuenta que los NIFS deben estar ordenados alftabéticamente:
NIF: 22223333F ---> Nº HORAS: 340
NIF: 22223355F ---> Nº HORAS: 140 
NIF: 11123355F ---> Nº HORAS: 55
...
Los datos te los puedes inventar y no hace falta pedir nada por teclado.*/

 /*
    ************************************************************************************************************
   README 
   Este proyecto implementa un sistema de gestión de matriculas para administrar alumnos y los cursos en los 
    que están matriculados. El sistema permite mantener un registro de alumnos únicos (sin repeticiones) 
    y cursos únicos, así como la relación entre ellos (qué alumnos están matriculados en qué cursos y viceversa).
Clases Principales
1. Alumno
Representa a un estudiante con nombre y NIF.
Atributos:

nombre: String - El nombre completo del alumno
nif: String - El número de identificación fiscal del alumno (único)

Métodos principales:

Constructor: Crea un nuevo alumno con nombre y NIF
Getters y setters: Para acceder y modificar los atributos
equals(): Compara alumnos basándose únicamente en su NIF
hashCode(): Genera un código hash basado en el NIF
toString(): Devuelve una representación en texto del alumno

2. Curso
Representa un curso académico con nombre y número de horas.
Atributos:

nombre: String - El nombre del curso (único)
horas: int - El número de horas del curso

Métodos principales:

Constructor: Crea un nuevo curso con nombre y horas
Getters y setters: Para acceder y modificar los atributos
equals(): Compara cursos basándose únicamente en su nombre
hashCode(): Genera un código hash basado en el nombre
toString(): Devuelve una representación en texto del curso

3. GestorMatricula
Esta es la clase principal que gestiona toda la lógica del sistema.
Estructuras de datos utilizadas:

alumnos: Set<Alumno> - Conjunto de alumnos únicos
cursos: Set<Curso> - Conjunto de cursos únicos
matriculasAlumno: Map<String, Set<Curso>> - Mapa que asocia el NIF de cada 
    alumno con el conjunto de cursos en los que está matriculado
alumnosPorCurso: Map<String, Set<Alumno>> - Mapa que asocia el nombre 
    de cada curso con el conjunto de alumnos matriculados en él

Métodos principales:

agregarAlumno(Alumno): Añade un alumno al sistema si no existe ya
agregarCurso(Curso): Añade un curso al sistema si no existe ya
matricular(String nif, String nombreCurso): Matricula a un alumno en un curso
desmatricular(String nif, String nombreCurso):
    Desmatricula a un alumno de un curso
imprimirHorasPorAlumno(): 
    Calcula e imprime el total de horas que cursa cada alumno, ordenado por NIF
getCursosDeAlumno(String nif): Devuelve los cursos en los que está matriculado un alumno
getAlumnosDeCurso(String nombreCurso): Devuelve los alumnos matriculados en un curso
Getters para obtener las colecciones completas

4. Principal
Clase con el método main() que crea instancias de las otras clases 
    y demuestra el funcionamiento del sistema.
Funcionalidades Principales

Gestión de Alumnos y Cursos:

Añadir alumnos al sistema (sin permitir NIFs duplicados)
Añadir cursos al sistema (sin permitir nombres duplicados)


Gestión de Matrículas:

Matricular alumnos en cursos
Desmatricular alumnos de cursos
Consultar en qué cursos está matriculado un alumno
Consultar qué alumnos están matriculados en un curso


Cálculo e Impresión de Horas:

Calcular el total de horas que cursa cada alumno
Imprimir los resultados ordenados alfabéticamente por NIF



Implementación de Estructuras de Datos

HashSet: Utilizado para almacenar alumnos y cursos sin repeticiones, 
    aprovechando la sobrescritura de los métodos equals() y hashCode() en ambas clases.
HashMap: Utilizado para asociar NIFs con conjuntos de cursos y 
    nombres de cursos con conjuntos de alumnos.
ArrayList y Collections.sort(): Utilizados para ordenar los resultados 
    de las horas cursadas por NIF.*/
    
    public static void main(String[] args) {

        System.out.println("README del ejercicio 5C");
    }

}
