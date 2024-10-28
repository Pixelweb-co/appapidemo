Demo prueba tecnica

Api en spring boot (localhost) -  (aws Elastic Beanstalk) y mysql (aws RDS)

compilar en local

En la raiz de el directorio escribe

mvn clean install

y luego ejecuta el jar generado

java -jar /target/app-0.0.1-SNAPSHOT.jar

-----------------------
Api en aws: 

http://54.197.222.16:5000/api

Api en localhost
http://localhost:5000/api/

----------------------
Documentacion de la api: 

http://54.197.222.16:5000/swagger-ui/index.html

Demo en aws con rds mysql y Elastic Beanstalk

http://54.197.222.16:5000/api/franquicias/


#Instalacion en Modo local

Se crean 3 contenedores para e funcionamiento y pruebas de la app

- mysql database (3306)
- phpmyadmin (80)
- springapp (8080)



# Franquicias API

Esta API permite gestionar una lista de franquicias y sus sucursales. Proporciona endpoints para crear franquicias y listar todas las franquicias disponibles.

## Tabla de Contenidos
- [Instalación](#instalación)
- [Endpoints](#endpoints)
    - [Crear una Franquicia](#crear-una-franquicia)
    - [Obtener todas las Franquicias](#obtener-todas-las-franquicias)
- [Ejemplos de Solicitud](#ejemplos-de-solicitud)

## Instalación
1. Clona este repositorio.
2. Asegúrate de tener Docker y Docker Compose instalados.
3. Ejecuta el siguiente comando para levantar los contenedores:
   ```bash
   docker-compose up -d --build
