package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.P04_womenproductlist.*;

public class D04_womenproductlist {

    @When ("the user selects the \"Women\" category")
    public void user_select_women() throws Exception {
        women_category();
    }


        @And("the user selects the \"Hoodies & Sweatshirts\" category from the filter options")
    public void user_select_hw_category() throws Exception {
        user_select_category_HW();
    }

    @Then("the user should be redirected to the \"Hoodies & Sweatshirts\" product page")
    public void user_navigate_to_hw_page() throws Exception {
        HW_category_page();
    }

    @Given("the user selects the \"Jackets\" category from the filter options")
    public void user_select_jk_category() throws Exception {
        user_select_category_jackets();
    }

    @Then("the user should be redirected to the \"Jackets\" product page")
    public void user_navigate_to_jk_page() throws Exception {
        jackets_category_page();
    }

    @Given("the user selects the \"Tees\" category from the filter options")
    public void user_select_tees_category() throws Exception {
        user_select_category_tees();
    }

    @Then("the user should be redirected to the \"Tees\" product page")
    public void user_navigate_to_tees_page() throws Exception {
        tees_category_page();
    }

    @Given("the user selects the BT category from the filter options")
    public void user_select_bt_category() throws Exception {
        user_select_category_bt();
    }

    @Then("the user should be redirected to the BT product page")
    public void user_navigate_to_bt_page() throws Exception{


        bt_category_page();
    }
    @Given("the user selects the \"Pants\" category from the filter options")
    public void user_select_pants_category() throws Exception {
        user_select_category_pants();
    }
    @Then("the user should be redirected to the \"Pants\" product page")
    public void user_navigate_to_pants_page() throws Exception {
        pants_category_page();
    }
    @Given("the user selects the \"Shorts\" category from the filter options")
    public void user_select_shorts_category() throws Exception {
        user_select_category_shorts();
    }
    @Then("the user should be redirected to the \"Shorts\" product page")
    public void user_navigate_to_shorts_page() throws Exception {
        shorts_category_page();
        quitDriver();
    }

}
