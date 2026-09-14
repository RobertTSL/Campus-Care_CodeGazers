package mx.edu.campuscare.common;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.Map;
@RestControllerAdvice public class ApiErrorHandler { @ExceptionHandler(Exception.class) ResponseEntity<Map<String,String>> error(Exception e){return ResponseEntity.status(500).body(Map.of("error",e.toString()));} } // TRAINING GAP U2-P4: expone detalle.
