package CRMPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Copyright {
	
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
    
	String myText = driver.findElement(By.id("admin_options")).getText();
	System.out.println("text is :  " + myText);
}

@AfterMethod
public void afterMethod() {
    //Close the browser
    driver.quit();
}

}
	