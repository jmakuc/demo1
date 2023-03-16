package cl.bithaus.prueba.demo1;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@ConfigurationProperties(prefix = "cl.demo")
@Data
@NoArgsConstructor
public class Configuracion {
    
    @NotBlank
    String[] nombres;
    String[] apellidos;
    Integer edadMaxima;
    Integer edadMinima;

    public String toString() {

        String s = "Configuracion: ";
        s += "nombres: " + Arrays.toString(nombres);
        s += ", apellidos: " + Arrays.toString(apellidos);
        s += ", edadMaxima: " + edadMaxima;
        s += ", edadMinima: " + edadMinima;
        return s;
    }
}
