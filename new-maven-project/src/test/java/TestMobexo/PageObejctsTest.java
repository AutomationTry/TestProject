package TestMobexo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.unauthaurizedUserPageObjects;

public class PageObejctsTest {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		SearchObjectTest();
	}

	public static void SearchObjectTest() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "//drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

		pages.unauthaurizedUserPageObjects searchPageObj = new unauthaurizedUserPageObjects(driver);

		driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");

		searchPageObj.setFirstTextInSearch("BO");
		searchPageObj.setSecondTextInSearch("CC");
		searchPageObj.setThirdTextInSearch("4500");

		searchPageObj.clickSearchButton();

		sleep(5000);

		searchPageObj.returnSearchButton();

		driver.quit();

	}

	private static void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
