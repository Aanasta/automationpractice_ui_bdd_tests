package jbehave.stepsDefinitions;

import com.automationpractice.steps.*;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;


public class AbstractStepDefinitions {

    @Steps
    OpeningMainPageSteps openingMainPageSteps;

    @Steps
    SearchingProductsSteps searchingProductsSteps;

    @Steps
    UsingCatalogSteps usingCatalogSteps;

    @Steps
    OrderingProductsSteps orderingProductsSteps;

    @Steps
    LoggingInSteps loggingInSteps;

    @Given("main page is opened")
    public void mainPageIsOpened() {
        openingMainPageSteps.mainPageIsOpenedStep();
    }

}
