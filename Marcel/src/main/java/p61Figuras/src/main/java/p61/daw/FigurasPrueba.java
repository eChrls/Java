/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.daw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import p61.figuras.Circulo;
import p61.figuras.Figura;
import p61.figuras.Rectangulo;
import p61.figuras.Triangulo;
import p61.interfaces.Dibujable;
import p61.interfaces.Movible;

/**
 *
 * @author Casa
 */
public class FigurasPrueba {

    public static void main(String[] args) {

        Set<Figura> conjunto = new HashSet<>();

        Circulo c1 = new Circulo(10, "1", "azul");
        Circulo c2 = new Circulo(20, "2", "blanco");
        Rectangulo r1 = new Rectangulo(4, 2, 4, "3", "rojo");
        Rectangulo r2 = new Rectangulo(10, 5, 4, "4", "verde");
        Triangulo t1 = new Triangulo(4, 3, 3, "5", "amarillo");
        Triangulo t2 = new Triangulo(2, 3, 3, "pepito", "morado");
        

        conjunto.add(t2);//Conversion implicita
        conjunto.add(t1);
        conjunto.add(c1);
        conjunto.add(c2);
        conjunto.add(r1);
        conjunto.add(r2);

        for (Figura f : conjunto) {
            System.out.println(f + " su area es = " + f.area());
        }

        //  listaFiguras.addAll(conjunto);
        List<Figura> listaFiguras = new ArrayList<>(conjunto);//Conversion implicita

//      Comparator<Figura> porColor = (f1, f2) -> String.compare(f1.getColor(), f2.getColor());
        Comparator<Figura> porColor = (f1, f2) -> f1.getColor().equals(f2.getColor())
                ? f1.getId().compareTo(f2.getId())
                : f1.getColor().compareTo(f2.getColor());//Conversion implicita

        /* (f1,f2) -> .(f1.getEdad()== f2.getEdad()) ?
                Integer.compare(f1.getId(), f2.getId())
                        :
            Double.compare(f1.getSalario, f2.getSalario);
            }
         */
        Collections.sort(listaFiguras, porColor);
        System.out.println("Lista ordenada por color");
        System.out.println("-----------------------------------");
        listaFiguras.forEach(System.out::println);
        System.out.println("**********************************");
        String idAux;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero para localizar la figura.");
        idAux = sc.nextLine();

        Circulo aux = new Circulo();

        aux.setId(idAux);
        Comparator<Figura> porId = (f1, f2) -> f1.getId().compareTo(f2.getId());//Conversion implicita
        Collections.sort(listaFiguras, porId);
        
        int posicion = Collections.binarySearch(listaFiguras, aux, porId);
        if (posicion < 0 ){
            System.out.println("No se encuentra");
        }else{
        System.out.println("Se encuentra en la posicion  " + posicion);
        }
        
        List<Dibujable> dibujables = new ArrayList<>();
        for(Figura f : listaFiguras){ //Conversion implicita
            if(f instanceof Dibujable){ //Conversion implicita
            dibujables.add((Dibujable)f); //Conversion explicita
        }
        }
        
        
        for(Dibujable d : dibujables){
            d.dibujar();
        }
        
        List<Movible> movibles = new ArrayList<>();
        for(Figura f : listaFiguras){ //Conversion implicita
            if(f instanceof Movible){//Conversion implicita
               movibles.add((Movible)f); //Conversion explicita
            }
        }
        
        for(Movible m : movibles){ //Conversion implicita
            if(m instanceof Rectangulo){
                 ((Rectangulo)m).moverDer(2); //Conversion explicita
            }
            else{
            ((Circulo)m).moderArr(3); //Conversion explicita
            }
        }
    }

}
