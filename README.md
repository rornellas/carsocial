# Car-Social Webservice API
Kotlin + Spring Boot + Spring HATEOAS + Reactive MongoDB

## AWS
- A api está acessível com documentação e navegação na aws sob o seguinte endereço: http://54.80.81.14/swagger-ui.html

## Requisitos
- Para executar o aplicativo, é necessário ter o docker instalado.

## Executar aplicação
Para rodar o aplicativo, dentro do diretório principal do projeto, execute execute o comando a seguir:  

- LINUX: start-project.sh
- WINDOWS: start-project.bat

## Documentação e navegação

Acesse a documentação e utilize a API no seguinte endereço: "http://localhost:8080/swagger-ui.html" ou "http://192.168.99.100:8080/swagger-ui.html" (instalação docker toolbox)

## HATEOAS

Para acessar as informações para navegação HATEOAS, acessar as seguintes url's: 

- http://localhost:8080/rides/v1/greeting
- http://localhost:8080/users/v1/greeting
- http://localhost:8080/travels/v1/greeting

ou 

- http://192.168.99.100:8080/rides/v1/greeting
- http://192.168.99.100:8080/users/v1/greeting
- http://192.168.99.100:8080/travels/v1/greeting
