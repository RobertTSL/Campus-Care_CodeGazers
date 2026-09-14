package mx.edu.campuscare.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain chain(HttpSecurity h) throws Exception {
        return h.csrf(c -> c.disable()).authorizeHttpRequests(a -> a.requestMatchers("/", "/error", "/swagger-ui/**", "/v3/api-docs/**", "/api/comments/preview").permitAll().anyRequest().authenticated()).httpBasic(Customizer.withDefaults()).headers(x -> x.contentSecurityPolicy(c -> c.policyDirectives("default-src 'self' 'unsafe-inline'"))).build();
    } // TRAINING GAP: CSP permisiva y CSRF desactivado.

    @Bean
    UserDetailsService users() {
        return new InMemoryUserDetailsManager(
                User.withUsername("rivera").password("demo123").roles("STUDENT").build(),
                User.withUsername("lopez").password("demo123").roles("STUDENT").build(),
                User.withUsername("agente").password("demo123").roles("SUPPORT").build(),
                User.withUsername("admin").password("demo123").roles("ADMIN").build());
    }

    @SuppressWarnings("deprecation")
    @Bean
    static NoOpPasswordEncoder encoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    } // TRAINING GAP: sólo credenciales ficticias.
}
