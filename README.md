# SampleAutomationFramework
  Devloped an Automation Framework for Web Project using Selenium Webdriver, TestNG, Java, Spring and Maven.

1. EcommerceSiteTest.java: Java class to automate test case which contains @Test method. Initial steps and closing browser methods are mentioned using BeforeClass and AfterClass annotation.

2. Test.properties: Properties file which contains the key value pair of detail for url, browser name, etc.

3. pom.xml: As this is a Maven project, it has pom.xml file which contains entries related to dependencies, for example, Spring, TestNG, Selenium, etc.

4. SeleniumUtil.java: This java class contains all the methods related to Selenium Webdriver. It can be used in any test class through the application.

5. ConfigBeanFactory.java: This java class is used to read properties file (except browser key) and send its value related to key to SeleniumUtil.java class.

6. SeleniumRunConfiguration.java: This java class has methods to read properties file and open mentioned browser.

7. Testng.xml: This xml file contains the suite created for project on which we can right click, select Run as TestNG and execute testcases. TestNG always generates test report in test-output folder after test execution.

8. config-bean.xml: I have used Spring Container to store locator in config-bean.xml, which can be used as object repository and property name is declared in EcommerceSiteBean.java which contains getter and setter methods for property name declared in config-bean.xml.
  
  
  
  
   
   
 
 
 

