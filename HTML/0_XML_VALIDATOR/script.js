// script.js

document.addEventListener("DOMContentLoaded", () => {

  // === Referencias a elementos del DOM ===
  const xmlText = document.getElementById("xmlText");
  const xsdText = document.getElementById("xsdText");
  const xmlFile = document.getElementById("xmlFile");
  const xsdFile = document.getElementById("xsdFile");
  const validateBtn = document.getElementById("validateBtn");
  const downloadXml = document.getElementById("downloadXml");
  const downloadXsd = document.getElementById("downloadXsd");
  const resultText = document.getElementById("resultText");
  const spinner = document.getElementById("spinner");
  const toJsonBtn = document.getElementById("toJsonBtn");

  // === Habilitar el botón de validar al cargar la página ===
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
    resultText.textContent = "";
    spinner.classList.remove("hidden");

    setTimeout(() => {
      try {
        const res = xmllint.validateXML({
          xml: xmlText.value,
          schema: xsdText.value
        });

        if (res.errors) {
          resultText.innerHTML = `❌ Errores:${res.errors.join("")}`;
          toJsonBtn.disabled = true;
        } else {
          resultText.innerHTML = `✅ XML válido.`;
          toJsonBtn.disabled = false;
        }
      } catch (err) {
        resultText.innerHTML = `⚠️ Error: ${err.message}`;
        toJsonBtn.disabled = true;
      } finally {
        spinner.classList.add("hidden");
      }
    }, 50);
  };

  // === Conversión de XML a JSON ===
  function xmlToJson(xml) {
    const parser = new DOMParser();
    const xmlDoc = parser.parseFromString(xml, "application/xml");
    function nodeToObject(node) {
      // Si es un nodo de texto
      if (node.nodeType === 3) return node.nodeValue.trim();
      // Si es un nodo de elemento
      const obj = {};
      if (node.attributes && node.attributes.length > 0) {
        obj["@attributes"] = {};
        for (let attr of node.attributes) {
          obj["@attributes"][attr.name] = attr.value;
        }
      }
      for (let child of node.childNodes) {
        if (child.nodeType === 3) {
          const text = child.nodeValue.trim();
          if (text) obj["#text"] = text;
        } else if (child.nodeType === 1) {
          const childObj = nodeToObject(child);
          if (!obj[child.nodeName]) {
            obj[child.nodeName] = childObj;
          } else {
            if (!Array.isArray(obj[child.nodeName])) {
              obj[child.nodeName] = [obj[child.nodeName]];
            }
            obj[child.nodeName].push(childObj);
          }
        }
      }
      return obj;
    }
    return nodeToObject(xmlDoc.documentElement);
  }

  // === Botón para convertir a JSON ===
  toJsonBtn.onclick = () => {
    try {
      const jsonObj = xmlToJson(xmlText.value);
      resultText.innerHTML = `<h2>Resultado JSON:</h2><pre>${JSON.stringify(jsonObj, null, 2)}</pre>`;
    } catch (err) {
      resultText.innerHTML = `⚠️ Error al convertir a JSON: ${err.message}`;
    }
  };

});
