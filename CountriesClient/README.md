# Countries Client
A simple java app to consume the Countries API.

Ps: Be in mind that it is just a simple project, so I avoided the use of 
frameworks and libraries that could make the work a little easier, 
but also the project a lot heavier.

## How it works
The Countries Client has two different modes. One get all countries 
information, and the other gets the information of a desired country.

### Get all countries info
To run this mode, you should just run the client.

Example: `java -jar countriesclient`

This way, the app will consume the /api/countries/ route and show all 
countries information.


### Get one country info
To run this mode, you should run the client passing the code of the
desired country.

Example: `java -jar countriesclient BR` 

Once you run the app with the Country's code parameter, the client will
consume the /api/countries/<<CODE>>, wich will return only the desired 
country's info.

## Build
To build the project, simply execute the following command on the
project's root directory:
`mvn verify`

## Technologies
- Java 8
- Maven
- RESTEasy
