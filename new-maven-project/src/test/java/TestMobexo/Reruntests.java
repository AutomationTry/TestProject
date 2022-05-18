package TestMobexo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Reruntests {
	public static WebDriver driver = null;

	@BeforeTest
	public void startBrowser() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "//drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");
	}

	@Test(groups = { "windows.sanity" })
	public void Test1() {

		driver.findElement(By.className("license-plate-input_region__mC3x9")).sendKeys("BO");

		driver.findElement(By.className("license-plate-input_letters__1o4sg")).sendKeys("CC");

		driver.findElement(By.className("license-plate-input_numbers__19K2B")).sendKeys("4500");

		driver.findElement(By.className("license-plate-input_icon__2sABH")).click();

		sleep(2000);

		driver.findElement(By.className("license-plate-input_icon__2sABH")).submit();
	}

	@Test(retryAnalyzer = Listeners.RetryAnalyzer.class)
	public void Test2() {

		// driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");

		pages.UnathorizedUser.firstsearchBox(driver).sendKeys("BO");
		pages.UnathorizedUser.secondsearchBox(driver).sendKeys("CC");
		pages.UnathorizedUser.thirdsearchBox(driver).sendKeys("450");

		pages.UnathorizedUser.buttonSearch(driver).click();

		sleep(2000);

		pages.UnathorizedUser.buttonSearch(driver).submit();
		
	}

	@Test
	public void Test3() {
		// driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");

		pages.UnathorizedUser.firstsearchBox(driver).sendKeys("ADM");
		pages.UnathorizedUser.secondsearchBox(driver).sendKeys("IN");
		pages.UnathorizedUser.thirdsearchBox(driver).sendKeys("123");

		pages.UnathorizedUser.buttonSearch(driver).click();

		sleep(2000);

		pages.UnathorizedUser.buttonSearch(driver).submit();
	}

	@Test
	public void Test4() {

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
