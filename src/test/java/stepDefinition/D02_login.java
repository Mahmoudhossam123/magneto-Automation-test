package stepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static pages.P02_login.*;

public class D02_login {

    @Given("the user navigates to the \"Login\" page")
    public void user_navigate_to_login_page() throws InterruptedException {
       open_home_page();
       open_login_page();
    }

    @When("the user enters a valid email address")
    public void User_enter_valid_email() throws Exception {

      Sendkeys_loginemail();
    }

    @And("the user enters a valid password")
    public void User_enter_valid_password() throws Exception {
        Sendkeys_loginpass();
        clickonsubmit_btn();
    }
    @Then("the user should be redirected to their account dashboard")
    public void user_could_navigate_to_his_account()throws Exception{
        login_successfully();
    }

    @When("the user enters an invalid email address")
    public void user_enter_invalid_email()throws Exception{
        Sendkeys_invalidemail();
    }
    @And("the user enters an incorrect password")
    public void user_enter_invalid_pass()throws Exception{
        Sendkeys_invalidpass();
        clickonsubmit_btn();
    }
    @Then ("an error message indicating \"Incorrect password\" should be displayed")
    public void invalid_message_appear()throws Exception{
        invalid_login_msg();
    }
    @Then("an error message indicating \"Invalid email address\" should be displayed")
    public void Invalid_login_msg()throws Exception{
        Invalid_email_msg();

    }
    @Then ("an error message indicating \"Invalid email or password\" should be displayed")
    public void invalid_email_msg()throws Exception{
        Invalid_email_msg();
        quitDriver();
    }
}
