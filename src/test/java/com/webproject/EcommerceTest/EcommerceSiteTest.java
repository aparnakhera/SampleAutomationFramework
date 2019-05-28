package com.webproject.EcommerceTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webproject.EcommerceSite.EcommerceSiteBean;
import com.webproject.EcommerceSite.SeleniumUtil;


/*Class to Automate Test Case which contains @Test method*/
public class EcommerceSiteTest {
	final static Logger logger = Logger.getLogger(SeleniumUtil.class);
	private EcommerceSiteBean ecommerceBean;

	@BeforeClass
	public  void setup() throws IOException {
		SeleniumUtil.getInitialContext();
		ecommerceBean=SeleniumUtil.ecommerceBean;
	}

	@Test
	public void LaunchEcommerceSiteTest() {
		try {
			SeleniumUtil.driverInit();
			SeleniumUtil.launchApplication();
			logger.info("Application Loaded");
			Assert.assertEquals(SeleniumUtil.findElementByXpathGetText(ecommerceBean.getWomenTitle()), "WOMEN");
		} catch (Exception ex) {
			logger.info("Issue in Loading Application");
			ex.getMessage();

		}
	}

	//Continue adding test case Automation


	@AfterClass
	public void tearDown() throws Exception {
		logger.info("Close the Browser");
		SeleniumUtil.closeBrowser();
	}

}
