
# MODA URBANA

## Proyecto de Integración Continua

### 1. Descripción del proyecto

MODA URBANA es un proyecto de software orientado a la gestión de productos e inventario de una tienda de ropa urbana. Su desarrollo permite aplicar herramientas de integración continua y tecnologías de contenedores.

### 2. Objetivo

Construir una aplicación Java conectada a una base de datos MySQL mediante dos contenedores Docker independientes, configurando su comunicación a través de Docker Compose.

### 3. Tecnologías utilizadas

- Java JDK 21
- Eclipse IDE
- Maven
- MySQL 8.4
- Docker Desktop
- Docker Compose
- GitHub

### 4. Arquitectura del proyecto

El proyecto está compuesto por dos contenedores:

**Contenedor 1: Aplicación Java**
- Ejecuta la aplicación MODA URBANA.
- Utiliza Java 21.
- Se conecta a la base de datos mediante JDBC.

**Contenedor 2: Base de datos MySQL**
- Ejecuta MySQL 8.4.
- Contiene la base de datos `moda_urbana`.
- Permite almacenar la información del sistema.

Los dos contenedores se comunican mediante una red interna administrada por Docker Compose.

### 5. Estructura del proyecto

- `src/`: código fuente de Java.
- `pom.xml`: configuración de Maven y dependencias.
- `Dockerfile`: instrucciones para construir la imagen de la aplicación.
- `docker-compose.yml`: configuración y comunicación de los contenedores.

### 6. Ejecución del proyecto

Para construir y ejecutar los contenedores, se utiliza el siguiente comando:

```bash
docker compose up --build
```

Este comando construye la imagen de la aplicación, inicia MySQL y ejecuta la aplicación Java cuando la base de datos está disponible.

### 7. Prueba de comunicación

Se realizó una consulta SQL utilizando `SELECT 1` desde la aplicación Java hacia MySQL.

Resultado obtenido:

- Conexión exitosa con MySQL.
- Respuesta de MySQL: 1.
- Los contenedores se comunican correctamente.

### 8. Entrega 1 - Semana 3

Construcción de dos contenedores Docker y configuración de su comunicación mediante Docker Compose.

### 9. Estado del proyecto

Primera entrega implementada y prueba de comunicación entre contenedores exitosa.

Proyecto académico - MODA URBANA.
