package com.automationpractice.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static com.automationpractice.pages.SearchResultsPage.getSearchResultsPageUrl;

public class SearchingProductsSteps extends AbstractSteps {

    @Step
    public void userSearchesForProductStep(String searchedProduct) {
        mainPage.searchForProduct(searchedProduct);
    }

    @Step
    public void isSearchResultsPageOpenedStep() {
        Assert.assertEquals("Search results page is not opened", getSearchResultsPageUrl(), searchResultsPage.getCurrentUrl());
    }

    @Step
    public void areSearchResultsDisplayedStep() {
        Assert.assertTrue("Search results are not displayed", searchResultsPage.isProductContainerDisplayed());
    }

    @Step
    public void isNumberOfResultsAsExpectedStep(int expectedSearchResultsCount) {
        Assert.assertEquals("Number of search results is not as expected", expectedSearchResultsCount, searchResultsPage.getDisplayedProductsCount());
    }

    @Step
    public void isSearchedProductDisplayedInResultsStep(String searchedProduct) {
        Assert.assertEquals("Search is not working as expected", searchedProduct, searchResultsPage.getSearchResultName());
    }
}
