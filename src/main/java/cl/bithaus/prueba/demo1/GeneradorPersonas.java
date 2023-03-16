package cl.bithaus.prueba.demo1;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;


public class GeneradorPersonas {
    
    @Autowired
    private Configuracion configuracion;
    
    private static final String[] ruts = {"12.345.678-9", "11.223.344-5", "33.445.556-7", "77.889.900-1", "45.678.912-3", "34.567.890-1", "98.765.432-1", "55.667.788-9", "12.345.678-0", "33.445.556-6"};


    public Persona getPersona() {

        Random random = new Random();
        String nombre = this.configuracion.nombres[random.nextInt(this.configuracion.nombres.length)];
        String apellido = this.configuracion.apellidos[random.nextInt(this.configuracion.apellidos.length)];
        String rut = ruts[random.nextInt(ruts.length)];
        int edad = random.nextInt(this.configuracion.getEdadMaxima() - this.configuracion.getEdadMinima()) + this.configuracion.getEdadMinima();
        return new Persona(nombre, apellido, rut, edad);        

    }
}
