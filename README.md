Demo prueba tecnica

Api en spring boot y mysql

compilar en local

En la raiz de el directorio escribe

mvn clean install

y luego ejecuta el jar generado

java -jar /target/app-0.0.1-SNAPSHOT.jar

En docker

escribe en la consola:

docker-compose up -d --build

crea tres servicios

- mysql database (3306)
- phpmyadmin (80)
- springapp (8080)

- Demo en aws con rds mysql

http://apidemoaws.us-east-2.elasticbeanstalk.com/