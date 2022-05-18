package TestMobexo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Newtestclass {

	private static WebDriver driver = null;

	public static void searchTest() {
		// Create driver

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\s.koldaieva\\eclipse-workspace\\new-maven-project\\drivers\\chromedriver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");

	}
}
