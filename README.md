# SampleAutomationFramework
  Devloped a Automation Framework for Web Project using Selenium Webdriver,TestNG,Java,Spring,Maven
  
 #EcommerceSiteTest Java class
  Class to Automate Test Case which contains @Test method.As well as intial step and closing browser method is mention using BeforeClass  and AfterClass annotation
  
 #Test.properties File
  Properties file contain the key value pair of detail for url,browsername etc
  
 #pom.xml file
 As we have used mavenized project so we need to create Java Maven project which creates pom.xml file which contains entries related to jar file ex Spring,testng,selenium etc
 
 #SeleniumUtil
   SeleniumUtil contains all the methods related to Selenium Webdriver.It can be used in any test class through the application
   
 #ConfigBeanFactory
  This java class is used to read properties file(except browser key) and send its value related to key to SeleniumUtil.java class
  
 #SeleniumRunConfiguration
   Metthod to read properties file and open mentioned Browser
   
 #Testng.xml
  Testng.xml file contains the suite created for project on which we can right click,select Run as TestNG and execute testcases
  
 #config-bean.xml
  I have used spring contian to store locator in config-bean.xml which can be used as object repository and property name is declared in EcommerceSiteBean which contains getter setter code for propert name declared in config-bean.xml
  
  
  
  
   
   
 
 
 

