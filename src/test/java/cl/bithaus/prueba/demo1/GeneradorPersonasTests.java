package cl.bithaus.prueba.demo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = GeneradorPersonas.class)
@ContextConfiguration(classes = GeneradorPersonasTests.Config.class)
public class GeneradorPersonasTests {

    @Autowired
    private GeneradorPersonas generadorPersonas;

    @Autowired
    private Configuracion config;

    @Test
    void testGetPersona() {

        Persona p = generadorPersonas.getPersona();
        
        Assertions.assertNotNull(p);
        Assertions.assertNotNull(p.getNombre());
        Assertions.assertNotNull(p.getApellido());
        Assertions.assertNotNull(p.getEdad());
        Assertions.assertNotNull(p.getRut());

        Assertions.assertTrue(p.getEdad() >= config.getEdadMinima());
        Assertions.assertTrue(p.getEdad() <= config.getEdadMaxima());


    }


    @TestConfiguration
    static class Config {

        @Bean
        public Configuracion getConfiguracion() {
         
            Configuracion config = new Configuracion();
            config.setEdadMaxima(100);
            config.setEdadMinima(18);
            config.setNombres(new String[] {"Juan", "Pedro", "Pablo"});
            config.setApellidos(new String[] {"Perez", "Gonzalez", "Gomez"});
            
            return config;
        }

        @Bean
        public GeneradorPersonas getGeneradorPersonas() {
            return new GeneradorPersonas();
        }
    }
}
