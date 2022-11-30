# Read Me First
The goal of this project is to manage superheroes and their attributes:
create and fetch superheroes and create new attributes (e.g new powers...).
* Well-documented
* Well-tested
* Designed simply yet flexible and extendable enough for future scaling and enhancements

## Tech stack:
* Java 11
* Lombok annotations to avoid boilerplate code
* Docker to build image & run the project from anywhere
* Docker-compose to start the DB
* Postgres as a relational DB
* Flyway DB migration tool to set up tables

## Assumptions:
* We have relations between a superheroes and its attributes: powers, weapons, associations. 
* We would like to add superhero attributes, such as weapons, flexibly (the assumption is we don't have a defined, finite set of attributes)
* Attributes need to be added priorly to the creation of a hero (e.g first create weapons, associations and powers, to then create a superhero with those attributes)


## How to run this project:
Create a local postgres DB
```
docker-compose up -d
```
I Used a pgadmin client, to interact with the DB (view tables etc.), using the application.yml credentials.

Start the spring project
```
./gradlew bootRun
```

### Deploy:
Build Docker image
```
docker build -t imthedoggo/superhero .
```
Run the image locally
```
docker run -p 8081:8080 -d imthedoggo/superhero 
```

### Endpoints:

| Method  | Resource                      | Description              |
|---------|-------------------------------|--------------------------|
| POST    | /v1/super-heroes/weapons      | Create a new weapon      |
| POST    | /v1/super-heroes/associations | Create a new association |
| POST    | /v1/super-heroes/powers       | Create a new power       |
| POST    | /v1/super-heroes              | Create a new superhero   |
| GET     | /v1/super-heroes/{id}         | Get a superhero          |


### Examples

#### POST /v1/super-heroes/weapons
Request:
```
curl --location --request POST 'http://localhost:8080/v1/super-heroes/weapons' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id":"pistol"
}'
```
Response:
```
{
    "id": "pistol"
}
```
#### POST /v1/super-heroes/associations
Request:
```
curl --location --request POST 'http://localhost:8080/v1/super-heroes/associations' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id":"avangers"
}'
```
Response:
```
{
    "id": "avangers"
}
```
#### POST /v1/super-heroes/powers
Request:
```
curl --location --request POST 'http://localhost:8080/v1/super-heroes/powers' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id":"vision"
}'
```
Response:
```
{
    "id": "vision"
}
```
#### POST /v1/super-heroes
Request:
```
{
    "alias": "Captain Margfatest",
    "name": "Carol Danvers",
    "powers": [
        "vision"
    ],
    "weapons": [
        "pistol"
    ],
    "origin": "Exposed to Space Stone reactor overload",
    "associations": [
        "avangers"
    ]
}
```
Response:
```
{
    "id": 12,
    "alias": "Captain Margfatest",
    "name": "Carol Danvers",
    "powers": [
        "vision"
    ],
    "weapons": [
        "pistol"
    ],
    "origin": "Exposed to Space Stone reactor overload",
    "associations": [
        "avangers"
    ]
}
```
#### GET /v1/super-heroes/{id}
Request:
```
curl --location --request GET 'http://localhost:8080/v1/super-heroes/12' \
--data-raw ''
```
Response:
```
{
    "id": 12,
    "alias": "Captain Margfatest",
    "name": "Carol Danvers",
    "powers": [
        "vision"
    ],
    "weapons": [
        "pistol"
    ],
    "origin": "Exposed to Space Stone reactor overload",
    "associations": [
        "avangers"
    ]
}
```

## Future improvements:
* Debug the service unitests (see FIXME)
* Introduce endpoints to fully support CRUD operations for superheroes and their attributes, and extend tests accordingly
* Split the controller and service into attribute-specific classes (e.g. WeaponController, WeaponService), once extending CRUD functionalities or attribute-fields
* Introduce error handling and input validations to give better visibility for client requests
* Authentication e.g. access with JWT token
* Add an API rate limit for security reasons