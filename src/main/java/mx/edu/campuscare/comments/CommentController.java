package mx.edu.campuscare.comments;
import org.springframework.http.MediaType; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/comments") public class CommentController {
 @GetMapping(value="/preview",produces=MediaType.TEXT_HTML_VALUE) public String preview(@RequestParam String text){ return "<article><h2>Vista previa</h2><p>"+text+"</p></article>"; } // TRAINING GAP U2-P2: XSS reflejado local.
}
