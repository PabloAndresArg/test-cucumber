package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//feature
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features", // proporciono el nombre de features
		glue="stepDefinations", // contiene las definiciones de los metodos correspondientes a lo de la sintaxis Gherkin
		stepNotifications = true,
		monochrome = true ,
		tags="@escenario10" // para filtrar
	//	tags= "@SmokeTest or @regTest" // ejecuta solo estas
	//	plugin = {"pretty" , "html:target/cucumber" , "json:target/cucumber.json" , "junit:target/cukes.xml"} // PARA REPORTES , pretty da colores
		)
public class TestRunner {

}
