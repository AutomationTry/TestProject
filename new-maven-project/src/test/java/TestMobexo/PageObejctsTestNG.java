package TestMobexo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.unauthaurizedUserPageObjects;

public class PageObejctsTestNG {

	private static WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "//drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public static void SearchObjectTest() {

		pages.unauthaurizedUserPageObjects searchPageObj = new unauthaurizedUserPageObjects(driver);

		driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");

		searchPageObj.setFirstTextInSearch("BO");
		searchPageObj.setSecondTextInSearch("CC");
		searchPageObj.setThirdTextInSearch("4500");

		searchPageObj.clickSearchButton();

		sleep(5000);

		searchPageObj.returnSearchButton();

	}
	
	@Test
	public static void incorrectSearchTest() {

		pages.unauthaurizedUserPageObjects searchPageObj = new unauthaurizedUserPageObjects(driver);

		driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");

		searchPageObj.setFirstTextInSearch("BO");
		searchPageObj.setSecondTextInSearch("CC");
		searchPageObj.setThirdTextInSearch("450");

		searchPageObj.clickSearchButton();

		sleep(5000);

		searchPageObj.returnSearchButton();

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
