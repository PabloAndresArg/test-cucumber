package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckOutPage {

	public WebDriver driver;

	By  selector = By.cssSelector("h4.product-name");
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	 public WebElement getProductName() {
		return driver.findElement(selector);
	 }
}



