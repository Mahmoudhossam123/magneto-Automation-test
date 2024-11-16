package stepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static pages.P01_User_registration.*;
import static pages.P02_login.*;

public class D01_User_registration {

    @Given ("the user navigates to the \"Create an Account\" page")
    public void user_navigate_to_create_new_account_page()throws Exception{
        open_home_page();
        signup_btn();
    }
    @When ("the user enters their first name and last name")
    public void user_enter_his_first_and_last_name()throws Exception{
        sendkeys_firstname();
        sendkeys_lastname();
    }
    @And ("the user provides a valid email and a strong password")
    public void user_enter_his_email()throws Exception {
        sendkeys_email();
        sendkeys_pass();
    }
    @And ("the user confirms the password correctly")
    public void user_confirm_pass()throws Exception{
        sendkeys_confirmpass();
    }

    @And ("the user clicks the \"Create Account\" button")
    public void user_click_on_create_account_btn()throws Exception{
        createaccount_btn();
    }
    @Then ("the user should be redirected to their new account dashboard")
    public void user_can_navigate_to_his_new_account()throws Exception{
        signup_successfully();
    }
    @And ("the user provides an invalid email format and a strong password")
    public void user_enter_wrong_email()throws Exception{
        sendkeys_wrongemail();
        sendkeys_pass();

    }
    @And("the user enters a different password in the \"Confirm Password\" field")
    public void user_enter_different_confirm_pass()throws Exception{
        sendkeys_wrongconfirmpass();
    }
    @Then ("an error message indicating \"Invalid email format\" should appear")
    public void invalid_email_msg_appear ()throws Exception{
     wrong_email_msg();
    }
    @Then ("an error message indicating \"Passwords do not match\" should appear")
    public void  confirmation_pass_error()throws Exception{
        confirm_pass_error();
    }
    @Then("an error message indicating \"Please fill in all required fields\" should appear")
    public void messing_value_error_appear()throws Exception{
        messing_value_error();
        quitDriver();
    }



}