# CampusCare Java Starter

> **Proyecto académico deliberadamente vulnerable. Uso exclusivo en localhost o entornos expresamente autorizados. No desplegar públicamente ni usar contra sistemas de terceros.**

## ¿De qué trata el sistema?

CampusCare simula una plataforma universitaria de atención y soporte. Los usuarios pueden iniciar sesión, crear y consultar tickets, publicar comentarios y dar seguimiento a solicitudes relacionadas con servicios del campus. El personal de soporte puede atender los tickets y registrar notas privadas, y el sistema incluye una función de vista previa de enlaces asociados con una solicitud.

El sistema contiene deliberadamente decisiones y vulnerabilidades que se analizarán y corregirán durante el semestre. El objetivo del proyecto no es ampliar sus funciones como producto, sino aplicar progresivamente diseño seguro, controles de acceso, protección de datos, seguridad de sesiones y prácticas DevSecOps, conservando evidencia técnica de cada decisión.

Baseline de Ciberseguridad Aplicada en Java 21 y Spring Boot 3. Incluye API HTTP, Basic Auth de laboratorio, tickets, vista previa HTML, preview de URL, H2, OpenAPI, pruebas, Docker y CI. Las debilidades marcadas `TRAINING GAP` son intencionales y deben tratarse únicamente dentro del curso.

## Equipo

- Líder inicial: Robert Stewart Teaze Legleu
- Responsable de evidencia: NOMBRE
- Responsable de calidad: Edgar Arturo Acevedo Acosta
- Integrante adicional: NOMBRE (si aplica)

No publiques matrículas, correos o teléfonos. Los roles rotan por unidad.

## Requisitos y ejecución

- JDK 21. No es necesario instalar Maven globalmente.

```bash
./mvnw test
./mvnw spring-boot:run
```

En Windows: `mvnw.cmd test` y `mvnw.cmd spring-boot:run`. Abre `http://localhost:8080/swagger-ui.html`.

Usuarios ficticios: `rivera`, `lopez`, `agente`, `admin`. Contraseña común: `demo123`.

## Inicio del equipo

El líder crea `campuscare-equipo-XX`, sube este starter e invita a sus compañeros. Cada integrante clona, ejecuta tests, arranca la app y abre un PR inicial. `main` se protege: PR obligatorio, una aprobación y CI aprobado. El autor no aprueba su propio PR.

```bash
git init
git add .
git commit -m "chore: importar baseline oficial de CampusCare"
git branch -M main
git remote add origin URL_DEL_REPOSITORIO
git push -u origin main
```

Cada PR debe documentar vulnerabilidad/riesgo, reproducción, evidencia, causa raíz, mitigación, tests, antes/después y riesgo residual. Etiquetar los Avances con `avance-u1`, `avance-u2` y `avance-u3`.

## Controles del starter

```bash
./mvnw verify
./mvnw spotbugs:check
./mvnw org.owasp:dependency-check-maven:check
docker build -t campuscare-java .
```

El escaneo de dependencias requiere acceso a las fuentes de vulnerabilidades y puede tardar; no reemplaza el análisis humano.
# Campus-Care_CodeGazers
