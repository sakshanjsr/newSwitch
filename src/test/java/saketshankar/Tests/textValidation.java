package saketshankar.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import saketshankar.TestComponents.BaseTest;
import saketshankar.pageobjects.productCatalogue;



public class textValidation extends BaseTest{

	
	@Test
	public void checkTest() {
		System.out.println("Text Check Method");
		
		productCatalogue pc =  lp.login("abcxyz@mail.com" , "Welcome11");
		
		Boolean filterText = pc.checkFilterText();
		Assert.assertTrue(filterText);
	}
}
