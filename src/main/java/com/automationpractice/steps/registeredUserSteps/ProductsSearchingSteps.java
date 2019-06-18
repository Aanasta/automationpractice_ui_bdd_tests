package com.automationpractice.steps.registeredUserSteps;

import com.automationpractice.steps.AbstractSteps;
import com.automationpractice.utils.ParsePomManager;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static com.automationpractice.pages.SearchResultsPage.getSearchResultsPageUrl;

public class ProductsSearchingSteps extends AbstractSteps {

    @Step
    public void userSearchesForProduct(String searchedProduct) {
        mainPage.searchForProduct(searchedProduct);
    }

    @Step
    public void searchResultsPageShouldBeOpened() {
        Assert.assertEquals("Search results page is not opened", getSearchResultsPageUrl(), searchResultsPage.getCurrentUrl());
    }

    @Step
    public void searchResultsShouldBeDisplayed() {
        Assert.assertTrue("Search results are not displayed", searchResultsPage.isProductContainerDisplayed());
    }

    @Step
    public void numberOfResultsShouldBeAsExpected() {
        Assert.assertEquals("Number of search results is not as expected", ParsePomManager.getIntPropertyFromPom("expectedSearchResultsCount"), searchResultsPage.getDisplayedProductsCount());
    }

    @Step
    public void searchedProductShouldBeDisplayedInResults(String searchedProduct) {
        Assert.assertEquals("Search is not working as expected", searchedProduct, searchResultsPage.getSearchResultName());
    }
}
