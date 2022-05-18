package TestMobexo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.UnathorizedUser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test_search {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		searchTest();
	}

	public static void searchTest() {
		// Create driver

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\s.koldaieva\\eclipse-workspace\\new-maven-project\\drivers\\chromedriver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://portal-mobexo-de-frontend-sandbox.azurewebsites.net/reparaturstatus/suche");

		/*
		 * WebElement searchBox = driver.findElement(By.className(
		 * "license-plate-input_input_form__2FOaw"));
		 * 
		 * wait.until(ExpectedConditions.visibilityOf(searchBox));
		 */

		pages.UnathorizedUser.firstsearchBox(driver).sendKeys("BO");
		pages.UnathorizedUser.secondsearchBox(driver).sendKeys("CC");
		pages.UnathorizedUser.thirdsearchBox(driver).sendKeys("4500");
		// WebElement secondInputField =
		// driver.findElement(By.className("license-plate-input_letters__1o4sg"));
		// WebElement thirdInputField =
		// driver.findElement(By.className("license-plate-input_numbers__19K2B"));
		pages.UnathorizedUser.buttonSearch(driver).click();

		WebElement listPage = driver.findElement(By.className("repair-status-unauthorized_page__alVxj"));

		sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(listPage));

		/*
		 * firstInputField.sendKeys("BO"); secondInputField.sendKeys("CC");
		 * thirdInputField.sendKeys("4500");
		 * 
		 * search.submit();
		 */

		// search.sendKeys(Keys.RETURN);

		System.out.println("Test completed");

		driver.quit();

	}

	private static void sleep(int i) {
		// TODO Auto-generated method stub

	}

}
