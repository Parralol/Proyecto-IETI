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

## Instalación y Configuración

### 1. Clonar el Repositorio
```bash

```

### 2. Configurar MongoDB Atlas
1. Crear un clúster en [MongoDB Atlas](https://www.mongodb.com/cloud/atlas).
2. Configurar las credenciales de conexión en el archivo `application.properties`.

### 3. Construcción del Proyecto
```bash
./mvnw clean install
```

### 4. Ejecutar la Aplicación
```bash
./mvnw spring-boot:run
```

## Uso

- La plataforma presenta un formulario de evaluación de ciberseguridad que permite a las empresas determinar su nivel de madurez.
- El motor de IA genera un conjunto de recomendaciones personalizadas basadas en los resultados del formulario.
- El chatbot interactivo guía a los usuarios durante el proceso de implementación de mejoras.

## Plan de Desarrollo

1. **Fase 1**: Investigación y Diseño del motor de recomendaciones.
2. **Fase 2**: Desarrollo del prototipo con el formulario de evaluación y el chatbot.
3. **Fase 3**: Pruebas con usuarios en un lanzamiento beta.
4. **Fase 4**: Lanzamiento comercial al mercado general.

## Contribuciones

* **Juan Esteban Ortiz Pastrana** - *Initial work* - [juaneortiz1](https://github.com/juaneortiz1) .

* **Nicolas Castro Jaramillo** - *Initial work* - [NicolasCastro9](https://github.com/NicolasCastro9).

* **Santiago Nicolás Parra Giraldo** - *Initial work* - [Parralol](https://github.com/Parralol)


