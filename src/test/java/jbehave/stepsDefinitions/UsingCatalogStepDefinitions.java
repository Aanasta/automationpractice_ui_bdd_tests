package jbehave.stepsDefinitions;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class UsingCatalogStepDefinitions extends AbstractStepDefinitions {

    @When("user goes to the catalog page")
    public void userOpensWomenTabInCatalogPage() {
        usingCatalogSteps.userOpensWomenTabInCatalogPageStep();
    }

    @When("user filters products by setting price slider")
    public void userSetsPriceSlider() {
        usingCatalogSteps.userSetsPriceSliderStep();
    }

    @When("user sorts products in <sortingOrder>")
    public void userSortsProductsOnThePage(@Named("sortingOrder") String sortingOrder) {
        usingCatalogSteps.userSortsProductsOnThePageStep(sortingOrder);
    }

    @Then("loading spinner should be displayed")
    public void loadingSpinnerShouldBeDisplayed() {
        usingCatalogSteps.isLoadingSpinnerDisplayedStep();
    }

    @Then("loading spinner image should be as expected")
    public void loadingSpinnerImageShouldBeAsExpected() {
        usingCatalogSteps.isLoadingSpinnerImageAsExpectedStep();
    }

    @Then("price filter <priceRange> should be applied")
    public void priceFilterShouldBeApplied(@Named("priceRange") String priceRange) {
        usingCatalogSteps.isPriceFilterAppliedStep(priceRange);
    }

    @Then("<sortingOrder> should be applied")
    public void sortingOptionShouldBeApplied(@Named("sortingOrder") String sortingOrder) {
        usingCatalogSteps.isSortingOptionAppliedStep(sortingOrder);
    }

    @Then("products quantity in the catalog should be <expectedProductsQuantity>")
    public void productsCountShouldBeAsExpected(@Named("expectedProductsQuantity") int expectedProductsCount) {
        usingCatalogSteps.isProductsCountAsExpectedStep(expectedProductsCount);
    }

}
