/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class Alumno {
    private int idAlumn;
    private String name; 
    private String nif;
    
    
    
    
    
   /* 
     //CREACION DE 10 ALUMNOS
    private static void crearAlumno(Alumno alumno) {
        /*Explicacion del for para nif alumnos
                i = 0 → "3333555" + 0 → "33335550"
                i = 1 → "3333555" + 1 → "33335551"
            'A' + i % 26 genera letras de la A a la Z:
            i = 0 → 'A' + (0 % 26) → 'A' + 0 = 'A'
            i = 1 → 'A' + (1 % 26) → 'A' + 1 = 'B'
            i = 2 → 'A' + (2 % 26) → 'A' + 2 = 'C'
            i = 26 → 'A' + (26 % 26) → 'A' + 0 = 'A'  ✅ *Reinicio*
            i = 27 → 'A' + (27 % 26) → 'A' + 1 = 'B'*/
/*        
for (int i = 0; i < 10; i++) {
            //creacion del nif
            char letra = (char) ('A' + i % 26); //Letras de A a Z
            NIF nif = new NIF("3333555" + i, letra);

            //Creamos la lista de alumnos vacía
            ArrayList<String> alumnos = new ArrayList<>();

            //Creamos el alumno
            Alumno alumno = new Alumno();
            
            alumnos.add(alumno);
        }
    }*/

    public Alumno() {
    }

    public Alumno(int idAlumn, String name, String nif) {
        this.idAlumn = idAlumn;
        this.name = name;
        this.nif = nif;
    }

    public int getIdAlumn() {
        return idAlumn;
    }

    public void setIdAlumn(int idAlumn) {
        this.idAlumn = idAlumn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumn=" + idAlumn + ", name=" + name + ", nif=" + nif + '}';
    }


}
