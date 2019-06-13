package tests.stepDefinitions;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import tests.steps.*;

public class AbstractStepDefinitions {

    @Managed
    WebDriver driver;

    @Steps
    SearchResultsPageSteps searchResultsPage;

    @Steps
    MainPageSteps mainPage;

    @Steps
    LoginPageSteps loginPage;

    @Steps
    AccountPageSteps accountPage;

    @Steps
    CatalogPageSteps catalogPage;

    @Steps
    ShoppingCartPageSteps shoppingCartPage;
}
