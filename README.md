##Spring MVC 

This sample application was created in order to play around with Thymeleaf and Spring MVC.  It was on my personal laptop lost. I found it while cleaning my dev projects so I decided to share it.

The application is composed of Spring MVC, Spring Security and Thymeleaf.  Also, I added Twitter's bootstrap for style and look + feel.

The spring-security-xml is used to configure login information.  Spring provides a variety of projects that support known industry standards such as: LDAP, OAUTH & SAML. http://projects.spring.io/spring-security/

The project uses gradle for dependency and build management.

### Requirements
1. Java 1.7
2. Gradle

### Runing the Applicaiton
From the command line type ```:> gradle jettyRun```

Then Navigate to:http://localhost:8099/spring-mvc-comp/
***user:*** **admin**
***assword:*** **password**

###TODO's
- [] deploy to Heroku App with Gradle.
- [] Wire the Project Home navbar. ```<a href="#" class="navbar-brand">Project name</a>```
