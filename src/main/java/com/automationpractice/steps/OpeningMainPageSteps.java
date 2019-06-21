package com.automationpractice.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class OpeningMainPageSteps extends AbstractSteps {

    @Step
    public void mainPageIsOpened() {
        mainPage.open();
    }
//
//    @Step
//    public void whenUnregisteredUserOpensMainPage() {
//        mainPage.open();
//    }

    @Step
    public void userOpensMainPage() {
        mainPage.clickLogoAndOpenMainPage();
    }

    @Step
    public void numberOfProductsIsAsExpected(int popularProductsCount) {
        Assert.assertEquals("Number of products in Popular tab is not as expected", popularProductsCount, mainPage.getPopularProductsCount());
    }

    @Step
    public void mainLogoIsDisplayed() {
        Assert.assertTrue("Main logo is not displayed", mainPage.isMainLogoDisplayed());
    }

    @Step
    public void mainLogoUrlIsAsExpected(String mainLogoUrl) {
        Assert.assertEquals("Main logo URL is not as expected", mainLogoUrl, mainPage.getMainLogoUrl());
    }

    @Step
    public void shoppingCartButtonIsClickable() {
        Assert.assertTrue("Shopping cart button is not clickable", mainPage.isShoppingCartButtonClickable());
    }

    @Step
    public void searchBarIsAvailable() {
        Assert.assertTrue("Search bar is not available", mainPage.isSearchBarAvailable());
    }

    @Step("products should be displayed")
    public void productsAreDisplayed() {
        Assert.assertTrue("Products are not displayed on the page", abstractPage.isProductContainerDisplayed());
    }

}
