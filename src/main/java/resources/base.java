package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver intializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		// mvn test -Dbrowser=chrome
		// String browserName = prop.getProperty("browser");
		String browserName = System.getProperty("browser");
		System.out.println(browserName);

		/*if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			if (browserName.contains("headless")) {
				option.addArguments("headless");
			}
			else if (browserName.contains("maximized")) {
				option.addArguments("--start-maximized");
			}
			driver = new ChromeDriver(option);
		}

		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {

		}
		
		else
		{
			System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}*/
		
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
