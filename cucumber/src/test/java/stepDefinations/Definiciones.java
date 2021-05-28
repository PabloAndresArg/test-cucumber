package stepDefinations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    	Thread.sleep(1200);
    	
		driver.findElement( By.xpath("//select[@id='WucRolxUsuario_ddlRoles']" )).click();
		 
		 List<WebElement> lista_valores_combobox =   driver.findElement( By.xpath("//select[@id='WucRolxUsuario_ddlRoles']" )).findElements(By.xpath("option")); 
		 Boolean testOK = false; 
		 for(WebElement we : lista_valores_combobox) {
			 
			 if(we.getText().equalsIgnoreCase("administrador")) {
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
    	Thread.sleep(1500);
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
    }
    
    
    //---------------------------------------------------------------
    
    // TEST 7 ----------------------------------------------------
    

    @And("^selecciona  persona la cual se encuentra en el apartado de catalogos basicos$")
    public void selecciona_persona_la_cual_se_encuentra_en_el_apartado_de_catalogos_basicos() throws Throwable {
	  	Thread.sleep(1000);
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]")).click();
	  	Thread.sleep(1000);
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[13]/a[1]")).click();	
	  	Thread.sleep(1000);   				
    }
    
    
    @And("^hace click en crear dentro del modulo de catalogos basicos persona$")
    public void hace_click_en_crear_dentro_del_modulo_de_catalogos_basicos_persona() throws Throwable {
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[4]/div[1]/a[2]/span[1]")).click();
      	Thread.sleep(1000);
	  	
    }
    
    @And("^llena el formulario de creacion de persona con los campos nombres (.+) , apellidos (.+)  y sexo (.+) cumpliendo asi los campos necesarios$")
    public void llena_el_formulario_de_creacion_de_persona_con_los_campos_nombres_something_apellidos_something_y_sexo_something_cumpliendo_asi_los_campos_necesarios(String nombres, String apellidos, String sexo) throws Throwable {
    	
    Thread.sleep(800); 
    driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/input[1]")).sendKeys(nombres);
 	Thread.sleep(800); 
    driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[3]/div[2]/input[1]")).sendKeys(apellidos);
 	Thread.sleep(800); 
 	String xPATH = "";
 	if (sexo.equalsIgnoreCase("F")) {
 	  xPATH = "/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/input[1]";
 	}else {
 	  xPATH = "/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/input[1]";	
 	}
    driver.findElement(By.xpath(xPATH)).click();
 	Thread.sleep(800); 

    }

    @Then("^hace click en guardar$")
    public void hace_click_en_crear() throws Throwable {
        System.out.println("CREA A UNA PERSONA");
       
        driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[16]/div[1]/a[2]/span[1]")).click();
     	Thread.sleep(7000); 
        	
    }
    
    @And("^Aparezca en la consulta de personas con su nombre (.+) y apellidos (.+)$")
    public void aparezca_en_la_consulta_de_personas_con_su_nombre_something_y_apellidos_something(String nombres, String apellidos) throws Throwable {
    	Thread.sleep(800); 
    	String xPATH = "/html[1]/body[1]/form[1]/nav[1]/div[1]/div[3]/div[1]/div[3]/a[1]";
    	driver.findElement(By.xpath(xPATH)).click();
    	Thread.sleep(1000); 
    	
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[6]/div[2]/div[1]/input[1]")).sendKeys(nombres);
    	Thread.sleep(1000); 	
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[6]/div[4]/div[1]/input[1]")).sendKeys(apellidos);
     	Thread.sleep(1000); 
     	
     	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]")).click();
     	
     	Thread.sleep(5000); 
    	String nombresApellidos =  driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]/span[1]")).getText();
    	System.out.println("BUSCANDO:"+ nombres +" "+apellidos);
    	System.out.println("Encuentra:"+nombresApellidos);
    	if(!(nombresApellidos.equalsIgnoreCase(nombres +" "+apellidos))) {
    		Assert.assertFalse(true);
        	System.out.println("DIFERENTES!!");
    	}else {
    		System.out.println("OK SI LO ENCUENTRA");
    	}
    	 
    }

    

    
    


    //------------------------------------------------------------
    
    //TEST8------------------------------------------------------
    @And("^busca a la persona de nombres (.+) y apellidos (.+) llenando el formulario dandole click en buscar$")
    public void busca_a_la_persona_de_nombres_something_y_apellidos_something_llenando_el_formulario_dandole_click_en_buscar(String nombres, String apellidos) throws Throwable {
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/input[1]")).sendKeys(nombres);
    	Thread.sleep(1000); 	
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/input[1]")).sendKeys(apellidos);
     	Thread.sleep(1000); 
     	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[4]/div[1]/a[1]")).click();

    	
    	
    }
    
    
 
    @Then("^lo convierte en empleado$")
    public void lo_convierte_en_empleado() throws Throwable {
    	Thread.sleep(5000); 
    	driver.findElement(By.xpath(" /html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[6]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/a[1]/span[1]")).click();
    	Thread.sleep(5000); 
    }
    
    @And("^verifica si se convirtio en empleado mediante una busqueda por nombre (.+) y apellido (.+)$")
    public void verifica_si_se_convirtio_en_empleado_mediante_una_busqueda_por_nombre_something_y_apellido_something(String nombres, String apellidos) throws Throwable {
    	Thread.sleep(1000);
	  	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[1]/button[1]")).click();
	  	Thread.sleep(1000);
	  	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
	 	Thread.sleep(1000);
	 	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
	  	Thread.sleep(1000);
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]")).click();
	  	Thread.sleep(1000);
	  	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[5]/a[1]")).click();
    	Thread.sleep(5000); 
    
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[4]/div[1]/input[1]")).sendKeys(nombres);
    	Thread.sleep(1000); 	
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[6]/div[1]/input[1]")).sendKeys(apellidos);
     	Thread.sleep(1000); 
     	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[10]/div[1]/button[1]/i[1]")).click();
      	Thread.sleep(3000); 
      	System.out.println(driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[11]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]")));
     	
    	
    }

   

    

    //-----------------------------------------------------------
    
    
    // TEST 9 -----------------------------------------------
    

    @And("^click en el boton para agrgar usuarios$")
    public void click_en_el_boton_para_agrgar_usuarios() throws Throwable {
    	Thread.sleep(1000); 
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]")).click();
    }
    

    @And("^busca al empleado por medio de nombre (.+) y apellido (.+)$")
    public void busca_al_empleado_por_medio_de_nombre_something_y_apellido_something(String nombres, String apellidos) throws Throwable {
    	
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[6]/div[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys(nombres);
     	Thread.sleep(1000); 
     	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[6]/div[1]/div[1]/div[2]/div[2]/input[1]")).sendKeys(apellidos);
    	Thread.sleep(1000); 	
     	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[6]/div[1]/div[1]/div[2]/div[3]/button[1]")).click();
     	// CLICK ASIGNAR
     	Thread.sleep(1000);
     	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[7]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/a[1]/span[1]")).click();    	
    }
    
    @And("^ingresa un nuevo usuario (.+) ingresandolo en el textbox seguido presiona registar$")
    public void ingresa_un_nuevo_usuario_something_ingresandolo_en_el_textbox_seguido_presiona_registar(String username) throws Throwable {
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys(username);			
    	Thread.sleep(1500);	
    	System.out.println("USUARIO CREADO");
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/input[1]")).click();    	
    	Thread.sleep(6000);
    }
    

    
    //-------------------------------------------------------
    
    // TEST10 ----------------------------------------------
    
    @And("^hace click en administracion de roles$")
    public void hace_click_en_administracion_de_roles() throws Throwable {
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]")).click();			
    }
    
    @And("^hace click en asignar usuarios$")
    public void hace_click_en_asignar_usuarios() throws Throwable {
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/a[1]/span[1]")).click();			
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[2]")).click();			
    	
    }
    
    @And("^busco el usuario por nombre (.+) y apellido (.+) y su vez se selecciona$")
    public void busco_el_usuario_something_y_su_vez_se_selecciona(String nom , String apellidos) throws Throwable { // REPORTAR PROBLEMA CON USUARIO
    	driver.manage().window().maximize();
    	Thread.sleep(2000);  
    	// input usersname   

    	WebElement frame_modal = driver.findElement(By.xpath("//body/div[@id='s7modal']/div[1]/div[1]/div[2]/div[1]/div[1]/iframe[1]"));
    	driver.switchTo().frame(frame_modal); // me muevo hacia ese marco
    	Thread.sleep(1000);  
    	driver.findElement(By.cssSelector("#ContentPlaceHolder_WucFiltroUsuarios_TxtNombrePersona")).sendKeys(nom);
    	Thread.sleep(1000);  
    	driver.findElement(By.cssSelector("#ContentPlaceHolder_WucFiltroUsuarios_TxtApellidoPersona")).sendKeys(apellidos);
    	Thread.sleep(1000); 
        // boton buscar
    	
    	driver.findElement(By.cssSelector("#ContentPlaceHolder_WucFiltroUsuarios_LnkBuscar")).click();	
     	
    	
    	Thread.sleep(5000); 
     	//---------------------------------------------------------------------------------------------------------------- 
    	//CHECK
    	
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[4]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).click();
     
    	// BTN ASIGNAR ROL
    	Thread.sleep(1500); 
    	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[3]/div[1]/button[2]")).click();
    	Thread.sleep(5000); 
    	
    	
    	//SALIR---------------------------------
    	
    	driver.switchTo().parentFrame(); //regresa al frame anterior
    	driver.findElement(By.xpath("//button[@id='btnModalClose']")).click();
    	Thread.sleep(1200); 
    	

    	
     	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[1]/button[1]")).click();
    	Thread.sleep(1200); 
    	// btn de salir
     	driver.findElement(By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[2]/ul[1]/li[5]/a[1]/span[2]")).click();
    	Thread.sleep(1200); 
    	// confirma la salida
     	driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[3]/div[1]/div[1]/button[2]")).click();
    	Thread.sleep(1200); 
    	
    }
    
    @Then("^verifica que se pueda logear con el usuario (.+) y su password (.+)$")
    public void verifica_que_se_pueda_logear_con_el_usuario_y_su_password(String username, String password) throws Throwable {
    	Thread.sleep(600); 
        driver.findElement(By.id("WucLogin_TxtUsuario")).sendKeys(username);
        driver.findElement(By.id("WucLogin_TxtClave")).sendKeys(password);
  	  	driver.findElement(By.id("WucLogin_BtnLogin")).click();
    	Thread.sleep(2100);

    	// sale que cambie la contraseña 
    }
    
    @And("^establecer una contraNueva (.+) quitando la antigua (.+)$")
    public void establecer_una_contranueva_quitando_la_antigua(String newpassword, String password) throws Throwable {

    	Thread.sleep(1000);
    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[3]/div[1]/input[1]")).sendKeys(password);
    	Thread.sleep(600);
    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[4]/div[1]/input[1]")).sendKeys(newpassword);
    	Thread.sleep(400);
    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[5]/div[1]/input[1]")).sendKeys(newpassword);
    	Thread.sleep(1200);

    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[6]/div[2]/input[1]")).click();
      	Thread.sleep(5000);

      	// cierra sesion

      	
      	System.out.print("ok");
    }
    
    @And("^logeo con user (.+) y pass (.+) para verificar la nueva contrasena$")
    
    public void logeo_con_user_y_pass_para_verificar_la_nueva_contrasena(String username, String contranueva) throws Throwable {
    	Thread.sleep(2000);
        driver.findElement(By.id("WucLogin_TxtUsuario")).sendKeys(username);
        driver.findElement(By.id("WucLogin_TxtClave")).sendKeys(contranueva);
        
        driver.findElement(By.id("WucLogin_BtnLogin")).click();
      	Thread.sleep(2000);
        String texto =  driver.findElement(By.id("WucRolxUsuario_lbSaludo")).getText();
        
    }


    
 
    		
    
    		
    	
    
    //------------------------------------------------------

}