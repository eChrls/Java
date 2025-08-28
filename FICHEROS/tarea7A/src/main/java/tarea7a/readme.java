/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/package-info.java to edit this template
 */
package tarea7a;

//Explicación:
//
//Se crea la lista de vehículos leyendo el archivo CSV
//Se muestran algunos vehículos para verificar que la lectura funcionó correctamente
//Se obtienen y muestran los fabricantes de coches verdes de 2007
//Se cuenta la cantidad de vehículos por color
//Se guarda este conteo en un nuevo archivo CSV
//
//4. Conceptos clave explicados
//4.1 Lectura de archivos CSV
//El CSV (Comma-Separated Values) es un formato que almacena datos separados por comas. Para leerlo en Java:
//
//Creamos un BufferedReader para leer línea por línea
//Descartamos la primera línea (encabezados)
//Dividimos cada línea usando split(",")
//Convertimos cada parte al tipo adecuado
//Creamos un objeto con estos datos
//
//4.2 Uso de Streams en Java
//Los Streams son una característica introducida en Java 8 que permite procesar secuencias de elementos de manera declarativa. En nuestro código:
//
//filter: Selecciona elementos según una condición (v.año() == 2007)
////map: Transforma cada elemento (Vehiculo → String de la marca)
//collect: Acumula elementos en una estructura (toSet(), groupingBy())
//forEach: Ejecuta una acción para cada elemento
//
//4.3 Manipulación de colecciones
//
//List: Almacenamos los vehículos en orden y permitiendo duplicados
//Set: Usamos para obtener marcas únicas (sin duplicados)
////Map: Usamos para contar ocurrencias (color → cantidad)
//TreeMap: Un tipo de Map que mantiene las claves ordenadas
//
//4.4 Escritura de archivos
//Para escribir el archivo CSV:
//
//Usamos BufferedWriter para escribir línea por línea
//Escribimos primero una línea de encabezados
//Recorremos el mapa y escribimos cada par clave-valor
//Manejamos excepciones adecuadamente
//
//5. Comparación con tu código original
//Tu código original tenía algunos problemas:
//
//No completaba la lectura del archivo
//No convertía adecuadamente los datos
//No implementaba las operaciones con Streams
//No tenía un método principal funcional
//
//La solución proporcionada aborda todos estos problemas y cumple con todos los requisitos del ejercicio.
//6. Recomendaciones para mejorar
//
//Manejo de errores: Implementa una mejor estrategia para manejar errores, como registrarlos o lanzar excepciones personalizadas.
//Validación de datos: Añade validación para los datos leídos del CSV.
//Configuración externa: Considera usar archivos de propiedades para configurar nombres de archivos y otros parámetros.
//Pruebas unitarias: Implementa pruebas para verificar que cada método funciona correctamente.
