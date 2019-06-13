package tests.steps;

import com.automationpractice.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import utils.ParsePomManager;

import static com.automationpractice.pages.SearchResultsPage.getSearchResultsPageUrl;

public class SearchResultsPageSteps extends AbstractPageSteps {

    SearchResultsPage searchResultsPage;

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
