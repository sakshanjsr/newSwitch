package saketshankar.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class check {
	
	WebDriver driver;
	
	@Test(dataProvider = "getTheData")
	public void hiturl(String url , String text1 , String text2) {
		driver.get(url);
		System.out.println("Test 1 : "+text1);
		System.out.println("Text 2 : "+text2);
	}
	
	
	@BeforeTest
	public void initialize() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getTheData() throws IOException{
		return new Object[][] {{"https://www.google.com/" , "Welcome11" , "ZARA COAT 3"},{"https://www.facebook.com/" , "Welcome11" , "IPHONE 13 PRO"}};
	}

}
