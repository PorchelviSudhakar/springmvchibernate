## SpringMVCHibernate

SpringMVCHibernate provides a simple student repository where one can store,update,delete and search 
the student related inforation like student id,steudent name etc.

## Prerequisites
1. Eclipse IDE/IntelliJ IDE
2. Tomcat Server
3. Install maven
3. JAVA 1.8

## Installing
1. Install maven into the system from https://maven.apache.org/download.cgi
2. Add Plugin for Apache Tomcat Server From Eclipse Market Place.


## Maven Project Creation
1. Install Maven Integration plugin for eclipse from Eclipse Market Place so that it can support the Maven project.
2. Create a new Maven project by File->New->Others->Maven Project

## Dependencies required for this project

1.Included dependencies and its versions were found on the POM.xml file in the project

## Project Description
1. In this project Dependency Injection configurations were done in spring-servlet.xml file in which <context:component-scan 
base-package="com.stpl.assignment"/> this command allows us to create singleton object for all the classes under this package.
2. .jsp files were used as a User Interface or Client-side.
3. Dispatcher servlet leads to the registered controller.
4. Service classes perform the CRUD operations into the database.

## Deploying this project in Tomcat Server:
1. In Eclipse IDE,right click project->Run as Tomcat Server will run your project in Tomcat Server.































