// script.js

document.addEventListener("DOMContentLoaded", () => {
    // === Referencias a elementos del DOM ===
    // Áreas de texto para XML y XSD
    const xmlText = document.getElementById("xmlText");
    const xsdText = document.getElementById("xsdText");
    // Inputs de archivo para cargar XML y XSD
    const xmlFile = document.getElementById("xmlFile");
    const xsdFile = document.getElementById("xsdFile");
    // Botones de acción
    const validateBtn = document.getElementById("validateBtn");
    const downloadXml = document.getElementById("downloadXml");
    const downloadXsd = document.getElementById("downloadXsd");
    // Elementos para mostrar resultados y spinner de carga
    const resultText = document.getElementById("resultText");
    const spinner = document.getElementById("spinner");

    // === Habilitar el botón de validar al cargar la página ===
    // xmllint.js ya está listo tras cargar el script, así que habilitamos el botón
    validateBtn.disabled = false;

    // === Función para leer un archivo y mostrarlo en el textarea correspondiente ===
    function readFile(file, textarea) {
        const reader = new FileReader();
        reader.onload = e => textarea.value = e.target.result;
        reader.readAsText(file);
    }

    // === Cargar archivos XML y XSD desde el sistema de archivos ===
    xmlFile.onchange = e => readFile(e.target.files[0], xmlText);
    xsdFile.onchange = e => readFile(e.target.files[0], xsdText);

    // === Función para descargar el contenido de un textarea como archivo ===
    function downloadFile(filename, content) {
        const blob = new Blob([content], { type: "application/xml" });
        const a = document.createElement("a");
        a.href = URL.createObjectURL(blob);
        a.download = filename;
        a.click();
        URL.revokeObjectURL(a.href);
    }

    // === Botones para descargar el XML y el XSD editados ===
    downloadXml.onclick = () => downloadFile("documento.xml", xmlText.value);
    downloadXsd.onclick = () => downloadFile("esquema.xsd", xsdText.value);

    // === Validación del XML contra el XSD al pulsar el botón ===
    validateBtn.onclick = () => {
        // Limpia el resultado anterior y muestra el spinner de carga
        resultText.textContent = "";
        spinner.classList.remove("hidden");

        // Ejecuta la validación tras un breve retardo para que el spinner se vea
        setTimeout(() => {
            try {
                // Llama a xmllint.validateXML con el contenido de los textareas
                const res = xmllint.validateXML({
                    xml: xmlText.value,
                    schema: xsdText.value
                });
                // Si hay errores, los muestra; si no, muestra mensaje de éxito
                if (res.errors) {
                    resultText.innerHTML = `❌ Errores:<br>${res.errors.join("<br>")}`;
                } else {
                    resultText.innerHTML = `✅ XML válido.`;
                }
            } catch (err) {
                // Si ocurre un error inesperado, lo muestra
                resultText.innerHTML = `⚠️ Error: ${err.message}`;
            } finally {
                // Oculta el spinner de carga
                spinner.classList.add("hidden");
            }
        }, 50);
    };
});
