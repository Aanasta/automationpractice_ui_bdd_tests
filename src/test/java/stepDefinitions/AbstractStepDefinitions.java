package stepDefinitions;

import com.automationpractice.steps.*;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

public class AbstractStepDefinitions {

    @Managed
    WebDriver driver;

    @Steps
    protected OpeningMainPageSteps openingMainPageSteps;

    @Steps
    protected LoggingInSteps loggingInSteps;

    @Steps
    protected OrderingProductsSteps orderingProductsSteps;

    @Steps
    protected SearchingProductsSteps searchingProductsSteps;

    @Steps
    protected UsingCatalogSteps usingCatalogSteps;

}
