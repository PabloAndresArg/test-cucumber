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

	@Before("@WebTest")
	public void beforevaldiationWeb() {// NO SE PUEDEN USAR HOOKS Y BACKGROUNDS AL MISMO TIEMPO
		System.out.println("WEB BEFORE HOOK****");
	}



}
