### Summary of the work done

### Limitations

// https://spring.io/guides/gs/accessing-data-mysql/
### Create the database and create user
Go to the terminal. Open MySQL client with a user that can create new users.
```$xslt
create database user_db;
create user 'brightTalkUser'@'%' identified by 'ThePassword';
grant all on user_db.* to 'brightTalkUser'@'%';
```

### Code coverage
- unit test line coverage 75%
- integration test coverage


### Deployment instruction
 A readme file detailing how to deploy, a summary of the work done, and limitations
(test coverage and time constraints)