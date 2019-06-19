package jbehave.unregisteredUserStepDefinitions;

import com.automationpractice.steps.AbstractSteps;
import com.automationpractice.utils.ParsePomManager;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class userOpensMainPageStepDefinitions extends AbstractSteps {

    @When("main page is opened")
    public void mainPageisopened() {
        mainPage.open();
    }

    @Then("products should be displayed")
    public void productsShouldBeDisplayed() {
        Assert.assertTrue("Products are not displayed on the page", abstractPage.isProductContainerDisplayed());
    }

    @Then("search bar should be available")
    public void searchBarShouldBeAvailable() {
        Assert.assertTrue("Search bar is not available", mainPage.isSearchBarAvailable());
    }

    @Then("number of products should be as expected")
    public void numberOfProductsShouldBeAsExpected() {
        Assert.assertEquals("Number of products in Popular tab is not as expected", ParsePomManager.getIntPropertyFromPom("popularProductsCount"), mainPage.getPopularProductsCount());
    }

    @Then("main logo should be displayed")
    public void mainLogoShouldBeDisplayed() {
        Assert.assertTrue("Main logo is not displayed", mainPage.isMainLogoDisplayed());
    }

    @Then("main logo url should be as expected")
    public void mainLogoUrlShouldBeAsExpected() {
        Assert.assertEquals("Main logo URL is not as expected", ParsePomManager.getStringPropertyFromPom("mainLogoUrl"), mainPage.getMainLogoUrl());
    }

    @Then("shopping cart button should be clickable")
    public void shoppingCartButtonShouldBeClickable() {
        Assert.assertTrue("Shopping cart button is not clickable", mainPage.isShoppingCartButtonClickable());
    }
}
