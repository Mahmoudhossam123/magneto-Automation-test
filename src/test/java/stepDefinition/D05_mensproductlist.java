package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.P05_mensproductlist.*;

public class D05_mensproductlist {

    @When("the user selects the \"Men's\" category")
    public void user_select_mens_category() throws Exception {
        mens_category();
    }


    @And("the user selects the \"Hoodies & Sweatshirts\" category from the men's options")
    public void user_select_hw_category() throws Exception {
     user_select_category_mensHW();
    }

    @Then("the user should be redirected to the \"Men's Hoodies & Sweatshirts\" page")
    public void user_navigate_to_hw_page() throws Exception {
      mensHW_category_page();
    }

    @Given("the user selects the \"Jackets\" category from the men's options")
    public void user_select_jk_category() throws Exception {
      user_select_category_mensjackets();
    }

    @Then("the user should be redirected to the \"Men's Jackets\" page")
    public void user_navigate_to_jk_page() throws Exception {
        mensjackets_category_page();
    }

    @Given("the user selects the \"Tees\" category from the men's options")
    public void user_select_tees_category() throws Exception {
        user_select_category_menstees();
    }

    @Then("the user should be redirected to the \"Men's Tees\" page")
    public void user_navigate_to_tees_page() throws Exception {
        menstees_category_page();
    }

    @Given("the user selects the \"Tanks\" category from the men's options")
    public void user_select_bt_category() throws Exception {
        user_select_category_mens_t();
    }

    @Then("the user should be redirected to the \"Men's Tanks\" page")
    public void user_navigate_to_bt_page() throws Exception{


        mens_t_category_page();
    }
    @Given("the user selects the \"Pants\" category from the men's options")
    public void user_select_pants_category() throws Exception {
        user_select_category_menspants();
    }
    @Then("the user should be redirected to the \"Men's Pants\" page")
    public void user_navigate_to_pants_page() throws Exception {
        menspants_category_page();
    }
    @Given("the user selects the \"Shorts\" category from the men's options")
    public void user_select_shorts_category() throws Exception {
        user_select_category_mensshorts();
    }
    @Then("the user should be redirected to the \"Men's Shorts\" page")
    public void user_navigate_to_shorts_page() throws Exception {
        mensshorts_category_page();
        quitDriver();
    }

}
