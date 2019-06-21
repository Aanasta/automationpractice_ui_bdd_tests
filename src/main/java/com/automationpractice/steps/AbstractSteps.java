package com.automationpractice.steps;

import com.automationpractice.pages.*;
import net.thucydides.core.annotations.Step;

public class AbstractSteps {

    protected AbstractPage abstractPage;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    protected CatalogPage catalogPage;
    protected ShoppingCartPage shoppingCartPage;
    protected SearchResultsPage searchResultsPage;

    @Step("main page is opened")
    public void mainPageIsOpened() {
        mainPage.open();
    }
    
}
