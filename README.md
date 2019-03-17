# La Mejor Cocina

Prueba tecnica en la cual se desea crear una aplicación que permita registrar las facturas de las ventas realizadas en el restaurante “LA MEJOR COCINA”. La aplicación debe contener el siguiente listado de requerimientos

## Comenzando 🚀

### Pre-requisitos 📋

```
- Se debe tener instalada la BD Postgresql versión 10.6.
- Se debe tener instalado JDK 1.8.
- Se debe tener el servidor wildfly-10.0.0.Final.
- Se debe tener Eclipse la versión manejada es la Neon.
- Se debe tener instalado o configurado el Maven.
- Se debe tener instalado o configurado Git en su versión 2.17 o superior.
```

### Instalación 🔧

```
- Correr en Postgres el script del Modelo de E/R del proyecto.
- Tener configurado el JAVA_HOME que apunte a la versión del JDK instalado.
- Tener configurado la MAVEN_HOME que apunte al Maven que hemos instalado.
- Clonar el proyecto del GitHub mediante Git a través de su gitBash.
- Importar en el Eclipse el proyecto que hemos clonado.
- Configurar el wildfly como servidor en el Eclipse.
- Compilar el proyecto mediante Maven Clean y Maven Install en las opciones de RUN.
- Subier el servidor y añadir el proyecto compilado en las opciones de despligue del servidor.

Para acceder a los endpoints de los servicios Rest se pueden acceder al path base
http://localhost:8080/lamejorcocina/api/v1/

y este seria el ejemplo del consumo de un servicio Rest tipo Get

http://localhost:8080/lamejorcocina/api/v1/factura
```

## Construido con 🛠️

* [Maven](https://maven.apache.org/) - Manejador de dependencias
