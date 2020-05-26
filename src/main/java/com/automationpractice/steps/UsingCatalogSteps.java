package com.automationpractice.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class UsingCatalogSteps extends AbstractSteps {

    @Step
    public void userOpensWomenTabInCatalogPageStep() {
        mainPage.openWomenTab();
    }

    @Step
    public void isProductsCountAsExpectedStep(int expectedProductsCount) {
        Assert.assertEquals("Catalog products count is not as expected", expectedProductsCount, catalogPage.getDisplayedProductsCount());
    }

    @Step
    public void userSetsPriceSliderStep() {
        catalogPage.setPriceFilterByMovingSlider();
    }

    @Step
    public void userSortsProductsOnThePageStep(String expectedSortingOption) {
        catalogPage.setSorting(expectedSortingOption);
    }

    @Step
    public void isLoadingSpinnerDisplayedStep() {
        Assert.assertTrue("Loading spinner is not displayed after applying filter and sorting", catalogPage.isLoadingSpinnerDisplayed());
    }

    @Step
    public void isLoadingSpinnerImageAsExpectedStep() {
        Assert.assertEquals("Loading spinner image source is not as expected", catalogPage.getLoadingSpinnerExpectedSrc(), catalogPage.getLoadingSpinnerSrc());
    }

    @Step
    public void isPriceFilterAppliedStep(String expectedPriceRange) {
        Assert.assertEquals("Price filter is not set as expected", expectedPriceRange, catalogPage.getPriceRange());
    }

    @Step
    public void isSortingOptionAppliedStep(String expectedSortingOption) {
        Assert.assertEquals("Sorting option is not set as expected", expectedSortingOption, catalogPage.getSorting());
    }

}
