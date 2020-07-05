package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic02_Xpath_Css_Locator {
	//Khai báo biến driver(instance= thể hiện/đại diện)
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		//Khởi tạo
		driver = new FirefoxDriver();
		//Phóng to browser
		driver.manage().window().maximize();
		//Chờ cho element được stable trước khi thao tác trong vòng xx giây
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Mở app Url
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	}
	
	// Html của login button 
	/* 
	 <input id="email" class="input-text required-entry validate-email" type="email" 
	  title="Email Address" value="" name="login[username]" spellcheck="false"
	  autocorrect="off" autocapitalize="off">
	*/
	// Trong Selenium có 3 dạng attribute của HTML(id/name/class)
	// Hay được dev team set là duy nhất
	@Test
	public void TC_01_ID() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("id@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).clear();
	}
	@Test
	public void TC_02_Class() throws InterruptedException {
		driver.findElement(By.className("input-text required-entry validate-password")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.className("input-text required-entry validate-password")).clear();
	}
	@Test
	public void TC_03_Name() throws InterruptedException{
		driver.findElement(By.name("login[username]")).sendKeys("name@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("login[username]")).clear();
	}
	@Test
	public void TC_04_Tagname() throws InterruptedException{
		int linkNumber= driver.findElements(By.tagName("a")).size();
		System.out.println("Sum link="+linkNumber);
		Thread.sleep(2000);
		
	}
	@Test
	//Chỉ làm việc với những đường link tuyệt đối
	public void TC_05_Link_Text()throws InterruptedException {
		//Click vào SITE MAP link
		driver.findElement(By.linkText("SITE MAP")).click();
		Thread.sleep(2000);
	}
	@Test //Chỉ làm việc với những đường link tương đối
	public void TC_06_Partial_Link_Text()throws InterruptedException {
		driver.findElement(By.partialLinkText("ADVANCED")).click();
		//driver.findElement(By.partialLinkText("SEARCH")).click();
		Thread.sleep(2000);
	}
	@Test
	public void TC_07_Css()throws InterruptedException {
		//ID
		driver.findElement(By.cssSelector("#search")).sendKeys("may store");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#search")).clear();
	}
	@Test
	public void TC_08_Xpath()throws InterruptedException {
		//class
		driver.findElement(By.xpath("//[@class='input-text']")).sendKeys("iphone X");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//[@class='input-text']")).clear();
	}
	@AfterClass
	public void afterClass() throws InterruptedException{
		driver.quit();
	}

}
