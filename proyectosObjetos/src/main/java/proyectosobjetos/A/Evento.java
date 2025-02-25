package proyectosobjetos.A;




import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Evento {
     ArrayList<Participante>listaParticipantes;
     boolean[]dorsalesDisponibles;
    
    //Constructor para crear un evento con un nº de dorsales
    public Evento (int totalDorsales){
        this.listaParticipantes = new ArrayList<>();
        this.dorsalesDisponibles= new boolean[totalDorsales];
        //Inicialmente todos los dorsales están disponibles
        for (int i = 1; i < totalDorsales; i++) {
             dorsalesDisponibles[i] = true;
        }
    }
        /*METODO B PARA LLENAR UN BOOLEANO DE DORSALES
    public Evento(int totalDorsales){
        this.listaParticipantes = new ArrayList<>();
        this.dorsalesDisponibles= new boolean[totalDorsales];
        Arrays.fill(dorsalesDisponibles, true);
    */

//Metodo para registrar un nuevo participante
   public void registrarParticipante(String nombre, String apellidos, LocalDate fechaNac, Categoria categoria, double tiempo) {
        int dorsal = asignarDorsal();
        if (dorsal != -1) {
            Participante participante = new Participante(nombre, apellidos, fechaNac, dorsal, categoria, tiempo);
            listaParticipantes.add(participante);
            System.out.println("Participante registrado con dorsal: " + dorsal);
        } else {
            System.out.println("No hay dorsales disponibles");
        }
    }
   


//Método para asignar un dorsal disponible
 private int asignarDorsal(){
     for (int i = 0; i < dorsalesDisponibles.length; i++) {
                if(dorsalesDisponibles[i]){ //= true
                    dorsalesDisponibles[i] = false; // Lo marcamos como no disponible
                    return i;
                }
     }
     return -1; //si no hay disponibles
 }
 
 
 //Metodo para ordenar los participantes por tiempo
 public void ordenarPorTiempo(){
     Collections.sort(listaParticipantes);
     System.out.println("************************Resultados por tiempo: **************************");
     for(Participante participante : listaParticipantes){
         System.out.println(participante);
     }
 }
    
 //Metodo para buscar un participante por dorsal
   public Participante buscarParticipantePorDorsal(int dorsal){
       for(Participante participante : listaParticipantes){
           if(participante.getDorsal() == dorsal){
               return participante;
           }
       }
       return null;
   }

}
