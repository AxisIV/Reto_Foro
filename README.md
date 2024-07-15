# Foro Reto

Este es un proyecto de un foro en Java utilizando Spring Boot, JPA, y MySQL. El propósito de este proyecto es permitir a los usuarios crear, actualizar y visualizar tópicos relacionados con diferentes cursos.

## Tecnologías Utilizadas

- Java 22
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- JWT (JSON Web Tokens)

## Configuración del Proyecto

### Prerrequisitos

Asegúrate de tener instalados los siguientes software en tu máquina:

- Java 22
- Maven
- MySQL

### Configuración de la Base de Datos

1. Abre tu terminal o línea de comandos y conéctate a MySQL:

    ```sh
    mysql -u tu_usuario -p
    ```

2. Crea la base de datos:

    ```sql
    CREATE DATABASE foro_reto;
    ```

3. Sal de MySQL:

    ```sql
    EXIT;
    ```

### Configuración del Proyecto

1. Clona el repositorio:

    ```sh
    git clone https://github.com/tu_usuario/foro-reto.git
    cd foro-reto
    ```

2. Configura las propiedades de la base de datos en `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/foro_reto
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    ```

3. Ejecuta la aplicación:

    ```sh
    mvn spring-boot:run
    ```

## API Endpoints

### Autenticación

- **Login**
  - **URL**: `/auth/login`
  - **Method**: `POST`
  - **Body**:
    ```json
    {
      "username": "correo@ejemplo.com",
      "password": "password123"
    }
    ```
  - **Response**:
    ```json
    {
      "token": "jwt-token-aqui"
    }
    ```

### Tópicos

- **Registrar Tópico**
  - **URL**: `/topicos`
  - **Method**: `POST`
  - **Headers**: 
    ```plaintext
    Authorization: Bearer <jwt-token>
    ```
  - **Body**:
    ```json
    {
      "titulo": "Problema con el código de ejemplo",
      "mensaje": "Estoy teniendo problemas con el código de ejemplo proporcionado. ¿Alguien puede ayudarme?",
      "curso": {
        "id": 1,
        "nombre": "Java Básico",
        "categoria": "Programación"
      },
      "fechaCreacion": "2024-07-13T10:00:00",
      "autor": {
        "id": 1,
        "nombre": "Juan Pérez",
        "email": "juan.perez@example.com",
        "contrasena": "password123"
      },
      "respuestas": []
    }
    ```

- **Actualizar Tópico**
  - **URL**: `/topicos`
  - **Method**: `PUT`
  - **Headers**: 
    ```plaintext
    Authorization: Bearer <jwt-token>
    ```
  - **Body**:
    ```json
    {
      "id": 1,
      "titulo": "Título Actualizado",
      "mensaje": "Mensaje actualizado",
      "curso": {
        "id": 1,
        "nombre": "Java Avanzado",
        "categoria": "Programación"
      },
      "fechaCreacion": "2024-07-13T10:00:00",
      "autor": {
        "id": 1,
        "nombre": "Juan Pérez",
        "email": "juan.perez@example.com",
        "contrasena": "password123"
      },
      "respuestas": []
    }
    ```

- **Listar Tópicos**
  - **URL**: `/topicos`
  - **Method**: `GET`
  - **Headers**: 
    ```plaintext
    Authorization: Bearer <jwt-token>
    ```

## Seguridad

Este proyecto utiliza JWT para la autenticación y autorización. Asegúrate de incluir el token en las cabeceras de tus solicitudes después de iniciar sesión.
