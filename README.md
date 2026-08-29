# Laboratorio V - Creación de APIs REST

## Información

**Estudiante:** ashly Aquino

**Sección:** C

**Curso:** Programación II

**Laboratorio:** V - Creación de APIs REST

## Descripción

Este proyecto contiene la implementación de 10 APIs REST desarrolladas utilizando Java y Spring Boot.

Las APIs permiten realizar operaciones CRUD mediante los métodos HTTP:

- GET
- POST
- PUT
- PATCH
- DELETE

## APIs implementadas

1. **Productos** - `/api/productos`
2. **Estudiantes** - `/api/estudiantes`
3. **Libros** - `/api/libros`
4. **Empleados** - `/api/empleados`
5. **Películas** - `/api/peliculas`
6. **Cursos** - `/api/cursos`
7. **Vehículos** - `/api/vehiculos`
8. **Tareas** - `/api/tareas`
9. **Clientes** - `/api/clientes`
10. **Pedidos** - `/api/pedidos`

Cada API cuenta con los siguientes endpoints:

```text
GET     /api/recurso
GET     /api/recurso/{id}
POST    /api/recurso
PUT     /api/recurso/{id}
PATCH   /api/recurso/{id}
DELETE  /api/recurso/{id}
```

## Tecnologías utilizadas

- Java
- Spring Boot
- Maven
- REST API
- Postman
- Git
- GitHub

## Estructura del proyecto

```text
spring-apis-lab/
├── pom.xml
├── README.md
├── .gitignore
├── postman/
│   └── APIs REST - LaboratorioV.json
├── evidencias/
│   └── Oliver_Yecute_SeccionC_LaboratorioV.pdf
└── src/
    └── main/
        ├── java/
        │   └── com/lab/apis/
        │       ├── ApisApplication.java
        │       ├── controller/
        │       └── model/
        └── resources/
            └── application.properties
```

## Evidencias

Las pruebas de las APIs realizadas mediante Postman se encuentran en el documento PDF ubicado en:



## Repositorio

