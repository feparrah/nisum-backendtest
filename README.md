# nisum-backendtest

Como correr la aplicacion:

Prerequisitos:
1. JDK 8+
2. Postman u otra app de prueba de APIs
3. Maven

Ejecución

Sobre la raiz del proyecto en una terminal (cmd o bash) ejecutar el comando ``mvn spring-boot:run``

Registro de Usuario

Para registrar un usuario ejecute una peticion POST al recurso /user desde su app de prueba con la siguiente estructura: 
``curl --location 'http://localhost:8080/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Juan Rodriguez",
    "email": "jua@rodriguez.orgio",
    "password": "gfjfdgfdg",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "countrycode": "32"
        }
    ]
}'``
