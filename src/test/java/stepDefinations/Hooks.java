package stepDefinations;


import Cucumber.Automatition.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base {//se ejecuta antes de cada escenario, el problema es que no se puede usar uno en comun para cada escenario

	@Before("@MobileTest")
	public void beforevaldiation() {// NO SE PUEDEN USAR HOOKS Y BACKGROUNDS AL MISMO TIEMPO
		System.out.println("MOBILE BEFORE HOOK****");
	}
	
	@After("@MobileTest")
	public void aftervaldiation() {// NO SE PUEDEN USAR HOOKS Y BACKGROUNDS AL MISMO TIEMPO
		System.out.println("MOBILE AFTER HOOK***");
	}

	@After("@seleniumTest")
	public void afterSeleniumTest() {// NO SE PUEDEN USAR HOOKS Y BACKGROUNDS AL MISMO TIEMPO
		driver.close();// por herencia ya lo tengo desde base 
	}
	@After("@seleniumTest1")
	public void afterSeleniumTest1() {// NO SE PUEDEN USAR HOOKS Y BACKGROUNDS AL MISMO TIEMPO
		System.out.println("close");
		//driver.close();// por herencia ya lo tengo desde base 
	}

	@Before("@WebTest")
	public void beforevaldiationWeb() {// NO SE PUEDEN USAR HOOKS Y BACKGROUNDS AL MISMO TIEMPO
		System.out.println("WEB BEFORE HOOK****");
	}
	
	@After("@WebTest")
	public void aftervaldiationWeb() {// NO SE PUEDEN USAR HOOKS Y BACKGROUNDS AL MISMO TIEMPO
		System.out.println("WEB AFTER HOOK***");
	}


}
