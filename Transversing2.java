package CRMPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Transversing2 {
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
    public void loginTest() throws InterruptedException {
        //Find the username and password fields
        WebElement username = driver.findElement(By.id("user_name"));
        WebElement password = driver.findElement(By.id("username_password"));
        
        //Enter credentials
        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");
        
        //Click login
        driver.findElement(By.id("bigbutton")).click();
        

		  Thread.sleep(5000);
		  driver.findElement(By.cssSelector("a[id=\'grouptab_0\']")).click();
		  WebElement SalesDropDown = driver.findElement(By.cssSelector("a[id=\'grouptab_0\']")); 
		  Actions action = new Actions (driver);
		  action.moveToElement(SalesDropDown).click().build().perform();
		   
		  WebElement account = driver.findElement(By.cssSelector("a[id=\'moduleTab_9_Accounts\']")); 
		    action.moveToElement(account).click().build().perform();
		    Thread.sleep(5000);
		    
		    
		    for(int i=1;i<=10;i++)
			  {
		    
					  String name = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[3]/form[2]/div[3]/table[1]/tbody[1]/tr["+i+"]/td[3]/b[1]/a[1]")).getText();
					  String username1 = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[3]/form[2]/div[3]/table[1]/tbody[1]/tr["+i+"]/td[8]/a[1]")).getText();
					  System.out.println(i+". Name: "+name+", Username: "+username1);  
					  
			  }
}
		  }



