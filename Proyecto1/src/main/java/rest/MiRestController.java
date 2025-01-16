/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
/**
 *
 * @author Casa
 */
public class MiRestController {
    
    
    @GetMapping("/")
    
    public String saludo(){
        
        return "Hola alumnos de Spring Boot";
    }
    
}
