// https://spring.io/guides/gs/accessing-data-mysql/
Create the database
Go to the terminal (command Prompt cmd in Microsoft Windows). Open MySQL client with a user that can create new users.

For example: On a Linux, use the command

$ sudo mysql --password
This connects to MySQL as a root, and allows access to the user from all hosts, this is not the recommended way for a production server.
Create a new database

mysql> create database db_example; -- Create the new database
mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all the privileges to the new user on the newly created database


create database user_db;
create user 'brightTalkUser'@'%' identified by 'ThePassword';
grant all on user_db.* to 'brightTalkUser'@'%';