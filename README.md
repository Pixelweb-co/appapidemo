Demo prueba tecnica

Api en spring boot (localhost) -  (aws Elastic Beanstalk) y mysql (aws RDS)

compilar en local

En la raiz de el directorio escribe

mvn clean install

y luego ejecuta el jar generado

java -jar /target/app-0.0.1-SNAPSHOT.jar

-----------------------
Api en aws: 

http://3.88.55.138:5000/api

Api en localhost
http://localhost:5000/api/

----------------------
Documentacion de la api: 

http://3.88.55.138:5000/swagger-ui/index.html

En docker

escribe en la consola:

docker-compose up -d --build

crea tres servicios

- mysql database (3306)
- phpmyadmin (80)
- springapp (8080)
