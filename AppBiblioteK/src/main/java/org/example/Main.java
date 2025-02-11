// import org.example.*;

/*
"Sistema de Biblioteca Personal"
Clases necesarias:
Libro (objeto básico)
Usuario (objeto básico)
CatalogoLibros (gestión de libros)
GestionUsuarios (gestión de usuarios)
Prestamo (objeto para registrar préstamos)
Biblioteca (clase que relaciona todo)
Main (AppBiblioteca)

Funcionalidades a implementar:
Calcular la edad del usuario a partir de su fecha de nacimiento
Calcular días de retraso en la devolución de un libro
Buscar libros por título o autor
Mostrar libros prestados a un usuario
Gestionar préstamos y devoluciones
Calcular multas por retraso (1€ por día)

El ejercicio debe cumplir estos requisitos:
Un usuario no puede tener más de 3 libros prestados a la vez
El período de préstamo es de 14 días
Los libros se identifican por ISBN único
Los usuarios se identifican por DNI único
Las búsquedas deben ignorar mayúsculas/minúsculas

En el main deberás:
Crear algunos libros y usuarios
Realizar préstamos
Simular devoluciones (algunas con retraso)++
Mostrar estado del sistema
*/

// public static void main(String[] args) {

//     GestionUsuarios gestionUsuarios = new GestionUsuarios();
//     Usuario usuario1 = gestionUsuarios.agregarUsuario("12345678Z", "Juan", LocalDate.of(1980, 1, 1));
//     Usuario usuario2 = gestionUsuarios.agregarUsuario("98765432X", "Maria", LocalDate.of(1990, 12, 15));
//     Usuario usuario3 = gestionUsuarios.agregarUsuario("76543210W", "Pedro", LocalDate.of(1995, 5, 10));
//     Usuario usuario4 = gestionUsuarios.agregarUsuario("32109876V", "Ana", LocalDate.of(1998, 7, 20));
//     Usuario usuario5 = gestionUsuarios.agregarUsuario("54321098T", "Luis", LocalDate.of(2000, 9, 25));


//     CatalogoLibros catalogoLibros = new CatalogoLibros();

//     Libro libro1 = new Libro("978-84-317-7161-0", "Java 8", "Joshua Bloch", false);
//     Libro libro2 = new Libro("978-0321-99278-0", "Clean Code", "Robert C. Martin", false);
//     Libro libro3 = new Libro("978-84-933988-17-1", "Effective Java", "Joshua Bloch", false);
//     Libro libro4 = new Libro("978-84-7199-857-0", "Refactoring: Improving the Design of Existing Code", "Martin Fowler", false);
//     Libro libro5 = new Libro("978-84-7775-376-0", "Clean Architecture", "Robert C. Martin", true);

//     catalogoLibros.agregarLibro(libro1);
//     catalogoLibros.agregarLibro(libro2);
//     catalogoLibros.agregarLibro(libro3);
//     catalogoLibros.agregarLibro(libro4);
//     catalogoLibros.agregarLibro(libro5);

//     Prestamo prestamo1 = Biblioteca.prestarLibro(1, libro2, usuario1, Calendar.getInstance().getTime(), false);
//     Prestamo prestamo2 = Biblioteca.prestarLibro(2, libro1, usuario2, Calendar.getInstance().getTime(), false);
//     Prestamo prestamo3 = Biblioteca.prestarLibro(3, libro3, usuario3, Calendar.getInstance().getTime(), false);

//     Biblioteca.devolverLibro(prestamo1, LocalDate.now().plusDays(7));
//     Biblioteca.devolverLibro(prestamo2, LocalDate.now().plusDays(14));
//     Biblioteca.devolverLibro(prestamo3, LocalDate.now().plusDays(30));

// }



