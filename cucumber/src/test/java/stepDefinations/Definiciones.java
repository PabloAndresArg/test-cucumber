package stepDefinations;

import org.openqa.selenium.WebElement;

import java.util.List;

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
      	Thread.sleep(2000);
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
	
    // TEST4--------------------------------

    @Given("^carga la pagina de bdg en la pantalla principal$")
    public void carga_la_pagina_de_bdg_en_la_pantalla_principal() throws Throwable {
        driver = Base.getDriver();
        driver.findElement(By.id("WucLogin_TxtUsuario")).sendKeys("pargueta");
        driver.findElement(By.id("WucLogin_TxtClave")).sendKeys("Root@7arg");
  	  	driver.findElement(By.id("WucLogin_BtnLogin")).click();
  	  	
    	Thread.sleep(2000); 
    	
    	
    }

    @When("^selecciono un rol del combobox$")
    public void selecciono_un_rol_del_combobox() throws Throwable {
    	// administrador o Self-service
    	 driver.findElement( By.xpath("//select[@id='WucRolxUsuario_ddlRoles']" )).click();
    	 
    	 List<WebElement> lista_valores_combobox =   driver.findElement( By.xpath("//select[@id='WucRolxUsuario_ddlRoles']" )).findElements(By.xpath("option")); 
    	 Boolean testOK = false; 
    	 for(WebElement we : lista_valores_combobox) {
    		 
    		 if(we.getText().equalsIgnoreCase("administrador")  || we.getText().equalsIgnoreCase("Self-service") ) {
    			 testOK = true;
    			 Thread.sleep(500);
    			 we.click();
    			 if (we.isSelected()) {
    				 System.out.println("OK");
    				 break;
    			 }
    		 }
    		 
    	 }
    	 
    	 if(!testOK) {
    			Assert.assertFalse(true);
    	 }
    }
    
    @Then("^ingresa al panel de bdg$")
    public void ingresa_al_panel_de_bdg() throws Throwable {
    	Thread.sleep(1500);
    	System.out.println(driver.findElement(By.id("WucMenu_WucToolbar_LblUsername")).getText());
  	  	
    }

    @And("^hace click en el boton de s7$")
    public void hace_click_en_el_boton_de_s7() throws Throwable {
  	  	driver.findElement(By.id("WucRolxUsuario_app_1")).click();
    }

    //------------
    
    // test 5---------------------------------------------------------
    

    @Given("^carga el panel administrativo de bdg (.+)$")
    public void carga_el_panel_administrativo_de_bdg(String passactual) throws Throwable {
        driver = Base.getDriver();
        driver.findElement(By.id("WucLogin_TxtUsuario")).sendKeys("pargueta");
        driver.findElement(By.id("WucLogin_TxtClave")).sendKeys(passactual);
  	  	driver.findElement(By.id("WucLogin_BtnLogin")).click();

    	Thread.sleep(2000);
  	  	driver.findElement(By.id("WucRolxUsuario_app_1")).click();
    }
    
    @When("^hace click en desplegar menu$")
    public void hace_click_en_desplegar_menu() throws Throwable {
    	Thread.sleep(1500);
	  	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[1]/button[1]")).click();
  		
    }
    

    @And("^hace click en administracion$")
    public void hace_click_en_administracion() throws Throwable {
    	
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
    }



    @And("^hace click en configuracion de usuarios$")
    public void hace_click_en_configuracion_de_usuarios() throws Throwable {
  		Thread.sleep(800);
  		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[2]/a[1]")).click();
    }

    @And("^hace click en cambio de contraseña$")
    public void hace_click_en_cambio_de_contrasea() throws Throwable {
  		Thread.sleep(1000);
  		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[2]/ul[1]/li[3]/a[1]")).click();
    }
    
    
    @And("^ingresa la contraseña  actual (.+)$")
    public void ingresa_la_contrasea_actual(String passactual) throws Throwable {
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys(passactual);
    }

    @And("^ingresa la contraseña nueva  (.+)$")
    public void ingresa_la_contrasea_nueva(String newpass) throws Throwable {
    		Thread.sleep(1000);
        	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/input[1]")).sendKeys(newpass);
    }

    @And("^verifica la contraseña nueva (.+)$")
    public void verifica_la_contrasea_nueva(String newpass) throws Throwable {
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/input[1]")).sendKeys(newpass);
    }


    


    
    @And("^click en aceptar$")
    public void click_en_aceptar() throws Throwable {
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/input[1]")).click();
    	Thread.sleep(5000);
    }
    
    
    @Then("^logearme con nueva contraseña (.+)$")
    public void logearme_con_nueva_contrasea(String newpass) throws Throwable {
    	Thread.sleep(500);
	  	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[1]/button[1]")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[5]/a[1]/span[2]")).click();
    	Thread.sleep(1000);
     	driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[3]/div[1]/div[1]/button[2]")).click();
    	Thread.sleep(2000);
    	
    	
        driver.findElement(By.id("WucLogin_TxtUsuario")).sendKeys("pargueta");
        driver.findElement(By.id("WucLogin_TxtClave")).sendKeys(newpass);
  	  	driver.findElement(By.id("WucLogin_BtnLogin")).click();
    	Thread.sleep(3000);
  	  	driver.findElement(By.id("WucRolxUsuario_app_1")).click();
  	  	driver.close();
    }
    
    

    
    
    // --------------------------------------------------------------
    
    // test 6 -------------------------------------------------------
    
    @Given("^carga el panel administrativo de bdg2 (.+)$")
    public void carga_el_panel_administrativo_de_bdg2(String passactual) throws Throwable {
        driver = Base.getDriver();
        driver.findElement(By.id("WucLogin_TxtUsuario")).sendKeys("pargueta");
        driver.findElement(By.id("WucLogin_TxtClave")).sendKeys("Root@7arg");
  	  	driver.findElement(By.id("WucLogin_BtnLogin")).click();

    	Thread.sleep(2000);
  	  	driver.findElement(By.id("WucRolxUsuario_app_1")).click();
    }
    
    @And("^hace click en administracion de usuarios$")
    public void hace_click_en_administracion_de_usuarios() throws Throwable {
  		Thread.sleep(1000);
  		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]")).click();
    }
    
    @And("^busca el usuario \"([^\"]*)\" presionando en buscar$")
    public void busca_el_usuario_something_presionando_en_buscar(String usuario) throws Throwable {
		Thread.sleep(900);
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/input[1]")).sendKeys(usuario);
    	Thread.sleep(900);
  		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[10]/div[1]/button[1]/i[1]")).click();
  		Thread.sleep(900);
    }
    
    @And("^hace click en reiniciar contraseña$")
    public void hace_click_en_reiniciar_contrasea() throws Throwable {
		Thread.sleep(2500);
  		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[12]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/a[1]/span[1]")).click();
  		Thread.sleep(4000);
    }
    
    @And("^se mueve a desplegar menu en la esquina derecha   Customer care mensajeria$")
    public void se_mueve_a_desplegar_menu_en_la_esquina_derecha_customer_care_mensajeria() throws Throwable {
    	Thread.sleep(1350);
	  	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[1]/button[1]")).click();
	  	Thread.sleep(1000);
	  	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[3]/a[1]/span[1]")).click();
	  	Thread.sleep(1000);
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[3]/a[1]")).click();
	  	Thread.sleep(1000);
    }
    
    @Then("^observara la informacion en el ultimo mensaje de la contraseña que se asigno$")
    public void observara_la_informacion_en_el_ultimo_mensaje_de_la_contrasea_que_se_asigno() throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
	  	Thread.sleep(1000);	
    }
    
    
    //---------------------------------------------------------------

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