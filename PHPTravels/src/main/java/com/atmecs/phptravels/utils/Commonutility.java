package com.atmecs.phptravels.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Commonutility {
	static WebDriver driver;

	public static void clickElement(final String xpath) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(1))
				.withTimeout(Duration.ofSeconds(30));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.click();
				return true;
			}

		});
	}

	public static void selectDropdown(final String xpath, int timeOut, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(1))
				.withTimeout(Duration.ofSeconds(30));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				Select select = new Select(element);

				select.selectByVisibleText(text);
				return true;
			}

		});
	}

	public static void clickAndSendText(final String xpath, int timeOutInSeconds, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(1))
				.withTimeout(Duration.ofSeconds(30));

		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.sendKeys(text);
				;
				return true;
			}
		});
	}

	public static WebElement getElement(String xpath) {

		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

}
