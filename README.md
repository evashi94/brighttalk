### Summary of the work done
user-realm-api is a web application that can save user realm into a mySQL database
and retrieve realm info from the database by accepting POST and GET REST calls.

### Limitations
1. This application has database credentials saved in the application.properties
and an alternative external dependency service should be used to retrieve this
credential otherwise it may cause security issues.
2. No logging is implemented due to time constrain

### Code coverage
- unit test line coverage: 75% classes, 83% lines
- integration test coverage: happy and unhappy path of both GET and POST endpoints

### Create the database and create user before deployment
Go to the terminal. Open MySQL client with a user that can create new users.
```$xslt
create database user_db;
create user 'brightTalkUser'@'%' identified by 'ThePassword';
grant all on user_db.* to 'brightTalkUser'@'%';
```

### Deployment instruction
1. download Apache Tomcat and un-package it into tomcat folder
2. copy the user-realm-api-0.0.1.war from root folder to tomcat/webapps/folder
3. from a terminal navigate to tomcat/bin folder and execute
```catlina.bat run``` for Windows or ```catlina.sh run``` for Unix-based systems
4. go to http://localhost:8080/alive and check application is alive
