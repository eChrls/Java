
package EstructurasDeAlmacenamiento;

public class PasoPorReferencia {
    //Se crea una variable nueva llamada letra con el valor 
    //que traiga del main
    public static void pasoValor(char letra){
        System.out.println("Dentro del metodo" + letra);
        letra = 'z';
        System.out.println(letra);
        
    }
        
    public static void main(String[] args) {
      
        char letraA = 'a';
        System.out.println(letraA);// a
        //Invocacion de un metodo pasando por valor el primitivo char
        PasoPorReferencia.pasoValor(letraA);
        System.out.println(letraA);// a o z ?
        
        
    }
    

    }   

