package cl.bithaus.prueba.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ImprimePersonas {
    
    @Autowired
    private GeneradorPersonas generadorPersonas;

    public void imprimePersonas() {

        for(int i = 0; i < 10; i++) {
            Persona p = generadorPersonas.getPersona();
            log.info("Persona: " + p.toString()); 
        }
            
            
    }
}
