package stepDefinitions.notRegisteredUserStepDefinitions;

import com.automationpractice.utils.ParsePomManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import stepDefinitions.AbstractStepDefinitions;

@RunWith(SerenityRunner.class)
public class userOpensCatalogPageTest extends AbstractStepDefinitions {

    @Test
    public void catalogPageIsOpenedTest() {

        int expectedProductsCount = ParsePomManager.getIntPropertyFromPom("expectedProductsCount");
        String expectedCategoryName = ParsePomManager.getStringPropertyFromPom("expectedCategoryName");
        int expectedSubcategoriesCount = ParsePomManager.getIntPropertyFromPom("expectedSubcategoriesCount");
        int expectedFiltersCount = ParsePomManager.getIntPropertyFromPom("expectedFiltersCount");

        //GIVEN
        openingMainPageSteps.mainPageIsOpened();

        //WHEN
        usingCatalogSteps.userOpensWomenTabInCatalogPage();

        //THEN
        openingMainPageSteps.productsShouldBeDisplayed();
        usingCatalogSteps.productsCountShouldBeAsExpected(expectedProductsCount);
        usingCatalogSteps.tabNameShouldBeAsExpected(expectedCategoryName);
        usingCatalogSteps.subcategoriesNumberShouldBeAsExpected(expectedSubcategoriesCount);
        usingCatalogSteps.filtersShouldBeAvailable();
        usingCatalogSteps.filtersNumberShouldBeAsExpected(expectedFiltersCount);
    }

    @Test
    public void catalogPageIsFilteredAndSortedTest() {

        //GIVEN
        openingMainPageSteps.mainPageIsOpened();
        usingCatalogSteps.userOpensWomenTabInCatalogPage();

        //WHEN
        usingCatalogSteps.userSetsPriceSlider();
        usingCatalogSteps.userSortsProductsOnThePage();

        //THEN
        usingCatalogSteps.loadingSpinnerShouldBeDisplayed();
        usingCatalogSteps.loadingSpinnerImageShouldBeAsExpected();
        usingCatalogSteps.priceFilterShouldBeApplied();
        usingCatalogSteps.sortingOptionShouldBeApplied();
    }

}
