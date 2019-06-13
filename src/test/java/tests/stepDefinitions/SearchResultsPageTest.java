package tests.stepDefinitions;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.ParsePomManager;

@RunWith(SerenityRunner.class)
public class SearchResultsPageTest extends AbstractStepDefinitions{

    @Test
    public void searchIsWorkingTest() {

        String searchedProduct = ParsePomManager.getStringPropertyFromPom("productSearchQuery");

        //GIVEN
        mainPage.mainPageIsOpened();

        //WHEN
        mainPage.userSearchesForProduct(searchedProduct);

        //THEN
        searchResultsPage.searchResultsPageShouldBeOpened();
        searchResultsPage.searchResultsShouldBeDisplayed();
        searchResultsPage.numberOfResultsShouldBeAsExpected();
        searchResultsPage.searchedProductShouldBeDisplayedInResults(searchedProduct);
    }

}
