package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static pages.P03_whatsnewpage.*;

public class D03_whatsnewpage {



    @When("the user clicks on the \"What's New\" button")
    public void user_click_on_whats_new_page() throws Exception {
        open_whatsnew_page();
    }

    @Then("the user should be redirected to the \"What's New\" page")
    public void user_navigate_to_whats_new_page() throws Exception {
        navigate_to_page();
    }



    @When("the new products are loaded")
    public void the_new_products_are_loaded() throws Exception {
        product_loaded();
    }

    @And ("each product should have an image, a name, and a price")
    public void each_product_should_have_an_image() throws Exception {
        product_image();
        product_name();
        product_price();
    }


    @Given ("the user selects any product")
    public void user_select_any_product() throws Exception {
       select_product();
    }


        @And ("the user clicks on the \"Compare Product\" button")
        public void user_click_on_compare_product() throws Exception {

        compare_product();
        }

    @Then ("the product should be added to the \"Compare Products\" list")
    public void user_chick_compare_product_field() throws Exception {
       comparison_list_page();

    }
   @Given ("the user clicks on the \"Add to Wishlist\" button")

   public void user_click_on_add_to_wish_button() throws Exception {
    add_to_wish_list();
    }
    @Then ("the product should be added to the wishlist")
    public void user_check_add_to_wish_list() throws Exception{
        add_to_wish_list_page();
        quitDriver();
    }

}
