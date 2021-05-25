package stepDefinations;

import java.util.List;

import org.junit.runner.RunWith;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class stepDefination {
	
    @Given("^User is on Netbacking landing page$")
    public void user_is_on_netbacking_landing_page() throws Throwable {
       System.out.println("iniciando sesion");
    }

    @When("^User login into application with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_login_into_application_with_username_and_password(String username , String password) throws Throwable {
    	   System.out.println("logged succes user: "+username+ " pass:"+password);
    }

    @Then("^Home page is populate$")
    public void home_page_is_populate() throws Throwable {
    	 System.out.println("validate home ok");
    }

    @And("^Cards are displayed \"([^\"]*)\"$")
    public void cards_are_displayed(String v) throws Throwable {
    	// code
    	 System.out.println("validate cards  : " + v);
    }
    
    @When("^User sign up with following details$")
    public void user_sign_up_with_following_details(DataTable data) throws Throwable {
    	
    	List<List<String>> obj = data.asLists(); 
    	System.out.println("----DATA TABLE---");
    	System.out.println(obj.get(0).get(0));
    	System.out.println(obj.get(0).get(1));
    	System.out.println(obj.get(0).get(2));
    	System.out.println(obj.get(0).get(3));
    	System.out.println(obj.get(0).get(4));

    }

    @When("^User login application with (.+) and (.+)$")
    public void user_login_application_with_and(String username, String password) throws Throwable {
        System.out.println("user: " + username);
        System.out.println("Pass: " + password );
    }
    
    @Given("^validate the browser$")
    public void validate_the_browser() throws Throwable {
        System.out.println(".");
    }

    @When("^browser is triggered$")
    public void browser_is_triggered() throws Throwable {
        System.out.println(".");
    }

    @Then("^check if browser is started$")
    public void check_if_browser_is_started() throws Throwable {
        System.out.println(".");
    }

}
