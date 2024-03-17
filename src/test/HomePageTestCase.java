package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTestCase {

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

	@Test(priority = 1, enabled = false)
	public void verify_HomePage() {

		driver.findElement(By.partialLinkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame("webform");
		driver.findElement(By.name("webform[email]")).sendKeys("Kalyani12@gamil.com");
		driver.findElement(By.xpath("//button[@class = \"button border\"]")).click();
		driver.switchTo().defaultContent();
		String actualResult = driver.getTitle();
		String expectedResult = "Online Quiz to test your skills in Java,Python,MySQL,Testing";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 2, enabled = false)
	public void verify_BlankEmailField() {

		driver.findElement(By.partialLinkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame("webform");
		driver.findElement(By.xpath("//button[@class = \"button border\"]")).click();
		String actualResult = driver.findElement(By.xpath("// div[@class = \"info-error\"]/p")).getText();
		String expectedResult = "Email address is invalid.";
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 3, enabled = false)
	public void verify_HomePage_SyallbusMenu() {

		driver.findElement(By.linkText("Syllabus")).click();
		String actualResult = driver.getTitle();
		String expectedResult = "Syallabus - JavaByKiran";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 4, enabled = false)
	public void verify_HomePage_InterviewQuestionMenu() {

		driver.findElement(By.linkText("Interview Question")).click();
		String actualResult = driver.getTitle();
		String expectedResult = "Interview Question - JavaByKiran";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 5, enabled = false)
	public void verify_HomePage_ContactUsMenu() {

		driver.findElement(By.linkText("Contact Us")).click();
		String actualResult = driver.getTitle();
		String expectedResult = "Contact Us - JavaByKiran";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 6, enabled = false)
	public void verify_HomePage_LiveVideosMenu() {

		driver.findElement(By.linkText("Live Videos")).click();
		String actualResult = driver.getTitle();
		String expectedResult = "Live Videos - JavaByKiran";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 7, enabled = false)
	public void verify_HomePage_TutorialsMenu() {

		driver.findElement(By.linkText("Tutorials")).click();
		String actualResult = driver.getTitle();
		String expectedResult = "Tutorials - JavaByKiran";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 8, enabled = false)
	public void verify_HomePage_JavaCourseTab() {

		driver.findElement(By.partialLinkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame("webform");
		driver.findElement(By.xpath("//div[@id = 'webform_preview']/div")).click();
		driver.switchTo().defaultContent();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		WebElement javacourse = driver.findElement(By.xpath("//div[@class = \"course-section\"]/div[1]/a/img"));
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		js.executeScript("arguments[0].scrollIntoView(true);", javacourse);
		javacourse.click();
		try {
			Thread.sleep(5000);
			String actualResult = driver.getTitle();
			String expectedResult = "JavaCourse - JavaByKiran";
			Assert.assertEquals(actualResult, expectedResult);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test(priority = 9, enabled = false)
	public void verify_HomePage_SeleniumCourseTab() {

		driver.findElement(By.partialLinkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame("webform");
		driver.findElement(By.xpath("//div[@id = 'webform_preview']/div")).click();
		driver.switchTo().defaultContent();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		WebElement javacourse = driver.findElement(By.xpath("//div[@class = \"course-section\"]/div[2]/a/img"));
		javacourse.click();
		try {
			Thread.sleep(5000);
			String actualResult = driver.getTitle();
			String expectedResult = "SeleniumCourse - JavaByKiran";
			Assert.assertEquals(actualResult, expectedResult);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	@Test(priority = 10, enabled = true)
	public void verify_HomePage_PythonCourseTab() {

		driver.findElement(By.partialLinkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame("webform");
		driver.findElement(By.xpath("//div[@id = 'webform_preview']/div")).click();
		driver.switchTo().defaultContent();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		WebElement javacourse = driver.findElement(By.xpath("//div[@class = \"course-section\"]/div[3]/a"));
		javacourse.click();
		try {
			Thread.sleep(5000);
			String actualResult = driver.getTitle();
			String expectedResult = "PythonCourse - JavaByKiran";
			Assert.assertEquals(actualResult, expectedResult);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
