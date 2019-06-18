package com.automationpractice.steps;

import com.automationpractice.pages.*;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static com.automationpractice.pages.AccountPage.getAccountPageUrl;

public class AbstractSteps {

    protected AbstractPage abstractPage;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    protected CatalogPage catalogPage;
    protected ShoppingCartPage shoppingCartPage;
    protected SearchResultsPage searchResultsPage;

    @Step
    public void mainPageIsOpened() {
        mainPage.open();
    }

    @Step
    public void productsShouldBeDisplayed() {
        Assert.assertTrue("Products are not displayed on the page", abstractPage.isProductContainerDisplayed());
    }

    @Step
    public void userOpensMainPage() {
        abstractPage.clickLogoAndOpenMainPage();
    }


    @Step
    public void loginPageIsOpened() {
        loginPage.open();
    }

    @Step
    public void logoutButtonShouldBeClickable() {
        Assert.assertTrue("Logout button is not displayed", accountPage.isLogoutButtonDisplayed());
    }

    @Step
    public void accountPageShouldBeOpened() {
        Assert.assertEquals("Account page isn't opened", getAccountPageUrl(), accountPage.getCurrentUrl());
    }

}
