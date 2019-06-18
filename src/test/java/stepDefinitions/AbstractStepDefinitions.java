package stepDefinitions;

import com.automationpractice.steps.MainPageSteps;
import com.automationpractice.steps.ShoppingCartPageSteps;
import com.automationpractice.steps.registeredUserSteps.*;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

public class AbstractStepDefinitions {

    @Managed
    WebDriver driver;

    @Steps
    protected LoggingInSteps loginSteps;

    @Steps
    protected RegisteringSteps registrationSteps;

    @Steps
    protected ProductOrderingSteps productOrderingSteps;

    @Steps
    protected ProductsSearchingSteps productsSearchingSteps;

    @Steps
    protected CatalogUsingSteps usingCatalogSteps;

    @Steps
    protected MainPageSteps mainPage;

    @Steps
    protected CatalogPageSteps catalogPage;

    @Steps
    protected ShoppingCartPageSteps shoppingCartPage;

}
