# Plataforma de Evaluación de Madurez en Ciberseguridad

## Descripción del Proyecto

**Nombre del Producto/Servicio**: Plataforma de Evaluación de Madurez en Ciberseguridad

**Concepto**: Este proyecto consiste en una plataforma en línea que permite a las organizaciones evaluar su nivel de madurez en ciberseguridad mediante un formulario detallado. Basado en los resultados, se generan recomendaciones personalizadas, que son presentadas y discutidas con un chatbot de IA especializado. El chatbot guía al usuario en la implementación de dichas mejoras para mejorar su postura de seguridad.

## Problema a Resolver

Las organizaciones, especialmente las pequeñas y medianas empresas, a menudo no tienen los recursos para contratar expertos en ciberseguridad ni cuentan con una evaluación clara de su madurez en esta área. Esto les impide identificar vulnerabilidades y priorizar acciones críticas para proteger sus activos.

## Propuesta de Valor

- **Evaluación Accesible y Comprensible**: Formulario intuitivo que permite a las organizaciones autoevaluarse en términos de ciberseguridad sin necesidad de conocimientos técnicos avanzados.
- **Recomendaciones Personalizadas**: IA que genera recomendaciones específicas basadas en los resultados de la evaluación, adaptadas al nivel de madurez de la organización.
- **Interacción con un Chatbot de IA**: Un chatbot interactivo que ofrece soporte continuo, respondiendo preguntas y guiando en la implementación de las recomendaciones.

## Componentes del Proyecto

1. **Formulario de Evaluación**: Un cuestionario estructurado que cubre áreas clave de ciberseguridad como gestión de riesgos, políticas de seguridad, y controles de acceso.
2. **Motor de Recomendaciones de IA**: Algoritmo que analiza las respuestas del formulario y genera un reporte de madurez junto con recomendaciones prácticas.
3. **Chatbot de IA**: Asistente virtual que interactúa con los usuarios, ofreciendo explicaciones detalladas de las recomendaciones y pasos concretos para su implementación.

## Requisitos Técnicos

1. **Lenguaje de Programación**: Java
2. **Persistencia de Datos**: MongoDB Atlas
3. **Servicios REST**: Controladores desarrollados siguiendo el nivel 2 del modelo de madurez de Richardson, gestionando operaciones CRUD para los usuarios, evaluaciones, y recomendaciones.
4. **Herramientas**:
   - Repositorio en GitHub para control de versiones.
   - Trello para la gestión de tareas del equipo.
   - Herramientas de IA Generativa para el diseño de prototipos visuales.
   - Docker para la creación de contenedores y despliegue del proyecto.

## Modelos de datos

### Modelo de Base de Datos de Usuario

La clase `User` representa una colección de usuarios almacenados en una base de datos MongoDB. Cada usuario tiene un ID, nombre, apellido, correo electrónico, contraseña (hash) y una asociación con una empresa. Además, cada usuario se marca con una fecha de creación (`createdAt`).

#### Colección de MongoDB: `users`

#### Campos:

| Nombre del Campo | Tipo      | Descripción                                                                 |
| ---------------- | --------- | --------------------------------------------------------------------------- |
| `id`             | `String`  | El identificador único del usuario.                                          |
| `createdAt`      | `Date`    | La fecha y hora en que se creó el usuario (se establece automáticamente).   |
| `name`           | `String`  | El nombre del usuario.                                                      |
| `lastName`       | `String`  | El apellido del usuario.                                                    |
| `email`          | `String`  | El correo electrónico del usuario (utilizado para comunicación).            |
| `passwordHash`   | `String`  | La contraseña del usuario, almacenada de forma segura como hash.            |
| `companyId`      | `String`  | El identificador de la empresa a la que pertenece el usuario.               |

### Modelo de Base de Datos de Empresa

La clase `Company` representa una colección de empresas almacenadas en una base de datos MongoDB. Cada empresa tiene un ID, nombre, NIT (número de identificación tributaria), dirección, teléfono, correo electrónico, y detalles de contacto. Además, mantiene una lista de IDs de usuarios asociados a la empresa.

#### Colección de MongoDB: `companies`

#### Campos:

| Nombre del Campo  | Tipo        | Descripción                                                                |
| ----------------- | ----------- | -------------------------------------------------------------------------- |
| `id`              | `String`    | El identificador único de la empresa.                                       |
| `name`            | `String`    | El nombre de la empresa.                                                    |
| `nit`             | `String`    | El NIT (número de identificación tributaria) de la empresa.                 |
| `address`         | `String`    | La dirección de la empresa.                                                 |
| `phone`           | `String`    | El número de teléfono de la empresa.                                        |
| `email`           | `String`    | El correo electrónico de la empresa.                                        |
| `contactName`     | `String`    | El nombre de la persona de contacto principal de la empresa.                |
| `contactPhone`    | `String`    | El número de teléfono del contacto principal.                               |
| `contactEmail`    | `String`    | El correo electrónico del contacto principal.                               |
| `usuariosIds`     | `List<User>`| Lista de usuarios (IDs) asociados a la empresa.                             |


## Instalación y Configuración

### 1. Configurar MongoDB Atlas
1. Crear un clúster en [MongoDB Atlas](https://www.mongodb.com/cloud/atlas).
2. Configurar las credenciales de conexión en el archivo `application.properties`.

### 2. Construcción del Proyecto
```bash
./mvnw clean install
```

### 3. Ejecutar la Aplicación
```bash
./mvnw spring-boot:run
```

### 4. Front de la Aplicación 

https://github.com/Parralol/Front-IETI.git

https://simplecurity.up.railway.app/login

## Uso

- La plataforma presenta un formulario de evaluación de ciberseguridad que permite a las empresas determinar su nivel de madurez.
- El motor de IA genera un conjunto de recomendaciones personalizadas basadas en los resultados del formulario.
- El chatbot interactivo guía a los usuarios durante el proceso de implementación de mejoras.

## Pruebaas unitarias pasando

![image](https://github.com/user-attachments/assets/e7541a73-b9cc-4385-96b9-e2cc703290ea)


## Plan de Desarrollo

1. **Fase 1**: Investigación y Diseño del motor de recomendaciones.
2. **Fase 2**: Desarrollo del prototipo con el formulario de evaluación y el chatbot.
3. **Fase 3**: Pruebas con usuarios en un lanzamiento beta.
4. **Fase 4**: Lanzamiento comercial al mercado general.

## Contribuciones

* **Juan Esteban Ortiz Pastrana** - *Initial work* - [juaneortiz1](https://github.com/juaneortiz1) .

* **Nicolas Castro Jaramillo** - *Initial work* - [NicolasCastro9](https://github.com/NicolasCastro9).

* **Santiago Nicolás Parra Giraldo** - *Initial work* - [Parralol](https://github.com/Parralol)


