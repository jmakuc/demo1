package cl.bithaus.prueba.demo1;

import java.util.concurrent.TimeUnit;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
@EnableScheduling
public class Demo1ContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ImprimePersonas imprimePersonas;

    @Autowired
    private GeneradorPersonas generadorPersonas;

    @Autowired
    private Configuracion config;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
      
        log.info("Hola estamos partiendo"); 

        log.info("Configuracion: " + config.toString());

        imprimePersonas.imprimePersonas();
    }
    

    @Scheduled(fixedRate = 1, initialDelay = 1, timeUnit = TimeUnit.SECONDS)
    public void imprimirPersona() {

        Persona p = this.generadorPersonas.getPersona();
        log.info("P: " + p.toString()); 
    }


    @PreDestroy
    public void antesDelCierre() {
        log.info("Adios, nos vemos pronto");
    }
}
