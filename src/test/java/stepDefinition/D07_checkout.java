package stepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utility.BrowserDriver;
import static pages.P07_checkout.*;
public class D07_checkout extends BrowserDriver {


        @Then("the user redirected to the checkout page")
        public void user_navigate_to_checkout_page() throws Exception {
            checkout_page();


        }
        @Given("the user logs into their account")
        public void user_login() throws Exception {
        checkout_login();
       }

            @And("the user enters valid shipping and payment details")
            public void user_enter_valid_credentials() throws Exception {

       credential();
            }

            @And("the user clicks on \"Next\"")
            public void user_click_next() throws Exception {
                next();
            }

            @And("the user clicks on \"Place Order\"")
            public void user_click_on_place_order() throws Exception {
                place_order();
            }

            @Then("the user should be redirected to the success page")
            public void user_navigate_to_success_page() throws Exception {
                success_page();
                quitDriver();
            }



        }

