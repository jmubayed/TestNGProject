package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	private static Logger Log = LogManager.getLogger(base.class.getName());
	@BeforeMethod
	public void initialize() throws IOException {
		driver = intializeDriver();

		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")

	public void basePageNavigation(String username, String password, String text) throws IOException {
		// one is inheritance
		// creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin();
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		//System.out.println(text);
		Log.info(text);
		lp.getLogin().click();

	}

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types test should run
		// Column stands for how many values per each test
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted user";
		// 1st row
		data[1][0] = "restrictedusser@qw.com";
		data[1][1] = "456789";
		data[1][2] = "Non restricted user";
		return data;
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
