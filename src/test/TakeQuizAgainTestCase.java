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

public class TakeQuizAgainTestCase {

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
	public void verify_TakeQuizAgain() {

		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("1234567832");
		driver.findElement(By.id("loginbtn")).click();

		for (int i = 0; i <= 8; i++) {
			WebElement next = driver.findElement(By.partialLinkText("Next"));
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", next);
			next.click();

		}
		driver.findElement(By.partialLinkText("Submit")).click();
		WebElement viewAnswer = driver.findElement(By.xpath("// *[text() = 'View Answer']"));
		viewAnswer.click();
		try {

			WebElement takeQuiz = driver.findElement(By.xpath("//*[text() = 'Take a Quiz Again']"));
			Thread.sleep(5000);
			JavascriptExecutor js12 = ((JavascriptExecutor) driver);
			js12.executeScript("arguments[0].scrollIntoView(true);", takeQuiz);
			takeQuiz.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String actualResult = driver.getTitle();
		String expectedResult = "Practice Online Quiz | Take a Online Test - JavaByKiran";
		Assert.assertEquals(actualResult, expectedResult);
	}

}
