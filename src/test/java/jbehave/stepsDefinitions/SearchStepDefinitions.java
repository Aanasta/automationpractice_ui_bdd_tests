package jbehave.stepsDefinitions;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class SearchStepDefinitions extends AbstractStepDefinitions {

    @When("user searches for <searchedProduct>")
    public void userSearchesForProduct(@Named("searchedProduct") String searchedProduct) {
        searchingProductsSteps.userSearchesForProductStep(searchedProduct);
    }

    @Then("search results page should be opened")
    public void searchResultsPageShouldBeOpened() {
        searchingProductsSteps.isSearchResultsPageOpenedStep();
    }

    @Then("search results should be displayed")
    public void searchResultsShouldBeDisplayed() {
        searchingProductsSteps.areSearchResultsDisplayedStep();
    }

    @Then("number of search results should be <expectedNumberOfSearchResults>")
    public void numberOfResultsShouldBeAsExpected(@Named("expectedNumberOfSearchResults") int expectedSearchResultsNumber) {
        searchingProductsSteps.isNumberOfResultsAsExpectedStep(expectedSearchResultsNumber);
    }

    @Then("<searchedProduct> should be displayed in search results")
    public void searchedProductShouldBeDisplayedInResults(@Named("searchedProduct") String searchedProduct) {
        searchingProductsSteps.isSearchedProductDisplayedInResultsStep(searchedProduct);
    }

}
