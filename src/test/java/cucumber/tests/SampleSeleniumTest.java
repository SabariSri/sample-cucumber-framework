package cucumber.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleSeleniumTest {

	private static WebDriver driver = null;

	public static void main(String[] args) {

		// Create a new instance of the Firefox driver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Deleting all the cookies
		driver.manage().deleteAllCookies();

		// Specifiying pageLoadTimeout and Implicit wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Put a Implicit wait, this means that any search for elements on the page
		// could take the time the implicit wait is set for before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the linkedin site
		driver.get("https://www.linkedin.com");

		// Find the element & click
		driver.findElement(By.xpath(".//*[text()='Sign in']")).click();

		// Enter Username on the element found the xpath
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("-----------");

		// Enter Password on the element found by the xpath
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("-----------");

		// Now submit the form. WebDriver will find the form for us from the element
		driver.findElement(By.xpath(".//*[@type='submit']")).click();

		// Print a Log In message to the screen
		System.out.println("Login Successfully");

		// Close the driver
		driver.close();
		driver.quit();

	}

}
