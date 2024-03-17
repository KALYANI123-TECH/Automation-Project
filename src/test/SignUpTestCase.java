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

public class SignUpTestCase {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("signup-tab")).click();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@Test(priority = 1, enabled = false)
	public void verifySignUp() {
	
		driver.findElement(By.id("name")).sendKeys("Kalyani");
		driver.findElement(By.id("emailid")).sendKeys("Kalyani39@gmail.com");
		WebElement Element = driver.findElement(By.id("mobile"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		Element.sendKeys("1234560238");
		driver.findElement(By.id("agree")).click();
		driver.findElement(By.id("emailbtn")).click();
		String actualResult = driver.findElement(By.xpath("//*[text() = 'Manual Testing(ISTQB) Quiz']")).getText();
		String expectedResult = "Manual Testing(ISTQB) Quiz";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 2, enabled = false)
	public void verify_SignUp_BlankName() {
		
	
		driver.findElement(By.id("name")).sendKeys("");
		driver.findElement(By.id("emailid")).sendKeys("Kalyani18@gmail.com");
		WebElement Element = driver.findElement(By.id("mobile"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		Element.sendKeys("8321234579");
		driver.findElement(By.id("agree")).click();
		driver.findElement(By.id("emailbtn")).click();
		String actualResult = driver.findElement(By.xpath("//*[text() = 'Manual Testing(ISTQB) Quiz']")).getText();
		String expectedResult = "Name should not be blank";
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 3, enabled = false)
	public void verify_SignUp_InvalidName() {

		driver.findElement(By.id("name")).sendKeys("2435354646");
		driver.findElement(By.id("emailid")).sendKeys("kalyani92@gmail.com");
		WebElement Element = driver.findElement(By.id("mobile"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		Element.sendKeys("3281234562");
		driver.findElement(By.id("agree")).click();
		driver.findElement(By.id("emailbtn")).click();
		String actualResult = driver.findElement(By.xpath("//*[text() = 'Manual Testing(ISTQB) Quiz']")).getText();
		String expectedResult = "Please enter valid name";
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 4, enabled = false)
	public void verify_SignUp_InvalidNameRange() {
	
		driver.findElement(By.id("name")).sendKeys("kalyanikalyanikalyanikalyanikalyani");
		driver.findElement(By.id("emailid")).sendKeys("kalyani10@gmail.com");
		WebElement Element = driver.findElement(By.id("mobile"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		Element.sendKeys("3211234565");
		driver.findElement(By.id("agree")).click();
		driver.findElement(By.id("emailbtn")).click();
		String actualResult = driver.findElement(By.xpath("//*[text() = 'Manual Testing(ISTQB) Quiz']")).getText();
		String expectedResult = "Name should not be exceed 32 characters";
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 5, enabled = false)
	public void verify_SignUp_InvalidEmail() {

		driver.findElement(By.id("name")).sendKeys("kalyani");
		driver.findElement(By.id("emailid")).sendKeys("kalyani20gmail.com");
		WebElement Element = driver.findElement(By.id("mobile"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		Element.sendKeys("1234567834");
		driver.findElement(By.id("agree")).click();
		driver.findElement(By.id("emailbtn")).click();
		String actualResult = driver.findElement(By.xpath("//div[@id = \"emailerr\"]")).getText();
		String expectedResult = "Please enter valid email";
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 6, enabled = false)
	public void verify_SignUp_ExistingEmail() {

		driver.findElement(By.id("name")).sendKeys("kalyani");
		driver.findElement(By.id("emailid")).sendKeys("kalyani12@gmail.com");
		WebElement Element = driver.findElement(By.id("mobile"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		Element.sendKeys("1234567833");
		driver.findElement(By.id("agree")).click();
		driver.findElement(By.id("emailbtn")).click();
		String actualResult = driver.findElement(By.xpath("//div[@id =\"emailerr\"]")).getText();
		String expectedResult = "Email Address already exists, please login with mobile number associated with this email. [check your inbox for welcome email]";
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 7, enabled = false)
	public void verify_SignUp_BlankMobileNumber() {

		driver.findElement(By.id("name")).sendKeys("kalyani");
		driver.findElement(By.id("emailid")).sendKeys("kalyani9@gmail.com");
		WebElement Element = driver.findElement(By.id("mobile"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		Element.sendKeys("");
		driver.findElement(By.id("agree")).click();
		driver.findElement(By.id("emailbtn")).click();
		String actualResult = driver.findElement(By.xpath("//div[@id = \"mobileerr\"]")).getText();
		String expectedResult = "Please enter a valid number!";
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 8, enabled = false)
	public void verify_SignUp_InvalidMobileNumberChar() {

		driver.findElement(By.id("name")).sendKeys("Kalyani");
		driver.findElement(By.id("emailid")).sendKeys("Kalyani8@gmail.com");
		WebElement Element = driver.findElement(By.id("mobile"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		Element.sendKeys("abcdefgtoj");
		driver.findElement(By.id("agree")).click();
		driver.findElement(By.id("emailbtn")).click();
		String actualResult = driver.findElement(By.xpath("//*[text()= 'Mobile number already exists, please login with this mobile number']")).getText();
		String expectedResult = "Please enter 10 digit mobile number, characters are not alllowed";
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 9, enabled = true)
	public void verify_SignUp_TermsCheckbox() {

		driver.findElement(By.id("name")).sendKeys("Kalyani");
		driver.findElement(By.id("emailid")).sendKeys("Kalyanim@gmail.com");
		WebElement Element = driver.findElement(By.id("mobile"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		Element.sendKeys("1234561116");
		driver.findElement(By.id("emailbtn")).click();
		String actualResult = driver.findElement(By.xpath("// div[@id = \"agreeerr\"]")).getText();
		String expectedResult = "Please select terms and condition checkbox.";
		Assert.assertEquals(actualResult, expectedResult);
	}

}
