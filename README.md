# aspire-app-test
Automation Test for Aspire app

## Setup and Pre-requisites
 - Java 1.8
 - TestNG 7.4.0
 - Selenium 3.141.59
 - Maven 3.3.9 (Build Tool)
 - Git 

## Supported Browsers: 
 - Chrome
 - Firefox

## Test Framework:
 - Page Object Model (POM)
 
## How to run test
For running the test suite, please follow below steps:
 - git clone https://github.com/paragdhoble/aspire-app-test.git
 - cd aspire-app-test
 - mvn -f pom.xml test -DsuiteXmlFiles=src/main/resources/TestNG.xml

