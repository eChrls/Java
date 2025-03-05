/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.MiExamen;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author carlos
 */
public class Operaciones {

    public static int NUMERO_FICHAS_POR_COLOR = 13;
    public int TOTALFICHAS = 52;
    private Ficha[] fichasArray;

    /*
    public Operaciones() {
        fichasArray = new Ficha[TOTALFICHAS];
        int indiceArray = 0; 
        for(Color color : Color.values()){
            for (int i = 1; i <= 13; i++) {
            fichasArray[indiceArray++] = new Color(color, i);
           
            }
        }
    }
   
    /* Generador de fichas con HashSet generando naipes aleatorios que no se repiten usando el constructor aleatorio*/
    public Set<Ficha> generarTodas() {

        fichasArray = new Ficha[TOTALFICHAS];
        //Hashset hace que no se repitan
        Set<Ficha> fichasUnicas = new HashSet<>();

        while (fichasUnicas.size() < TOTALFICHAS) {
            Ficha nuevaFicha = new Ficha();
            fichasUnicas.add(nuevaFicha);
        }
        return fichasUnicas;
    }

    //Metodo barajar intercambia posiciones del array fichas el numero de veces que se determine
    public void barajarFichas(int movimientos) {

        Random r = new Random();
        for (int i = 0; i < movimientos; i++) {
            int pos1 = r.nextInt(TOTALFICHAS);
            int pos2 = r.nextInt(TOTALFICHAS);

            Ficha fichaTemp = fichasArray[pos1];
            fichasArray[pos1] = fichasArray[pos2];
            fichasArray[pos2] = fichaTemp;

        }
    }

    /*• Método sacar(int numFichas): Retorna un array (que se puede convertir en lista -- ArrayList<String> listaFichas = new ArrayList<>(Arrays.asList(fichasSacadas));--)
    con numFichas sacadas aleatoriamente del juego (estableciendo a null en el juego las fichas sacadas). 
    Si numFichas es inválido (menor que 1 o mayor que 52), retorna null. El metodo no requiere recibir una lista porque tiene como atributo un array de fichas
    Por optimizacion y que no se repitieran las fichas he optado por un array y un */
    public Ficha[] sacarFicha(int numFichas) {
        if (numFichas < 1 || numFichas > TOTALFICHAS) {
            return null;
        }

        Ficha[] fichasSacadas = new Ficha[numFichas];
        int indiceArray = 0;
        Random r = new Random();

        while (indiceArray < numFichas) {

            int pos = r.nextInt(TOTALFICHAS);
            if (fichasArray[pos] != null) {

                fichasSacadas[indiceArray] = fichasArray[pos];

                fichasArray[pos] = null;

                indiceArray++;
            }

        }
        return fichasSacadas;
    }
       //ESCALERA - con metodo son 3 numeros seguidos + 3 colores seguidos tenemos escalera. 
//METODO PARA SABER SI LAS FICHAS SON 3 COLORES SEGUIDOS
    //Pasas el array y te dice si existen tres colores seguidos 
    public boolean sonTresColoresSeguidos(Ficha[] fichas) {
        
        
        
        for (int i = 1; i < TOTALFICHAS; i++) {
            for (int j = 1; j < fichas.length - 1; j++) {
                if (fichas[j].getColor() == fichas[j + 1].getColor());
                {
                Color colorTemp = fichas[j].getColor();
                    for (int k = 2; k < fichas.length-1; k++) {
                    if(colorTemp == fichas[k+1].getColor());
                    return true;
                    }
                }
            }
        }
        return false;
    }

    //TRIO
    //Metodo que recorre el array tres veces para comprobar si tiene tres numeros seguidos 
    //Solo hay que pasar el array y devolvera true si existe trio
    public boolean existeTrio(Ficha[] fichas) {

        for (int i = 1; i < TOTALFICHAS; i++) {
            for (int j = 1; j < TOTALFICHAS - 1; j++) {
                if (fichas[j].getNumero() == fichas[j + 1].getNumero()) {
                int numTemp = fichas[j].getNumero();
                    for (int k = 1; k < fichas.length-1; k++) {
                        if(numTemp == fichas[k+1].getNumero());
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
  
//METODO PARA SABER SI LAS FICHAS SON 3 SEGUIDAS, 
    public boolean sonTresSeguidas(Ficha[] fichas) {

        for (int i = 1; i < TOTALFICHAS; i++) {
            for (int j = 1; j < TOTALFICHAS - 1; j++) {
                if (fichas[j].getNumero() == fichas[j + 1].getNumero()+1) {
                    int Numtemp = fichas[j].getNumero();
                    for (int k = 2; k < fichas.length - 1; k++) {
                        int numTemp = fichas[k].getNumero();
                        if (numTemp == fichas[k + 1].getNumero()) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    /*  for (int i = 0; i < array.length - 1 ; i++) {
            for (int j = 0; j < array.length -1; j++) {
                if (array[j] > array[j+1]){ // 6 > 5
                    var = array [j]; // var = 6
                    array[j] = array[ j + 1]; // [ 5 , 5, 4 , 3 ....]
                    array[j + 1] = var; // [ 5 , 6 , 4,  3.....]
                }
            }
        }     */
    public boolean existeEscalera(Ficha[] fichas) {
       
        
        return false;
    }

    public boolean esConsecutivo(Ficha[] fichas) {

        return false;
    }

}
