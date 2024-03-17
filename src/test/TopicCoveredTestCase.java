package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopicCoveredTestCase {

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
	public void verifyDashboard_TopicCover() {
		
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("1234567832");
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.partialLinkText("Account")).click();
		driver.findElement(By.xpath("//div[@class = \"card card-stats card-pink\"]//following::div[4]/a")).click();
		String actualResult = driver.getTitle();
		String expectedResult = "Topics Covered";
		Assert.assertEquals(actualResult, expectedResult);
	}

}
