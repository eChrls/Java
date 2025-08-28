Proyecto: tareaA37 (API Chistes con GUI)
Paquete principal: apiChistes
Objetivo: Aplicación de escritorio (Swing) que solicita al usuario idioma, categoría y cantidad de chistes, realiza petición HTTP GET a JokeAPI, parsea JSON con Jackson y muestra los chistes en un JTextArea.

1. Estructura de paquetes:

   * apiChistes\conexion\_http

     * ConexionHTTP.java
   * apiChistes\serviciojson

     * JsonService.java
   * apiChistes\modelos

     * Flags.java
     * Joke.java
   * apiChistes\modelos2

     * Flags.java
     * Joke.java
     * ListaChistes.java
   * apiChistes

     * ChisteGUI.java

2. Descripción de clases y métodos:

\--- ConexionHTTP.java ---
Clase que gestiona la conexión con la API usando peticiones HTTP GET. Utiliza la clase java.net.URL, que forma parte de la biblioteca estándar de Java y representa direcciones URL. La comunicación con el resto del proyecto ocurre porque esta clase es invocada directamente desde la interfaz gráfica (ChisteGUI) para recuperar los datos JSON.

Método:

* peticionHttpGet(String urlStr): Abre una conexión, recupera el contenido de la respuesta en formato JSON, lo convierte en String y lo devuelve.

\--- JsonService.java ---
Esta clase convierte un String JSON en un objeto Java (POJO). Está diseñada como genérica (<T>) para permitir convertir diferentes tipos de respuestas de la API (una sola o una lista de chistes) sin duplicar código. Devuelve objetos específicos según el tipo que se indique al invocar el método.

Método:

* stringToPojo(String json, Class<T> clase): Usa ObjectMapper de Jackson para transformar el JSON en un objeto del tipo especificado.

\--- modelos.Flags.java ---
Representa los indicadores de contenido sensible (como nsfw o political). los métodos getter/setter permiten acceso y modificación a las propiedades si fueran necesarias desde otras clases.

Métodos:

* toString(): Devuelve una representación en texto de los valores de los flags.

\--- modelos.Joke.java ---
Representa un chiste individual. Incluye datos como setup, delivery, categoría, etc. El método toString devuelve el contenido del chiste con formato simple para mostrar en pantalla. Esta clase se usa cuando se solicita un único chiste a la API.

\--- modelos2.Flags.java y modelos2.Joke.java ---
Son copias funcionales de los anteriores pero están separados porque el JSON de lista de chistes puede requerir un mapeo distinto. Se separan para evitar conflictos de nombres y mejorar la claridad.

\--- modelos2.ListaChistes.java ---
Clase que representa una respuesta de la API que contiene varios chistes. Contiene una lista de objetos Joke. Se utiliza para parsear respuestas múltiples.

Método:

* getJokes(): Devuelve la lista de chistes para iterar y mostrar.

\--- ChisteGUI.java ---
Clase que representa la interfaz gráfica. Usa componentes Swing, generados en parte por el asistente de NetBeans (initComponents). Se encarga de recoger la entrada del usuario, hacer la petición y mostrar los resultados.

Métodos clave:

* initComponents(): Configura la interfaz.
* obtenerChistes():

  * Lee idioma, categoría y cantidad del usuario.
  * Valida que la cantidad esté entre 2 y 5 usando Integer.parseInt() y comprobando el rango. Si se sale del rango, lanza NumberFormatException.
  * Construye la URL con String.format usando los valores ingresados.
  * Llama a ConexionHTTP para hacer la petición y obtener el JSON.
  * Pasa el JSON a JsonService para convertirlo a ListaChistes.
  * Recorre cada Joke y usa toString() para mostrar el texto en el área de resultados.
* main(): Lanza la aplicación usando SwingUtilities.invokeLater().

3. Otros detalles importantes:

* La construcción de la URL se realiza con String.format para mantener la estructura dinámica y clara.
* La validación del número de chistes permite controlar errores tempranos y asegurar una buena experiencia de usuario.
* La separación entre modelos y modelos2 permite gestionar correctamente la diferencia en el tipo de respuesta de la API.
* La clase principal se declara en el pom.xml con la propiedad \<exec.mainClass> para que Maven sepa qué clase ejecutar al usar el plugin exec.

4. Instrucciones de uso en NetBeans:

* Importar el proyecto como proyecto Maven.
* Confirmar que el POM incluye las dependencias de Jackson necesarias.
* Ejecutar el proyecto desde NetBeans o desde terminal con mvn compile exec\:java.
* Usar la interfaz para introducir idioma, categoría y número de chistes, luego pulsar "Obtener Chistes".

Fin del README.

