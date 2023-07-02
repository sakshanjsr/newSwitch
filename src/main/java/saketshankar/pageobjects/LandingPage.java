package saketshankar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saketshankar.AbstractComponents.AbstractComponents;


public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginButton;
	
    public productCatalogue login(String userMail , String passwordText) {
    	userEmail.sendKeys(userMail);
    	password.sendKeys(passwordText);
    	loginButton.click();
    	productCatalogue pc = new productCatalogue(driver);
    	return pc;
    }
    
    public void gotoURL(String url) {
    	driver.get(url);
    }
	

}
