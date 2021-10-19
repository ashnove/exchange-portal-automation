package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static WebDriver driver;
	public static String username = "dv";
	public static String password = "1234";
	@Test(description="opening of the blog is successfully occured!")
	public void openMyBlog() {
		
		System.out.println("Blog Opened");
		driver.get("https://localhost:4200/login");

	}

	@BeforeClass
	public void beforeClass() {

		System.out.println("Chrome Opened");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		
		driver.findElement(By.xpath("/html/body/app-root/app-login/html/body/div/div/div/div[2]/form/div[1]/input")).sendKeys(username);
		driver.findElement(By.xpath("/html/body/app-root/app-login/html/body/div/div/div/div[2]/form/div[2]/input")).sendKeys(password);
		System.out.println("Page Logged In");
		
		Thread.sleep(2000);
		driver.close();

	}

}
