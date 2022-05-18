import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenPage {
	public static void main(String[] args) {

		//String projectPath = System.getProperty("user.dir");
		//System.out.println("projectPath :" + projectPath);

		// System.setProperty("webdriver.gecko.driver",
		// projectPath+"//drivers/geckodriver/geckodriver.exe");

		// WebDriver driver = new FirefoxDriver();

		// System.setProperty("webdriver.chrome.driver",
		// projectPath+"//drivers/chromedriver/chromedriver.exe");
		// WebDriver driver = new ChromeDriver();

		// System.setProperty("webdriver.edge.driver",
		// projectPath+"//drivers/msedgedriver/msedgedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		// driver.quit();
	}

}
