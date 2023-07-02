package saketshankar.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import saketshankar.TestComponents.BaseTest;
import saketshankar.pageobjects.productCatalogue;

public class landingMain extends BaseTest{

	@Test(dataProvider = "getdatas")
	public void submitOrder(HashMap<String, String> hm) throws InterruptedException, IOException {
		// TODO Auto-generated method stub


		String email = hm.get("email");
		String password="Welcome11";
		String Product = hm.get("Product");
		
		productCatalogue pc  = lp.login(email , password);


	    List<WebElement> products = pc.getProductList();
		WebElement prod =  products.stream().filter(product->
						   product.findElement(By.cssSelector("b")).getText().equals(Product)).findFirst().orElse(null);
        prod.findElement(By.cssSelector("button:last-of-type")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
        List<WebElement> carts =  driver.findElements(By.cssSelector(".infoWrap"));
        Boolean cartMatch = carts.stream().anyMatch(cart ->
        					  cart.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(Product));
        org.testng.Assert.assertTrue(cartMatch);
        System.out.println("cartMatch  "+Product+" : "+cartMatch);
        closeTest();
	}


	@DataProvider
	public Object[][] getdatas() throws IOException{
		
		//return new Object[][] {{"abcxyz@mail.com" , "Welcome11" , "ZARA COAT 3"},{"abcxyz@mail.com" , "Welcome11" , "IPHONE 13 PRO"}};
		
//		HashMap<String, String> hm = new HashMap<String, String>();
//		hm.put("email", "abcxyz@mail.com");
//		hm.put("Product", "IPHONE 13 PRO");
//		
//		HashMap<String, String> hm2 = new HashMap<String, String>();
//		hm2.put("email", "abcxyz@mail.com");
//		hm2.put("Product", "ZARA COAT 3");
//		
//		return new Object[][] {{hm},{hm2}};
		
		List<HashMap<String, String>> list =  readJSONdata();
		return new Object[][] {{list.get(0)},{list.get(1)}};
	}

}
