//package com.automationpractice.steps;
//
//import com.automationpractice.utils.ParsePomManager;
//import net.thucydides.core.annotations.Step;
//import org.junit.Assert;
//
//public class UsingCatalogSteps extends AbstractSteps {
//
//    @Step
//    public void userOpensWomenTabInCatalogPage() {
//        mainPage.openWomenTab();
//    }
//
//    @Step
//    public void productsCountShouldBeAsExpected(int expectedProductsCount) {
//        Assert.assertEquals("Catalog products count is not as expected", expectedProductsCount, catalogPage.getDisplayedProductsCount());
//    }
//
//    @Step
//    public void tabNameShouldBeAsExpected(String expectedCategoryName) {
//        Assert.assertEquals("Catalog tab name is not as expected", expectedCategoryName, catalogPage.getCategoryNameText());
//    }
//
//    @Step
//    public void subcategoriesNumberShouldBeAsExpected(int expectedSubcategoriesCount) {
//        Assert.assertEquals("Number of subcategories is not expected", expectedSubcategoriesCount, catalogPage.getSubcategoriesCount());
//    }
//
//    @Step
//    public void filtersShouldBeAvailable() {
//        Assert.assertTrue("Filters are not displayed", catalogPage.isFiltersBlockDisplayed());
//    }
//
//    @Step
//    public void filtersNumberShouldBeAsExpected(int expectedFiltersCount) {
//        Assert.assertEquals("Number of filters is not as expected", expectedFiltersCount, catalogPage.getFiltersCount());
//    }
//
//    @Step
//    public void userSetsPriceSlider() {
//        catalogPage.setPriceFilterByMovingSlider();
//    }
//
//    @Step
//    public void userSortsProductsOnThePage() {
//        catalogPage.setSorting(ParsePomManager.getStringPropertyFromPom("expectedSortingOption"));
//    }
//
//    @Step
//    public void loadingSpinnerShouldBeDisplayed() {
//        Assert.assertTrue("Loading spinner is not displayed after applying filter and sorting", catalogPage.isLoadingSpinnerDisplayed());
//    }
//
//    @Step
//    public void loadingSpinnerImageShouldBeAsExpected() {
//        Assert.assertEquals("Loading spinner image source is not as expected", catalogPage.getLoadingSpinnerExpectedSrc(), catalogPage.getLoadingSpinnerSrc());
//    }
//
//    @Step
//    public void priceFilterShouldBeApplied() {
//        Assert.assertEquals("Price filter is not set as expected", ParsePomManager.getStringPropertyFromPom("expectedPriceRange"), catalogPage.getPriceRange());
//    }
//
//    @Step
//    public void sortingOptionShouldBeApplied() {
//        Assert.assertEquals("Sorting option is not set as expected", ParsePomManager.getStringPropertyFromPom("expectedSortingOption"), catalogPage.getSorting());
//    }
//
//}
