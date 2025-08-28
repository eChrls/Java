# VideoClubDAW

## Descripción general

Soy el desarrollador de VideoClubDAW, una aplicación de escritorio Java Swing para la gestión de un videoclub. Permite gestionar usuarios, películas, fichas técnicas y alquileres, diferenciando entre usuarios normales y administradores.

---

## Funcionamiento paso a paso de la aplicación

### 1. Configuración inicial
- Abre **MySQL Workbench**.
- Crea un usuario `pruebas` con contraseña `pruebas`.
- Crea la base de datos y ejecuta el script `videoclubdaw.sql` que está en la carpeta `src` del proyecto.

### 2. Login y gestión de acceso
- Inicia la aplicación.
- Accede con usuario `admin` y contraseña `1234`.
- Si olvidas la contraseña, puedes dar de alta un usuario desde el login. 

### 3. Recorrido funcional recomendado (en orden)
1. **Crear usuario de prueba** (antes de intentar editar/eliminar usuarios).
2. **Editar usuario** (modifica datos de un usuario existente).
3. **Eliminar usuario** (solo si existe y no es el admin principal).
4. **Crear película** (antes de añadir fichas técnicas).
5. **Editar película** (modifica datos de una película existente).
6. **Eliminar película** (solo si no tiene ficha técnica ni alquileres activos).
7. **Añadir ficha técnica** (solo a películas sin ficha).
8. **Editar ficha técnica** (modifica género o descripción).
9. **Eliminar ficha técnica** (solo si existe).
10. **Ver películas** (catálogo, thumbnails, ampliación de imagen, acceso a ficha técnica).
11. **Alquilar película** (usuarios normales).
12. **Consultar alquileres activos**.
13. **Devolver película**.
14. **Ver/editar perfil**.
15. **Cerrar sesión**.
16. **Salir de la aplicación**.

---

## Clases principales y su función

### Controladores
- **UsuarioController**: CRUD de usuarios.
- **PeliculaController**: CRUD de películas.
- **FichaTecnicaController**: CRUD de fichas técnicas, asociadas a películas.
- **AlquilerController**: Gestión de alquileres (alta, devolución, consulta).

### Entidades
- **Usuario**: Datos de usuario (nombre, email, contraseña).
- **Pelicula**: Datos de película (título, año, portada), relación con ficha técnica y alquileres.
- **FichaTecnica**: Género y descripción, asociada a una película.
- **Alquiler**: Relación usuario-película, con fechas de alquiler y devolución.

### Vistas
- **MainFrame**: Ventana principal, muestra menú según rol.
- **VerPeliculasDialog**: Catálogo de películas con thumbnails y ficha técnica.
- **FormularioPeliculaDialog**: Alta/edición de películas.
- **FormularioUsuarioDialog**: Alta/edición de usuarios.
- **GestionFichasDialog**: Gestión de fichas técnicas (añadir solo a películas sin ficha, editar, eliminar).
- **FormularioFichaDialog**: Alta/edición de fichas técnicas.
- **VerFichaTecnicaDialog**: Visualización de ficha técnica con imagen.

---

## Interconexión entre clases

- Las **vistas** llaman a los **controladores** para realizar operaciones de base de datos.
- Los **controladores** gestionan las entidades y la lógica de negocio.
- Las **entidades** representan las tablas de la base de datos y sus relaciones.
- Ejemplo: al añadir una ficha técnica, el formulario usa `FichaTecnicaController` y `PeliculaController` para asociarla a una película existente.

---

## Problemas detectados y soluciones

- **Añadir ficha técnica a película inexistente**:  
  Antes se permitía, causando errores. Ahora solo se puede añadir a películas ya existentes y sin ficha.
- **Imagen no visible en ficha técnica**:  
  Problemas de mayúsculas/minúsculas en nombres de archivo y layouts. Solucionado usando el mismo código que para thumbnails y forzando el repintado.
- **Edición de usuario crea uno nuevo**:  
  Se corregió pasando el usuario seleccionado al formulario de edición.
- **Otros**:  
  Ajustes en scroll de JTextArea, renderizado de imágenes, métodos duplicados, validación de campos.

---

## ¿Por qué no hay capa Service?

Este proyecto es pequeño y la lógica de negocio es sencilla. Los controladores encapsulan el acceso a datos y la lógica, y las vistas interactúan directamente con ellos. Añadir una capa Service complicaría el diseño sin aportar ventajas claras, por lo que se ha optado por una arquitectura simple y eficiente.

---
## Notas

- El campo de película en ficha técnica es solo lectura y se rellena automáticamente al seleccionar la película.
- Solo se puede añadir ficha técnica a películas existentes y sin ficha.
- Las imágenes deben estar en `/img/` dentro de `src/main/resources`.
- El admin por defecto es `admin/1234`.



