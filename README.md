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

En docker

escribe en la consola:

docker-compose up -d --build

crea tres servicios

- mysql database (3306)
- phpmyadmin (80)
- springapp (5000)


Demo en aws con rds mysql y Elastic Beanstalk

http://54.197.222.16:5000/api/franquicias/


## Endpoints

# Crear una Franquicia
URL: /api/franquicias/
Método: POST
Descripción: Crea una nueva franquicia con un nombre especificado.

# Cuerpo de Solicitud (JSON):

{
  "nombre": "Nombre de la Franquicia"
}

# Respuesta Exitosa (Código 200):

{
  "id": 1,
  "nombre": "Nombre de la Franquicia",
  "sucursales": []
}

-----------------------------------------
# Obtener todas las Franquicias

URL: /api/franquicias/
Método: GET
Descripción: Obtiene una lista de todas las franquicias.
Respuesta Exitosa (Código 200):

[
  {
    "id": 1,
    "nombre": "Nombre de la Franquicia",
    "sucursales": []
  },
  {
    "id": 2,
    "nombre": "Otra Franquicia",
    "sucursales": []
  }
]

## Ejemplos de Solicitud

# Crear una Franquicia
curl -X POST http://localhost:5000/api/franquicias/ -H "Content-Type: application/json" -d '{"nombre": "Mi Nueva Franquicia"}'

# Respuesta Exitosa:
{
  "id": 1,
  "nombre": "Mi Nueva Franquicia",
  "sucursales": []
}

# Obtener todas las Franquicias

curl -X GET http://localhost:5000/api/franquicias/ -H "Content-Type: application/json"

# Respuesta Exitosa:

[
  {
    "id": 1,
    "nombre": "Mi Nueva Franquicia",
    "sucursales": []
  },
  {
    "id": 2,
    "nombre": "Otra Franquicia",
    "sucursales": []
  }
]

# Notas

Asegúrate de que el servidor esté en ejecución en localhost:5000.
Los datos de ejemplo pueden variar dependiendo de las franquicias añadidas.


Este archivo README proporciona una guía clara para los usuarios de la API, detallando cómo realizar solicitudes y los formatos esperados en las respuestas.

