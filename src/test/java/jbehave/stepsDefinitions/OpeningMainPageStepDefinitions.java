package jbehave.stepsDefinitions;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;

public class OpeningMainPageStepDefinitions extends AbstractStepDefinitions {

    @Then("products should be displayed")
    public void productsShouldBeDisplayed() {
        Assert.assertTrue("Products are not displayed on the page", abstractPage.isProductContainerDisplayed());
    }

    @Then("search bar should be available")
    public void searchBarShouldBeAvailable() {
        Assert.assertTrue("Search bar is not available", mainPage.isSearchBarAvailable());
    }

    @Then("number of products should be <expectedProductsNumber>")
    public void numberOfProductsShouldBeAsExpected(@Named("expectedProductsNumber") int productsNumber) {
        Assert.assertEquals("Number of products in Popular tab is not as expected", productsNumber, mainPage.getPopularProductsCount());
    }

    @Then("main logo should be displayed")
    public void mainLogoShouldBeDisplayed() {
        Assert.assertTrue("Main logo is not displayed", mainPage.isMainLogoDisplayed());
    }

    @Then("main logo url should be <mainLogoUrl>")
    public void mainLogoUrlShouldBeAsExpected(@Named("mainLogoUrl") String mainLogoUrl) {
        Assert.assertEquals("Main logo URL is not as expected", mainLogoUrl, mainPage.getMainLogoUrl());
    }

    @Then("shopping cart button should be clickable")
    public void shoppingCartButtonShouldBeClickable() {
        Assert.assertTrue("Shopping cart button is not clickable", mainPage.isShoppingCartButtonClickable());
    }
}
