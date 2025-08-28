/*
Tiene el método estático generarQR(String texto, String nombreFichero).

Usa la librería ZXing para:

Codificar el texto en un QR (BitMatrix).

Generar una imagen (BufferedImage) y escribirla en disco usando la extensión indicada (png o jpg).
 */
package QR;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class QR {

    public static void generarQR(String texto, String nombreFichero) throws WriterException, IOException {
        int ancho = 300;
        int alto = 300;
        String formato = nombreFichero.endsWith(".jpg") ? "jpg" : "png";//Decide el formato (según la extensión).

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");//Configura parámetros de codificación (UTF-8).

        BitMatrix matrix = new MultiFormatWriter().encode(texto, BarcodeFormat.QR_CODE, ancho, alto, hints);
        Path ruta = FileSystems.getDefault().getPath(nombreFichero);
        MatrixToImageWriter.writeToPath(matrix, formato, ruta);//Usa MatrixToImageWriter.writeToPath(...) para guardar la imagen.
    }
}
