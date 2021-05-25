package Cucumber.Automatition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver; 
	public static Properties propiedades;
	

	
	public static WebDriver getDriver() throws IOException {
		propiedades = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Pablo\\eclipse-workspace\\Automatition\\src\\test\\java\\Cucumber\\Automatition\\global.properties"); // el path
		propiedades.load(fis);
		
		System.setProperty("webdriver.chrome.driver" ,"D:\\Escritorio2\\CHROME_SELENIUM\\chromedriver.exe");
	   	driver = new ChromeDriver();
	   	driver.get( (String) propiedades.get("url") );
	   	return driver;
	}
}
