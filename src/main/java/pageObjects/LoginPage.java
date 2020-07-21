package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
public WebDriver driver;
	
	private By email = By.cssSelector("input[id='user_email']");
	private By password = By.cssSelector("input[id='user_password']");
	private By login = By.cssSelector("input[value='Log In']");
	private By error_message = By.cssSelector("div.alert.alert-danger.alert-show.mb-5");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public List<WebElement> getErrorMessage()
	{
		return driver.findElements(error_message);
	}
	
}
