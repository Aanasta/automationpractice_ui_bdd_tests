package jbehave.stepsDefinitions;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import static com.automationpractice.pages.SearchResultsPage.getSearchResultsPageUrl;

public class SearchStepDefinitions extends AbstractStepDefinitions {

    @When("user searches for <searchedProduct>")
    public void userSearchesForProduct(@Named("searchedProduct") String searchedProduct) {
        mainPage.searchForProduct(searchedProduct);
    }

    @Then("search results page should be opened")
    public void searchResultsPageShouldBeOpened() {
        Assert.assertEquals("Search results page is not opened", getSearchResultsPageUrl(), searchResultsPage.getCurrentUrl());
    }

    @Then("search results should be displayed")
    public void searchResultsShouldBeDisplayed() {
        Assert.assertTrue("Search results are not displayed", searchResultsPage.isProductContainerDisplayed());
    }

    @Then("number of search results should be <expectedNumberOfSearchResults>")
    public void numberOfResultsShouldBeAsExpected(@Named("expectedNumberOfSearchResults") int expectedSearchResultsNumber) {
        Assert.assertEquals("Number of search results is not as expected", expectedSearchResultsNumber, searchResultsPage.getDisplayedProductsCount());
    }

    @Then("<searchedProduct> should be displayed in search results")
    public void searchedProductShouldBeDisplayedInResults(@Named("searchedProduct") String searchedProduct) {
        Assert.assertEquals("Search is not working as expected", searchedProduct, searchResultsPage.getSearchResultName());
    }

}
