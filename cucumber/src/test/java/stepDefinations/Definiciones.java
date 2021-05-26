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

import pageObjects.HomePage;

@RunWith(Cucumber.class)
public class Definiciones extends Base {
	public WebDriver driver; 
	HomePage h;
	
	
	// TEST 1 -------------------------------------------------------------
	
    @Given("^carga la pagina de bdg$")
    public void carga_la_pagina_de_bdg() throws Throwable {
       driver = Base.getDriver();
    }
    @When("^el usuario ingresa su user (.+)  y su password (.+)$")
    public void el_usuario_ingresa_su_user_y_su_password(String user, String password) throws Throwable {
       System.out.println(user);
       driver.findElement(By.id("WucLogin_TxtUsuario")).sendKeys(user);
       driver.findElement(By.id("WucLogin_TxtClave")).sendKeys(password);
    }
    
    @And("^hace click en el boton de ingresar$")
    public void hace_click_en_el_boton_de_ingresar() throws Throwable {
    	
    	  driver.findElement(By.id("WucLogin_BtnLogin")).click();
      	Thread.sleep(3000);
    }

    @Then("^ingresa a la pantalla principal$")
    public void ingresa_a_la_pantalla_principal() throws Throwable {
    	//WucRolxUsuario_lbSaludo
    	
    	  String texto =  driver.findElement(By.id("WucRolxUsuario_lbSaludo")).getText();
   
    	 System.out.println(texto);
    }



	// -------------------------------------------------------------------
    //test2 y test3-------------------------------------------------------
    
    @Then("^no deja entrar a  la pantalla principal$")
    public void no_deja_entrar_a_la_pantalla_principal() throws Throwable {
       // WucLogin_InvalidTokenMsg_Label
    	String texto =  driver.findElement(By.id("WucLogin_InvalidTokenMsg_Label")).getText();
    	System.out.print(texto);
    }
    
    
    //--------------------------------------------------------------------
	

    @Given("^User is on Greencart Langing page2$")
    public void user_is_on_greencart_langing_page_() throws Throwable {
    	driver = Base.getDriver();
    }

    
    @When("^User seached for (.+) vegetable2$")
    public void user_seached_for_vegetable2(String vegetal) throws Throwable {
    	
      	 h = new HomePage(driver);
       	// h.getSearch().sendKeys(vegetal);
       	// Thread.sleep(3000);
    }

    @Then("^verify selected (.+) items are displayed in check	out page$")
    public void verify_selected_something_items_are_displayed_in_checkout_page(String strArg1) throws Throwable {
    	//Assert.assertTrue( driver.findElement(By.cssSelector("p.product-name")).getText().contains(strArg1));
    	System.out.println("ok");
    }

    @And("^Added items to cart$")
    public void added_items_to_cart() throws Throwable {
    	//driver.findElement(By.cssSelector("a.increment")).click();
    	//sale analizando con  chrome
    	//driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]")).click();
      	System.out.println("ok");
    	
    }

    @And("^User proceeded to Checkout page for purchase$")
    public void user_proceeded_to_checkout_page_for_purchase() throws Throwable {
     	System.out.println("ok");
    	//driver.findElement(By.xpath("//a[@class='cart-icon']//img[contains(@class,'')]")).click();
    	//driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
    }

}