
package com.mycompany.apppassword;

import org.apache.commons.lang3.RandomStringUtils;

public class GeneraContraseña {
    //metodo string 
    public static String DameContraseña(){
        //importamos librería y usamos objeto
        RandomStringUtils generador = RandomStringUtils.secure();
        //añadimos 8 caracteres a la contraseña como nos pide el ejercicio   
        String contraseña = generador.nextAlphanumeric(8).toUpperCase(); 
        
    return contraseña;
    }
}