package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Cucumber.Automatition.Base;

public class HomePage {
	public WebDriver driver;
	By search = By.xpath("//input[@type='search']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	 public WebElement getSearch() {
		return driver.findElement(search);
	 }
	 

}
