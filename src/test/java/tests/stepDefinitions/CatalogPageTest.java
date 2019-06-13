package tests.stepDefinitions;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CatalogPageTest extends AbstractStepDefinitions {

    @Test
    public void catalogPageIsOpenedTest() {

        //GIVEN
        mainPage.mainPageIsOpened();

        //WHEN
        mainPage.userOpensWomenTabInCatalogPage();

        //THEN
        catalogPage.productsShouldBeDisplayed();
        catalogPage.productsCountShouldBeAsExpected();
        catalogPage.tabNameShouldBeWomen();
        catalogPage.subcategoriesNumberShouldBeAsExpected();
        catalogPage.filtersShouldBeAvailable();
        catalogPage.filtersNumberShouldBeAsExpected();
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
