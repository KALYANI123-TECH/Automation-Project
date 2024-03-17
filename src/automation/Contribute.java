package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Contribute {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Contribute")).click();
		driver.findElement(By.name("first_name")).sendKeys("Kalyani");
		driver.findElement(By.name("email")).sendKeys("kalyani12@gamil.com");
		driver.findElement(By.id("phone")).sendKeys("1234567832");
		WebElement selectDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select select = new Select(selectDropdown);
		select.selectByValue("Moderator");
		driver.findElement(By.name("submit")).click();

	}

}
