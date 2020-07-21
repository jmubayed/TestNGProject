package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	//se recomienda usar las variables en privado para evitar acceder a ellas de manera directa y que sea solo a travez de method public
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector("div[class='text-center']");
	private By NavBar = By.cssSelector("ul.nav.navbar-nav.navbar-right");
	private By header = By.cssSelector("div.video-banner h3");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public LoginPage getLogin()
	{
		driver.findElement(signin).click();
		return new LoginPage(driver);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavBar);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}

}
