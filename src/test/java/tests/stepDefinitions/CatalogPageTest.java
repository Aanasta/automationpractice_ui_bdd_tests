package tests.stepDefinitions;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.ParsePomManager;

@RunWith(SerenityRunner.class)
public class CatalogPageTest extends AbstractStepDefinitions {

    @Test
    public void catalogPageIsOpenedTest() {

        int expectedProductsCount = ParsePomManager.getIntPropertyFromPom("expectedProductsCount");
        String expectedCategoryName = ParsePomManager.getStringPropertyFromPom("expectedCategoryName");
        int expectedSubcategoriesCount = ParsePomManager.getIntPropertyFromPom("expectedSubcategoriesCount");
        int expectedFiltersCount = ParsePomManager.getIntPropertyFromPom("expectedFiltersCount");

        //GIVEN
        mainPage.mainPageIsOpened();

        //WHEN
        mainPage.userOpensWomenTabInCatalogPage();

        //THEN
        catalogPage.productsShouldBeDisplayed();
        catalogPage.productsCountShouldBeAsExpected(expectedProductsCount);
        catalogPage.tabNameShouldBeAsExpected(expectedCategoryName);
        catalogPage.subcategoriesNumberShouldBeAsExpected(expectedSubcategoriesCount);
        catalogPage.filtersShouldBeAvailable();
        catalogPage.filtersNumberShouldBeAsExpected(expectedFiltersCount);
    }

    @Test
    public void catalogPageIsFilteredAndSortedTest() {

        //GIVEN
        mainPage.mainPageIsOpened();
        mainPage.userOpensWomenTabInCatalogPage();

        //WHEN
        catalogPage.userSetsPriceSlider();
        catalogPage.userSortsProductsOnThePage();

        //THEN
        catalogPage.loadingSpinnerShouldBeDisplayed();
        catalogPage.loadingSpinnerImageShouldBeAsExpected();
        catalogPage.priceFilterShouldBeApplied();
        catalogPage.sortingOptionShouldBeApplied();
    }

}
