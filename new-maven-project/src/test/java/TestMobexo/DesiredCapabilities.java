package TestMobexo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DesiredCapabilities {

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		
		 System.setProperty("webdriver.chrome.driver", projectPath + "//drivers/chromedriver/chromedriver.exe"); 
		 WebDriver driver = new ChromeDriver(options);
		 /* 
		 * EdgeOptions caps = new EdgeOptions();
		 * caps.setCapability("ignoreProtectedModeSettings", true);
		 */

		//System.setProperty("webdriver.edge.driver", projectPath + "//drivers/msedgedriver/msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();

		driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");

		pages.UnathorizedUser.firstsearchBox(driver).sendKeys("BO");
		pages.UnathorizedUser.secondsearchBox(driver).sendKeys("CC");
		pages.UnathorizedUser.thirdsearchBox(driver).sendKeys("4500");

		pages.UnathorizedUser.buttonSearch(driver).click();

		sleep(2000);

		pages.UnathorizedUser.buttonSearch(driver).submit();

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
