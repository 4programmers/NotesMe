This project is a simple scaffold for SpringMVC+JPA application.
It is rather simplistic, but contains some useful configuration items:
- Proper handling of UTF-8 encoding in forms
- Mapping responses to json
- Can be compiled into runnable war when build with "mvn package package". Runnable war can be executed as any runnable jar archive by "java -jar nameOfApp.war", and it will start an embedded jetty server.
- By default data source is set to file H2 database which will be created in CWD after application is run.

Because of the last two points, this scaffold application can be run without any need for additional configuration -> user only needs to have Java JRE and can run a webapplication.