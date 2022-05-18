package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnathorizedUser {

	private static WebElement element = null;

	public static WebElement firstsearchBox(WebDriver driver) {

		element = driver.findElement(By.className("license-plate-input_region__mC3x9"));
		return element;
	}

	public static WebElement secondsearchBox(WebDriver driver) {

		element = driver.findElement(By.className("license-plate-input_letters__1o4sg"));
		return element;
	}

	public static WebElement thirdsearchBox(WebDriver driver) {

		element = driver.findElement(By.className("license-plate-input_numbers__19K2B"));
		return element;
	}

	public static WebElement buttonSearch(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".license-plate-input_icon__2sABH"));
		return element;

	}

}
