# Spring Boot Server Applcation
<img src="https://huongdanjava.com/wp-content/uploads/2018/03/spring-boot-1.png">

## Requirements
1. Java - 1.8.x.
2. Maven - 4.x.x.
3. Git - 2.x.x


## Steps to Setup
### 1. Clone the application
* Create folder for contain project and open Git bash in it
* Type: 
  * HTTPS: git clone https://github.com/thanhlongvl/springbootserversportstore.git

  * SSH: git clone git@github.com:thanhlongvl/springbootserversportstore.git

<img src="https://i.imgur.com/VuaimFz.png">

### 2. Set up database and connect to MySQL
* Run all query in **query.sql** file with MySQL to create database
* Open project with IntelliJ IDEA or Eclipse then search **application.properties** file and edit code to connet with MySQL and database.
  * spring.datasource.url=jdbc:mysql://localhost:3306/sportstore
  * spring.datasource.username=yourusername
  * spring.datasource.password=yourpassword

<img src="https://i.imgur.com/vMEIa8U.png">

### 3. Build and run the app
Run app with Run->Runproject