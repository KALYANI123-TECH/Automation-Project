package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ServicePolicyTestCase {

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

	@Test(priority = 1)
	public void verifyPolicy() {

		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("signup-tab")).click();
		WebElement term = driver.findElement(By.linkText("Terms of Service and Privacy Policy."));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", term);
		term.click();
		String actualResult = driver.getTitle();
		String expectedResult = "Contribute | Earn Reaward Points - JavaByKiran";
		Assert.assertEquals(actualResult, expectedResult);
	}

}
