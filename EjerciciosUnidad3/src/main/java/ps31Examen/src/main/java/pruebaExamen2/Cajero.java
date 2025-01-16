package pruebaExamen2;

import javax.swing.JOptionPane;

public class Cajero {

    public static void main(String[] args) {

        final float saldoInicial = 112.34f;
        String salida = "";
        String miniMenu = "";
        double saldo = (double) saldoInicial;
        String num = "";
        int numero = 0;
        String numMenu = "";


        /*El programa tendrá un menú de opciones, que se describe más adelante. Después de ejecutar una operación en el cajero, 
 el programa pregunta al usuario si quiere volver a realizar otra. Si el usuario escribe la cadena de texto "otra" 
 entonces se muestra el menú de opciones otra vez. Si el usuario escribe "salir" el programa termina. 
 En otros casos se vuelve a preguntar al usuario que quiere hacer. */
        do {

            String menu = """
               Bienvenido a su cajero, elija una opción (1-3):
               1) Mostrar saldo.
               2) Ingresar dinero.
               3) Sacar dinero               
               """;
            numMenu = JOptionPane.showInputDialog(null, menu);

            try {
                numero = Integer.parseInt(numMenu);
            } catch (NumberFormatException nfe) {
                System.out.println("Has escrito una opción no válida");
            }
            switch (numero) {
                case 1 -> {
                    miniMenu = """
                                   Su saldo actual es de  :  %.2f """.formatted(saldo);
                    JOptionPane.showMessageDialog(null, miniMenu);
                }
                case 2 -> {
                    
                    double ingresos = MetodosCajero.IntroducirNumero();

                    while(ingresos <= 0) {//control de ingreso negativo o 0
                        JOptionPane.showMessageDialog(null, "Cifra introducida incorrecta. Vuelva a empezar");
                        ingresos = MetodosCajero.IntroducirNumero();
                    } 
                        saldo = MetodosCajero.Ingresar(saldo, ingresos);
                         String resultado="""
                                         El saldo restante es: %.3f
                                         """.formatted(saldo);
                        JOptionPane.showMessageDialog(null, resultado);
                }

                case 3 -> {
                    double retiradas = MetodosCajero.IntroducirNumero();
                    while (retiradas > saldoInicial) {//control de retirada a negativo
                        JOptionPane.showMessageDialog(null, "NO TIENES SUFICIENTE SALDO. VUELVE A EMPEZAR");
                        retiradas = MetodosCajero.IntroducirNumero();
                    }
                        saldo = MetodosCajero.Sacar(saldo, retiradas);
                        String resultado="""
                                         El saldo restante es: %.3f
                                         """.formatted(saldo);
                        JOptionPane.showMessageDialog(null, resultado);
                   
                }

            }

            String menu2 = """
                      Quieres realizar otra operación?
                        Escribe: 
                            -    otra
                            -    salir
                      """;
            try {
                salida = JOptionPane.showInputDialog(menu2);

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Has escrito una opción no válida.");
            }
            while (!salida.equals("salir") && !salida.equals("otra")) {//control en salida para elegir unicamente valores exactos

                salida = JOptionPane.showInputDialog("Opcion incorrecta..." + "Introduce otra o salir");
            }

        } while (!salida.equals("salir"));

        JOptionPane.showMessageDialog(null, "Gracias, hasta pronto");
    }
}
