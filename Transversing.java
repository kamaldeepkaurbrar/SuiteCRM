package CRMPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Transversing {
	
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
	       for(int i=0;i<10;i++)
		  {
	    	  if(i%2 != 0)
			  {
				  String name = driver.findElement(By.xpath("//tr["+i+"]//td[3]//b[1]//a[1]")).getText();
				  System.out.println("Name "+i+": "+name);  
			  }
			  
		  }
	  }


	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }
	
	
	

}
