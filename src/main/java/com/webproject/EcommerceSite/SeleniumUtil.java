package com.webproject.EcommerceSite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*SeleniumUtil Class contains all Selenium WebDriver methods to be used in Automating script and called in TestClass*/

public class SeleniumUtil {

	public static WebDriver         webDriver;
	final static Logger LOG = Logger.getLogger(SeleniumUtil.class);
	public static EcommerceSiteBean ecommerceBean;

	public static void getInitialContext() {
		System.out.println("in method");
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("config-bean.xml");
			ecommerceBean=(EcommerceSiteBean)context.getBean("ecommerceSitebean");  
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}

	}
	public static void driverInit(){
		//In future if you need to Run your condition in jenkins you can add code here 
		SeleniumRunConfiguration runConfig = new SeleniumRunConfiguration();
		webDriver = runConfig.getRunningBrowser();
		webDriver.manage().window().maximize();
	}

	public static void launchApplication() {
		try {
			String url=ConfigBeanFactory.getLoginUrl();
			webDriver.get(url);
		}
		catch ( Exception ex ) {
			ex.printStackTrace();
		}

	}

	public static WebElement findElementByName(final String elementName) {
		WebElement elementFetched = null;
		try {

			elementFetched = webDriver.findElement(By.name(elementName));
			LOG.info("Element Fetched: " + elementFetched);
			System.out.println("Element Fetched: " + elementFetched);

		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with name " + elementName + "was found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return elementFetched;
	}

	public static WebElement findElementByClassName(final String elementName) {
		WebElement elementFetched = null;
		try {
			elementFetched = webDriver.findElement(By.className(elementName));
			LOG.info("Element Fetched: " + elementFetched);
			System.out.println("Element Fetched: " + elementFetched);

		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with name " + elementName + "was found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return elementFetched;
	}

	public static WebElement findElementById(final String elementId) {
		WebElement elementFetched = null;
		try {
			elementFetched = webDriver.findElement(By.id(elementId));
			LOG.info("Element Fetched: " + elementFetched.getText());
			System.out.println("Element Fetched: " + elementFetched.getText());
		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with element Id " + elementId + "was found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return elementFetched;
	}

	public static WebElement findElementByText(final String text) {
		WebElement elementFetched = null;
		try {
			elementFetched = webDriver.findElement(By.linkText(text));
			LOG.info("Element Fetched: " + elementFetched.getText());
			System.out.println("Element Fetched: " + elementFetched.getText());
		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with such text " + text + "was found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return elementFetched;
	}

	public static WebElement findElementByPartialLinkText(final String partialLinkText) {
		WebElement elementFetched = null;
		try {
			elementFetched = webDriver.findElement(By.partialLinkText(partialLinkText));
			LOG.info("Element Fetched: " + elementFetched.getText());
			System.out.println("Element with Name: " + elementFetched.getText());

		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with partial link text " + partialLinkText + "was found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return elementFetched;
	}

	public static WebElement findElementByXpath(final String xpathVar) {
		WebElement elementFetched = null;
		try {
			elementFetched = webDriver.findElement(By.xpath(xpathVar));
			//LOG.info("Element with Name: " + elementName);
		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with XpathId  " + xpathVar + "was found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return elementFetched;
	}

	public static String findElementByXpathGetText(final String xpathVar) {
		String elementName = null;
		try {
			elementName = webDriver.findElement(By.xpath(xpathVar)).getText();
			LOG.info("Element with Name: " + elementName);
			System.out.println("Element with Name: " + elementName);
		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with XpathId  " + xpathVar + "was not found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return elementName;
	}

	public static WebElement findElementByCSS(final String cssSelector) {
		WebElement elementFetched = null;
		try {
			elementFetched = webDriver.findElement(By.cssSelector(cssSelector));
			String elementName = elementFetched.getText();
			LOG.info("Element with Name: " + elementName);
			System.out.println("Element with Name: " + elementName);
		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with XpathId  " + cssSelector + "was not found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return elementFetched;
	}

	/* */
	public static boolean findElementByAttributeName(final String xpathvar, String attributeName) {
		boolean elementName = false;
		try {
			elementName = webDriver.findElement(By.xpath(xpathvar)).getAttribute(attributeName) != null;
			LOG.info("Element with Name: " + elementName);
			System.out.println("Element with Name: " + elementName);
		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with XpathId  " + xpathvar + "was not found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return elementName;
	}
	public static String findElementByAttributeNameString(final String xpathvar, String attributeName) {
		WebElement elementName=null;
		String attValue =null;
		try {
			elementName = webDriver.findElement(By.xpath(xpathvar));
			attValue=elementName.getAttribute(attributeName);
			LOG.info("Element with Name: " + elementName);
			System.out.println("Element with Name: " + elementName);
		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with XpathId  " + xpathvar + "was not found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return attValue;
	}

	public static void clickButtonByName(final String elementName) {
		findElementByName(elementName).click();
	}
	public static void clickButtonByXpath(final String xpathVar) {
		findElementByXpath(xpathVar).click();
	}
	public static void clickButtonByCss(final String cssSelector){
		findElementByCSS(cssSelector).click();
	}
	public static void refreshPage(){
		webDriver.navigate().refresh();
	}

	public static void wait(final int timeInSeconds) {
		webDriver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
		try {
			Thread.sleep(timeInSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void setValue(final String elementName, final String valueToSet) {
		findElementByName(elementName).sendKeys(valueToSet);
	}

	public static void setValueWithXpath(final String xpathvar, final String valueToSet) {
		webDriver.findElement(By.xpath(xpathvar)).clear();
		findElementByXpath(xpathvar).sendKeys(valueToSet);
	}

	public static boolean findElementByXpath(final String xpathVar, final String expectedTextOnElement) {
		WebElement elementFetched = null;
		boolean flag = false;
		try {

			elementFetched = webDriver.findElement(By.xpath(xpathVar));
			String actualTextOnElement = elementFetched.getText();
			System.out.println(actualTextOnElement);
			LOG.info("Actual Text on Element: " + actualTextOnElement);
			if ( actualTextOnElement.contains(expectedTextOnElement) ) {
				System.out.println("Actual Matches expected.");
				flag = true;
			} else {
				System.out.println("Actual does not Matches expected.");
			}
		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with XpathId " + xpathVar + "was found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return flag;
	}

	public static boolean findElementByCssselector(final String linktext, final String expectedTextOnElement) {
		WebElement elementFetched = null;
		boolean flag = false;
		try {
			elementFetched = webDriver.findElement(By.cssSelector(linktext));
			String actualTextOnElement = elementFetched.getText();
			System.out.println(actualTextOnElement);
			LOG.info("Actual Text on Element: " + actualTextOnElement);
			if ( actualTextOnElement.contains(expectedTextOnElement) ) {
				System.out.println("Actual Matches expected.");
				flag = true;
			} else {
				System.out.println("Actual does not Matches expected.");
			}
		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with XpathId " + linktext + "was found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return flag;
	}
	public static boolean findElementByClassName(final String classname, final String expectedTextOnElement) {
		WebElement elementFetched = null;
		boolean flag = false;
		try {
			elementFetched = webDriver.findElement(By.className(classname));
			String actualTextOnElement = elementFetched.getText();
			System.out.println(actualTextOnElement);
			LOG.info("Actual Text on Element: " + actualTextOnElement);
			if ( actualTextOnElement.contains(expectedTextOnElement) ) {
				System.out.println("Actual Matches expected.");
				flag = true;
			} else {
				System.out.println("Actual does not Matches expected.");
			}
		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with XpathId " + classname + "was found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return flag;
	}
	public static boolean findElementByXpathId(final String xpathVar, final String expectedTextOnElement) {
		WebElement elementFetched = null;
		boolean flag = false;
		try {
			elementFetched = webDriver.findElement(By.id(xpathVar));
			String actualTextOnElement = elementFetched.getText();
			System.out.println(actualTextOnElement);
			LOG.info("Actual Text on Element: " + actualTextOnElement);
			if ( actualTextOnElement.contains(expectedTextOnElement) ) {
				System.out.println("Actual Matches expected.");
				flag = true;
			} else {
				System.out.println("Actual does not Matches expected.");
			}
		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with XpathId " + xpathVar + "was found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return flag;
	}
	public static boolean findElementByPartialLinkText(final String linkText, final String expectedTextOnElement) {
		WebElement elementFetched = null;
		boolean flag = false;
		try {
			elementFetched = webDriver.findElement(By.partialLinkText(linkText));
			String actualTextOnElement = elementFetched.getText();
			System.out.println(actualTextOnElement);
			LOG.info("Actual Text on Element: " + actualTextOnElement);
			if ( actualTextOnElement.contains(expectedTextOnElement) ) {
				System.out.println("Actual Matches expected.");
				flag = true;
			} else {
				System.out.println("Actual does not Matches expected.");
			}
		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with XpathId " + linkText + "was not found.");
			ex.printStackTrace();
			closeBrowser();
		}
		return flag;
	}
	public static void clickButtonByPartialLinkText(final String partialLinkText) {
		findElementByPartialLinkText(partialLinkText).click();
	}

	public static boolean moveHoverOnanElementUsingXPath(String xpath) throws InterruptedException {
		boolean mouseHover = false;

		WebElement myElement = webDriver.findElement(By.xpath(xpath));

		Actions builder = new Actions(webDriver);

		builder.moveToElement(myElement).build().perform();

		if ( null != myElement ) {
			mouseHover = true;
			LOG.info("Mouse hovered successfully on " + myElement.getText());
			System.out.println("Mouse hovered successfully on " + myElement.getText());
		}

		return mouseHover;

	}

	public static boolean menuHoverElementUsingXPath(String mainLink, String subLink1, String subLink2) throws InterruptedException {
		boolean mouseHover = false;
		WebElement menuHoverLink = webDriver.findElement(By.xpath(mainLink));
		Actions builder = new Actions(webDriver);
		Thread.sleep(1000);
		builder.moveToElement(menuHoverLink);
		WebElement menuHoversubLink1 = webDriver.findElement(By.xpath(subLink1));
		builder.moveToElement(menuHoversubLink1);
		Thread.sleep(1000);
		WebElement menuHoversubLink2 = webDriver.findElement(By.xpath(subLink2));
		builder.moveToElement(menuHoversubLink2).build().perform();
		builder.click();
		if ( null != menuHoversubLink2 ) {
			mouseHover = true;
			LOG.info("Mouse hovered and successfully clicked on SubLink " + menuHoversubLink2.getText());
			System.out.println("Sucessfully clicked on menu hover sublink" + menuHoversubLink2.getText());
		}

		return mouseHover;

	}
	public static String currentSystemDate(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currenrDate=dateFormat.format(date);
		System.out.println(dateFormat.format(date));
		return currenrDate;
	}
	public static void sendKeysById(String id, String data) {
		try {
			WebElement element = webDriver.findElement(By.id(id));
			LOG.info("Entering data");
			element.sendKeys(data);
			LOG.info("Data entered is" + data);

		} catch ( Exception ex ) {
			System.out.println(ex.getMessage());
		}
	}

	public static void closeBrowser() {
		if ( null != webDriver ) {
			webDriver.quit();
		}
	}

	public static void setValueByElementName(final String elementName, final String valueToSet) {
		try {

			findElementByName(elementName).sendKeys(valueToSet);
			LOG.info("Value set: " + valueToSet);
			System.out.println("Value set: " + valueToSet);

		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with name " + elementName + "was found.");
			ex.printStackTrace();
			closeBrowser();
		}

	}
	public static void clickValueByElementName(final String elementName) {
		try {
			findElementByName(elementName).click();
			LOG.info("Value set: " + elementName);
			System.out.println("Value set: " + elementName);

		} catch ( NoSuchElementException ex ) {
			System.out.println("No element with name " + elementName + "was found.");
			ex.printStackTrace();
			closeBrowser();
		}
	}

	public static void selectValueFromDropDown(WebElement element, final int index) {
		try {
			Select sel =  new Select(element);
			sel.selectByIndex(index);

		} catch(Exception ex) {
			ex.printStackTrace();
			closeBrowser();
		}

	}
	public static void selectValueFromDropDwn(String element,  String value) {

		try {
			Select sel =  new Select(findElementByXpath(element));
			sel.selectByValue(value);

		} catch(Exception ex) {
			ex.printStackTrace();
			closeBrowser();
		}


	}
	public static void explicitWait(String xpathVar){
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathVar)));

	}

	public static void mouseHover(String text){
		Actions actions = new Actions(webDriver);
		WebElement menuHoverLink = webDriver.findElement(By.xpath(text));
		actions.moveToElement(menuHoverLink).click().perform();

	}

}
