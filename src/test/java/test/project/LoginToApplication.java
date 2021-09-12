package test.project;

import java.net.SocketException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;




public class LoginToApplication {

	
	WebDriver driver=null;
	
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shashi\\workspace2\\project\\Dependencies\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	
@Test
public void SignIn(){
	
	try{
	
	
	driver.get("http://live.demoguru99.com");
	driver.manage().window().maximize();
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'account')]")));
//	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(@href,'account')]")).click();
	
	driver.findElement(By.xpath("//a[text()='Log In']")).click();
	
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("autotestuser1234@mailinator.com");
	
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Test@1234");
	driver.findElement(By.xpath("//button[@id='send2']")).click();
	
	String msg=driver.findElement(By.xpath("//p[@class='welcome-msg']")).getText();
	System.out.println(msg);
	
//	driver.close();
	
//	Assert.assertEquals(msg, "WELCOME, TEST USER!");
	
}catch (Exception e) {
	System.out.println(""+e.getLocalizedMessage());
}
}

@AfterTest
	public void Logout(){
		try{
		
			driver.findElement(By.xpath("//a[contains(@href,'account')]")).click();
			driver.findElement(By.xpath("//a[text()='Log Out']")).click();
			
			driver.close();
			driver.quit();
			
			
		}catch (Exception e) {
			System.out.println(""+e.getLocalizedMessage());
		}
	}

}
