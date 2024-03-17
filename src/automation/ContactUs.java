package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContactUs {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Home")).click();
		driver.switchTo().frame("webform");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id = 'webform_preview']/div")).click();
		driver.switchTo().defaultContent();
		WebElement contact = driver.findElement(By.xpath("//div[@class = \"subscribe row\"]//following::input"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", contact);
		contact.sendKeys("Kalyani12@gmail.com");
		driver.findElement(By.name("mailUs")).click();

	}
	
	

}
