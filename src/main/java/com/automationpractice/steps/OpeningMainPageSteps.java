package com.automationpractice.steps;

import com.automationpractice.steps.AbstractSteps;
import com.automationpractice.utils.ParsePomManager;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class OpeningMainPageSteps extends AbstractSteps {

    @Step
    public void mainPageIsOpened() {
        mainPage.open();
    }

    @Step
    public void userOpensMainPage() {
        mainPage.clickLogoAndOpenMainPage();
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
    public void productsShouldBeDisplayed() {
        Assert.assertTrue("Products are not displayed on the page", abstractPage.isProductContainerDisplayed());
    }

}
