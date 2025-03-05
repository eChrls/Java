
package com.mycompany.apppassword;

import java.util.*;

public class GeneraPin {
   //metodo int para el pin con un random para conseguirlo.
    public static int damePin (){
     
        Random r = new Random();
        
        return r.nextInt(1000,9999);
        
    }    
}
