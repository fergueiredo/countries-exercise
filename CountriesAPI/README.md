# CountriesAPI
A simple java web app that provide two rest endpoints.

Ps: Be in mind that it is just a simple project, so I avoided the use of 
frameworks and libraries that could make the work a little easier, 
but also the project a lot heavier.

In a production-driven project we should implement a lot more features, like:
- caching
- database connection pool
- limit the amount of requests
- creation of user tokens
- etc. 


## How it works
This web app provide two routes to get countries info.
It must be deployed on Wildfly

### Important!
To use the CountriesClient, this project must be deployed on `localhost:8080`.


### All Countries Info
To get all countries previous added info, just navigate to:
`http://localhost:8080/countriesapi/api/countries/`

This route will provide a JSON with the code, english name and french name 
of all registered countries.


### One Country Info
To get an especific country info, just navigate to:
`http://localhost:8080/countriesapi/api/countries/<<CODE>>`

This route will provide a JSON with the code, english name and french name 
of the desired country.


## Build
To build the project, simply execute the following command on the
project's root directory:
`mvn verify`

## Run
Just move the WAR file to yours WildFly standalone/deployments.

## Seeing the results
There are many ways to check the results. You could use a browser, an rest application 
like Postman, the *CountriesClient*, etc.

To use a browser, just navigate to the URLs described above.

To use the CountriesClient, just follow it's README.


## Technologies
- Java 8
- Maven
- MongoDB 3.6.8
- WildFly
