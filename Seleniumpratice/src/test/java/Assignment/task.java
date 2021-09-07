package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class task {
	
	public static WebDriver driver;
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\laxmisrinivas.tanav\\Desktop\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/user/add.do");
		driver.manage().window().maximize();
	}

	@Test(priority=0)
	public void register()
	{
		//Enter the fields for registration
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("tanavarappulaxmi@gmail.com");
		driver.findElement(By.xpath(" //*[@id=\"fullName\"]")).sendKeys("Laxmi Tanavarappu");
		driver.findElement(By.xpath("//*[@id=\"mobileNo\"]")).sendKeys("9099009870");
		driver.findElement(By.xpath("//*[@id=\"userProfileForm\"]/div/div/div/div/div/div[4]/input")).click();
		//Already registered with the email,so alert pop-ups
		driver.switchTo().alert().accept();

	}
	
	@Test(priority=1)
	public void login() 
	{
		//login the page with the given credentials
		driver.findElement(By.xpath("/html/body/header/div/div/div[1]/div/div/ul[1]/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("tanavarappulaxmi@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Laxmi!123");
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
	}
	
	@Test(priority=2)
	public void bookticket()
	{
		
		WebElement element=driver.findElement(By.xpath("//*[@id=\"routeSlider\"]/div/div[1]/div/div/ul/li[2]/a"));
		Actions a=new Actions(driver);
		a.moveToElement(element).build().perform();
		
		//handle from location
		WebElement from=driver.findElement(By.xpath("//*[@id=\"fromPlaceName\"]"));
		from.sendKeys("Hyderabad");
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		
		//handle to location
		WebElement to=driver.findElement(By.xpath("//*[@id=\"toPlaceName\"]"));
		to.sendKeys("Bengaluru");  //BANGALORE
		to.sendKeys(Keys.ARROW_DOWN);
		to.sendKeys(Keys.ENTER);
		
		
		//handle the Date Of Departure
		driver.findElement(By.xpath("//*[@id=\"txtJourneyDate\"]")).click();;
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]/a")).click();
		
		//handle the Date Of Return
		driver.findElement(By.xpath("//*[@id=\"txtReturnJourneyDate\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[3]/a")).click();
		
		//Click the checkbox
		driver.findElement(By.xpath("//*[@id=\"bookingsForm\"]/div[1]/div/div[2]/div[2]/div/div[3]/div")).click();
		
		//Click the button
		driver.findElement(By.xpath("//*[@id=\"bookingsForm\"]/div[1]/div/div[2]/div[3]/button")).click();
	}
	
	@AfterTest()
	public void teardown()
	{
		driver.close();
	}
}
