package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_05_DataProvider {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}

	@Test(dataProvider = "user_pass")
	public void TC_01(String username, String password) {
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		driver.findElement(By.cssSelector("#send2")).click();
		driver.findElement(By.xpath("//span[@class='label'][contains(text(),'Account')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
}

	@DataProvider
	public Object[][] user_pass() {
		return new Object[][] { 
			new Object[] { "selenium123@gmail.com", "123456" }, 
			new Object[] { "selenium_11_01@gmail.com", "111111" }, };
	}

	@AfterClass
	public void afterClass() {
	}

}
