package stepDefinitions;

import driverUtil.DriverInitiation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.DemoPageObject;


public class DemoStepDefinition {

    DemoPageObject demoPageObject = new DemoPageObject();
    DriverInitiation driverUtil = new DriverInitiation();
    WebDriver driver = driverUtil.newDriver();

    @Given("I add four different product to my wishlist")
    public void i_add_four_different_product_to_my_wishlist() {
        driver.get("https://testscriptdemo.com/");
        demoPageObject.searchProductsAndInWishList(driver);
    }

    @When("I view my wishlist table")
    public void i_view_my_wishlist_table() {
        demoPageObject.viewWishList(driver);
    }

    @Then("I find total four selected items in my wishlist")
    public void i_find_total_four_selected_items_in_my_wishlist() {
        demoPageObject.countTheNumberOfProduct(driver);
    }

    @When("I search for lowest price product")
    public void i_search_for_lowest_price_product() {
        demoPageObject.getProductPrice(driver);
    }

    @When("I am able to add the lowest price product to my cart")
    public void i_am_able_to_add_the_lowest_price_product_to_my_cart() {
        demoPageObject.addingLowestPriceProductInCart(driver);
    }

    @Then("I am able to verify the item in my cart")
    public void i_am_able_to_verify_the_item_in_my_cart() {
        demoPageObject.verifyItemAddedToCart(driver);
    }

}
