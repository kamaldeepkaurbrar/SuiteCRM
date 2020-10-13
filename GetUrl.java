package CRMPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetUrl {
	
public WebDriver driver;
	
	@BeforeMethod
    public void beforeMethod() {
    	String ProjectPath = System.getProperty("user.dir");
		System.out.println("ProjectPath:" +ProjectPath);
	    System.setProperty("webdriver.gecko.driver", ProjectPath+"\\drivers\\geckodriver.exe");
	    driver = new FirefoxDriver();
	  
        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");
    }
	
	@Test
    public void URL() {
        //This test case will Fail
        String LogoUrl = driver.findElement(By.xpath("//a[@href='http://www.suitecrm.com']")).getAttribute("href");;
		//System.out.println("LogoUrl:" +LogoUrl);
        //Assert.assertTrue(LogoUrl.isDisplayed());
        System.out.println("LogoUrl:" +LogoUrl);
        
    }
    
	@AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
	
}
