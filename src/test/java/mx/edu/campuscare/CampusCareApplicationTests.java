package mx.edu.campuscare;
import org.junit.jupiter.api.*; import org.springframework.beans.factory.annotation.*; import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc; import org.springframework.boot.test.context.SpringBootTest; import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic; import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest(properties="spring.datasource.url=jdbc:h2:mem:testdb") @AutoConfigureMockMvc class CampusCareApplicationTests {
 @Autowired MockMvc mvc;
 @Test void swaggerIsAvailable() throws Exception {mvc.perform(get("/v3/api-docs")).andExpect(status().isOk());}
 @Test void anonymousCannotListTickets() throws Exception {mvc.perform(get("/api/tickets")).andExpect(status().isUnauthorized());}
 @Test void studentCanListBaselineTickets() throws Exception {mvc.perform(get("/api/tickets").with(httpBasic("rivera","demo123"))).andExpect(status().isOk());}
 @Test void xssTrainingGapIsReproducible() throws Exception {mvc.perform(get("/api/comments/preview").param("text","<script>alert(1)</script>")).andExpect(status().isOk()).andExpect(content().string(org.hamcrest.Matchers.containsString("<script>")));}
 @Disabled("Se habilita al corregir BOLA en U3-P1") @Test void studentCannotReadAnotherUsersTicket() throws Exception {mvc.perform(get("/api/tickets/2").with(httpBasic("rivera","demo123"))).andExpect(status().isForbidden());}
}
