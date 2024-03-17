package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShareCertificates {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		driver.findElement(By.xpath("//div[@id = \"social-media\"]/a[1]")).click();
		
//		WebElement element = driver.findElement(By.xpath("//div[@id = \"choices\"]/div/label/div"));
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		js.executeScript("arguments[0].scrollIntoView(true);", element);
//		element.click();
//		driver.findElement(By.partialLinkText("Next")).click();
//
//		WebElement question2 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[2]/div/label/div"));
//		JavascriptExecutor js2 = ((JavascriptExecutor) driver);
//		js2.executeScript("arguments[0].scrollIntoView(true);", question2);
//		question2.click();
//		driver.findElement(By.partialLinkText("Next")).click();
//
//		WebElement question3 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[3]/div/label/div"));
//		JavascriptExecutor js3 = ((JavascriptExecutor) driver);
//		js3.executeScript("arguments[0].scrollIntoView(true);", question3);
//		question3.click();
//		driver.findElement(By.partialLinkText("Next")).click();
//
//		WebElement question4 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[4]/div/label/div"));
//		JavascriptExecutor js4 = ((JavascriptExecutor) driver);
//		js4.executeScript("arguments[0].scrollIntoView(true);", question4);
//		question4.click();
//		driver.findElement(By.partialLinkText("Next")).click();
//
//		WebElement question5 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[5]/div/label/div"));
//		JavascriptExecutor js5 = ((JavascriptExecutor) driver);
//		js5.executeScript("arguments[0].scrollIntoView(true);", question5);
//		question5.click();
//		driver.findElement(By.partialLinkText("Next")).click();
//
//		WebElement question6 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[6]/div/label/div"));
//		JavascriptExecutor js6 = ((JavascriptExecutor) driver);
//		js6.executeScript("arguments[0].scrollIntoView(true);", question6);
//		question6.click();
//		driver.findElement(By.partialLinkText("Next")).click();
//
//		WebElement question7 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[7]/div/label/div"));
//		JavascriptExecutor js7 = ((JavascriptExecutor) driver);
//		js7.executeScript("arguments[0].scrollIntoView(true);", question7);
//		question7.click();
//		driver.findElement(By.partialLinkText("Next")).click();
//
//		WebElement question8 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[8]/div/label/div"));
//		JavascriptExecutor js8 = ((JavascriptExecutor) driver);
//		js8.executeScript("arguments[0].scrollIntoView(true);", question8);
//		question8.click();
//		driver.findElement(By.partialLinkText("Next")).click();
//
//		WebElement question9 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[9]/div/label/div"));
//		JavascriptExecutor js9 = ((JavascriptExecutor) driver);
//		js9.executeScript("arguments[0].scrollIntoView(true);", question9);
//		question9.click();
//		driver.findElement(By.partialLinkText("Next")).click();
//
//		WebElement question10 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[10]/div/label/div"));
//		JavascriptExecutor js10 = ((JavascriptExecutor) driver);
//		js3.executeScript("arguments[0].scrollIntoView(true);", question10);
//		question10.click();
//
//		WebElement submitElement = driver.findElement(By.partialLinkText("Submit"));
//		JavascriptExecutor js11 = ((JavascriptExecutor) driver);
//		js11.executeScript("arguments[0].scrollIntoView(true);", element);
//		submitElement.click();

//		driver.findElement(By.xpath("//div[@id = \"social-media\"]/a[1]")).click();
//		String win = driver.getWindowHandle();
//		driver.switchTo().window(win);
//		driver.manage().window().maximize();

//		WebElement sign = driver.findElement(By.linkText("Signin"));
//		sign.click();
//		JavascriptExecutor js12 = ((JavascriptExecutor) driver);
//		js12.executeScript("arguments[0].scrollIntoView(true);", sign);

	}

}
