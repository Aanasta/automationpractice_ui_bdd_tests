package stepDefinitions.notRegisteredUserStepDefinitions;

import com.automationpractice.utils.ParsePomManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import stepDefinitions.AbstractStepDefinitions;

@RunWith(SerenityRunner.class)
public class userSearchesForProductsTest extends AbstractStepDefinitions {

    @Test
    public void searchIsWorkingTest() {

        String searchedProduct = ParsePomManager.getStringPropertyFromPom("productSearchQuery");

        //GIVEN
        openingMainPageSteps.mainPageIsOpened();

        //WHEN
        searchingProductsSteps.userSearchesForProduct(searchedProduct);

        //THEN
        searchingProductsSteps.searchResultsPageShouldBeOpened();
        searchingProductsSteps.searchResultsShouldBeDisplayed();
        searchingProductsSteps.numberOfResultsShouldBeAsExpected();
        searchingProductsSteps.searchedProductShouldBeDisplayedInResults(searchedProduct);
    }

}
