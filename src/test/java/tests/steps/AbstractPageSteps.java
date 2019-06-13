package tests.steps;

import com.automationpractice.pages.*;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class AbstractPageSteps {

    AbstractPage abstractPage;
    MainPage mainPage;
    LoginPage loginPage;
    AccountPage accountPage;
    CatalogPage catalogPage;
    ShoppingCartPage shoppingCartPage;

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
}
