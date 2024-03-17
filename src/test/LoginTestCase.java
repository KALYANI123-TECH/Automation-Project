package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestCase {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@Test(priority = 1, enabled = false)
	public void verifyLogin() {

		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("1234567832");
		driver.findElement(By.id("loginbtn")).click();
		String actualResult = driver.findElement(By.xpath("//*[text() ='Manual Testing(ISTQB) Quiz']")).getText();
		String expectedResult = "Manual Testing(ISTQB) Quiz";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 2)
	public void verify_InvalidMobileNumberRange() {

		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("12345678329");
		driver.findElement(By.id("loginbtn")).click();
		String actualResult = driver.findElement(By.xpath("//div[@id = \"loginerr\"]")).getText();
		String expectedResult = "Please enter valid mobile number, If you have not registered, please click signup tab to get registered.";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 3)
	public void verify_NotRegisterMobileNumber() {

		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("1234567837");
		driver.findElement(By.id("loginbtn")).click();
		String actualResult = driver.findElement(By.xpath("//div[@id = \"loginerr\"]")).getText();
		String expectedResult = "You have not registered with us. Please click signup tab to get registered";
		Assert.assertEquals(actualResult, expectedResult);

	}

}
