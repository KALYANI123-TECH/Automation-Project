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

public class ContactUsTestCase {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.switchTo().frame("webform");
		driver.findElement(By.xpath("//div[@id = 'webform_preview']/div")).click();
		driver.switchTo().defaultContent();

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@Test(priority = 1, enabled = false)
	public void verify_ContactUs() {

		WebElement contact = driver.findElement(By.xpath("//div[@class = \"subscribe row\"]//following::input"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", contact);
		contact.sendKeys("Kalyani12@gmail.com");
		driver.findElement(By.name("mailUs")).click();
		String actualResult = driver.findElement(By.xpath("//div[@class = \"mail-success\"]")).getText();
		String expectedResult = "Mail Sent. We will contact you shortly.";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 2, enabled = false)
	public void verify_ContactUs_InvalidEmailField() {

		WebElement contact = driver.findElement(By.xpath("//div[@class = \"subscribe row\"]//following::input"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", contact);
		contact.sendKeys("1351235");
		driver.findElement(By.name("mailUs")).click();
		String actualResult = driver.findElement(By.xpath("//div[@class = \"mail-success\"]")).getText();
		String expectedResult = "Please enter valid email address";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 3)
	public void verify_ContactUs_BlankEmailField() {

		WebElement contact = driver.findElement(By.xpath("//div[@class = \"subscribe row\"]//following::input"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", contact);
		contact.sendKeys("");
		driver.findElement(By.name("mailUs")).click();
		String actualResult = driver.findElement(By.xpath("//*[text()=\"required\"]")).getText();
		String expectedResult = "required";
		Assert.assertEquals(actualResult, expectedResult);

	}

}
