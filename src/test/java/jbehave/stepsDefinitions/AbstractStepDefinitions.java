package jbehave.stepsDefinitions;

import com.automationpractice.steps.*;
import org.jbehave.core.annotations.Given;

public class AbstractStepDefinitions {

    protected AbstractSteps abstractSteps;
    protected LoggingInSteps loggingInSteps;
    protected OpeningMainPageSteps openingMainPageSteps;
    OrderingProductsSteps orderingProductsSteps;
    SearchingProductsSteps searchingProductsSteps;
    UsingCatalogSteps usingCatalogSteps;

    @Given("main page is opened")
    public void mainPageIsOpened() {
        abstractSteps.mainPageIsOpened();
    }

}
