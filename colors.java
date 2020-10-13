package CRMPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class colors {
	
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
    public void loginTest() {
        //Find the username and password fields
        WebElement username = driver.findElement(By.id("user_name"));
        WebElement password = driver.findElement(By.id("username_password"));
        
        //Enter credentials
        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");
        
        //Click login
        driver.findElement(By.id("bigbutton")).click();
        
        String buttonTextColor = driver.findElement(By.className("desktop-toolbar")).getCssValue("color");
        System.out.println("Button color: " + buttonTextColor);
        String hex = Color.fromString(buttonTextColor).asHex();
        System.out.println(hex);
        Assert.assertEquals("#534d64", hex);

}
	
	@AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
	
}
	
