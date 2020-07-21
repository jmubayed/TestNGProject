package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base {
	public WebDriver driver;
	private static Logger Log = LogManager.getLogger(base.class.getName());
	LandingPage l;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = intializeDriver();
		Log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to home page");
	}

	@Test
	public void basePageNavigation() throws IOException {
		// one is inheritance
		// creating object to that class and invoke methods of it
		l = new LandingPage(driver);
		// Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		Assert.assertTrue(false);
		Log.info("Successfully Validated Text Message");

	}
	
	@Test
	public void validateHeader()
	{
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
