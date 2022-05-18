package TestMobexo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentReportsBasic {

	private static WebDriver driver = null;

	public static void main(String[] args) {

		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("Unauthorized Search", "Search test for unauthorized user");

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "//drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		// log(Status, details)
        test1.log(Status.INFO, "Starting test case");

		driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");
		
		test1.pass("Naviagted to unauthorized page");

		driver.findElement(By.className("license-plate-input_region__mC3x9")).sendKeys("BO");
		
		test1.pass("Entered first element");
		
		driver.findElement(By.className("license-plate-input_letters__1o4sg")).sendKeys("CC");
		
		test1.pass("Entered second element");
		
		driver.findElement(By.className("license-plate-input_numbers__19K2B")).sendKeys("4500");
		
		test1.pass("Entered third element");
		
		driver.findElement(By.className("license-plate-input_icon__2sABH")).click();
		
		test1.pass("Clicked search button");

		sleep(2000);

		driver.findElement(By.className("license-plate-input_icon__2sABH")).submit();
		
		test1.pass("Returned result");
		// driver.findElement(By.className("repair-status-unauthorized_page__alVxj"));

		driver.quit();
		test1.pass("Closed the browser");
		
		test1.info("Completed test");
		
		ExtentTest test2 = extent.createTest("Unauthorized Search fail", "Fail test for unauthorized user");
		
		projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "//drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		// log(Status, details)
        test2.log(Status.INFO, "Starting test case");

		driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");
		
		test2.pass("Naviagted to unauthorized page");

		driver.findElement(By.className("license-plate-input_region__mC3x9")).sendKeys("BO");
		
		test2.pass("Entered first element");
		
		driver.findElement(By.className("license-plate-input_letters__1o4sg")).sendKeys("CC");
		
		test2.pass("Entered second element");
		
		driver.findElement(By.className("license-plate-input_numbers__19K2B")).sendKeys("4500");
		
		test2.pass("Entered third element");
		
		driver.findElement(By.className("license-plate-input_icon__2sABH")).click();
		
		test2.fail("Clicked search button");

		sleep(2000);

		driver.findElement(By.className("license-plate-input_icon__2sABH")).submit();
		
		test2.pass("Returned result");
		// driver.findElement(By.className("repair-status-unauthorized_page__alVxj"));

		driver.quit();
		test2.pass("Closed the browser");
		
		test2.info("Completed test");
		
		extent.flush();
	}

	private static void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
