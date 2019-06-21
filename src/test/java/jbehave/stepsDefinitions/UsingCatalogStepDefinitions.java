package jbehave.stepsDefinitions;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class UsingCatalogStepDefinitions extends AbstractStepDefinitions {

    @When("user goes to the catalog page")
    public void userOpensWomenTabInCatalogPage() {
        mainPage.openWomenTab();
    }

    @When("user filters products by setting price slider")
    public void userSetsPriceSlider() {
        catalogPage.setPriceFilterByMovingSlider();
    }

    @When("user sorts products in <sortingOrder>")
    public void userSortsProductsOnThePage(@Named("sortingOrder") String sortingOrder) {
        catalogPage.setSorting(sortingOrder);
    }

    @Then("loading spinner should be displayed")
    public void loadingSpinnerShouldBeDisplayed() {
        Assert.assertTrue("Loading spinner is not displayed after applying filter and sorting", catalogPage.isLoadingSpinnerDisplayed());
    }

    @Then("loading spinner image should be as expected")
    public void loadingSpinnerImageShouldBeAsExpected() {
        Assert.assertEquals("Loading spinner image source is not as expected", catalogPage.getLoadingSpinnerExpectedSrc(), catalogPage.getLoadingSpinnerSrc());
    }

    @Then("price filter <priceRange> should be applied")
    public void priceFilterShouldBeApplied(@Named("priceRange") String priceRange) {
        Assert.assertEquals("Price filter is not set as expected", priceRange, catalogPage.getPriceRange());
    }

    @Then("<sortingOrder> should be applied")
    public void sortingOptionShouldBeApplied(@Named("sortingOrder") String sortingOrder) {
        Assert.assertEquals("Sorting option is not set as expected", sortingOrder, catalogPage.getSorting());
    }

    @Then("products quantity in the catalog should be <expectedProductsQuantity>")
    public void productsCountShouldBeAsExpected(@Named("expectedProductsQuantity") int expectedProductsCount) {
        Assert.assertEquals("Catalog products count is not as expected", expectedProductsCount, catalogPage.getDisplayedProductsCount());
    }

}
