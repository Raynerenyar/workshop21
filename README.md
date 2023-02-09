# Deploying to Railway and their MySQL


## Add.env with the following contents
- ### For localhost development
    ```
    MYSQLUSER=<user>
    MYSQLPASSWORD=<password>
    MYSQLDATABASE=
    MYSQLHOST=
    MYSQLPORT=
    MYSQL_URL=jdbc:mysql://localhost/<schema name>
    ```
- ### For deploying to Railway MySQL and using root user
    `MYSQLUSER=root` if using root user.

    Spring runs `MySqlConfig.java` and pulls railway's environment variables to connect to railway's MySQL.

- ### For deploying to Railway MySQL and using new user
    #### share these variables to railway
    ```
    MYSQLUSER=<user>
    MYSQLPASSWORD=<password>
    ```
## This workshop requires the creation of the following database:
[mywind_database folder](src/main/java/sg/edu/nus/iss/workshop21/mywind_database)

[Create mywind database](src/main/java/sg/edu/nus/iss/workshop21/mywind_database/northwind.sql)

[Populate mywind](src/main/java/sg/edu/nus/iss/workshop21/mywind_database/northwind-data.sql)