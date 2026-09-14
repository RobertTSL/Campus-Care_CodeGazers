package mx.edu.campuscare.config;
import mx.edu.campuscare.tickets.*; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.*;
@Configuration class SeedData { @Bean CommandLineRunner seed(TicketRepository r){return args->{if(r.count()==0){r.save(new Ticket("rivera","Acceso al portal","No puedo consultar mi horario",false));r.save(new Ticket("lopez","Apoyo psicológico","Nota privada de demostración",true));}};} }
