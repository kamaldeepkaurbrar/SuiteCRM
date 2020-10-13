package CRMPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class popup {
	
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
        
        //driver.findElement(By.id("grouptab_0")).click();
        //Thread.sleep(5000);
        
        driver.findElement(By.cssSelector("a[id=\'grouptab_0\']")).click();
        WebElement SalesDropDown = driver.findElement(By.cssSelector("a[id=\'grouptab_0\']"));
   	    Actions action = new Actions (driver);
   	    action.moveToElement(SalesDropDown).click().build().perform();
   	    WebElement Lead = driver.findElement(By.cssSelector("a[id=\'moduleTab_9_Leads\']"));
   	    action.moveToElement(Lead).click().build().perform();
   	     Thread.sleep(10000);
        
   	//Create Lead:
 	    Thread.sleep(5000);
 	    driver.findElement(By.xpath("//li[1]//a[1]//div[2]")).click();
 	    Thread.sleep(5000);
 	    driver.findElement(By.xpath("//select[@id='salutation']")).sendKeys("Miss");
 	    driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("SDET");
 	    driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Training");
 	    driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("9080000000");
 	    driver.findElement(By.xpath("//input[@id='Leads0emailAddress0']")).sendKeys("sdet3@gmail.com");
 	    driver.findElement(By.xpath("//td[@class='buttons']//input[@id='SAVE']")).click();
 	    driver.findElement(By.xpath("//span[@class='currentTab']//a[@id='moduleTab_Leads']")).click();
 	    
 	  //Click on Additional information and get mobile number
 	    
 	    Thread.sleep(5000);
 	    driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[3]/form[2]/div[3]/table[1]/tbody[1]/tr[1]/td[10]/span[1]/span[1]")).click();
 	   
 	    Thread.sleep(5000);
 	    String mobileNumber = driver.findElement(By.cssSelector("span[class=\'phone\']")).getText();
 	    System.out.println("Mobile number of newly created Lead is: "+mobileNumber);
 	    
   }
   
  @AfterClass
   public void afterClass() 
   {
 	  driver.close();
   }

	}
	