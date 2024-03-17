package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpPage {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("signup-tab")).click();
		driver.findElement(By.id("name")).sendKeys("Kalyani");
		driver.findElement(By.id("emailid")).sendKeys("Kalyani12@gamil.com");
		WebElement Element = driver.findElement(By.id("mobile"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		Element.sendKeys("1234567832");
		driver.findElement(By.id("agree")).click();
		driver.findElement(By.id("emailbtn")).click();

	}
}
