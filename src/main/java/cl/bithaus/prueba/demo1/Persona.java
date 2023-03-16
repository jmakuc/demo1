package cl.bithaus.prueba.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    
    private String nombre;
    private String apellido;
    private String rut;
    private Integer edad;


    

}
