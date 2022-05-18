package TestMobexo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

public class TestDependency implements ITestListener {

	public static WebDriver driver = null;

	@BeforeTest

	public void startBrowser() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "//drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");
	}

	@Test(dependsOnGroups={"new"}, priority = 1)

	public void Test1() {

		System.out.println("This is test 1");

		driver.findElement(By.className("license-plate-input_region__mC3x9")).sendKeys("BO");

		driver.findElement(By.className("license-plate-input_letters__1o4sg")).sendKeys("CC");

		driver.findElement(By.className("license-plate-input_numbers__19K2B")).sendKeys("4500");

		driver.findElement(By.className("license-plate-input_icon__2sABH")).click();

		sleep(2000);

		driver.findElement(By.className("license-plate-input_icon__2sABH")).submit();
	}

	@Test(groups= {"new"}, priority = 2)
	public void Test4() {

		System.out.println("This is test 2");

		// driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");

		pages.UnathorizedUser.firstsearchBox(driver).sendKeys("BO");
		pages.UnathorizedUser.secondsearchBox(driver).sendKeys("CC");
		pages.UnathorizedUser.thirdsearchBox(driver).sendKeys("4500H");

		pages.UnathorizedUser.buttonSearch(driver).click();

		sleep(2000);

		pages.UnathorizedUser.buttonSearch(driver).submit();

	}

	private static void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	public void TearDowm() {
		driver.quit();
	}

}
