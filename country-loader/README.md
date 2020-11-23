# Country Loader
A simple java app to load countries from a CSV file into MongoDB.

Ps: Be in mind that it is just a simple project, so I avoided the use of 
frameworks and libraries that could make the work a little easier, 
but also the project a lot heavier.

In a production-driven project we should implement a lot more features, like:
- validate the data
- use a CSV parser 
- use a database connection pool
- etc. 


## How it works
The Country Loader has two different modes. The single time run and the 
listener.

In both cases it will update an existing country data, or create if it 
doesn't exist yet. 

In neither case it will remove existing stored countries.

Now, lets see how the modes work.


### Single time run
To run this mode, you should run with "execute" flag followed by the 
CSV file path.

Example: `java countryloader execute ~/countries/countries.csv` 

This way, the app will load the countries from the CSV file to MongoDB and
stop.
Every time you run this mode the content of the file is loaded to the DB, 
doesn't matter if it was already previously added.


### Listener mode
To run in listener mode, you should run with "monitor" flag followed
by the directory that should be monitored.

Example: `java countryloader monitor ~/countries` 

Once you run the app in the listener mode it will keep running and will load 
every new CSV file stored on the mentioned folder.

This mode saves a hash of the file as well as the current timestamp, so one 
same file will never be loaded twice.
If you need to load a file that was previously added, you can use one of the
following methods:
- Run the *Single Time* mode with the wanted file
- Rename the file
- Update its content


## Build
To build the project, simply execute the following command on the
project's root directory:
`mvn verify`


## Technologies
- Java 8
- Maven
- MongoDB 3.6.8
