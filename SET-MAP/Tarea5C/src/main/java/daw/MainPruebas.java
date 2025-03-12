
package daw;


public class MainPruebas {
      public static void main(String[] args) {
        // Creamos una instancia de GestionAcademica para administrar alumnos y cursos
        GestorMatricula gestion = new GestorMatricula();
        
        // Creamos algunos alumnos (con datos inventados)
        // Nótese que algunos tienen el mismo NIF para probar que no se permiten duplicados
        Alumno alumno1 = new Alumno("Juan Pérez", "11123355F");
        Alumno alumno2 = new Alumno("María López", "22223333F");
        Alumno alumno3 = new Alumno("Pedro García", "22223355F");
        Alumno alumno4 = new Alumno("Ana Martín", "33334444G");
        Alumno alumno5 = new Alumno("Carlos Sánchez", "11123355F"); // NIF repetido
        
        // Creamos algunos cursos (con datos inventados)
        // Nótese que algunos tienen el mismo nombre para probar que no se permiten duplicados
        Curso curso1 = new Curso("Programación", 200);
        Curso curso2 = new Curso("Bases de Datos", 140);
        Curso curso3 = new Curso("Entornos de Desarrollo", 55);
        Curso curso4 = new Curso("Programación", 180); // Nombre repetido
        
        // Añadimos los alumnos a la gestión académica
        gestion.agregarAlumno(alumno1);
        gestion.agregarAlumno(alumno2);
        gestion.agregarAlumno(alumno3);
        gestion.agregarAlumno(alumno4);
        gestion.agregarAlumno(alumno5); // No se añadirá como duplicado
        
        // Añadimos los cursos a la gestión académica
        gestion.agregarCurso(curso1);
        gestion.agregarCurso(curso2);
        gestion.agregarCurso(curso3);
        gestion.agregarCurso(curso4); // No se añadirá como duplicado
        
        // Matriculamos alumnos en cursos
        gestion.matricular("11123355F", "Programación");
        gestion.matricular("11123355F", "Entornos de Desarrollo");
        gestion.matricular("22223333F", "Programación");
        gestion.matricular("22223333F", "Bases de Datos");
        gestion.matricular("22223355F", "Bases de Datos");
        gestion.matricular("33334444G", "Programación");
        gestion.matricular("33334444G", "Bases de Datos");
        gestion.matricular("33334444G", "Entornos de Desarrollo");
        
        // Desmatriculamos a un alumno de un curso
        gestion.desmatricular("33334444G", "Bases de Datos");
        
        // Imprimimos el total de horas que cursa cada alumno
        System.out.println("Total de horas por alumno (ordenado por NIF):");
        gestion.imprimirHorasPorAlumno();
    }
}
