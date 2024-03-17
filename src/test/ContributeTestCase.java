package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContributeTestCase {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@Test(priority = 1)
	public void verify_ContributeMenu() {

		driver.findElement(By.partialLinkText("Contribute")).click();
		driver.findElement(By.name("first_name")).sendKeys("Kalyani");
		driver.findElement(By.name("email")).sendKeys("kalyani12@gamil.com");
		driver.findElement(By.id("phone")).sendKeys("1234567832");
		WebElement selectDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select select = new Select(selectDropdown);
		select.selectByValue("Moderator");
		driver.findElement(By.name("submit")).click();
		String actualResult = driver.getTitle();
		String expectedResult = "Contribute | Earn Reaward Points - JavaByKiran";
		Assert.assertEquals(actualResult, expectedResult);
	}

}
