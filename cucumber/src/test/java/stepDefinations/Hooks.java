package stepDefinations;


import Cucumber.Automatition.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base {//se ejecuta antes de cada escenario, el problema es que no se puede usar uno en comun para cada escenario

	
	@After("@seleniumTest1")
	public void afterSeleniumTest1() {// NO SE PUEDEN USAR HOOKS Y BACKGROUNDS AL MISMO TIEMPO
		System.out.println("close");
		driver.close();// por herencia ya lo tengo desde base 
	}
	
	@After("@escenario1")
	public void afterescenario1() {

		driver.close();
	}
	
	@After("@escenario2")// escenario 2 y3 
	public void afterescenario2() {

		driver.close();
	}

	@Before("@WebTest")
	public void beforevaldiationWeb() {// NO SE PUEDEN USAR HOOKS Y BACKGROUNDS AL MISMO TIEMPO
		System.out.println("WEB BEFORE HOOK****");
	}



}
