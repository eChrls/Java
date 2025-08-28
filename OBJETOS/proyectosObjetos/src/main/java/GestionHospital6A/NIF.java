/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionHospital6A;

import java.time.LocalDate;

/**
 *
 * @author Casa
 */
public class NIF {
    String numero;
    char letra; 

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public NIF(String numero, char letra) {
        this.numero = numero;
        this.letra = letra;
    }

    /*FUNCION PARA VALIDAR UN DNI DE 8 DIGITOS Y UNA LETRA*/
public boolean validar(){
    if(numero.length() != 8){
        return false;
    }
    /*Comprobacion de la letra del dni. 
    el número del DN es dividido entre 23. El resto se compara con unas tablas que asignan numeros a letras
RESTO	0	1	2	3	4	5	6	7	8	9	10	11
LETRA	T	R	W	A	G	M	Y	F	P	D	X	B
RESTO	12	13	14	15	16	17	18	19	20	21	22
LETRA	N	J	Z	S	Q	V	H	L	C	K	E
    */
   try{
       int num = Integer.parseInt(numero);
       
       String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
       int indice = num%23;
       char letraCalculada = letras.charAt(indice);
       
       return letraCalculada == letra; 
       
    }catch (NumberFormatException e){
           return false;
   }
   
}

    @Override
    public String toString() {
        return "NIF=  " + numero +  " - " + letra + '}';
    }



    

   
    
    

}
