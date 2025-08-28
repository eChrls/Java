# Validador DAW – XML ↔ XSD ↔ JSON

**Validador DAW** es una aplicación web local que permite validar archivos XML contra esquemas XSD de forma visual, rápida y sin necesidad de instalar software adicional ni depender de servidores externos. Está orientada a estudiantes y profesionales de Desarrollo de Aplicaciones Web (DAW) y utiliza la potencia de la librería `xmllint.js` (libxml2 portado a JavaScript) para realizar la validación directamente en el navegador.

---

## Características

- **Validación local**: Todo el proceso ocurre en tu navegador, sin enviar datos a internet.
- **Conversión a JSON**: Si el XML es válido, puedes convertirlo automáticamente a formato JSON con un solo clic.
- **Interfaz moderna y profesional**: Inspirada en herramientas como Figma, con diseño responsive y atractivo.
- **Edición y carga de archivos**: Puedes pegar, editar, cargar y descargar tus archivos XML y XSD.
- **Resultados claros**: Muestra errores de validación o confirmación de éxito de forma visual y fácil de entender.
- **Sin dependencias externas**: Solo necesitas abrir el archivo `index.html` en tu navegador.

---

## ¿Cómo funciona?

1. **Carga o pega tu XML y XSD**
   - Usa los campos de texto para pegar o editar el contenido de tus archivos.
   - O bien, utiliza los botones de "Cargar archivo" para seleccionar archivos `.xml` y `.xsd` desde tu ordenador.

2. **Valida**
   - Pulsa el botón **Validar**.
   - El sistema procesa ambos archivos y muestra el resultado de la validación en la parte inferior.
   - Si hay errores, se mostrarán detallados; si es válido, verás un mensaje de éxito.

3. **Convierte a JSON**
   - Si el XML es válido, el botón **Convertir a JSON** se habilita.
   - Haz clic en **Convertir a JSON** y el resultado en formato JSON aparecerá en la sección de resultados.

4. **Descarga tus archivos**
   - Puedes descargar el XML y el XSD editados con los botones correspondientes.

---

## ¿Qué tecnologías utiliza?

- **HTML, CSS y JavaScript puro**: No requiere frameworks ni servidores.
- **[xmllint.js](https://github.com/syssgx/xml.js/)**: Port de libxml2 para validación XML/XSD en navegador.
- **Google Fonts (Inter)**: Tipografía moderna y legible.

---

## Instalación y uso

1. **Descarga o clona el repositorio.**
2. Asegúrate de tener los archivos `index.html`, `styles.css`, `script.js` y `xmllint.js` en la misma carpeta.
3. Abre `index.html` en tu navegador favorito (Chrome, Edge, Firefox...).
4. ¡Listo! Ya puedes validar y convertir tus archivos XML ↔ XSD ↔ JSON de forma local y segura.

---

## Ejemplo de uso

1. Copia tu XML y tu XSD en los campos correspondientes o cárgalos desde tu equipo.
2. Haz clic en **Validar**.
3. Observa el resultado en la sección "Resultado":
   - Si es válido:
     `✅ XML válido.`
   - Si hay errores:
     `❌ Errores:`
     *(se listarán los errores encontrados)*
4. Si el XML es válido, haz clic en **Convertir a JSON** para ver la conversión automática a formato JSON.

---

## Notas técnicas

- La validación es estricta y sigue el estándar XSD 1.0, igual que la herramienta de línea de comandos `xmllint`.
- Todo el procesamiento es local: tus archivos no salen de tu equipo.
- Si tienes problemas con la carga de archivos, asegúrate de estar usando un navegador moderno y que todos los archivos estén en la misma carpeta.
- La conversión a JSON es básica y orientada a estructuras simples; para XMLs muy complejos, revisa el resultado antes de usarlo en producción.

