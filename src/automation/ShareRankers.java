package automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShareRankers {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Home")).click();
		driver.switchTo().frame("webform");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id = 'webform_preview']/div")).click();
		driver.switchTo().defaultContent();
		// driver.findElement(By.xpath("//ul[@id =
		// \"social-share\"]/li[1]/a/i")).click();
		//driver.findElement(By.className("fa fa-facebook social-icon")).click();
		driver.findElement(By.xpath("//i[contains(@class , 'fa fa-facebook social-icon')]")).click();


	}

}
