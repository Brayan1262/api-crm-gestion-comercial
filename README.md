# API CRM Gestión Comercial🛡️

> API REST tipo CRM desarrollada para la gestión comercial empresarial. Permite registrar clientes, administrar contactos, controlar oportunidades de venta, programar actividades de seguimiento y visualizar indicadores clave mediante un dashboard CRM inspirado en Salesforce.
>
> ![Java](https://img.shields.io/badge/JAVA-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring Boot](https://img.shields.io/badge/SPRING_BOOT-3-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/POSTGRESQL-DB-316192?style=for-the-badge&logo=postgresql&logoColor=white) ![Docker](https://img.shields.io/badge/DOCKER-Compose-2CA5E0?style=for-the-badge&logo=docker&logoColor=white) ![Swagger](https://img.shields.io/badge/SWAGGER-OpenAPI-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)

---

## 🚀 Características Principales

- **Gestión Estructurada:** Operaciones CRUD completas para **Clientes** (Empresas), **Contactos**, **Oportunidades Comerciales** y **Actividades de Seguimiento**.
- **Dashboard Gerencial:** Endpoints integrados para visualizar indicadores en tiempo real (clientes activos, oportunidades ganadas/perdidas, montos estimados, etc.).
- **Arquitectura Robusta:** Aplicación de buenas prácticas REST, arquitectura en capas, validaciones exhaustivas de datos (Bean Validation) y manejo global centralizado de errores.
- **Infraestructura Moderna:** Persistencia de datos con PostgreSQL y despliegue rápido aislado usando contenedores Docker.
- **Documentación Activa:** Autogeneración de documentación interactiva a través de Swagger / OpenAPI para un consumo simplificado por parte de aplicaciones Frontend.

---

## 🛠️ Stack Tecnológico

| Capa | Tecnologías |
| :--- | :--- |
| **Framework Base** | Java 21, Spring Boot 3, Spring Web |
| **Persistencia de Datos** | PostgreSQL, Spring Data JPA, Hibernate |
| **Herramientas Clave** | Lombok, Bean Validation, Maven |
| **Documentación API** | Swagger / OpenAPI |
| **Orquestación DevOps** | Docker, Docker Compose |

---

## 🏗️ Arquitectura del Sistema

El proyecto sigue una estructura limpia dentro de `src/main/java/`:

```text
com.brayan.salesflow
├── config/       # Configuraciones globales (Swagger, CORS, etc.)
├── controller/   # Controladores REST expuestos
├── dto/          # Objetos de Transferencia de Datos (Request/Response)
├── entity/       # Modelos de Base de Datos (Hibernate/JPA)
├── exception/    # Controladores globales de excepciones (@ControllerAdvice)
├── repository/   # Interfaces de acceso a base de datos
└── service/      # Lógica de negocio y reglas comerciales
```

---

## 📊 Endpoints Principales (Módulos)

### 🏢 Clientes (`/api/customers`)
Administración de cuentas o empresas comerciales con sus respectivos estados (`ACTIVE`, `INACTIVE`, `PROSPECT`).

### 👤 Contactos (`/api/contacts`)
Gestión de personas de contacto asociadas relacionalmente a un cliente específico.

### 💰 Oportunidades (`/api/opportunities`)
Control de embudo de ventas. Estados: `NEW`, `CONTACTED`, `PROPOSAL`, `NEGOTIATION`, `WON`, `LOST`.

### 📅 Actividades (`/api/activities`)
Registro de tareas y seguimientos comerciales (`CALL`, `EMAIL`, `MEETING`, `TASK`, `NOTE`).

### 📈 Dashboard (`/api/dashboard`)
Resumen de KPIs: Total de clientes, oportunidades abiertas vs ganadas, monto total estimado, tareas pendientes.

---

## 🚀 Roadmap y Futuras Mejoras

- [ ] Implementar sistema de Autenticación y Autorización de seguridad con **JWT**.
- [ ] Incorporar Roles de acceso comerciales (`ADMIN`, `SALES`, `SUPPORT`).
- [ ] Desarrollar cliente Frontend dinámico completo en **Angular**.
- [ ] Generación automática de reportes de ventas en formato PDF y exportación en Excel.
- [ ] Implementar un módulo de auditoría de cambios comerciales (Historial de acciones).
- [ ] Despliegue automatizado de la arquitectura en la Nube.

---

## 👨‍💻 Autor

**Brayan Jair Chavez Oscor**
*Ingeniería de Software / Arquitectura Backend*

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Brayan1262)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/brayan-chavez-218088334/)
[![Portfolio](https://img.shields.io/badge/Portfolio-000000?style=for-the-badge&logo=web&logoColor=white)](https://brayan1262.github.io/portafolio-brayan/)