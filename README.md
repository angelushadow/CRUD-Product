# CRUD-Product
Crud de producto - API de creación, actualización, eliminación y busqueda de producto.

## Description

Request:

*    El objecto Producto posee los siguientes campos:
     *    Campo nombre Obligatorio.
     *    Campo precio valor mayor a 1.
     *    campo created generado automaticamente al crear un registro.
     *    Campo modified generado automaticamente al actualizar un registro.

 Response:

 *	Formato de mensajes de respuesta de error: {"mensaje": "mensaje de error"}.


## Getting Started

### Dependencies

*	Apache Maven 3.6.1
*	java 17
*	JPA H2	
*	Swagger ui 5.2.0
*	Spring Boot 3.2.3
*	Lombok 1.18.30
*	mapstruct 1.6.0.beta1
*	Junit 5.10.2
*	Mockito 5.7.0


### Installing

1.	Realizar el clone del repositorio y descarga de las dependencias.
	```sh
	mvn clean install 
	```

2.	Ejecutar proyecto.
	```sh
	mvnw spring-boot:run
	```

3.	Ir al navegador de preferencia e ingresar http://localhost:8085/swagger-ui.html


### Docker

1.  Generar el .jar desde la carpeta raíz.
  ```sh
  .\mvnw clean package
  ```

3.  Contruir imagen.
  ```sh
  docker build .
  ```

4.  Identificar el Id de la imagen(dd0d644878fe) ejecutando el comando
   ```sh
  docker images
  ```

5.  Ejecutar la imagen.
   ```sh
  docker run -p 8000:8085 dd0d644878fe
   ```
6.	Ir al navegador de preferencia e ingresar http://localhost:8000/swagger-ui.html

### Testing

En tu navegador url http://localhost:8080/api/v2/api-docs para verificar documentacion Swagger.
importar esta documentacion con la herramienta Postman para generar los endpoints, ver https://www.baeldung.com/swagger-apis-in-postman para mas información.

## Contact

John Ocampo - [@Linkedin](https://www.linkedin.com/in/john-bayron-ocampo-fonnegra/) - bayron.ocampo.8@gmail.com

<p align="right">(<a href="# CRUD-Product">back to top</a>)</p>
   
