# APIalu (FOROHUB)

APIalu es una aplicación desarrollada con Java 17 y Spring Boot para la gestión de un foro educativo. El proyecto utiliza el artefacto com.arheco.apialu y está diseñado para gestionar tópicos mediante una interfaz de programación de aplicaciones.

## Requisitos y Tecnologías

El desarrollo del proyecto utiliza las siguientes herramientas y dependencias:
* Java JDK 17
* Maven
* Spring Boot
* Spring Data JPA
* Spring Security
* Postgresql Driver
* Flyway Migration
* Lombok
* Validation
* Auth0 JWT

## Estructura de Datos

La base de datos se centra en la gestión de tópicos con los siguientes campos:
* Identificador único
* Título del tópico
* Mensaje del contenido
* Fecha de creación
* Estado del tópico
* Autor
* Curso relacionado

## Funcionalidades de la API

La aplicación permite realizar las siguientes operaciones sobre los tópicos:
* Registro de tópicos: Endpoint POST en la ruta /tópicos que recibe un archivo JSON. Valida que no existan registros duplicados con el mismo título y mensaje. Todos los campos son obligatorios.
* Listado general: Endpoint GET en la ruta /tópicos para recuperar todos los registros almacenados.
* Consulta detallada: Endpoint GET en la ruta /tópicos/{id} para visualizar la información de un registro específico mediante su identificador.
* Eliminación: Endpoint DELETE en la ruta /tópicos/{id} para borrar registros de la base de datos previa verificación de su existencia.

## Seguridad y Autenticación

El sistema implementa un control de acceso para restringir las operaciones a usuarios registrados:
* Mecanismo de autenticación: Se requiere un proceso de inicio de sesión mediante la ruta /login.
* Token JWT: La seguridad se gestiona a través de JSON Web Tokens generados con el algoritmo HMAC256 y una contraseña secreta definida en la configuración.
* Filtro de seguridad: Las solicitudes deben incluir el token válido en el encabezado Authorization utilizando el esquema Bearer para ser procesadas por el sistema.