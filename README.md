# Spring Boot Minimal Web Application

[![GitHub forks](https://img.shields.io/github/forks/Spring-Boot-Framework/Spring-Boot-Minimal-Web-App)](https://github.com/Spring-Boot-Framework/Spring-Boot-Minimal-Web-App/network)
[![GitHub pull requests](https://img.shields.io/github/stars/Spring-Boot-Framework/Spring-Boot-Minimal-Web-App)](https://github.com/Spring-Boot-Framework/Spring-Boot-Minimal-Web-App/stargazers)
[![GitHub last commit](https://img.shields.io/github/last-commit/Spring-Boot-Framework/Spring-Boot-Minimal-Web-App)](https://github.com/Spring-Boot-Framework/Spring-Boot-Minimal-Web-App/stargazers)
[![BCH compliance](https://bettercodehub.com/edge/badge/Spring-Boot-Framework/Spring-Boot-Minimal-Web-App?branch=main)](https://bettercodehub.com/)

This is a simple Spring Boot Web Application with REST end point's with minimal code for quick testing of deployment services and other purposes.

## Installing

#### Running the application with IDE

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `io.github.anantharajuc.sbmwa` class from your IDE.

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

#### Running the application with Maven

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
$ git clone https://github.com/Spring-Boot-Framework/Spring-Boot-Minimal-Web-App.git
$ cd Spring-Boot-Application-Template
$ mvn spring-boot:run
```

#### Running the application with Executable JAR

The code can also be built into a jar and then executed/run. Once the jar is built, run the jar by double clicking on it or by using the command 

```shell
$ git clone https://github.com/Spring-Boot-Framework/Spring-Boot-Application-Template.git
$ cd Spring-Boot-Minimal-Web-App
$ mvn clean package
$ java -jar target/Spring-Boot-Minimal-Web-App-0.0.1-SNAPSHOT.jar
```

To shutdown the jar, follow the below mentioned steps on a Windows machine.

*	In command prompt execute the **jcmd** command to print a list of all running Java processes
*	**Taskkill /PID PROCESS_ID_OF_RUNNING_APP /F** execute this command by replacing the **PROCESS_ID_OF_RUNNING_APP** with the actual process id of the running jar found out from executing the previous command

## Explore Rest APIs

### URLs

|            URL          | Method |                      Remarks                       |
|-------------------------|--------|----------------------------------------------------|
|`http://localhost:8080/` | GET    | Simple Web Controller, returns a `String` response.|
|`http://localhost:8080/` | PUT    | Simple Web Controller, returns a `String` response.|
|`http://localhost:8080/` | POST   | Simple Web Controller, returns a `String` response.|
|`http://localhost:8080/` | DELETE | Simple Web Controller, returns a `String` response.|

**`curl http://localhost:8080/`** produces a sample response like **`HTTP GET Handled - 2021-05-25T15:02:16.928`**

## Docker

docker images  
docker build -t spring-boot-minimal-web-app .  
docker images  

docker run -p 8080:8080 --name spring-boot-minimal-web-app spring-boot-minimal-web-app  
docker ps  
docker ps -a  

docker stop spring-boot-minimal-web-app  

docker images  
docker rm spring-boot-minimal-web-app  
docker image rm -f spring-boot-minimal-web-app  

docker tag spring-boot-minimal-web-app anantha/spring-boot-minimal-web-app:latest  
docker push anantha/spring-boot-minimal-web-app:latest  