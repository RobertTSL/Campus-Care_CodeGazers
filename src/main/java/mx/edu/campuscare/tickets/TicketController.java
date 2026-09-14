package mx.edu.campuscare.tickets;
import jakarta.validation.Valid; import jakarta.validation.constraints.NotBlank;
import org.springframework.http.*; import org.springframework.security.core.Authentication; import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/tickets") public class TicketController {
 private final TicketRepository repo; public TicketController(TicketRepository repo){this.repo=repo;}
 @GetMapping public List<Ticket> all(){ return repo.findAll(); } // TRAINING GAP U2-P1: filtra por ownership/rol.
 @GetMapping("/{id}") public Ticket one(@PathVariable Long id){ return repo.findById(id).orElseThrow(); } // TRAINING GAP U3-P1: BOLA.
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Ticket create(@Valid @RequestBody CreateTicket req, Authentication a){return repo.save(new Ticket(a.getName(),req.title(),req.description(),false));}
 @PatchMapping("/{id}") public Ticket patch(@PathVariable Long id,@RequestBody Map<String,Object> body){ // TRAINING GAP U3-P2: binding permisivo.
   Ticket t=repo.findById(id).orElseThrow(); if(body.containsKey("title"))t.setTitle(String.valueOf(body.get("title"))); if(body.containsKey("status"))t.setStatus(String.valueOf(body.get("status"))); if(body.containsKey("owner"))t.setOwner(String.valueOf(body.get("owner"))); if(body.containsKey("privateNote"))t.setPrivateNote(Boolean.parseBoolean(String.valueOf(body.get("privateNote")))); return repo.save(t);
 }
 public record CreateTicket(@NotBlank String title,@NotBlank String description){}
}
