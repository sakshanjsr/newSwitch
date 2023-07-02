package saketshankar.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import saketshankar.pageobjects.LandingPage;

public class BaseTest {
	
	public static  WebDriver driver;
	public static LandingPage lp;
	public static String url ;
	
	public static WebDriver initializeDriver() throws IOException {
	
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\saketshankar\\resources\\global.properties");
	    props.load(file);
	    String browser = props.getProperty("browser");
	    url = props.getProperty("url");
	    
	    
	    if(browser.equalsIgnoreCase("chrome")) {
	    	WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--remote-allow-origins=*");
	    	driver = new ChromeDriver();
	    }else {
	    	System.exit(0);
	    }
	    
	    
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
  }
	
	

	//Take Screenshot
	public static String getScreenshot(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//Screenshots//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//Screenshots//" + testCaseName + ".png";
	}
	
	
	//Read data from JSON file
	public List<HashMap<String, String>> readJSONdata() throws IOException {
		String jsonContect = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//saketshankar//data//data.json"));
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data = mapper.readValue(jsonContect, new TypeReference<List<HashMap<String, String>>>()  {});
		return data;
	}
	
	
	@BeforeTest
	public static LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		lp = new LandingPage(driver);
		lp.gotoURL(url);
		return lp;
	}
	
	
	@AfterTest
	public static void closeTest() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("close driver");
		driver.close();
	}
	
	
}
