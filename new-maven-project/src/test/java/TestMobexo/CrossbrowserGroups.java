package TestMobexo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.unauthaurizedUserPageObjects;

@Test(groups= {"ALL"})
public class CrossbrowserGroups {

	static WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(@Optional("chrome") String browserName) {
		System.out.println("This is browser :"+browserName);
		System.out.println("Thread id:"+Thread.currentThread().getId());
		
		if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", projectPath + "//drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "//drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
			}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath+"//drivers/msedgedriver/msedgedriver.exe");
			driver = new EdgeDriver();
			}

	}

	@Test(retryAnalyzer = Listeners.RetryAnalyzer.class)
	public void Test1() {

		driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");

		pages.UnathorizedUser.firstsearchBox(driver).sendKeys("BO");
		pages.UnathorizedUser.secondsearchBox(driver).sendKeys("CC");
		pages.UnathorizedUser.thirdsearchBox(driver).sendKeys("4500");

		pages.UnathorizedUser.buttonSearch(driver).click();

		sleep(2000);

		pages.UnathorizedUser.buttonSearch(driver).submit();
	}
	
	@Test(retryAnalyzer = Listeners.RetryAnalyzer.class)
	public static void test2() {

		pages.unauthaurizedUserPageObjects searchPageObj = new unauthaurizedUserPageObjects(driver);

		driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");

		searchPageObj.setFirstTextInSearch("BO");
		searchPageObj.setSecondTextInSearch("CC");
		searchPageObj.setThirdTextInSearch("450");

		searchPageObj.clickSearchButton();

		sleep(5000);

		searchPageObj.returnSearchButton();

	}
	
	@Test(retryAnalyzer = Listeners.RetryAnalyzer.class)
	public static void test3() {

		pages.unauthaurizedUserPageObjects searchPageObj = new unauthaurizedUserPageObjects(driver);

		driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");

		searchPageObj.setFirstTextInSearch("ADM");
		searchPageObj.setSecondTextInSearch("IN");
		searchPageObj.setThirdTextInSearch("123");

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