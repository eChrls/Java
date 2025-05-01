/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea7c;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.myprojects.tarea7c.Precipitacion;

/**
 *
 * @author Casa
 */
public class tarea7c {
    
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<Precipitacion> precipitaciones = mapper.readValue(new File("precipitacionesBadajoz.json"), new TypeReference<List<Precipitacion>>(){});
        precipitaciones.forEach(System.out::println);
       
        Map<String, Double> map = precipitaciones.stream()
                                                                         .collect(
                                                                         Collectors.groupingBy(Precipitacion::getEstacionMeteorologica, 
                                                                         Collectors.summingDouble(Precipitacion::getPrecipitacion))
                                                                         );
        
        map.forEach((k,v)->System.out.println(k + v));
        
    }
    
    
    
}
