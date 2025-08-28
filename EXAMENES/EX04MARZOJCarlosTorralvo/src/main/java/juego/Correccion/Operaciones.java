
package juego.Correccion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public class Operaciones {

    public static int NUMERO_FICHAS_POR_COLOR = 13;

    public static List<Ficha> generarTodas() {

        List<Ficha> lista = new ArrayList<>();

        for (int i = 0; i < 2; i++) { // 2 conjuntos de fichas
            for (Color value : Color.values()) { // 4 colores
                for (int j = 1; j <= NUMERO_FICHAS_POR_COLOR; j++) { // 13 fichas por color
                    lista.add(new Ficha(j, value));
                }
            }
        }
        return lista;
    }

}