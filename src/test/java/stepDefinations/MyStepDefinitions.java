package stepDefinations;


import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import Cucumber.Automatition.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;

@RunWith(Cucumber.class)
public class MyStepDefinitions extends Base {
	public WebDriver driver; 
	HomePage h;
	CheckOutPage cp;
	

    @Given("^User is on Greencart Langing page$")
    public void user_is_on_greencart_langing_page() throws Throwable {
    	driver = Base.getDriver();
    }

    @When("^User seached for \"([^\"]*)\" vegetable$")
    public void user_seached_for_something_vegetable(String name) throws Throwable {
    	// // tagname[@attribute='value']    para acceder al html 
    	System.out.println("search:  " + name);
    	 h = new HomePage(driver);
    	 h.getSearch().sendKeys(name);
    	Thread.sleep(3000);
    }
    


    @Then("^\"([^\"]*)\" results are displayed$")
    public void something_results_are_displayed(String strArg1) throws Throwable {
    	//driver = Base.getDriver();
    	Assert.assertTrue( driver.findElement(By.cssSelector("h4.product-name")).getText().contains(strArg1));// devuelve lo que coincida con el nombre y en este caso el titulo del producto estaba en esta clase css
    	
    }
    

    @Given("^User is on Greencart Langing page2$")
    public void user_is_on_greencart_langing_page_() throws Throwable {
    	driver = Base.getDriver();
    	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

  /* @When("^User seached for \"([^\"]*)\" vegetable2$")
    public void user_seached_for_something_vegetable_(String strArg1) throws Throwable {
   	 h = new HomePage(driver);
   	 h.getSearch().sendKeys(strArg1);
   	 Thread.sleep(3000);
    }
    */
    
    @When("^User seached for (.+) vegetable2$")
    public void user_seached_for_vegetable2(String vegetal) throws Throwable {
    	
      	 h = new HomePage(driver);
       	 h.getSearch().sendKeys(vegetal);
       	 Thread.sleep(3000);
    }

    @Then("^verify selected (.+) items are displayed in check	out page$")
    public void verify_selected_something_items_are_displayed_in_checkout_page(String strArg1) throws Throwable {
    	Assert.assertTrue( driver.findElement(By.cssSelector("p.product-name")).getText().contains(strArg1));
    }

    @And("^Added items to cart$")
    public void added_items_to_cart() throws Throwable {
    	
    	driver.findElement(By.cssSelector("a.increment")).click();
    	//sale analizando con  chrome
    	driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]")).click();
    	
    }

    @And("^User proceeded to Checkout page for purchase$")
    public void user_proceeded_to_checkout_page_for_purchase() throws Throwable {
    	driver.findElement(By.xpath("//a[@class='cart-icon']//img[contains(@class,'')]")).click();
    	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
    }

}