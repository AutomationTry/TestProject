package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class unauthaurizedUserPageObjects {

	WebDriver driver = null;

	By firstbox_search = By.className("license-plate-input_region__mC3x9");

	By secondbox_search = By.className("license-plate-input_letters__1o4sg");

	By thirdbox_search = By.className("license-plate-input_numbers__19K2B");

	By searchButton = By.className("license-plate-input_icon__2sABH");

	By listpage = By.className("repair-status-unauthorized_page__alVxj");

	public unauthaurizedUserPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void setFirstTextInSearch(String text) {
		driver.findElement(firstbox_search).sendKeys(text);
	}

	public void setSecondTextInSearch(String text) {
		driver.findElement(secondbox_search).sendKeys(text);
	}

	public void setThirdTextInSearch(String text) {
		driver.findElement(thirdbox_search).sendKeys(text);
	}

	public void clickSearchButton() {
		driver.findElement(searchButton).click();
	}

	public void returnSearchButton() {
		driver.findElement(searchButton).submit();
	}

}
