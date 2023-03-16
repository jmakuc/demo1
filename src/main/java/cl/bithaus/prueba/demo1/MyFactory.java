package cl.bithaus.prueba.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFactory {

    @Bean
    public GeneradorPersonas getGeneradorPersonas() {
        return new GeneradorPersonas();
    }

    
}
