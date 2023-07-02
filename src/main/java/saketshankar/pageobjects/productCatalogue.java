package saketshankar.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import saketshankar.AbstractComponents.AbstractComponents;

public class productCatalogue extends AbstractComponents{
	
	
	WebDriver driver;
	
	public productCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productsBy = By.cssSelector(".mb-3");
	
	@FindBy (xpath = "(//*[@id=\"burgundy\"])[1]")
	WebElement filter;
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public Boolean checkFilterText() {
		waitForElementToAppear(filter);
		Boolean filterText = filter.getText().equals("Filters");
		return filterText;
	}

}
