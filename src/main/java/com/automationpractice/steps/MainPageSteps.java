package com.automationpractice.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import com.automationpractice.utils.ParsePomManager;

public class MainPageSteps extends AbstractSteps {

    @Step
    public void userSearchesForProduct(String searchedProduct) {
        mainPage.searchForProduct(searchedProduct);
    }

    @Step
    public void numberOfProductsShouldBeAsExpected() {
        Assert.assertEquals("Number of products in Popular tab is not as expected", ParsePomManager.getIntPropertyFromPom("popularProductsCount"), mainPage.getPopularProductsCount());
    }

    @Step
    public void mainLogoShouldBeDisplayed() {
        Assert.assertTrue("Main logo is not displayed", mainPage.isMainLogoDisplayed());
    }

    @Step
    public void mainLogoUrlShouldBeAsExpected() {
        Assert.assertEquals("Main logo URL is not as expected", ParsePomManager.getStringPropertyFromPom("mainLogoUrl"), mainPage.getMainLogoUrl());
    }

    @Step
    public void shoppingCartButtonShouldBeClickable() {
        Assert.assertTrue("Shopping cart button is not clickable", mainPage.isShoppingCartButtonClickable());
    }

    @Step
    public void searchBarShouldBeAvailable() {
        Assert.assertTrue("Search bar is not available", mainPage.isSearchBarAvailable());
    }




    @Step
    public void userAddsBlouseToCartAndContinuesShopping() {
        mainPage.addBlouseAndContinueShopping();
    }

    @Step
    public void userAddsTshirtToCartAndGoesToCart() {
        mainPage.addTshirtAndGoToShoppingCart();
    }

}
