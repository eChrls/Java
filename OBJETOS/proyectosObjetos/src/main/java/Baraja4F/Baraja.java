/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Baraja4F;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Baraja {
    //•Atributos: Un array de Naipe (modificable) y una constante pública que indique que todas las barajas tienen 40 cartas.
    public final int TOTALNAIPES = 40;  
    private Naipe[] naipes; 

    //•Constructor sin parámetros: Crea una baraja completa con las 40 cartas diferentes.
    public Baraja() {
        /* OPCION 1 : iterando entre los diferetentes PALOS un máximo de 10 veces y usando el constructor formado, 
        i : numero de carta*/
        
        naipes = new Naipe[TOTALNAIPES];
        int indiceArray = 0; 
        for(Palos palo : Palos.values()){
            for (int i = 1; i <= 10; i++) {
                naipes[indiceArray++] = new Naipe(palo, i);
           
            }
        }
        /*
        OPCION 2 con HashSet generando naipes aleatorios usando el constructor aleatorio
        
        naipes = new Naipe[TOTALNAIPES];
        //Hashset hace que no se repitan
        Set<Naipe>naipesUnicos = new HashSet<>();
        
        while (naipesUnicos.size()< TOTALNAIPES){
            Naipe nuevoNaipe = new Naipe(); 
            naipesUnicos.add(nuevoNaipe);
         }
        
        naipesUnicos.toArray(naipes);
        */
    }
    //•Método get(): Retorna un Naipe específico de la baraja.
    public Naipe getNaipePorPosicion(int posicion){
            
        return naipes[posicion];
        }
           
    
  //•Método barajar(int movimientos): Intercambia la posición de dos cartas aleatoriamente movimientos veces.
  public void barajar (int movimientos){
      
    Random r = new Random();
      for (int i = 0; i < movimientos; i++) {
          int pos1 = r.nextInt(TOTALNAIPES);
          int pos2 = r.nextInt(TOTALNAIPES);
          
          Naipe naipeTemp  = naipes[pos1];
          naipes[pos1] = naipes[pos2];
          naipes[pos2] = naipeTemp;
          
          }
      }
  /*• Método sacar(int numCartas): Retorna un array con numCartas sacadas aleatoriamente de la baraja (estableciendo a null en la baraja
  las cartas sacadas). Si numCartas es inválido (menor que 1 o mayor que 40), retorna null.*/
  public Naipe[] sacarNaipe(int numNaipes){
      if(numNaipes <1 || numNaipes > TOTALNAIPES){
          return null; 
      }
      
      Naipe[]naipesSacados = new Naipe[numNaipes];
      int indiceArray = 0; 
      Random r = new Random();
      
      while(indiceArray < numNaipes){
          
          int pos = r.nextInt(TOTALNAIPES);
          if(naipes[pos]!=null){
              
              naipesSacados[indiceArray] = naipes[pos];
              
              naipes[pos] = null; 
              
              indiceArray++;
          }
          
      }
      return naipesSacados; 
  }
  //•toString(): Retorna una cadena con el toString() de cada carta en una línea.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Naipe naipe : naipes){
            if(naipe != null){
                sb.append(naipe.toString()).append("\n");
            }
        }
                return sb.toString();

    }
      
      
      
  
    
    
    
    
}
