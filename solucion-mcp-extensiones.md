# 🛠️ Configuración MCP y Extensiones - Solución Completa

## 🚨 **ERRORES DETECTADOS Y SOLUCIONES**

### **❌ Servidores MCP Problemáticos:**

- `my-mcp-server-796f638a` → **ELIMINAR** (ID corrupto)
- `imagesorcery` → **ELIMINAR** (no es MCP estándar)
- `figma` → **ELIMINAR** (plugin experimental inestable)

### **✅ Extensiones AI Instaladas (Correctas):**

- ✅ `github.copilot` (Agente principal - MANTENER)
- ✅ `github.copilot-chat` (Agente principal - MANTENER)
- ✅ `rooveterinaryinc.roo-cline` (Roo Code - MANTENER como solicitaste)
- ✅ `visualstudioexptteam.vscodeintellicode` (Útil para autocompletado)
- ✅ `devsense.intelli-php-vscode` (Específico PHP - MANTENER)

## 🔧 **COMANDOS DE LIMPIEZA ESPECÍFICOS**

### **1. Limpiar Configuración MCP Actual:**

```bash
# Respaldar configuración actual
copy "%APPDATA%\Code\User\globalStorage\ms-vscode.vscode-json\mcp-servers.json" "%APPDATA%\Code\User\globalStorage\ms-vscode.vscode-json\mcp-servers.json.backup"

# Aplicar nueva configuración (copiar el archivo mcp-config-optimizada.json)
copy "c:\Users\Casa\Documents\MiPC\Formación\DAW\PROGRAMACIÓN\NetBeansProjects\mcp-config-optimizada.json" "%APPDATA%\Code\User\globalStorage\ms-vscode.vscode-json\mcp-servers.json"
```

### **2. Verificar y Limpiar Cache MCP:**

```bash
# Limpiar cache MCP corrupto
rmdir /s /q "%APPDATA%\Code\CachedExtensions"
rmdir /s /q "%APPDATA%\Code\logs"

# Reiniciar VS Code completamente
taskkill /f /im Code.exe
```

### **3. Instalar MCPs Necesarios (si no están):**

```bash
# GitHub MCP Server
npm install -g @modelcontextprotocol/server-github

# Filesystem MCP Server
npm install -g @modelcontextprotocol/server-filesystem

# Brave Search MCP Server
npm install -g @modelcontextprotocol/server-brave-search
```

## ⚙️ **CONFIGURACIÓN GITHUB COPILOT COMO AGENTE PRINCIPAL**

### **Settings.json a añadir:**

```json
{
  "github.copilot.enable": {
    "*": true,
    "plaintext": true,
    "markdown": true,
    "scminput": false
  },
  "github.copilot.editor.enableAutoCompletions": true,
  "github.copilot.chat.enable": true,
  "github.copilot.advanced": {
    "length": 1000,
    "temperature": 0.1,
    "top_p": 1,
    "inlineSuggestEnable": true
  },
  "roo-cline.priority": "secondary",
  "roo-cline.autoActivate": false
}
```

## 🎯 **CONFIGURACIÓN MCP ROBUSTA (2-3 SERVIDORES)**

La nueva configuración incluye **SOLO** servidores probados y estables:

1. **GitHub MCP** → Gestión repositorios y PRs
2. **Filesystem MCP** → Operaciones de archivos locales
3. **Brave Search MCP** → Búsquedas web para desarrollo

### **Características:**

- ✅ **Autostart activado** → Se inician automáticamente
- ✅ **Timeout 30s** → Tiempo suficiente para operaciones
- ✅ **Logging habilitado** → Para debuggear problemas
- ✅ **GitHub como principal** → Configurado como default

## 🚀 **ORDEN DE EJECUCIÓN RECOMENDADO**

1. **Respaldar** configuración actual MCP
2. **Aplicar** nueva configuración optimizada
3. **Limpiar** cache VS Code corrupto
4. **Reiniciar** VS Code completamente
5. **Verificar** que solo aparecen 3 servidores MCP
6. **Configurar** GitHub como agente principal
7. **Testear** cada servidor MCP individualmente

## ✅ **RESULTADO ESPERADO**

- ❌ **Símbolo rojo desaparecido** (servidores corruptos eliminados)
- ✅ **3 servidores MCP funcionando** (github, filesystem, brave-search)
- ✅ **GitHub Copilot como principal** (autocompletado y chat prioritarios)
- ✅ **Roo Code como secundario** (disponible cuando lo necesites)
- ✅ **Inicio automático** habilitado sin errores

¿Quieres que ejecute estos comandos paso a paso o prefieres hacerlo manualmente siguiendo la guía?
