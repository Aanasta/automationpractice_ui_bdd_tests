package jbehave.unregisteredUserStepDefinitions;

import com.automationpractice.pages.*;
import org.jbehave.core.annotations.Given;

public class AbstractStepDefinitions {

    protected AbstractPage abstractPage;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    protected CatalogPage catalogPage;
    protected ShoppingCartPage shoppingCartPage;
    protected SearchResultsPage searchResultsPage;

    @Given("main page is opened")
    public void mainPageIsOpened() {
        mainPage.open();
    }

}
