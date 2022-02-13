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

## Test Cases
For all the automated cases, you can find the detailed Test cases and scenarios at:  Resources>>TestCasesAspire

## Features
 - Some important information like browser and credentials are configured in 'application.properties' and makes it easy to modify as and when needed
 - Passing '-Denv=dev' argumet while running will run this automation for specific environment like for this instance developement env. In this scenario it will read data from application-dev.properties. These properties can be added as per the environments we have to test. This helps when we have different environments to run our automation against
 
##Project Structure
 - In Base >> We write the launch the Browsers
 - Pages >> We kept all the locators and the methods related to particular page
 - Scenarios >> we kept all the Testcase
 - Util >> Kept the logic to read properties file
 - Warpper class >> We write the wrapper method which we used
 - Resources >> Applicatio Properties amd driver.exe , TestNG.xml
 