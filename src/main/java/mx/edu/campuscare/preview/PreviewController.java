package mx.edu.campuscare.preview;

import org.springframework.web.bind.annotation.*;

import java.net.*;
import java.net.http.*;
import java.time.Duration;

@RestController
@RequestMapping("/api/preview")
public class PreviewController {
    private final HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(2)).build();

    @GetMapping
    public String preview(@RequestParam String url) throws Exception { // TRAINING GAP U2-P3: falta allowlist/destinos privados.
        URI uri = URI.create(url);
        HttpRequest r = HttpRequest.newBuilder(uri).timeout(Duration.ofSeconds(3)).GET().build();
        return client.send(r, HttpResponse.BodyHandlers.ofString()).body();
    }
}
