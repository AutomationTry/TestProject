package TestMobexo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentRepoertsTestNG {

	WebDriver driver;

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	@BeforeSuite

	public void setup() {

		// start reporters
		htmlReporter = new ExtentHtmlReporter("extentReports1.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@BeforeTest

	public void setupTest() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "//drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void test1() throws Exception {

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("MyFirstTest", "Sample description");

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
		
	}
		// driver.findElement(By.className("repair-status-unauthorized_page__alVxj"));

		/*
		 * // log(Status, details) test.log(Status.INFO,
		 * "This step shows usage of log(status, details)");
		 * 
		 * // info(details) test.info("This step shows usage of info(details)");
		 * 
		 * // log with snapshot test.fail("details",
		 * MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		 * 
		 * // test with snapshot test.addScreenCaptureFromPath("screenshot.png");
		 */
	
	@AfterTest
	public void tearDownTest() {

		driver.quit();

	} 

	@AfterSuite
	public void tearDown() {

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
