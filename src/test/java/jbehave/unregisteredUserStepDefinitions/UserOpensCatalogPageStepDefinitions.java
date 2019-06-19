package jbehave.unregisteredUserStepDefinitions;

import com.automationpractice.utils.ParsePomManager;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class UserOpensCatalogPageStepDefinitions extends AbstractStepDefinitions {

    @When("user goes to the catalog page")
    public void userOpensWomenTabInCatalogPage() {
        mainPage.openWomenTab();
    }

    @When("user sets price slider")
    public void userSetsPriceSlider() {
        catalogPage.setPriceFilterByMovingSlider();
    }

    @When("user sorts products")
    public void userSortsProductsOnThePage() {
        catalogPage.setSorting(ParsePomManager.getStringPropertyFromPom("expectedSortingOption"));
    }

    @Then("loading spinner should be displayed")
    public void loadingSpinnerShouldBeDisplayed() {
        Assert.assertTrue("Loading spinner is not displayed after applying filter and sorting", catalogPage.isLoadingSpinnerDisplayed());
    }

    @Then("loading spinner image should be as expected")
    public void loadingSpinnerImageShouldBeAsExpected() {
        Assert.assertEquals("Loading spinner image source is not as expected", catalogPage.getLoadingSpinnerExpectedSrc(), catalogPage.getLoadingSpinnerSrc());
    }

    @Then("price filter should be applied")
    public void priceFilterShouldBeApplied() {
        Assert.assertEquals("Price filter is not set as expected", ParsePomManager.getStringPropertyFromPom("expectedPriceRange"), catalogPage.getPriceRange());
    }

    @Then("sorting order should be applied")
    public void sortingOptionShouldBeApplied() {
        Assert.assertEquals("Sorting option is not set as expected", ParsePomManager.getStringPropertyFromPom("expectedSortingOption"), catalogPage.getSorting());
    }

    @Then("products quantity in the catalog should be <expectedProductsQuantity>")
    public void productsCountShouldBeAsExpected(@Named("expectedProductsQuantity") int expectedProductsCount) {
        Assert.assertEquals("Catalog products count is not as expected", expectedProductsCount, catalogPage.getDisplayedProductsCount());
    }

}
