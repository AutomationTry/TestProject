package Listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.unauthaurizedUserPageObjects;

//@Listeners({ListenersTest.class})

public class TestNGListenerDemo {

	private static WebDriver driver = null;

	@Test
	public void one() {
		System.out.println("I am inside Test 1");
	}

	@Test
	public void two() {
		System.out.println("I am inside Test 2");

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

	@Test
	public void three() {
		System.out.println("I am inside Test 3");
		throw new SkipException("This test case is skipped");
	}

}
