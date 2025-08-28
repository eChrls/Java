# InterfacesJTable: Gestión de Estudiantes con JTable

## Descripción

Esta aplicación Java Swing permite gestionar una lista de estudiantes leída desde un archivo CSV, mostrando los datos en una tabla (`JTable`). El usuario puede consultar la información y editar el **nombre** de un estudiante mediante un diálogo modal (no directamente en la tabla). Todos los cambios se reflejan de inmediato en la interfaz gráfica y se guardan de forma persistente en el archivo CSV.

## Estructura del Proyecto

```
InterfacesJTable/
├── src/
│   ├── InterfacesJTable/
│   │   ├── InterfazGrafica.java
│   │   ├── modelos/
│   │   │   ├── Student.java
│   │   │   ├── StudentList.java
│   │   │   └── StudentTableModel.java
│   │   ├── utils/
│   │   │   └── CSVReader.java
│   │   └── vistas/
│   │       ├── MainWindow.java
│   │       └── EditDialog.java
│   └── resources/
│       └── RegAlum.csv
└── pom.xml
```

## Funcionalidades principales

- **Carga automática de datos:** Al iniciar, se leen hasta 25 estudiantes nacidos antes de 2005 desde `RegAlum.csv`.
- **Visualización:** Los datos se muestran en un `JTable` no editable directamente.
- **Edición controlada:**  
  - Para editar el **nombre** de un estudiante, selecciónalo en la tabla y pulsa el botón **Actualizar**. Se abrirá un diálogo modal donde puedes modificar el nombre y guardar o cancelar los cambios.
  - No se permite editar ninguna celda directamente en la tabla.
- **Persistencia:**  
  - Todos los cambios guardados se escriben automáticamente en el archivo CSV, de modo que al reiniciar la aplicación los datos editados permanecen.
- **Refresco automático:**  
  - Los cambios se reflejan de inmediato en la tabla y se imprimen por consola para comprobación.

## Componentes principales

- **Student.java:** POJO que representa a un estudiante (id, nombre, localidad, unidad, fecha de nacimiento, sexo, país).
- **StudentList.java:** Gestiona la lista de estudiantes, carga desde CSV, guarda cambios y permite búsquedas.
- **StudentTableModel.java:** Modelo de tabla que conecta la lista real de estudiantes con el `JTable` (sin duplicar datos).
- **CSVReader.java:** Utilidad para leer y parsear estudiantes desde el CSV.
- **MainWindow.java:** Ventana principal con el `JTable`, botón "Actualizar" y lógica de interacción.
- **EditDialog.java:** Diálogo modal para editar el nombre de un estudiante seleccionado.

## Uso

1. **Compila y ejecuta el proyecto** (Maven o desde tu IDE).
2. **Al abrir la aplicación**, verás la tabla con los 25 primeros estudiantes nacidos antes de 2005.
3. **Para editar un nombre:**
   - Selecciona una fila en la tabla.
   - Haz clic en el botón **Actualizar**.
   - Modifica el nombre en el diálogo y pulsa **Guardar**.
4. El cambio se reflejará en la tabla y se guardará en el archivo CSV automáticamente.


## Interconexión entre Componentes

La aplicación sigue una estructura modular donde cada clase cumple una función clara y todas están conectadas para asegurar la coherencia de los datos:

- **Inicio:** La clase principal (`InterfazGrafica`) crea la ventana principal (`MainWindow`), que es el centro de la interacción.

- **Gestión de datos:** `MainWindow` utiliza una instancia de `StudentList` para cargar y gestionar los estudiantes desde el CSV.

- **Visualización:** El modelo de tabla (`StudentTableModel`) accede directamente a la lista de `StudentList`, asegurando que cualquier 
cambio en los datos se refleje de inmediato en el `JTable`.

- **Edición:** Al pulsar el botón "Actualizar", se abre un `EditDialog` modal con el estudiante seleccionado. Los cambios realizados
 se guardan en la lista, se actualizan en la tabla y se escriben en el CSV.

- **Comunicación:** Todos los componentes se comunican pasando referencias directas (por ejemplo, el estudiante a editar 
o la lista de estudiantes), evitando duplicidades y garantizando que los cambios sean consistentes en toda la aplicación.



---
Respuesta de Perplexity: pplx.ai/share

## Notas técnicas

- El modelo de tabla (`StudentTableModel`) accede siempre a la lista real de estudiantes, asegurando que cualquier cambio se refleje de inmediato.
- El método `equals` de `Student` compara solo por `id`, para garantizar la correcta identificación incluso tras cambios de nombre.
- El archivo `RegAlum.csv` debe estar presente en la raíz del proyecto o en la ruta especificada en el código.
- El código está estructurado siguiendo buenas prácticas de separación de responsabilidades y claridad de paquetes.

