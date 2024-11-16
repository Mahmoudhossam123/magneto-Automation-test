package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utility.BrowserDriver;


import static pages.P06_addtocart.*;
import static pages.P02_login.open_home_page;


public class D06_addtocart extends BrowserDriver {

    @Given("the user is on the homepage")
    public void user_open_whats_new_page() throws Exception {
        open_home_page();

    }


    @When("the user selects a product")

   public void user_add_product_to_cart() throws Exception{
        open_product();



    }

    @And  ("the user clicks on \"Add to Cart\"")
    public void user_click_on_add_to_cart()throws Exception{

        add_to_cart_button();

    }

    @And  ("the user navigates to their shopping cart")
    public void user_Check_his_cart() throws Exception{
       check_cart();

    }
    @Then("the selected product should be visible in the shopping cart")
    public void user_should_find_the_product_added() throws Exception {

        cart_item();

    }
    @Given ("the user has items in their shopping cart")
    public void items_in_shopping_cart()throws Exception{
        cart_item();
    }
    @When ("the user removes an item")
    public void user_try_to_delete_item() throws Exception {
    delete_item();

    }
    @Then ("the item should no longer appear in the shopping cart")
    public void item_should_be_deleted() throws Exception{
        cart_item();
        quitDriver();
    }
    @When ("the user updates the quantity of an item")
    public void user_try_to_update_item() throws Exception {
        update_item();
        add_qty();
    }

    @Then ("the cart should reflect the updated quantity")
    public void item_updated()throws Exception{
   update_button();
    }
    @When ("the user enters an invalid discount code")
    public void user_enter_invalid_code()throws Exception{
        apply_discount_code();
    }
    @Then ("an error message should appear stating \"Invalid coupon code\"")
    public void coupon_is_invalid()throws Exception{
        invalid_coupon();
    }
}
