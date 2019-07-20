package com.automationpractice.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class OpeningMainPageSteps extends AbstractSteps {

    @Step
    public void mainPageIsOpenedStep() {
        mainPage.open();
    }

    @Step
    public void userOpensMainPageStep() {
        mainPage.clickLogoAndOpenMainPage();
    }

    @Step
    public void isNumberOfProductsAsExpectedStep(int popularProductsCount) {
        Assert.assertEquals("Number of products in Popular tab is not as expected", popularProductsCount, mainPage.getPopularProductsCount());
    }

    @Step
    public void isMainLogoDisplayedStep() {
        Assert.assertTrue("Main logo is not displayed", mainPage.isMainLogoDisplayed());
    }

    @Step
    public void isMainLogoUrlAsExpectedStep(String mainLogoUrl) {
        Assert.assertEquals("Main logo URL is not as expected", mainLogoUrl, mainPage.getMainLogoUrl());
    }

    @Step
    public void isShoppingCartButtonClickableStep() {
        Assert.assertTrue("Shopping cart button is not clickable", mainPage.isShoppingCartButtonClickable());
    }

    @Step
    public void isSearchBarAvailableStep() {
        Assert.assertTrue("Search bar is not available", mainPage.isSearchBarAvailable());
    }

    @Step
    public void productsShouldBeDisplayedStep() {
        Assert.assertTrue("Products are not displayed on the page", abstractPage.isProductContainerDisplayed());
    }

}
